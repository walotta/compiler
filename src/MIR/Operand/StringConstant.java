package MIR.Operand;

import MIR.IRVisitor;
import MIR.IRtype.IRStringType;

public class StringConstant extends IROperand{
    public final String value;
    public final String name;
    public final int len;

    public StringConstant(int id,String value){
        super(new IRStringType());
        this.name=".str."+id;
        String vv=value.substring(1,value.length()-1);
        vv=vv.replace("\\\\", "\\")
             .replace("\\n", "\n")
             .replace("\\t", "\t")
             .replace("\\\"", "\"");
        this.len=vv.length()+1;
        vv=vv.replace("\\", "\\5C")
             .replace("\n", "\\0A")
             .replace("\t", "\\09")
             .replace("\"", "\\22");
        this.value=vv;
    }

    @Override
    public String toString(){
        return "getelementptr inbounds (["+len+" x i8], ["+len+" x i8]* @"+name+", i32 0,i32 0)";
    }

    public String define(){
        return "@"+name+" = private unnamed_addr constant [ "+len+" x i8 ] c\""+value+"\\00\"";
    }

    public Object accept(IRVisitor visitor){
        return visitor.visit(this);
    }
}
