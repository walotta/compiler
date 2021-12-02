package MIR.IRtype;

import MIR.Operand.IROperand;
import MIR.Operand.StringConstant;

public class IRStringType extends IRPointerType{

    public IRStringType(){
        super(new IRCharType());
    }

}
