package AST;

import Util.position;

import java.util.ArrayList;

public class lambdaExprNode extends exprNode{
    public ArrayList<singleVarBlockNode> paras;
    public statementBlockNode funcStatementLists;

    public lambdaExprNode(position pos,ArrayList<singleVarBlockNode> paras,statementBlockNode funcStatementLists){
        super(pos,false);
        this.paras=paras;
        this.funcStatementLists=funcStatementLists;
    }

}
