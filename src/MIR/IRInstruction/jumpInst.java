package MIR.IRInstruction;

public class jumpInst extends Instruction{
    int target;

    public jumpInst(int target){
        this.target=target;
        this.blockFinish=true;
    }

    @Override
    public String toString() {
        return "br label %"+target;
    }
}
