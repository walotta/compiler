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

    public void visit(programNode it) {
        //todo

    }

    public void visit(funcBlockNode it) {
        //todo

    }

    public void visit(classBlockNode it) {
        //todo

    }

    public void visit(singleVarBlockNode it) {
        //todo

    }

    public void visit(varBlockNode it) {
        //todo

    }

    public void visit(statementBlockNode it) {
        //todo

    }

    public void visit(breakNode it) {
        //todo

    }

    public void visit(continueNode it) {
        //todo

    }

    public void visit(exprStatementNode it) {
        //todo

    }

    public void visit(forNode it) {
        //todo

    }

    public void visit(ifNode it) {
        //todo

    }

    public void visit(retNode it) {
        //todo

    }

    public void visit(whileNode it) {
        //todo

    }

    public void visit(emptyStatementNode it) {
        //todo

    }

    public void visit(binaryExprNode it) {
        //todo

    }

    public void visit(unaryExprNode it) {
        //todo

    }

    public void visit(newArrayExprNode it) {
        //todo

    }

    public void visit(newInitObjectExprNode it) {
        //todo

    }

    public void visit(newObjectExprNode it) {
        //todo

    }

    public void visit(postfixExprNode it) {
        //todo

    }

    public void visit(funcCallExprNode it) {
        //todo

    }

    public void visit(assignExprNode it) {
        //todo

    }

    public void visit(classMemberExprNode it) {
        //todo

    }

    public void visit(arrayMemberExprNode it) {
        //todo

    }

    public void visit(thisExprNode it) {
        //todo

    }

    public void visit(intConstNode it) {
        //todo

    }

    public void visit(boolConstNode it) {
        //todo

    }

    public void visit(nullConstNode it) {
        //todo

    }

    public void visit(stringConstNode it) {
        //todo

    }

    public void visit(singleTypeNode it) {
        //todo

    }

    public void visit(typeNode it) {
        //todo

    }

    public void visit(varNode it) {
        //todo

    }

    public void visit(funcNode it) {
        //todo

    }

    public void visit(methodNode it) {
        //todo

    }

    public void visit(lambdaExprNode it) {
        //todo

    }

}