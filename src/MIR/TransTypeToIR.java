package MIR;

import AST.typeNode;
import MIR.IRtype.*;
import Util.Type.Type;
import Util.Type.arrayType;
import Util.Type.classType;
import Util.Type.funcType;
import Util.error.compilerError;
import Util.position;

public class TransTypeToIR {

    public IRBaseType transType(Type t){
        IRBaseType irType;
        if(t instanceof funcType){
            throw new compilerError("wrong type trans",new position(0,0));
        }else if(t instanceof arrayType){
            irType=transType(((arrayType)t).arrayType);
            for(int i=0;i<((arrayType)t).dim;i++){
                irType=new IRPointerType(irType);
            }
        }else if(t instanceof classType && t.type== Type.types.Class){
            irType=new IRPointerType(new IRClassType(((classType)t).className));
        }else{
            switch (t.type){
                case Int -> irType=new IRIntType();
                case Bool -> irType=new IRBoolType();
                case String -> irType=new IRStringType();
                case Void -> irType=new IRVoidType();
                case Null -> irType=new IRPointerType(null);
                default -> throw new compilerError("type trans not find",new position(0,0));
            }
        }
        return irType;
    }

    public IRBaseType transType(typeNode t){
        String typeName=t.typeName;
        IRBaseType irType;
        if(t.dim==0){
            switch (typeName){
                case "int" -> irType=new IRIntType();
                case "bool" -> irType=new IRBoolType();
                case "string" -> irType=new IRStringType();
                case "void" -> irType=new IRVoidType();
                default -> irType=new IRPointerType(new IRClassType(typeName));
            }
        }else{
            irType=new IRPointerType(transType(new typeNode(t.pos,t.typeName,t.dim-1)));
        }
        return irType;
    }

}
