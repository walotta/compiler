package MIR.IRtype;

import MIR.Operand.IROperand;

public class IRArrayType extends IRPointerType{
    private final int length;

    //todo remove
    public IRArrayType(IRPointerType baseType,int length){
        super(baseType);
        this.length=length;
    }

    @Override
    public int size() {
        return baseType.size()*length;
    }

    @Override
    public IROperand defaultValue() {
        return null;
    }

    @Override
    public String toString() {
        return "["+length+" x "+baseType+"]";
    }
}
