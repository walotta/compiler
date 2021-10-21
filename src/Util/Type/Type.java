package Util.Type;

import java.util.HashMap;

abstract public class Type {

    public enum types {Int, Bool, String, Void, Class, Null, Array, Func}
    private types type;
    public abstract int dim();
    public Type(Type.types type){
        this.type=type;
    }
}
