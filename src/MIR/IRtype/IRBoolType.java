package MIR.IRtype;

import MIR.Operand.BoolConstant;
import MIR.Operand.IROperand;

public class IRBoolType extends IRBaseType{

    @Override
    public int size() {
        return 4;
    }

    @Override
    public String toString(){
        return "i1";
    }

    @Override
    public IROperand defaultValue(){
        return new BoolConstant(false);
    }
}
