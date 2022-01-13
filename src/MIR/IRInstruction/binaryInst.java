package MIR.IRInstruction;

import MIR.IRVisitor;
import MIR.Operand.IROperand;
import MIR.Operand.Register;

public class binaryInst extends Instruction{

    public enum binaryType{
        mul,sdiv,srem,          // *  /  %
        add,sub,                // +  -
        shl,ashr,               // << >>
        and,xor,or,             // &  ^  |
        logicAnd,logicOr        // && ||
    }

    public binaryType type;
    public IROperand leftOperand,rightOperand;
    public Register target;

    public binaryInst(binaryType type, IROperand leftOperand, IROperand rightOperand, Register target){
        this.type=type;
        this.leftOperand=leftOperand;
        this.rightOperand=rightOperand;
        this.target=target;
    }

    @Override
    public String toString() {
        return target+" = "+type+" "+leftOperand.type+" "+leftOperand+", "+rightOperand;
    }

    @Override
    public void accept(IRVisitor visitor){
        visitor.visit(this);
    }
}
