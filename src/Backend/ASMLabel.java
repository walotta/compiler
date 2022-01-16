package Backend;

public class ASMLabel {
    String labelName;

    public ASMLabel(ASMFunction fa,String name){
        labelName="."+fa.funcName+"."+name;
    }

    @Override
    public String toString(){
        return labelName;
    }
}
