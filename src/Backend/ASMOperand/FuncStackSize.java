package Backend.ASMOperand;

public class FuncStackSize extends Immediate{
    public String funcName;
    public int offset;
    public boolean positive;

    public FuncStackSize(String funcName,int offset,boolean positive){
        super(0);
        this.funcName=funcName;
        this.offset=offset;
        this.positive=positive;
    }

    public void resize(int size){
        if(positive)
            value=size;
        else
            value=-size;
    }

    @Override
    public String toString(){
        return Integer.toString(value+offset);
    }
}
