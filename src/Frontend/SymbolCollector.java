package Frontend;

import AST.*;
import Util.Scope.Scope;
import Util.Scope.funcScope;
import Util.Scope.globalScope;
import Util.Type.classType;
import Util.Type.funcType;
import Util.error.semanticError;

public class SymbolCollector implements ASTVisitor {
    private globalScope gScope;
    private Scope currentScope = null;

    public SymbolCollector(globalScope gScope) {
        this.gScope = gScope;
    }

    @Override
    public void visit(programNode it) {

        currentScope=gScope;
        it.programBlockList.forEach(item->item.accept(this));
    }

    @Override
    public void visit(funcBlockNode it) {

        funcType func=new funcType(it.funcName);
        if(gScope==currentScope && gScope.getType(it.funcName)!=null){
            throw new semanticError("[symbolCollector][function declare] same funcName",it.pos);
        }else{
            it.func=func;
            currentScope.defineFunc(it.funcName,func,it.pos);
        }
    }

    @Override
    public void visit(classBlockNode it) {

        if(currentScope!=gScope)
            throw new semanticError("[symbolCollector][class declare] cannot declare class nested",it.pos);
        classType cl=new classType(it.className);
        currentScope=new Scope(currentScope);
        it.funcList.forEach(item->item.accept(this));
        it.buildFuncList.forEach(item->item.accept(this));
        cl.scope=currentScope;
        currentScope=currentScope.parentScope;
        if(gScope.getType(it.className)!=null)
            throw new semanticError("[symbolCollector][class declare] same className with other class",it.pos);
        if(gScope.getFunc(it.className,false)!=null)
            throw new semanticError("[symbolCollector][class declare] same className with function",it.pos);

        gScope.defineClass(it.className,cl,it.pos);
    }

    @Override
    public void visit(singleVarBlockNode it) {}

    @Override
    public void visit(varBlockNode it) {}

    @Override
    public void visit(statementBlockNode it) {}

    @Override
    public void visit(breakNode it) {}

    @Override
    public void visit(continueNode it) {}

    @Override
    public void visit(exprStatementNode it) {}

    @Override
    public void visit(forNode it) {}

    @Override
    public void visit(ifNode it) {}

    @Override
    public void visit(retNode it) {}

    @Override
    public void visit(whileNode it) {}

    @Override
    public void visit(emptyStatementNode it) {}

    @Override
    public void visit(binaryExprNode it) {}

    @Override
    public void visit(unaryExprNode it) {}

    @Override
    public void visit(newArrayExprNode it) {}

    @Override
    public void visit(newInitObjectExprNode it) {}

    @Override
    public void visit(newObjectExprNode it) {}

    @Override
    public void visit(postfixExprNode it) {}

    @Override
    public void visit(funcCallExprNode it) {}

    @Override
    public void visit(assignExprNode it) {}

    @Override
    public void visit(classMemberExprNode it) {}

    @Override
    public void visit(arrayMemberExprNode it) {}

    @Override
    public void visit(thisExprNode it) {}

    @Override
    public void visit(intConstNode it) {}

    @Override
    public void visit(boolConstNode it) {}

    @Override
    public void visit(nullConstNode it) {}

    @Override
    public void visit(stringConstNode it) {}

    @Override
    public void visit(singleTypeNode it) {}

    @Override
    public void visit(typeNode it) {}

    @Override
    public void visit(varNode it) {}

    @Override
    public void visit(funcNode it) {}

    @Override
    public void visit(methodNode it) {}

    @Override
    public void visit(lambdaExprNode it) {}

    @Override
    public void visit(buildFuncBlockNode it) {
        funcType func=new funcType(it.funcName);
        func.scope=new funcScope(currentScope);
        it.func=func;
        currentScope.defineFunc(it.funcName,func,it.pos);
    }

}