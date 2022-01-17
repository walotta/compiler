package MIR;

import MIR.IRtype.IRBaseType;
import MIR.Operand.IROperand;
import MIR.Operand.IntConstant;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.StringJoiner;

public class ClassUnit {
    public String className;
    public LinkedHashMap<String,IRMember> memberVars;
    public LinkedHashMap<String,Function> methods;
    public Function initFunc;

    public ClassUnit(String className){
        this.className=className;
        memberVars=new LinkedHashMap<>();
        methods=new LinkedHashMap<>();
        initFunc=null;
    }

    public IntConstant queryMember(String name){
        int index=memberVars.get(name).memberCnt();
        return new IntConstant(index);
    }

    public int queryOffset(int id){
        int ret=0;
        int i=0;
        for(var v:memberVars.values()){
            if(i>=id)break;
            i+=1;
            ret+=v.size();
        }
        return ret;
    }

    @Override
    public String toString(){
        StringBuilder builder=new StringBuilder();
        builder.append("%class.").append(className).append(" = type { ");
        StringJoiner memberVarsJoiner=new StringJoiner(", ");
        if(memberVars.isEmpty())
            memberVarsJoiner.add("i8");
        else
            memberVars.forEach((memName,memType)->memberVarsJoiner.add(memType.toString()));
        builder.append(memberVarsJoiner).append(" }\n\n");
        StringJoiner methodJoiner=new StringJoiner("\n\n");
        //add initFunc
        methodJoiner.add(initFunc.toString());
        //add method
        methods.forEach((methodName,item)->methodJoiner.add(item.toString()));
        builder.append(methodJoiner);
        return builder.toString();
    }

    public Object accept(IRVisitor visitor){
        return visitor.visit(this);
    }
}
