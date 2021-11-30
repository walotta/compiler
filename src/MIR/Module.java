package MIR;

import MIR.IRtype.*;
import MIR.Operand.globalVariable;
import Util.Scope.globalScope;
import Util.Type.*;
import Util.error.compilerError;
import Util.position;

import java.util.LinkedHashMap;

public class Module {
    public LinkedHashMap<String, Function> functions;
    public LinkedHashMap<String, globalVariable> globalVars;
    private final TransTypeToIR trans=new TransTypeToIR();

    private void FuncDecl(globalScope gScope){
        //todo
        gScope.funcs.forEach((funcName,func)->{
            Function funcIR=new Function(funcName,trans.transType(func.retType));
            funcIR.isBuiltin=func.builtin;
            functions.put(funcName,funcIR);
        });
    }

    public Module(globalScope gScope){
        functions=new LinkedHashMap<>();
        globalVars=new LinkedHashMap<>();
        FuncDecl(gScope);
    }
}
