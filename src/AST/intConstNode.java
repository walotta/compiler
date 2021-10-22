package AST;

import Util.position;

public class intConstNode extends constExprNode{
    public int value;

    public intConstNode(position pos,int value){
        super(pos);
        this.value=value;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
