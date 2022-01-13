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
        //8 for IR
        return 8;
        //! 4 for codegen
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
