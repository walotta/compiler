// Generated from /Users/wzj/Documents/code/compiler/src/Parser/Mx.g4 by ANTLR 4.9.1
package Parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MxParser}.
 */
public interface MxListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MxParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MxParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#programBlock}.
	 * @param ctx the parse tree
	 */
	void enterProgramBlock(MxParser.ProgramBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#programBlock}.
	 * @param ctx the parse tree
	 */
	void exitProgramBlock(MxParser.ProgramBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#classBlock}.
	 * @param ctx the parse tree
	 */
	void enterClassBlock(MxParser.ClassBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#classBlock}.
	 * @param ctx the parse tree
	 */
	void exitClassBlock(MxParser.ClassBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#buildFuncBlock}.
	 * @param ctx the parse tree
	 */
	void enterBuildFuncBlock(MxParser.BuildFuncBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#buildFuncBlock}.
	 * @param ctx the parse tree
	 */
	void exitBuildFuncBlock(MxParser.BuildFuncBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#funcBlock}.
	 * @param ctx the parse tree
	 */
	void enterFuncBlock(MxParser.FuncBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#funcBlock}.
	 * @param ctx the parse tree
	 */
	void exitFuncBlock(MxParser.FuncBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#varBlock}.
	 * @param ctx the parse tree
	 */
	void enterVarBlock(MxParser.VarBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#varBlock}.
	 * @param ctx the parse tree
	 */
	void exitVarBlock(MxParser.VarBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeRet}
	 * labeled alternative in {@link MxParser#retType}.
	 * @param ctx the parse tree
	 */
	void enterTypeRet(MxParser.TypeRetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeRet}
	 * labeled alternative in {@link MxParser#retType}.
	 * @param ctx the parse tree
	 */
	void exitTypeRet(MxParser.TypeRetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code voidRet}
	 * labeled alternative in {@link MxParser#retType}.
	 * @param ctx the parse tree
	 */
	void enterVoidRet(MxParser.VoidRetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code voidRet}
	 * labeled alternative in {@link MxParser#retType}.
	 * @param ctx the parse tree
	 */
	void exitVoidRet(MxParser.VoidRetContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#singleVarBlock}.
	 * @param ctx the parse tree
	 */
	void enterSingleVarBlock(MxParser.SingleVarBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#singleVarBlock}.
	 * @param ctx the parse tree
	 */
	void exitSingleVarBlock(MxParser.SingleVarBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code single}
	 * labeled alternative in {@link MxParser#type}.
	 * @param ctx the parse tree
	 */
	void enterSingle(MxParser.SingleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code single}
	 * labeled alternative in {@link MxParser#type}.
	 * @param ctx the parse tree
	 */
	void exitSingle(MxParser.SingleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code array}
	 * labeled alternative in {@link MxParser#type}.
	 * @param ctx the parse tree
	 */
	void enterArray(MxParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code array}
	 * labeled alternative in {@link MxParser#type}.
	 * @param ctx the parse tree
	 */
	void exitArray(MxParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#singleType}.
	 * @param ctx the parse tree
	 */
	void enterSingleType(MxParser.SingleTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#singleType}.
	 * @param ctx the parse tree
	 */
	void exitSingleType(MxParser.SingleTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#statementBlock}.
	 * @param ctx the parse tree
	 */
	void enterStatementBlock(MxParser.StatementBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#statementBlock}.
	 * @param ctx the parse tree
	 */
	void exitStatementBlock(MxParser.StatementBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stateBlock}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStateBlock(MxParser.StateBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stateBlock}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStateBlock(MxParser.StateBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varDefine}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterVarDefine(MxParser.VarDefineContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varDefine}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitVarDefine(MxParser.VarDefineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code if}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIf(MxParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code if}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIf(MxParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code for}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterFor(MxParser.ForContext ctx);
	/**
	 * Exit a parse tree produced by the {@code for}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitFor(MxParser.ForContext ctx);
	/**
	 * Enter a parse tree produced by the {@code while}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhile(MxParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code while}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhile(MxParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code break}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBreak(MxParser.BreakContext ctx);
	/**
	 * Exit a parse tree produced by the {@code break}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBreak(MxParser.BreakContext ctx);
	/**
	 * Enter a parse tree produced by the {@code continue}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterContinue(MxParser.ContinueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code continue}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitContinue(MxParser.ContinueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ret}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterRet(MxParser.RetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ret}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitRet(MxParser.RetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exp}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExp(MxParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exp}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExp(MxParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newVarEmptyValue}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void enterNewVarEmptyValue(MxParser.NewVarEmptyValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newVarEmptyValue}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void exitNewVarEmptyValue(MxParser.NewVarEmptyValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newVarNoValue}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void enterNewVarNoValue(MxParser.NewVarNoValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newVarNoValue}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void exitNewVarNoValue(MxParser.NewVarNoValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code const}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void enterConst(MxParser.ConstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code const}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void exitConst(MxParser.ConstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bitOr}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void enterBitOr(MxParser.BitOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bitOr}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void exitBitOr(MxParser.BitOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicOr}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void enterLogicOr(MxParser.LogicOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicOr}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void exitLogicOr(MxParser.LogicOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compareEqual}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void enterCompareEqual(MxParser.CompareEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compareEqual}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void exitCompareEqual(MxParser.CompareEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classVar}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void enterClassVar(MxParser.ClassVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classVar}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void exitClassVar(MxParser.ClassVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicAnd}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void enterLogicAnd(MxParser.LogicAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicAnd}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void exitLogicAnd(MxParser.LogicAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newArrayErr}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void enterNewArrayErr(MxParser.NewArrayErrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newArrayErr}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void exitNewArrayErr(MxParser.NewArrayErrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valuenceOp}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void enterValuenceOp(MxParser.ValuenceOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valuenceOp}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void exitValuenceOp(MxParser.ValuenceOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code block}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MxParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code block}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MxParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifier}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(MxParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifier}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(MxParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code selfOpLeft}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void enterSelfOpLeft(MxParser.SelfOpLeftContext ctx);
	/**
	 * Exit a parse tree produced by the {@code selfOpLeft}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void exitSelfOpLeft(MxParser.SelfOpLeftContext ctx);
	/**
	 * Enter a parse tree produced by the {@code selfOpRight}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void enterSelfOpRight(MxParser.SelfOpRightContext ctx);
	/**
	 * Exit a parse tree produced by the {@code selfOpRight}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void exitSelfOpRight(MxParser.SelfOpRightContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bitMove}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void enterBitMove(MxParser.BitMoveContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bitMove}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void exitBitMove(MxParser.BitMoveContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newArray}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void enterNewArray(MxParser.NewArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newArray}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void exitNewArray(MxParser.NewArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(MxParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(MxParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalJudge}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void enterEqualJudge(MxParser.EqualJudgeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalJudge}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void exitEqualJudge(MxParser.EqualJudgeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newVarWithValue}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void enterNewVarWithValue(MxParser.NewVarWithValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newVarWithValue}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void exitNewVarWithValue(MxParser.NewVarWithValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplyDivide}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void enterMultiplyDivide(MxParser.MultiplyDivideContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplyDivide}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void exitMultiplyDivide(MxParser.MultiplyDivideContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bitAnd}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void enterBitAnd(MxParser.BitAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bitAnd}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void exitBitAnd(MxParser.BitAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayMember}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void enterArrayMember(MxParser.ArrayMemberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayMember}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void exitArrayMember(MxParser.ArrayMemberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compareNoEqual}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void enterCompareNoEqual(MxParser.CompareNoEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compareNoEqual}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void exitCompareNoEqual(MxParser.CompareNoEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bitXor}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void enterBitXor(MxParser.BitXorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bitXor}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void exitBitXor(MxParser.BitXorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lambdaExp}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void enterLambdaExp(MxParser.LambdaExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lambdaExp}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void exitLambdaExp(MxParser.LambdaExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicOp}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void enterLogicOp(MxParser.LogicOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicOp}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void exitLogicOp(MxParser.LogicOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcCall}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall(MxParser.FuncCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcCall}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall(MxParser.FuncCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void enterAssign(MxParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void exitAssign(MxParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#constValue}.
	 * @param ctx the parse tree
	 */
	void enterConstValue(MxParser.ConstValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#constValue}.
	 * @param ctx the parse tree
	 */
	void exitConstValue(MxParser.ConstValueContext ctx);
}