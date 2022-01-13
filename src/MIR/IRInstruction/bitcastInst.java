package MIR.IRInstruction;

import MIR.IRVisitor;
import MIR.Operand.IROperand;
import MIR.Operand.Register;

public class bitcastInst extends Instruction{
    public Register target;
    public IROperand source;

    public bitcastInst(IROperand source,Register target){
        this.source=source;
        this.target=target;
    }

    public String toString(){
        return target+" = bitcast "+source.type+" "+source+" to "+target.type;
    }

    @Override
    public void accept(IRVisitor visitor){
        visitor.visit(this);
    }
}
