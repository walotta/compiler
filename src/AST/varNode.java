package AST;

import Util.position;
import Util.varEntity;

public class varNode extends exprNode{

    public String name;
    public varEntity var;

    public varNode(position pos,String name){
        super(pos,true);
        this.name=name;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
