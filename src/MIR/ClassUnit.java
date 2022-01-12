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

}
