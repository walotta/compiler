import AST.*;
import Frontend.ASTBuilder;
import Frontend.SymbolCollector;
import Parser.MxLexer;
import Parser.MxParser;
import Util.MxErrorListener;
import Util.error.error;
import Util.Scope.globalScope;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {

    public static void main(String[] args) throws Exception {
        boolean onlySemantic=false;
        boolean runSemantic=true;
        if(args.length!=0){
            for(String item:args){
                if(item.contains("-semantic=")){
                    String opt=item.substring(10);
                    System.err.println(opt);
                    if(opt.equals("skip")){
                        runSemantic=false;
                    }else if(opt.equals("only")){
                        runSemantic=true;
                        onlySemantic=true;
                    }
                }
            }
        }
        try {
            programNode ASTRoot;
            globalScope gScope = new globalScope();

            MxLexer lexer=new MxLexer(CharStreams.fromStream(System.in));
            lexer.removeErrorListeners();
            lexer.addErrorListener(new MxErrorListener());
            MxParser parser=new MxParser(new CommonTokenStream(lexer));
            parser.removeErrorListeners();
            parser.addErrorListener(new MxErrorListener());
            ParseTree parseTreeRoot = parser.program();
            ASTBuilder astBuilder = new ASTBuilder();
            ASTRoot=(programNode) astBuilder.visit(parseTreeRoot);

            if(runSemantic){
                //run semantic checker
                System.err.println("running semantic ...");
                new SymbolCollector(gScope).visit(ASTRoot);
            }
            if(onlySemantic)return;

            //run build program
            System.err.println("building codegen ...");
        }catch (error errorPoint) {
            System.err.println(errorPoint.toString());
            throw new RuntimeException();
        }
    }
}
