package Backend;

import Backend.ASMOperand.ASMGlobalVarBase;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.StringJoiner;

public class ASMModule {
    public LinkedHashMap<String,ASMFunction> funcs;
    public LinkedHashMap<String, ASMGlobalVarBase> globalVars;

    public ASMModule(){
        funcs=new LinkedHashMap<>();
        globalVars=new LinkedHashMap<>();
    }

    @Override
    public String toString(){
        StringJoiner joiner=new StringJoiner("\n\n");
        funcs.forEach((funcName,func)->joiner.add(func.toString()));
        globalVars.forEach((varName,v)->joiner.add(v.print()));
        return joiner.toString();
    }
}
