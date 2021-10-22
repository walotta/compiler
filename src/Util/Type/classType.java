package Util.Type;

import Util.Scope.Scope;
import Util.position;

public class classType extends Type{
    public Scope scope;
    public String className;

    public classType(String className){
        super(types.Class);
        this.className=className;
        scope=null;
    }

    public void defineFunc(String methodName, funcType f, position pos){
        scope.defineFunc(methodName,f,pos);
    }

    @Override
    public int dim(){
        return 0;
    }
}
