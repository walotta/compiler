package AST;

import Util.position;

public class forNode extends statementNode{
    public ASTNode initExp;
    public exprNode finishExp,stepExp;
    public statementNode runStatement;

    public forNode(position pos,ASTNode initExp,exprNode finishExp,exprNode stepExp,statementNode runStatement){
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
