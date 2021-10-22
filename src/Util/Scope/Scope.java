package Util.Scope;

import Util.Type.Type;
import Util.Type.funcType;
import Util.error.semanticError;
import Util.position;
import Util.varEntity;

import java.util.HashMap;

public class Scope {

    public HashMap<String, varEntity> vars=new HashMap<>();
    public HashMap<String, funcType>funcs=new HashMap<>();
    public Scope parentScope;

    public Scope(Scope parentScope){
        this.parentScope=parentScope;
    }

    public void defineVar(String name, varEntity v, position pos){
        if(vars.containsKey(name))
            throw new semanticError("[scope][define var] same varName",pos);
        else
            vars.put(name,v);
    }

    public varEntity getVar(String name,boolean checkParent){
        if(vars.containsKey(name))return vars.get(name);
        else if(checkParent && parentScope!=null)
            return parentScope.getVar(name,true);
        else return null;
    }

    public void defineFunc(String name,funcType f,position pos){
        if(funcs.containsKey(name))
            throw new semanticError("[scope][define func] same funcName",pos);
        else
            funcs.put(name,f);
    }

    public funcType getFunc(String name,boolean checkParent){
        if(funcs.containsKey(name))return funcs.get(name);
        else if(checkParent && parentScope!=null)
            return parentScope.getFunc(name,true);
        else return null;
    }

}
