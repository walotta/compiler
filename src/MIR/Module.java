package MIR;

import MIR.IRtype.*;
import MIR.Operand.globalVariable;
import Util.Scope.globalScope;
import Util.Type.*;
import Util.error.compilerError;
import Util.position;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Module {
    public LinkedHashMap<String, Function> functions;
    public LinkedHashMap<String, globalVariable> globalVars;
    public LinkedList<Function> initFuncs;

    public Module(){
        functions=new LinkedHashMap<>();
        globalVars=new LinkedHashMap<>();
        initFuncs=new LinkedList<>();
    }
}
