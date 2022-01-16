package Backend;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.StringJoiner;

public class ASMModule {
    public LinkedHashMap<String,ASMFunction> funcs;
    public ArrayList<ASMFunction> initFuncs;

    public ASMModule(){
        funcs=new LinkedHashMap<>();
        initFuncs=new ArrayList<>();
    }

    @Override
    public String toString(){
        StringJoiner joiner=new StringJoiner("\n\n");
        funcs.forEach((funcName,func)->joiner.add(func.toString()));
        if(!initFuncs.isEmpty()) {
            joiner.add("# --globalInit funcs");
            initFuncs.forEach(func -> joiner.add(func.toString()));
        }
        return joiner.toString();
    }
}
