package AST;

public interface ASTVisitor {
    void visit(programNode it);

    void visit(funcBlockNode it);
    void visit(classBlockNode it);
    void visit(singleVarBlockNode it);
    void visit(varBlockNode it);

    void visit(statementBlockNode it);
    void visit(breakNode it);
    void visit(continueNode it);
    void visit(exprStatementNode it);
    void visit(forNode it);
    void visit(ifNode it);
    void visit(retNode it);
    void visit(whileNode it);
    void visit(emptyStatementNode it);

    void visit(binaryExprNode it);
    void visit(unaryExprNode it);
    void visit(newArrayExprNode it);
    void visit(newInitObjectExprNode it);
    void visit(newObjectExprNode it);
    void visit(postfixExprNode it);
    void visit(funcCallExprNode it);
    void visit(assignExprNode it);
    void visit(classMemberExprNode it);
    void visit(arrayMemberExprNode it);
    void visit(thisExprNode it);

    void visit(intConstNode it);
    void visit(boolConstNode it);
    void visit(nullConstNode it);
    void visit(stringConstNode it);

    void visit(singleTypeNode it);
    void visit(typeNode it);

    void visit(varNode it);
    void visit(funcNode it);
    void visit(methodNode it);
    void visit(lambdaExprNode it);
}
