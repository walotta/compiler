package MIR.IRtype;

import MIR.Operand.IROperand;
import MIR.Operand.NullptrConstant;

public class IRPointerType extends IRBaseType{
    public IRBaseType baseType;

    public IRPointerType(IRBaseType baseType){
        this.baseType=baseType;
    }

    @Override
    public int size(){
        return 4;
    }

    @Override
    public String toString(){
        return baseType.toString()+"*";
    }

    @Override
    public IROperand defaultValue(){
        return new NullptrConstant(new IRPointerType(baseType));
    }
}
