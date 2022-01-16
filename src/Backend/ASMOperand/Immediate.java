package Backend.ASMOperand;

public class Immediate extends ASMOperandBase{
    int value;

    public Immediate(int value){
        this.value=value;
    }

    @Override
    public String toString(){
        return Integer.toString(value);
    }
}
