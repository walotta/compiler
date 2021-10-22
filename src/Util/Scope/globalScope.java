package Util.Scope;

import Util.Scope.Scope;
import Util.Type.*;
import Util.error.semanticError;
import Util.position;
import Util.varEntity;

import java.util.ArrayList;
import java.util.HashMap;

public class globalScope extends Scope {
    public HashMap<String, classType> classes=new HashMap<>();

    //内建类型都归类为class

    public globalScope(){
        super(null);

        classType intType=new classType("int");
        intType.type= Type.types.Int;
        intType.scope=new Scope(this);
        classes.put("int",intType);

        classType boolType=new classType("bool");
        boolType.type= Type.types.Bool;
        boolType.scope=new Scope(this);
        classes.put("bool",boolType);

        classType stringType=new classType("string");
        stringType.type= Type.types.String;
        stringType.scope=new Scope(this);
        classes.put("string",stringType);

        classType voidType=new classType("void");
        voidType.type= Type.types.Void;
        voidType.scope=new Scope(this);
        classes.put("void",voidType);

        classType nullType=new classType("null");
        nullType.type= Type.types.Null;
        nullType.scope=new Scope(this);
        classes.put("null",nullType);


        funcType buildInFunc;

        buildInFunc = new funcType("print");
        buildInFunc.scope=new funcScope(this);
        buildInFunc.addParas(new varEntity("str", stringType, false), new position(0,0));
        buildInFunc.retType=voidType;
        defineFunc("print", buildInFunc, new position(0,0));

        buildInFunc = new funcType("println");
        buildInFunc.scope=new funcScope(this);
        buildInFunc.addParas(new varEntity("str", stringType, false), new position(0,0));
        buildInFunc.retType=voidType;
        defineFunc("println", buildInFunc, new position(0,0));

        buildInFunc = new funcType("printInt");
        buildInFunc.scope=new funcScope(this);
        buildInFunc.addParas(new varEntity("n", intType, false), new position(0,0));
        buildInFunc.retType=voidType;
        defineFunc("printInt", buildInFunc, new position(0,0));

        buildInFunc = new funcType("printlnInt");
        buildInFunc.scope=new funcScope(this);
        buildInFunc.addParas(new varEntity("n", intType, false), new position(0,0));
        buildInFunc.retType=voidType;
        defineFunc("printlnInt", buildInFunc, new position(0,0));

        buildInFunc = new funcType("getString");
        buildInFunc.scope=new funcScope(this);
        buildInFunc.retType=stringType;
        defineFunc("getString", buildInFunc, new position(0,0));

        buildInFunc = new funcType("getInt");
        buildInFunc.scope=new funcScope(this);
        buildInFunc.retType=intType;
        defineFunc("getInt", buildInFunc, new position(0,0));

        buildInFunc = new funcType("toString");
        buildInFunc.scope=new funcScope(this);
        buildInFunc.addParas(new varEntity("i", intType, false), new position(0,0));
        buildInFunc.retType=stringType;
        defineFunc("toString", buildInFunc, new position(0,0));

        buildInFunc = new funcType("size");
        buildInFunc.scope=new funcScope(this);
        buildInFunc.retType=intType;
        defineFunc("size", buildInFunc, new position(0,0));

        buildInFunc = new funcType("length");
        buildInFunc.scope=new funcScope(this);
        buildInFunc.retType=intType;
        stringType.defineFunc("length", buildInFunc, new position(0,0));

        buildInFunc = new funcType("substring");
        buildInFunc.scope=new funcScope(this);
        buildInFunc.addParas(new varEntity("left", intType, false), new position(0,0));
        buildInFunc.addParas(new varEntity("right", intType, false), new position(0,0));
        buildInFunc.retType=stringType;
        stringType.defineFunc("substring", buildInFunc, new position(0,0));

        buildInFunc = new funcType("parseInt");
        buildInFunc.scope=new funcScope(this);
        buildInFunc.retType=intType;
        stringType.defineFunc("parseInt", buildInFunc, new position(0,0));

        buildInFunc = new funcType("ord");
        buildInFunc.scope=new funcScope(this);
        buildInFunc.addParas(new varEntity("pos", intType, false), new position(0,0));
        buildInFunc.retType=intType;
        stringType.defineFunc("ord", buildInFunc, new position(0,0));
    }

    public void defineClass(String name,classType c,position pos){
        if(classes.containsKey(name))
            throw new semanticError("[global scope][define class] the same className or the className is buildIn type name",pos);
        else{
            classes.put(name,c);
        }
    }

    public Type getType(String name){
        return classes.getOrDefault(name, null);
    }
}
