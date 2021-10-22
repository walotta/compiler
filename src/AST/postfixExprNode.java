package AST;

import Util.position;

public class postfixExprNode extends exprNode{
    public enum opType {
        selfAdd, selfSub
    }

    public exprNode calExp;
    public opType op;

    public postfixExprNode(position pos, exprNode calExp, opType op){
        super(pos,false);
        this.calExp=calExp;
        this.op=op;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
