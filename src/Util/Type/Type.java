package Util.Type;

import java.util.HashMap;

abstract public class Type {

    public enum types {Int, Bool, String, Void, Class, Null, Array, Func}
    public types type;
    public abstract int dim();
    public Type(Type.types type){
        this.type=type;
    }
    public Type(String typeNameString){
        switch (typeNameString){
            case"int"->this.type=types.Int;
            case"bool"->this.type=types.Bool;
            case"string"->this.type=types.String;
            case"void"->this.type=types.Void;
            case"null"->this.type=types.Null;
            default -> this.type=null;
        }
    }
}
