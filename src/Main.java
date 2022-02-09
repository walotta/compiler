import AST.*;
import Backend.ASMModule;
import Backend.ASMPrinter;
import Backend.InstSelect;
import Backend.RegisterAllocation.interferenceGraph.graph.graphBase;
import Backend.RegisterAllocation.interferenceGraph.interferenceGraphBuilder;
import Backend.RegisterAllocation.livenessAnalysis;
import Backend.RegisterAllocation.preProcess;
import Backend.RegisterAllocation.simpleRegDist;
import MIR.IRBuilder;
import MIR.IRForwarder;
import MIR.IRPrinter;
import MIR.IRtype.IRBaseType;
import MIR.Module;
import Frontend.ASTBuilder;
import Frontend.SemanticChecker;
import Frontend.SymbolCollector;
import Frontend.TypeFilter;
import Parser.MxLexer;
import Parser.MxParser;
import Util.MxErrorListener;
import Util.error.error;
import Util.Scope.globalScope;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.PrintStream;

public class Main {

    public static void main(String[] args) throws Exception {
        boolean onlySemantic=false;
        boolean printIR=false;
        int pointSize=4;
        String IRFileName="src.ll";
        String ASMFileName="src.s";
        boolean toFile=false;
        boolean noOpt=false;

        var input=System.in;
        var output=System.out;
        if(args.length!=0){
            for(String item:args){
                if(item.equals("-semantic")){
                    onlySemantic=true;
                }else if(item.contains("-emit-llvm")){
                    pointSize=8;
                    printIR=true;
                    if(item.length()>10&&item.charAt(10)=='=')
                        IRFileName=item.substring(11);
                }else if(item.contains("-file")){
                    toFile=true;
                }else if(item.contains("-O0")){
                    noOpt=true;
                }
            }
        }
        if(toFile){
            if(printIR)
                output=new PrintStream(IRFileName);
            else
                output=new PrintStream(ASMFileName);
        }

        try {
            programNode ASTRoot;
            globalScope gScope = new globalScope();

            //antlr analyze
            MxLexer lexer=new MxLexer(CharStreams.fromStream(input));
            lexer.removeErrorListeners();
            lexer.addErrorListener(new MxErrorListener());
            MxParser parser=new MxParser(new CommonTokenStream(lexer));
            parser.removeErrorListeners();
            parser.addErrorListener(new MxErrorListener());
            ParseTree parseTreeRoot = parser.program();

            //build ast
            ASTBuilder astBuilder = new ASTBuilder();
            ASTRoot=(programNode) astBuilder.visit(parseTreeRoot);

            //run semantic checker
            new SymbolCollector(gScope).visit(ASTRoot);
            new TypeFilter(gScope).visit(ASTRoot);
            new SemanticChecker(gScope).visit(ASTRoot);
            if(onlySemantic)return;

            //run IRBuilder
            IRBaseType.pointSize=pointSize;
            Module module=new IRBuilder().run(ASTRoot,gScope);
            module=new IRForwarder(module).forward();
            if(printIR) {
                new IRPrinter(module, output);
                return;
            }
            ASMModule asmModule=new InstSelect().run(module);
            if(noOpt)
                asmModule=new simpleRegDist(asmModule).run();
            else{
                asmModule=new preProcess(asmModule).run();
                asmModule=new livenessAnalysis(asmModule).run();
                graphBase interGraph=new interferenceGraphBuilder().run(asmModule);

            }
            new ASMPrinter(output).print(asmModule);

            //run build program
            System.err.println("compile finish");
        }catch (error errorPoint) {
            System.err.println(errorPoint.toString());
            throw new RuntimeException();
        }
    }
}
