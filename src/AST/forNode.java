package AST;

import Util.position;

public class forNode extends statementNode{
    public exprNode initExp,finishExp,stepExp;
    public statementNode runStatement;

    public forNode(position pos,exprNode initExp,exprNode finishExp,exprNode stepExp,statementNode runStatement){
        super(pos);
        this.initExp=initExp;
        this.finishExp=finishExp;
        this.stepExp=stepExp;
        this.runStatement=runStatement;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

}
