// Generated from /Users/wzj/Documents/code/compiler/src/Parser/Mx.g4 by ANTLR 4.9.2
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
	 * Visit a parse tree produced by {@link MxParser#retType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetType(MxParser.RetTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#singleVarBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleVarBlock(MxParser.SingleVarBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MxParser.TypeContext ctx);
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
	 * Visit a parse tree produced by {@link MxParser#forInitExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInitExpr(MxParser.ForInitExprContext ctx);
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
	 * Visit a parse tree produced by the {@code retStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetStatement(MxParser.RetStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpStatement(MxParser.ExpStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code emptyStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement(MxParser.EmptyStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classMember}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMember(MxParser.ClassMemberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(MxParser.AtomExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newArray}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewArray(MxParser.NewArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpr(MxParser.BinaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newInitObject}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewInitObject(MxParser.NewInitObjectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code postFixIncDec}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostFixIncDec(MxParser.PostFixIncDecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayMember}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayMember(MxParser.ArrayMemberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(MxParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newArrayErr}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewArrayErr(MxParser.NewArrayErrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lambdaExpr}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaExpr(MxParser.LambdaExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newObject}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewObject(MxParser.NewObjectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcCall}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCall(MxParser.FuncCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link MxParser#experssion}.
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