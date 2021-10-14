// Generated from /Users/wzj/Documents/code/compiler/src/Parser/Mx.g4 by ANTLR 4.9.1
package Parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MxParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MxVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MxParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#programBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramBlock(MxParser.ProgramBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#classBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBlock(MxParser.ClassBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#buildFuncBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuildFuncBlock(MxParser.BuildFuncBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#funcBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncBlock(MxParser.FuncBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#varBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarBlock(MxParser.VarBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeRet}
	 * labeled alternative in {@link MxParser#retType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeRet(MxParser.TypeRetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code voidRet}
	 * labeled alternative in {@link MxParser#retType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidRet(MxParser.VoidRetContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#singleVarBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleVarBlock(MxParser.SingleVarBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code single}
	 * labeled alternative in {@link MxParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingle(MxParser.SingleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code array}
	 * labeled alternative in {@link MxParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(MxParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#singleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleType(MxParser.SingleTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#statementBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementBlock(MxParser.StatementBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stateBlock}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStateBlock(MxParser.StateBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDefine}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefine(MxParser.VarDefineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(MxParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code for}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor(MxParser.ForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code while}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(MxParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code break}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak(MxParser.BreakContext ctx);
	/**
	 * Visit a parse tree produced by the {@code continue}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinue(MxParser.ContinueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ret}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRet(MxParser.RetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exp}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(MxParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newVarEmptyValue}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewVarEmptyValue(MxParser.NewVarEmptyValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newVarNoValue}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewVarNoValue(MxParser.NewVarNoValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code const}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConst(MxParser.ConstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bitOr}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitOr(MxParser.BitOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicOr}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicOr(MxParser.LogicOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compareEqual}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareEqual(MxParser.CompareEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classVar}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassVar(MxParser.ClassVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicAnd}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicAnd(MxParser.LogicAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newArrayErr}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewArrayErr(MxParser.NewArrayErrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valuenceOp}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValuenceOp(MxParser.ValuenceOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code block}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MxParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifier}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(MxParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code selfOpLeft}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfOpLeft(MxParser.SelfOpLeftContext ctx);
	/**
	 * Visit a parse tree produced by the {@code selfOpRight}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfOpRight(MxParser.SelfOpRightContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bitMove}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitMove(MxParser.BitMoveContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newArray}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewArray(MxParser.NewArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(MxParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalJudge}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualJudge(MxParser.EqualJudgeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newVarWithValue}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewVarWithValue(MxParser.NewVarWithValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplyDivide}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplyDivide(MxParser.MultiplyDivideContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bitAnd}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitAnd(MxParser.BitAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayMember}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayMember(MxParser.ArrayMemberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compareNoEqual}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareNoEqual(MxParser.CompareNoEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bitXor}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitXor(MxParser.BitXorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lambdaExp}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaExp(MxParser.LambdaExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicOp}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicOp(MxParser.LogicOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcCall}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCall(MxParser.FuncCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(MxParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#constValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstValue(MxParser.ConstValueContext ctx);
}