package AST;

import Util.position;

public class arrayMemberExprNode extends exprNode{
    public exprNode arrayFather;
    public exprNode index;

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
