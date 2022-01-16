package Backend;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.StringJoiner;

public class ASMModule {
    public LinkedHashMap<String,ASMFunction> funcs;

    public ASMModule(){
        funcs=new LinkedHashMap<>();
    }

    @Override
    public String toString(){
        StringJoiner joiner=new StringJoiner("\n\n");
        funcs.forEach((funcName,func)->joiner.add(func.toString()));
        return joiner.toString();
    }
}
