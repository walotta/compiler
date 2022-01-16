package Backend.ASMOperand;

import java.util.StringJoiner;

public class ASMGloString extends ASMGlobalVarBase{
    String name;
    String contain;

    public ASMGloString(String name,String contain){
        this.name=name;
        this.contain=contain;
    }

    @Override
    public String print(){
        StringJoiner joiner=new StringJoiner("\n");
        joiner.add("\t.type\t"+name+",@object                  # @"+name);
        joiner.add("\t.section\t.rodata.str1.1,\"aMS\",@progbits,1");
        joiner.add(name+":");
        joiner.add("\t.asciz\t\""+contain+"\"");
        return joiner.toString();
    }

    @Override
    public String toString(){
        return name;
    }
}
