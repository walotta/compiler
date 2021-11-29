package MIR.IRtype;

import MIR.Operand.BoolConstant;
import MIR.Operand.IROperand;

public class IRBoolType extends IRBaseType{
    @Override
    public String toString(){
        return "i8";
    }

    @Override
    public IROperand defaultValue(){
        return new BoolConstant(false);
    }
}
