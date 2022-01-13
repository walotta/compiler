package MIR.IRInstruction;

import MIR.IRVisitor;

abstract public class Instruction {
    public boolean blockFinish=false;
    abstract public String toString();
    abstract public void accept(IRVisitor visitor);
}
