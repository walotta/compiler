package MIR;

import MIR.IRtype.IRBaseType;
import MIR.IRtype.IRPointerType;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class IRPrinter {
    private void printHeader(PrintStream ps,String FileName){
        String declareText="""
        declare void @print(i8*)
        declare void @println(i8*)
        declare void @printInt(i32)
        declare void @printlnInt(i32)
        declare i8* @getString()
        declare i32 @getInt()
        declare i8* @toString(i32)
        declare i32 @_str_length(i8*)
        declare i8* @_str_substring(i8*,i32,i32)
        declare i8* @_str_addstring(i8*,i8*)
        declare i32 @_str_parseInt(i8*)
        declare i32 @_str_ord(i8*,i32)
        declare i1 @_str_eq(i8*,i8*)
        declare i1 @_str_ne(i8*,i8*)
        declare i1 @_str_lt(i8*,i8*)
        declare i1 @_str_le(i8*,i8*)
        declare i1 @_str_gt(i8*,i8*)
        declare i1 @_str_ge(i8*,i8*)
        """;
        ps.println("; llvm-link "+FileName+" bif/bif.ll -S -o link.ll");
        ps.println("target triple = \"x86_64-apple-macosx11.0.0\"");
        ps.println();
        ps.println(declareText);
        ps.println("@llvm.global_ctors = appending global [1 x { i32, void ()*, i8* }] [{ i32, void ()*, i8* } { i32 65535, void ()* @_GLOBAL_INIT, i8* null }]");
        ps.println();
    }

    private void printTail(PrintStream ps){
        ps.println();
    }

    private void printInitFunc(PrintStream ps, Module module){
        module.globalVars.forEach((varName,gVar)->{
            IRBaseType baseType=((IRPointerType)gVar.type).baseType;
            ps.println(gVar+" = global "+baseType+" "+(baseType.defaultValue()));
        });
        for(int i=0;i<module.initFuncs.size();i++){
            if(i!=module.initFuncs.size()-1)
                ps.println("; Function Attrs: noinline norecurse optnone ssp uwtable mustprogress");
            else
                ps.println("; Function Attrs: noinline ssp uwtable");
            ps.println(module.initFuncs.get(i));
            ps.println();
        }
    }

    private void printModule(PrintStream ps,Module module){
        //todo print global
        //print func
        module.functions.forEach((funcName,funcIR)->{
            if(!funcIR.isBuiltin){
                ps.println("; Function Attrs: noinline norecurse optnone ssp uwtable mustprogress");
                ps.println(funcIR);
                ps.println();
            }
        });
    }

    public IRPrinter(Module module, String FileName) throws FileNotFoundException {
        PrintStream ps=new PrintStream(FileName);
        printHeader(ps,FileName);
        printInitFunc(ps,module);
        printModule(ps,module);
        printTail(ps);
    }
}
