package Util.Type;

import Util.Scope.FuncScope;

public class funcType extends Type{
    public String funcName;
    public FuncScope scope;
    public Type retType;

    public funcType(String funcName){
        super(types.Func);
        this.funcName=funcName;
    }

    @Override
    public int dim(){
        return 0;
    }

}
