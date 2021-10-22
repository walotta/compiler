package AST;

import Util.position;

public class methodNode extends exprNode{
    public exprNode father;
    public String methodName;

    public methodNode(position pos,exprNode father,String methodName){
        super(pos,false);
        this.father=father;
        this.methodName=methodName;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
