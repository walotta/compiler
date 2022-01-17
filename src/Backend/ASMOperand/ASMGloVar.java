package Backend.ASMOperand;

import java.util.StringJoiner;

public class ASMGloVar extends ASMGlobalVarBase{
    String name;

    public ASMGloVar(String name){
        this.name=name;
    }

    @Override
    public String print(){
        StringBuilder builder=new StringBuilder();
        builder.append("\t.type\t").append(name).append(",@object\t# @").append(name).append('\n');
        builder.append("\t.section\t.sbss,\"aw\",@nobits").append('\n');
        builder.append("\t.globl\t").append(name).append('\n');
        builder.append(name).append(":").append('\n');
        builder.append("\t.word\t0                               # 0x0");
        return builder.toString();
    }

    @Override
    public String toString(){
        return name;
    }
}
