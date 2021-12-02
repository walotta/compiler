package MIR;

import AST.typeNode;
import MIR.IRtype.*;
import Util.Type.Type;
import Util.Type.arrayType;
import Util.Type.funcType;
import Util.error.compilerError;
import Util.position;

public class TransTypeToIR {

    public IRBaseType transType(Type t){
        //todo class Array
        IRBaseType irType;
        if(t instanceof funcType){
            throw new compilerError("wrong type trans",new position(0,0));
        }else if(t instanceof arrayType){
            //todo array
            irType=null;
        }else{
            //todo class
            switch (t.type){
                case Int->{irType=new IRIntType();}
                case Bool->{irType=new IRBoolType();}
                case String->{irType=new IRStringType();}
                case Void->{irType=new IRVoidType();}
                default -> {throw new compilerError("class type trans",new position(0,0));}
            }
        }
        return irType;
    }

    public IRBaseType transType(typeNode t){
        //todo class
        String typeName=t.typeName;
        IRBaseType irType;
        if(t.dim==0){
            switch (typeName){
                case "int"->{irType=new IRIntType();}
                case "bool"->{irType=new IRBoolType();}
                case "string"->{irType=new IRStringType();}
                case "void"->{irType=new IRVoidType();}
                default -> {throw new compilerError("class type trans",t.pos);}
            }
        }else{
            irType=new IRPointerType(transType(new typeNode(t.pos,t.typeName,t.dim-1)));
        }
        return irType;
    }

}