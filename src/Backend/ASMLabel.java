package Backend;

public class ASMLabel {
    String labelName;

    public ASMLabel(ASMFunction fa,String name){
        labelName="."+fa.funcName+"."+name;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        return labelName.equals(((ASMLabel) obj).labelName);
    }

    @Override
    public int hashCode(){
        return labelName.hashCode();
    }

    @Override
    public String toString(){
        return labelName;
    }
}
