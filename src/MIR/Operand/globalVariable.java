package MIR.Operand;

import MIR.IRtype.IRBaseType;

public class globalVariable extends Register{

    public globalVariable(String identifier, IRBaseType type){
        super(-1,identifier,type);
    }

    @Override
    public String toString(){
        return "@"+identifier;
    }
}
