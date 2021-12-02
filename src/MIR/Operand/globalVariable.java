package MIR.Operand;

import MIR.IRtype.IRBaseType;

public class globalVariable extends Register{
    IROperand initVal;

    public globalVariable(String identifier, IRBaseType type){
        super(-1,identifier,type);
        initVal=null;
    }

    @Override
    public String toString(){
        return "@"+identifier;
    }
}
