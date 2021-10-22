package AST;

import Util.position;

public class arrayMemberExprNode extends exprNode{
    exprNode arrayFather;
    exprNode index;

    public arrayMemberExprNode(position pos,exprNode arrayFather,exprNode index){
        super(pos,arrayFather.isAssignable);
        this.arrayFather=arrayFather;
        this.index=index;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
