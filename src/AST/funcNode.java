package AST;

import Util.position;

public class funcNode extends exprNode{
    public String funcName;

    public funcNode(position pos, String funcName){
        super(pos,false);
        this.funcName=funcName;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
