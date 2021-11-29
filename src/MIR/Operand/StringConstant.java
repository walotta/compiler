package MIR.Operand;

import MIR.IRtype.IRStringType;

public class StringConstant extends IROperand{
    public String value;

    public StringConstant(String value){
        super(new IRStringType());
        this.value=value;
    }

    @Override
    public String toString(){
        return value;
    }
}
