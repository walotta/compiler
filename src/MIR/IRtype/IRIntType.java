package MIR.IRtype;

import MIR.Operand.IROperand;
import MIR.Operand.IntConstant;

public class IRIntType extends IRBaseType{
    @Override
    public String toString(){
        return "i32";
    }

    @Override
    public IROperand defaultValue(){
        return new IntConstant(0);
    }
}
