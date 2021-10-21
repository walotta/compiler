package AST;

import Util.position;

public class classMemberExprNode extends exprNode{
    public exprNode fatherExpr;
    public String memberName;

    public classMemberExprNode(position pos,exprNode fatherExpr,String memberName){
        super(pos,true);
        this.fatherExpr=fatherExpr;
        this.memberName=memberName;
    }
}
