package MIR.IRInstruction;

import MIR.IRVisitor;
import MIR.Operand.IROperand;

public class retInst extends Instruction{
    public IROperand toRet;

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

    @Override
    public void accept(IRVisitor visitor){
        visitor.visit(this);
    }
}
