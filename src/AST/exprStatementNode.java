package AST;

import Util.position;

public class exprStatementNode extends statementNode{
    exprNode expr;

    public exprStatementNode(position pos,exprNode expr){
        super(pos);
        this.expr=expr;
    }

}
