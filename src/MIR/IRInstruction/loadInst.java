package MIR.IRInstruction;

import MIR.IRVisitor;
import MIR.Operand.Register;

public class loadInst extends Instruction{
    public Register target;
    public Register source;

    public loadInst(Register target,Register source){
        this.target=target;
        this.source=source;
    }
    @Override
    public String toString() {
        return target+" = load "+target.type+", "+source.type+" "+source;
    }

    @Override
    public Object accept(IRVisitor visitor){
        return visitor.visit(this);
    }
}
