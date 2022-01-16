package Backend.ASMOperand;

public class FuncStackSize extends Immediate{
    public String funcName;
    public int offset;

    public FuncStackSize(String funcName,int offset){
        super(0);
        this.funcName=funcName;
        this.offset=offset;
    }

    public void resize(int size){
        value=size;
    }

    @Override
    public String toString(){
        return Integer.toString(value+offset);
    }
}
