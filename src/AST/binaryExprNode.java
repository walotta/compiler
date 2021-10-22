package AST;

import Util.position;

public class binaryExprNode extends exprNode{

    public enum opType{
        mul,div,mod,
        add,sub,
        bitLeft,bitRight,
        smallThan,bigThan,
        smallEqual,bigEqual,
        isEqual,isNotEqual,
        bitAnd,bitXor,bitOr,
        logicAnd,logicOr
    }

    public exprNode leftExp,rightExp;
    public opType op;

    public binaryExprNode(position pos,opType op,exprNode leftExp,exprNode rightExp){
        super(pos,false);
        this.op=op;
        this.leftExp=leftExp;
        this.rightExp=rightExp;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

}
