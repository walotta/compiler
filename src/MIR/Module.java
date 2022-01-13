package MIR;

import MIR.IRtype.*;
import MIR.Operand.StringConstant;
import MIR.Operand.globalVariable;
import Util.Scope.globalScope;
import Util.Type.*;
import Util.error.compilerError;
import Util.position;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Module {
    public LinkedHashMap<String, Function> functions;
    public LinkedHashMap<String, ClassUnit> classes;
    public LinkedHashMap<String, globalVariable> globalVars;
    public LinkedHashMap<String, StringConstant> stringConstTable;
    public LinkedList<Function> initFuncs;

    public Module(){
        functions=new LinkedHashMap<>();
        classes=new LinkedHashMap<>();
        globalVars=new LinkedHashMap<>();
        initFuncs=new LinkedList<>();
        stringConstTable=new LinkedHashMap<>();
    }

    public IRPointerType queryClassPointer(String name){
        if(classes.containsKey(name)){
            IRClassType queryClassType=new IRClassType(name);
            queryClassType.calSize(classes.get(name));
            return new IRPointerType(queryClassType);
        }else
            throw new compilerError("class name not find",new position(0,0));
    }

    public void accept(IRVisitor visitor){
        visitor.visit(this);
    }
}
