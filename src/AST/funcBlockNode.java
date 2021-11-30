package AST;

import MIR.Function;
import Util.Type.funcType;
import Util.position;

import java.util.ArrayList;

public class funcBlockNode extends ASTNode{
    public typeNode retType;
    public String funcName;
    public ArrayList<singleVarBlockNode> paras;
    public statementBlockNode funcStatementLists;
    public funcType func;

    public funcBlockNode(position pos, typeNode retType, String funcName, ArrayList<singleVarBlockNode> paras, statementBlockNode funcStatementLists){
        super(pos);
        this.retType=retType;
        this.funcName=funcName;
        this.paras=paras;
        this.funcStatementLists=funcStatementLists;
        this.func=null;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
