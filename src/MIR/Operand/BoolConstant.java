package MIR.Operand;

import MIR.IRtype.IRBoolType;

public class BoolConstant extends IROperand{
    public boolean value;

    public BoolConstant(boolean value){
        super(new IRBoolType());
        this.value=value;
    }

    @Override
    public String toString(){
        return value?"true":"false";
    }
}
