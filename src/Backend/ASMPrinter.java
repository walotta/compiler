package Backend;

import java.io.PrintStream;

public class ASMPrinter {
    PrintStream ps;
    String tab="\t";

    private void printHead(){
        ps.println(tab+".text");
        ps.println();
    }

    public ASMPrinter(PrintStream ps){
        this.ps=ps;
    }

    public void print(ASMModule asmModule){
        printHead();
        ps.println(asmModule);
    }
}
