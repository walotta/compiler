package MIR.IRInstruction;

import MIR.Operand.Register;

public class loadInst extends Instruction{
    Register target;
    Register source;

    public loadInst(Register target,Register source){
        this.target=target;
        this.source=source;
    }
    @Override
    public String toString() {
        return target+" = load "+target.type+", "+source.type+" "+source;
    }
}
