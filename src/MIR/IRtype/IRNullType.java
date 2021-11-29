package MIR.IRtype;

import MIR.Operand.IROperand;

public class IRNullType extends IRBaseType{
    //todo delete
    @Override
    public String toString(){
        return "null";
    }

    @Override
    public IROperand defaultValue() {
        return null;
    }
}
