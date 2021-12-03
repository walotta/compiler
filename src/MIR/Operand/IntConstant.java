package MIR.Operand;

import MIR.IRtype.IRIntType;
import MIR.Operand.IROperand;

public class IntConstant extends IROperand {
    public int value;

    public IntConstant(int value){
        super(new IRIntType());
        this.value=value;
    }

    public IntConstant(int value,int width){
        super(new IRIntType(width));
        this.value=value;
    }

    @Override
    public String toString(){
        return Integer.valueOf(value).toString();
    }
}
