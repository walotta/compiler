package AST;

import Util.position;

public class singleTypeNode extends typeNode {
    public singleTypeNode(position pos, String typeName){
        super(pos,typeName,0);
    }
}
