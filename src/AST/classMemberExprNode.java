package AST;

import Util.position;
import Util.varEntity;

public class classMemberExprNode extends exprNode{
    public exprNode fatherExpr;
    public String memberName;
    public varEntity var;

    public classMemberExprNode(position pos,exprNode fatherExpr,String memberName){
        super(pos,true);
        this.fatherExpr=fatherExpr;
        this.memberName=memberName;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
