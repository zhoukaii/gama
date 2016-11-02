/*********************************************************************************************
 *
 * 'GamlGrammarAccess.java, in plugin msi.gama.lang.gaml, is part of the source code of the
 * GAMA modeling and simulation platform.
 * (c) 2007-2016 UMI 209 UMMISCO IRD/UPMC & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and developers contact.
 * 
 *
 **********************************************************************************************/
package msi.gama.lang.gaml.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;


@Singleton
public class GamlGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class EntryElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.Entry");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cModelParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cStringEvaluatorParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cStandaloneBlockParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//Entry:
		//	Model | StringEvaluator | StandaloneBlock;
		@Override public ParserRule getRule() { return rule; }

		//Model | StringEvaluator | StandaloneBlock
		public Alternatives getAlternatives() { return cAlternatives; }

		//Model
		public RuleCall getModelParserRuleCall_0() { return cModelParserRuleCall_0; }

		//StringEvaluator
		public RuleCall getStringEvaluatorParserRuleCall_1() { return cStringEvaluatorParserRuleCall_1; }

		//StandaloneBlock
		public RuleCall getStandaloneBlockParserRuleCall_2() { return cStandaloneBlockParserRuleCall_2; }
	}

	public class StandaloneBlockElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.StandaloneBlock");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c__synthetic__Keyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cBlockAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cBlockBlockParserRuleCall_1_0 = (RuleCall)cBlockAssignment_1.eContents().get(0);
		
		//StandaloneBlock:
		//	'__synthetic__' block=Block;
		@Override public ParserRule getRule() { return rule; }

		//'__synthetic__' block=Block
		public Group getGroup() { return cGroup; }

		//'__synthetic__'
		public Keyword get__synthetic__Keyword_0() { return c__synthetic__Keyword_0; }

		//block=Block
		public Assignment getBlockAssignment_1() { return cBlockAssignment_1; }

		//Block
		public RuleCall getBlockBlockParserRuleCall_1_0() { return cBlockBlockParserRuleCall_1_0; }
	}

	public class StringEvaluatorElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.StringEvaluator");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cTotoAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cTotoIDTerminalRuleCall_0_0 = (RuleCall)cTotoAssignment_0.eContents().get(0);
		private final Keyword cLessThanSignHyphenMinusKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cExprAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cExprExpressionParserRuleCall_2_0 = (RuleCall)cExprAssignment_2.eContents().get(0);
		
		//StringEvaluator:
		//	toto=ID "<-" expr=Expression;
		@Override public ParserRule getRule() { return rule; }

		//toto=ID "<-" expr=Expression
		public Group getGroup() { return cGroup; }

		//toto=ID
		public Assignment getTotoAssignment_0() { return cTotoAssignment_0; }

		//ID
		public RuleCall getTotoIDTerminalRuleCall_0_0() { return cTotoIDTerminalRuleCall_0_0; }

		//"<-"
		public Keyword getLessThanSignHyphenMinusKeyword_1() { return cLessThanSignHyphenMinusKeyword_1; }

		//expr=Expression
		public Assignment getExprAssignment_2() { return cExprAssignment_2; }

		//Expression
		public RuleCall getExprExpressionParserRuleCall_2_0() { return cExprExpressionParserRuleCall_2_0; }
	}

	public class ModelElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.Model");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cPragmasAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cPragmasPragmaParserRuleCall_0_0 = (RuleCall)cPragmasAssignment_0.eContents().get(0);
		private final Keyword cModelKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Assignment cImportsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cImportsImportParserRuleCall_3_0 = (RuleCall)cImportsAssignment_3.eContents().get(0);
		private final Assignment cBlockAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cBlockModelBlockParserRuleCall_4_0 = (RuleCall)cBlockAssignment_4.eContents().get(0);
		
		//Model:
		//	pragmas+=Pragma* 'model' name=ID imports+=Import* block=ModelBlock;
		@Override public ParserRule getRule() { return rule; }

		//pragmas+=Pragma* 'model' name=ID imports+=Import* block=ModelBlock
		public Group getGroup() { return cGroup; }

		//pragmas+=Pragma*
		public Assignment getPragmasAssignment_0() { return cPragmasAssignment_0; }

		//Pragma
		public RuleCall getPragmasPragmaParserRuleCall_0_0() { return cPragmasPragmaParserRuleCall_0_0; }

		//'model'
		public Keyword getModelKeyword_1() { return cModelKeyword_1; }

		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }

		//imports+=Import*
		public Assignment getImportsAssignment_3() { return cImportsAssignment_3; }

		//Import
		public RuleCall getImportsImportParserRuleCall_3_0() { return cImportsImportParserRuleCall_3_0; }

		//block=ModelBlock
		public Assignment getBlockAssignment_4() { return cBlockAssignment_4; }

		//ModelBlock
		public RuleCall getBlockModelBlockParserRuleCall_4_0() { return cBlockModelBlockParserRuleCall_4_0; }
	}

	public class ModelBlockElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.ModelBlock");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cBlockAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cStatementsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cStatementsS_SectionParserRuleCall_1_0 = (RuleCall)cStatementsAssignment_1.eContents().get(0);
		
		//ModelBlock Block:
		//	{Block} statements+=S_Section*
		@Override public ParserRule getRule() { return rule; }

		//{Block} statements+=S_Section*
		public Group getGroup() { return cGroup; }

		//{Block}
		public Action getBlockAction_0() { return cBlockAction_0; }

		//statements+=S_Section*
		public Assignment getStatementsAssignment_1() { return cStatementsAssignment_1; }

		//S_Section
		public RuleCall getStatementsS_SectionParserRuleCall_1_0() { return cStatementsS_SectionParserRuleCall_1_0; }
	}

	public class ImportElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.Import");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cImportKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cImportURIAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cImportURISTRINGTerminalRuleCall_1_0 = (RuleCall)cImportURIAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cAsKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cNameAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cNameValid_IDParserRuleCall_2_1_0 = (RuleCall)cNameAssignment_2_1.eContents().get(0);
		
		//Import:
		//	'import' importURI=STRING ("as" name=Valid_ID)?;
		@Override public ParserRule getRule() { return rule; }

		//'import' importURI=STRING ("as" name=Valid_ID)?
		public Group getGroup() { return cGroup; }

		//'import'
		public Keyword getImportKeyword_0() { return cImportKeyword_0; }

		//importURI=STRING
		public Assignment getImportURIAssignment_1() { return cImportURIAssignment_1; }

		//STRING
		public RuleCall getImportURISTRINGTerminalRuleCall_1_0() { return cImportURISTRINGTerminalRuleCall_1_0; }

		//("as" name=Valid_ID)?
		public Group getGroup_2() { return cGroup_2; }

		//"as"
		public Keyword getAsKeyword_2_0() { return cAsKeyword_2_0; }

		//name=Valid_ID
		public Assignment getNameAssignment_2_1() { return cNameAssignment_2_1; }

		//Valid_ID
		public RuleCall getNameValid_IDParserRuleCall_2_1_0() { return cNameValid_IDParserRuleCall_2_1_0; }
	}

	public class PragmaElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.Pragma");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cCommercialAtKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		
		//// must be named importURI
		//Pragma:
		//	'@' name=ID;
		@Override public ParserRule getRule() { return rule; }

		//'@' name=ID
		public Group getGroup() { return cGroup; }

		//'@'
		public Keyword getCommercialAtKeyword_0() { return cCommercialAtKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
	}

	public class S_SectionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.S_Section");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cS_GlobalParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cS_SpeciesParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cS_ExperimentParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		/// **
		// * Global statements
		// * / S_Section Statement:
		//	S_Global | S_Species | S_Experiment
		@Override public ParserRule getRule() { return rule; }

		//S_Global | S_Species | S_Experiment
		public Alternatives getAlternatives() { return cAlternatives; }

		//S_Global
		public RuleCall getS_GlobalParserRuleCall_0() { return cS_GlobalParserRuleCall_0; }

		//S_Species
		public RuleCall getS_SpeciesParserRuleCall_1() { return cS_SpeciesParserRuleCall_1; }

		//S_Experiment
		public RuleCall getS_ExperimentParserRuleCall_2() { return cS_ExperimentParserRuleCall_2; }
	}

	public class S_GlobalElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.S_Global");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cKeyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cKeyGlobalKeyword_0_0 = (Keyword)cKeyAssignment_0.eContents().get(0);
		private final Assignment cFacetsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cFacetsFacetParserRuleCall_1_0 = (RuleCall)cFacetsAssignment_1.eContents().get(0);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Assignment cBlockAssignment_2_0 = (Assignment)cAlternatives_2.eContents().get(0);
		private final RuleCall cBlockBlockParserRuleCall_2_0_0 = (RuleCall)cBlockAssignment_2_0.eContents().get(0);
		private final Keyword cSemicolonKeyword_2_1 = (Keyword)cAlternatives_2.eContents().get(1);
		
		//S_Global:
		//	key="global" facets+=Facet* (block=Block | ';');
		@Override public ParserRule getRule() { return rule; }

		//key="global" facets+=Facet* (block=Block | ';')
		public Group getGroup() { return cGroup; }

		//key="global"
		public Assignment getKeyAssignment_0() { return cKeyAssignment_0; }

		//"global"
		public Keyword getKeyGlobalKeyword_0_0() { return cKeyGlobalKeyword_0_0; }

		//facets+=Facet*
		public Assignment getFacetsAssignment_1() { return cFacetsAssignment_1; }

		//Facet
		public RuleCall getFacetsFacetParserRuleCall_1_0() { return cFacetsFacetParserRuleCall_1_0; }

		//(block=Block | ';')
		public Alternatives getAlternatives_2() { return cAlternatives_2; }

		//block=Block
		public Assignment getBlockAssignment_2_0() { return cBlockAssignment_2_0; }

		//Block
		public RuleCall getBlockBlockParserRuleCall_2_0_0() { return cBlockBlockParserRuleCall_2_0_0; }

		//';'
		public Keyword getSemicolonKeyword_2_1() { return cSemicolonKeyword_2_1; }
	}

	public class S_SpeciesElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.S_Species");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cKeyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cKey_SpeciesKeyParserRuleCall_0_0 = (RuleCall)cKeyAssignment_0.eContents().get(0);
		private final Assignment cFirstFacetAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cFirstFacetNameKeyword_1_0 = (Keyword)cFirstFacetAssignment_1.eContents().get(0);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Assignment cFacetsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cFacetsFacetParserRuleCall_3_0 = (RuleCall)cFacetsAssignment_3.eContents().get(0);
		private final Alternatives cAlternatives_4 = (Alternatives)cGroup.eContents().get(4);
		private final Assignment cBlockAssignment_4_0 = (Assignment)cAlternatives_4.eContents().get(0);
		private final RuleCall cBlockBlockParserRuleCall_4_0_0 = (RuleCall)cBlockAssignment_4_0.eContents().get(0);
		private final Keyword cSemicolonKeyword_4_1 = (Keyword)cAlternatives_4.eContents().get(1);
		
		//S_Species:
		//	key=_SpeciesKey firstFacet='name:'? name=ID facets+=Facet* (block=Block | ';');
		@Override public ParserRule getRule() { return rule; }

		//key=_SpeciesKey firstFacet='name:'? name=ID facets+=Facet* (block=Block | ';')
		public Group getGroup() { return cGroup; }

		//key=_SpeciesKey
		public Assignment getKeyAssignment_0() { return cKeyAssignment_0; }

		//_SpeciesKey
		public RuleCall getKey_SpeciesKeyParserRuleCall_0_0() { return cKey_SpeciesKeyParserRuleCall_0_0; }

		//firstFacet='name:'?
		public Assignment getFirstFacetAssignment_1() { return cFirstFacetAssignment_1; }

		//'name:'
		public Keyword getFirstFacetNameKeyword_1_0() { return cFirstFacetNameKeyword_1_0; }

		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }

		//facets+=Facet*
		public Assignment getFacetsAssignment_3() { return cFacetsAssignment_3; }

		//Facet
		public RuleCall getFacetsFacetParserRuleCall_3_0() { return cFacetsFacetParserRuleCall_3_0; }

		//(block=Block | ';')
		public Alternatives getAlternatives_4() { return cAlternatives_4; }

		//block=Block
		public Assignment getBlockAssignment_4_0() { return cBlockAssignment_4_0; }

		//Block
		public RuleCall getBlockBlockParserRuleCall_4_0_0() { return cBlockBlockParserRuleCall_4_0_0; }

		//';'
		public Keyword getSemicolonKeyword_4_1() { return cSemicolonKeyword_4_1; }
	}

	public class S_ExperimentElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.S_Experiment");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cKeyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cKey_ExperimentKeyParserRuleCall_0_0 = (RuleCall)cKeyAssignment_0.eContents().get(0);
		private final Assignment cFirstFacetAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cFirstFacetNameKeyword_1_0 = (Keyword)cFirstFacetAssignment_1.eContents().get(0);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final Alternatives cNameAlternatives_2_0 = (Alternatives)cNameAssignment_2.eContents().get(0);
		private final RuleCall cNameValid_IDParserRuleCall_2_0_0 = (RuleCall)cNameAlternatives_2_0.eContents().get(0);
		private final RuleCall cNameSTRINGTerminalRuleCall_2_0_1 = (RuleCall)cNameAlternatives_2_0.eContents().get(1);
		private final Assignment cFacetsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cFacetsFacetParserRuleCall_3_0 = (RuleCall)cFacetsAssignment_3.eContents().get(0);
		private final Alternatives cAlternatives_4 = (Alternatives)cGroup.eContents().get(4);
		private final Assignment cBlockAssignment_4_0 = (Assignment)cAlternatives_4.eContents().get(0);
		private final RuleCall cBlockBlockParserRuleCall_4_0_0 = (RuleCall)cBlockAssignment_4_0.eContents().get(0);
		private final Keyword cSemicolonKeyword_4_1 = (Keyword)cAlternatives_4.eContents().get(1);
		
		//S_Experiment:
		//	key=_ExperimentKey firstFacet="name:"? name=(Valid_ID | STRING) facets+=Facet* (block=Block | ';');
		@Override public ParserRule getRule() { return rule; }

		//key=_ExperimentKey firstFacet="name:"? name=(Valid_ID | STRING) facets+=Facet* (block=Block | ';')
		public Group getGroup() { return cGroup; }

		//key=_ExperimentKey
		public Assignment getKeyAssignment_0() { return cKeyAssignment_0; }

		//_ExperimentKey
		public RuleCall getKey_ExperimentKeyParserRuleCall_0_0() { return cKey_ExperimentKeyParserRuleCall_0_0; }

		//firstFacet="name:"?
		public Assignment getFirstFacetAssignment_1() { return cFirstFacetAssignment_1; }

		//"name:"
		public Keyword getFirstFacetNameKeyword_1_0() { return cFirstFacetNameKeyword_1_0; }

		//name=(Valid_ID | STRING)
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//(Valid_ID | STRING)
		public Alternatives getNameAlternatives_2_0() { return cNameAlternatives_2_0; }

		//Valid_ID
		public RuleCall getNameValid_IDParserRuleCall_2_0_0() { return cNameValid_IDParserRuleCall_2_0_0; }

		//STRING
		public RuleCall getNameSTRINGTerminalRuleCall_2_0_1() { return cNameSTRINGTerminalRuleCall_2_0_1; }

		//facets+=Facet*
		public Assignment getFacetsAssignment_3() { return cFacetsAssignment_3; }

		//Facet
		public RuleCall getFacetsFacetParserRuleCall_3_0() { return cFacetsFacetParserRuleCall_3_0; }

		//(block=Block | ';')
		public Alternatives getAlternatives_4() { return cAlternatives_4; }

		//block=Block
		public Assignment getBlockAssignment_4_0() { return cBlockAssignment_4_0; }

		//Block
		public RuleCall getBlockBlockParserRuleCall_4_0_0() { return cBlockBlockParserRuleCall_4_0_0; }

		//';'
		public Keyword getSemicolonKeyword_4_1() { return cSemicolonKeyword_4_1; }
	}

	public class StatementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.Statement");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cAlternatives.eContents().get(0);
		private final RuleCall cS_DeclarationParserRuleCall_0_0 = (RuleCall)cAlternatives_0.eContents().get(0);
		private final Alternatives cAlternatives_0_1 = (Alternatives)cAlternatives_0.eContents().get(1);
		private final RuleCall cS_AssignmentParserRuleCall_0_1_0 = (RuleCall)cAlternatives_0_1.eContents().get(0);
		private final RuleCall cS_1Expr_Facets_BlockOrEndParserRuleCall_0_1_1 = (RuleCall)cAlternatives_0_1.eContents().get(1);
		private final RuleCall cS_OtherParserRuleCall_0_1_2 = (RuleCall)cAlternatives_0_1.eContents().get(2);
		private final RuleCall cS_DoParserRuleCall_0_1_3 = (RuleCall)cAlternatives_0_1.eContents().get(3);
		private final RuleCall cS_ReturnParserRuleCall_0_1_4 = (RuleCall)cAlternatives_0_1.eContents().get(4);
		private final RuleCall cS_SolveParserRuleCall_0_1_5 = (RuleCall)cAlternatives_0_1.eContents().get(5);
		private final RuleCall cS_IfParserRuleCall_0_1_6 = (RuleCall)cAlternatives_0_1.eContents().get(6);
		private final RuleCall cS_EquationsParserRuleCall_0_1_7 = (RuleCall)cAlternatives_0_1.eContents().get(7);
		private final RuleCall cS_DisplayParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		/// **
		// * Statements
		// * / Statement:
		//	(=> S_Declaration | (=> S_Assignment | S_1Expr_Facets_BlockOrEnd | S_Other | S_Do | S_Return | S_Solve | S_If |
		//	S_Equations)) | S_Display;
		@Override public ParserRule getRule() { return rule; }

		//(=> S_Declaration | (=> S_Assignment | S_1Expr_Facets_BlockOrEnd | S_Other | S_Do | S_Return | S_Solve | S_If |
		//S_Equations)) | S_Display
		public Alternatives getAlternatives() { return cAlternatives; }

		//(=> S_Declaration | (=> S_Assignment | S_1Expr_Facets_BlockOrEnd | S_Other | S_Do | S_Return | S_Solve | S_If |
		//S_Equations))
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//=> S_Declaration
		public RuleCall getS_DeclarationParserRuleCall_0_0() { return cS_DeclarationParserRuleCall_0_0; }

		//(=> S_Assignment | S_1Expr_Facets_BlockOrEnd | S_Other | S_Do | S_Return | S_Solve | S_If | S_Equations)
		public Alternatives getAlternatives_0_1() { return cAlternatives_0_1; }

		//=> S_Assignment
		public RuleCall getS_AssignmentParserRuleCall_0_1_0() { return cS_AssignmentParserRuleCall_0_1_0; }

		//S_1Expr_Facets_BlockOrEnd
		public RuleCall getS_1Expr_Facets_BlockOrEndParserRuleCall_0_1_1() { return cS_1Expr_Facets_BlockOrEndParserRuleCall_0_1_1; }

		//S_Other
		public RuleCall getS_OtherParserRuleCall_0_1_2() { return cS_OtherParserRuleCall_0_1_2; }

		//S_Do
		public RuleCall getS_DoParserRuleCall_0_1_3() { return cS_DoParserRuleCall_0_1_3; }

		//S_Return
		public RuleCall getS_ReturnParserRuleCall_0_1_4() { return cS_ReturnParserRuleCall_0_1_4; }

		//S_Solve
		public RuleCall getS_SolveParserRuleCall_0_1_5() { return cS_SolveParserRuleCall_0_1_5; }

		//S_If
		public RuleCall getS_IfParserRuleCall_0_1_6() { return cS_IfParserRuleCall_0_1_6; }

		//S_Equations
		public RuleCall getS_EquationsParserRuleCall_0_1_7() { return cS_EquationsParserRuleCall_0_1_7; }

		//S_Display
		public RuleCall getS_DisplayParserRuleCall_1() { return cS_DisplayParserRuleCall_1; }
	}

	public class S_1Expr_Facets_BlockOrEndElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.S_1Expr_Facets_BlockOrEnd");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cKeyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cKey_1Expr_Facets_BlockOrEnd_KeyParserRuleCall_0_0 = (RuleCall)cKeyAssignment_0.eContents().get(0);
		private final Assignment cFirstFacetAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cFirstFacetFirstFacetKeyParserRuleCall_1_0 = (RuleCall)cFirstFacetAssignment_1.eContents().get(0);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Assignment cExprAssignment_2_0 = (Assignment)cAlternatives_2.eContents().get(0);
		private final RuleCall cExprExpressionParserRuleCall_2_0_0 = (RuleCall)cExprAssignment_2_0.eContents().get(0);
		private final Assignment cExprAssignment_2_1 = (Assignment)cAlternatives_2.eContents().get(1);
		private final RuleCall cExprTypeRefParserRuleCall_2_1_0 = (RuleCall)cExprAssignment_2_1.eContents().get(0);
		private final Assignment cFacetsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cFacetsFacetParserRuleCall_3_0 = (RuleCall)cFacetsAssignment_3.eContents().get(0);
		private final Alternatives cAlternatives_4 = (Alternatives)cGroup.eContents().get(4);
		private final Assignment cBlockAssignment_4_0 = (Assignment)cAlternatives_4.eContents().get(0);
		private final RuleCall cBlockBlockParserRuleCall_4_0_0 = (RuleCall)cBlockAssignment_4_0.eContents().get(0);
		private final Keyword cSemicolonKeyword_4_1 = (Keyword)cAlternatives_4.eContents().get(1);
		
		//S_1Expr_Facets_BlockOrEnd Statement:
		//	key=_1Expr_Facets_BlockOrEnd_Key firstFacet=FirstFacetKey? (=> expr=Expression | expr=TypeRef) facets+=Facet*
		//	(block=Block | ";")
		@Override public ParserRule getRule() { return rule; }

		//key=_1Expr_Facets_BlockOrEnd_Key firstFacet=FirstFacetKey? (=> expr=Expression | expr=TypeRef) facets+=Facet*
		//(block=Block | ";")
		public Group getGroup() { return cGroup; }

		//key=_1Expr_Facets_BlockOrEnd_Key
		public Assignment getKeyAssignment_0() { return cKeyAssignment_0; }

		//_1Expr_Facets_BlockOrEnd_Key
		public RuleCall getKey_1Expr_Facets_BlockOrEnd_KeyParserRuleCall_0_0() { return cKey_1Expr_Facets_BlockOrEnd_KeyParserRuleCall_0_0; }

		//firstFacet=FirstFacetKey?
		public Assignment getFirstFacetAssignment_1() { return cFirstFacetAssignment_1; }

		//FirstFacetKey
		public RuleCall getFirstFacetFirstFacetKeyParserRuleCall_1_0() { return cFirstFacetFirstFacetKeyParserRuleCall_1_0; }

		//(=> expr=Expression | expr=TypeRef)
		public Alternatives getAlternatives_2() { return cAlternatives_2; }

		//=> expr=Expression
		public Assignment getExprAssignment_2_0() { return cExprAssignment_2_0; }

		//Expression
		public RuleCall getExprExpressionParserRuleCall_2_0_0() { return cExprExpressionParserRuleCall_2_0_0; }

		//expr=TypeRef
		public Assignment getExprAssignment_2_1() { return cExprAssignment_2_1; }

		//TypeRef
		public RuleCall getExprTypeRefParserRuleCall_2_1_0() { return cExprTypeRefParserRuleCall_2_1_0; }

		//facets+=Facet*
		public Assignment getFacetsAssignment_3() { return cFacetsAssignment_3; }

		//Facet
		public RuleCall getFacetsFacetParserRuleCall_3_0() { return cFacetsFacetParserRuleCall_3_0; }

		//(block=Block | ";")
		public Alternatives getAlternatives_4() { return cAlternatives_4; }

		//block=Block
		public Assignment getBlockAssignment_4_0() { return cBlockAssignment_4_0; }

		//Block
		public RuleCall getBlockBlockParserRuleCall_4_0_0() { return cBlockBlockParserRuleCall_4_0_0; }

		//";"
		public Keyword getSemicolonKeyword_4_1() { return cSemicolonKeyword_4_1; }
	}

	public class S_DoElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.S_Do");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cKeyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cKey_DoKeyParserRuleCall_0_0 = (RuleCall)cKeyAssignment_0.eContents().get(0);
		private final Assignment cFirstFacetAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cFirstFacetActionKeyword_1_0 = (Keyword)cFirstFacetAssignment_1.eContents().get(0);
		private final Assignment cExprAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cExprAbstractRefParserRuleCall_2_0 = (RuleCall)cExprAssignment_2.eContents().get(0);
		private final Assignment cFacetsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cFacetsFacetParserRuleCall_3_0 = (RuleCall)cFacetsAssignment_3.eContents().get(0);
		private final Alternatives cAlternatives_4 = (Alternatives)cGroup.eContents().get(4);
		private final Assignment cBlockAssignment_4_0 = (Assignment)cAlternatives_4.eContents().get(0);
		private final RuleCall cBlockBlockParserRuleCall_4_0_0 = (RuleCall)cBlockAssignment_4_0.eContents().get(0);
		private final Keyword cSemicolonKeyword_4_1 = (Keyword)cAlternatives_4.eContents().get(1);
		
		//S_Do:
		//	key=_DoKey firstFacet="action:"? expr=AbstractRef facets+=Facet* (block=Block | ';');
		@Override public ParserRule getRule() { return rule; }

		//key=_DoKey firstFacet="action:"? expr=AbstractRef facets+=Facet* (block=Block | ';')
		public Group getGroup() { return cGroup; }

		//key=_DoKey
		public Assignment getKeyAssignment_0() { return cKeyAssignment_0; }

		//_DoKey
		public RuleCall getKey_DoKeyParserRuleCall_0_0() { return cKey_DoKeyParserRuleCall_0_0; }

		//firstFacet="action:"?
		public Assignment getFirstFacetAssignment_1() { return cFirstFacetAssignment_1; }

		//"action:"
		public Keyword getFirstFacetActionKeyword_1_0() { return cFirstFacetActionKeyword_1_0; }

		//expr=AbstractRef
		public Assignment getExprAssignment_2() { return cExprAssignment_2; }

		//AbstractRef
		public RuleCall getExprAbstractRefParserRuleCall_2_0() { return cExprAbstractRefParserRuleCall_2_0; }

		//facets+=Facet*
		public Assignment getFacetsAssignment_3() { return cFacetsAssignment_3; }

		//Facet
		public RuleCall getFacetsFacetParserRuleCall_3_0() { return cFacetsFacetParserRuleCall_3_0; }

		//(block=Block | ';')
		public Alternatives getAlternatives_4() { return cAlternatives_4; }

		//block=Block
		public Assignment getBlockAssignment_4_0() { return cBlockAssignment_4_0; }

		//Block
		public RuleCall getBlockBlockParserRuleCall_4_0_0() { return cBlockBlockParserRuleCall_4_0_0; }

		//';'
		public Keyword getSemicolonKeyword_4_1() { return cSemicolonKeyword_4_1; }
	}

	public class S_LoopElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.S_Loop");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cKeyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cKeyLoopKeyword_0_0 = (Keyword)cKeyAssignment_0.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Assignment cFacetsAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cFacetsFacetParserRuleCall_2_0 = (RuleCall)cFacetsAssignment_2.eContents().get(0);
		private final Assignment cBlockAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cBlockBlockParserRuleCall_3_0 = (RuleCall)cBlockAssignment_3.eContents().get(0);
		
		//S_Loop:
		//	key="loop" name=ID? facets+=Facet* block=Block;
		@Override public ParserRule getRule() { return rule; }

		//key="loop" name=ID? facets+=Facet* block=Block
		public Group getGroup() { return cGroup; }

		//key="loop"
		public Assignment getKeyAssignment_0() { return cKeyAssignment_0; }

		//"loop"
		public Keyword getKeyLoopKeyword_0_0() { return cKeyLoopKeyword_0_0; }

		//name=ID?
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//facets+=Facet*
		public Assignment getFacetsAssignment_2() { return cFacetsAssignment_2; }

		//Facet
		public RuleCall getFacetsFacetParserRuleCall_2_0() { return cFacetsFacetParserRuleCall_2_0; }

		//block=Block
		public Assignment getBlockAssignment_3() { return cBlockAssignment_3; }

		//Block
		public RuleCall getBlockBlockParserRuleCall_3_0() { return cBlockBlockParserRuleCall_3_0; }
	}

	public class S_IfElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.S_If");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cKeyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cKeyIfKeyword_0_0 = (Keyword)cKeyAssignment_0.eContents().get(0);
		private final Assignment cFirstFacetAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cFirstFacetConditionKeyword_1_0 = (Keyword)cFirstFacetAssignment_1.eContents().get(0);
		private final Assignment cExprAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cExprExpressionParserRuleCall_2_0 = (RuleCall)cExprAssignment_2.eContents().get(0);
		private final Assignment cBlockAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cBlockBlockParserRuleCall_3_0 = (RuleCall)cBlockAssignment_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cElseKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cElseAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final Alternatives cElseAlternatives_4_1_0 = (Alternatives)cElseAssignment_4_1.eContents().get(0);
		private final RuleCall cElseS_IfParserRuleCall_4_1_0_0 = (RuleCall)cElseAlternatives_4_1_0.eContents().get(0);
		private final RuleCall cElseBlockParserRuleCall_4_1_0_1 = (RuleCall)cElseAlternatives_4_1_0.eContents().get(1);
		
		//S_If:
		//	key='if' firstFacet="condition:"? expr=Expression block=Block (=> 'else' else=(S_If | Block))?;
		@Override public ParserRule getRule() { return rule; }

		//key='if' firstFacet="condition:"? expr=Expression block=Block (=> 'else' else=(S_If | Block))?
		public Group getGroup() { return cGroup; }

		//key='if'
		public Assignment getKeyAssignment_0() { return cKeyAssignment_0; }

		//'if'
		public Keyword getKeyIfKeyword_0_0() { return cKeyIfKeyword_0_0; }

		//firstFacet="condition:"?
		public Assignment getFirstFacetAssignment_1() { return cFirstFacetAssignment_1; }

		//"condition:"
		public Keyword getFirstFacetConditionKeyword_1_0() { return cFirstFacetConditionKeyword_1_0; }

		//expr=Expression
		public Assignment getExprAssignment_2() { return cExprAssignment_2; }

		//Expression
		public RuleCall getExprExpressionParserRuleCall_2_0() { return cExprExpressionParserRuleCall_2_0; }

		//block=Block
		public Assignment getBlockAssignment_3() { return cBlockAssignment_3; }

		//Block
		public RuleCall getBlockBlockParserRuleCall_3_0() { return cBlockBlockParserRuleCall_3_0; }

		//(=> 'else' else=(S_If | Block))?
		public Group getGroup_4() { return cGroup_4; }

		//=> 'else'
		public Keyword getElseKeyword_4_0() { return cElseKeyword_4_0; }

		//else=(S_If | Block)
		public Assignment getElseAssignment_4_1() { return cElseAssignment_4_1; }

		//(S_If | Block)
		public Alternatives getElseAlternatives_4_1_0() { return cElseAlternatives_4_1_0; }

		//S_If
		public RuleCall getElseS_IfParserRuleCall_4_1_0_0() { return cElseS_IfParserRuleCall_4_1_0_0; }

		//Block
		public RuleCall getElseBlockParserRuleCall_4_1_0_1() { return cElseBlockParserRuleCall_4_1_0_1; }
	}

	public class S_OtherElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.S_Other");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cKeyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cKeyIDTerminalRuleCall_0_0 = (RuleCall)cKeyAssignment_0.eContents().get(0);
		private final Assignment cFacetsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cFacetsFacetParserRuleCall_1_0 = (RuleCall)cFacetsAssignment_1.eContents().get(0);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Assignment cBlockAssignment_2_0 = (Assignment)cAlternatives_2.eContents().get(0);
		private final RuleCall cBlockBlockParserRuleCall_2_0_0 = (RuleCall)cBlockAssignment_2_0.eContents().get(0);
		private final Keyword cSemicolonKeyword_2_1 = (Keyword)cAlternatives_2.eContents().get(1);
		
		//S_Other:
		//	key=ID facets+=Facet* (block=Block | ';');
		@Override public ParserRule getRule() { return rule; }

		//key=ID facets+=Facet* (block=Block | ';')
		public Group getGroup() { return cGroup; }

		//key=ID
		public Assignment getKeyAssignment_0() { return cKeyAssignment_0; }

		//ID
		public RuleCall getKeyIDTerminalRuleCall_0_0() { return cKeyIDTerminalRuleCall_0_0; }

		//facets+=Facet*
		public Assignment getFacetsAssignment_1() { return cFacetsAssignment_1; }

		//Facet
		public RuleCall getFacetsFacetParserRuleCall_1_0() { return cFacetsFacetParserRuleCall_1_0; }

		//(block=Block | ';')
		public Alternatives getAlternatives_2() { return cAlternatives_2; }

		//block=Block
		public Assignment getBlockAssignment_2_0() { return cBlockAssignment_2_0; }

		//Block
		public RuleCall getBlockBlockParserRuleCall_2_0_0() { return cBlockBlockParserRuleCall_2_0_0; }

		//';'
		public Keyword getSemicolonKeyword_2_1() { return cSemicolonKeyword_2_1; }
	}

	public class S_ReturnElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.S_Return");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cKeyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cKeyReturnKeyword_0_0 = (Keyword)cKeyAssignment_0.eContents().get(0);
		private final Assignment cFirstFacetAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cFirstFacetValueKeyword_1_0 = (Keyword)cFirstFacetAssignment_1.eContents().get(0);
		private final Assignment cExprAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cExprExpressionParserRuleCall_2_0 = (RuleCall)cExprAssignment_2.eContents().get(0);
		private final Keyword cSemicolonKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//S_Return:
		//	key='return' firstFacet="value:"? expr=Expression? ';';
		@Override public ParserRule getRule() { return rule; }

		//key='return' firstFacet="value:"? expr=Expression? ';'
		public Group getGroup() { return cGroup; }

		//key='return'
		public Assignment getKeyAssignment_0() { return cKeyAssignment_0; }

		//'return'
		public Keyword getKeyReturnKeyword_0_0() { return cKeyReturnKeyword_0_0; }

		//firstFacet="value:"?
		public Assignment getFirstFacetAssignment_1() { return cFirstFacetAssignment_1; }

		//"value:"
		public Keyword getFirstFacetValueKeyword_1_0() { return cFirstFacetValueKeyword_1_0; }

		//expr=Expression?
		public Assignment getExprAssignment_2() { return cExprAssignment_2; }

		//Expression
		public RuleCall getExprExpressionParserRuleCall_2_0() { return cExprExpressionParserRuleCall_2_0; }

		//';'
		public Keyword getSemicolonKeyword_3() { return cSemicolonKeyword_3; }
	}

	public class S_DeclarationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.S_Declaration");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cS_DefinitionParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cS_SpeciesParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cS_ReflexParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cS_ActionParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cS_VarParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cS_LoopParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		
		/// *
		// * DECLARATIONS
		// * / S_Declaration:
		//	=> S_Definition | S_Species | S_Reflex | S_Action | S_Var | S_Loop;
		@Override public ParserRule getRule() { return rule; }

		//=> S_Definition | S_Species | S_Reflex | S_Action | S_Var | S_Loop
		public Alternatives getAlternatives() { return cAlternatives; }

		//=> S_Definition
		public RuleCall getS_DefinitionParserRuleCall_0() { return cS_DefinitionParserRuleCall_0; }

		//S_Species
		public RuleCall getS_SpeciesParserRuleCall_1() { return cS_SpeciesParserRuleCall_1; }

		//S_Reflex
		public RuleCall getS_ReflexParserRuleCall_2() { return cS_ReflexParserRuleCall_2; }

		//S_Action
		public RuleCall getS_ActionParserRuleCall_3() { return cS_ActionParserRuleCall_3; }

		//S_Var
		public RuleCall getS_VarParserRuleCall_4() { return cS_VarParserRuleCall_4; }

		//S_Loop
		public RuleCall getS_LoopParserRuleCall_5() { return cS_LoopParserRuleCall_5; }
	}

	public class S_ReflexElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.S_Reflex");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cKeyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cKey_ReflexKeyParserRuleCall_0_0 = (RuleCall)cKeyAssignment_0.eContents().get(0);
		private final Assignment cFirstFacetAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cFirstFacetNameKeyword_1_0 = (Keyword)cFirstFacetAssignment_1.eContents().get(0);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameValid_IDParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cWhenKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Keyword cColonKeyword_3_1 = (Keyword)cGroup_3.eContents().get(1);
		private final Assignment cExprAssignment_3_2 = (Assignment)cGroup_3.eContents().get(2);
		private final RuleCall cExprExpressionParserRuleCall_3_2_0 = (RuleCall)cExprAssignment_3_2.eContents().get(0);
		private final Assignment cBlockAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cBlockBlockParserRuleCall_4_0 = (RuleCall)cBlockAssignment_4.eContents().get(0);
		
		//S_Reflex:
		//	key=_ReflexKey firstFacet="name:"? name=Valid_ID? ("when" ":" expr=Expression)? block=Block;
		@Override public ParserRule getRule() { return rule; }

		//key=_ReflexKey firstFacet="name:"? name=Valid_ID? ("when" ":" expr=Expression)? block=Block
		public Group getGroup() { return cGroup; }

		//key=_ReflexKey
		public Assignment getKeyAssignment_0() { return cKeyAssignment_0; }

		//_ReflexKey
		public RuleCall getKey_ReflexKeyParserRuleCall_0_0() { return cKey_ReflexKeyParserRuleCall_0_0; }

		//firstFacet="name:"?
		public Assignment getFirstFacetAssignment_1() { return cFirstFacetAssignment_1; }

		//"name:"
		public Keyword getFirstFacetNameKeyword_1_0() { return cFirstFacetNameKeyword_1_0; }

		//name=Valid_ID?
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//Valid_ID
		public RuleCall getNameValid_IDParserRuleCall_2_0() { return cNameValid_IDParserRuleCall_2_0; }

		//("when" ":" expr=Expression)?
		public Group getGroup_3() { return cGroup_3; }

		//"when"
		public Keyword getWhenKeyword_3_0() { return cWhenKeyword_3_0; }

		//":"
		public Keyword getColonKeyword_3_1() { return cColonKeyword_3_1; }

		//expr=Expression
		public Assignment getExprAssignment_3_2() { return cExprAssignment_3_2; }

		//Expression
		public RuleCall getExprExpressionParserRuleCall_3_2_0() { return cExprExpressionParserRuleCall_3_2_0; }

		//block=Block
		public Assignment getBlockAssignment_4() { return cBlockAssignment_4; }

		//Block
		public RuleCall getBlockBlockParserRuleCall_4_0() { return cBlockBlockParserRuleCall_4_0; }
	}

	public class S_DefinitionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.S_Definition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cTkeyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cTkeyTypeRefParserRuleCall_0_0 = (RuleCall)cTkeyAssignment_0.eContents().get(0);
		private final Assignment cFirstFacetAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cFirstFacetNameKeyword_1_0 = (Keyword)cFirstFacetAssignment_1.eContents().get(0);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final Alternatives cNameAlternatives_2_0 = (Alternatives)cNameAssignment_2.eContents().get(0);
		private final RuleCall cNameValid_IDParserRuleCall_2_0_0 = (RuleCall)cNameAlternatives_2_0.eContents().get(0);
		private final RuleCall cNameSTRINGTerminalRuleCall_2_0_1 = (RuleCall)cNameAlternatives_2_0.eContents().get(1);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cLeftParenthesisKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cArgsAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cArgsActionArgumentsParserRuleCall_3_1_0 = (RuleCall)cArgsAssignment_3_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3_2 = (Keyword)cGroup_3.eContents().get(2);
		private final Assignment cFacetsAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cFacetsFacetParserRuleCall_4_0 = (RuleCall)cFacetsAssignment_4.eContents().get(0);
		private final Alternatives cAlternatives_5 = (Alternatives)cGroup.eContents().get(5);
		private final Assignment cBlockAssignment_5_0 = (Assignment)cAlternatives_5.eContents().get(0);
		private final RuleCall cBlockBlockParserRuleCall_5_0_0 = (RuleCall)cBlockAssignment_5_0.eContents().get(0);
		private final Keyword cSemicolonKeyword_5_1 = (Keyword)cAlternatives_5.eContents().get(1);
		
		//S_Definition:
		//	tkey=TypeRef firstFacet="name:"? name=(Valid_ID | STRING) ('(' args=ActionArguments ')')? facets+=Facet* (block=Block
		//	| ';');
		@Override public ParserRule getRule() { return rule; }

		//tkey=TypeRef firstFacet="name:"? name=(Valid_ID | STRING) ('(' args=ActionArguments ')')? facets+=Facet* (block=Block |
		//';')
		public Group getGroup() { return cGroup; }

		//tkey=TypeRef
		public Assignment getTkeyAssignment_0() { return cTkeyAssignment_0; }

		//TypeRef
		public RuleCall getTkeyTypeRefParserRuleCall_0_0() { return cTkeyTypeRefParserRuleCall_0_0; }

		//firstFacet="name:"?
		public Assignment getFirstFacetAssignment_1() { return cFirstFacetAssignment_1; }

		//"name:"
		public Keyword getFirstFacetNameKeyword_1_0() { return cFirstFacetNameKeyword_1_0; }

		//name=(Valid_ID | STRING)
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//(Valid_ID | STRING)
		public Alternatives getNameAlternatives_2_0() { return cNameAlternatives_2_0; }

		//Valid_ID
		public RuleCall getNameValid_IDParserRuleCall_2_0_0() { return cNameValid_IDParserRuleCall_2_0_0; }

		//STRING
		public RuleCall getNameSTRINGTerminalRuleCall_2_0_1() { return cNameSTRINGTerminalRuleCall_2_0_1; }

		//('(' args=ActionArguments ')')?
		public Group getGroup_3() { return cGroup_3; }

		//'('
		public Keyword getLeftParenthesisKeyword_3_0() { return cLeftParenthesisKeyword_3_0; }

		//args=ActionArguments
		public Assignment getArgsAssignment_3_1() { return cArgsAssignment_3_1; }

		//ActionArguments
		public RuleCall getArgsActionArgumentsParserRuleCall_3_1_0() { return cArgsActionArgumentsParserRuleCall_3_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_3_2() { return cRightParenthesisKeyword_3_2; }

		//facets+=Facet*
		public Assignment getFacetsAssignment_4() { return cFacetsAssignment_4; }

		//Facet
		public RuleCall getFacetsFacetParserRuleCall_4_0() { return cFacetsFacetParserRuleCall_4_0; }

		//(block=Block | ';')
		public Alternatives getAlternatives_5() { return cAlternatives_5; }

		//block=Block
		public Assignment getBlockAssignment_5_0() { return cBlockAssignment_5_0; }

		//Block
		public RuleCall getBlockBlockParserRuleCall_5_0_0() { return cBlockBlockParserRuleCall_5_0_0; }

		//';'
		public Keyword getSemicolonKeyword_5_1() { return cSemicolonKeyword_5_1; }
	}

	public class S_ActionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.S_Action");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cS_ActionAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cKeyAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cKeyActionKeyword_1_0 = (Keyword)cKeyAssignment_1.eContents().get(0);
		private final Assignment cFirstFacetAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final Keyword cFirstFacetNameKeyword_2_0 = (Keyword)cFirstFacetAssignment_2.eContents().get(0);
		private final Assignment cNameAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cNameValid_IDParserRuleCall_3_0 = (RuleCall)cNameAssignment_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cLeftParenthesisKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cArgsAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cArgsActionArgumentsParserRuleCall_4_1_0 = (RuleCall)cArgsAssignment_4_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_4_2 = (Keyword)cGroup_4.eContents().get(2);
		private final Assignment cFacetsAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cFacetsFacetParserRuleCall_5_0 = (RuleCall)cFacetsAssignment_5.eContents().get(0);
		private final Alternatives cAlternatives_6 = (Alternatives)cGroup.eContents().get(6);
		private final Assignment cBlockAssignment_6_0 = (Assignment)cAlternatives_6.eContents().get(0);
		private final RuleCall cBlockBlockParserRuleCall_6_0_0 = (RuleCall)cBlockAssignment_6_0.eContents().get(0);
		private final Keyword cSemicolonKeyword_6_1 = (Keyword)cAlternatives_6.eContents().get(1);
		
		//S_Action S_Definition:
		//	{S_Action} key="action" firstFacet='name:'? name=Valid_ID ('(' args=ActionArguments ')')? facets+=Facet* (block=Block
		//	| ';')
		@Override public ParserRule getRule() { return rule; }

		//{S_Action} key="action" firstFacet='name:'? name=Valid_ID ('(' args=ActionArguments ')')? facets+=Facet* (block=Block |
		//';')
		public Group getGroup() { return cGroup; }

		//{S_Action}
		public Action getS_ActionAction_0() { return cS_ActionAction_0; }

		//key="action"
		public Assignment getKeyAssignment_1() { return cKeyAssignment_1; }

		//"action"
		public Keyword getKeyActionKeyword_1_0() { return cKeyActionKeyword_1_0; }

		//firstFacet='name:'?
		public Assignment getFirstFacetAssignment_2() { return cFirstFacetAssignment_2; }

		//'name:'
		public Keyword getFirstFacetNameKeyword_2_0() { return cFirstFacetNameKeyword_2_0; }

		//name=Valid_ID
		public Assignment getNameAssignment_3() { return cNameAssignment_3; }

		//Valid_ID
		public RuleCall getNameValid_IDParserRuleCall_3_0() { return cNameValid_IDParserRuleCall_3_0; }

		//('(' args=ActionArguments ')')?
		public Group getGroup_4() { return cGroup_4; }

		//'('
		public Keyword getLeftParenthesisKeyword_4_0() { return cLeftParenthesisKeyword_4_0; }

		//args=ActionArguments
		public Assignment getArgsAssignment_4_1() { return cArgsAssignment_4_1; }

		//ActionArguments
		public RuleCall getArgsActionArgumentsParserRuleCall_4_1_0() { return cArgsActionArgumentsParserRuleCall_4_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_4_2() { return cRightParenthesisKeyword_4_2; }

		//facets+=Facet*
		public Assignment getFacetsAssignment_5() { return cFacetsAssignment_5; }

		//Facet
		public RuleCall getFacetsFacetParserRuleCall_5_0() { return cFacetsFacetParserRuleCall_5_0; }

		//(block=Block | ';')
		public Alternatives getAlternatives_6() { return cAlternatives_6; }

		//block=Block
		public Assignment getBlockAssignment_6_0() { return cBlockAssignment_6_0; }

		//Block
		public RuleCall getBlockBlockParserRuleCall_6_0_0() { return cBlockBlockParserRuleCall_6_0_0; }

		//';'
		public Keyword getSemicolonKeyword_6_1() { return cSemicolonKeyword_6_1; }
	}

	public class S_VarElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.S_Var");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cS_VarAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cKeyAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cKey_VarOrConstKeyParserRuleCall_1_0 = (RuleCall)cKeyAssignment_1.eContents().get(0);
		private final Assignment cFirstFacetAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final Keyword cFirstFacetNameKeyword_2_0 = (Keyword)cFirstFacetAssignment_2.eContents().get(0);
		private final Assignment cNameAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cNameValid_IDParserRuleCall_3_0 = (RuleCall)cNameAssignment_3.eContents().get(0);
		private final Assignment cFacetsAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cFacetsFacetParserRuleCall_4_0 = (RuleCall)cFacetsAssignment_4.eContents().get(0);
		private final Keyword cSemicolonKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//S_Var S_Definition:
		//	{S_Var} key=_VarOrConstKey firstFacet="name:"? name=Valid_ID facets+=Facet* ';'
		@Override public ParserRule getRule() { return rule; }

		//{S_Var} key=_VarOrConstKey firstFacet="name:"? name=Valid_ID facets+=Facet* ';'
		public Group getGroup() { return cGroup; }

		//{S_Var}
		public Action getS_VarAction_0() { return cS_VarAction_0; }

		//key=_VarOrConstKey
		public Assignment getKeyAssignment_1() { return cKeyAssignment_1; }

		//_VarOrConstKey
		public RuleCall getKey_VarOrConstKeyParserRuleCall_1_0() { return cKey_VarOrConstKeyParserRuleCall_1_0; }

		//firstFacet="name:"?
		public Assignment getFirstFacetAssignment_2() { return cFirstFacetAssignment_2; }

		//"name:"
		public Keyword getFirstFacetNameKeyword_2_0() { return cFirstFacetNameKeyword_2_0; }

		//name=Valid_ID
		public Assignment getNameAssignment_3() { return cNameAssignment_3; }

		//Valid_ID
		public RuleCall getNameValid_IDParserRuleCall_3_0() { return cNameValid_IDParserRuleCall_3_0; }

		//facets+=Facet*
		public Assignment getFacetsAssignment_4() { return cFacetsAssignment_4; }

		//Facet
		public RuleCall getFacetsFacetParserRuleCall_4_0() { return cFacetsFacetParserRuleCall_4_0; }

		//';'
		public Keyword getSemicolonKeyword_5() { return cSemicolonKeyword_5; }
	}

	public class S_AssignmentElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.S_Assignment");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cS_DirectAssignmentParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cS_SetParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		/// *
		// * ASSIGNMENTS
		// * / S_Assignment:
		//	S_DirectAssignment | S_Set;
		@Override public ParserRule getRule() { return rule; }

		//S_DirectAssignment | S_Set
		public Alternatives getAlternatives() { return cAlternatives; }

		//S_DirectAssignment
		public RuleCall getS_DirectAssignmentParserRuleCall_0() { return cS_DirectAssignmentParserRuleCall_0; }

		//S_Set
		public RuleCall getS_SetParserRuleCall_1() { return cS_SetParserRuleCall_1; }
	}

	public class S_DirectAssignmentElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.S_DirectAssignment");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Assignment cExprAssignment_0_0 = (Assignment)cGroup_0.eContents().get(0);
		private final RuleCall cExprExpressionParserRuleCall_0_0_0 = (RuleCall)cExprAssignment_0_0.eContents().get(0);
		private final Assignment cKeyAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final RuleCall cKey_AssignmentKeyParserRuleCall_0_1_0 = (RuleCall)cKeyAssignment_0_1.eContents().get(0);
		private final Assignment cValueAssignment_0_2 = (Assignment)cGroup_0.eContents().get(2);
		private final RuleCall cValueExpressionParserRuleCall_0_2_0 = (RuleCall)cValueAssignment_0_2.eContents().get(0);
		private final Assignment cFacetsAssignment_0_3 = (Assignment)cGroup_0.eContents().get(3);
		private final RuleCall cFacetsFacetParserRuleCall_0_3_0 = (RuleCall)cFacetsAssignment_0_3.eContents().get(0);
		private final Keyword cSemicolonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//S_DirectAssignment:
		//	(expr=Expression key=_AssignmentKey value=Expression facets+=Facet*) ';';
		@Override public ParserRule getRule() { return rule; }

		//(expr=Expression key=_AssignmentKey value=Expression facets+=Facet*) ';'
		public Group getGroup() { return cGroup; }

		//(expr=Expression key=_AssignmentKey value=Expression facets+=Facet*)
		public Group getGroup_0() { return cGroup_0; }

		//expr=Expression
		public Assignment getExprAssignment_0_0() { return cExprAssignment_0_0; }

		//Expression
		public RuleCall getExprExpressionParserRuleCall_0_0_0() { return cExprExpressionParserRuleCall_0_0_0; }

		//key=_AssignmentKey
		public Assignment getKeyAssignment_0_1() { return cKeyAssignment_0_1; }

		//_AssignmentKey
		public RuleCall getKey_AssignmentKeyParserRuleCall_0_1_0() { return cKey_AssignmentKeyParserRuleCall_0_1_0; }

		//value=Expression
		public Assignment getValueAssignment_0_2() { return cValueAssignment_0_2; }

		//Expression
		public RuleCall getValueExpressionParserRuleCall_0_2_0() { return cValueExpressionParserRuleCall_0_2_0; }

		//facets+=Facet*
		public Assignment getFacetsAssignment_0_3() { return cFacetsAssignment_0_3; }

		//Facet
		public RuleCall getFacetsFacetParserRuleCall_0_3_0() { return cFacetsFacetParserRuleCall_0_3_0; }

		//';'
		public Keyword getSemicolonKeyword_1() { return cSemicolonKeyword_1; }
	}

	public class S_SetElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.S_Set");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cKeyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cKeySetKeyword_0_0 = (Keyword)cKeyAssignment_0.eContents().get(0);
		private final Assignment cExprAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cExprExpressionParserRuleCall_1_0 = (RuleCall)cExprAssignment_1.eContents().get(0);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Keyword cValueKeyword_2_0 = (Keyword)cAlternatives_2.eContents().get(0);
		private final Keyword cLessThanSignHyphenMinusKeyword_2_1 = (Keyword)cAlternatives_2.eContents().get(1);
		private final Assignment cValueAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cValueExpressionParserRuleCall_3_0 = (RuleCall)cValueAssignment_3.eContents().get(0);
		private final Keyword cSemicolonKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//S_Set:
		//	key="set" expr=Expression ("value:" | "<-") value=Expression ";";
		@Override public ParserRule getRule() { return rule; }

		//key="set" expr=Expression ("value:" | "<-") value=Expression ";"
		public Group getGroup() { return cGroup; }

		//key="set"
		public Assignment getKeyAssignment_0() { return cKeyAssignment_0; }

		//"set"
		public Keyword getKeySetKeyword_0_0() { return cKeySetKeyword_0_0; }

		//expr=Expression
		public Assignment getExprAssignment_1() { return cExprAssignment_1; }

		//Expression
		public RuleCall getExprExpressionParserRuleCall_1_0() { return cExprExpressionParserRuleCall_1_0; }

		//("value:" | "<-")
		public Alternatives getAlternatives_2() { return cAlternatives_2; }

		//"value:"
		public Keyword getValueKeyword_2_0() { return cValueKeyword_2_0; }

		//"<-"
		public Keyword getLessThanSignHyphenMinusKeyword_2_1() { return cLessThanSignHyphenMinusKeyword_2_1; }

		//value=Expression
		public Assignment getValueAssignment_3() { return cValueAssignment_3; }

		//Expression
		public RuleCall getValueExpressionParserRuleCall_3_0() { return cValueExpressionParserRuleCall_3_0; }

		//";"
		public Keyword getSemicolonKeyword_4() { return cSemicolonKeyword_4; }
	}

	public class S_EquationsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.S_Equations");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cKeyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cKey_EquationsKeyParserRuleCall_0_0 = (RuleCall)cKeyAssignment_0.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameValid_IDParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Assignment cFacetsAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cFacetsFacetParserRuleCall_2_0 = (RuleCall)cFacetsAssignment_2.eContents().get(0);
		private final Alternatives cAlternatives_3 = (Alternatives)cGroup.eContents().get(3);
		private final Group cGroup_3_0 = (Group)cAlternatives_3.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3_0_0 = (Keyword)cGroup_3_0.eContents().get(0);
		private final Group cGroup_3_0_1 = (Group)cGroup_3_0.eContents().get(1);
		private final Assignment cEquationsAssignment_3_0_1_0 = (Assignment)cGroup_3_0_1.eContents().get(0);
		private final RuleCall cEquationsS_EquationParserRuleCall_3_0_1_0_0 = (RuleCall)cEquationsAssignment_3_0_1_0.eContents().get(0);
		private final Keyword cSemicolonKeyword_3_0_1_1 = (Keyword)cGroup_3_0_1.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_3_0_2 = (Keyword)cGroup_3_0.eContents().get(2);
		private final Keyword cSemicolonKeyword_3_1 = (Keyword)cAlternatives_3.eContents().get(1);
		
		//S_Equations:
		//	key=_EquationsKey name=Valid_ID facets+=Facet* ('{' (equations+=S_Equation ';')* '}' | ';');
		@Override public ParserRule getRule() { return rule; }

		//key=_EquationsKey name=Valid_ID facets+=Facet* ('{' (equations+=S_Equation ';')* '}' | ';')
		public Group getGroup() { return cGroup; }

		//key=_EquationsKey
		public Assignment getKeyAssignment_0() { return cKeyAssignment_0; }

		//_EquationsKey
		public RuleCall getKey_EquationsKeyParserRuleCall_0_0() { return cKey_EquationsKeyParserRuleCall_0_0; }

		//name=Valid_ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//Valid_ID
		public RuleCall getNameValid_IDParserRuleCall_1_0() { return cNameValid_IDParserRuleCall_1_0; }

		//facets+=Facet*
		public Assignment getFacetsAssignment_2() { return cFacetsAssignment_2; }

		//Facet
		public RuleCall getFacetsFacetParserRuleCall_2_0() { return cFacetsFacetParserRuleCall_2_0; }

		//('{' (equations+=S_Equation ';')* '}' | ';')
		public Alternatives getAlternatives_3() { return cAlternatives_3; }

		//'{' (equations+=S_Equation ';')* '}'
		public Group getGroup_3_0() { return cGroup_3_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_3_0_0() { return cLeftCurlyBracketKeyword_3_0_0; }

		//(equations+=S_Equation ';')*
		public Group getGroup_3_0_1() { return cGroup_3_0_1; }

		//equations+=S_Equation
		public Assignment getEquationsAssignment_3_0_1_0() { return cEquationsAssignment_3_0_1_0; }

		//S_Equation
		public RuleCall getEquationsS_EquationParserRuleCall_3_0_1_0_0() { return cEquationsS_EquationParserRuleCall_3_0_1_0_0; }

		//';'
		public Keyword getSemicolonKeyword_3_0_1_1() { return cSemicolonKeyword_3_0_1_1; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_3_0_2() { return cRightCurlyBracketKeyword_3_0_2; }

		//';'
		public Keyword getSemicolonKeyword_3_1() { return cSemicolonKeyword_3_1; }
	}

	public class S_EquationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.S_Equation");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cExprAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Alternatives cExprAlternatives_0_0 = (Alternatives)cExprAssignment_0.eContents().get(0);
		private final RuleCall cExprFunctionParserRuleCall_0_0_0 = (RuleCall)cExprAlternatives_0_0.eContents().get(0);
		private final RuleCall cExprVariableRefParserRuleCall_0_0_1 = (RuleCall)cExprAlternatives_0_0.eContents().get(1);
		private final Assignment cKeyAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cKeyEqualsSignKeyword_1_0 = (Keyword)cKeyAssignment_1.eContents().get(0);
		private final Assignment cValueAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cValueExpressionParserRuleCall_2_0 = (RuleCall)cValueAssignment_2.eContents().get(0);
		
		//S_Equation S_Assignment:
		//	expr=(Function | VariableRef) key="=" value=Expression
		@Override public ParserRule getRule() { return rule; }

		//expr=(Function | VariableRef) key="=" value=Expression
		public Group getGroup() { return cGroup; }

		//expr=(Function | VariableRef)
		public Assignment getExprAssignment_0() { return cExprAssignment_0; }

		//(Function | VariableRef)
		public Alternatives getExprAlternatives_0_0() { return cExprAlternatives_0_0; }

		//Function
		public RuleCall getExprFunctionParserRuleCall_0_0_0() { return cExprFunctionParserRuleCall_0_0_0; }

		//VariableRef
		public RuleCall getExprVariableRefParserRuleCall_0_0_1() { return cExprVariableRefParserRuleCall_0_0_1; }

		//key="="
		public Assignment getKeyAssignment_1() { return cKeyAssignment_1; }

		//"="
		public Keyword getKeyEqualsSignKeyword_1_0() { return cKeyEqualsSignKeyword_1_0; }

		//value=Expression
		public Assignment getValueAssignment_2() { return cValueAssignment_2; }

		//Expression
		public RuleCall getValueExpressionParserRuleCall_2_0() { return cValueExpressionParserRuleCall_2_0; }
	}

	public class S_SolveElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.S_Solve");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cKeyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cKey_SolveKeyParserRuleCall_0_0 = (RuleCall)cKeyAssignment_0.eContents().get(0);
		private final Assignment cFirstFacetAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cFirstFacetEquationKeyword_1_0 = (Keyword)cFirstFacetAssignment_1.eContents().get(0);
		private final Assignment cExprAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cExprEquationRefParserRuleCall_2_0 = (RuleCall)cExprAssignment_2.eContents().get(0);
		private final Assignment cFacetsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cFacetsFacetParserRuleCall_3_0 = (RuleCall)cFacetsAssignment_3.eContents().get(0);
		private final Alternatives cAlternatives_4 = (Alternatives)cGroup.eContents().get(4);
		private final Assignment cBlockAssignment_4_0 = (Assignment)cAlternatives_4.eContents().get(0);
		private final RuleCall cBlockBlockParserRuleCall_4_0_0 = (RuleCall)cBlockAssignment_4_0.eContents().get(0);
		private final Keyword cSemicolonKeyword_4_1 = (Keyword)cAlternatives_4.eContents().get(1);
		
		//S_Solve:
		//	key=_SolveKey firstFacet="equation:"? expr=EquationRef facets+=Facet* (block=Block | ';');
		@Override public ParserRule getRule() { return rule; }

		//key=_SolveKey firstFacet="equation:"? expr=EquationRef facets+=Facet* (block=Block | ';')
		public Group getGroup() { return cGroup; }

		//key=_SolveKey
		public Assignment getKeyAssignment_0() { return cKeyAssignment_0; }

		//_SolveKey
		public RuleCall getKey_SolveKeyParserRuleCall_0_0() { return cKey_SolveKeyParserRuleCall_0_0; }

		//firstFacet="equation:"?
		public Assignment getFirstFacetAssignment_1() { return cFirstFacetAssignment_1; }

		//"equation:"
		public Keyword getFirstFacetEquationKeyword_1_0() { return cFirstFacetEquationKeyword_1_0; }

		//expr=EquationRef
		public Assignment getExprAssignment_2() { return cExprAssignment_2; }

		//EquationRef
		public RuleCall getExprEquationRefParserRuleCall_2_0() { return cExprEquationRefParserRuleCall_2_0; }

		//facets+=Facet*
		public Assignment getFacetsAssignment_3() { return cFacetsAssignment_3; }

		//Facet
		public RuleCall getFacetsFacetParserRuleCall_3_0() { return cFacetsFacetParserRuleCall_3_0; }

		//(block=Block | ';')
		public Alternatives getAlternatives_4() { return cAlternatives_4; }

		//block=Block
		public Assignment getBlockAssignment_4_0() { return cBlockAssignment_4_0; }

		//Block
		public RuleCall getBlockBlockParserRuleCall_4_0_0() { return cBlockBlockParserRuleCall_4_0_0; }

		//';'
		public Keyword getSemicolonKeyword_4_1() { return cSemicolonKeyword_4_1; }
	}

	public class S_DisplayElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.S_Display");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cKeyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cKeyDisplayKeyword_0_0 = (Keyword)cKeyAssignment_0.eContents().get(0);
		private final Assignment cFirstFacetAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cFirstFacetNameKeyword_1_0 = (Keyword)cFirstFacetAssignment_1.eContents().get(0);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final Alternatives cNameAlternatives_2_0 = (Alternatives)cNameAssignment_2.eContents().get(0);
		private final RuleCall cNameValid_IDParserRuleCall_2_0_0 = (RuleCall)cNameAlternatives_2_0.eContents().get(0);
		private final RuleCall cNameSTRINGTerminalRuleCall_2_0_1 = (RuleCall)cNameAlternatives_2_0.eContents().get(1);
		private final Assignment cFacetsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cFacetsFacetParserRuleCall_3_0 = (RuleCall)cFacetsAssignment_3.eContents().get(0);
		private final Assignment cBlockAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cBlockDisplayBlockParserRuleCall_4_0 = (RuleCall)cBlockAssignment_4.eContents().get(0);
		
		/// **
		// * DISPLAYS
		// * / //S_Monitor:
		////	key="monitor" (firstFacet="name:")? name=(Valid_ID|STRING) facets+=Facet ";"
		////;
		//S_Display:
		//	key="display" firstFacet="name:"? name=(Valid_ID | STRING) facets+=Facet* block=displayBlock;
		@Override public ParserRule getRule() { return rule; }

		//key="display" firstFacet="name:"? name=(Valid_ID | STRING) facets+=Facet* block=displayBlock
		public Group getGroup() { return cGroup; }

		//key="display"
		public Assignment getKeyAssignment_0() { return cKeyAssignment_0; }

		//"display"
		public Keyword getKeyDisplayKeyword_0_0() { return cKeyDisplayKeyword_0_0; }

		//firstFacet="name:"?
		public Assignment getFirstFacetAssignment_1() { return cFirstFacetAssignment_1; }

		//"name:"
		public Keyword getFirstFacetNameKeyword_1_0() { return cFirstFacetNameKeyword_1_0; }

		//name=(Valid_ID | STRING)
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//(Valid_ID | STRING)
		public Alternatives getNameAlternatives_2_0() { return cNameAlternatives_2_0; }

		//Valid_ID
		public RuleCall getNameValid_IDParserRuleCall_2_0_0() { return cNameValid_IDParserRuleCall_2_0_0; }

		//STRING
		public RuleCall getNameSTRINGTerminalRuleCall_2_0_1() { return cNameSTRINGTerminalRuleCall_2_0_1; }

		//facets+=Facet*
		public Assignment getFacetsAssignment_3() { return cFacetsAssignment_3; }

		//Facet
		public RuleCall getFacetsFacetParserRuleCall_3_0() { return cFacetsFacetParserRuleCall_3_0; }

		//block=displayBlock
		public Assignment getBlockAssignment_4() { return cBlockAssignment_4; }

		//displayBlock
		public RuleCall getBlockDisplayBlockParserRuleCall_4_0() { return cBlockDisplayBlockParserRuleCall_4_0; }
	}

	public class DisplayBlockElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.displayBlock");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cBlockAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cStatementsAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cStatementsDisplayStatementParserRuleCall_2_0 = (RuleCall)cStatementsAssignment_2.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//displayBlock Block:
		//	{Block} '{' statements+=displayStatement* '}'
		@Override public ParserRule getRule() { return rule; }

		//{Block} '{' statements+=displayStatement* '}'
		public Group getGroup() { return cGroup; }

		//{Block}
		public Action getBlockAction_0() { return cBlockAction_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_1() { return cLeftCurlyBracketKeyword_1; }

		//statements+=displayStatement*
		public Assignment getStatementsAssignment_2() { return cStatementsAssignment_2; }

		//displayStatement
		public RuleCall getStatementsDisplayStatementParserRuleCall_2_0() { return cStatementsDisplayStatementParserRuleCall_2_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_3() { return cRightCurlyBracketKeyword_3; }
	}

	public class DisplayStatementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.displayStatement");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cSpeciesOrGridDisplayStatementParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cS_1Expr_Facets_BlockOrEndParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		////
		////ExperimentBlock returns Block:
		////	{Block} '{' (statements+=Statement)* '}'
		////;
		////experimentStatement returns Statement:
		////	Statement | S_Output
		////;
		////
		////
		////S_Output returns Statement:
		////	key=("output"|"permanent") (facets+=Facet)* block=outputBlock?
		////;
		////outputBlock returns Block:
		////	{Block} '{' (statements += outputStatement)* '}'
		////;
		////outputStatement returns Statement:
		////	Statement | S_Display 
		////;
		//displayStatement Statement:
		//	speciesOrGridDisplayStatement | S_1Expr_Facets_BlockOrEnd
		@Override public ParserRule getRule() { return rule; }

		//speciesOrGridDisplayStatement | S_1Expr_Facets_BlockOrEnd
		public Alternatives getAlternatives() { return cAlternatives; }

		//speciesOrGridDisplayStatement
		public RuleCall getSpeciesOrGridDisplayStatementParserRuleCall_0() { return cSpeciesOrGridDisplayStatementParserRuleCall_0; }

		//S_1Expr_Facets_BlockOrEnd
		public RuleCall getS_1Expr_Facets_BlockOrEndParserRuleCall_1() { return cS_1Expr_Facets_BlockOrEndParserRuleCall_1; }
	}

	public class SpeciesOrGridDisplayStatementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.speciesOrGridDisplayStatement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cKeyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cKey_SpeciesKeyParserRuleCall_0_0 = (RuleCall)cKeyAssignment_0.eContents().get(0);
		private final Assignment cExprAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cExprExpressionParserRuleCall_1_0 = (RuleCall)cExprAssignment_1.eContents().get(0);
		private final Assignment cFacetsAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cFacetsFacetParserRuleCall_2_0 = (RuleCall)cFacetsAssignment_2.eContents().get(0);
		private final Alternatives cAlternatives_3 = (Alternatives)cGroup.eContents().get(3);
		private final Assignment cBlockAssignment_3_0 = (Assignment)cAlternatives_3.eContents().get(0);
		private final RuleCall cBlockDisplayBlockParserRuleCall_3_0_0 = (RuleCall)cBlockAssignment_3_0.eContents().get(0);
		private final Keyword cSemicolonKeyword_3_1 = (Keyword)cAlternatives_3.eContents().get(1);
		
		//speciesOrGridDisplayStatement:
		//	key=_SpeciesKey expr=Expression facets+=Facet* (block=displayBlock | ";");
		@Override public ParserRule getRule() { return rule; }

		//key=_SpeciesKey expr=Expression facets+=Facet* (block=displayBlock | ";")
		public Group getGroup() { return cGroup; }

		//key=_SpeciesKey
		public Assignment getKeyAssignment_0() { return cKeyAssignment_0; }

		//_SpeciesKey
		public RuleCall getKey_SpeciesKeyParserRuleCall_0_0() { return cKey_SpeciesKeyParserRuleCall_0_0; }

		//expr=Expression
		public Assignment getExprAssignment_1() { return cExprAssignment_1; }

		//Expression
		public RuleCall getExprExpressionParserRuleCall_1_0() { return cExprExpressionParserRuleCall_1_0; }

		//facets+=Facet*
		public Assignment getFacetsAssignment_2() { return cFacetsAssignment_2; }

		//Facet
		public RuleCall getFacetsFacetParserRuleCall_2_0() { return cFacetsFacetParserRuleCall_2_0; }

		//(block=displayBlock | ";")
		public Alternatives getAlternatives_3() { return cAlternatives_3; }

		//block=displayBlock
		public Assignment getBlockAssignment_3_0() { return cBlockAssignment_3_0; }

		//displayBlock
		public RuleCall getBlockDisplayBlockParserRuleCall_3_0_0() { return cBlockDisplayBlockParserRuleCall_3_0_0; }

		//";"
		public Keyword getSemicolonKeyword_3_1() { return cSemicolonKeyword_3_1; }
	}

	public class _EquationsKeyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml._EquationsKey");
		private final Keyword cEquationKeyword = (Keyword)rule.eContents().get(1);
		
		/// **
		// * Statement keys
		// * / _EquationsKey:
		//	"equation";
		@Override public ParserRule getRule() { return rule; }

		//"equation"
		public Keyword getEquationKeyword() { return cEquationKeyword; }
	}

	public class _SolveKeyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml._SolveKey");
		private final Keyword cSolveKeyword = (Keyword)rule.eContents().get(1);
		
		//_SolveKey:
		//	"solve";
		@Override public ParserRule getRule() { return rule; }

		//"solve"
		public Keyword getSolveKeyword() { return cSolveKeyword; }
	}

	public class _SpeciesKeyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml._SpeciesKey");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cSpeciesKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cGridKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		
		//_SpeciesKey:
		//	"species" | "grid";
		@Override public ParserRule getRule() { return rule; }

		//"species" | "grid"
		public Alternatives getAlternatives() { return cAlternatives; }

		//"species"
		public Keyword getSpeciesKeyword_0() { return cSpeciesKeyword_0; }

		//"grid"
		public Keyword getGridKeyword_1() { return cGridKeyword_1; }
	}

	public class _ExperimentKeyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml._ExperimentKey");
		private final Keyword cExperimentKeyword = (Keyword)rule.eContents().get(1);
		
		//_ExperimentKey:
		//	"experiment";
		@Override public ParserRule getRule() { return rule; }

		//"experiment"
		public Keyword getExperimentKeyword() { return cExperimentKeyword; }
	}

	public class _1Expr_Facets_BlockOrEnd_KeyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml._1Expr_Facets_BlockOrEnd_Key");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall c_LayerKeyParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final Keyword cAskKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cReleaseKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cCaptureKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cCreateKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Keyword cWriteKeyword_5 = (Keyword)cAlternatives.eContents().get(5);
		private final Keyword cErrorKeyword_6 = (Keyword)cAlternatives.eContents().get(6);
		private final Keyword cWarnKeyword_7 = (Keyword)cAlternatives.eContents().get(7);
		private final Keyword cExceptionKeyword_8 = (Keyword)cAlternatives.eContents().get(8);
		private final Keyword cSaveKeyword_9 = (Keyword)cAlternatives.eContents().get(9);
		private final Keyword cAssertKeyword_10 = (Keyword)cAlternatives.eContents().get(10);
		private final Keyword cInspectKeyword_11 = (Keyword)cAlternatives.eContents().get(11);
		private final Keyword cBrowseKeyword_12 = (Keyword)cAlternatives.eContents().get(12);
		private final Keyword cDrawKeyword_13 = (Keyword)cAlternatives.eContents().get(13);
		private final Keyword cUsingKeyword_14 = (Keyword)cAlternatives.eContents().get(14);
		private final Keyword cSwitchKeyword_15 = (Keyword)cAlternatives.eContents().get(15);
		private final Keyword cPutKeyword_16 = (Keyword)cAlternatives.eContents().get(16);
		private final Keyword cAddKeyword_17 = (Keyword)cAlternatives.eContents().get(17);
		private final Keyword cRemoveKeyword_18 = (Keyword)cAlternatives.eContents().get(18);
		private final Keyword cMatchKeyword_19 = (Keyword)cAlternatives.eContents().get(19);
		private final Keyword cMatch_betweenKeyword_20 = (Keyword)cAlternatives.eContents().get(20);
		private final Keyword cMatch_oneKeyword_21 = (Keyword)cAlternatives.eContents().get(21);
		private final Keyword cParameterKeyword_22 = (Keyword)cAlternatives.eContents().get(22);
		private final Keyword cStatusKeyword_23 = (Keyword)cAlternatives.eContents().get(23);
		private final Keyword cHighlightKeyword_24 = (Keyword)cAlternatives.eContents().get(24);
		private final Keyword cFocus_onKeyword_25 = (Keyword)cAlternatives.eContents().get(25);
		
		//_1Expr_Facets_BlockOrEnd_Key:
		//	_LayerKey | "ask" | "release" | "capture" | "create" | "write" | "error" | "warn" | "exception" | "save" | "assert" |
		//	"inspect" | "browse" |
		//	"draw" | "using" | "switch" | "put" | "add" | "remove" | "match" | "match_between" | "match_one" | "parameter" |
		//	"status" | "highlight" | "focus_on";
		@Override public ParserRule getRule() { return rule; }

		//_LayerKey | "ask" | "release" | "capture" | "create" | "write" | "error" | "warn" | "exception" | "save" | "assert" |
		//"inspect" | "browse" | "draw" | "using" | "switch" | "put" | "add" | "remove" | "match" | "match_between" | "match_one"
		//| "parameter" | "status" | "highlight" | "focus_on"
		public Alternatives getAlternatives() { return cAlternatives; }

		//_LayerKey
		public RuleCall get_LayerKeyParserRuleCall_0() { return c_LayerKeyParserRuleCall_0; }

		//"ask"
		public Keyword getAskKeyword_1() { return cAskKeyword_1; }

		//"release"
		public Keyword getReleaseKeyword_2() { return cReleaseKeyword_2; }

		//"capture"
		public Keyword getCaptureKeyword_3() { return cCaptureKeyword_3; }

		//"create"
		public Keyword getCreateKeyword_4() { return cCreateKeyword_4; }

		//"write"
		public Keyword getWriteKeyword_5() { return cWriteKeyword_5; }

		//"error"
		public Keyword getErrorKeyword_6() { return cErrorKeyword_6; }

		//"warn"
		public Keyword getWarnKeyword_7() { return cWarnKeyword_7; }

		//"exception"
		public Keyword getExceptionKeyword_8() { return cExceptionKeyword_8; }

		//"save"
		public Keyword getSaveKeyword_9() { return cSaveKeyword_9; }

		//"assert"
		public Keyword getAssertKeyword_10() { return cAssertKeyword_10; }

		//"inspect"
		public Keyword getInspectKeyword_11() { return cInspectKeyword_11; }

		//"browse"
		public Keyword getBrowseKeyword_12() { return cBrowseKeyword_12; }

		//"draw"
		public Keyword getDrawKeyword_13() { return cDrawKeyword_13; }

		//"using"
		public Keyword getUsingKeyword_14() { return cUsingKeyword_14; }

		//"switch"
		public Keyword getSwitchKeyword_15() { return cSwitchKeyword_15; }

		//"put"
		public Keyword getPutKeyword_16() { return cPutKeyword_16; }

		//"add"
		public Keyword getAddKeyword_17() { return cAddKeyword_17; }

		//"remove"
		public Keyword getRemoveKeyword_18() { return cRemoveKeyword_18; }

		//"match"
		public Keyword getMatchKeyword_19() { return cMatchKeyword_19; }

		//"match_between"
		public Keyword getMatch_betweenKeyword_20() { return cMatch_betweenKeyword_20; }

		//"match_one"
		public Keyword getMatch_oneKeyword_21() { return cMatch_oneKeyword_21; }

		//"parameter"
		public Keyword getParameterKeyword_22() { return cParameterKeyword_22; }

		//"status"
		public Keyword getStatusKeyword_23() { return cStatusKeyword_23; }

		//"highlight"
		public Keyword getHighlightKeyword_24() { return cHighlightKeyword_24; }

		//"focus_on"
		public Keyword getFocus_onKeyword_25() { return cFocus_onKeyword_25; }
	}

	public class _LayerKeyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml._LayerKey");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cLightKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cCameraKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cTextKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cImageKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cDataKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Keyword cChartKeyword_5 = (Keyword)cAlternatives.eContents().get(5);
		private final Keyword cAgentsKeyword_6 = (Keyword)cAlternatives.eContents().get(6);
		private final Keyword cGraphicsKeyword_7 = (Keyword)cAlternatives.eContents().get(7);
		private final Keyword cDisplay_populationKeyword_8 = (Keyword)cAlternatives.eContents().get(8);
		private final Keyword cDisplay_gridKeyword_9 = (Keyword)cAlternatives.eContents().get(9);
		private final Keyword cQuadtreeKeyword_10 = (Keyword)cAlternatives.eContents().get(10);
		private final Keyword cEventKeyword_11 = (Keyword)cAlternatives.eContents().get(11);
		private final Keyword cOverlayKeyword_12 = (Keyword)cAlternatives.eContents().get(12);
		private final Keyword cDatalistKeyword_13 = (Keyword)cAlternatives.eContents().get(13);
		
		//_LayerKey:
		//	"light" | "camera" | "text" | "image" | "data" | "chart" | "agents" | "graphics" | "display_population" |
		//	"display_grid" | "quadtree" | "event" | "overlay" | "datalist";
		@Override public ParserRule getRule() { return rule; }

		//"light" | "camera" | "text" | "image" | "data" | "chart" | "agents" | "graphics" | "display_population" | "display_grid"
		//| "quadtree" | "event" | "overlay" | "datalist"
		public Alternatives getAlternatives() { return cAlternatives; }

		//"light"
		public Keyword getLightKeyword_0() { return cLightKeyword_0; }

		//"camera"
		public Keyword getCameraKeyword_1() { return cCameraKeyword_1; }

		//"text"
		public Keyword getTextKeyword_2() { return cTextKeyword_2; }

		//"image"
		public Keyword getImageKeyword_3() { return cImageKeyword_3; }

		//"data"
		public Keyword getDataKeyword_4() { return cDataKeyword_4; }

		//"chart"
		public Keyword getChartKeyword_5() { return cChartKeyword_5; }

		//"agents"
		public Keyword getAgentsKeyword_6() { return cAgentsKeyword_6; }

		//"graphics"
		public Keyword getGraphicsKeyword_7() { return cGraphicsKeyword_7; }

		//"display_population"
		public Keyword getDisplay_populationKeyword_8() { return cDisplay_populationKeyword_8; }

		//"display_grid"
		public Keyword getDisplay_gridKeyword_9() { return cDisplay_gridKeyword_9; }

		//"quadtree"
		public Keyword getQuadtreeKeyword_10() { return cQuadtreeKeyword_10; }

		//"event"
		public Keyword getEventKeyword_11() { return cEventKeyword_11; }

		//"overlay"
		public Keyword getOverlayKeyword_12() { return cOverlayKeyword_12; }

		//"datalist"
		public Keyword getDatalistKeyword_13() { return cDatalistKeyword_13; }
	}

	public class _DoKeyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml._DoKey");
		private final Keyword cDoKeyword = (Keyword)rule.eContents().get(1);
		
		//_DoKey:
		//	"do";
		@Override public ParserRule getRule() { return rule; }

		//"do"
		public Keyword getDoKeyword() { return cDoKeyword; }
	}

	public class _VarOrConstKeyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml._VarOrConstKey");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cVarKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cConstKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cLetKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cArgKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		
		//_VarOrConstKey:
		//	"var" | "const" | "let" | "arg";
		@Override public ParserRule getRule() { return rule; }

		//"var" | "const" | "let" | "arg"
		public Alternatives getAlternatives() { return cAlternatives; }

		//"var"
		public Keyword getVarKeyword_0() { return cVarKeyword_0; }

		//"const"
		public Keyword getConstKeyword_1() { return cConstKeyword_1; }

		//"let"
		public Keyword getLetKeyword_2() { return cLetKeyword_2; }

		//"arg"
		public Keyword getArgKeyword_3() { return cArgKeyword_3; }
	}

	public class _ReflexKeyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml._ReflexKey");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cInitKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cReflexKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cAspectKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		
		//_ReflexKey:
		//	"init" | "reflex" | "aspect";
		@Override public ParserRule getRule() { return rule; }

		//"init" | "reflex" | "aspect"
		public Alternatives getAlternatives() { return cAlternatives; }

		//"init"
		public Keyword getInitKeyword_0() { return cInitKeyword_0; }

		//"reflex"
		public Keyword getReflexKeyword_1() { return cReflexKeyword_1; }

		//"aspect"
		public Keyword getAspectKeyword_2() { return cAspectKeyword_2; }
	}

	public class _AssignmentKeyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml._AssignmentKey");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cLessThanSignHyphenMinusKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cLessThanSignLessThanSignKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Group cGroup_2 = (Group)cAlternatives.eContents().get(2);
		private final Keyword cGreaterThanSignKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_2_1 = (Keyword)cGroup_2.eContents().get(1);
		private final Keyword cLessThanSignLessThanSignPlusSignKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Group cGroup_4 = (Group)cAlternatives.eContents().get(4);
		private final Keyword cGreaterThanSignKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Keyword cGreaterThanSignHyphenMinusKeyword_4_1 = (Keyword)cGroup_4.eContents().get(1);
		private final Keyword cPlusSignLessThanSignHyphenMinusKeyword_5 = (Keyword)cAlternatives.eContents().get(5);
		private final Keyword cLessThanSignPlusSignKeyword_6 = (Keyword)cAlternatives.eContents().get(6);
		private final Keyword cGreaterThanSignHyphenMinusKeyword_7 = (Keyword)cAlternatives.eContents().get(7);
		
		//_AssignmentKey:
		//	"<-" | "<<" | '>' '>' | "<<+" | '>' '>-' | "+<-" | "<+" | ">-";
		@Override public ParserRule getRule() { return rule; }

		//"<-" | "<<" | '>' '>' | "<<+" | '>' '>-' | "+<-" | "<+" | ">-"
		public Alternatives getAlternatives() { return cAlternatives; }

		//"<-"
		public Keyword getLessThanSignHyphenMinusKeyword_0() { return cLessThanSignHyphenMinusKeyword_0; }

		//"<<"
		public Keyword getLessThanSignLessThanSignKeyword_1() { return cLessThanSignLessThanSignKeyword_1; }

		//'>' '>'
		public Group getGroup_2() { return cGroup_2; }

		//'>'
		public Keyword getGreaterThanSignKeyword_2_0() { return cGreaterThanSignKeyword_2_0; }

		//'>'
		public Keyword getGreaterThanSignKeyword_2_1() { return cGreaterThanSignKeyword_2_1; }

		//"<<+"
		public Keyword getLessThanSignLessThanSignPlusSignKeyword_3() { return cLessThanSignLessThanSignPlusSignKeyword_3; }

		//'>' '>-'
		public Group getGroup_4() { return cGroup_4; }

		//'>'
		public Keyword getGreaterThanSignKeyword_4_0() { return cGreaterThanSignKeyword_4_0; }

		//'>-'
		public Keyword getGreaterThanSignHyphenMinusKeyword_4_1() { return cGreaterThanSignHyphenMinusKeyword_4_1; }

		//"+<-"
		public Keyword getPlusSignLessThanSignHyphenMinusKeyword_5() { return cPlusSignLessThanSignHyphenMinusKeyword_5; }

		//"<+"
		public Keyword getLessThanSignPlusSignKeyword_6() { return cLessThanSignPlusSignKeyword_6; }

		//">-"
		public Keyword getGreaterThanSignHyphenMinusKeyword_7() { return cGreaterThanSignHyphenMinusKeyword_7; }
	}

	public class ParametersElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.Parameters");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cParametersAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cParamsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cParamsParameterListParserRuleCall_1_0 = (RuleCall)cParamsAssignment_1.eContents().get(0);
		
		/// **
		// * Parameters and arguments
		// * / Parameters:
		//	{Parameters} params=ParameterList?;
		@Override public ParserRule getRule() { return rule; }

		//{Parameters} params=ParameterList?
		public Group getGroup() { return cGroup; }

		//{Parameters}
		public Action getParametersAction_0() { return cParametersAction_0; }

		//params=ParameterList?
		public Assignment getParamsAssignment_1() { return cParamsAssignment_1; }

		//ParameterList
		public RuleCall getParamsParameterListParserRuleCall_1_0() { return cParamsParameterListParserRuleCall_1_0; }
	}

	public class ActionArgumentsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.ActionArguments");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cArgsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cArgsArgumentDefinitionParserRuleCall_0_0 = (RuleCall)cArgsAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cCommaKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cArgsAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cArgsArgumentDefinitionParserRuleCall_1_1_0 = (RuleCall)cArgsAssignment_1_1.eContents().get(0);
		
		//ActionArguments:
		//	args+=ArgumentDefinition (',' args+=ArgumentDefinition)*;
		@Override public ParserRule getRule() { return rule; }

		//args+=ArgumentDefinition (',' args+=ArgumentDefinition)*
		public Group getGroup() { return cGroup; }

		//args+=ArgumentDefinition
		public Assignment getArgsAssignment_0() { return cArgsAssignment_0; }

		//ArgumentDefinition
		public RuleCall getArgsArgumentDefinitionParserRuleCall_0_0() { return cArgsArgumentDefinitionParserRuleCall_0_0; }

		//(',' args+=ArgumentDefinition)*
		public Group getGroup_1() { return cGroup_1; }

		//','
		public Keyword getCommaKeyword_1_0() { return cCommaKeyword_1_0; }

		//args+=ArgumentDefinition
		public Assignment getArgsAssignment_1_1() { return cArgsAssignment_1_1; }

		//ArgumentDefinition
		public RuleCall getArgsArgumentDefinitionParserRuleCall_1_1_0() { return cArgsArgumentDefinitionParserRuleCall_1_1_0; }
	}

	public class ArgumentDefinitionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.ArgumentDefinition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cTypeAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cTypeTypeRefParserRuleCall_0_0 = (RuleCall)cTypeAssignment_0.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameValid_IDParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cLessThanSignHyphenMinusKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cDefaultAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cDefaultExpressionParserRuleCall_2_1_0 = (RuleCall)cDefaultAssignment_2_1.eContents().get(0);
		
		//ArgumentDefinition:
		//	type=TypeRef name=Valid_ID ('<-' default=Expression)?;
		@Override public ParserRule getRule() { return rule; }

		//type=TypeRef name=Valid_ID ('<-' default=Expression)?
		public Group getGroup() { return cGroup; }

		//type=TypeRef
		public Assignment getTypeAssignment_0() { return cTypeAssignment_0; }

		//TypeRef
		public RuleCall getTypeTypeRefParserRuleCall_0_0() { return cTypeTypeRefParserRuleCall_0_0; }

		//name=Valid_ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//Valid_ID
		public RuleCall getNameValid_IDParserRuleCall_1_0() { return cNameValid_IDParserRuleCall_1_0; }

		//('<-' default=Expression)?
		public Group getGroup_2() { return cGroup_2; }

		//'<-'
		public Keyword getLessThanSignHyphenMinusKeyword_2_0() { return cLessThanSignHyphenMinusKeyword_2_0; }

		//default=Expression
		public Assignment getDefaultAssignment_2_1() { return cDefaultAssignment_2_1; }

		//Expression
		public RuleCall getDefaultExpressionParserRuleCall_2_1_0() { return cDefaultExpressionParserRuleCall_2_1_0; }
	}

	public class FacetElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.Facet");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cDefinitionFacetParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cFunctionFacetParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cClassicFacetParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cTypeFacetParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cVarFacetParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cActionFacetParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		
		/// **
		// * Facets
		// * / Facet:
		//	DefinitionFacet | FunctionFacet | ClassicFacet | TypeFacet | VarFacet | ActionFacet;
		@Override public ParserRule getRule() { return rule; }

		//DefinitionFacet | FunctionFacet | ClassicFacet | TypeFacet | VarFacet | ActionFacet
		public Alternatives getAlternatives() { return cAlternatives; }

		//DefinitionFacet
		public RuleCall getDefinitionFacetParserRuleCall_0() { return cDefinitionFacetParserRuleCall_0; }

		//FunctionFacet
		public RuleCall getFunctionFacetParserRuleCall_1() { return cFunctionFacetParserRuleCall_1; }

		//ClassicFacet
		public RuleCall getClassicFacetParserRuleCall_2() { return cClassicFacetParserRuleCall_2; }

		//TypeFacet
		public RuleCall getTypeFacetParserRuleCall_3() { return cTypeFacetParserRuleCall_3; }

		//VarFacet
		public RuleCall getVarFacetParserRuleCall_4() { return cVarFacetParserRuleCall_4; }

		//ActionFacet
		public RuleCall getActionFacetParserRuleCall_5() { return cActionFacetParserRuleCall_5; }
	}

	public class FirstFacetKeyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.FirstFacetKey");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cDefinitionFacetKeyParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cTypeFacetKeyParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cSpecialFacetKeyParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cVarFacetKeyParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cActionFacetKeyParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cClassicFacetKeyParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		
		//FirstFacetKey:
		//	DefinitionFacetKey | TypeFacetKey | SpecialFacetKey | VarFacetKey | ActionFacetKey | ClassicFacetKey;
		@Override public ParserRule getRule() { return rule; }

		//DefinitionFacetKey | TypeFacetKey | SpecialFacetKey | VarFacetKey | ActionFacetKey | ClassicFacetKey
		public Alternatives getAlternatives() { return cAlternatives; }

		//DefinitionFacetKey
		public RuleCall getDefinitionFacetKeyParserRuleCall_0() { return cDefinitionFacetKeyParserRuleCall_0; }

		//TypeFacetKey
		public RuleCall getTypeFacetKeyParserRuleCall_1() { return cTypeFacetKeyParserRuleCall_1; }

		//SpecialFacetKey
		public RuleCall getSpecialFacetKeyParserRuleCall_2() { return cSpecialFacetKeyParserRuleCall_2; }

		//VarFacetKey
		public RuleCall getVarFacetKeyParserRuleCall_3() { return cVarFacetKeyParserRuleCall_3; }

		//ActionFacetKey
		public RuleCall getActionFacetKeyParserRuleCall_4() { return cActionFacetKeyParserRuleCall_4; }

		//ClassicFacetKey
		public RuleCall getClassicFacetKeyParserRuleCall_5() { return cClassicFacetKeyParserRuleCall_5; }
	}

	public class ClassicFacetKeyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.ClassicFacetKey");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//ClassicFacetKey:
		//	ID ':';
		@Override public ParserRule getRule() { return rule; }

		//ID ':'
		public Group getGroup() { return cGroup; }

		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }

		//':'
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }
	}

	public class DefinitionFacetKeyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.DefinitionFacetKey");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cNameKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cReturnsKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		
		//DefinitionFacetKey:
		//	"name:" | "returns:";
		@Override public ParserRule getRule() { return rule; }

		//"name:" | "returns:"
		public Alternatives getAlternatives() { return cAlternatives; }

		//"name:"
		public Keyword getNameKeyword_0() { return cNameKeyword_0; }

		//"returns:"
		public Keyword getReturnsKeyword_1() { return cReturnsKeyword_1; }
	}

	public class TypeFacetKeyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.TypeFacetKey");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cAsKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cOfKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cParentKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cSpeciesKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cTypeKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		
		/// *| "var:" * / TypeFacetKey:
		//	"as:" | "of:" | "parent:" | "species:" | "type:";
		@Override public ParserRule getRule() { return rule; }

		//"as:" | "of:" | "parent:" | "species:" | "type:"
		public Alternatives getAlternatives() { return cAlternatives; }

		//"as:"
		public Keyword getAsKeyword_0() { return cAsKeyword_0; }

		//"of:"
		public Keyword getOfKeyword_1() { return cOfKeyword_1; }

		//"parent:"
		public Keyword getParentKeyword_2() { return cParentKeyword_2; }

		//"species:"
		public Keyword getSpeciesKeyword_3() { return cSpeciesKeyword_3; }

		//"type:"
		public Keyword getTypeKeyword_4() { return cTypeKeyword_4; }
	}

	public class SpecialFacetKeyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.SpecialFacetKey");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cDataKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Keyword cWhenKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Keyword cColonKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Keyword cConstKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cValueKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cTopologyKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Keyword cItemKeyword_5 = (Keyword)cAlternatives.eContents().get(5);
		private final Keyword cInitKeyword_6 = (Keyword)cAlternatives.eContents().get(6);
		private final Keyword cMessageKeyword_7 = (Keyword)cAlternatives.eContents().get(7);
		private final Keyword cControlKeyword_8 = (Keyword)cAlternatives.eContents().get(8);
		private final Keyword cEnvironmentKeyword_9 = (Keyword)cAlternatives.eContents().get(9);
		private final Keyword cTextKeyword_10 = (Keyword)cAlternatives.eContents().get(10);
		private final Keyword cImageKeyword_11 = (Keyword)cAlternatives.eContents().get(11);
		private final Keyword cUsingKeyword_12 = (Keyword)cAlternatives.eContents().get(12);
		private final Keyword cParameterKeyword_13 = (Keyword)cAlternatives.eContents().get(13);
		private final Keyword cAspectKeyword_14 = (Keyword)cAlternatives.eContents().get(14);
		private final Keyword cLightKeyword_15 = (Keyword)cAlternatives.eContents().get(15);
		
		//SpecialFacetKey:
		//	'data:' | 'when' ':' | "const:" | "value:" | "topology:" | "item:" | "init:" | "message:" | "control:" |
		//	"environment:" | 'text:' | 'image:' | 'using:' | "parameter:" | "aspect:" | "light:";
		@Override public ParserRule getRule() { return rule; }

		//'data:' | 'when' ':' | "const:" | "value:" | "topology:" | "item:" | "init:" | "message:" | "control:" | "environment:"
		//| 'text:' | 'image:' | 'using:' | "parameter:" | "aspect:" | "light:"
		public Alternatives getAlternatives() { return cAlternatives; }

		//'data:'
		public Keyword getDataKeyword_0() { return cDataKeyword_0; }

		//'when' ':'
		public Group getGroup_1() { return cGroup_1; }

		//'when'
		public Keyword getWhenKeyword_1_0() { return cWhenKeyword_1_0; }

		//':'
		public Keyword getColonKeyword_1_1() { return cColonKeyword_1_1; }

		//"const:"
		public Keyword getConstKeyword_2() { return cConstKeyword_2; }

		//"value:"
		public Keyword getValueKeyword_3() { return cValueKeyword_3; }

		//"topology:"
		public Keyword getTopologyKeyword_4() { return cTopologyKeyword_4; }

		//"item:"
		public Keyword getItemKeyword_5() { return cItemKeyword_5; }

		//"init:"
		public Keyword getInitKeyword_6() { return cInitKeyword_6; }

		//"message:"
		public Keyword getMessageKeyword_7() { return cMessageKeyword_7; }

		//"control:"
		public Keyword getControlKeyword_8() { return cControlKeyword_8; }

		//"environment:"
		public Keyword getEnvironmentKeyword_9() { return cEnvironmentKeyword_9; }

		//'text:'
		public Keyword getTextKeyword_10() { return cTextKeyword_10; }

		//'image:'
		public Keyword getImageKeyword_11() { return cImageKeyword_11; }

		//'using:'
		public Keyword getUsingKeyword_12() { return cUsingKeyword_12; }

		//"parameter:"
		public Keyword getParameterKeyword_13() { return cParameterKeyword_13; }

		//"aspect:"
		public Keyword getAspectKeyword_14() { return cAspectKeyword_14; }

		//"light:"
		public Keyword getLightKeyword_15() { return cLightKeyword_15; }
	}

	public class ActionFacetKeyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.ActionFacetKey");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cActionKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cOn_changeKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		
		//ActionFacetKey:
		//	"action:" | "on_change:";
		@Override public ParserRule getRule() { return rule; }

		//"action:" | "on_change:"
		public Alternatives getAlternatives() { return cAlternatives; }

		//"action:"
		public Keyword getActionKeyword_0() { return cActionKeyword_0; }

		//"on_change:"
		public Keyword getOn_changeKeyword_1() { return cOn_changeKeyword_1; }
	}

	public class VarFacetKeyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.VarFacetKey");
		private final Keyword cVarKeyword = (Keyword)rule.eContents().get(1);
		
		//VarFacetKey:
		//	"var:";
		@Override public ParserRule getRule() { return rule; }

		//"var:"
		public Keyword getVarKeyword() { return cVarKeyword; }
	}

	public class ClassicFacetElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.ClassicFacet");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Assignment cKeyAssignment_0_0 = (Assignment)cAlternatives_0.eContents().get(0);
		private final RuleCall cKeyClassicFacetKeyParserRuleCall_0_0_0 = (RuleCall)cKeyAssignment_0_0.eContents().get(0);
		private final Assignment cKeyAssignment_0_1 = (Assignment)cAlternatives_0.eContents().get(1);
		private final Keyword cKeyLessThanSignHyphenMinusKeyword_0_1_0 = (Keyword)cKeyAssignment_0_1.eContents().get(0);
		private final Assignment cKeyAssignment_0_2 = (Assignment)cAlternatives_0.eContents().get(2);
		private final RuleCall cKeySpecialFacetKeyParserRuleCall_0_2_0 = (RuleCall)cKeyAssignment_0_2.eContents().get(0);
		private final Assignment cExprAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cExprExpressionParserRuleCall_1_0 = (RuleCall)cExprAssignment_1.eContents().get(0);
		
		//ClassicFacet Facet:
		//	(key=ClassicFacetKey | key='<-' | key=SpecialFacetKey) expr=Expression
		@Override public ParserRule getRule() { return rule; }

		//(key=ClassicFacetKey | key='<-' | key=SpecialFacetKey) expr=Expression
		public Group getGroup() { return cGroup; }

		//(key=ClassicFacetKey | key='<-' | key=SpecialFacetKey)
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//key=ClassicFacetKey
		public Assignment getKeyAssignment_0_0() { return cKeyAssignment_0_0; }

		//ClassicFacetKey
		public RuleCall getKeyClassicFacetKeyParserRuleCall_0_0_0() { return cKeyClassicFacetKeyParserRuleCall_0_0_0; }

		//key='<-'
		public Assignment getKeyAssignment_0_1() { return cKeyAssignment_0_1; }

		//'<-'
		public Keyword getKeyLessThanSignHyphenMinusKeyword_0_1_0() { return cKeyLessThanSignHyphenMinusKeyword_0_1_0; }

		//key=SpecialFacetKey
		public Assignment getKeyAssignment_0_2() { return cKeyAssignment_0_2; }

		//SpecialFacetKey
		public RuleCall getKeySpecialFacetKeyParserRuleCall_0_2_0() { return cKeySpecialFacetKeyParserRuleCall_0_2_0; }

		//expr=Expression
		public Assignment getExprAssignment_1() { return cExprAssignment_1; }

		//Expression
		public RuleCall getExprExpressionParserRuleCall_1_0() { return cExprExpressionParserRuleCall_1_0; }
	}

	public class DefinitionFacetElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.DefinitionFacet");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cKeyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cKeyDefinitionFacetKeyParserRuleCall_0_0 = (RuleCall)cKeyAssignment_0.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Alternatives cNameAlternatives_1_0 = (Alternatives)cNameAssignment_1.eContents().get(0);
		private final RuleCall cNameValid_IDParserRuleCall_1_0_0 = (RuleCall)cNameAlternatives_1_0.eContents().get(0);
		private final RuleCall cNameSTRINGTerminalRuleCall_1_0_1 = (RuleCall)cNameAlternatives_1_0.eContents().get(1);
		
		//DefinitionFacet Facet:
		//	=> key=DefinitionFacetKey name=(Valid_ID | STRING)
		@Override public ParserRule getRule() { return rule; }

		//=> key=DefinitionFacetKey name=(Valid_ID | STRING)
		public Group getGroup() { return cGroup; }

		//=> key=DefinitionFacetKey
		public Assignment getKeyAssignment_0() { return cKeyAssignment_0; }

		//DefinitionFacetKey
		public RuleCall getKeyDefinitionFacetKeyParserRuleCall_0_0() { return cKeyDefinitionFacetKeyParserRuleCall_0_0; }

		//name=(Valid_ID | STRING)
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//(Valid_ID | STRING)
		public Alternatives getNameAlternatives_1_0() { return cNameAlternatives_1_0; }

		//Valid_ID
		public RuleCall getNameValid_IDParserRuleCall_1_0_0() { return cNameValid_IDParserRuleCall_1_0_0; }

		//STRING
		public RuleCall getNameSTRINGTerminalRuleCall_1_0_1() { return cNameSTRINGTerminalRuleCall_1_0_1; }
	}

	public class FunctionFacetElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.FunctionFacet");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Assignment cKeyAssignment_0_0 = (Assignment)cAlternatives_0.eContents().get(0);
		private final Keyword cKeyFunctionKeyword_0_0_0 = (Keyword)cKeyAssignment_0_0.eContents().get(0);
		private final Assignment cKeyAssignment_0_1 = (Assignment)cAlternatives_0.eContents().get(1);
		private final Keyword cKeyHyphenMinusGreaterThanSignKeyword_0_1_0 = (Keyword)cKeyAssignment_0_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cExprAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cExprExpressionParserRuleCall_2_0 = (RuleCall)cExprAssignment_2.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//FunctionFacet Facet:
		//	(key='function:' | key='->') '{' expr=Expression '}'
		@Override public ParserRule getRule() { return rule; }

		//(key='function:' | key='->') '{' expr=Expression '}'
		public Group getGroup() { return cGroup; }

		//(key='function:' | key='->')
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//key='function:'
		public Assignment getKeyAssignment_0_0() { return cKeyAssignment_0_0; }

		//'function:'
		public Keyword getKeyFunctionKeyword_0_0_0() { return cKeyFunctionKeyword_0_0_0; }

		//key='->'
		public Assignment getKeyAssignment_0_1() { return cKeyAssignment_0_1; }

		//'->'
		public Keyword getKeyHyphenMinusGreaterThanSignKeyword_0_1_0() { return cKeyHyphenMinusGreaterThanSignKeyword_0_1_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_1() { return cLeftCurlyBracketKeyword_1; }

		//expr=Expression
		public Assignment getExprAssignment_2() { return cExprAssignment_2; }

		//Expression
		public RuleCall getExprExpressionParserRuleCall_2_0() { return cExprExpressionParserRuleCall_2_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_3() { return cRightCurlyBracketKeyword_3; }
	}

	public class TypeFacetElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.TypeFacet");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cKeyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cKeyTypeFacetKeyParserRuleCall_0_0 = (RuleCall)cKeyAssignment_0.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cAlternatives_1.eContents().get(0);
		private final Assignment cExprAssignment_1_0_0 = (Assignment)cGroup_1_0.eContents().get(0);
		private final RuleCall cExprTypeRefParserRuleCall_1_0_0_0 = (RuleCall)cExprAssignment_1_0_0.eContents().get(0);
		private final Assignment cExprAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final RuleCall cExprExpressionParserRuleCall_1_1_0 = (RuleCall)cExprAssignment_1_1.eContents().get(0);
		
		//TypeFacet Facet:
		//	key=TypeFacetKey (=> (expr=TypeRef) | expr=Expression)
		@Override public ParserRule getRule() { return rule; }

		//key=TypeFacetKey (=> (expr=TypeRef) | expr=Expression)
		public Group getGroup() { return cGroup; }

		//key=TypeFacetKey
		public Assignment getKeyAssignment_0() { return cKeyAssignment_0; }

		//TypeFacetKey
		public RuleCall getKeyTypeFacetKeyParserRuleCall_0_0() { return cKeyTypeFacetKeyParserRuleCall_0_0; }

		//(=> (expr=TypeRef) | expr=Expression)
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//=> (expr=TypeRef)
		public Group getGroup_1_0() { return cGroup_1_0; }

		//expr=TypeRef
		public Assignment getExprAssignment_1_0_0() { return cExprAssignment_1_0_0; }

		//TypeRef
		public RuleCall getExprTypeRefParserRuleCall_1_0_0_0() { return cExprTypeRefParserRuleCall_1_0_0_0; }

		//expr=Expression
		public Assignment getExprAssignment_1_1() { return cExprAssignment_1_1; }

		//Expression
		public RuleCall getExprExpressionParserRuleCall_1_1_0() { return cExprExpressionParserRuleCall_1_1_0; }
	}

	public class ActionFacetElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.ActionFacet");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cKeyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cKeyActionFacetKeyParserRuleCall_0_0 = (RuleCall)cKeyAssignment_0.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cExprAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final RuleCall cExprActionRefParserRuleCall_1_0_0 = (RuleCall)cExprAssignment_1_0.eContents().get(0);
		private final Assignment cBlockAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final RuleCall cBlockBlockParserRuleCall_1_1_0 = (RuleCall)cBlockAssignment_1_1.eContents().get(0);
		
		//ActionFacet Facet:
		//	key=ActionFacetKey (expr=ActionRef | block=Block)
		@Override public ParserRule getRule() { return rule; }

		//key=ActionFacetKey (expr=ActionRef | block=Block)
		public Group getGroup() { return cGroup; }

		//key=ActionFacetKey
		public Assignment getKeyAssignment_0() { return cKeyAssignment_0; }

		//ActionFacetKey
		public RuleCall getKeyActionFacetKeyParserRuleCall_0_0() { return cKeyActionFacetKeyParserRuleCall_0_0; }

		//(expr=ActionRef | block=Block)
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//expr=ActionRef
		public Assignment getExprAssignment_1_0() { return cExprAssignment_1_0; }

		//ActionRef
		public RuleCall getExprActionRefParserRuleCall_1_0_0() { return cExprActionRefParserRuleCall_1_0_0; }

		//block=Block
		public Assignment getBlockAssignment_1_1() { return cBlockAssignment_1_1; }

		//Block
		public RuleCall getBlockBlockParserRuleCall_1_1_0() { return cBlockBlockParserRuleCall_1_1_0; }
	}

	public class VarFacetElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.VarFacet");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cKeyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cKeyVarFacetKeyParserRuleCall_0_0 = (RuleCall)cKeyAssignment_0.eContents().get(0);
		private final Assignment cExprAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cExprVariableRefParserRuleCall_1_0 = (RuleCall)cExprAssignment_1.eContents().get(0);
		
		//VarFacet Facet:
		//	key=VarFacetKey expr=VariableRef
		@Override public ParserRule getRule() { return rule; }

		//key=VarFacetKey expr=VariableRef
		public Group getGroup() { return cGroup; }

		//key=VarFacetKey
		public Assignment getKeyAssignment_0() { return cKeyAssignment_0; }

		//VarFacetKey
		public RuleCall getKeyVarFacetKeyParserRuleCall_0_0() { return cKeyVarFacetKeyParserRuleCall_0_0; }

		//expr=VariableRef
		public Assignment getExprAssignment_1() { return cExprAssignment_1; }

		//VariableRef
		public RuleCall getExprVariableRefParserRuleCall_1_0() { return cExprVariableRefParserRuleCall_1_0; }
	}

	public class BlockElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.Block");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cBlockAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Group cGroup_2_0 = (Group)cAlternatives_2.eContents().get(0);
		private final Group cGroup_2_0_0 = (Group)cGroup_2_0.eContents().get(0);
		private final Assignment cFunctionAssignment_2_0_0_0 = (Assignment)cGroup_2_0_0.eContents().get(0);
		private final RuleCall cFunctionExpressionParserRuleCall_2_0_0_0_0 = (RuleCall)cFunctionAssignment_2_0_0_0.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_2_0_0_1 = (Keyword)cGroup_2_0_0.eContents().get(1);
		private final Group cGroup_2_1 = (Group)cAlternatives_2.eContents().get(1);
		private final Assignment cStatementsAssignment_2_1_0 = (Assignment)cGroup_2_1.eContents().get(0);
		private final RuleCall cStatementsStatementParserRuleCall_2_1_0_0 = (RuleCall)cStatementsAssignment_2_1_0.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_2_1_1 = (Keyword)cGroup_2_1.eContents().get(1);
		
		/// **
		// * Blocks. An ordered list of statements inside curly brackets
		// * / Block:
		//	{Block} '{' (=> (function=Expression '}') | statements+=Statement* '}');
		@Override public ParserRule getRule() { return rule; }

		//{Block} '{' (=> (function=Expression '}') | statements+=Statement* '}')
		public Group getGroup() { return cGroup; }

		//{Block}
		public Action getBlockAction_0() { return cBlockAction_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_1() { return cLeftCurlyBracketKeyword_1; }

		//(=> (function=Expression '}') | statements+=Statement* '}')
		public Alternatives getAlternatives_2() { return cAlternatives_2; }

		//=> (function=Expression '}')
		public Group getGroup_2_0() { return cGroup_2_0; }

		//(function=Expression '}')
		public Group getGroup_2_0_0() { return cGroup_2_0_0; }

		//function=Expression
		public Assignment getFunctionAssignment_2_0_0_0() { return cFunctionAssignment_2_0_0_0; }

		//Expression
		public RuleCall getFunctionExpressionParserRuleCall_2_0_0_0_0() { return cFunctionExpressionParserRuleCall_2_0_0_0_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_2_0_0_1() { return cRightCurlyBracketKeyword_2_0_0_1; }

		//statements+=Statement* '}'
		public Group getGroup_2_1() { return cGroup_2_1; }

		//statements+=Statement*
		public Assignment getStatementsAssignment_2_1_0() { return cStatementsAssignment_2_1_0; }

		//Statement
		public RuleCall getStatementsStatementParserRuleCall_2_1_0_0() { return cStatementsStatementParserRuleCall_2_1_0_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_2_1_1() { return cRightCurlyBracketKeyword_2_1_1; }
	}

	public class ExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.Expression");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cArgumentPairParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cPairParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		/// **
		// * Expressions
		// * / Expression:
		//	ArgumentPair | Pair;
		@Override public ParserRule getRule() { return rule; }

		//ArgumentPair | Pair
		public Alternatives getAlternatives() { return cAlternatives; }

		//ArgumentPair
		public RuleCall getArgumentPairParserRuleCall_0() { return cArgumentPairParserRuleCall_0; }

		//Pair
		public RuleCall getPairParserRuleCall_1() { return cPairParserRuleCall_1; }
	}

	public class ArgumentPairElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.ArgumentPair");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_0_0 = (Alternatives)cGroup_0.eContents().get(0);
		private final Group cGroup_0_0_0 = (Group)cAlternatives_0_0.eContents().get(0);
		private final Assignment cOpAssignment_0_0_0_0 = (Assignment)cGroup_0_0_0.eContents().get(0);
		private final RuleCall cOpValid_IDParserRuleCall_0_0_0_0_0 = (RuleCall)cOpAssignment_0_0_0_0.eContents().get(0);
		private final Keyword cColonColonKeyword_0_0_0_1 = (Keyword)cGroup_0_0_0.eContents().get(1);
		private final Group cGroup_0_0_1 = (Group)cAlternatives_0_0.eContents().get(1);
		private final Assignment cOpAssignment_0_0_1_0 = (Assignment)cGroup_0_0_1.eContents().get(0);
		private final Alternatives cOpAlternatives_0_0_1_0_0 = (Alternatives)cOpAssignment_0_0_1_0.eContents().get(0);
		private final RuleCall cOpDefinitionFacetKeyParserRuleCall_0_0_1_0_0_0 = (RuleCall)cOpAlternatives_0_0_1_0_0.eContents().get(0);
		private final RuleCall cOpTypeFacetKeyParserRuleCall_0_0_1_0_0_1 = (RuleCall)cOpAlternatives_0_0_1_0_0.eContents().get(1);
		private final RuleCall cOpSpecialFacetKeyParserRuleCall_0_0_1_0_0_2 = (RuleCall)cOpAlternatives_0_0_1_0_0.eContents().get(2);
		private final RuleCall cOpActionFacetKeyParserRuleCall_0_0_1_0_0_3 = (RuleCall)cOpAlternatives_0_0_1_0_0.eContents().get(3);
		private final RuleCall cOpVarFacetKeyParserRuleCall_0_0_1_0_0_4 = (RuleCall)cOpAlternatives_0_0_1_0_0.eContents().get(4);
		private final Keyword cColonKeyword_0_0_1_1 = (Keyword)cGroup_0_0_1.eContents().get(1);
		private final Assignment cRightAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cRightIfParserRuleCall_1_0 = (RuleCall)cRightAssignment_1.eContents().get(0);
		
		//ArgumentPair:
		//	=> (op=Valid_ID '::' | op=(DefinitionFacetKey | TypeFacetKey | SpecialFacetKey | ActionFacetKey | VarFacetKey) ':')?
		//	right=If;
		@Override public ParserRule getRule() { return rule; }

		//=> (op=Valid_ID '::' | op=(DefinitionFacetKey | TypeFacetKey | SpecialFacetKey | ActionFacetKey | VarFacetKey) ':')?
		//right=If
		public Group getGroup() { return cGroup; }

		//=> (op=Valid_ID '::' | op=(DefinitionFacetKey | TypeFacetKey | SpecialFacetKey | ActionFacetKey | VarFacetKey) ':')?
		public Group getGroup_0() { return cGroup_0; }

		//(op=Valid_ID '::' | op=(DefinitionFacetKey | TypeFacetKey | SpecialFacetKey | ActionFacetKey | VarFacetKey) ':')
		public Alternatives getAlternatives_0_0() { return cAlternatives_0_0; }

		//op=Valid_ID '::'
		public Group getGroup_0_0_0() { return cGroup_0_0_0; }

		//op=Valid_ID
		public Assignment getOpAssignment_0_0_0_0() { return cOpAssignment_0_0_0_0; }

		//Valid_ID
		public RuleCall getOpValid_IDParserRuleCall_0_0_0_0_0() { return cOpValid_IDParserRuleCall_0_0_0_0_0; }

		//'::'
		public Keyword getColonColonKeyword_0_0_0_1() { return cColonColonKeyword_0_0_0_1; }

		//op=(DefinitionFacetKey | TypeFacetKey | SpecialFacetKey | ActionFacetKey | VarFacetKey) ':'
		public Group getGroup_0_0_1() { return cGroup_0_0_1; }

		//op=(DefinitionFacetKey | TypeFacetKey | SpecialFacetKey | ActionFacetKey | VarFacetKey)
		public Assignment getOpAssignment_0_0_1_0() { return cOpAssignment_0_0_1_0; }

		//(DefinitionFacetKey | TypeFacetKey | SpecialFacetKey | ActionFacetKey | VarFacetKey)
		public Alternatives getOpAlternatives_0_0_1_0_0() { return cOpAlternatives_0_0_1_0_0; }

		//DefinitionFacetKey
		public RuleCall getOpDefinitionFacetKeyParserRuleCall_0_0_1_0_0_0() { return cOpDefinitionFacetKeyParserRuleCall_0_0_1_0_0_0; }

		//TypeFacetKey
		public RuleCall getOpTypeFacetKeyParserRuleCall_0_0_1_0_0_1() { return cOpTypeFacetKeyParserRuleCall_0_0_1_0_0_1; }

		//SpecialFacetKey
		public RuleCall getOpSpecialFacetKeyParserRuleCall_0_0_1_0_0_2() { return cOpSpecialFacetKeyParserRuleCall_0_0_1_0_0_2; }

		//ActionFacetKey
		public RuleCall getOpActionFacetKeyParserRuleCall_0_0_1_0_0_3() { return cOpActionFacetKeyParserRuleCall_0_0_1_0_0_3; }

		//VarFacetKey
		public RuleCall getOpVarFacetKeyParserRuleCall_0_0_1_0_0_4() { return cOpVarFacetKeyParserRuleCall_0_0_1_0_0_4; }

		//':'
		public Keyword getColonKeyword_0_0_1_1() { return cColonKeyword_0_0_1_1; }

		//right=If
		public Assignment getRightAssignment_1() { return cRightAssignment_1; }

		//If
		public RuleCall getRightIfParserRuleCall_1_0() { return cRightIfParserRuleCall_1_0; }
	}

	public class PairElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.Pair");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cIfParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Action cPairLeftAction_1_0_0 = (Action)cGroup_1_0.eContents().get(0);
		private final Assignment cOpAssignment_1_0_1 = (Assignment)cGroup_1_0.eContents().get(1);
		private final Keyword cOpColonColonKeyword_1_0_1_0 = (Keyword)cOpAssignment_1_0_1.eContents().get(0);
		private final Assignment cRightAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightIfParserRuleCall_1_1_0 = (RuleCall)cRightAssignment_1_1.eContents().get(0);
		
		//Pair Expression:
		//	If (({Pair.left=current} op='::') right=If)?
		@Override public ParserRule getRule() { return rule; }

		//If (({Pair.left=current} op='::') right=If)?
		public Group getGroup() { return cGroup; }

		//If
		public RuleCall getIfParserRuleCall_0() { return cIfParserRuleCall_0; }

		//(({Pair.left=current} op='::') right=If)?
		public Group getGroup_1() { return cGroup_1; }

		//({Pair.left=current} op='::')
		public Group getGroup_1_0() { return cGroup_1_0; }

		//{Pair.left=current}
		public Action getPairLeftAction_1_0_0() { return cPairLeftAction_1_0_0; }

		//op='::'
		public Assignment getOpAssignment_1_0_1() { return cOpAssignment_1_0_1; }

		//'::'
		public Keyword getOpColonColonKeyword_1_0_1_0() { return cOpColonColonKeyword_1_0_1_0; }

		//right=If
		public Assignment getRightAssignment_1_1() { return cRightAssignment_1_1; }

		//If
		public RuleCall getRightIfParserRuleCall_1_1_0() { return cRightIfParserRuleCall_1_1_0; }
	}

	public class IfElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.If");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cOrParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cIfLeftAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Assignment cOpAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final Keyword cOpQuestionMarkKeyword_1_1_0 = (Keyword)cOpAssignment_1_1.eContents().get(0);
		private final Assignment cRightAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cRightOrParserRuleCall_1_2_0 = (RuleCall)cRightAssignment_1_2.eContents().get(0);
		private final Group cGroup_1_3 = (Group)cGroup_1.eContents().get(3);
		private final Keyword cColonKeyword_1_3_0 = (Keyword)cGroup_1_3.eContents().get(0);
		private final Assignment cIfFalseAssignment_1_3_1 = (Assignment)cGroup_1_3.eContents().get(1);
		private final RuleCall cIfFalseOrParserRuleCall_1_3_1_0 = (RuleCall)cIfFalseAssignment_1_3_1.eContents().get(0);
		
		//If Expression:
		//	Or ({If.left=current} op='?'
		//	right=Or (':'
		//	ifFalse=Or))?
		@Override public ParserRule getRule() { return rule; }

		//Or ({If.left=current} op='?' right=Or (':' ifFalse=Or))?
		public Group getGroup() { return cGroup; }

		//Or
		public RuleCall getOrParserRuleCall_0() { return cOrParserRuleCall_0; }

		//({If.left=current} op='?' right=Or (':' ifFalse=Or))?
		public Group getGroup_1() { return cGroup_1; }

		//{If.left=current}
		public Action getIfLeftAction_1_0() { return cIfLeftAction_1_0; }

		//op='?'
		public Assignment getOpAssignment_1_1() { return cOpAssignment_1_1; }

		//'?'
		public Keyword getOpQuestionMarkKeyword_1_1_0() { return cOpQuestionMarkKeyword_1_1_0; }

		//right=Or
		public Assignment getRightAssignment_1_2() { return cRightAssignment_1_2; }

		//Or
		public RuleCall getRightOrParserRuleCall_1_2_0() { return cRightOrParserRuleCall_1_2_0; }

		//(':' ifFalse=Or)
		public Group getGroup_1_3() { return cGroup_1_3; }

		//':'
		public Keyword getColonKeyword_1_3_0() { return cColonKeyword_1_3_0; }

		//ifFalse=Or
		public Assignment getIfFalseAssignment_1_3_1() { return cIfFalseAssignment_1_3_1; }

		//Or
		public RuleCall getIfFalseOrParserRuleCall_1_3_1_0() { return cIfFalseOrParserRuleCall_1_3_1_0; }
	}

	public class OrElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.Or");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cAndParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cExpressionLeftAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Assignment cOpAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final Keyword cOpOrKeyword_1_1_0 = (Keyword)cOpAssignment_1_1.eContents().get(0);
		private final Assignment cRightAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cRightAndParserRuleCall_1_2_0 = (RuleCall)cRightAssignment_1_2.eContents().get(0);
		
		//Or Expression:
		//	And ({Expression.left=current} op='or'
		//	right=And)*
		@Override public ParserRule getRule() { return rule; }

		//And ({Expression.left=current} op='or' right=And)*
		public Group getGroup() { return cGroup; }

		//And
		public RuleCall getAndParserRuleCall_0() { return cAndParserRuleCall_0; }

		//({Expression.left=current} op='or' right=And)*
		public Group getGroup_1() { return cGroup_1; }

		//{Expression.left=current}
		public Action getExpressionLeftAction_1_0() { return cExpressionLeftAction_1_0; }

		//op='or'
		public Assignment getOpAssignment_1_1() { return cOpAssignment_1_1; }

		//'or'
		public Keyword getOpOrKeyword_1_1_0() { return cOpOrKeyword_1_1_0; }

		//right=And
		public Assignment getRightAssignment_1_2() { return cRightAssignment_1_2; }

		//And
		public RuleCall getRightAndParserRuleCall_1_2_0() { return cRightAndParserRuleCall_1_2_0; }
	}

	public class AndElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.And");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cCastParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cExpressionLeftAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Assignment cOpAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final Keyword cOpAndKeyword_1_1_0 = (Keyword)cOpAssignment_1_1.eContents().get(0);
		private final Assignment cRightAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cRightCastParserRuleCall_1_2_0 = (RuleCall)cRightAssignment_1_2.eContents().get(0);
		
		//And Expression:
		//	Cast ({Expression.left=current} op='and'
		//	right=Cast)*
		@Override public ParserRule getRule() { return rule; }

		//Cast ({Expression.left=current} op='and' right=Cast)*
		public Group getGroup() { return cGroup; }

		//Cast
		public RuleCall getCastParserRuleCall_0() { return cCastParserRuleCall_0; }

		//({Expression.left=current} op='and' right=Cast)*
		public Group getGroup_1() { return cGroup_1; }

		//{Expression.left=current}
		public Action getExpressionLeftAction_1_0() { return cExpressionLeftAction_1_0; }

		//op='and'
		public Assignment getOpAssignment_1_1() { return cOpAssignment_1_1; }

		//'and'
		public Keyword getOpAndKeyword_1_1_0() { return cOpAndKeyword_1_1_0; }

		//right=Cast
		public Assignment getRightAssignment_1_2() { return cRightAssignment_1_2; }

		//Cast
		public RuleCall getRightCastParserRuleCall_1_2_0() { return cRightCastParserRuleCall_1_2_0; }
	}

	public class CastElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.Cast");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cComparisonParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Action cCastLeftAction_1_0_0 = (Action)cGroup_1_0.eContents().get(0);
		private final Assignment cOpAssignment_1_0_1 = (Assignment)cGroup_1_0.eContents().get(1);
		private final Keyword cOpAsKeyword_1_0_1_0 = (Keyword)cOpAssignment_1_0_1.eContents().get(0);
		private final Alternatives cAlternatives_1_1 = (Alternatives)cGroup_1.eContents().get(1);
		private final Assignment cRightAssignment_1_1_0 = (Assignment)cAlternatives_1_1.eContents().get(0);
		private final RuleCall cRightTypeRefParserRuleCall_1_1_0_0 = (RuleCall)cRightAssignment_1_1_0.eContents().get(0);
		private final Group cGroup_1_1_1 = (Group)cAlternatives_1_1.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_1_1_1_0 = (Keyword)cGroup_1_1_1.eContents().get(0);
		private final Assignment cRightAssignment_1_1_1_1 = (Assignment)cGroup_1_1_1.eContents().get(1);
		private final RuleCall cRightTypeRefParserRuleCall_1_1_1_1_0 = (RuleCall)cRightAssignment_1_1_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_1_1_1_2 = (Keyword)cGroup_1_1_1.eContents().get(2);
		
		//Cast Expression:
		//	Comparison (({Cast.left=current} op='as') (right=TypeRef | '(' right=TypeRef ')'))?
		@Override public ParserRule getRule() { return rule; }

		//Comparison (({Cast.left=current} op='as') (right=TypeRef | '(' right=TypeRef ')'))?
		public Group getGroup() { return cGroup; }

		//Comparison
		public RuleCall getComparisonParserRuleCall_0() { return cComparisonParserRuleCall_0; }

		//(({Cast.left=current} op='as') (right=TypeRef | '(' right=TypeRef ')'))?
		public Group getGroup_1() { return cGroup_1; }

		//({Cast.left=current} op='as')
		public Group getGroup_1_0() { return cGroup_1_0; }

		//{Cast.left=current}
		public Action getCastLeftAction_1_0_0() { return cCastLeftAction_1_0_0; }

		//op='as'
		public Assignment getOpAssignment_1_0_1() { return cOpAssignment_1_0_1; }

		//'as'
		public Keyword getOpAsKeyword_1_0_1_0() { return cOpAsKeyword_1_0_1_0; }

		//(right=TypeRef | '(' right=TypeRef ')')
		public Alternatives getAlternatives_1_1() { return cAlternatives_1_1; }

		//right=TypeRef
		public Assignment getRightAssignment_1_1_0() { return cRightAssignment_1_1_0; }

		//TypeRef
		public RuleCall getRightTypeRefParserRuleCall_1_1_0_0() { return cRightTypeRefParserRuleCall_1_1_0_0; }

		//'(' right=TypeRef ')'
		public Group getGroup_1_1_1() { return cGroup_1_1_1; }

		//'('
		public Keyword getLeftParenthesisKeyword_1_1_1_0() { return cLeftParenthesisKeyword_1_1_1_0; }

		//right=TypeRef
		public Assignment getRightAssignment_1_1_1_1() { return cRightAssignment_1_1_1_1; }

		//TypeRef
		public RuleCall getRightTypeRefParserRuleCall_1_1_1_1_0() { return cRightTypeRefParserRuleCall_1_1_1_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_1_1_1_2() { return cRightParenthesisKeyword_1_1_1_2; }
	}

	public class ComparisonElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.Comparison");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cAdditionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Action cExpressionLeftAction_1_0_0 = (Action)cGroup_1_0.eContents().get(0);
		private final Assignment cOpAssignment_1_0_1 = (Assignment)cGroup_1_0.eContents().get(1);
		private final Alternatives cOpAlternatives_1_0_1_0 = (Alternatives)cOpAssignment_1_0_1.eContents().get(0);
		private final Keyword cOpExclamationMarkEqualsSignKeyword_1_0_1_0_0 = (Keyword)cOpAlternatives_1_0_1_0.eContents().get(0);
		private final Keyword cOpEqualsSignKeyword_1_0_1_0_1 = (Keyword)cOpAlternatives_1_0_1_0.eContents().get(1);
		private final Keyword cOpGreaterThanSignEqualsSignKeyword_1_0_1_0_2 = (Keyword)cOpAlternatives_1_0_1_0.eContents().get(2);
		private final Keyword cOpLessThanSignEqualsSignKeyword_1_0_1_0_3 = (Keyword)cOpAlternatives_1_0_1_0.eContents().get(3);
		private final Keyword cOpLessThanSignKeyword_1_0_1_0_4 = (Keyword)cOpAlternatives_1_0_1_0.eContents().get(4);
		private final Keyword cOpGreaterThanSignKeyword_1_0_1_0_5 = (Keyword)cOpAlternatives_1_0_1_0.eContents().get(5);
		private final Assignment cRightAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightAdditionParserRuleCall_1_1_0 = (RuleCall)cRightAssignment_1_1.eContents().get(0);
		
		//Comparison Expression:
		//	Addition (({Expression.left=current} op=('!=' | '=' | '>=' | '<=' | '<' | '>')) right=Addition)?
		@Override public ParserRule getRule() { return rule; }

		//Addition (({Expression.left=current} op=('!=' | '=' | '>=' | '<=' | '<' | '>')) right=Addition)?
		public Group getGroup() { return cGroup; }

		//Addition
		public RuleCall getAdditionParserRuleCall_0() { return cAdditionParserRuleCall_0; }

		//(({Expression.left=current} op=('!=' | '=' | '>=' | '<=' | '<' | '>')) right=Addition)?
		public Group getGroup_1() { return cGroup_1; }

		//({Expression.left=current} op=('!=' | '=' | '>=' | '<=' | '<' | '>'))
		public Group getGroup_1_0() { return cGroup_1_0; }

		//{Expression.left=current}
		public Action getExpressionLeftAction_1_0_0() { return cExpressionLeftAction_1_0_0; }

		//op=('!=' | '=' | '>=' | '<=' | '<' | '>')
		public Assignment getOpAssignment_1_0_1() { return cOpAssignment_1_0_1; }

		//('!=' | '=' | '>=' | '<=' | '<' | '>')
		public Alternatives getOpAlternatives_1_0_1_0() { return cOpAlternatives_1_0_1_0; }

		//'!='
		public Keyword getOpExclamationMarkEqualsSignKeyword_1_0_1_0_0() { return cOpExclamationMarkEqualsSignKeyword_1_0_1_0_0; }

		//'='
		public Keyword getOpEqualsSignKeyword_1_0_1_0_1() { return cOpEqualsSignKeyword_1_0_1_0_1; }

		//'>='
		public Keyword getOpGreaterThanSignEqualsSignKeyword_1_0_1_0_2() { return cOpGreaterThanSignEqualsSignKeyword_1_0_1_0_2; }

		//'<='
		public Keyword getOpLessThanSignEqualsSignKeyword_1_0_1_0_3() { return cOpLessThanSignEqualsSignKeyword_1_0_1_0_3; }

		//'<'
		public Keyword getOpLessThanSignKeyword_1_0_1_0_4() { return cOpLessThanSignKeyword_1_0_1_0_4; }

		//'>'
		public Keyword getOpGreaterThanSignKeyword_1_0_1_0_5() { return cOpGreaterThanSignKeyword_1_0_1_0_5; }

		//right=Addition
		public Assignment getRightAssignment_1_1() { return cRightAssignment_1_1; }

		//Addition
		public RuleCall getRightAdditionParserRuleCall_1_1_0() { return cRightAdditionParserRuleCall_1_1_0; }
	}

	public class AdditionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.Addition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cMultiplicationParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Action cExpressionLeftAction_1_0_0 = (Action)cGroup_1_0.eContents().get(0);
		private final Assignment cOpAssignment_1_0_1 = (Assignment)cGroup_1_0.eContents().get(1);
		private final Alternatives cOpAlternatives_1_0_1_0 = (Alternatives)cOpAssignment_1_0_1.eContents().get(0);
		private final Keyword cOpPlusSignKeyword_1_0_1_0_0 = (Keyword)cOpAlternatives_1_0_1_0.eContents().get(0);
		private final Keyword cOpHyphenMinusKeyword_1_0_1_0_1 = (Keyword)cOpAlternatives_1_0_1_0.eContents().get(1);
		private final Assignment cRightAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightMultiplicationParserRuleCall_1_1_0 = (RuleCall)cRightAssignment_1_1.eContents().get(0);
		
		//Addition Expression:
		//	Multiplication (({Expression.left=current} op=('+' | '-')) right=Multiplication)*
		@Override public ParserRule getRule() { return rule; }

		//Multiplication (({Expression.left=current} op=('+' | '-')) right=Multiplication)*
		public Group getGroup() { return cGroup; }

		//Multiplication
		public RuleCall getMultiplicationParserRuleCall_0() { return cMultiplicationParserRuleCall_0; }

		//(({Expression.left=current} op=('+' | '-')) right=Multiplication)*
		public Group getGroup_1() { return cGroup_1; }

		//({Expression.left=current} op=('+' | '-'))
		public Group getGroup_1_0() { return cGroup_1_0; }

		//{Expression.left=current}
		public Action getExpressionLeftAction_1_0_0() { return cExpressionLeftAction_1_0_0; }

		//op=('+' | '-')
		public Assignment getOpAssignment_1_0_1() { return cOpAssignment_1_0_1; }

		//('+' | '-')
		public Alternatives getOpAlternatives_1_0_1_0() { return cOpAlternatives_1_0_1_0; }

		//'+'
		public Keyword getOpPlusSignKeyword_1_0_1_0_0() { return cOpPlusSignKeyword_1_0_1_0_0; }

		//'-'
		public Keyword getOpHyphenMinusKeyword_1_0_1_0_1() { return cOpHyphenMinusKeyword_1_0_1_0_1; }

		//right=Multiplication
		public Assignment getRightAssignment_1_1() { return cRightAssignment_1_1; }

		//Multiplication
		public RuleCall getRightMultiplicationParserRuleCall_1_1_0() { return cRightMultiplicationParserRuleCall_1_1_0; }
	}

	public class MultiplicationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.Multiplication");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cExponentiationParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Action cExpressionLeftAction_1_0_0 = (Action)cGroup_1_0.eContents().get(0);
		private final Assignment cOpAssignment_1_0_1 = (Assignment)cGroup_1_0.eContents().get(1);
		private final Alternatives cOpAlternatives_1_0_1_0 = (Alternatives)cOpAssignment_1_0_1.eContents().get(0);
		private final Keyword cOpAsteriskKeyword_1_0_1_0_0 = (Keyword)cOpAlternatives_1_0_1_0.eContents().get(0);
		private final Keyword cOpSolidusKeyword_1_0_1_0_1 = (Keyword)cOpAlternatives_1_0_1_0.eContents().get(1);
		private final Assignment cRightAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightExponentiationParserRuleCall_1_1_0 = (RuleCall)cRightAssignment_1_1.eContents().get(0);
		
		//Multiplication Expression:
		//	Exponentiation (({Expression.left=current} op=('*' | '/')) right=Exponentiation)*
		@Override public ParserRule getRule() { return rule; }

		//Exponentiation (({Expression.left=current} op=('*' | '/')) right=Exponentiation)*
		public Group getGroup() { return cGroup; }

		//Exponentiation
		public RuleCall getExponentiationParserRuleCall_0() { return cExponentiationParserRuleCall_0; }

		//(({Expression.left=current} op=('*' | '/')) right=Exponentiation)*
		public Group getGroup_1() { return cGroup_1; }

		//({Expression.left=current} op=('*' | '/'))
		public Group getGroup_1_0() { return cGroup_1_0; }

		//{Expression.left=current}
		public Action getExpressionLeftAction_1_0_0() { return cExpressionLeftAction_1_0_0; }

		//op=('*' | '/')
		public Assignment getOpAssignment_1_0_1() { return cOpAssignment_1_0_1; }

		//('*' | '/')
		public Alternatives getOpAlternatives_1_0_1_0() { return cOpAlternatives_1_0_1_0; }

		//'*'
		public Keyword getOpAsteriskKeyword_1_0_1_0_0() { return cOpAsteriskKeyword_1_0_1_0_0; }

		//'/'
		public Keyword getOpSolidusKeyword_1_0_1_0_1() { return cOpSolidusKeyword_1_0_1_0_1; }

		//right=Exponentiation
		public Assignment getRightAssignment_1_1() { return cRightAssignment_1_1; }

		//Exponentiation
		public RuleCall getRightExponentiationParserRuleCall_1_1_0() { return cRightExponentiationParserRuleCall_1_1_0; }
	}

	public class ExponentiationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.Exponentiation");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cBinaryParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Action cExpressionLeftAction_1_0_0 = (Action)cGroup_1_0.eContents().get(0);
		private final Assignment cOpAssignment_1_0_1 = (Assignment)cGroup_1_0.eContents().get(1);
		private final Keyword cOpCircumflexAccentKeyword_1_0_1_0 = (Keyword)cOpAssignment_1_0_1.eContents().get(0);
		private final Assignment cRightAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightBinaryParserRuleCall_1_1_0 = (RuleCall)cRightAssignment_1_1.eContents().get(0);
		
		//Exponentiation Expression:
		//	Binary (({Expression.left=current} op='^') right=Binary)*
		@Override public ParserRule getRule() { return rule; }

		//Binary (({Expression.left=current} op='^') right=Binary)*
		public Group getGroup() { return cGroup; }

		//Binary
		public RuleCall getBinaryParserRuleCall_0() { return cBinaryParserRuleCall_0; }

		//(({Expression.left=current} op='^') right=Binary)*
		public Group getGroup_1() { return cGroup_1; }

		//({Expression.left=current} op='^')
		public Group getGroup_1_0() { return cGroup_1_0; }

		//{Expression.left=current}
		public Action getExpressionLeftAction_1_0_0() { return cExpressionLeftAction_1_0_0; }

		//op='^'
		public Assignment getOpAssignment_1_0_1() { return cOpAssignment_1_0_1; }

		//'^'
		public Keyword getOpCircumflexAccentKeyword_1_0_1_0() { return cOpCircumflexAccentKeyword_1_0_1_0; }

		//right=Binary
		public Assignment getRightAssignment_1_1() { return cRightAssignment_1_1; }

		//Binary
		public RuleCall getRightBinaryParserRuleCall_1_1_0() { return cRightBinaryParserRuleCall_1_1_0; }
	}

	public class BinaryElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.Binary");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cUnitParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Action cBinaryLeftAction_1_0_0 = (Action)cGroup_1_0.eContents().get(0);
		private final Assignment cOpAssignment_1_0_1 = (Assignment)cGroup_1_0.eContents().get(1);
		private final RuleCall cOpValid_IDParserRuleCall_1_0_1_0 = (RuleCall)cOpAssignment_1_0_1.eContents().get(0);
		private final Assignment cRightAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightUnitParserRuleCall_1_1_0 = (RuleCall)cRightAssignment_1_1.eContents().get(0);
		
		//Binary Expression:
		//	Unit (({Binary.left=current} op=Valid_ID) right=Unit)*
		@Override public ParserRule getRule() { return rule; }

		//Unit (({Binary.left=current} op=Valid_ID) right=Unit)*
		public Group getGroup() { return cGroup; }

		//Unit
		public RuleCall getUnitParserRuleCall_0() { return cUnitParserRuleCall_0; }

		//(({Binary.left=current} op=Valid_ID) right=Unit)*
		public Group getGroup_1() { return cGroup_1; }

		//({Binary.left=current} op=Valid_ID)
		public Group getGroup_1_0() { return cGroup_1_0; }

		//{Binary.left=current}
		public Action getBinaryLeftAction_1_0_0() { return cBinaryLeftAction_1_0_0; }

		//op=Valid_ID
		public Assignment getOpAssignment_1_0_1() { return cOpAssignment_1_0_1; }

		//Valid_ID
		public RuleCall getOpValid_IDParserRuleCall_1_0_1_0() { return cOpValid_IDParserRuleCall_1_0_1_0; }

		//right=Unit
		public Assignment getRightAssignment_1_1() { return cRightAssignment_1_1; }

		//Unit
		public RuleCall getRightUnitParserRuleCall_1_1_0() { return cRightUnitParserRuleCall_1_1_0; }
	}

	public class UnitElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.Unit");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cUnaryParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Action cUnitLeftAction_1_0_0 = (Action)cGroup_1_0.eContents().get(0);
		private final Assignment cOpAssignment_1_0_1 = (Assignment)cGroup_1_0.eContents().get(1);
		private final Alternatives cOpAlternatives_1_0_1_0 = (Alternatives)cOpAssignment_1_0_1.eContents().get(0);
		private final Keyword cOpDegreeSignKeyword_1_0_1_0_0 = (Keyword)cOpAlternatives_1_0_1_0.eContents().get(0);
		private final Keyword cOpNumberSignKeyword_1_0_1_0_1 = (Keyword)cOpAlternatives_1_0_1_0.eContents().get(1);
		private final Assignment cRightAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightUnitRefParserRuleCall_1_1_0 = (RuleCall)cRightAssignment_1_1.eContents().get(0);
		
		//// NEW: Units are now expressed using the "°" symbol
		//Unit Expression:
		//	Unary (({Unit.left=current} op=('°' | "#")) right=UnitRef)?
		@Override public ParserRule getRule() { return rule; }

		//Unary (({Unit.left=current} op=('°' | "#")) right=UnitRef)?
		public Group getGroup() { return cGroup; }

		//Unary
		public RuleCall getUnaryParserRuleCall_0() { return cUnaryParserRuleCall_0; }

		//(({Unit.left=current} op=('°' | "#")) right=UnitRef)?
		public Group getGroup_1() { return cGroup_1; }

		//({Unit.left=current} op=('°' | "#"))
		public Group getGroup_1_0() { return cGroup_1_0; }

		//{Unit.left=current}
		public Action getUnitLeftAction_1_0_0() { return cUnitLeftAction_1_0_0; }

		//op=('°' | "#")
		public Assignment getOpAssignment_1_0_1() { return cOpAssignment_1_0_1; }

		//('°' | "#")
		public Alternatives getOpAlternatives_1_0_1_0() { return cOpAlternatives_1_0_1_0; }

		//'°'
		public Keyword getOpDegreeSignKeyword_1_0_1_0_0() { return cOpDegreeSignKeyword_1_0_1_0_0; }

		//"#"
		public Keyword getOpNumberSignKeyword_1_0_1_0_1() { return cOpNumberSignKeyword_1_0_1_0_1; }

		//right=UnitRef
		public Assignment getRightAssignment_1_1() { return cRightAssignment_1_1; }

		//UnitRef
		public RuleCall getRightUnitRefParserRuleCall_1_1_0() { return cRightUnitRefParserRuleCall_1_1_0; }
	}

	public class UnaryElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.Unary");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cAccessParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Action cUnaryAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Alternatives cAlternatives_1_1 = (Alternatives)cGroup_1.eContents().get(1);
		private final Group cGroup_1_1_0 = (Group)cAlternatives_1_1.eContents().get(0);
		private final Assignment cOpAssignment_1_1_0_0 = (Assignment)cGroup_1_1_0.eContents().get(0);
		private final Alternatives cOpAlternatives_1_1_0_0_0 = (Alternatives)cOpAssignment_1_1_0_0.eContents().get(0);
		private final Keyword cOpDegreeSignKeyword_1_1_0_0_0_0 = (Keyword)cOpAlternatives_1_1_0_0_0.eContents().get(0);
		private final Keyword cOpNumberSignKeyword_1_1_0_0_0_1 = (Keyword)cOpAlternatives_1_1_0_0_0.eContents().get(1);
		private final Assignment cRightAssignment_1_1_0_1 = (Assignment)cGroup_1_1_0.eContents().get(1);
		private final RuleCall cRightUnitRefParserRuleCall_1_1_0_1_0 = (RuleCall)cRightAssignment_1_1_0_1.eContents().get(0);
		private final Group cGroup_1_1_1 = (Group)cAlternatives_1_1.eContents().get(1);
		private final Assignment cOpAssignment_1_1_1_0 = (Assignment)cGroup_1_1_1.eContents().get(0);
		private final Alternatives cOpAlternatives_1_1_1_0_0 = (Alternatives)cOpAssignment_1_1_1_0.eContents().get(0);
		private final Keyword cOpHyphenMinusKeyword_1_1_1_0_0_0 = (Keyword)cOpAlternatives_1_1_1_0_0.eContents().get(0);
		private final Keyword cOpExclamationMarkKeyword_1_1_1_0_0_1 = (Keyword)cOpAlternatives_1_1_1_0_0.eContents().get(1);
		private final Keyword cOpMyKeyword_1_1_1_0_0_2 = (Keyword)cOpAlternatives_1_1_1_0_0.eContents().get(2);
		private final Keyword cOpTheKeyword_1_1_1_0_0_3 = (Keyword)cOpAlternatives_1_1_1_0_0.eContents().get(3);
		private final Keyword cOpNotKeyword_1_1_1_0_0_4 = (Keyword)cOpAlternatives_1_1_1_0_0.eContents().get(4);
		private final Assignment cRightAssignment_1_1_1_1 = (Assignment)cGroup_1_1_1.eContents().get(1);
		private final RuleCall cRightUnaryParserRuleCall_1_1_1_1_0 = (RuleCall)cRightAssignment_1_1_1_1.eContents().get(0);
		
		//Unary Expression:
		//	Access | {Unary} (op=('°' | '#') right=UnitRef | op=('-' | '!' | 'my' | 'the' | 'not') right=Unary)
		@Override public ParserRule getRule() { return rule; }

		//Access | {Unary} (op=('°' | '#') right=UnitRef | op=('-' | '!' | 'my' | 'the' | 'not') right=Unary)
		public Alternatives getAlternatives() { return cAlternatives; }

		//Access
		public RuleCall getAccessParserRuleCall_0() { return cAccessParserRuleCall_0; }

		//{Unary} (op=('°' | '#') right=UnitRef | op=('-' | '!' | 'my' | 'the' | 'not') right=Unary)
		public Group getGroup_1() { return cGroup_1; }

		//{Unary}
		public Action getUnaryAction_1_0() { return cUnaryAction_1_0; }

		//(op=('°' | '#') right=UnitRef | op=('-' | '!' | 'my' | 'the' | 'not') right=Unary)
		public Alternatives getAlternatives_1_1() { return cAlternatives_1_1; }

		//op=('°' | '#') right=UnitRef
		public Group getGroup_1_1_0() { return cGroup_1_1_0; }

		//op=('°' | '#')
		public Assignment getOpAssignment_1_1_0_0() { return cOpAssignment_1_1_0_0; }

		//('°' | '#')
		public Alternatives getOpAlternatives_1_1_0_0_0() { return cOpAlternatives_1_1_0_0_0; }

		//'°'
		public Keyword getOpDegreeSignKeyword_1_1_0_0_0_0() { return cOpDegreeSignKeyword_1_1_0_0_0_0; }

		//'#'
		public Keyword getOpNumberSignKeyword_1_1_0_0_0_1() { return cOpNumberSignKeyword_1_1_0_0_0_1; }

		//right=UnitRef
		public Assignment getRightAssignment_1_1_0_1() { return cRightAssignment_1_1_0_1; }

		//UnitRef
		public RuleCall getRightUnitRefParserRuleCall_1_1_0_1_0() { return cRightUnitRefParserRuleCall_1_1_0_1_0; }

		//op=('-' | '!' | 'my' | 'the' | 'not') right=Unary
		public Group getGroup_1_1_1() { return cGroup_1_1_1; }

		//op=('-' | '!' | 'my' | 'the' | 'not')
		public Assignment getOpAssignment_1_1_1_0() { return cOpAssignment_1_1_1_0; }

		//('-' | '!' | 'my' | 'the' | 'not')
		public Alternatives getOpAlternatives_1_1_1_0_0() { return cOpAlternatives_1_1_1_0_0; }

		//'-'
		public Keyword getOpHyphenMinusKeyword_1_1_1_0_0_0() { return cOpHyphenMinusKeyword_1_1_1_0_0_0; }

		//'!'
		public Keyword getOpExclamationMarkKeyword_1_1_1_0_0_1() { return cOpExclamationMarkKeyword_1_1_1_0_0_1; }

		//'my'
		public Keyword getOpMyKeyword_1_1_1_0_0_2() { return cOpMyKeyword_1_1_1_0_0_2; }

		//'the'
		public Keyword getOpTheKeyword_1_1_1_0_0_3() { return cOpTheKeyword_1_1_1_0_0_3; }

		//'not'
		public Keyword getOpNotKeyword_1_1_1_0_0_4() { return cOpNotKeyword_1_1_1_0_0_4; }

		//right=Unary
		public Assignment getRightAssignment_1_1_1_1() { return cRightAssignment_1_1_1_1; }

		//Unary
		public RuleCall getRightUnaryParserRuleCall_1_1_1_1_0() { return cRightUnaryParserRuleCall_1_1_1_1_0; }
	}

	public class AccessElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.Access");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cPrimaryParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cAccessLeftAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Alternatives cAlternatives_1_1 = (Alternatives)cGroup_1.eContents().get(1);
		private final Group cGroup_1_1_0 = (Group)cAlternatives_1_1.eContents().get(0);
		private final Assignment cOpAssignment_1_1_0_0 = (Assignment)cGroup_1_1_0.eContents().get(0);
		private final Keyword cOpLeftSquareBracketKeyword_1_1_0_0_0 = (Keyword)cOpAssignment_1_1_0_0.eContents().get(0);
		private final Assignment cArgsAssignment_1_1_0_1 = (Assignment)cGroup_1_1_0.eContents().get(1);
		private final RuleCall cArgsExpressionListParserRuleCall_1_1_0_1_0 = (RuleCall)cArgsAssignment_1_1_0_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_1_1_0_2 = (Keyword)cGroup_1_1_0.eContents().get(2);
		private final Group cGroup_1_1_1 = (Group)cAlternatives_1_1.eContents().get(1);
		private final Assignment cOpAssignment_1_1_1_0 = (Assignment)cGroup_1_1_1.eContents().get(0);
		private final Keyword cOpFullStopKeyword_1_1_1_0_0 = (Keyword)cOpAssignment_1_1_1_0.eContents().get(0);
		private final Assignment cRightAssignment_1_1_1_1 = (Assignment)cGroup_1_1_1.eContents().get(1);
		private final RuleCall cRightAbstractRefParserRuleCall_1_1_1_1_0 = (RuleCall)cRightAssignment_1_1_1_1.eContents().get(0);
		private final Group cGroup_1_1_2 = (Group)cAlternatives_1_1.eContents().get(2);
		private final Assignment cOpAssignment_1_1_2_0 = (Assignment)cGroup_1_1_2.eContents().get(0);
		private final Keyword cOpFullStopKeyword_1_1_2_0_0 = (Keyword)cOpAssignment_1_1_2_0.eContents().get(0);
		private final Assignment cNamed_expAssignment_1_1_2_1 = (Assignment)cGroup_1_1_2.eContents().get(1);
		private final RuleCall cNamed_expSTRINGTerminalRuleCall_1_1_2_1_0 = (RuleCall)cNamed_expAssignment_1_1_2_1.eContents().get(0);
		
		////Access returns Expression:
		////	Primary ({Access.left = current} ((op='[' args=ExpressionList? ']') | (op="." right=AbstractRef)))*
		////;
		//Access Expression:
		//	Primary ({Access.left=current} (op='[' args=ExpressionList? ']' | op="." right=AbstractRef | op="."
		//	named_exp=STRING))*
		@Override public ParserRule getRule() { return rule; }

		//Primary ({Access.left=current} (op='[' args=ExpressionList? ']' | op="." right=AbstractRef | op="." named_exp=STRING))*
		public Group getGroup() { return cGroup; }

		//Primary
		public RuleCall getPrimaryParserRuleCall_0() { return cPrimaryParserRuleCall_0; }

		//({Access.left=current} (op='[' args=ExpressionList? ']' | op="." right=AbstractRef | op="." named_exp=STRING))*
		public Group getGroup_1() { return cGroup_1; }

		//{Access.left=current}
		public Action getAccessLeftAction_1_0() { return cAccessLeftAction_1_0; }

		//(op='[' args=ExpressionList? ']' | op="." right=AbstractRef | op="." named_exp=STRING)
		public Alternatives getAlternatives_1_1() { return cAlternatives_1_1; }

		//op='[' args=ExpressionList? ']'
		public Group getGroup_1_1_0() { return cGroup_1_1_0; }

		//op='['
		public Assignment getOpAssignment_1_1_0_0() { return cOpAssignment_1_1_0_0; }

		//'['
		public Keyword getOpLeftSquareBracketKeyword_1_1_0_0_0() { return cOpLeftSquareBracketKeyword_1_1_0_0_0; }

		//args=ExpressionList?
		public Assignment getArgsAssignment_1_1_0_1() { return cArgsAssignment_1_1_0_1; }

		//ExpressionList
		public RuleCall getArgsExpressionListParserRuleCall_1_1_0_1_0() { return cArgsExpressionListParserRuleCall_1_1_0_1_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_1_1_0_2() { return cRightSquareBracketKeyword_1_1_0_2; }

		//op="." right=AbstractRef
		public Group getGroup_1_1_1() { return cGroup_1_1_1; }

		//op="."
		public Assignment getOpAssignment_1_1_1_0() { return cOpAssignment_1_1_1_0; }

		//"."
		public Keyword getOpFullStopKeyword_1_1_1_0_0() { return cOpFullStopKeyword_1_1_1_0_0; }

		//right=AbstractRef
		public Assignment getRightAssignment_1_1_1_1() { return cRightAssignment_1_1_1_1; }

		//AbstractRef
		public RuleCall getRightAbstractRefParserRuleCall_1_1_1_1_0() { return cRightAbstractRefParserRuleCall_1_1_1_1_0; }

		//op="." named_exp=STRING
		public Group getGroup_1_1_2() { return cGroup_1_1_2; }

		//op="."
		public Assignment getOpAssignment_1_1_2_0() { return cOpAssignment_1_1_2_0; }

		//"."
		public Keyword getOpFullStopKeyword_1_1_2_0_0() { return cOpFullStopKeyword_1_1_2_0_0; }

		//named_exp=STRING
		public Assignment getNamed_expAssignment_1_1_2_1() { return cNamed_expAssignment_1_1_2_1; }

		//STRING
		public RuleCall getNamed_expSTRINGTerminalRuleCall_1_1_2_1_0() { return cNamed_expSTRINGTerminalRuleCall_1_1_2_1_0; }
	}

	public class PrimaryElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.Primary");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cTerminalExpressionParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cAbstractRefParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final Group cGroup_2 = (Group)cAlternatives.eContents().get(2);
		private final Keyword cLeftParenthesisKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final RuleCall cExpressionListParserRuleCall_2_1 = (RuleCall)cGroup_2.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_2_2 = (Keyword)cGroup_2.eContents().get(2);
		private final Group cGroup_3 = (Group)cAlternatives.eContents().get(3);
		private final Keyword cLeftParenthesisKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Action cParametersAction_3_1 = (Action)cGroup_3.eContents().get(1);
		private final Assignment cParamsAssignment_3_2 = (Assignment)cGroup_3.eContents().get(2);
		private final RuleCall cParamsParameterListParserRuleCall_3_2_0 = (RuleCall)cParamsAssignment_3_2.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3_3 = (Keyword)cGroup_3.eContents().get(3);
		private final Group cGroup_4 = (Group)cAlternatives.eContents().get(4);
		private final Keyword cLeftSquareBracketKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Action cArrayAction_4_1 = (Action)cGroup_4.eContents().get(1);
		private final Assignment cExprsAssignment_4_2 = (Assignment)cGroup_4.eContents().get(2);
		private final RuleCall cExprsExpressionListParserRuleCall_4_2_0 = (RuleCall)cExprsAssignment_4_2.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_4_3 = (Keyword)cGroup_4.eContents().get(3);
		private final Group cGroup_5 = (Group)cAlternatives.eContents().get(5);
		private final Keyword cLeftCurlyBracketKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Action cPointAction_5_1 = (Action)cGroup_5.eContents().get(1);
		private final Assignment cLeftAssignment_5_2 = (Assignment)cGroup_5.eContents().get(2);
		private final RuleCall cLeftExpressionParserRuleCall_5_2_0 = (RuleCall)cLeftAssignment_5_2.eContents().get(0);
		private final Assignment cOpAssignment_5_3 = (Assignment)cGroup_5.eContents().get(3);
		private final Keyword cOpCommaKeyword_5_3_0 = (Keyword)cOpAssignment_5_3.eContents().get(0);
		private final Assignment cRightAssignment_5_4 = (Assignment)cGroup_5.eContents().get(4);
		private final RuleCall cRightExpressionParserRuleCall_5_4_0 = (RuleCall)cRightAssignment_5_4.eContents().get(0);
		private final Group cGroup_5_5 = (Group)cGroup_5.eContents().get(5);
		private final Keyword cCommaKeyword_5_5_0 = (Keyword)cGroup_5_5.eContents().get(0);
		private final Assignment cZAssignment_5_5_1 = (Assignment)cGroup_5_5.eContents().get(1);
		private final RuleCall cZExpressionParserRuleCall_5_5_1_0 = (RuleCall)cZAssignment_5_5_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_5_6 = (Keyword)cGroup_5.eContents().get(6);
		
		//Primary Expression:
		//	TerminalExpression | AbstractRef |
		//	'(' ExpressionList ')' |
		//	'(' {Parameters} params=ParameterList? ')' |
		//	'[' {Array} exprs=ExpressionList? ']' |
		//	'{' {Point} left=Expression op=',' right=Expression (',' z=Expression)? '}'
		@Override public ParserRule getRule() { return rule; }

		//TerminalExpression | AbstractRef | '(' ExpressionList ')' | '(' {Parameters} params=ParameterList? ')' | '[' {Array}
		//exprs=ExpressionList? ']' | '{' {Point} left=Expression op=',' right=Expression (',' z=Expression)? '}'
		public Alternatives getAlternatives() { return cAlternatives; }

		//TerminalExpression
		public RuleCall getTerminalExpressionParserRuleCall_0() { return cTerminalExpressionParserRuleCall_0; }

		//AbstractRef
		public RuleCall getAbstractRefParserRuleCall_1() { return cAbstractRefParserRuleCall_1; }

		//'(' ExpressionList ')'
		public Group getGroup_2() { return cGroup_2; }

		//'('
		public Keyword getLeftParenthesisKeyword_2_0() { return cLeftParenthesisKeyword_2_0; }

		//ExpressionList
		public RuleCall getExpressionListParserRuleCall_2_1() { return cExpressionListParserRuleCall_2_1; }

		//')'
		public Keyword getRightParenthesisKeyword_2_2() { return cRightParenthesisKeyword_2_2; }

		//'(' {Parameters} params=ParameterList? ')'
		public Group getGroup_3() { return cGroup_3; }

		//'('
		public Keyword getLeftParenthesisKeyword_3_0() { return cLeftParenthesisKeyword_3_0; }

		//{Parameters}
		public Action getParametersAction_3_1() { return cParametersAction_3_1; }

		//params=ParameterList?
		public Assignment getParamsAssignment_3_2() { return cParamsAssignment_3_2; }

		//ParameterList
		public RuleCall getParamsParameterListParserRuleCall_3_2_0() { return cParamsParameterListParserRuleCall_3_2_0; }

		//')'
		public Keyword getRightParenthesisKeyword_3_3() { return cRightParenthesisKeyword_3_3; }

		//'[' {Array} exprs=ExpressionList? ']'
		public Group getGroup_4() { return cGroup_4; }

		//'['
		public Keyword getLeftSquareBracketKeyword_4_0() { return cLeftSquareBracketKeyword_4_0; }

		//{Array}
		public Action getArrayAction_4_1() { return cArrayAction_4_1; }

		//exprs=ExpressionList?
		public Assignment getExprsAssignment_4_2() { return cExprsAssignment_4_2; }

		//ExpressionList
		public RuleCall getExprsExpressionListParserRuleCall_4_2_0() { return cExprsExpressionListParserRuleCall_4_2_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_4_3() { return cRightSquareBracketKeyword_4_3; }

		//'{' {Point} left=Expression op=',' right=Expression (',' z=Expression)? '}'
		public Group getGroup_5() { return cGroup_5; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_5_0() { return cLeftCurlyBracketKeyword_5_0; }

		//{Point}
		public Action getPointAction_5_1() { return cPointAction_5_1; }

		//left=Expression
		public Assignment getLeftAssignment_5_2() { return cLeftAssignment_5_2; }

		//Expression
		public RuleCall getLeftExpressionParserRuleCall_5_2_0() { return cLeftExpressionParserRuleCall_5_2_0; }

		//op=','
		public Assignment getOpAssignment_5_3() { return cOpAssignment_5_3; }

		//','
		public Keyword getOpCommaKeyword_5_3_0() { return cOpCommaKeyword_5_3_0; }

		//right=Expression
		public Assignment getRightAssignment_5_4() { return cRightAssignment_5_4; }

		//Expression
		public RuleCall getRightExpressionParserRuleCall_5_4_0() { return cRightExpressionParserRuleCall_5_4_0; }

		//(',' z=Expression)?
		public Group getGroup_5_5() { return cGroup_5_5; }

		//','
		public Keyword getCommaKeyword_5_5_0() { return cCommaKeyword_5_5_0; }

		//z=Expression
		public Assignment getZAssignment_5_5_1() { return cZAssignment_5_5_1; }

		//Expression
		public RuleCall getZExpressionParserRuleCall_5_5_1_0() { return cZExpressionParserRuleCall_5_5_1_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_5_6() { return cRightCurlyBracketKeyword_5_6; }
	}

	public class AbstractRefElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.AbstractRef");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cFunctionParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cAlternatives.eContents().get(1);
		private final RuleCall cCastingFunctionParserRuleCall_1_0 = (RuleCall)cAlternatives_1.eContents().get(0);
		private final RuleCall cVariableRefParserRuleCall_1_1 = (RuleCall)cAlternatives_1.eContents().get(1);
		
		//AbstractRef Expression:
		//	Function | (=> CastingFunction | VariableRef)
		@Override public ParserRule getRule() { return rule; }

		//Function | (=> CastingFunction | VariableRef)
		public Alternatives getAlternatives() { return cAlternatives; }

		//Function
		public RuleCall getFunctionParserRuleCall_0() { return cFunctionParserRuleCall_0; }

		//(=> CastingFunction | VariableRef)
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//=> CastingFunction
		public RuleCall getCastingFunctionParserRuleCall_1_0() { return cCastingFunctionParserRuleCall_1_0; }

		//VariableRef
		public RuleCall getVariableRefParserRuleCall_1_1() { return cVariableRefParserRuleCall_1_1; }
	}

	public class FunctionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.Function");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cFunctionAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cActionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cActionActionRefParserRuleCall_1_0 = (RuleCall)cActionAssignment_1.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Alternatives cAlternatives_3 = (Alternatives)cGroup.eContents().get(3);
		private final Assignment cParametersAssignment_3_0 = (Assignment)cAlternatives_3.eContents().get(0);
		private final RuleCall cParametersParametersParserRuleCall_3_0_0 = (RuleCall)cParametersAssignment_3_0.eContents().get(0);
		private final Assignment cArgsAssignment_3_1 = (Assignment)cAlternatives_3.eContents().get(1);
		private final RuleCall cArgsExpressionListParserRuleCall_3_1_0 = (RuleCall)cArgsAssignment_3_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//Function Expression:
		//	{Function} action=ActionRef '(' (parameters=Parameters | args=ExpressionList) ')'
		@Override public ParserRule getRule() { return rule; }

		//{Function} action=ActionRef '(' (parameters=Parameters | args=ExpressionList) ')'
		public Group getGroup() { return cGroup; }

		//{Function}
		public Action getFunctionAction_0() { return cFunctionAction_0; }

		//action=ActionRef
		public Assignment getActionAssignment_1() { return cActionAssignment_1; }

		//ActionRef
		public RuleCall getActionActionRefParserRuleCall_1_0() { return cActionActionRefParserRuleCall_1_0; }

		//'('
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }

		//(parameters=Parameters | args=ExpressionList)
		public Alternatives getAlternatives_3() { return cAlternatives_3; }

		//parameters=Parameters
		public Assignment getParametersAssignment_3_0() { return cParametersAssignment_3_0; }

		//Parameters
		public RuleCall getParametersParametersParserRuleCall_3_0_0() { return cParametersParametersParserRuleCall_3_0_0; }

		//args=ExpressionList
		public Assignment getArgsAssignment_3_1() { return cArgsAssignment_3_1; }

		//ExpressionList
		public RuleCall getArgsExpressionListParserRuleCall_3_1_0() { return cArgsExpressionListParserRuleCall_3_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_4() { return cRightParenthesisKeyword_4; }
	}

	public class CastingFunctionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.CastingFunction");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cActionAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cActionActionRefParserRuleCall_0_0 = (RuleCall)cActionAssignment_0.eContents().get(0);
		private final Assignment cTypeAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cTypeTypeInfoParserRuleCall_1_0 = (RuleCall)cTypeAssignment_1.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cArgsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cArgsExpressionListParserRuleCall_3_0 = (RuleCall)cArgsAssignment_3.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//CastingFunction Function:
		//	action=ActionRef type=TypeInfo "(" args=ExpressionList ')'
		@Override public ParserRule getRule() { return rule; }

		//action=ActionRef type=TypeInfo "(" args=ExpressionList ')'
		public Group getGroup() { return cGroup; }

		//action=ActionRef
		public Assignment getActionAssignment_0() { return cActionAssignment_0; }

		//ActionRef
		public RuleCall getActionActionRefParserRuleCall_0_0() { return cActionActionRefParserRuleCall_0_0; }

		//type=TypeInfo
		public Assignment getTypeAssignment_1() { return cTypeAssignment_1; }

		//TypeInfo
		public RuleCall getTypeTypeInfoParserRuleCall_1_0() { return cTypeTypeInfoParserRuleCall_1_0; }

		//"("
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }

		//args=ExpressionList
		public Assignment getArgsAssignment_3() { return cArgsAssignment_3; }

		//ExpressionList
		public RuleCall getArgsExpressionListParserRuleCall_3_0() { return cArgsExpressionListParserRuleCall_3_0; }

		//')'
		public Keyword getRightParenthesisKeyword_4() { return cRightParenthesisKeyword_4; }
	}

	public class ParameterElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.Parameter");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cParameterAction_0 = (Action)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cBuiltInFacetKeyAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final Alternatives cBuiltInFacetKeyAlternatives_1_0_0 = (Alternatives)cBuiltInFacetKeyAssignment_1_0.eContents().get(0);
		private final RuleCall cBuiltInFacetKeyDefinitionFacetKeyParserRuleCall_1_0_0_0 = (RuleCall)cBuiltInFacetKeyAlternatives_1_0_0.eContents().get(0);
		private final RuleCall cBuiltInFacetKeyTypeFacetKeyParserRuleCall_1_0_0_1 = (RuleCall)cBuiltInFacetKeyAlternatives_1_0_0.eContents().get(1);
		private final RuleCall cBuiltInFacetKeySpecialFacetKeyParserRuleCall_1_0_0_2 = (RuleCall)cBuiltInFacetKeyAlternatives_1_0_0.eContents().get(2);
		private final RuleCall cBuiltInFacetKeyActionFacetKeyParserRuleCall_1_0_0_3 = (RuleCall)cBuiltInFacetKeyAlternatives_1_0_0.eContents().get(3);
		private final RuleCall cBuiltInFacetKeyVarFacetKeyParserRuleCall_1_0_0_4 = (RuleCall)cBuiltInFacetKeyAlternatives_1_0_0.eContents().get(4);
		private final Group cGroup_1_1 = (Group)cAlternatives_1.eContents().get(1);
		private final Assignment cLeftAssignment_1_1_0 = (Assignment)cGroup_1_1.eContents().get(0);
		private final RuleCall cLeftVariableRefParserRuleCall_1_1_0_0 = (RuleCall)cLeftAssignment_1_1_0.eContents().get(0);
		private final Keyword cColonKeyword_1_1_1 = (Keyword)cGroup_1_1.eContents().get(1);
		private final Assignment cRightAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cRightExpressionParserRuleCall_2_0 = (RuleCall)cRightAssignment_2.eContents().get(0);
		
		//Parameter Expression:
		//	{Parameter} (builtInFacetKey=(DefinitionFacetKey | TypeFacetKey | SpecialFacetKey | ActionFacetKey | VarFacetKey) |
		//	left=VariableRef ':') right=Expression
		@Override public ParserRule getRule() { return rule; }

		//{Parameter} (builtInFacetKey=(DefinitionFacetKey | TypeFacetKey | SpecialFacetKey | ActionFacetKey | VarFacetKey) |
		//left=VariableRef ':') right=Expression
		public Group getGroup() { return cGroup; }

		//{Parameter}
		public Action getParameterAction_0() { return cParameterAction_0; }

		//(builtInFacetKey=(DefinitionFacetKey | TypeFacetKey | SpecialFacetKey | ActionFacetKey | VarFacetKey) | left=VariableRef
		//':')
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//builtInFacetKey=(DefinitionFacetKey | TypeFacetKey | SpecialFacetKey | ActionFacetKey | VarFacetKey)
		public Assignment getBuiltInFacetKeyAssignment_1_0() { return cBuiltInFacetKeyAssignment_1_0; }

		//(DefinitionFacetKey | TypeFacetKey | SpecialFacetKey | ActionFacetKey | VarFacetKey)
		public Alternatives getBuiltInFacetKeyAlternatives_1_0_0() { return cBuiltInFacetKeyAlternatives_1_0_0; }

		//DefinitionFacetKey
		public RuleCall getBuiltInFacetKeyDefinitionFacetKeyParserRuleCall_1_0_0_0() { return cBuiltInFacetKeyDefinitionFacetKeyParserRuleCall_1_0_0_0; }

		//TypeFacetKey
		public RuleCall getBuiltInFacetKeyTypeFacetKeyParserRuleCall_1_0_0_1() { return cBuiltInFacetKeyTypeFacetKeyParserRuleCall_1_0_0_1; }

		//SpecialFacetKey
		public RuleCall getBuiltInFacetKeySpecialFacetKeyParserRuleCall_1_0_0_2() { return cBuiltInFacetKeySpecialFacetKeyParserRuleCall_1_0_0_2; }

		//ActionFacetKey
		public RuleCall getBuiltInFacetKeyActionFacetKeyParserRuleCall_1_0_0_3() { return cBuiltInFacetKeyActionFacetKeyParserRuleCall_1_0_0_3; }

		//VarFacetKey
		public RuleCall getBuiltInFacetKeyVarFacetKeyParserRuleCall_1_0_0_4() { return cBuiltInFacetKeyVarFacetKeyParserRuleCall_1_0_0_4; }

		//left=VariableRef ':'
		public Group getGroup_1_1() { return cGroup_1_1; }

		//left=VariableRef
		public Assignment getLeftAssignment_1_1_0() { return cLeftAssignment_1_1_0; }

		//VariableRef
		public RuleCall getLeftVariableRefParserRuleCall_1_1_0_0() { return cLeftVariableRefParserRuleCall_1_1_0_0; }

		//':'
		public Keyword getColonKeyword_1_1_1() { return cColonKeyword_1_1_1; }

		//right=Expression
		public Assignment getRightAssignment_2() { return cRightAssignment_2; }

		//Expression
		public RuleCall getRightExpressionParserRuleCall_2_0() { return cRightExpressionParserRuleCall_2_0; }
	}

	public class ExpressionListElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.ExpressionList");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cExprsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cExprsExpressionParserRuleCall_0_0 = (RuleCall)cExprsAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cCommaKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cExprsAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cExprsExpressionParserRuleCall_1_1_0 = (RuleCall)cExprsAssignment_1_1.eContents().get(0);
		
		//ExpressionList:
		//	exprs+=Expression (',' exprs+=Expression)*;
		@Override public ParserRule getRule() { return rule; }

		//exprs+=Expression (',' exprs+=Expression)*
		public Group getGroup() { return cGroup; }

		//exprs+=Expression
		public Assignment getExprsAssignment_0() { return cExprsAssignment_0; }

		//Expression
		public RuleCall getExprsExpressionParserRuleCall_0_0() { return cExprsExpressionParserRuleCall_0_0; }

		//(',' exprs+=Expression)*
		public Group getGroup_1() { return cGroup_1; }

		//','
		public Keyword getCommaKeyword_1_0() { return cCommaKeyword_1_0; }

		//exprs+=Expression
		public Assignment getExprsAssignment_1_1() { return cExprsAssignment_1_1; }

		//Expression
		public RuleCall getExprsExpressionParserRuleCall_1_1_0() { return cExprsExpressionParserRuleCall_1_1_0; }
	}

	public class ParameterListElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.ParameterList");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cExprsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cExprsParameterParserRuleCall_0_0 = (RuleCall)cExprsAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cCommaKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cExprsAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cExprsParameterParserRuleCall_1_1_0 = (RuleCall)cExprsAssignment_1_1.eContents().get(0);
		
		//ParameterList ExpressionList:
		//	exprs+=Parameter (',' exprs+=Parameter)*
		@Override public ParserRule getRule() { return rule; }

		//exprs+=Parameter (',' exprs+=Parameter)*
		public Group getGroup() { return cGroup; }

		//exprs+=Parameter
		public Assignment getExprsAssignment_0() { return cExprsAssignment_0; }

		//Parameter
		public RuleCall getExprsParameterParserRuleCall_0_0() { return cExprsParameterParserRuleCall_0_0; }

		//(',' exprs+=Parameter)*
		public Group getGroup_1() { return cGroup_1; }

		//','
		public Keyword getCommaKeyword_1_0() { return cCommaKeyword_1_0; }

		//exprs+=Parameter
		public Assignment getExprsAssignment_1_1() { return cExprsAssignment_1_1; }

		//Parameter
		public RuleCall getExprsParameterParserRuleCall_1_1_0() { return cExprsParameterParserRuleCall_1_1_0; }
	}

	public class UnitRefElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.UnitRef");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cUnitNameAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cRefAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cRefUnitFakeDefinitionCrossReference_1_0 = (CrossReference)cRefAssignment_1.eContents().get(0);
		private final RuleCall cRefUnitFakeDefinitionIDTerminalRuleCall_1_0_1 = (RuleCall)cRefUnitFakeDefinitionCrossReference_1_0.eContents().get(1);
		
		//UnitRef Expression:
		//	{UnitName} ref=[UnitFakeDefinition]
		@Override public ParserRule getRule() { return rule; }

		//{UnitName} ref=[UnitFakeDefinition]
		public Group getGroup() { return cGroup; }

		//{UnitName}
		public Action getUnitNameAction_0() { return cUnitNameAction_0; }

		//ref=[UnitFakeDefinition]
		public Assignment getRefAssignment_1() { return cRefAssignment_1; }

		//[UnitFakeDefinition]
		public CrossReference getRefUnitFakeDefinitionCrossReference_1_0() { return cRefUnitFakeDefinitionCrossReference_1_0; }

		//ID
		public RuleCall getRefUnitFakeDefinitionIDTerminalRuleCall_1_0_1() { return cRefUnitFakeDefinitionIDTerminalRuleCall_1_0_1; }
	}

	public class VariableRefElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.VariableRef");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cVariableRefAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cRefAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cRefVarDefinitionCrossReference_1_0 = (CrossReference)cRefAssignment_1.eContents().get(0);
		private final RuleCall cRefVarDefinitionValid_IDParserRuleCall_1_0_1 = (RuleCall)cRefVarDefinitionCrossReference_1_0.eContents().get(1);
		
		//VariableRef:
		//	{VariableRef} ref=[VarDefinition|Valid_ID];
		@Override public ParserRule getRule() { return rule; }

		//{VariableRef} ref=[VarDefinition|Valid_ID]
		public Group getGroup() { return cGroup; }

		//{VariableRef}
		public Action getVariableRefAction_0() { return cVariableRefAction_0; }

		//ref=[VarDefinition|Valid_ID]
		public Assignment getRefAssignment_1() { return cRefAssignment_1; }

		//[VarDefinition|Valid_ID]
		public CrossReference getRefVarDefinitionCrossReference_1_0() { return cRefVarDefinitionCrossReference_1_0; }

		//Valid_ID
		public RuleCall getRefVarDefinitionValid_IDParserRuleCall_1_0_1() { return cRefVarDefinitionValid_IDParserRuleCall_1_0_1; }
	}

	public class TypeRefElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.TypeRef");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Action cTypeRefAction_0_0 = (Action)cGroup_0.eContents().get(0);
		private final Group cGroup_0_1 = (Group)cGroup_0.eContents().get(1);
		private final Assignment cRefAssignment_0_1_0 = (Assignment)cGroup_0_1.eContents().get(0);
		private final CrossReference cRefTypeDefinitionCrossReference_0_1_0_0 = (CrossReference)cRefAssignment_0_1_0.eContents().get(0);
		private final RuleCall cRefTypeDefinitionIDTerminalRuleCall_0_1_0_0_1 = (RuleCall)cRefTypeDefinitionCrossReference_0_1_0_0.eContents().get(1);
		private final Assignment cParameterAssignment_0_1_1 = (Assignment)cGroup_0_1.eContents().get(1);
		private final RuleCall cParameterTypeInfoParserRuleCall_0_1_1_0 = (RuleCall)cParameterAssignment_0_1_1.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Action cTypeRefAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cGroup_1.eContents().get(1);
		private final Keyword cSpeciesKeyword_1_1_0 = (Keyword)cGroup_1_1.eContents().get(0);
		private final Assignment cParameterAssignment_1_1_1 = (Assignment)cGroup_1_1.eContents().get(1);
		private final RuleCall cParameterTypeInfoParserRuleCall_1_1_1_0 = (RuleCall)cParameterAssignment_1_1_1.eContents().get(0);
		
		//TypeRef Expression:
		//	{TypeRef} (ref=[TypeDefinition] parameter=TypeInfo?) | {TypeRef} ("species" parameter=TypeInfo)
		@Override public ParserRule getRule() { return rule; }

		//{TypeRef} (ref=[TypeDefinition] parameter=TypeInfo?) | {TypeRef} ("species" parameter=TypeInfo)
		public Alternatives getAlternatives() { return cAlternatives; }

		//{TypeRef} (ref=[TypeDefinition] parameter=TypeInfo?)
		public Group getGroup_0() { return cGroup_0; }

		//{TypeRef}
		public Action getTypeRefAction_0_0() { return cTypeRefAction_0_0; }

		//(ref=[TypeDefinition] parameter=TypeInfo?)
		public Group getGroup_0_1() { return cGroup_0_1; }

		//ref=[TypeDefinition]
		public Assignment getRefAssignment_0_1_0() { return cRefAssignment_0_1_0; }

		//[TypeDefinition]
		public CrossReference getRefTypeDefinitionCrossReference_0_1_0_0() { return cRefTypeDefinitionCrossReference_0_1_0_0; }

		//ID
		public RuleCall getRefTypeDefinitionIDTerminalRuleCall_0_1_0_0_1() { return cRefTypeDefinitionIDTerminalRuleCall_0_1_0_0_1; }

		//parameter=TypeInfo?
		public Assignment getParameterAssignment_0_1_1() { return cParameterAssignment_0_1_1; }

		//TypeInfo
		public RuleCall getParameterTypeInfoParserRuleCall_0_1_1_0() { return cParameterTypeInfoParserRuleCall_0_1_1_0; }

		//{TypeRef} ("species" parameter=TypeInfo)
		public Group getGroup_1() { return cGroup_1; }

		//{TypeRef}
		public Action getTypeRefAction_1_0() { return cTypeRefAction_1_0; }

		//("species" parameter=TypeInfo)
		public Group getGroup_1_1() { return cGroup_1_1; }

		//"species"
		public Keyword getSpeciesKeyword_1_1_0() { return cSpeciesKeyword_1_1_0; }

		//parameter=TypeInfo
		public Assignment getParameterAssignment_1_1_1() { return cParameterAssignment_1_1_1; }

		//TypeInfo
		public RuleCall getParameterTypeInfoParserRuleCall_1_1_1_0() { return cParameterTypeInfoParserRuleCall_1_1_1_0; }
	}

	public class TypeInfoElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.TypeInfo");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLessThanSignKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cFirstAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cFirstTypeRefParserRuleCall_1_0 = (RuleCall)cFirstAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cCommaKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cSecondAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cSecondTypeRefParserRuleCall_2_1_0 = (RuleCall)cSecondAssignment_2_1.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//TypeInfo:
		//	'<' first=TypeRef ("," second=TypeRef)? => '>';
		@Override public ParserRule getRule() { return rule; }

		//'<' first=TypeRef ("," second=TypeRef)? => '>'
		public Group getGroup() { return cGroup; }

		//'<'
		public Keyword getLessThanSignKeyword_0() { return cLessThanSignKeyword_0; }

		//first=TypeRef
		public Assignment getFirstAssignment_1() { return cFirstAssignment_1; }

		//TypeRef
		public RuleCall getFirstTypeRefParserRuleCall_1_0() { return cFirstTypeRefParserRuleCall_1_0; }

		//("," second=TypeRef)?
		public Group getGroup_2() { return cGroup_2; }

		//","
		public Keyword getCommaKeyword_2_0() { return cCommaKeyword_2_0; }

		//second=TypeRef
		public Assignment getSecondAssignment_2_1() { return cSecondAssignment_2_1; }

		//TypeRef
		public RuleCall getSecondTypeRefParserRuleCall_2_1_0() { return cSecondTypeRefParserRuleCall_2_1_0; }

		//=> '>'
		public Keyword getGreaterThanSignKeyword_3() { return cGreaterThanSignKeyword_3; }
	}

	public class SkillRefElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.SkillRef");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cSkillRefAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cRefAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cRefSkillFakeDefinitionCrossReference_1_0 = (CrossReference)cRefAssignment_1.eContents().get(0);
		private final RuleCall cRefSkillFakeDefinitionIDTerminalRuleCall_1_0_1 = (RuleCall)cRefSkillFakeDefinitionCrossReference_1_0.eContents().get(1);
		
		//SkillRef Expression:
		//	{SkillRef} ref=[SkillFakeDefinition]
		@Override public ParserRule getRule() { return rule; }

		//{SkillRef} ref=[SkillFakeDefinition]
		public Group getGroup() { return cGroup; }

		//{SkillRef}
		public Action getSkillRefAction_0() { return cSkillRefAction_0; }

		//ref=[SkillFakeDefinition]
		public Assignment getRefAssignment_1() { return cRefAssignment_1; }

		//[SkillFakeDefinition]
		public CrossReference getRefSkillFakeDefinitionCrossReference_1_0() { return cRefSkillFakeDefinitionCrossReference_1_0; }

		//ID
		public RuleCall getRefSkillFakeDefinitionIDTerminalRuleCall_1_0_1() { return cRefSkillFakeDefinitionIDTerminalRuleCall_1_0_1; }
	}

	public class ActionRefElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.ActionRef");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cActionRefAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cRefAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cRefActionDefinitionCrossReference_1_0 = (CrossReference)cRefAssignment_1.eContents().get(0);
		private final RuleCall cRefActionDefinitionValid_IDParserRuleCall_1_0_1 = (RuleCall)cRefActionDefinitionCrossReference_1_0.eContents().get(1);
		
		//ActionRef Expression:
		//	{ActionRef} ref=[ActionDefinition|Valid_ID]
		@Override public ParserRule getRule() { return rule; }

		//{ActionRef} ref=[ActionDefinition|Valid_ID]
		public Group getGroup() { return cGroup; }

		//{ActionRef}
		public Action getActionRefAction_0() { return cActionRefAction_0; }

		//ref=[ActionDefinition|Valid_ID]
		public Assignment getRefAssignment_1() { return cRefAssignment_1; }

		//[ActionDefinition|Valid_ID]
		public CrossReference getRefActionDefinitionCrossReference_1_0() { return cRefActionDefinitionCrossReference_1_0; }

		//Valid_ID
		public RuleCall getRefActionDefinitionValid_IDParserRuleCall_1_0_1() { return cRefActionDefinitionValid_IDParserRuleCall_1_0_1; }
	}

	public class EquationRefElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.EquationRef");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cEquationRefAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cRefAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cRefEquationDefinitionCrossReference_1_0 = (CrossReference)cRefAssignment_1.eContents().get(0);
		private final RuleCall cRefEquationDefinitionValid_IDParserRuleCall_1_0_1 = (RuleCall)cRefEquationDefinitionCrossReference_1_0.eContents().get(1);
		
		//EquationRef Expression:
		//	{EquationRef} ref=[EquationDefinition|Valid_ID]
		@Override public ParserRule getRule() { return rule; }

		//{EquationRef} ref=[EquationDefinition|Valid_ID]
		public Group getGroup() { return cGroup; }

		//{EquationRef}
		public Action getEquationRefAction_0() { return cEquationRefAction_0; }

		//ref=[EquationDefinition|Valid_ID]
		public Assignment getRefAssignment_1() { return cRefAssignment_1; }

		//[EquationDefinition|Valid_ID]
		public CrossReference getRefEquationDefinitionCrossReference_1_0() { return cRefEquationDefinitionCrossReference_1_0; }

		//Valid_ID
		public RuleCall getRefEquationDefinitionValid_IDParserRuleCall_1_0_1() { return cRefEquationDefinitionValid_IDParserRuleCall_1_0_1; }
	}

	public class GamlDefinitionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.GamlDefinition");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cTypeDefinitionParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cVarDefinitionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cUnitFakeDefinitionParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cSkillFakeDefinitionParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cActionDefinitionParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cEquationDefinitionParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		
		//GamlDefinition:
		//	TypeDefinition | VarDefinition | UnitFakeDefinition | SkillFakeDefinition | ActionDefinition | EquationDefinition;
		@Override public ParserRule getRule() { return rule; }

		//TypeDefinition | VarDefinition | UnitFakeDefinition | SkillFakeDefinition | ActionDefinition | EquationDefinition
		public Alternatives getAlternatives() { return cAlternatives; }

		//TypeDefinition
		public RuleCall getTypeDefinitionParserRuleCall_0() { return cTypeDefinitionParserRuleCall_0; }

		//VarDefinition
		public RuleCall getVarDefinitionParserRuleCall_1() { return cVarDefinitionParserRuleCall_1; }

		//UnitFakeDefinition
		public RuleCall getUnitFakeDefinitionParserRuleCall_2() { return cUnitFakeDefinitionParserRuleCall_2; }

		//SkillFakeDefinition
		public RuleCall getSkillFakeDefinitionParserRuleCall_3() { return cSkillFakeDefinitionParserRuleCall_3; }

		//ActionDefinition
		public RuleCall getActionDefinitionParserRuleCall_4() { return cActionDefinitionParserRuleCall_4; }

		//EquationDefinition
		public RuleCall getEquationDefinitionParserRuleCall_5() { return cEquationDefinitionParserRuleCall_5; }
	}

	public class EquationDefinitionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.EquationDefinition");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cS_EquationsParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cEquationFakeDefinitionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//EquationDefinition:
		//	S_Equations | EquationFakeDefinition;
		@Override public ParserRule getRule() { return rule; }

		//S_Equations | EquationFakeDefinition
		public Alternatives getAlternatives() { return cAlternatives; }

		//S_Equations
		public RuleCall getS_EquationsParserRuleCall_0() { return cS_EquationsParserRuleCall_0; }

		//EquationFakeDefinition
		public RuleCall getEquationFakeDefinitionParserRuleCall_1() { return cEquationFakeDefinitionParserRuleCall_1; }
	}

	public class TypeDefinitionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.TypeDefinition");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cS_SpeciesParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cTypeFakeDefinitionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//TypeDefinition:
		//	S_Species / *| S_Experiment |* / | TypeFakeDefinition;
		@Override public ParserRule getRule() { return rule; }

		//S_Species / *| S_Experiment |* / | TypeFakeDefinition
		public Alternatives getAlternatives() { return cAlternatives; }

		//S_Species
		public RuleCall getS_SpeciesParserRuleCall_0() { return cS_SpeciesParserRuleCall_0; }

		//TypeFakeDefinition
		public RuleCall getTypeFakeDefinitionParserRuleCall_1() { return cTypeFakeDefinitionParserRuleCall_1; }
	}

	public class VarDefinitionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.VarDefinition");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cS_DeclarationParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cAlternatives.eContents().get(1);
		private final RuleCall cModelParserRuleCall_1_0 = (RuleCall)cAlternatives_1.eContents().get(0);
		private final RuleCall cArgumentDefinitionParserRuleCall_1_1 = (RuleCall)cAlternatives_1.eContents().get(1);
		private final RuleCall cDefinitionFacetParserRuleCall_1_2 = (RuleCall)cAlternatives_1.eContents().get(2);
		private final RuleCall cVarFakeDefinitionParserRuleCall_1_3 = (RuleCall)cAlternatives_1.eContents().get(3);
		private final RuleCall cImportParserRuleCall_1_4 = (RuleCall)cAlternatives_1.eContents().get(4);
		private final RuleCall cS_ExperimentParserRuleCall_1_5 = (RuleCall)cAlternatives_1.eContents().get(5);
		
		//VarDefinition:
		//	=> S_Declaration | (Model | ArgumentDefinition | DefinitionFacet | VarFakeDefinition | Import | S_Experiment);
		@Override public ParserRule getRule() { return rule; }

		//=> S_Declaration | (Model | ArgumentDefinition | DefinitionFacet | VarFakeDefinition | Import | S_Experiment)
		public Alternatives getAlternatives() { return cAlternatives; }

		//=> S_Declaration
		public RuleCall getS_DeclarationParserRuleCall_0() { return cS_DeclarationParserRuleCall_0; }

		//(Model | ArgumentDefinition | DefinitionFacet | VarFakeDefinition | Import | S_Experiment)
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//Model
		public RuleCall getModelParserRuleCall_1_0() { return cModelParserRuleCall_1_0; }

		//ArgumentDefinition
		public RuleCall getArgumentDefinitionParserRuleCall_1_1() { return cArgumentDefinitionParserRuleCall_1_1; }

		//DefinitionFacet
		public RuleCall getDefinitionFacetParserRuleCall_1_2() { return cDefinitionFacetParserRuleCall_1_2; }

		//VarFakeDefinition
		public RuleCall getVarFakeDefinitionParserRuleCall_1_3() { return cVarFakeDefinitionParserRuleCall_1_3; }

		//Import
		public RuleCall getImportParserRuleCall_1_4() { return cImportParserRuleCall_1_4; }

		//S_Experiment
		public RuleCall getS_ExperimentParserRuleCall_1_5() { return cS_ExperimentParserRuleCall_1_5; }
	}

	public class ActionDefinitionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.ActionDefinition");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cS_ActionParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cActionFakeDefinitionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cS_DefinitionParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cTypeDefinitionParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		
		//ActionDefinition:
		//	S_Action | ActionFakeDefinition | S_Definition | TypeDefinition;
		@Override public ParserRule getRule() { return rule; }

		//S_Action | ActionFakeDefinition | S_Definition | TypeDefinition
		public Alternatives getAlternatives() { return cAlternatives; }

		//S_Action
		public RuleCall getS_ActionParserRuleCall_0() { return cS_ActionParserRuleCall_0; }

		//ActionFakeDefinition
		public RuleCall getActionFakeDefinitionParserRuleCall_1() { return cActionFakeDefinitionParserRuleCall_1; }

		//S_Definition
		public RuleCall getS_DefinitionParserRuleCall_2() { return cS_DefinitionParserRuleCall_2; }

		//TypeDefinition
		public RuleCall getTypeDefinitionParserRuleCall_3() { return cTypeDefinitionParserRuleCall_3; }
	}

	public class UnitFakeDefinitionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.UnitFakeDefinition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cUnitKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		
		//// Fake Definitions produced by the global scope provider
		//UnitFakeDefinition:
		//	'**unit*' name=ID;
		@Override public ParserRule getRule() { return rule; }

		//'**unit*' name=ID
		public Group getGroup() { return cGroup; }

		//'**unit*'
		public Keyword getUnitKeyword_0() { return cUnitKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
	}

	public class TypeFakeDefinitionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.TypeFakeDefinition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cTypeKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		
		//TypeFakeDefinition:
		//	'**type*' name=ID;
		@Override public ParserRule getRule() { return rule; }

		//'**type*' name=ID
		public Group getGroup() { return cGroup; }

		//'**type*'
		public Keyword getTypeKeyword_0() { return cTypeKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
	}

	public class ActionFakeDefinitionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.ActionFakeDefinition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cActionKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameValid_IDParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		
		//ActionFakeDefinition:
		//	'**action*' name=Valid_ID;
		@Override public ParserRule getRule() { return rule; }

		//'**action*' name=Valid_ID
		public Group getGroup() { return cGroup; }

		//'**action*'
		public Keyword getActionKeyword_0() { return cActionKeyword_0; }

		//name=Valid_ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//Valid_ID
		public RuleCall getNameValid_IDParserRuleCall_1_0() { return cNameValid_IDParserRuleCall_1_0; }
	}

	public class SkillFakeDefinitionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.SkillFakeDefinition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cSkillKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		
		//SkillFakeDefinition:
		//	'**skill*' name=ID;
		@Override public ParserRule getRule() { return rule; }

		//'**skill*' name=ID
		public Group getGroup() { return cGroup; }

		//'**skill*'
		public Keyword getSkillKeyword_0() { return cSkillKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
	}

	public class VarFakeDefinitionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.VarFakeDefinition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cVarKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameValid_IDParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		
		//VarFakeDefinition:
		//	'**var*' name=Valid_ID;
		@Override public ParserRule getRule() { return rule; }

		//'**var*' name=Valid_ID
		public Group getGroup() { return cGroup; }

		//'**var*'
		public Keyword getVarKeyword_0() { return cVarKeyword_0; }

		//name=Valid_ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//Valid_ID
		public RuleCall getNameValid_IDParserRuleCall_1_0() { return cNameValid_IDParserRuleCall_1_0; }
	}

	public class EquationFakeDefinitionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.EquationFakeDefinition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cEquationKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameValid_IDParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		
		//EquationFakeDefinition:
		//	'**equation*' name=Valid_ID;
		@Override public ParserRule getRule() { return rule; }

		//'**equation*' name=Valid_ID
		public Group getGroup() { return cGroup; }

		//'**equation*'
		public Keyword getEquationKeyword_0() { return cEquationKeyword_0; }

		//name=Valid_ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//Valid_ID
		public RuleCall getNameValid_IDParserRuleCall_1_0() { return cNameValid_IDParserRuleCall_1_0; }
	}

	public class Valid_IDElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.Valid_ID");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall c_SpeciesKeyParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall c_DoKeyParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall c_ReflexKeyParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall c_VarOrConstKeyParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall c_1Expr_Facets_BlockOrEnd_KeyParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall c_EquationsKeyParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		private final RuleCall cIDTerminalRuleCall_6 = (RuleCall)cAlternatives.eContents().get(6);
		private final RuleCall c_ExperimentKeyParserRuleCall_7 = (RuleCall)cAlternatives.eContents().get(7);
		
		//Valid_ID:
		//	_SpeciesKey | _DoKey | _ReflexKey | _VarOrConstKey | _1Expr_Facets_BlockOrEnd_Key | _EquationsKey | ID |
		//	_ExperimentKey;
		@Override public ParserRule getRule() { return rule; }

		//_SpeciesKey | _DoKey | _ReflexKey | _VarOrConstKey | _1Expr_Facets_BlockOrEnd_Key | _EquationsKey | ID | _ExperimentKey
		public Alternatives getAlternatives() { return cAlternatives; }

		//_SpeciesKey
		public RuleCall get_SpeciesKeyParserRuleCall_0() { return c_SpeciesKeyParserRuleCall_0; }

		//_DoKey
		public RuleCall get_DoKeyParserRuleCall_1() { return c_DoKeyParserRuleCall_1; }

		//_ReflexKey
		public RuleCall get_ReflexKeyParserRuleCall_2() { return c_ReflexKeyParserRuleCall_2; }

		//_VarOrConstKey
		public RuleCall get_VarOrConstKeyParserRuleCall_3() { return c_VarOrConstKeyParserRuleCall_3; }

		//_1Expr_Facets_BlockOrEnd_Key
		public RuleCall get_1Expr_Facets_BlockOrEnd_KeyParserRuleCall_4() { return c_1Expr_Facets_BlockOrEnd_KeyParserRuleCall_4; }

		//_EquationsKey
		public RuleCall get_EquationsKeyParserRuleCall_5() { return c_EquationsKeyParserRuleCall_5; }

		//ID
		public RuleCall getIDTerminalRuleCall_6() { return cIDTerminalRuleCall_6; }

		//_ExperimentKey
		public RuleCall get_ExperimentKeyParserRuleCall_7() { return c_ExperimentKeyParserRuleCall_7; }
	}

	public class TerminalExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.TerminalExpression");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Action cIntLiteralAction_0_0 = (Action)cGroup_0.eContents().get(0);
		private final Assignment cOpAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final RuleCall cOpINTEGERTerminalRuleCall_0_1_0 = (RuleCall)cOpAssignment_0_1.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Action cDoubleLiteralAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Assignment cOpAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cOpDOUBLETerminalRuleCall_1_1_0 = (RuleCall)cOpAssignment_1_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cAlternatives.eContents().get(2);
		private final Action cColorLiteralAction_2_0 = (Action)cGroup_2.eContents().get(0);
		private final Assignment cOpAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cOpCOLORTerminalRuleCall_2_1_0 = (RuleCall)cOpAssignment_2_1.eContents().get(0);
		private final Group cGroup_3 = (Group)cAlternatives.eContents().get(3);
		private final Action cStringLiteralAction_3_0 = (Action)cGroup_3.eContents().get(0);
		private final Assignment cOpAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cOpSTRINGTerminalRuleCall_3_1_0 = (RuleCall)cOpAssignment_3_1.eContents().get(0);
		private final Group cGroup_4 = (Group)cAlternatives.eContents().get(4);
		private final Action cBooleanLiteralAction_4_0 = (Action)cGroup_4.eContents().get(0);
		private final Assignment cOpAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cOpBOOLEANTerminalRuleCall_4_1_0 = (RuleCall)cOpAssignment_4_1.eContents().get(0);
		private final Group cGroup_5 = (Group)cAlternatives.eContents().get(5);
		private final Action cReservedLiteralAction_5_0 = (Action)cGroup_5.eContents().get(0);
		private final Assignment cOpAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cOpKEYWORDTerminalRuleCall_5_1_0 = (RuleCall)cOpAssignment_5_1.eContents().get(0);
		
		/// **
		// * Terminals
		// * / TerminalExpression:
		//	{IntLiteral} op=INTEGER | {DoubleLiteral} op=DOUBLE | {ColorLiteral} op=COLOR | {StringLiteral} op=STRING |
		//	{BooleanLiteral} op=BOOLEAN | {ReservedLiteral} op=KEYWORD;
		@Override public ParserRule getRule() { return rule; }

		//{IntLiteral} op=INTEGER | {DoubleLiteral} op=DOUBLE | {ColorLiteral} op=COLOR | {StringLiteral} op=STRING |
		//{BooleanLiteral} op=BOOLEAN | {ReservedLiteral} op=KEYWORD
		public Alternatives getAlternatives() { return cAlternatives; }

		//{IntLiteral} op=INTEGER
		public Group getGroup_0() { return cGroup_0; }

		//{IntLiteral}
		public Action getIntLiteralAction_0_0() { return cIntLiteralAction_0_0; }

		//op=INTEGER
		public Assignment getOpAssignment_0_1() { return cOpAssignment_0_1; }

		//INTEGER
		public RuleCall getOpINTEGERTerminalRuleCall_0_1_0() { return cOpINTEGERTerminalRuleCall_0_1_0; }

		//{DoubleLiteral} op=DOUBLE
		public Group getGroup_1() { return cGroup_1; }

		//{DoubleLiteral}
		public Action getDoubleLiteralAction_1_0() { return cDoubleLiteralAction_1_0; }

		//op=DOUBLE
		public Assignment getOpAssignment_1_1() { return cOpAssignment_1_1; }

		//DOUBLE
		public RuleCall getOpDOUBLETerminalRuleCall_1_1_0() { return cOpDOUBLETerminalRuleCall_1_1_0; }

		//{ColorLiteral} op=COLOR
		public Group getGroup_2() { return cGroup_2; }

		//{ColorLiteral}
		public Action getColorLiteralAction_2_0() { return cColorLiteralAction_2_0; }

		//op=COLOR
		public Assignment getOpAssignment_2_1() { return cOpAssignment_2_1; }

		//COLOR
		public RuleCall getOpCOLORTerminalRuleCall_2_1_0() { return cOpCOLORTerminalRuleCall_2_1_0; }

		//{StringLiteral} op=STRING
		public Group getGroup_3() { return cGroup_3; }

		//{StringLiteral}
		public Action getStringLiteralAction_3_0() { return cStringLiteralAction_3_0; }

		//op=STRING
		public Assignment getOpAssignment_3_1() { return cOpAssignment_3_1; }

		//STRING
		public RuleCall getOpSTRINGTerminalRuleCall_3_1_0() { return cOpSTRINGTerminalRuleCall_3_1_0; }

		//{BooleanLiteral} op=BOOLEAN
		public Group getGroup_4() { return cGroup_4; }

		//{BooleanLiteral}
		public Action getBooleanLiteralAction_4_0() { return cBooleanLiteralAction_4_0; }

		//op=BOOLEAN
		public Assignment getOpAssignment_4_1() { return cOpAssignment_4_1; }

		//BOOLEAN
		public RuleCall getOpBOOLEANTerminalRuleCall_4_1_0() { return cOpBOOLEANTerminalRuleCall_4_1_0; }

		//{ReservedLiteral} op=KEYWORD
		public Group getGroup_5() { return cGroup_5; }

		//{ReservedLiteral}
		public Action getReservedLiteralAction_5_0() { return cReservedLiteralAction_5_0; }

		//op=KEYWORD
		public Assignment getOpAssignment_5_1() { return cOpAssignment_5_1; }

		//KEYWORD
		public RuleCall getOpKEYWORDTerminalRuleCall_5_1_0() { return cOpKEYWORDTerminalRuleCall_5_1_0; }
	}
	
	
	private final EntryElements pEntry;
	private final StandaloneBlockElements pStandaloneBlock;
	private final StringEvaluatorElements pStringEvaluator;
	private final ModelElements pModel;
	private final ModelBlockElements pModelBlock;
	private final ImportElements pImport;
	private final PragmaElements pPragma;
	private final S_SectionElements pS_Section;
	private final S_GlobalElements pS_Global;
	private final S_SpeciesElements pS_Species;
	private final S_ExperimentElements pS_Experiment;
	private final StatementElements pStatement;
	private final S_1Expr_Facets_BlockOrEndElements pS_1Expr_Facets_BlockOrEnd;
	private final S_DoElements pS_Do;
	private final S_LoopElements pS_Loop;
	private final S_IfElements pS_If;
	private final S_OtherElements pS_Other;
	private final S_ReturnElements pS_Return;
	private final S_DeclarationElements pS_Declaration;
	private final S_ReflexElements pS_Reflex;
	private final S_DefinitionElements pS_Definition;
	private final S_ActionElements pS_Action;
	private final S_VarElements pS_Var;
	private final S_AssignmentElements pS_Assignment;
	private final S_DirectAssignmentElements pS_DirectAssignment;
	private final S_SetElements pS_Set;
	private final S_EquationsElements pS_Equations;
	private final S_EquationElements pS_Equation;
	private final S_SolveElements pS_Solve;
	private final S_DisplayElements pS_Display;
	private final DisplayBlockElements pDisplayBlock;
	private final DisplayStatementElements pDisplayStatement;
	private final SpeciesOrGridDisplayStatementElements pSpeciesOrGridDisplayStatement;
	private final _EquationsKeyElements p_EquationsKey;
	private final _SolveKeyElements p_SolveKey;
	private final _SpeciesKeyElements p_SpeciesKey;
	private final _ExperimentKeyElements p_ExperimentKey;
	private final _1Expr_Facets_BlockOrEnd_KeyElements p_1Expr_Facets_BlockOrEnd_Key;
	private final _LayerKeyElements p_LayerKey;
	private final _DoKeyElements p_DoKey;
	private final _VarOrConstKeyElements p_VarOrConstKey;
	private final _ReflexKeyElements p_ReflexKey;
	private final _AssignmentKeyElements p_AssignmentKey;
	private final ParametersElements pParameters;
	private final ActionArgumentsElements pActionArguments;
	private final ArgumentDefinitionElements pArgumentDefinition;
	private final FacetElements pFacet;
	private final FirstFacetKeyElements pFirstFacetKey;
	private final ClassicFacetKeyElements pClassicFacetKey;
	private final DefinitionFacetKeyElements pDefinitionFacetKey;
	private final TypeFacetKeyElements pTypeFacetKey;
	private final SpecialFacetKeyElements pSpecialFacetKey;
	private final ActionFacetKeyElements pActionFacetKey;
	private final VarFacetKeyElements pVarFacetKey;
	private final ClassicFacetElements pClassicFacet;
	private final DefinitionFacetElements pDefinitionFacet;
	private final FunctionFacetElements pFunctionFacet;
	private final TypeFacetElements pTypeFacet;
	private final ActionFacetElements pActionFacet;
	private final VarFacetElements pVarFacet;
	private final BlockElements pBlock;
	private final ExpressionElements pExpression;
	private final ArgumentPairElements pArgumentPair;
	private final PairElements pPair;
	private final IfElements pIf;
	private final OrElements pOr;
	private final AndElements pAnd;
	private final CastElements pCast;
	private final ComparisonElements pComparison;
	private final AdditionElements pAddition;
	private final MultiplicationElements pMultiplication;
	private final ExponentiationElements pExponentiation;
	private final BinaryElements pBinary;
	private final UnitElements pUnit;
	private final UnaryElements pUnary;
	private final AccessElements pAccess;
	private final PrimaryElements pPrimary;
	private final AbstractRefElements pAbstractRef;
	private final FunctionElements pFunction;
	private final CastingFunctionElements pCastingFunction;
	private final ParameterElements pParameter;
	private final ExpressionListElements pExpressionList;
	private final ParameterListElements pParameterList;
	private final UnitRefElements pUnitRef;
	private final VariableRefElements pVariableRef;
	private final TypeRefElements pTypeRef;
	private final TypeInfoElements pTypeInfo;
	private final SkillRefElements pSkillRef;
	private final ActionRefElements pActionRef;
	private final EquationRefElements pEquationRef;
	private final GamlDefinitionElements pGamlDefinition;
	private final EquationDefinitionElements pEquationDefinition;
	private final TypeDefinitionElements pTypeDefinition;
	private final VarDefinitionElements pVarDefinition;
	private final ActionDefinitionElements pActionDefinition;
	private final UnitFakeDefinitionElements pUnitFakeDefinition;
	private final TypeFakeDefinitionElements pTypeFakeDefinition;
	private final ActionFakeDefinitionElements pActionFakeDefinition;
	private final SkillFakeDefinitionElements pSkillFakeDefinition;
	private final VarFakeDefinitionElements pVarFakeDefinition;
	private final EquationFakeDefinitionElements pEquationFakeDefinition;
	private final Valid_IDElements pValid_ID;
	private final TerminalExpressionElements pTerminalExpression;
	private final TerminalRule tKEYWORD;
	private final TerminalRule tINTEGER;
	private final TerminalRule tBOOLEAN;
	private final TerminalRule tID;
	private final TerminalRule tCOLOR;
	private final TerminalRule tDOUBLE;
	private final TerminalRule tSTRING;
	private final TerminalRule tML_COMMENT;
	private final TerminalRule tSL_COMMENT;
	private final TerminalRule tWS;
	private final TerminalRule tANY_OTHER;
	
	private final Grammar grammar;

	@Inject
	public GamlGrammarAccess(GrammarProvider grammarProvider) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.pEntry = new EntryElements();
		this.pStandaloneBlock = new StandaloneBlockElements();
		this.pStringEvaluator = new StringEvaluatorElements();
		this.pModel = new ModelElements();
		this.pModelBlock = new ModelBlockElements();
		this.pImport = new ImportElements();
		this.pPragma = new PragmaElements();
		this.pS_Section = new S_SectionElements();
		this.pS_Global = new S_GlobalElements();
		this.pS_Species = new S_SpeciesElements();
		this.pS_Experiment = new S_ExperimentElements();
		this.pStatement = new StatementElements();
		this.pS_1Expr_Facets_BlockOrEnd = new S_1Expr_Facets_BlockOrEndElements();
		this.pS_Do = new S_DoElements();
		this.pS_Loop = new S_LoopElements();
		this.pS_If = new S_IfElements();
		this.pS_Other = new S_OtherElements();
		this.pS_Return = new S_ReturnElements();
		this.pS_Declaration = new S_DeclarationElements();
		this.pS_Reflex = new S_ReflexElements();
		this.pS_Definition = new S_DefinitionElements();
		this.pS_Action = new S_ActionElements();
		this.pS_Var = new S_VarElements();
		this.pS_Assignment = new S_AssignmentElements();
		this.pS_DirectAssignment = new S_DirectAssignmentElements();
		this.pS_Set = new S_SetElements();
		this.pS_Equations = new S_EquationsElements();
		this.pS_Equation = new S_EquationElements();
		this.pS_Solve = new S_SolveElements();
		this.pS_Display = new S_DisplayElements();
		this.pDisplayBlock = new DisplayBlockElements();
		this.pDisplayStatement = new DisplayStatementElements();
		this.pSpeciesOrGridDisplayStatement = new SpeciesOrGridDisplayStatementElements();
		this.p_EquationsKey = new _EquationsKeyElements();
		this.p_SolveKey = new _SolveKeyElements();
		this.p_SpeciesKey = new _SpeciesKeyElements();
		this.p_ExperimentKey = new _ExperimentKeyElements();
		this.p_1Expr_Facets_BlockOrEnd_Key = new _1Expr_Facets_BlockOrEnd_KeyElements();
		this.p_LayerKey = new _LayerKeyElements();
		this.p_DoKey = new _DoKeyElements();
		this.p_VarOrConstKey = new _VarOrConstKeyElements();
		this.p_ReflexKey = new _ReflexKeyElements();
		this.p_AssignmentKey = new _AssignmentKeyElements();
		this.pParameters = new ParametersElements();
		this.pActionArguments = new ActionArgumentsElements();
		this.pArgumentDefinition = new ArgumentDefinitionElements();
		this.pFacet = new FacetElements();
		this.pFirstFacetKey = new FirstFacetKeyElements();
		this.pClassicFacetKey = new ClassicFacetKeyElements();
		this.pDefinitionFacetKey = new DefinitionFacetKeyElements();
		this.pTypeFacetKey = new TypeFacetKeyElements();
		this.pSpecialFacetKey = new SpecialFacetKeyElements();
		this.pActionFacetKey = new ActionFacetKeyElements();
		this.pVarFacetKey = new VarFacetKeyElements();
		this.pClassicFacet = new ClassicFacetElements();
		this.pDefinitionFacet = new DefinitionFacetElements();
		this.pFunctionFacet = new FunctionFacetElements();
		this.pTypeFacet = new TypeFacetElements();
		this.pActionFacet = new ActionFacetElements();
		this.pVarFacet = new VarFacetElements();
		this.pBlock = new BlockElements();
		this.pExpression = new ExpressionElements();
		this.pArgumentPair = new ArgumentPairElements();
		this.pPair = new PairElements();
		this.pIf = new IfElements();
		this.pOr = new OrElements();
		this.pAnd = new AndElements();
		this.pCast = new CastElements();
		this.pComparison = new ComparisonElements();
		this.pAddition = new AdditionElements();
		this.pMultiplication = new MultiplicationElements();
		this.pExponentiation = new ExponentiationElements();
		this.pBinary = new BinaryElements();
		this.pUnit = new UnitElements();
		this.pUnary = new UnaryElements();
		this.pAccess = new AccessElements();
		this.pPrimary = new PrimaryElements();
		this.pAbstractRef = new AbstractRefElements();
		this.pFunction = new FunctionElements();
		this.pCastingFunction = new CastingFunctionElements();
		this.pParameter = new ParameterElements();
		this.pExpressionList = new ExpressionListElements();
		this.pParameterList = new ParameterListElements();
		this.pUnitRef = new UnitRefElements();
		this.pVariableRef = new VariableRefElements();
		this.pTypeRef = new TypeRefElements();
		this.pTypeInfo = new TypeInfoElements();
		this.pSkillRef = new SkillRefElements();
		this.pActionRef = new ActionRefElements();
		this.pEquationRef = new EquationRefElements();
		this.pGamlDefinition = new GamlDefinitionElements();
		this.pEquationDefinition = new EquationDefinitionElements();
		this.pTypeDefinition = new TypeDefinitionElements();
		this.pVarDefinition = new VarDefinitionElements();
		this.pActionDefinition = new ActionDefinitionElements();
		this.pUnitFakeDefinition = new UnitFakeDefinitionElements();
		this.pTypeFakeDefinition = new TypeFakeDefinitionElements();
		this.pActionFakeDefinition = new ActionFakeDefinitionElements();
		this.pSkillFakeDefinition = new SkillFakeDefinitionElements();
		this.pVarFakeDefinition = new VarFakeDefinitionElements();
		this.pEquationFakeDefinition = new EquationFakeDefinitionElements();
		this.pValid_ID = new Valid_IDElements();
		this.pTerminalExpression = new TerminalExpressionElements();
		this.tKEYWORD = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.KEYWORD");
		this.tINTEGER = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.INTEGER");
		this.tBOOLEAN = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.BOOLEAN");
		this.tID = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.ID");
		this.tCOLOR = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.COLOR");
		this.tDOUBLE = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.DOUBLE");
		this.tSTRING = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.STRING");
		this.tML_COMMENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.ML_COMMENT");
		this.tSL_COMMENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.SL_COMMENT");
		this.tWS = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.WS");
		this.tANY_OTHER = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "msi.gama.lang.gaml.Gaml.ANY_OTHER");
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("msi.gama.lang.gaml.Gaml".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	

	
	//Entry:
	//	Model | StringEvaluator | StandaloneBlock;
	public EntryElements getEntryAccess() {
		return pEntry;
	}
	
	public ParserRule getEntryRule() {
		return getEntryAccess().getRule();
	}

	//StandaloneBlock:
	//	'__synthetic__' block=Block;
	public StandaloneBlockElements getStandaloneBlockAccess() {
		return pStandaloneBlock;
	}
	
	public ParserRule getStandaloneBlockRule() {
		return getStandaloneBlockAccess().getRule();
	}

	//StringEvaluator:
	//	toto=ID "<-" expr=Expression;
	public StringEvaluatorElements getStringEvaluatorAccess() {
		return pStringEvaluator;
	}
	
	public ParserRule getStringEvaluatorRule() {
		return getStringEvaluatorAccess().getRule();
	}

	//Model:
	//	pragmas+=Pragma* 'model' name=ID imports+=Import* block=ModelBlock;
	public ModelElements getModelAccess() {
		return pModel;
	}
	
	public ParserRule getModelRule() {
		return getModelAccess().getRule();
	}

	//ModelBlock Block:
	//	{Block} statements+=S_Section*
	public ModelBlockElements getModelBlockAccess() {
		return pModelBlock;
	}
	
	public ParserRule getModelBlockRule() {
		return getModelBlockAccess().getRule();
	}

	//Import:
	//	'import' importURI=STRING ("as" name=Valid_ID)?;
	public ImportElements getImportAccess() {
		return pImport;
	}
	
	public ParserRule getImportRule() {
		return getImportAccess().getRule();
	}

	//// must be named importURI
	//Pragma:
	//	'@' name=ID;
	public PragmaElements getPragmaAccess() {
		return pPragma;
	}
	
	public ParserRule getPragmaRule() {
		return getPragmaAccess().getRule();
	}

	/// **
	// * Global statements
	// * / S_Section Statement:
	//	S_Global | S_Species | S_Experiment
	public S_SectionElements getS_SectionAccess() {
		return pS_Section;
	}
	
	public ParserRule getS_SectionRule() {
		return getS_SectionAccess().getRule();
	}

	//S_Global:
	//	key="global" facets+=Facet* (block=Block | ';');
	public S_GlobalElements getS_GlobalAccess() {
		return pS_Global;
	}
	
	public ParserRule getS_GlobalRule() {
		return getS_GlobalAccess().getRule();
	}

	//S_Species:
	//	key=_SpeciesKey firstFacet='name:'? name=ID facets+=Facet* (block=Block | ';');
	public S_SpeciesElements getS_SpeciesAccess() {
		return pS_Species;
	}
	
	public ParserRule getS_SpeciesRule() {
		return getS_SpeciesAccess().getRule();
	}

	//S_Experiment:
	//	key=_ExperimentKey firstFacet="name:"? name=(Valid_ID | STRING) facets+=Facet* (block=Block | ';');
	public S_ExperimentElements getS_ExperimentAccess() {
		return pS_Experiment;
	}
	
	public ParserRule getS_ExperimentRule() {
		return getS_ExperimentAccess().getRule();
	}

	/// **
	// * Statements
	// * / Statement:
	//	(=> S_Declaration | (=> S_Assignment | S_1Expr_Facets_BlockOrEnd | S_Other | S_Do | S_Return | S_Solve | S_If |
	//	S_Equations)) | S_Display;
	public StatementElements getStatementAccess() {
		return pStatement;
	}
	
	public ParserRule getStatementRule() {
		return getStatementAccess().getRule();
	}

	//S_1Expr_Facets_BlockOrEnd Statement:
	//	key=_1Expr_Facets_BlockOrEnd_Key firstFacet=FirstFacetKey? (=> expr=Expression | expr=TypeRef) facets+=Facet*
	//	(block=Block | ";")
	public S_1Expr_Facets_BlockOrEndElements getS_1Expr_Facets_BlockOrEndAccess() {
		return pS_1Expr_Facets_BlockOrEnd;
	}
	
	public ParserRule getS_1Expr_Facets_BlockOrEndRule() {
		return getS_1Expr_Facets_BlockOrEndAccess().getRule();
	}

	//S_Do:
	//	key=_DoKey firstFacet="action:"? expr=AbstractRef facets+=Facet* (block=Block | ';');
	public S_DoElements getS_DoAccess() {
		return pS_Do;
	}
	
	public ParserRule getS_DoRule() {
		return getS_DoAccess().getRule();
	}

	//S_Loop:
	//	key="loop" name=ID? facets+=Facet* block=Block;
	public S_LoopElements getS_LoopAccess() {
		return pS_Loop;
	}
	
	public ParserRule getS_LoopRule() {
		return getS_LoopAccess().getRule();
	}

	//S_If:
	//	key='if' firstFacet="condition:"? expr=Expression block=Block (=> 'else' else=(S_If | Block))?;
	public S_IfElements getS_IfAccess() {
		return pS_If;
	}
	
	public ParserRule getS_IfRule() {
		return getS_IfAccess().getRule();
	}

	//S_Other:
	//	key=ID facets+=Facet* (block=Block | ';');
	public S_OtherElements getS_OtherAccess() {
		return pS_Other;
	}
	
	public ParserRule getS_OtherRule() {
		return getS_OtherAccess().getRule();
	}

	//S_Return:
	//	key='return' firstFacet="value:"? expr=Expression? ';';
	public S_ReturnElements getS_ReturnAccess() {
		return pS_Return;
	}
	
	public ParserRule getS_ReturnRule() {
		return getS_ReturnAccess().getRule();
	}

	/// *
	// * DECLARATIONS
	// * / S_Declaration:
	//	=> S_Definition | S_Species | S_Reflex | S_Action | S_Var | S_Loop;
	public S_DeclarationElements getS_DeclarationAccess() {
		return pS_Declaration;
	}
	
	public ParserRule getS_DeclarationRule() {
		return getS_DeclarationAccess().getRule();
	}

	//S_Reflex:
	//	key=_ReflexKey firstFacet="name:"? name=Valid_ID? ("when" ":" expr=Expression)? block=Block;
	public S_ReflexElements getS_ReflexAccess() {
		return pS_Reflex;
	}
	
	public ParserRule getS_ReflexRule() {
		return getS_ReflexAccess().getRule();
	}

	//S_Definition:
	//	tkey=TypeRef firstFacet="name:"? name=(Valid_ID | STRING) ('(' args=ActionArguments ')')? facets+=Facet* (block=Block
	//	| ';');
	public S_DefinitionElements getS_DefinitionAccess() {
		return pS_Definition;
	}
	
	public ParserRule getS_DefinitionRule() {
		return getS_DefinitionAccess().getRule();
	}

	//S_Action S_Definition:
	//	{S_Action} key="action" firstFacet='name:'? name=Valid_ID ('(' args=ActionArguments ')')? facets+=Facet* (block=Block
	//	| ';')
	public S_ActionElements getS_ActionAccess() {
		return pS_Action;
	}
	
	public ParserRule getS_ActionRule() {
		return getS_ActionAccess().getRule();
	}

	//S_Var S_Definition:
	//	{S_Var} key=_VarOrConstKey firstFacet="name:"? name=Valid_ID facets+=Facet* ';'
	public S_VarElements getS_VarAccess() {
		return pS_Var;
	}
	
	public ParserRule getS_VarRule() {
		return getS_VarAccess().getRule();
	}

	/// *
	// * ASSIGNMENTS
	// * / S_Assignment:
	//	S_DirectAssignment | S_Set;
	public S_AssignmentElements getS_AssignmentAccess() {
		return pS_Assignment;
	}
	
	public ParserRule getS_AssignmentRule() {
		return getS_AssignmentAccess().getRule();
	}

	//S_DirectAssignment:
	//	(expr=Expression key=_AssignmentKey value=Expression facets+=Facet*) ';';
	public S_DirectAssignmentElements getS_DirectAssignmentAccess() {
		return pS_DirectAssignment;
	}
	
	public ParserRule getS_DirectAssignmentRule() {
		return getS_DirectAssignmentAccess().getRule();
	}

	//S_Set:
	//	key="set" expr=Expression ("value:" | "<-") value=Expression ";";
	public S_SetElements getS_SetAccess() {
		return pS_Set;
	}
	
	public ParserRule getS_SetRule() {
		return getS_SetAccess().getRule();
	}

	//S_Equations:
	//	key=_EquationsKey name=Valid_ID facets+=Facet* ('{' (equations+=S_Equation ';')* '}' | ';');
	public S_EquationsElements getS_EquationsAccess() {
		return pS_Equations;
	}
	
	public ParserRule getS_EquationsRule() {
		return getS_EquationsAccess().getRule();
	}

	//S_Equation S_Assignment:
	//	expr=(Function | VariableRef) key="=" value=Expression
	public S_EquationElements getS_EquationAccess() {
		return pS_Equation;
	}
	
	public ParserRule getS_EquationRule() {
		return getS_EquationAccess().getRule();
	}

	//S_Solve:
	//	key=_SolveKey firstFacet="equation:"? expr=EquationRef facets+=Facet* (block=Block | ';');
	public S_SolveElements getS_SolveAccess() {
		return pS_Solve;
	}
	
	public ParserRule getS_SolveRule() {
		return getS_SolveAccess().getRule();
	}

	/// **
	// * DISPLAYS
	// * / //S_Monitor:
	////	key="monitor" (firstFacet="name:")? name=(Valid_ID|STRING) facets+=Facet ";"
	////;
	//S_Display:
	//	key="display" firstFacet="name:"? name=(Valid_ID | STRING) facets+=Facet* block=displayBlock;
	public S_DisplayElements getS_DisplayAccess() {
		return pS_Display;
	}
	
	public ParserRule getS_DisplayRule() {
		return getS_DisplayAccess().getRule();
	}

	//displayBlock Block:
	//	{Block} '{' statements+=displayStatement* '}'
	public DisplayBlockElements getDisplayBlockAccess() {
		return pDisplayBlock;
	}
	
	public ParserRule getDisplayBlockRule() {
		return getDisplayBlockAccess().getRule();
	}

	////
	////ExperimentBlock returns Block:
	////	{Block} '{' (statements+=Statement)* '}'
	////;
	////experimentStatement returns Statement:
	////	Statement | S_Output
	////;
	////
	////
	////S_Output returns Statement:
	////	key=("output"|"permanent") (facets+=Facet)* block=outputBlock?
	////;
	////outputBlock returns Block:
	////	{Block} '{' (statements += outputStatement)* '}'
	////;
	////outputStatement returns Statement:
	////	Statement | S_Display 
	////;
	//displayStatement Statement:
	//	speciesOrGridDisplayStatement | S_1Expr_Facets_BlockOrEnd
	public DisplayStatementElements getDisplayStatementAccess() {
		return pDisplayStatement;
	}
	
	public ParserRule getDisplayStatementRule() {
		return getDisplayStatementAccess().getRule();
	}

	//speciesOrGridDisplayStatement:
	//	key=_SpeciesKey expr=Expression facets+=Facet* (block=displayBlock | ";");
	public SpeciesOrGridDisplayStatementElements getSpeciesOrGridDisplayStatementAccess() {
		return pSpeciesOrGridDisplayStatement;
	}
	
	public ParserRule getSpeciesOrGridDisplayStatementRule() {
		return getSpeciesOrGridDisplayStatementAccess().getRule();
	}

	/// **
	// * Statement keys
	// * / _EquationsKey:
	//	"equation";
	public _EquationsKeyElements get_EquationsKeyAccess() {
		return p_EquationsKey;
	}
	
	public ParserRule get_EquationsKeyRule() {
		return get_EquationsKeyAccess().getRule();
	}

	//_SolveKey:
	//	"solve";
	public _SolveKeyElements get_SolveKeyAccess() {
		return p_SolveKey;
	}
	
	public ParserRule get_SolveKeyRule() {
		return get_SolveKeyAccess().getRule();
	}

	//_SpeciesKey:
	//	"species" | "grid";
	public _SpeciesKeyElements get_SpeciesKeyAccess() {
		return p_SpeciesKey;
	}
	
	public ParserRule get_SpeciesKeyRule() {
		return get_SpeciesKeyAccess().getRule();
	}

	//_ExperimentKey:
	//	"experiment";
	public _ExperimentKeyElements get_ExperimentKeyAccess() {
		return p_ExperimentKey;
	}
	
	public ParserRule get_ExperimentKeyRule() {
		return get_ExperimentKeyAccess().getRule();
	}

	//_1Expr_Facets_BlockOrEnd_Key:
	//	_LayerKey | "ask" | "release" | "capture" | "create" | "write" | "error" | "warn" | "exception" | "save" | "assert" |
	//	"inspect" | "browse" |
	//	"draw" | "using" | "switch" | "put" | "add" | "remove" | "match" | "match_between" | "match_one" | "parameter" |
	//	"status" | "highlight" | "focus_on";
	public _1Expr_Facets_BlockOrEnd_KeyElements get_1Expr_Facets_BlockOrEnd_KeyAccess() {
		return p_1Expr_Facets_BlockOrEnd_Key;
	}
	
	public ParserRule get_1Expr_Facets_BlockOrEnd_KeyRule() {
		return get_1Expr_Facets_BlockOrEnd_KeyAccess().getRule();
	}

	//_LayerKey:
	//	"light" | "camera" | "text" | "image" | "data" | "chart" | "agents" | "graphics" | "display_population" |
	//	"display_grid" | "quadtree" | "event" | "overlay" | "datalist";
	public _LayerKeyElements get_LayerKeyAccess() {
		return p_LayerKey;
	}
	
	public ParserRule get_LayerKeyRule() {
		return get_LayerKeyAccess().getRule();
	}

	//_DoKey:
	//	"do";
	public _DoKeyElements get_DoKeyAccess() {
		return p_DoKey;
	}
	
	public ParserRule get_DoKeyRule() {
		return get_DoKeyAccess().getRule();
	}

	//_VarOrConstKey:
	//	"var" | "const" | "let" | "arg";
	public _VarOrConstKeyElements get_VarOrConstKeyAccess() {
		return p_VarOrConstKey;
	}
	
	public ParserRule get_VarOrConstKeyRule() {
		return get_VarOrConstKeyAccess().getRule();
	}

	//_ReflexKey:
	//	"init" | "reflex" | "aspect";
	public _ReflexKeyElements get_ReflexKeyAccess() {
		return p_ReflexKey;
	}
	
	public ParserRule get_ReflexKeyRule() {
		return get_ReflexKeyAccess().getRule();
	}

	//_AssignmentKey:
	//	"<-" | "<<" | '>' '>' | "<<+" | '>' '>-' | "+<-" | "<+" | ">-";
	public _AssignmentKeyElements get_AssignmentKeyAccess() {
		return p_AssignmentKey;
	}
	
	public ParserRule get_AssignmentKeyRule() {
		return get_AssignmentKeyAccess().getRule();
	}

	/// **
	// * Parameters and arguments
	// * / Parameters:
	//	{Parameters} params=ParameterList?;
	public ParametersElements getParametersAccess() {
		return pParameters;
	}
	
	public ParserRule getParametersRule() {
		return getParametersAccess().getRule();
	}

	//ActionArguments:
	//	args+=ArgumentDefinition (',' args+=ArgumentDefinition)*;
	public ActionArgumentsElements getActionArgumentsAccess() {
		return pActionArguments;
	}
	
	public ParserRule getActionArgumentsRule() {
		return getActionArgumentsAccess().getRule();
	}

	//ArgumentDefinition:
	//	type=TypeRef name=Valid_ID ('<-' default=Expression)?;
	public ArgumentDefinitionElements getArgumentDefinitionAccess() {
		return pArgumentDefinition;
	}
	
	public ParserRule getArgumentDefinitionRule() {
		return getArgumentDefinitionAccess().getRule();
	}

	/// **
	// * Facets
	// * / Facet:
	//	DefinitionFacet | FunctionFacet | ClassicFacet | TypeFacet | VarFacet | ActionFacet;
	public FacetElements getFacetAccess() {
		return pFacet;
	}
	
	public ParserRule getFacetRule() {
		return getFacetAccess().getRule();
	}

	//FirstFacetKey:
	//	DefinitionFacetKey | TypeFacetKey | SpecialFacetKey | VarFacetKey | ActionFacetKey | ClassicFacetKey;
	public FirstFacetKeyElements getFirstFacetKeyAccess() {
		return pFirstFacetKey;
	}
	
	public ParserRule getFirstFacetKeyRule() {
		return getFirstFacetKeyAccess().getRule();
	}

	//ClassicFacetKey:
	//	ID ':';
	public ClassicFacetKeyElements getClassicFacetKeyAccess() {
		return pClassicFacetKey;
	}
	
	public ParserRule getClassicFacetKeyRule() {
		return getClassicFacetKeyAccess().getRule();
	}

	//DefinitionFacetKey:
	//	"name:" | "returns:";
	public DefinitionFacetKeyElements getDefinitionFacetKeyAccess() {
		return pDefinitionFacetKey;
	}
	
	public ParserRule getDefinitionFacetKeyRule() {
		return getDefinitionFacetKeyAccess().getRule();
	}

	/// *| "var:" * / TypeFacetKey:
	//	"as:" | "of:" | "parent:" | "species:" | "type:";
	public TypeFacetKeyElements getTypeFacetKeyAccess() {
		return pTypeFacetKey;
	}
	
	public ParserRule getTypeFacetKeyRule() {
		return getTypeFacetKeyAccess().getRule();
	}

	//SpecialFacetKey:
	//	'data:' | 'when' ':' | "const:" | "value:" | "topology:" | "item:" | "init:" | "message:" | "control:" |
	//	"environment:" | 'text:' | 'image:' | 'using:' | "parameter:" | "aspect:" | "light:";
	public SpecialFacetKeyElements getSpecialFacetKeyAccess() {
		return pSpecialFacetKey;
	}
	
	public ParserRule getSpecialFacetKeyRule() {
		return getSpecialFacetKeyAccess().getRule();
	}

	//ActionFacetKey:
	//	"action:" | "on_change:";
	public ActionFacetKeyElements getActionFacetKeyAccess() {
		return pActionFacetKey;
	}
	
	public ParserRule getActionFacetKeyRule() {
		return getActionFacetKeyAccess().getRule();
	}

	//VarFacetKey:
	//	"var:";
	public VarFacetKeyElements getVarFacetKeyAccess() {
		return pVarFacetKey;
	}
	
	public ParserRule getVarFacetKeyRule() {
		return getVarFacetKeyAccess().getRule();
	}

	//ClassicFacet Facet:
	//	(key=ClassicFacetKey | key='<-' | key=SpecialFacetKey) expr=Expression
	public ClassicFacetElements getClassicFacetAccess() {
		return pClassicFacet;
	}
	
	public ParserRule getClassicFacetRule() {
		return getClassicFacetAccess().getRule();
	}

	//DefinitionFacet Facet:
	//	=> key=DefinitionFacetKey name=(Valid_ID | STRING)
	public DefinitionFacetElements getDefinitionFacetAccess() {
		return pDefinitionFacet;
	}
	
	public ParserRule getDefinitionFacetRule() {
		return getDefinitionFacetAccess().getRule();
	}

	//FunctionFacet Facet:
	//	(key='function:' | key='->') '{' expr=Expression '}'
	public FunctionFacetElements getFunctionFacetAccess() {
		return pFunctionFacet;
	}
	
	public ParserRule getFunctionFacetRule() {
		return getFunctionFacetAccess().getRule();
	}

	//TypeFacet Facet:
	//	key=TypeFacetKey (=> (expr=TypeRef) | expr=Expression)
	public TypeFacetElements getTypeFacetAccess() {
		return pTypeFacet;
	}
	
	public ParserRule getTypeFacetRule() {
		return getTypeFacetAccess().getRule();
	}

	//ActionFacet Facet:
	//	key=ActionFacetKey (expr=ActionRef | block=Block)
	public ActionFacetElements getActionFacetAccess() {
		return pActionFacet;
	}
	
	public ParserRule getActionFacetRule() {
		return getActionFacetAccess().getRule();
	}

	//VarFacet Facet:
	//	key=VarFacetKey expr=VariableRef
	public VarFacetElements getVarFacetAccess() {
		return pVarFacet;
	}
	
	public ParserRule getVarFacetRule() {
		return getVarFacetAccess().getRule();
	}

	/// **
	// * Blocks. An ordered list of statements inside curly brackets
	// * / Block:
	//	{Block} '{' (=> (function=Expression '}') | statements+=Statement* '}');
	public BlockElements getBlockAccess() {
		return pBlock;
	}
	
	public ParserRule getBlockRule() {
		return getBlockAccess().getRule();
	}

	/// **
	// * Expressions
	// * / Expression:
	//	ArgumentPair | Pair;
	public ExpressionElements getExpressionAccess() {
		return pExpression;
	}
	
	public ParserRule getExpressionRule() {
		return getExpressionAccess().getRule();
	}

	//ArgumentPair:
	//	=> (op=Valid_ID '::' | op=(DefinitionFacetKey | TypeFacetKey | SpecialFacetKey | ActionFacetKey | VarFacetKey) ':')?
	//	right=If;
	public ArgumentPairElements getArgumentPairAccess() {
		return pArgumentPair;
	}
	
	public ParserRule getArgumentPairRule() {
		return getArgumentPairAccess().getRule();
	}

	//Pair Expression:
	//	If (({Pair.left=current} op='::') right=If)?
	public PairElements getPairAccess() {
		return pPair;
	}
	
	public ParserRule getPairRule() {
		return getPairAccess().getRule();
	}

	//If Expression:
	//	Or ({If.left=current} op='?'
	//	right=Or (':'
	//	ifFalse=Or))?
	public IfElements getIfAccess() {
		return pIf;
	}
	
	public ParserRule getIfRule() {
		return getIfAccess().getRule();
	}

	//Or Expression:
	//	And ({Expression.left=current} op='or'
	//	right=And)*
	public OrElements getOrAccess() {
		return pOr;
	}
	
	public ParserRule getOrRule() {
		return getOrAccess().getRule();
	}

	//And Expression:
	//	Cast ({Expression.left=current} op='and'
	//	right=Cast)*
	public AndElements getAndAccess() {
		return pAnd;
	}
	
	public ParserRule getAndRule() {
		return getAndAccess().getRule();
	}

	//Cast Expression:
	//	Comparison (({Cast.left=current} op='as') (right=TypeRef | '(' right=TypeRef ')'))?
	public CastElements getCastAccess() {
		return pCast;
	}
	
	public ParserRule getCastRule() {
		return getCastAccess().getRule();
	}

	//Comparison Expression:
	//	Addition (({Expression.left=current} op=('!=' | '=' | '>=' | '<=' | '<' | '>')) right=Addition)?
	public ComparisonElements getComparisonAccess() {
		return pComparison;
	}
	
	public ParserRule getComparisonRule() {
		return getComparisonAccess().getRule();
	}

	//Addition Expression:
	//	Multiplication (({Expression.left=current} op=('+' | '-')) right=Multiplication)*
	public AdditionElements getAdditionAccess() {
		return pAddition;
	}
	
	public ParserRule getAdditionRule() {
		return getAdditionAccess().getRule();
	}

	//Multiplication Expression:
	//	Exponentiation (({Expression.left=current} op=('*' | '/')) right=Exponentiation)*
	public MultiplicationElements getMultiplicationAccess() {
		return pMultiplication;
	}
	
	public ParserRule getMultiplicationRule() {
		return getMultiplicationAccess().getRule();
	}

	//Exponentiation Expression:
	//	Binary (({Expression.left=current} op='^') right=Binary)*
	public ExponentiationElements getExponentiationAccess() {
		return pExponentiation;
	}
	
	public ParserRule getExponentiationRule() {
		return getExponentiationAccess().getRule();
	}

	//Binary Expression:
	//	Unit (({Binary.left=current} op=Valid_ID) right=Unit)*
	public BinaryElements getBinaryAccess() {
		return pBinary;
	}
	
	public ParserRule getBinaryRule() {
		return getBinaryAccess().getRule();
	}

	//// NEW: Units are now expressed using the "°" symbol
	//Unit Expression:
	//	Unary (({Unit.left=current} op=('°' | "#")) right=UnitRef)?
	public UnitElements getUnitAccess() {
		return pUnit;
	}
	
	public ParserRule getUnitRule() {
		return getUnitAccess().getRule();
	}

	//Unary Expression:
	//	Access | {Unary} (op=('°' | '#') right=UnitRef | op=('-' | '!' | 'my' | 'the' | 'not') right=Unary)
	public UnaryElements getUnaryAccess() {
		return pUnary;
	}
	
	public ParserRule getUnaryRule() {
		return getUnaryAccess().getRule();
	}

	////Access returns Expression:
	////	Primary ({Access.left = current} ((op='[' args=ExpressionList? ']') | (op="." right=AbstractRef)))*
	////;
	//Access Expression:
	//	Primary ({Access.left=current} (op='[' args=ExpressionList? ']' | op="." right=AbstractRef | op="."
	//	named_exp=STRING))*
	public AccessElements getAccessAccess() {
		return pAccess;
	}
	
	public ParserRule getAccessRule() {
		return getAccessAccess().getRule();
	}

	//Primary Expression:
	//	TerminalExpression | AbstractRef |
	//	'(' ExpressionList ')' |
	//	'(' {Parameters} params=ParameterList? ')' |
	//	'[' {Array} exprs=ExpressionList? ']' |
	//	'{' {Point} left=Expression op=',' right=Expression (',' z=Expression)? '}'
	public PrimaryElements getPrimaryAccess() {
		return pPrimary;
	}
	
	public ParserRule getPrimaryRule() {
		return getPrimaryAccess().getRule();
	}

	//AbstractRef Expression:
	//	Function | (=> CastingFunction | VariableRef)
	public AbstractRefElements getAbstractRefAccess() {
		return pAbstractRef;
	}
	
	public ParserRule getAbstractRefRule() {
		return getAbstractRefAccess().getRule();
	}

	//Function Expression:
	//	{Function} action=ActionRef '(' (parameters=Parameters | args=ExpressionList) ')'
	public FunctionElements getFunctionAccess() {
		return pFunction;
	}
	
	public ParserRule getFunctionRule() {
		return getFunctionAccess().getRule();
	}

	//CastingFunction Function:
	//	action=ActionRef type=TypeInfo "(" args=ExpressionList ')'
	public CastingFunctionElements getCastingFunctionAccess() {
		return pCastingFunction;
	}
	
	public ParserRule getCastingFunctionRule() {
		return getCastingFunctionAccess().getRule();
	}

	//Parameter Expression:
	//	{Parameter} (builtInFacetKey=(DefinitionFacetKey | TypeFacetKey | SpecialFacetKey | ActionFacetKey | VarFacetKey) |
	//	left=VariableRef ':') right=Expression
	public ParameterElements getParameterAccess() {
		return pParameter;
	}
	
	public ParserRule getParameterRule() {
		return getParameterAccess().getRule();
	}

	//ExpressionList:
	//	exprs+=Expression (',' exprs+=Expression)*;
	public ExpressionListElements getExpressionListAccess() {
		return pExpressionList;
	}
	
	public ParserRule getExpressionListRule() {
		return getExpressionListAccess().getRule();
	}

	//ParameterList ExpressionList:
	//	exprs+=Parameter (',' exprs+=Parameter)*
	public ParameterListElements getParameterListAccess() {
		return pParameterList;
	}
	
	public ParserRule getParameterListRule() {
		return getParameterListAccess().getRule();
	}

	//UnitRef Expression:
	//	{UnitName} ref=[UnitFakeDefinition]
	public UnitRefElements getUnitRefAccess() {
		return pUnitRef;
	}
	
	public ParserRule getUnitRefRule() {
		return getUnitRefAccess().getRule();
	}

	//VariableRef:
	//	{VariableRef} ref=[VarDefinition|Valid_ID];
	public VariableRefElements getVariableRefAccess() {
		return pVariableRef;
	}
	
	public ParserRule getVariableRefRule() {
		return getVariableRefAccess().getRule();
	}

	//TypeRef Expression:
	//	{TypeRef} (ref=[TypeDefinition] parameter=TypeInfo?) | {TypeRef} ("species" parameter=TypeInfo)
	public TypeRefElements getTypeRefAccess() {
		return pTypeRef;
	}
	
	public ParserRule getTypeRefRule() {
		return getTypeRefAccess().getRule();
	}

	//TypeInfo:
	//	'<' first=TypeRef ("," second=TypeRef)? => '>';
	public TypeInfoElements getTypeInfoAccess() {
		return pTypeInfo;
	}
	
	public ParserRule getTypeInfoRule() {
		return getTypeInfoAccess().getRule();
	}

	//SkillRef Expression:
	//	{SkillRef} ref=[SkillFakeDefinition]
	public SkillRefElements getSkillRefAccess() {
		return pSkillRef;
	}
	
	public ParserRule getSkillRefRule() {
		return getSkillRefAccess().getRule();
	}

	//ActionRef Expression:
	//	{ActionRef} ref=[ActionDefinition|Valid_ID]
	public ActionRefElements getActionRefAccess() {
		return pActionRef;
	}
	
	public ParserRule getActionRefRule() {
		return getActionRefAccess().getRule();
	}

	//EquationRef Expression:
	//	{EquationRef} ref=[EquationDefinition|Valid_ID]
	public EquationRefElements getEquationRefAccess() {
		return pEquationRef;
	}
	
	public ParserRule getEquationRefRule() {
		return getEquationRefAccess().getRule();
	}

	//GamlDefinition:
	//	TypeDefinition | VarDefinition | UnitFakeDefinition | SkillFakeDefinition | ActionDefinition | EquationDefinition;
	public GamlDefinitionElements getGamlDefinitionAccess() {
		return pGamlDefinition;
	}
	
	public ParserRule getGamlDefinitionRule() {
		return getGamlDefinitionAccess().getRule();
	}

	//EquationDefinition:
	//	S_Equations | EquationFakeDefinition;
	public EquationDefinitionElements getEquationDefinitionAccess() {
		return pEquationDefinition;
	}
	
	public ParserRule getEquationDefinitionRule() {
		return getEquationDefinitionAccess().getRule();
	}

	//TypeDefinition:
	//	S_Species / *| S_Experiment |* / | TypeFakeDefinition;
	public TypeDefinitionElements getTypeDefinitionAccess() {
		return pTypeDefinition;
	}
	
	public ParserRule getTypeDefinitionRule() {
		return getTypeDefinitionAccess().getRule();
	}

	//VarDefinition:
	//	=> S_Declaration | (Model | ArgumentDefinition | DefinitionFacet | VarFakeDefinition | Import | S_Experiment);
	public VarDefinitionElements getVarDefinitionAccess() {
		return pVarDefinition;
	}
	
	public ParserRule getVarDefinitionRule() {
		return getVarDefinitionAccess().getRule();
	}

	//ActionDefinition:
	//	S_Action | ActionFakeDefinition | S_Definition | TypeDefinition;
	public ActionDefinitionElements getActionDefinitionAccess() {
		return pActionDefinition;
	}
	
	public ParserRule getActionDefinitionRule() {
		return getActionDefinitionAccess().getRule();
	}

	//// Fake Definitions produced by the global scope provider
	//UnitFakeDefinition:
	//	'**unit*' name=ID;
	public UnitFakeDefinitionElements getUnitFakeDefinitionAccess() {
		return pUnitFakeDefinition;
	}
	
	public ParserRule getUnitFakeDefinitionRule() {
		return getUnitFakeDefinitionAccess().getRule();
	}

	//TypeFakeDefinition:
	//	'**type*' name=ID;
	public TypeFakeDefinitionElements getTypeFakeDefinitionAccess() {
		return pTypeFakeDefinition;
	}
	
	public ParserRule getTypeFakeDefinitionRule() {
		return getTypeFakeDefinitionAccess().getRule();
	}

	//ActionFakeDefinition:
	//	'**action*' name=Valid_ID;
	public ActionFakeDefinitionElements getActionFakeDefinitionAccess() {
		return pActionFakeDefinition;
	}
	
	public ParserRule getActionFakeDefinitionRule() {
		return getActionFakeDefinitionAccess().getRule();
	}

	//SkillFakeDefinition:
	//	'**skill*' name=ID;
	public SkillFakeDefinitionElements getSkillFakeDefinitionAccess() {
		return pSkillFakeDefinition;
	}
	
	public ParserRule getSkillFakeDefinitionRule() {
		return getSkillFakeDefinitionAccess().getRule();
	}

	//VarFakeDefinition:
	//	'**var*' name=Valid_ID;
	public VarFakeDefinitionElements getVarFakeDefinitionAccess() {
		return pVarFakeDefinition;
	}
	
	public ParserRule getVarFakeDefinitionRule() {
		return getVarFakeDefinitionAccess().getRule();
	}

	//EquationFakeDefinition:
	//	'**equation*' name=Valid_ID;
	public EquationFakeDefinitionElements getEquationFakeDefinitionAccess() {
		return pEquationFakeDefinition;
	}
	
	public ParserRule getEquationFakeDefinitionRule() {
		return getEquationFakeDefinitionAccess().getRule();
	}

	//Valid_ID:
	//	_SpeciesKey | _DoKey | _ReflexKey | _VarOrConstKey | _1Expr_Facets_BlockOrEnd_Key | _EquationsKey | ID |
	//	_ExperimentKey;
	public Valid_IDElements getValid_IDAccess() {
		return pValid_ID;
	}
	
	public ParserRule getValid_IDRule() {
		return getValid_IDAccess().getRule();
	}

	/// **
	// * Terminals
	// * / TerminalExpression:
	//	{IntLiteral} op=INTEGER | {DoubleLiteral} op=DOUBLE | {ColorLiteral} op=COLOR | {StringLiteral} op=STRING |
	//	{BooleanLiteral} op=BOOLEAN | {ReservedLiteral} op=KEYWORD;
	public TerminalExpressionElements getTerminalExpressionAccess() {
		return pTerminalExpression;
	}
	
	public ParserRule getTerminalExpressionRule() {
		return getTerminalExpressionAccess().getRule();
	}

	//terminal KEYWORD:
	//	'each' | 'self' | 'myself' | 'nil' | 'world';
	public TerminalRule getKEYWORDRule() {
		return tKEYWORD;
	} 

	//terminal INTEGER:
	//	'0' | '1'..'9' '0'..'9'*;
	public TerminalRule getINTEGERRule() {
		return tINTEGER;
	} 

	//terminal BOOLEAN:
	//	'true' | 'false';
	public TerminalRule getBOOLEANRule() {
		return tBOOLEAN;
	} 

	//terminal ID:
	//	('a'..'z' | 'A'..'Z' | '_' | '$') ('a'..'z' | 'A'..'Z' | '_' | '$' | '0'..'9')*;
	public TerminalRule getIDRule() {
		return tID;
	} 

	//terminal COLOR:
	//	'#' ('0'..'9' | 'A'..'F')+;
	public TerminalRule getCOLORRule() {
		return tCOLOR;
	} 

	//terminal DOUBLE:
	//	'1'..'9' '0'..'9'* ('.' '0'..'9'+)? (('E' | 'e') ('+' | '-')? '0'..'9'+)? | '0' ('.' '0'..'9'+)? (('E' | 'e') ('+' |
	//	'-')? '0'..'9'+)?;
	public TerminalRule getDOUBLERule() {
		return tDOUBLE;
	} 

	//terminal STRING:
	//	'"' ('\\' ('b' | 't' | 'n' | 'f' | 'r' | 'u' | '"' | '\\') | !('\\' | '"'))* '"' | "'" ('\\' ('b' | 't' | 'n' | 'f' |
	//	'r' | 'u' | "'" | '\\') | !('\\' | "'"))* "'";
	public TerminalRule getSTRINGRule() {
		return tSTRING;
	} 

	//terminal ML_COMMENT:
	//	'/ *'->'* /';
	public TerminalRule getML_COMMENTRule() {
		return tML_COMMENT;
	} 

	//terminal SL_COMMENT:
	//	'//' !('\n' | '\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return tSL_COMMENT;
	} 

	//terminal WS:
	//	' ' | '\t' | '\r' | '\n'+;
	public TerminalRule getWSRule() {
		return tWS;
	} 

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return tANY_OTHER;
	} 
}
