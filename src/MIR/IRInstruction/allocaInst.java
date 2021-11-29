package MIR.IRInstruction;

import MIR.IRtype.IRPointerType;
import MIR.Operand.Register;

public class allocaInst extends Instruction{
    Register target;
    int number;

    public allocaInst(Register target){
        this.target=target;
        this.number=1;
    }

    public allocaInst(Register target,int number){
        this.target=target;
        this.number=number;
    }

    @Override
    public String toString(){
        String ret=target+" = alloca ";
        if(number==1){
            ret=ret+((IRPointerType)target.type).baseType;
        }else{
            ret=ret+"["+number+" x "+target.type+"]";
        }
        return ret;
    }
}
