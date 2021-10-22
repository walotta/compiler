package Frontend;

import AST.*;
import Util.Scope.Scope;
import Util.Scope.globalScope;
import Util.Type.classType;
import Util.Type.funcType;
import Util.error.semanticError;

public class SymbolCollector implements ASTVisitor {
    private globalScope gScope;
    private Scope currentScope = null;

    public SymbolCollector(globalScope gScope) {
        this.gScope = gScope;
    }

    @Override
    public void visit(programNode it) {
        //todo

    }

    @Override
    public void visit(funcBlockNode it) {
        //todo

    }

    @Override
    public void visit(classBlockNode it) {
        //todo

    }

    @Override
    public void visit(singleVarBlockNode it) {
        //todo

    }

    @Override
    public void visit(varBlockNode it) {
        //todo

    }

    @Override
    public void visit(statementBlockNode it) {
        //todo

    }

    @Override
    public void visit(breakNode it) {
        //todo

    }

    @Override
    public void visit(continueNode it) {
        //todo

    }

    @Override
    public void visit(exprStatementNode it) {
        //todo

    }

    @Override
    public void visit(forNode it) {
        //todo

    }

    @Override
    public void visit(ifNode it) {
        //todo

    }

    @Override
    public void visit(retNode it) {
        //todo

    }

    @Override
    public void visit(whileNode it) {
        //todo

    }

    @Override
    public void visit(emptyStatementNode it) {
        //todo

    }

    @Override
    public void visit(binaryExprNode it) {
        //todo

    }

    @Override
    public void visit(unaryExprNode it) {
        //todo

    }

    @Override
    public void visit(newArrayExprNode it) {
        //todo

    }

    @Override
    public void visit(newInitObjectExprNode it) {
        //todo

    }

    @Override
    public void visit(newObjectExprNode it) {
        //todo

    }

    @Override
    public void visit(postfixExprNode it) {
        //todo

    }

    @Override
    public void visit(funcCallExprNode it) {
        //todo

    }

    @Override
    public void visit(assignExprNode it) {
        //todo

    }

    @Override
    public void visit(classMemberExprNode it) {
        //todo

    }

    @Override
    public void visit(arrayMemberExprNode it) {
        //todo

    }

    @Override
    public void visit(thisExprNode it) {
        //todo

    }

    @Override
    public void visit(intConstNode it) {
        //todo

    }

    @Override
    public void visit(boolConstNode it) {
        //todo

    }

    @Override
    public void visit(nullConstNode it) {
        //todo

    }

    @Override
    public void visit(stringConstNode it) {
        //todo

    }

    @Override
    public void visit(singleTypeNode it) {
        //todo

    }

    @Override
    public void visit(typeNode it) {
        //todo

    }

    @Override
    public void visit(varNode it) {
        //todo

    }

    @Override
    public void visit(funcNode it) {
        //todo

    }

    @Override
    public void visit(methodNode it) {
        //todo

    }

    @Override
    public void visit(lambdaExprNode it) {
        //todo

    }

}