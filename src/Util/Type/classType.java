package Util.Type;

import Util.Scope.Scope;

public class classType extends Type{
    public Scope scope;
    public String className;

    public classType(String className){
        super(types.Class);
        this.className=className;
    }

    @Override
    public int dim(){
        return 0;
    }
}
