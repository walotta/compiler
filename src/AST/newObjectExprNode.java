package AST;

import Util.position;

public class newObjectExprNode extends exprNode{
    public singleTypeNode objectType;

    public newObjectExprNode(position pos,singleTypeNode objectType){
        super(pos,true);
        this.objectType=objectType;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
