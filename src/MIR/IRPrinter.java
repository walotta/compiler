package MIR;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class IRPrinter {
    private void printHeader(PrintStream ps,String FileName){
        String declareText="""
        declare void @_glb_print(i8*)
        declare void @_glb_println(i8*)
        declare void @_glb_printInt(i32)
        declare void @_glb_printlnInt(i32)
        declare i8* @_glb_getString()
        declare i32 @_glb_getInt()
        declare i8* @_glb_toString(i32)
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
        ps.println(declareText);
        ps.println("@llvm.global_ctors = appending global [1 x { i32, void ()*, i8* }] [{ i32, void ()*, i8* } { i32 65535, void ()* @_GLOBAL_INIT, i8* null }]");
        ps.println();
    }

    private void printTail(PrintStream ps){
        ps.println();
    }

    private void printInitFunc(PrintStream ps, Module module){
        ps.println("; Function Attrs: noinline ssp uwtable");
        ps.println("define internal void @_GLOBAL_INIT(){");
        //todo
        ps.println("    ret void");
        ps.println("}");
        ps.println();
    }

    private void printModule(PrintStream ps,Module module){
        //todo print global
        //print func
        module.functions.forEach((funcName,funcIR)->{
            ps.println("; Function Attrs: noinline norecurse optnone ssp uwtable mustprogress");
            ps.println(funcIR);
            ps.println();
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
