/*
 * GAMA - V1.4 http://gama-platform.googlecode.com
 * 
 * (c) 2007-2011 UMI 209 UMMISCO IRD/UPMC & Partners (see below)
 * 
 * Developers :
 * 
 * - Alexis Drogoul, UMI 209 UMMISCO, IRD/UPMC (Kernel, Metamodel, GAML), 2007-2012
 * - Vo Duc An, UMI 209 UMMISCO, IRD/UPMC (SWT, multi-level architecture), 2008-2012
 * - Patrick Taillandier, UMR 6228 IDEES, CNRS/Univ. Rouen (Batch, GeoTools & JTS), 2009-2012
 * - Beno�t Gaudou, UMR 5505 IRIT, CNRS/Univ. Toulouse 1 (Documentation, Tests), 2010-2012
 * - Phan Huy Cuong, DREAM team, Univ. Can Tho (XText-based GAML), 2012
 * - Pierrick Koch, UMI 209 UMMISCO, IRD/UPMC (XText-based GAML), 2010-2011
 * - Romain Lavaud, UMI 209 UMMISCO, IRD/UPMC (RCP environment), 2010
 * - Francois Sempe, UMI 209 UMMISCO, IRD/UPMC (EMF model, Batch), 2007-2009
 * - Edouard Amouroux, UMI 209 UMMISCO, IRD/UPMC (C++ initial porting), 2007-2008
 * - Chu Thanh Quang, UMI 209 UMMISCO, IRD/UPMC (OpenMap integration), 2007-2008
 */
package msi.gama.lang.utils;

import static msi.gama.common.interfaces.IKeyword.*;
import java.util.Set;
import msi.gama.common.interfaces.*;
import msi.gama.common.util.*;
import msi.gama.lang.gaml.gaml.*;
import msi.gama.runtime.GAMA;
import msi.gaml.compilation.AbstractStatementDescription;
import msi.gaml.descriptions.*;
import msi.gaml.expressions.IExpressionFactory;
import msi.gaml.factories.DescriptionFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public class GamlToSyntacticElements {

	public static ISyntacticElement doConvert(final Model m, final IErrorCollector collect) {
		long time = System.currentTimeMillis();
		IExpressionFactory fact = GAMA.getExpressionFactory();
		if ( fact.getParser() == null ) {
			fact.registerParser(new NewGamlExpressionCompiler());
		}

		AbstractStatementDescription elt = convModel(m, collect);
		long now = System.currentTimeMillis();
		GuiUtils.debug("doConvert " + m.eResource().getURI() + " took: " + (now - time) + "ms");
		// elt.dump();
		return elt;
	}

	private static AbstractStatementDescription convModel(final Model m,
		final IErrorCollector collect) {
		final AbstractStatementDescription model =
			new ECoreBasedStatementDescription(MODEL, m, collect);
		model.setFacet(NAME, new LabelExpressionDescription(m.getName()));
		for ( final Import i : m.getImports() ) {
			final String uri = i.getImportURI();
			final AbstractStatementDescription include =
				new ECoreBasedStatementDescription(INCLUDE, i, collect);
			include.setFacet(FILE, new LabelExpressionDescription(uri));
			model.addChild(include);
		}
		convStatements(model, m.getStatements(), collect);
		return model;
	}

	private static void convStatements(final AbstractStatementDescription elt,
		final EList<Statement> ss, final IErrorCollector collect) {
		for ( final Statement stm : ss ) {
			elt.addChild(convStatement(elt.getKeyword(), stm, collect));
		}
	}

	static Set<String> builtin = EGaml.getAllowedFacetsFor(DO);

	private static AbstractStatementDescription convStatement(final String upper,
		final Statement stm, final IErrorCollector collect) {

		// If the initial statement is null, we return null
		if ( stm == null ) { return null; }
		// We catch its keyword
		String keyword = EGaml.getKeyOf(stm);
		if ( keyword == null ) { return null; }
		// We see if we can provide the temporary fix for the "collision of save(s)"
		if ( upper.equals(EXPERIMENT) && keyword.equals(SAVE) ) {
			keyword = SAVE_BATCH;
		}
		final AbstractStatementDescription elt =
			new ECoreBasedStatementDescription(keyword, stm, collect);

		// We modify the "const" declarations in order to only keep "var"
		if ( keyword.equals(CONST) ) {
			elt.setKeyword(VAR);
			elt.setFacet(CONST, conv(EGaml.createTerminal(true)));
		}

		// We now apply some conversions to the facets expressed in the statement
		for ( FacetExpr f : stm.getFacets() ) {
			String fname = EGaml.getKeyOf(f);
			// We change the "<-" and "->" symbols into full names
			if ( fname.equals("<-") ) {
				fname = keyword.equals(LET) || keyword.equals(SET) ? VALUE : INIT;
			} else if ( fname.equals("->") ) {
				fname = FUNCTION;
			}
			// We compute (and convert) the expression attached to the facet
			IExpressionDescription fexpr = conv(f.getExpr());
			// In case it is null and the facet is a definition expr (eg. "returns"), we get the
			// name feature of the statement instead.
			if ( fexpr == null && f instanceof DefinitionFacetExpr ) {
				fexpr = conv(EGaml.createTerminal(((DefinitionFacetExpr) f).getName()));
			}
			elt.setFacet(fname, fexpr);
		}
		// If the statement is "if", we convert its potential "else" part and put it inside the
		// syntactic element (as the legacy GAML expects it)
		if ( keyword.equals(IKeyword.IF) ) {
			convElse(stm, elt, collect);
		}

		// We add the dependencies (only for variable declarations)
		if ( !SymbolMetaDescription.nonVariableStatements.contains(keyword) ) {
			// GuiUtils.debug("Dependencies of : " + conv.getKeyword());
			Array a = EGaml.varDependenciesOf(stm);
			if ( a != null ) {
				elt.setFacet(DEPENDS_ON, conv(a));
			}
		}

		// We add the "default" (or omissible) facet to the syntactic element
		String def = DescriptionFactory.getModelFactory().getOmissibleFacetForSymbol(keyword);
		if ( def != null && elt.getFacet(def) == null ) { // TODO verify this
			Expression expr = EGaml.getValueOfOmittedFacet(stm);
			if ( expr != null ) {
				// GuiUtils.debug("Found facet " + def + " as omissible facet of " + keyword);
				elt.setFacet(def, conv(expr));
			}
		}

		// We convert the block of the statement, if any
		Block block = EGaml.getBlockOf(stm);
		if ( block != null ) {
			convStatements(elt, block.getStatements(), collect);
		}
		return elt;
	}

	private static void convElse(final Statement stm, final ISyntacticElement elt,
		final IErrorCollector collect) {
		EObject elseBlock = stm.getElse();
		if ( elseBlock != null ) {
			AbstractStatementDescription elseElt =
				new ECoreBasedStatementDescription(ELSE, elseBlock, collect);
			if ( elseBlock instanceof Statement ) {
				elseElt.addChild(convStatement(IF, (Statement) elseBlock, collect));
			} else {
				convStatements(elseElt, ((Block) elseBlock).getStatements(), collect);
			}
			elt.addChild(elseElt);
		}
	}

	private static IExpressionDescription conv(final Expression expr) {
		return expr == null ? null : new EcoreBasedExpressionDescription(expr);
	}

}
