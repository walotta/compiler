package AST;

import Util.position;

import java.util.ArrayList;

public class funcCallExprNode extends exprNode{
    public exprNode funcName;
    public ArrayList<exprNode> paras;

    public funcCallExprNode(position pos, exprNode funcName,ArrayList<exprNode> paras){
        super(pos,false);
        this.funcName=funcName;
        this.paras=paras;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
