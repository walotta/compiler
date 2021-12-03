package MIR.IRtype;

import MIR.Operand.IROperand;
import MIR.Operand.IntConstant;

public class IRIntType extends IRBaseType{
    public final int width;

    public IRIntType(){
        width=32;
    }

    public IRIntType(int width){
        this.width=width;
    }

    @Override
    public int size(){
        return width/8;
    }

    @Override
    public String toString(){
        return "i"+width;
    }

    @Override
    public IROperand defaultValue(){
        return new IntConstant(0);
    }
}
