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
	 * Enter a parse tree produced by {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MxParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MxParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MxParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MxParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(MxParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(MxParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(MxParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(MxParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void enterExpersion(MxParser.ExpersionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#expersion}.
	 * @param ctx the parse tree
	 */
	void exitExpersion(MxParser.ExpersionContext ctx);
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