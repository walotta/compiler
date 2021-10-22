package AST;

import Util.position;

import java.util.ArrayList;

public class funcBlockNode extends ASTNode{
    public typeNode retType;
    public String funcName;
    public ArrayList<singleVarBlockNode> paras;
    public statementBlockNode funcStatementLists;

    public funcBlockNode(position pos, typeNode retType, String funcName, ArrayList<singleVarBlockNode> paras, statementBlockNode funcStatementLists){
        super(pos);
        this.retType=retType;
        this.funcName=funcName;
        this.paras=paras;
        this.funcStatementLists=funcStatementLists;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
