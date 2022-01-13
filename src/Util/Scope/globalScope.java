package Util.Scope;

import AST.typeNode;
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
        intType.isBuiltin=true;
        classes.put("int",intType);

        classType boolType=new classType("bool");
        boolType.type= Type.types.Bool;
        boolType.scope=new Scope(this);
        boolType.isBuiltin=true;
        classes.put("bool",boolType);

        classType stringType=new classType("string");
        stringType.type= Type.types.String;
        stringType.scope=new Scope(this);
        stringType.isBuiltin=true;
        classes.put("string",stringType);

        classType voidType=new classType("void");
        voidType.type= Type.types.Void;
        voidType.scope=new Scope(this);
        voidType.isBuiltin=true;
        classes.put("void",voidType);

        classType nullType=new classType("null");
        nullType.type= Type.types.Null;
        nullType.scope=new Scope(this);
        nullType.isBuiltin=true;
        classes.put("null",nullType);


        funcType buildInFunc;

        buildInFunc = new funcType("print");
        buildInFunc.builtin=true;
        buildInFunc.scope=new funcScope(this);
        buildInFunc.addParas(new varEntity("str", stringType, false), new position(0,0));
        buildInFunc.retType=voidType;
        defineFunc("print", buildInFunc, new position(0,0));

        buildInFunc = new funcType("println");
        buildInFunc.builtin=true;
        buildInFunc.scope=new funcScope(this);
        buildInFunc.addParas(new varEntity("str", stringType, false), new position(0,0));
        buildInFunc.retType=voidType;
        defineFunc("println", buildInFunc, new position(0,0));

        buildInFunc = new funcType("printInt");
        buildInFunc.builtin=true;
        buildInFunc.scope=new funcScope(this);
        buildInFunc.addParas(new varEntity("n", intType, false), new position(0,0));
        buildInFunc.retType=voidType;
        defineFunc("printInt", buildInFunc, new position(0,0));

        buildInFunc = new funcType("printlnInt");
        buildInFunc.builtin=true;
        buildInFunc.scope=new funcScope(this);
        buildInFunc.addParas(new varEntity("n", intType, false), new position(0,0));
        buildInFunc.retType=voidType;
        defineFunc("printlnInt", buildInFunc, new position(0,0));

        buildInFunc = new funcType("getString");
        buildInFunc.builtin=true;
        buildInFunc.scope=new funcScope(this);
        buildInFunc.retType=stringType;
        defineFunc("getString", buildInFunc, new position(0,0));

        buildInFunc = new funcType("getInt");
        buildInFunc.builtin=true;
        buildInFunc.scope=new funcScope(this);
        buildInFunc.retType=intType;
        defineFunc("getInt", buildInFunc, new position(0,0));

        buildInFunc = new funcType("toString");
        buildInFunc.builtin=true;
        buildInFunc.scope=new funcScope(this);
        buildInFunc.addParas(new varEntity("i", intType, false), new position(0,0));
        buildInFunc.retType=stringType;
        defineFunc("toString", buildInFunc, new position(0,0));

        buildInFunc = new funcType("size");
        buildInFunc.builtin=true;
        buildInFunc.scope=new funcScope(this);
        buildInFunc.retType=intType;
        defineFunc("size", buildInFunc, new position(0,0));

        buildInFunc = new funcType("length");
        buildInFunc.builtin=true;
        buildInFunc.scope=new funcScope(this);
        buildInFunc.retType=intType;
        stringType.defineFunc("length", buildInFunc, new position(0,0));

        buildInFunc = new funcType("substring");
        buildInFunc.builtin=true;
        buildInFunc.scope=new funcScope(this);
        buildInFunc.addParas(new varEntity("left", intType, false), new position(0,0));
        buildInFunc.addParas(new varEntity("right", intType, false), new position(0,0));
        buildInFunc.retType=stringType;
        stringType.defineFunc("substring", buildInFunc, new position(0,0));

        buildInFunc = new funcType("parseInt");
        buildInFunc.builtin=true;
        buildInFunc.scope=new funcScope(this);
        buildInFunc.retType=intType;
        stringType.defineFunc("parseInt", buildInFunc, new position(0,0));

        buildInFunc = new funcType("ord");
        buildInFunc.builtin=true;
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

    public Type generateType(typeNode node){
        Type tmp=getType(node.typeName);
        if(tmp==null)
            throw new semanticError("[globalScope][generate type]typeName not find",node.pos);
        if(node.dim!=0){
            return new arrayType(tmp,node.dim);
        }else{
            return tmp;
        }
    }

    public classType getType(String name){
        return classes.getOrDefault(name, null);
    }
}
