package MIR.IRtype;

import MIR.Operand.IROperand;
import MIR.Operand.StringConstant;

public class IRStringType extends IRBaseType{
    //todo
    @Override
    public String toString(){
        return "todo";
    }

    @Override
    public IROperand defaultValue(){
        return new StringConstant("default String");
    }
}
