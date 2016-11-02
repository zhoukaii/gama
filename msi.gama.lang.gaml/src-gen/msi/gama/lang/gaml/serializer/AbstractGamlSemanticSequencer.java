/*********************************************************************************************
 *
 * 'AbstractGamlSemanticSequencer.java, in plugin msi.gama.lang.gaml, is part of the source code of the
 * GAMA modeling and simulation platform.
 * (c) 2007-2016 UMI 209 UMMISCO IRD/UPMC & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and developers contact.
 * 
 *
 **********************************************************************************************/
package msi.gama.lang.gaml.serializer;

import com.google.inject.Inject;
import java.util.Set;
import msi.gama.lang.gaml.gaml.Access;
import msi.gama.lang.gaml.gaml.ActionArguments;
import msi.gama.lang.gaml.gaml.ActionFakeDefinition;
import msi.gama.lang.gaml.gaml.ActionRef;
import msi.gama.lang.gaml.gaml.ArgumentDefinition;
import msi.gama.lang.gaml.gaml.ArgumentPair;
import msi.gama.lang.gaml.gaml.Array;
import msi.gama.lang.gaml.gaml.Binary;
import msi.gama.lang.gaml.gaml.Block;
import msi.gama.lang.gaml.gaml.BooleanLiteral;
import msi.gama.lang.gaml.gaml.Cast;
import msi.gama.lang.gaml.gaml.ColorLiteral;
import msi.gama.lang.gaml.gaml.DoubleLiteral;
import msi.gama.lang.gaml.gaml.EquationFakeDefinition;
import msi.gama.lang.gaml.gaml.EquationRef;
import msi.gama.lang.gaml.gaml.Expression;
import msi.gama.lang.gaml.gaml.ExpressionList;
import msi.gama.lang.gaml.gaml.Facet;
import msi.gama.lang.gaml.gaml.Function;
import msi.gama.lang.gaml.gaml.GamlPackage;
import msi.gama.lang.gaml.gaml.If;
import msi.gama.lang.gaml.gaml.Import;
import msi.gama.lang.gaml.gaml.IntLiteral;
import msi.gama.lang.gaml.gaml.Model;
import msi.gama.lang.gaml.gaml.Pair;
import msi.gama.lang.gaml.gaml.Parameters;
import msi.gama.lang.gaml.gaml.Point;
import msi.gama.lang.gaml.gaml.Pragma;
import msi.gama.lang.gaml.gaml.ReservedLiteral;
import msi.gama.lang.gaml.gaml.S_Action;
import msi.gama.lang.gaml.gaml.S_Assignment;
import msi.gama.lang.gaml.gaml.S_Definition;
import msi.gama.lang.gaml.gaml.S_DirectAssignment;
import msi.gama.lang.gaml.gaml.S_Display;
import msi.gama.lang.gaml.gaml.S_Do;
import msi.gama.lang.gaml.gaml.S_Equations;
import msi.gama.lang.gaml.gaml.S_Experiment;
import msi.gama.lang.gaml.gaml.S_Global;
import msi.gama.lang.gaml.gaml.S_If;
import msi.gama.lang.gaml.gaml.S_Loop;
import msi.gama.lang.gaml.gaml.S_Other;
import msi.gama.lang.gaml.gaml.S_Reflex;
import msi.gama.lang.gaml.gaml.S_Return;
import msi.gama.lang.gaml.gaml.S_Set;
import msi.gama.lang.gaml.gaml.S_Solve;
import msi.gama.lang.gaml.gaml.S_Species;
import msi.gama.lang.gaml.gaml.S_Var;
import msi.gama.lang.gaml.gaml.SkillFakeDefinition;
import msi.gama.lang.gaml.gaml.SkillRef;
import msi.gama.lang.gaml.gaml.StandaloneBlock;
import msi.gama.lang.gaml.gaml.Statement;
import msi.gama.lang.gaml.gaml.StringEvaluator;
import msi.gama.lang.gaml.gaml.StringLiteral;
import msi.gama.lang.gaml.gaml.TypeFakeDefinition;
import msi.gama.lang.gaml.gaml.TypeInfo;
import msi.gama.lang.gaml.gaml.TypeRef;
import msi.gama.lang.gaml.gaml.Unary;
import msi.gama.lang.gaml.gaml.Unit;
import msi.gama.lang.gaml.gaml.UnitFakeDefinition;
import msi.gama.lang.gaml.gaml.UnitName;
import msi.gama.lang.gaml.gaml.VarFakeDefinition;
import msi.gama.lang.gaml.gaml.VariableRef;
import msi.gama.lang.gaml.gaml.speciesOrGridDisplayStatement;
import msi.gama.lang.gaml.services.GamlGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public abstract class AbstractGamlSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private GamlGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == GamlPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case GamlPackage.ACCESS:
				sequence_Access(context, (Access) semanticObject); 
				return; 
			case GamlPackage.ACTION_ARGUMENTS:
				sequence_ActionArguments(context, (ActionArguments) semanticObject); 
				return; 
			case GamlPackage.ACTION_FAKE_DEFINITION:
				sequence_ActionFakeDefinition(context, (ActionFakeDefinition) semanticObject); 
				return; 
			case GamlPackage.ACTION_REF:
				sequence_ActionRef(context, (ActionRef) semanticObject); 
				return; 
			case GamlPackage.ARGUMENT_DEFINITION:
				sequence_ArgumentDefinition(context, (ArgumentDefinition) semanticObject); 
				return; 
			case GamlPackage.ARGUMENT_PAIR:
				sequence_ArgumentPair(context, (ArgumentPair) semanticObject); 
				return; 
			case GamlPackage.ARRAY:
				sequence_Primary(context, (Array) semanticObject); 
				return; 
			case GamlPackage.BINARY:
				sequence_Binary(context, (Binary) semanticObject); 
				return; 
			case GamlPackage.BLOCK:
				if (rule == grammarAccess.getBlockRule()) {
					sequence_Block(context, (Block) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getModelBlockRule()) {
					sequence_ModelBlock(context, (Block) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getDisplayBlockRule()) {
					sequence_displayBlock(context, (Block) semanticObject); 
					return; 
				}
				else break;
			case GamlPackage.BOOLEAN_LITERAL:
				sequence_TerminalExpression(context, (BooleanLiteral) semanticObject); 
				return; 
			case GamlPackage.CAST:
				sequence_Cast(context, (Cast) semanticObject); 
				return; 
			case GamlPackage.COLOR_LITERAL:
				sequence_TerminalExpression(context, (ColorLiteral) semanticObject); 
				return; 
			case GamlPackage.DOUBLE_LITERAL:
				sequence_TerminalExpression(context, (DoubleLiteral) semanticObject); 
				return; 
			case GamlPackage.EQUATION_FAKE_DEFINITION:
				sequence_EquationFakeDefinition(context, (EquationFakeDefinition) semanticObject); 
				return; 
			case GamlPackage.EQUATION_REF:
				sequence_EquationRef(context, (EquationRef) semanticObject); 
				return; 
			case GamlPackage.EXPRESSION:
				if (rule == grammarAccess.getAndRule()
						|| action == grammarAccess.getAndAccess().getExpressionLeftAction_1_0()) {
					sequence_Addition_And_Comparison_Exponentiation_Multiplication(context, (Expression) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getExpressionRule()
						|| rule == grammarAccess.getPairRule()
						|| action == grammarAccess.getPairAccess().getPairLeftAction_1_0_0()
						|| rule == grammarAccess.getIfRule()
						|| action == grammarAccess.getIfAccess().getIfLeftAction_1_0()
						|| rule == grammarAccess.getOrRule()
						|| action == grammarAccess.getOrAccess().getExpressionLeftAction_1_0()) {
					sequence_Addition_And_Comparison_Exponentiation_Multiplication_Or(context, (Expression) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getCastRule()
						|| action == grammarAccess.getCastAccess().getCastLeftAction_1_0_0()
						|| rule == grammarAccess.getComparisonRule()) {
					sequence_Addition_Comparison_Exponentiation_Multiplication(context, (Expression) semanticObject); 
					return; 
				}
				else if (action == grammarAccess.getComparisonAccess().getExpressionLeftAction_1_0_0()
						|| rule == grammarAccess.getAdditionRule()
						|| action == grammarAccess.getAdditionAccess().getExpressionLeftAction_1_0_0()) {
					sequence_Addition_Exponentiation_Multiplication(context, (Expression) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getExponentiationRule()
						|| action == grammarAccess.getExponentiationAccess().getExpressionLeftAction_1_0_0()) {
					sequence_Exponentiation(context, (Expression) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getMultiplicationRule()
						|| action == grammarAccess.getMultiplicationAccess().getExpressionLeftAction_1_0_0()) {
					sequence_Exponentiation_Multiplication(context, (Expression) semanticObject); 
					return; 
				}
				else break;
			case GamlPackage.EXPRESSION_LIST:
				if (rule == grammarAccess.getExpressionRule()
						|| rule == grammarAccess.getPairRule()
						|| action == grammarAccess.getPairAccess().getPairLeftAction_1_0_0()
						|| rule == grammarAccess.getIfRule()
						|| action == grammarAccess.getIfAccess().getIfLeftAction_1_0()
						|| rule == grammarAccess.getOrRule()
						|| action == grammarAccess.getOrAccess().getExpressionLeftAction_1_0()
						|| rule == grammarAccess.getAndRule()
						|| action == grammarAccess.getAndAccess().getExpressionLeftAction_1_0()
						|| rule == grammarAccess.getCastRule()
						|| action == grammarAccess.getCastAccess().getCastLeftAction_1_0_0()
						|| rule == grammarAccess.getComparisonRule()
						|| action == grammarAccess.getComparisonAccess().getExpressionLeftAction_1_0_0()
						|| rule == grammarAccess.getAdditionRule()
						|| action == grammarAccess.getAdditionAccess().getExpressionLeftAction_1_0_0()
						|| rule == grammarAccess.getMultiplicationRule()
						|| action == grammarAccess.getMultiplicationAccess().getExpressionLeftAction_1_0_0()
						|| rule == grammarAccess.getExponentiationRule()
						|| action == grammarAccess.getExponentiationAccess().getExpressionLeftAction_1_0_0()
						|| rule == grammarAccess.getBinaryRule()
						|| action == grammarAccess.getBinaryAccess().getBinaryLeftAction_1_0_0()
						|| rule == grammarAccess.getUnitRule()
						|| action == grammarAccess.getUnitAccess().getUnitLeftAction_1_0_0()
						|| rule == grammarAccess.getUnaryRule()
						|| rule == grammarAccess.getAccessRule()
						|| action == grammarAccess.getAccessAccess().getAccessLeftAction_1_0()
						|| rule == grammarAccess.getPrimaryRule()
						|| rule == grammarAccess.getExpressionListRule()) {
					sequence_ExpressionList(context, (ExpressionList) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getParameterListRule()) {
					sequence_ParameterList(context, (ExpressionList) semanticObject); 
					return; 
				}
				else break;
			case GamlPackage.FACET:
				if (rule == grammarAccess.getFacetRule()) {
					sequence_ActionFacet_ClassicFacet_DefinitionFacet_FunctionFacet_TypeFacet_VarFacet(context, (Facet) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getActionFacetRule()) {
					sequence_ActionFacet(context, (Facet) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getClassicFacetRule()) {
					sequence_ClassicFacet(context, (Facet) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getDefinitionFacetRule()
						|| rule == grammarAccess.getGamlDefinitionRule()
						|| rule == grammarAccess.getVarDefinitionRule()) {
					sequence_DefinitionFacet(context, (Facet) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getFunctionFacetRule()) {
					sequence_FunctionFacet(context, (Facet) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeFacetRule()) {
					sequence_TypeFacet(context, (Facet) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getVarFacetRule()) {
					sequence_VarFacet(context, (Facet) semanticObject); 
					return; 
				}
				else break;
			case GamlPackage.FUNCTION:
				if (rule == grammarAccess.getCastingFunctionRule()) {
					sequence_CastingFunction(context, (Function) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getExpressionRule()
						|| rule == grammarAccess.getPairRule()
						|| action == grammarAccess.getPairAccess().getPairLeftAction_1_0_0()
						|| rule == grammarAccess.getIfRule()
						|| action == grammarAccess.getIfAccess().getIfLeftAction_1_0()
						|| rule == grammarAccess.getOrRule()
						|| action == grammarAccess.getOrAccess().getExpressionLeftAction_1_0()
						|| rule == grammarAccess.getAndRule()
						|| action == grammarAccess.getAndAccess().getExpressionLeftAction_1_0()
						|| rule == grammarAccess.getCastRule()
						|| action == grammarAccess.getCastAccess().getCastLeftAction_1_0_0()
						|| rule == grammarAccess.getComparisonRule()
						|| action == grammarAccess.getComparisonAccess().getExpressionLeftAction_1_0_0()
						|| rule == grammarAccess.getAdditionRule()
						|| action == grammarAccess.getAdditionAccess().getExpressionLeftAction_1_0_0()
						|| rule == grammarAccess.getMultiplicationRule()
						|| action == grammarAccess.getMultiplicationAccess().getExpressionLeftAction_1_0_0()
						|| rule == grammarAccess.getExponentiationRule()
						|| action == grammarAccess.getExponentiationAccess().getExpressionLeftAction_1_0_0()
						|| rule == grammarAccess.getBinaryRule()
						|| action == grammarAccess.getBinaryAccess().getBinaryLeftAction_1_0_0()
						|| rule == grammarAccess.getUnitRule()
						|| action == grammarAccess.getUnitAccess().getUnitLeftAction_1_0_0()
						|| rule == grammarAccess.getUnaryRule()
						|| rule == grammarAccess.getAccessRule()
						|| action == grammarAccess.getAccessAccess().getAccessLeftAction_1_0()
						|| rule == grammarAccess.getPrimaryRule()
						|| rule == grammarAccess.getAbstractRefRule()) {
					sequence_CastingFunction_Function(context, (Function) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getFunctionRule()) {
					sequence_Function(context, (Function) semanticObject); 
					return; 
				}
				else break;
			case GamlPackage.IF:
				sequence_If(context, (If) semanticObject); 
				return; 
			case GamlPackage.IMPORT:
				sequence_Import(context, (Import) semanticObject); 
				return; 
			case GamlPackage.INT_LITERAL:
				sequence_TerminalExpression(context, (IntLiteral) semanticObject); 
				return; 
			case GamlPackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case GamlPackage.PAIR:
				sequence_Pair(context, (Pair) semanticObject); 
				return; 
			case GamlPackage.PARAMETER:
				sequence_Parameter(context, (msi.gama.lang.gaml.gaml.Parameter) semanticObject); 
				return; 
			case GamlPackage.PARAMETERS:
				if (rule == grammarAccess.getParametersRule()) {
					sequence_Parameters(context, (Parameters) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getExpressionRule()
						|| rule == grammarAccess.getPairRule()
						|| action == grammarAccess.getPairAccess().getPairLeftAction_1_0_0()
						|| rule == grammarAccess.getIfRule()
						|| action == grammarAccess.getIfAccess().getIfLeftAction_1_0()
						|| rule == grammarAccess.getOrRule()
						|| action == grammarAccess.getOrAccess().getExpressionLeftAction_1_0()
						|| rule == grammarAccess.getAndRule()
						|| action == grammarAccess.getAndAccess().getExpressionLeftAction_1_0()
						|| rule == grammarAccess.getCastRule()
						|| action == grammarAccess.getCastAccess().getCastLeftAction_1_0_0()
						|| rule == grammarAccess.getComparisonRule()
						|| action == grammarAccess.getComparisonAccess().getExpressionLeftAction_1_0_0()
						|| rule == grammarAccess.getAdditionRule()
						|| action == grammarAccess.getAdditionAccess().getExpressionLeftAction_1_0_0()
						|| rule == grammarAccess.getMultiplicationRule()
						|| action == grammarAccess.getMultiplicationAccess().getExpressionLeftAction_1_0_0()
						|| rule == grammarAccess.getExponentiationRule()
						|| action == grammarAccess.getExponentiationAccess().getExpressionLeftAction_1_0_0()
						|| rule == grammarAccess.getBinaryRule()
						|| action == grammarAccess.getBinaryAccess().getBinaryLeftAction_1_0_0()
						|| rule == grammarAccess.getUnitRule()
						|| action == grammarAccess.getUnitAccess().getUnitLeftAction_1_0_0()
						|| rule == grammarAccess.getUnaryRule()
						|| rule == grammarAccess.getAccessRule()
						|| action == grammarAccess.getAccessAccess().getAccessLeftAction_1_0()
						|| rule == grammarAccess.getPrimaryRule()) {
					sequence_Primary(context, (Parameters) semanticObject); 
					return; 
				}
				else break;
			case GamlPackage.POINT:
				sequence_Primary(context, (Point) semanticObject); 
				return; 
			case GamlPackage.PRAGMA:
				sequence_Pragma(context, (Pragma) semanticObject); 
				return; 
			case GamlPackage.RESERVED_LITERAL:
				sequence_TerminalExpression(context, (ReservedLiteral) semanticObject); 
				return; 
			case GamlPackage.SACTION:
				sequence_S_Action(context, (S_Action) semanticObject); 
				return; 
			case GamlPackage.SASSIGNMENT:
				sequence_S_Equation(context, (S_Assignment) semanticObject); 
				return; 
			case GamlPackage.SDEFINITION:
				sequence_S_Definition(context, (S_Definition) semanticObject); 
				return; 
			case GamlPackage.SDIRECT_ASSIGNMENT:
				sequence_S_DirectAssignment(context, (S_DirectAssignment) semanticObject); 
				return; 
			case GamlPackage.SDISPLAY:
				sequence_S_Display(context, (S_Display) semanticObject); 
				return; 
			case GamlPackage.SDO:
				sequence_S_Do(context, (S_Do) semanticObject); 
				return; 
			case GamlPackage.SEQUATIONS:
				sequence_S_Equations(context, (S_Equations) semanticObject); 
				return; 
			case GamlPackage.SEXPERIMENT:
				sequence_S_Experiment(context, (S_Experiment) semanticObject); 
				return; 
			case GamlPackage.SGLOBAL:
				sequence_S_Global(context, (S_Global) semanticObject); 
				return; 
			case GamlPackage.SIF:
				sequence_S_If(context, (S_If) semanticObject); 
				return; 
			case GamlPackage.SLOOP:
				sequence_S_Loop(context, (S_Loop) semanticObject); 
				return; 
			case GamlPackage.SOTHER:
				sequence_S_Other(context, (S_Other) semanticObject); 
				return; 
			case GamlPackage.SREFLEX:
				sequence_S_Reflex(context, (S_Reflex) semanticObject); 
				return; 
			case GamlPackage.SRETURN:
				sequence_S_Return(context, (S_Return) semanticObject); 
				return; 
			case GamlPackage.SSET:
				sequence_S_Set(context, (S_Set) semanticObject); 
				return; 
			case GamlPackage.SSOLVE:
				sequence_S_Solve(context, (S_Solve) semanticObject); 
				return; 
			case GamlPackage.SSPECIES:
				sequence_S_Species(context, (S_Species) semanticObject); 
				return; 
			case GamlPackage.SVAR:
				sequence_S_Var(context, (S_Var) semanticObject); 
				return; 
			case GamlPackage.SKILL_FAKE_DEFINITION:
				sequence_SkillFakeDefinition(context, (SkillFakeDefinition) semanticObject); 
				return; 
			case GamlPackage.SKILL_REF:
				sequence_SkillRef(context, (SkillRef) semanticObject); 
				return; 
			case GamlPackage.STANDALONE_BLOCK:
				sequence_StandaloneBlock(context, (StandaloneBlock) semanticObject); 
				return; 
			case GamlPackage.STATEMENT:
				sequence_S_1Expr_Facets_BlockOrEnd(context, (Statement) semanticObject); 
				return; 
			case GamlPackage.STRING_EVALUATOR:
				sequence_StringEvaluator(context, (StringEvaluator) semanticObject); 
				return; 
			case GamlPackage.STRING_LITERAL:
				sequence_TerminalExpression(context, (StringLiteral) semanticObject); 
				return; 
			case GamlPackage.TYPE_FAKE_DEFINITION:
				sequence_TypeFakeDefinition(context, (TypeFakeDefinition) semanticObject); 
				return; 
			case GamlPackage.TYPE_INFO:
				sequence_TypeInfo(context, (TypeInfo) semanticObject); 
				return; 
			case GamlPackage.TYPE_REF:
				sequence_TypeRef(context, (TypeRef) semanticObject); 
				return; 
			case GamlPackage.UNARY:
				sequence_Unary(context, (Unary) semanticObject); 
				return; 
			case GamlPackage.UNIT:
				sequence_Unit(context, (Unit) semanticObject); 
				return; 
			case GamlPackage.UNIT_FAKE_DEFINITION:
				sequence_UnitFakeDefinition(context, (UnitFakeDefinition) semanticObject); 
				return; 
			case GamlPackage.UNIT_NAME:
				sequence_UnitRef(context, (UnitName) semanticObject); 
				return; 
			case GamlPackage.VAR_FAKE_DEFINITION:
				sequence_VarFakeDefinition(context, (VarFakeDefinition) semanticObject); 
				return; 
			case GamlPackage.VARIABLE_REF:
				sequence_VariableRef(context, (VariableRef) semanticObject); 
				return; 
			case GamlPackage.SPECIES_OR_GRID_DISPLAY_STATEMENT:
				sequence_speciesOrGridDisplayStatement(context, (speciesOrGridDisplayStatement) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     Expression returns Access
	 *     Pair returns Access
	 *     Pair.Pair_1_0_0 returns Access
	 *     If returns Access
	 *     If.If_1_0 returns Access
	 *     Or returns Access
	 *     Or.Expression_1_0 returns Access
	 *     And returns Access
	 *     And.Expression_1_0 returns Access
	 *     Cast returns Access
	 *     Cast.Cast_1_0_0 returns Access
	 *     Comparison returns Access
	 *     Comparison.Expression_1_0_0 returns Access
	 *     Addition returns Access
	 *     Addition.Expression_1_0_0 returns Access
	 *     Multiplication returns Access
	 *     Multiplication.Expression_1_0_0 returns Access
	 *     Exponentiation returns Access
	 *     Exponentiation.Expression_1_0_0 returns Access
	 *     Binary returns Access
	 *     Binary.Binary_1_0_0 returns Access
	 *     Unit returns Access
	 *     Unit.Unit_1_0_0 returns Access
	 *     Unary returns Access
	 *     Access returns Access
	 *     Access.Access_1_0 returns Access
	 *
	 * Constraint:
	 *     (left=Access_Access_1_0 ((op='[' args=ExpressionList?) | (op='.' right=AbstractRef) | (op='.' named_exp=STRING)))
	 */
	protected void sequence_Access(ISerializationContext context, Access semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ActionArguments returns ActionArguments
	 *
	 * Constraint:
	 *     (args+=ArgumentDefinition args+=ArgumentDefinition*)
	 */
	protected void sequence_ActionArguments(ISerializationContext context, ActionArguments semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Facet returns Facet
	 *
	 * Constraint:
	 *     (
	 *         ((key=ClassicFacetKey | key='<-' | key=SpecialFacetKey) expr=Expression) | 
	 *         (key=DefinitionFacetKey (name=Valid_ID | name=STRING)) | 
	 *         ((key='function:' | key='->') expr=Expression) | 
	 *         (key=TypeFacetKey (expr=TypeRef | expr=Expression)) | 
	 *         (key=ActionFacetKey (expr=ActionRef | block=Block)) | 
	 *         (key=VarFacetKey expr=VariableRef)
	 *     )
	 */
	protected void sequence_ActionFacet_ClassicFacet_DefinitionFacet_FunctionFacet_TypeFacet_VarFacet(ISerializationContext context, Facet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ActionFacet returns Facet
	 *
	 * Constraint:
	 *     (key=ActionFacetKey (expr=ActionRef | block=Block))
	 */
	protected void sequence_ActionFacet(ISerializationContext context, Facet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     GamlDefinition returns ActionFakeDefinition
	 *     ActionDefinition returns ActionFakeDefinition
	 *     ActionFakeDefinition returns ActionFakeDefinition
	 *
	 * Constraint:
	 *     name=Valid_ID
	 */
	protected void sequence_ActionFakeDefinition(ISerializationContext context, ActionFakeDefinition semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.GAML_DEFINITION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.GAML_DEFINITION__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getActionFakeDefinitionAccess().getNameValid_IDParserRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ActionRef returns ActionRef
	 *
	 * Constraint:
	 *     ref=[ActionDefinition|Valid_ID]
	 */
	protected void sequence_ActionRef(ISerializationContext context, ActionRef semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.ACTION_REF__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.ACTION_REF__REF));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getActionRefAccess().getRefActionDefinitionValid_IDParserRuleCall_1_0_1(), semanticObject.getRef());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     And returns Expression
	 *     And.Expression_1_0 returns Expression
	 *
	 * Constraint:
	 *     (
	 *         (left=And_Expression_1_0 op='and' right=Cast) | 
	 *         (
	 *             left=Comparison_Expression_1_0_0 
	 *             (
	 *                 op='!=' | 
	 *                 op='=' | 
	 *                 op='>=' | 
	 *                 op='<=' | 
	 *                 op='<' | 
	 *                 op='>'
	 *             ) 
	 *             right=Addition
	 *         ) | 
	 *         (left=Addition_Expression_1_0_0 (op='+' | op='-') right=Multiplication) | 
	 *         (left=Multiplication_Expression_1_0_0 (op='*' | op='/') right=Exponentiation) | 
	 *         (left=Exponentiation_Expression_1_0_0 op='^' right=Binary)
	 *     )
	 */
	protected void sequence_Addition_And_Comparison_Exponentiation_Multiplication(ISerializationContext context, Expression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns Expression
	 *     Pair returns Expression
	 *     Pair.Pair_1_0_0 returns Expression
	 *     If returns Expression
	 *     If.If_1_0 returns Expression
	 *     Or returns Expression
	 *     Or.Expression_1_0 returns Expression
	 *
	 * Constraint:
	 *     (
	 *         (left=Or_Expression_1_0 op='or' right=And) | 
	 *         (left=And_Expression_1_0 op='and' right=Cast) | 
	 *         (
	 *             left=Comparison_Expression_1_0_0 
	 *             (
	 *                 op='!=' | 
	 *                 op='=' | 
	 *                 op='>=' | 
	 *                 op='<=' | 
	 *                 op='<' | 
	 *                 op='>'
	 *             ) 
	 *             right=Addition
	 *         ) | 
	 *         (left=Addition_Expression_1_0_0 (op='+' | op='-') right=Multiplication) | 
	 *         (left=Multiplication_Expression_1_0_0 (op='*' | op='/') right=Exponentiation) | 
	 *         (left=Exponentiation_Expression_1_0_0 op='^' right=Binary)
	 *     )
	 */
	protected void sequence_Addition_And_Comparison_Exponentiation_Multiplication_Or(ISerializationContext context, Expression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Cast returns Expression
	 *     Cast.Cast_1_0_0 returns Expression
	 *     Comparison returns Expression
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             left=Comparison_Expression_1_0_0 
	 *             (
	 *                 op='!=' | 
	 *                 op='=' | 
	 *                 op='>=' | 
	 *                 op='<=' | 
	 *                 op='<' | 
	 *                 op='>'
	 *             ) 
	 *             right=Addition
	 *         ) | 
	 *         (left=Addition_Expression_1_0_0 (op='+' | op='-') right=Multiplication) | 
	 *         (left=Multiplication_Expression_1_0_0 (op='*' | op='/') right=Exponentiation) | 
	 *         (left=Exponentiation_Expression_1_0_0 op='^' right=Binary)
	 *     )
	 */
	protected void sequence_Addition_Comparison_Exponentiation_Multiplication(ISerializationContext context, Expression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Comparison.Expression_1_0_0 returns Expression
	 *     Addition returns Expression
	 *     Addition.Expression_1_0_0 returns Expression
	 *
	 * Constraint:
	 *     (
	 *         (left=Addition_Expression_1_0_0 (op='+' | op='-') right=Multiplication) | 
	 *         (left=Multiplication_Expression_1_0_0 (op='*' | op='/') right=Exponentiation) | 
	 *         (left=Exponentiation_Expression_1_0_0 op='^' right=Binary)
	 *     )
	 */
	protected void sequence_Addition_Exponentiation_Multiplication(ISerializationContext context, Expression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ArgumentDefinition returns ArgumentDefinition
	 *     GamlDefinition returns ArgumentDefinition
	 *     VarDefinition returns ArgumentDefinition
	 *
	 * Constraint:
	 *     (type=TypeRef name=Valid_ID default=Expression?)
	 */
	protected void sequence_ArgumentDefinition(ISerializationContext context, ArgumentDefinition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns ArgumentPair
	 *     ArgumentPair returns ArgumentPair
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             op=Valid_ID | 
	 *             op=DefinitionFacetKey | 
	 *             op=TypeFacetKey | 
	 *             op=SpecialFacetKey | 
	 *             op=ActionFacetKey | 
	 *             op=VarFacetKey
	 *         )? 
	 *         right=If
	 *     )
	 */
	protected void sequence_ArgumentPair(ISerializationContext context, ArgumentPair semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns Binary
	 *     Pair returns Binary
	 *     Pair.Pair_1_0_0 returns Binary
	 *     If returns Binary
	 *     If.If_1_0 returns Binary
	 *     Or returns Binary
	 *     Or.Expression_1_0 returns Binary
	 *     And returns Binary
	 *     And.Expression_1_0 returns Binary
	 *     Cast returns Binary
	 *     Cast.Cast_1_0_0 returns Binary
	 *     Comparison returns Binary
	 *     Comparison.Expression_1_0_0 returns Binary
	 *     Addition returns Binary
	 *     Addition.Expression_1_0_0 returns Binary
	 *     Multiplication returns Binary
	 *     Multiplication.Expression_1_0_0 returns Binary
	 *     Exponentiation returns Binary
	 *     Exponentiation.Expression_1_0_0 returns Binary
	 *     Binary returns Binary
	 *     Binary.Binary_1_0_0 returns Binary
	 *
	 * Constraint:
	 *     (left=Binary_Binary_1_0_0 op=Valid_ID right=Unit)
	 */
	protected void sequence_Binary(ISerializationContext context, Binary semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.EXPRESSION__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.EXPRESSION__LEFT));
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.EXPRESSION__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.EXPRESSION__OP));
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.EXPRESSION__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.EXPRESSION__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getBinaryAccess().getBinaryLeftAction_1_0_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getBinaryAccess().getOpValid_IDParserRuleCall_1_0_1_0(), semanticObject.getOp());
		feeder.accept(grammarAccess.getBinaryAccess().getRightUnitParserRuleCall_1_1_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Block returns Block
	 *
	 * Constraint:
	 *     (function=Expression | statements+=Statement+)?
	 */
	protected void sequence_Block(ISerializationContext context, Block semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns Cast
	 *     Pair returns Cast
	 *     Pair.Pair_1_0_0 returns Cast
	 *     If returns Cast
	 *     If.If_1_0 returns Cast
	 *     Or returns Cast
	 *     Or.Expression_1_0 returns Cast
	 *     And returns Cast
	 *     And.Expression_1_0 returns Cast
	 *     Cast returns Cast
	 *
	 * Constraint:
	 *     (left=Cast_Cast_1_0_0 op='as' (right=TypeRef | right=TypeRef))
	 */
	protected void sequence_Cast(ISerializationContext context, Cast semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     CastingFunction returns Function
	 *
	 * Constraint:
	 *     (action=ActionRef type=TypeInfo args=ExpressionList)
	 */
	protected void sequence_CastingFunction(ISerializationContext context, Function semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.FUNCTION__ACTION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.FUNCTION__ACTION));
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.FUNCTION__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.FUNCTION__TYPE));
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.FUNCTION__ARGS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.FUNCTION__ARGS));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getCastingFunctionAccess().getActionActionRefParserRuleCall_0_0(), semanticObject.getAction());
		feeder.accept(grammarAccess.getCastingFunctionAccess().getTypeTypeInfoParserRuleCall_1_0(), semanticObject.getType());
		feeder.accept(grammarAccess.getCastingFunctionAccess().getArgsExpressionListParserRuleCall_3_0(), semanticObject.getArgs());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns Function
	 *     Pair returns Function
	 *     Pair.Pair_1_0_0 returns Function
	 *     If returns Function
	 *     If.If_1_0 returns Function
	 *     Or returns Function
	 *     Or.Expression_1_0 returns Function
	 *     And returns Function
	 *     And.Expression_1_0 returns Function
	 *     Cast returns Function
	 *     Cast.Cast_1_0_0 returns Function
	 *     Comparison returns Function
	 *     Comparison.Expression_1_0_0 returns Function
	 *     Addition returns Function
	 *     Addition.Expression_1_0_0 returns Function
	 *     Multiplication returns Function
	 *     Multiplication.Expression_1_0_0 returns Function
	 *     Exponentiation returns Function
	 *     Exponentiation.Expression_1_0_0 returns Function
	 *     Binary returns Function
	 *     Binary.Binary_1_0_0 returns Function
	 *     Unit returns Function
	 *     Unit.Unit_1_0_0 returns Function
	 *     Unary returns Function
	 *     Access returns Function
	 *     Access.Access_1_0 returns Function
	 *     Primary returns Function
	 *     AbstractRef returns Function
	 *
	 * Constraint:
	 *     ((action=ActionRef (parameters=Parameters | args=ExpressionList)) | (action=ActionRef type=TypeInfo args=ExpressionList))
	 */
	protected void sequence_CastingFunction_Function(ISerializationContext context, Function semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ClassicFacet returns Facet
	 *
	 * Constraint:
	 *     ((key=ClassicFacetKey | key='<-' | key=SpecialFacetKey) expr=Expression)
	 */
	protected void sequence_ClassicFacet(ISerializationContext context, Facet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DefinitionFacet returns Facet
	 *     GamlDefinition returns Facet
	 *     VarDefinition returns Facet
	 *
	 * Constraint:
	 *     (key=DefinitionFacetKey (name=Valid_ID | name=STRING))
	 */
	protected void sequence_DefinitionFacet(ISerializationContext context, Facet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     GamlDefinition returns EquationFakeDefinition
	 *     EquationDefinition returns EquationFakeDefinition
	 *     EquationFakeDefinition returns EquationFakeDefinition
	 *
	 * Constraint:
	 *     name=Valid_ID
	 */
	protected void sequence_EquationFakeDefinition(ISerializationContext context, EquationFakeDefinition semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.GAML_DEFINITION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.GAML_DEFINITION__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getEquationFakeDefinitionAccess().getNameValid_IDParserRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     EquationRef returns EquationRef
	 *
	 * Constraint:
	 *     ref=[EquationDefinition|Valid_ID]
	 */
	protected void sequence_EquationRef(ISerializationContext context, EquationRef semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.EQUATION_REF__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.EQUATION_REF__REF));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getEquationRefAccess().getRefEquationDefinitionValid_IDParserRuleCall_1_0_1(), semanticObject.getRef());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Exponentiation returns Expression
	 *     Exponentiation.Expression_1_0_0 returns Expression
	 *
	 * Constraint:
	 *     (left=Exponentiation_Expression_1_0_0 op='^' right=Binary)
	 */
	protected void sequence_Exponentiation(ISerializationContext context, Expression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.EXPRESSION__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.EXPRESSION__LEFT));
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.EXPRESSION__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.EXPRESSION__OP));
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.EXPRESSION__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.EXPRESSION__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getExponentiationAccess().getExpressionLeftAction_1_0_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getExponentiationAccess().getOpCircumflexAccentKeyword_1_0_1_0(), semanticObject.getOp());
		feeder.accept(grammarAccess.getExponentiationAccess().getRightBinaryParserRuleCall_1_1_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Multiplication returns Expression
	 *     Multiplication.Expression_1_0_0 returns Expression
	 *
	 * Constraint:
	 *     ((left=Multiplication_Expression_1_0_0 (op='*' | op='/') right=Exponentiation) | (left=Exponentiation_Expression_1_0_0 op='^' right=Binary))
	 */
	protected void sequence_Exponentiation_Multiplication(ISerializationContext context, Expression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns ExpressionList
	 *     Pair returns ExpressionList
	 *     Pair.Pair_1_0_0 returns ExpressionList
	 *     If returns ExpressionList
	 *     If.If_1_0 returns ExpressionList
	 *     Or returns ExpressionList
	 *     Or.Expression_1_0 returns ExpressionList
	 *     And returns ExpressionList
	 *     And.Expression_1_0 returns ExpressionList
	 *     Cast returns ExpressionList
	 *     Cast.Cast_1_0_0 returns ExpressionList
	 *     Comparison returns ExpressionList
	 *     Comparison.Expression_1_0_0 returns ExpressionList
	 *     Addition returns ExpressionList
	 *     Addition.Expression_1_0_0 returns ExpressionList
	 *     Multiplication returns ExpressionList
	 *     Multiplication.Expression_1_0_0 returns ExpressionList
	 *     Exponentiation returns ExpressionList
	 *     Exponentiation.Expression_1_0_0 returns ExpressionList
	 *     Binary returns ExpressionList
	 *     Binary.Binary_1_0_0 returns ExpressionList
	 *     Unit returns ExpressionList
	 *     Unit.Unit_1_0_0 returns ExpressionList
	 *     Unary returns ExpressionList
	 *     Access returns ExpressionList
	 *     Access.Access_1_0 returns ExpressionList
	 *     Primary returns ExpressionList
	 *     ExpressionList returns ExpressionList
	 *
	 * Constraint:
	 *     (exprs+=Expression exprs+=Expression*)
	 */
	protected void sequence_ExpressionList(ISerializationContext context, ExpressionList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FunctionFacet returns Facet
	 *
	 * Constraint:
	 *     ((key='function:' | key='->') expr=Expression)
	 */
	protected void sequence_FunctionFacet(ISerializationContext context, Facet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Function returns Function
	 *
	 * Constraint:
	 *     (action=ActionRef (parameters=Parameters | args=ExpressionList))
	 */
	protected void sequence_Function(ISerializationContext context, Function semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns If
	 *     Pair returns If
	 *     Pair.Pair_1_0_0 returns If
	 *     If returns If
	 *
	 * Constraint:
	 *     (left=If_If_1_0 op='?' right=Or ifFalse=Or)
	 */
	protected void sequence_If(ISerializationContext context, If semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.EXPRESSION__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.EXPRESSION__LEFT));
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.EXPRESSION__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.EXPRESSION__OP));
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.EXPRESSION__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.EXPRESSION__RIGHT));
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.IF__IF_FALSE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.IF__IF_FALSE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getIfAccess().getIfLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getIfAccess().getOpQuestionMarkKeyword_1_1_0(), semanticObject.getOp());
		feeder.accept(grammarAccess.getIfAccess().getRightOrParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.accept(grammarAccess.getIfAccess().getIfFalseOrParserRuleCall_1_3_1_0(), semanticObject.getIfFalse());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Import returns Import
	 *     GamlDefinition returns Import
	 *     VarDefinition returns Import
	 *
	 * Constraint:
	 *     (importURI=STRING name=Valid_ID?)
	 */
	protected void sequence_Import(ISerializationContext context, Import semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ModelBlock returns Block
	 *
	 * Constraint:
	 *     statements+=S_Section*
	 */
	protected void sequence_ModelBlock(ISerializationContext context, Block semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Entry returns Model
	 *     Model returns Model
	 *     GamlDefinition returns Model
	 *     VarDefinition returns Model
	 *
	 * Constraint:
	 *     (pragmas+=Pragma* name=ID imports+=Import* block=ModelBlock)
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns Pair
	 *     Pair returns Pair
	 *
	 * Constraint:
	 *     (left=Pair_Pair_1_0_0 op='::' right=If)
	 */
	protected void sequence_Pair(ISerializationContext context, Pair semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.EXPRESSION__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.EXPRESSION__LEFT));
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.EXPRESSION__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.EXPRESSION__OP));
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.EXPRESSION__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.EXPRESSION__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPairAccess().getPairLeftAction_1_0_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getPairAccess().getOpColonColonKeyword_1_0_1_0(), semanticObject.getOp());
		feeder.accept(grammarAccess.getPairAccess().getRightIfParserRuleCall_1_1_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ParameterList returns ExpressionList
	 *
	 * Constraint:
	 *     (exprs+=Parameter exprs+=Parameter*)
	 */
	protected void sequence_ParameterList(ISerializationContext context, ExpressionList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Parameter returns Parameter
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             builtInFacetKey=DefinitionFacetKey | 
	 *             builtInFacetKey=TypeFacetKey | 
	 *             builtInFacetKey=SpecialFacetKey | 
	 *             builtInFacetKey=ActionFacetKey | 
	 *             builtInFacetKey=VarFacetKey | 
	 *             left=VariableRef
	 *         ) 
	 *         right=Expression
	 *     )
	 */
	protected void sequence_Parameter(ISerializationContext context, msi.gama.lang.gaml.gaml.Parameter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Parameters returns Parameters
	 *
	 * Constraint:
	 *     params=ParameterList?
	 */
	protected void sequence_Parameters(ISerializationContext context, Parameters semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Pragma returns Pragma
	 *
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_Pragma(ISerializationContext context, Pragma semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.PRAGMA__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.PRAGMA__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPragmaAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns Array
	 *     Pair returns Array
	 *     Pair.Pair_1_0_0 returns Array
	 *     If returns Array
	 *     If.If_1_0 returns Array
	 *     Or returns Array
	 *     Or.Expression_1_0 returns Array
	 *     And returns Array
	 *     And.Expression_1_0 returns Array
	 *     Cast returns Array
	 *     Cast.Cast_1_0_0 returns Array
	 *     Comparison returns Array
	 *     Comparison.Expression_1_0_0 returns Array
	 *     Addition returns Array
	 *     Addition.Expression_1_0_0 returns Array
	 *     Multiplication returns Array
	 *     Multiplication.Expression_1_0_0 returns Array
	 *     Exponentiation returns Array
	 *     Exponentiation.Expression_1_0_0 returns Array
	 *     Binary returns Array
	 *     Binary.Binary_1_0_0 returns Array
	 *     Unit returns Array
	 *     Unit.Unit_1_0_0 returns Array
	 *     Unary returns Array
	 *     Access returns Array
	 *     Access.Access_1_0 returns Array
	 *     Primary returns Array
	 *
	 * Constraint:
	 *     exprs=ExpressionList?
	 */
	protected void sequence_Primary(ISerializationContext context, Array semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns Parameters
	 *     Pair returns Parameters
	 *     Pair.Pair_1_0_0 returns Parameters
	 *     If returns Parameters
	 *     If.If_1_0 returns Parameters
	 *     Or returns Parameters
	 *     Or.Expression_1_0 returns Parameters
	 *     And returns Parameters
	 *     And.Expression_1_0 returns Parameters
	 *     Cast returns Parameters
	 *     Cast.Cast_1_0_0 returns Parameters
	 *     Comparison returns Parameters
	 *     Comparison.Expression_1_0_0 returns Parameters
	 *     Addition returns Parameters
	 *     Addition.Expression_1_0_0 returns Parameters
	 *     Multiplication returns Parameters
	 *     Multiplication.Expression_1_0_0 returns Parameters
	 *     Exponentiation returns Parameters
	 *     Exponentiation.Expression_1_0_0 returns Parameters
	 *     Binary returns Parameters
	 *     Binary.Binary_1_0_0 returns Parameters
	 *     Unit returns Parameters
	 *     Unit.Unit_1_0_0 returns Parameters
	 *     Unary returns Parameters
	 *     Access returns Parameters
	 *     Access.Access_1_0 returns Parameters
	 *     Primary returns Parameters
	 *
	 * Constraint:
	 *     params=ParameterList?
	 */
	protected void sequence_Primary(ISerializationContext context, Parameters semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns Point
	 *     Pair returns Point
	 *     Pair.Pair_1_0_0 returns Point
	 *     If returns Point
	 *     If.If_1_0 returns Point
	 *     Or returns Point
	 *     Or.Expression_1_0 returns Point
	 *     And returns Point
	 *     And.Expression_1_0 returns Point
	 *     Cast returns Point
	 *     Cast.Cast_1_0_0 returns Point
	 *     Comparison returns Point
	 *     Comparison.Expression_1_0_0 returns Point
	 *     Addition returns Point
	 *     Addition.Expression_1_0_0 returns Point
	 *     Multiplication returns Point
	 *     Multiplication.Expression_1_0_0 returns Point
	 *     Exponentiation returns Point
	 *     Exponentiation.Expression_1_0_0 returns Point
	 *     Binary returns Point
	 *     Binary.Binary_1_0_0 returns Point
	 *     Unit returns Point
	 *     Unit.Unit_1_0_0 returns Point
	 *     Unary returns Point
	 *     Access returns Point
	 *     Access.Access_1_0 returns Point
	 *     Primary returns Point
	 *
	 * Constraint:
	 *     (left=Expression op=',' right=Expression z=Expression?)
	 */
	protected void sequence_Primary(ISerializationContext context, Point semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Statement returns Statement
	 *     S_1Expr_Facets_BlockOrEnd returns Statement
	 *     displayStatement returns Statement
	 *
	 * Constraint:
	 *     (key=_1Expr_Facets_BlockOrEnd_Key firstFacet=FirstFacetKey? (expr=Expression | expr=TypeRef) facets+=Facet* block=Block?)
	 */
	protected void sequence_S_1Expr_Facets_BlockOrEnd(ISerializationContext context, Statement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Statement returns S_Action
	 *     S_Declaration returns S_Action
	 *     S_Action returns S_Action
	 *     GamlDefinition returns S_Action
	 *     VarDefinition returns S_Action
	 *     ActionDefinition returns S_Action
	 *
	 * Constraint:
	 *     (
	 *         key='action' 
	 *         firstFacet='name:'? 
	 *         name=Valid_ID 
	 *         args=ActionArguments? 
	 *         facets+=Facet* 
	 *         block=Block?
	 *     )
	 */
	protected void sequence_S_Action(ISerializationContext context, S_Action semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Statement returns S_Definition
	 *     S_Declaration returns S_Definition
	 *     S_Definition returns S_Definition
	 *     GamlDefinition returns S_Definition
	 *     VarDefinition returns S_Definition
	 *     ActionDefinition returns S_Definition
	 *
	 * Constraint:
	 *     (
	 *         tkey=TypeRef 
	 *         firstFacet='name:'? 
	 *         (name=Valid_ID | name=STRING) 
	 *         args=ActionArguments? 
	 *         facets+=Facet* 
	 *         block=Block?
	 *     )
	 */
	protected void sequence_S_Definition(ISerializationContext context, S_Definition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Statement returns S_DirectAssignment
	 *     S_Assignment returns S_DirectAssignment
	 *     S_DirectAssignment returns S_DirectAssignment
	 *
	 * Constraint:
	 *     (expr=Expression key=_AssignmentKey value=Expression facets+=Facet*)
	 */
	protected void sequence_S_DirectAssignment(ISerializationContext context, S_DirectAssignment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Statement returns S_Display
	 *     S_Display returns S_Display
	 *
	 * Constraint:
	 *     (key='display' firstFacet='name:'? (name=Valid_ID | name=STRING) facets+=Facet* block=displayBlock)
	 */
	protected void sequence_S_Display(ISerializationContext context, S_Display semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Statement returns S_Do
	 *     S_Do returns S_Do
	 *
	 * Constraint:
	 *     (key=_DoKey firstFacet='action:'? expr=AbstractRef facets+=Facet* block=Block?)
	 */
	protected void sequence_S_Do(ISerializationContext context, S_Do semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     S_Equation returns S_Assignment
	 *
	 * Constraint:
	 *     ((expr=Function | expr=VariableRef) key='=' value=Expression)
	 */
	protected void sequence_S_Equation(ISerializationContext context, S_Assignment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Statement returns S_Equations
	 *     S_Equations returns S_Equations
	 *     GamlDefinition returns S_Equations
	 *     EquationDefinition returns S_Equations
	 *
	 * Constraint:
	 *     (key=_EquationsKey name=Valid_ID facets+=Facet* equations+=S_Equation*)
	 */
	protected void sequence_S_Equations(ISerializationContext context, S_Equations semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     S_Section returns S_Experiment
	 *     S_Experiment returns S_Experiment
	 *     GamlDefinition returns S_Experiment
	 *     VarDefinition returns S_Experiment
	 *
	 * Constraint:
	 *     (key=_ExperimentKey firstFacet='name:'? (name=Valid_ID | name=STRING) facets+=Facet* block=Block?)
	 */
	protected void sequence_S_Experiment(ISerializationContext context, S_Experiment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     S_Section returns S_Global
	 *     S_Global returns S_Global
	 *
	 * Constraint:
	 *     (key='global' facets+=Facet* block=Block?)
	 */
	protected void sequence_S_Global(ISerializationContext context, S_Global semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Statement returns S_If
	 *     S_If returns S_If
	 *
	 * Constraint:
	 *     (key='if' firstFacet='condition:'? expr=Expression block=Block (else=S_If | else=Block)?)
	 */
	protected void sequence_S_If(ISerializationContext context, S_If semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Statement returns S_Loop
	 *     S_Loop returns S_Loop
	 *     S_Declaration returns S_Loop
	 *     GamlDefinition returns S_Loop
	 *     VarDefinition returns S_Loop
	 *
	 * Constraint:
	 *     (key='loop' name=ID? facets+=Facet* block=Block)
	 */
	protected void sequence_S_Loop(ISerializationContext context, S_Loop semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Statement returns S_Other
	 *     S_Other returns S_Other
	 *
	 * Constraint:
	 *     (key=ID facets+=Facet* block=Block?)
	 */
	protected void sequence_S_Other(ISerializationContext context, S_Other semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Statement returns S_Reflex
	 *     S_Declaration returns S_Reflex
	 *     S_Reflex returns S_Reflex
	 *     GamlDefinition returns S_Reflex
	 *     VarDefinition returns S_Reflex
	 *
	 * Constraint:
	 *     (key=_ReflexKey firstFacet='name:'? name=Valid_ID? expr=Expression? block=Block)
	 */
	protected void sequence_S_Reflex(ISerializationContext context, S_Reflex semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Statement returns S_Return
	 *     S_Return returns S_Return
	 *
	 * Constraint:
	 *     (key='return' firstFacet='value:'? expr=Expression?)
	 */
	protected void sequence_S_Return(ISerializationContext context, S_Return semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Statement returns S_Set
	 *     S_Assignment returns S_Set
	 *     S_Set returns S_Set
	 *
	 * Constraint:
	 *     (key='set' expr=Expression value=Expression)
	 */
	protected void sequence_S_Set(ISerializationContext context, S_Set semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.STATEMENT__KEY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.STATEMENT__KEY));
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.STATEMENT__EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.STATEMENT__EXPR));
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.SASSIGNMENT__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.SASSIGNMENT__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getS_SetAccess().getKeySetKeyword_0_0(), semanticObject.getKey());
		feeder.accept(grammarAccess.getS_SetAccess().getExprExpressionParserRuleCall_1_0(), semanticObject.getExpr());
		feeder.accept(grammarAccess.getS_SetAccess().getValueExpressionParserRuleCall_3_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Statement returns S_Solve
	 *     S_Solve returns S_Solve
	 *
	 * Constraint:
	 *     (key=_SolveKey firstFacet='equation:'? expr=EquationRef facets+=Facet* block=Block?)
	 */
	protected void sequence_S_Solve(ISerializationContext context, S_Solve semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     S_Section returns S_Species
	 *     S_Species returns S_Species
	 *     Statement returns S_Species
	 *     S_Declaration returns S_Species
	 *     GamlDefinition returns S_Species
	 *     TypeDefinition returns S_Species
	 *     VarDefinition returns S_Species
	 *     ActionDefinition returns S_Species
	 *
	 * Constraint:
	 *     (key=_SpeciesKey firstFacet='name:'? name=ID facets+=Facet* block=Block?)
	 */
	protected void sequence_S_Species(ISerializationContext context, S_Species semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Statement returns S_Var
	 *     S_Declaration returns S_Var
	 *     S_Var returns S_Var
	 *     GamlDefinition returns S_Var
	 *     VarDefinition returns S_Var
	 *
	 * Constraint:
	 *     (key=_VarOrConstKey firstFacet='name:'? name=Valid_ID facets+=Facet*)
	 */
	protected void sequence_S_Var(ISerializationContext context, S_Var semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     GamlDefinition returns SkillFakeDefinition
	 *     SkillFakeDefinition returns SkillFakeDefinition
	 *
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_SkillFakeDefinition(ISerializationContext context, SkillFakeDefinition semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.GAML_DEFINITION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.GAML_DEFINITION__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSkillFakeDefinitionAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     SkillRef returns SkillRef
	 *
	 * Constraint:
	 *     ref=[SkillFakeDefinition|ID]
	 */
	protected void sequence_SkillRef(ISerializationContext context, SkillRef semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.SKILL_REF__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.SKILL_REF__REF));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSkillRefAccess().getRefSkillFakeDefinitionIDTerminalRuleCall_1_0_1(), semanticObject.getRef());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Entry returns StandaloneBlock
	 *     StandaloneBlock returns StandaloneBlock
	 *
	 * Constraint:
	 *     block=Block
	 */
	protected void sequence_StandaloneBlock(ISerializationContext context, StandaloneBlock semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.STANDALONE_BLOCK__BLOCK) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.STANDALONE_BLOCK__BLOCK));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getStandaloneBlockAccess().getBlockBlockParserRuleCall_1_0(), semanticObject.getBlock());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Entry returns StringEvaluator
	 *     StringEvaluator returns StringEvaluator
	 *
	 * Constraint:
	 *     (toto=ID expr=Expression)
	 */
	protected void sequence_StringEvaluator(ISerializationContext context, StringEvaluator semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.STRING_EVALUATOR__TOTO) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.STRING_EVALUATOR__TOTO));
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.STRING_EVALUATOR__EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.STRING_EVALUATOR__EXPR));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getStringEvaluatorAccess().getTotoIDTerminalRuleCall_0_0(), semanticObject.getToto());
		feeder.accept(grammarAccess.getStringEvaluatorAccess().getExprExpressionParserRuleCall_2_0(), semanticObject.getExpr());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns BooleanLiteral
	 *     Pair returns BooleanLiteral
	 *     Pair.Pair_1_0_0 returns BooleanLiteral
	 *     If returns BooleanLiteral
	 *     If.If_1_0 returns BooleanLiteral
	 *     Or returns BooleanLiteral
	 *     Or.Expression_1_0 returns BooleanLiteral
	 *     And returns BooleanLiteral
	 *     And.Expression_1_0 returns BooleanLiteral
	 *     Cast returns BooleanLiteral
	 *     Cast.Cast_1_0_0 returns BooleanLiteral
	 *     Comparison returns BooleanLiteral
	 *     Comparison.Expression_1_0_0 returns BooleanLiteral
	 *     Addition returns BooleanLiteral
	 *     Addition.Expression_1_0_0 returns BooleanLiteral
	 *     Multiplication returns BooleanLiteral
	 *     Multiplication.Expression_1_0_0 returns BooleanLiteral
	 *     Exponentiation returns BooleanLiteral
	 *     Exponentiation.Expression_1_0_0 returns BooleanLiteral
	 *     Binary returns BooleanLiteral
	 *     Binary.Binary_1_0_0 returns BooleanLiteral
	 *     Unit returns BooleanLiteral
	 *     Unit.Unit_1_0_0 returns BooleanLiteral
	 *     Unary returns BooleanLiteral
	 *     Access returns BooleanLiteral
	 *     Access.Access_1_0 returns BooleanLiteral
	 *     Primary returns BooleanLiteral
	 *     TerminalExpression returns BooleanLiteral
	 *
	 * Constraint:
	 *     op=BOOLEAN
	 */
	protected void sequence_TerminalExpression(ISerializationContext context, BooleanLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.EXPRESSION__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.EXPRESSION__OP));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTerminalExpressionAccess().getOpBOOLEANTerminalRuleCall_4_1_0(), semanticObject.getOp());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns ColorLiteral
	 *     Pair returns ColorLiteral
	 *     Pair.Pair_1_0_0 returns ColorLiteral
	 *     If returns ColorLiteral
	 *     If.If_1_0 returns ColorLiteral
	 *     Or returns ColorLiteral
	 *     Or.Expression_1_0 returns ColorLiteral
	 *     And returns ColorLiteral
	 *     And.Expression_1_0 returns ColorLiteral
	 *     Cast returns ColorLiteral
	 *     Cast.Cast_1_0_0 returns ColorLiteral
	 *     Comparison returns ColorLiteral
	 *     Comparison.Expression_1_0_0 returns ColorLiteral
	 *     Addition returns ColorLiteral
	 *     Addition.Expression_1_0_0 returns ColorLiteral
	 *     Multiplication returns ColorLiteral
	 *     Multiplication.Expression_1_0_0 returns ColorLiteral
	 *     Exponentiation returns ColorLiteral
	 *     Exponentiation.Expression_1_0_0 returns ColorLiteral
	 *     Binary returns ColorLiteral
	 *     Binary.Binary_1_0_0 returns ColorLiteral
	 *     Unit returns ColorLiteral
	 *     Unit.Unit_1_0_0 returns ColorLiteral
	 *     Unary returns ColorLiteral
	 *     Access returns ColorLiteral
	 *     Access.Access_1_0 returns ColorLiteral
	 *     Primary returns ColorLiteral
	 *     TerminalExpression returns ColorLiteral
	 *
	 * Constraint:
	 *     op=COLOR
	 */
	protected void sequence_TerminalExpression(ISerializationContext context, ColorLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.EXPRESSION__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.EXPRESSION__OP));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTerminalExpressionAccess().getOpCOLORTerminalRuleCall_2_1_0(), semanticObject.getOp());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns DoubleLiteral
	 *     Pair returns DoubleLiteral
	 *     Pair.Pair_1_0_0 returns DoubleLiteral
	 *     If returns DoubleLiteral
	 *     If.If_1_0 returns DoubleLiteral
	 *     Or returns DoubleLiteral
	 *     Or.Expression_1_0 returns DoubleLiteral
	 *     And returns DoubleLiteral
	 *     And.Expression_1_0 returns DoubleLiteral
	 *     Cast returns DoubleLiteral
	 *     Cast.Cast_1_0_0 returns DoubleLiteral
	 *     Comparison returns DoubleLiteral
	 *     Comparison.Expression_1_0_0 returns DoubleLiteral
	 *     Addition returns DoubleLiteral
	 *     Addition.Expression_1_0_0 returns DoubleLiteral
	 *     Multiplication returns DoubleLiteral
	 *     Multiplication.Expression_1_0_0 returns DoubleLiteral
	 *     Exponentiation returns DoubleLiteral
	 *     Exponentiation.Expression_1_0_0 returns DoubleLiteral
	 *     Binary returns DoubleLiteral
	 *     Binary.Binary_1_0_0 returns DoubleLiteral
	 *     Unit returns DoubleLiteral
	 *     Unit.Unit_1_0_0 returns DoubleLiteral
	 *     Unary returns DoubleLiteral
	 *     Access returns DoubleLiteral
	 *     Access.Access_1_0 returns DoubleLiteral
	 *     Primary returns DoubleLiteral
	 *     TerminalExpression returns DoubleLiteral
	 *
	 * Constraint:
	 *     op=DOUBLE
	 */
	protected void sequence_TerminalExpression(ISerializationContext context, DoubleLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.EXPRESSION__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.EXPRESSION__OP));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTerminalExpressionAccess().getOpDOUBLETerminalRuleCall_1_1_0(), semanticObject.getOp());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns IntLiteral
	 *     Pair returns IntLiteral
	 *     Pair.Pair_1_0_0 returns IntLiteral
	 *     If returns IntLiteral
	 *     If.If_1_0 returns IntLiteral
	 *     Or returns IntLiteral
	 *     Or.Expression_1_0 returns IntLiteral
	 *     And returns IntLiteral
	 *     And.Expression_1_0 returns IntLiteral
	 *     Cast returns IntLiteral
	 *     Cast.Cast_1_0_0 returns IntLiteral
	 *     Comparison returns IntLiteral
	 *     Comparison.Expression_1_0_0 returns IntLiteral
	 *     Addition returns IntLiteral
	 *     Addition.Expression_1_0_0 returns IntLiteral
	 *     Multiplication returns IntLiteral
	 *     Multiplication.Expression_1_0_0 returns IntLiteral
	 *     Exponentiation returns IntLiteral
	 *     Exponentiation.Expression_1_0_0 returns IntLiteral
	 *     Binary returns IntLiteral
	 *     Binary.Binary_1_0_0 returns IntLiteral
	 *     Unit returns IntLiteral
	 *     Unit.Unit_1_0_0 returns IntLiteral
	 *     Unary returns IntLiteral
	 *     Access returns IntLiteral
	 *     Access.Access_1_0 returns IntLiteral
	 *     Primary returns IntLiteral
	 *     TerminalExpression returns IntLiteral
	 *
	 * Constraint:
	 *     op=INTEGER
	 */
	protected void sequence_TerminalExpression(ISerializationContext context, IntLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.EXPRESSION__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.EXPRESSION__OP));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTerminalExpressionAccess().getOpINTEGERTerminalRuleCall_0_1_0(), semanticObject.getOp());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns ReservedLiteral
	 *     Pair returns ReservedLiteral
	 *     Pair.Pair_1_0_0 returns ReservedLiteral
	 *     If returns ReservedLiteral
	 *     If.If_1_0 returns ReservedLiteral
	 *     Or returns ReservedLiteral
	 *     Or.Expression_1_0 returns ReservedLiteral
	 *     And returns ReservedLiteral
	 *     And.Expression_1_0 returns ReservedLiteral
	 *     Cast returns ReservedLiteral
	 *     Cast.Cast_1_0_0 returns ReservedLiteral
	 *     Comparison returns ReservedLiteral
	 *     Comparison.Expression_1_0_0 returns ReservedLiteral
	 *     Addition returns ReservedLiteral
	 *     Addition.Expression_1_0_0 returns ReservedLiteral
	 *     Multiplication returns ReservedLiteral
	 *     Multiplication.Expression_1_0_0 returns ReservedLiteral
	 *     Exponentiation returns ReservedLiteral
	 *     Exponentiation.Expression_1_0_0 returns ReservedLiteral
	 *     Binary returns ReservedLiteral
	 *     Binary.Binary_1_0_0 returns ReservedLiteral
	 *     Unit returns ReservedLiteral
	 *     Unit.Unit_1_0_0 returns ReservedLiteral
	 *     Unary returns ReservedLiteral
	 *     Access returns ReservedLiteral
	 *     Access.Access_1_0 returns ReservedLiteral
	 *     Primary returns ReservedLiteral
	 *     TerminalExpression returns ReservedLiteral
	 *
	 * Constraint:
	 *     op=KEYWORD
	 */
	protected void sequence_TerminalExpression(ISerializationContext context, ReservedLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.EXPRESSION__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.EXPRESSION__OP));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTerminalExpressionAccess().getOpKEYWORDTerminalRuleCall_5_1_0(), semanticObject.getOp());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns StringLiteral
	 *     Pair returns StringLiteral
	 *     Pair.Pair_1_0_0 returns StringLiteral
	 *     If returns StringLiteral
	 *     If.If_1_0 returns StringLiteral
	 *     Or returns StringLiteral
	 *     Or.Expression_1_0 returns StringLiteral
	 *     And returns StringLiteral
	 *     And.Expression_1_0 returns StringLiteral
	 *     Cast returns StringLiteral
	 *     Cast.Cast_1_0_0 returns StringLiteral
	 *     Comparison returns StringLiteral
	 *     Comparison.Expression_1_0_0 returns StringLiteral
	 *     Addition returns StringLiteral
	 *     Addition.Expression_1_0_0 returns StringLiteral
	 *     Multiplication returns StringLiteral
	 *     Multiplication.Expression_1_0_0 returns StringLiteral
	 *     Exponentiation returns StringLiteral
	 *     Exponentiation.Expression_1_0_0 returns StringLiteral
	 *     Binary returns StringLiteral
	 *     Binary.Binary_1_0_0 returns StringLiteral
	 *     Unit returns StringLiteral
	 *     Unit.Unit_1_0_0 returns StringLiteral
	 *     Unary returns StringLiteral
	 *     Access returns StringLiteral
	 *     Access.Access_1_0 returns StringLiteral
	 *     Primary returns StringLiteral
	 *     TerminalExpression returns StringLiteral
	 *
	 * Constraint:
	 *     op=STRING
	 */
	protected void sequence_TerminalExpression(ISerializationContext context, StringLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.EXPRESSION__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.EXPRESSION__OP));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTerminalExpressionAccess().getOpSTRINGTerminalRuleCall_3_1_0(), semanticObject.getOp());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TypeFacet returns Facet
	 *
	 * Constraint:
	 *     (key=TypeFacetKey (expr=TypeRef | expr=Expression))
	 */
	protected void sequence_TypeFacet(ISerializationContext context, Facet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     GamlDefinition returns TypeFakeDefinition
	 *     TypeDefinition returns TypeFakeDefinition
	 *     ActionDefinition returns TypeFakeDefinition
	 *     TypeFakeDefinition returns TypeFakeDefinition
	 *
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_TypeFakeDefinition(ISerializationContext context, TypeFakeDefinition semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.GAML_DEFINITION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.GAML_DEFINITION__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTypeFakeDefinitionAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TypeInfo returns TypeInfo
	 *
	 * Constraint:
	 *     (first=TypeRef second=TypeRef?)
	 */
	protected void sequence_TypeInfo(ISerializationContext context, TypeInfo semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TypeRef returns TypeRef
	 *
	 * Constraint:
	 *     ((ref=[TypeDefinition|ID] parameter=TypeInfo?) | parameter=TypeInfo)
	 */
	protected void sequence_TypeRef(ISerializationContext context, TypeRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns Unary
	 *     Pair returns Unary
	 *     Pair.Pair_1_0_0 returns Unary
	 *     If returns Unary
	 *     If.If_1_0 returns Unary
	 *     Or returns Unary
	 *     Or.Expression_1_0 returns Unary
	 *     And returns Unary
	 *     And.Expression_1_0 returns Unary
	 *     Cast returns Unary
	 *     Cast.Cast_1_0_0 returns Unary
	 *     Comparison returns Unary
	 *     Comparison.Expression_1_0_0 returns Unary
	 *     Addition returns Unary
	 *     Addition.Expression_1_0_0 returns Unary
	 *     Multiplication returns Unary
	 *     Multiplication.Expression_1_0_0 returns Unary
	 *     Exponentiation returns Unary
	 *     Exponentiation.Expression_1_0_0 returns Unary
	 *     Binary returns Unary
	 *     Binary.Binary_1_0_0 returns Unary
	 *     Unit returns Unary
	 *     Unit.Unit_1_0_0 returns Unary
	 *     Unary returns Unary
	 *
	 * Constraint:
	 *     (((op='°' | op='#') right=UnitRef) | ((op='-' | op='!' | op='my' | op='the' | op='not') right=Unary))
	 */
	protected void sequence_Unary(ISerializationContext context, Unary semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     GamlDefinition returns UnitFakeDefinition
	 *     UnitFakeDefinition returns UnitFakeDefinition
	 *
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_UnitFakeDefinition(ISerializationContext context, UnitFakeDefinition semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.GAML_DEFINITION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.GAML_DEFINITION__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getUnitFakeDefinitionAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     UnitRef returns UnitName
	 *
	 * Constraint:
	 *     ref=[UnitFakeDefinition|ID]
	 */
	protected void sequence_UnitRef(ISerializationContext context, UnitName semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.UNIT_NAME__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.UNIT_NAME__REF));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getUnitRefAccess().getRefUnitFakeDefinitionIDTerminalRuleCall_1_0_1(), semanticObject.getRef());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns Unit
	 *     Pair returns Unit
	 *     Pair.Pair_1_0_0 returns Unit
	 *     If returns Unit
	 *     If.If_1_0 returns Unit
	 *     Or returns Unit
	 *     Or.Expression_1_0 returns Unit
	 *     And returns Unit
	 *     And.Expression_1_0 returns Unit
	 *     Cast returns Unit
	 *     Cast.Cast_1_0_0 returns Unit
	 *     Comparison returns Unit
	 *     Comparison.Expression_1_0_0 returns Unit
	 *     Addition returns Unit
	 *     Addition.Expression_1_0_0 returns Unit
	 *     Multiplication returns Unit
	 *     Multiplication.Expression_1_0_0 returns Unit
	 *     Exponentiation returns Unit
	 *     Exponentiation.Expression_1_0_0 returns Unit
	 *     Binary returns Unit
	 *     Binary.Binary_1_0_0 returns Unit
	 *     Unit returns Unit
	 *
	 * Constraint:
	 *     (left=Unit_Unit_1_0_0 (op='°' | op='#') right=UnitRef)
	 */
	protected void sequence_Unit(ISerializationContext context, Unit semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     VarFacet returns Facet
	 *
	 * Constraint:
	 *     (key=VarFacetKey expr=VariableRef)
	 */
	protected void sequence_VarFacet(ISerializationContext context, Facet semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.FACET__KEY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.FACET__KEY));
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.FACET__EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.FACET__EXPR));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getVarFacetAccess().getKeyVarFacetKeyParserRuleCall_0_0(), semanticObject.getKey());
		feeder.accept(grammarAccess.getVarFacetAccess().getExprVariableRefParserRuleCall_1_0(), semanticObject.getExpr());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     GamlDefinition returns VarFakeDefinition
	 *     VarDefinition returns VarFakeDefinition
	 *     VarFakeDefinition returns VarFakeDefinition
	 *
	 * Constraint:
	 *     name=Valid_ID
	 */
	protected void sequence_VarFakeDefinition(ISerializationContext context, VarFakeDefinition semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.GAML_DEFINITION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.GAML_DEFINITION__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getVarFakeDefinitionAccess().getNameValid_IDParserRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns VariableRef
	 *     Pair returns VariableRef
	 *     Pair.Pair_1_0_0 returns VariableRef
	 *     If returns VariableRef
	 *     If.If_1_0 returns VariableRef
	 *     Or returns VariableRef
	 *     Or.Expression_1_0 returns VariableRef
	 *     And returns VariableRef
	 *     And.Expression_1_0 returns VariableRef
	 *     Cast returns VariableRef
	 *     Cast.Cast_1_0_0 returns VariableRef
	 *     Comparison returns VariableRef
	 *     Comparison.Expression_1_0_0 returns VariableRef
	 *     Addition returns VariableRef
	 *     Addition.Expression_1_0_0 returns VariableRef
	 *     Multiplication returns VariableRef
	 *     Multiplication.Expression_1_0_0 returns VariableRef
	 *     Exponentiation returns VariableRef
	 *     Exponentiation.Expression_1_0_0 returns VariableRef
	 *     Binary returns VariableRef
	 *     Binary.Binary_1_0_0 returns VariableRef
	 *     Unit returns VariableRef
	 *     Unit.Unit_1_0_0 returns VariableRef
	 *     Unary returns VariableRef
	 *     Access returns VariableRef
	 *     Access.Access_1_0 returns VariableRef
	 *     Primary returns VariableRef
	 *     AbstractRef returns VariableRef
	 *     VariableRef returns VariableRef
	 *
	 * Constraint:
	 *     ref=[VarDefinition|Valid_ID]
	 */
	protected void sequence_VariableRef(ISerializationContext context, VariableRef semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.VARIABLE_REF__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.VARIABLE_REF__REF));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getVariableRefAccess().getRefVarDefinitionValid_IDParserRuleCall_1_0_1(), semanticObject.getRef());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     displayBlock returns Block
	 *
	 * Constraint:
	 *     statements+=displayStatement*
	 */
	protected void sequence_displayBlock(ISerializationContext context, Block semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     displayStatement returns speciesOrGridDisplayStatement
	 *     speciesOrGridDisplayStatement returns speciesOrGridDisplayStatement
	 *
	 * Constraint:
	 *     (key=_SpeciesKey expr=Expression facets+=Facet* block=displayBlock?)
	 */
	protected void sequence_speciesOrGridDisplayStatement(ISerializationContext context, speciesOrGridDisplayStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
