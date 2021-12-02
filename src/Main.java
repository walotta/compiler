import AST.*;
import MIR.IRBuilder;
import MIR.IRPrinter;
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

import java.io.FileInputStream;

public class Main {

    public static void main(String[] args) throws Exception {
        boolean onlySemantic=false;
        boolean printIR=false;
        String IRFileName="src.ll";
        if(args.length!=0){
            for(String item:args){
                if(item.equals("-semantic")){
                    onlySemantic=true;
                }else if(item.contains("-emit-llvm")){
                    printIR=true;
                    if(item.length()>10&&item.charAt(10)=='=')
                        IRFileName=item.substring(11);
                }
            }
        }

        var input=System.in;
        //var input=new FileInputStream("src.mx");

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
            Module module=new IRBuilder().run(ASTRoot,gScope);
            if(printIR)
                new IRPrinter(module,IRFileName);

            //run build program
            System.err.println("building codegen ...");
        }catch (error errorPoint) {
            System.err.println(errorPoint.toString());
            throw new RuntimeException();
        }
    }
}
