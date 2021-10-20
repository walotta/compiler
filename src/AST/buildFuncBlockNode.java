package AST;

import Util.position;

import java.util.ArrayList;

public class buildFuncBlockNode extends funcBlockNode{

    public buildFuncBlockNode(position pos, String funcName, ArrayList<singleVarBlockNode> paras, statementBlockNode funcStatementLists){
        super(pos,null,funcName,paras,funcStatementLists);
    }

}
