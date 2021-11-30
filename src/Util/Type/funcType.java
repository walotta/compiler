package Util.Type;

import Util.Scope.funcScope;
import Util.position;
import Util.varEntity;

public class funcType extends Type{
    public String funcName;
    public funcScope scope;
    public Type retType;
    public boolean builtin;

    public funcType(String funcName){
        super(types.Func);
        this.funcName=funcName;
        builtin=false;
    }

    public void addParas(varEntity v, position pos){
        scope.addParas(v,pos);
    }

    @Override
    public int dim(){
        return 0;
    }

}
