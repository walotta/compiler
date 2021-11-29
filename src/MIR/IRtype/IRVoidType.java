package MIR.IRtype;

import MIR.Operand.IROperand;

public class IRVoidType extends IRBaseType{
    @Override
    public String toString(){
        return "void";
    }

    @Override
    public IROperand defaultValue(){
        throw new IllegalStateException();
    }
}
