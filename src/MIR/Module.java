package MIR;

import MIR.Operand.globalVariable;

import java.util.LinkedHashMap;

public class Module {
    public LinkedHashMap<String, Function> functions;
    public LinkedHashMap<String, globalVariable> globalVars;

    public Module(){
        functions=new LinkedHashMap<>();
        globalVars=new LinkedHashMap<>();
    }
}
