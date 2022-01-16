package Backend;

import java.util.ArrayList;
import java.util.StringJoiner;

public class ASMModule {
    public ArrayList<ASMFunction> funcs;

    public ASMModule(){
        funcs=new ArrayList<>();
    }

    @Override
    public String toString(){
        StringJoiner joiner=new StringJoiner("\n\n");
        funcs.forEach(func->joiner.add(func.toString()));
        return joiner.toString();
    }
}
