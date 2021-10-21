package AST;

import Util.position;

public class unaryExprNode extends exprNode{
    public enum opType {
        selfAdd, selfSub,
        positive,negative,
        logicNot,bitNot
    }

    public exprNode calExp;
    public opType op;

    public unaryExprNode(position pos,exprNode calExp,opType op){
        super(pos,(op==opType.selfAdd||op==opType.selfSub));
        this.calExp=calExp;
        this.op=op;
    }
}
