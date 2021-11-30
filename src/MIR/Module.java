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

    private IRBaseType transType(Type t){
        //todo class Array
        IRBaseType irType;
        if(t instanceof funcType){
            throw new compilerError("wrong type trans",new position(0,0));
        }else if(t instanceof arrayType){
            //todo array
            irType=null;
        }else{
            //todo class
            switch (t.type){
                case Int->{irType=new IRIntType();}
                case Bool->{irType=new IRBoolType();}
                case String->{irType=new IRStringType();}
                case Void->{irType=new IRVoidType();}
                default -> {throw new compilerError("class type trans",new position(0,0));}
            }
        }
        return irType;
    }

    private void FuncDecl(globalScope gScope){
        //todo
        gScope.funcs.forEach((funcName,func)->{
            Function funcIR=new Function(funcName,transType(func.retType));
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
