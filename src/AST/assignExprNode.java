package AST;

import Util.position;

public class assignExprNode extends exprNode{
    public exprNode leftExpr,rightExpr;

    public assignExprNode(position pos,exprNode leftExpr,exprNode rightExpr){
        super(pos,rightExpr.isAssignable);
        this.leftExpr=leftExpr;
        this.rightExpr=rightExpr;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

}
