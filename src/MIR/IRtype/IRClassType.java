package MIR.IRtype;

import MIR.ClassUnit;
import MIR.Operand.IROperand;

public class IRClassType extends IRBaseType{
    public String name;
    int size;

    public IRClassType(String name){
        this.name=name;
        this.size=0;
    }

    public void calSize(ClassUnit cu){
        for(var varUnit:cu.memberVars.values())
            size+=varUnit.size();
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public String toString() {
        return "%class."+name;
    }

    @Override
    public IROperand defaultValue() {
        return null;
    }
}
