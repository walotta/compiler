package MIR.IRInstruction;

import MIR.Operand.IROperand;

public class retInst extends Instruction{
    IROperand toRet;

    public retInst(IROperand toRet){
        this.toRet=toRet;
        this.blockFinish=true;
    }

    @Override
    public String toString() {
        if(toRet==null)
            return "ret void";
        else
            return "ret "+toRet.type+" "+toRet;
    }
}
