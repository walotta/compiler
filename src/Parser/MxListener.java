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
	 * Enter a parse tree produced by {@link MxParser#retType}.
	 * @param ctx the parse tree
	 */
	void enterRetType(MxParser.RetTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#retType}.
	 * @param ctx the parse tree
	 */
	void exitRetType(MxParser.RetTypeContext ctx);
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
	 * Enter a parse tree produced by {@link MxParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MxParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MxParser.TypeContext ctx);
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
	 * Enter a parse tree produced by the {@code retStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterRetStatement(MxParser.RetStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code retStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitRetStatement(MxParser.RetStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExpStatement(MxParser.ExpStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expStatement}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExpStatement(MxParser.ExpStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classMember}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 */
	void enterClassMember(MxParser.ClassMemberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classMember}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 */
	void exitClassMember(MxParser.ClassMemberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(MxParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(MxParser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newArray}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 */
	void enterNewArray(MxParser.NewArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newArray}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 */
	void exitNewArray(MxParser.NewArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpr(MxParser.BinaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpr(MxParser.BinaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newInitObject}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 */
	void enterNewInitObject(MxParser.NewInitObjectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newInitObject}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 */
	void exitNewInitObject(MxParser.NewInitObjectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code postFixIncDec}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 */
	void enterPostFixIncDec(MxParser.PostFixIncDecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code postFixIncDec}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 */
	void exitPostFixIncDec(MxParser.PostFixIncDecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayMember}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 */
	void enterArrayMember(MxParser.ArrayMemberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayMember}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 */
	void exitArrayMember(MxParser.ArrayMemberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(MxParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(MxParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newArrayErr}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 */
	void enterNewArrayErr(MxParser.NewArrayErrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newArrayErr}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 */
	void exitNewArrayErr(MxParser.NewArrayErrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newObject}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 */
	void enterNewObject(MxParser.NewObjectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newObject}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 */
	void exitNewObject(MxParser.NewObjectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lambdaExp}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 */
	void enterLambdaExp(MxParser.LambdaExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lambdaExp}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 */
	void exitLambdaExp(MxParser.LambdaExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcCall}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall(MxParser.FuncCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcCall}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall(MxParser.FuncCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link MxParser#experssion}.
	 * @param ctx the parse tree
	 */
	void enterAssign(MxParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link MxParser#experssion}.
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