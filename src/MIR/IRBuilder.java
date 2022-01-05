package MIR;

import AST.*;
import MIR.IRInstruction.*;
import MIR.IRScope.IRScopeBase;
import MIR.IRScope.IRScopeFunc;
import MIR.IRScope.IRScopeGlobal;
import MIR.IRtype.*;
import MIR.Operand.*;
import Util.Scope.globalScope;
import Util.error.compilerError;
import Util.position;

import java.util.*;

public class IRBuilder implements ASTVisitor {
    private final Module module;
    private IRScopeBase currentScope;
    private BasicBlock currentBlock;
    private Function currentFunc;
    private IROperand calBack;
    private final IRCounter IRCounter;
    private final TransTypeToIR trans=new TransTypeToIR();
    private final position throwPos=new position(0,0);
    private boolean getLeftPointer=false;
    private final Stack<Label> continueStack;
    private final Stack<Label> breakStack;
    private final LinkedHashMap<globalVariable,exprNode>toInit=new LinkedHashMap<>();

    public IRBuilder(){
        module=new Module();
        currentScope=null;
        calBack=null;
        IRCounter =new IRCounter();
        continueStack=new Stack<>();
        breakStack=new Stack<>();
    }

    public Module run(programNode it,globalScope gScope){
        GlobalDecl(gScope);
        it.accept(this);
        return module;
    }

    private void GlobalDecl(globalScope gScope){
        //func
        gScope.funcs.forEach((funcName,func)->{
            Function funcIR=new Function(funcName,trans.transType(func.retType));
            funcIR.isBuiltin=func.builtin;
            module.functions.put(funcName,funcIR);
        });

        //var
        gScope.vars.forEach((varName,varE)->{
            globalVariable variable=new globalVariable(varE.name,new IRPointerType(trans.transType(varE.type)));
            toInit.put(variable,varE.initExpr);
            module.globalVars.put(varName,variable);
        });

        //todo class
    }

    private void buildInitFunc(){
        //gen initFunc
        toInit.forEach((varE,iniNode)->{
            if(iniNode!=null){
                currentFunc=new Function("initForGlobalVar."+module.initFuncs.size(),new IRVoidType());
                currentScope=new IRScopeFunc(currentScope);
                currentBlock=new BasicBlock(new Label(currentScope.regCnt()));
                currentFunc.buildInit((IRScopeFunc)currentScope,currentBlock);
                iniNode.accept(this);
                currentBlock.pushInstruction(new storeInst(calBack,varE));
                if(currentBlock.canInsert())
                    currentBlock.pushInstruction(currentFunc.jumpToRet());
                currentFunc.Blocks.add(currentBlock);
                currentBlock=currentFunc.genRetBlock(currentScope);
                currentFunc.Blocks.add(currentBlock);
                module.initFuncs.add(currentFunc);
                currentBlock=null;
                currentFunc=null;
                currentScope=currentScope.parentsScope;
            }
        });

        //gen head initFunc
        Function allInitFunc=new Function("_GLOBAL_INIT",new IRVoidType());
        allInitFunc.ExtendMsg="internal";
        BasicBlock initBlock=new BasicBlock(new Label("init"));
        module.initFuncs.forEach(f-> initBlock.pushInstruction(new callInst(f,null,new ArrayList<>())));
        initBlock.pushInstruction(new retInst(null));
        allInitFunc.Blocks.add(initBlock);
        module.initFuncs.add(allInitFunc);
    }

    private void mallocArray(IRBaseType targetType,IROperand sizeOperand){
        //cal malloc size
        Register sizeCal=new Register(currentScope.regCnt(),null,new IRIntType());
        currentBlock.pushInstruction(new binaryInst(binaryInst.binaryType.mul,sizeOperand,new IntConstant(targetType.size()),sizeCal));
        Register sizeCalFinal=new Register(currentScope.regCnt(),null,new IRIntType());
        currentBlock.pushInstruction(new binaryInst(binaryInst.binaryType.add,sizeCal,new IntConstant((new IRIntType()).size()),sizeCalFinal));

        //call malloc
        Register mallocHeader=new Register(currentScope.regCnt(),null,new IRPointerType(new IRCharType()));
        Function func=new Function("_bif_malloc",new IRPointerType(new IRCharType()));
        currentBlock.pushInstruction(new callInst(func,mallocHeader,new ArrayList<>(){{add(sizeCalFinal);}}));

        //store len
        Register lenHeader=new Register(currentScope.regCnt(),null,new IRPointerType(new IRIntType()));
        currentBlock.pushInstruction(new bitcastInst(mallocHeader,lenHeader));
        currentBlock.pushInstruction(new storeInst(sizeOperand,lenHeader));

        //return header
        Register trueHead=new Register(currentScope.regCnt(),null,mallocHeader.type);
        currentBlock.pushInstruction(new getElementInst(trueHead,mallocHeader,new IntConstant((new IRIntType()).size())));
        Register header=new Register(currentScope.regCnt(),null,targetType);
        currentBlock.pushInstruction(new bitcastInst(trueHead,header));
        calBack=header;
    }

    private void genArray(IRBaseType targetType,ArrayList<IROperand> sizeExpr){
        if(sizeExpr.size()==1){
            mallocArray(targetType,sizeExpr.get(0));
        }else{
            //todo
            //multi-array
            IROperand currentArrayCnt=sizeExpr.get(0);
            sizeExpr.remove(0);
            mallocArray(targetType,currentArrayCnt);
            Register currentArrayHead=(Register) calBack;
            Register memberCounter=new Register(currentScope.regCnt(),null,currentArrayCnt.type);
            currentBlock.pushInstruction(new binaryInst(binaryInst.binaryType.sub,currentArrayCnt,new IntConstant(1),memberCounter));
            Register memberCounterPointer=new Register(currentScope.regCnt(),null,new IRPointerType(currentArrayCnt.type));
            currentBlock.pushInstruction(new allocaInst(memberCounterPointer));
            currentBlock.pushInstruction(new storeInst(memberCounter,memberCounterPointer));
            int LabelId=IRCounter.getLabelCnt();
            Label ArraySub=new Label("ArraySub."+LabelId);
            Label ArrayAfter=new Label("ArrayAfter."+LabelId);
            Label ArrayCond=new Label("ArrayCond."+LabelId);

            currentBlock.pushInstruction(new jumpInst(ArrayCond));
            currentFunc.Blocks.add(currentBlock);
            //cond
            currentBlock=new BasicBlock(ArrayCond);
            memberCounter=new Register(currentScope.regCnt(),null,((IRPointerType)memberCounterPointer.type).baseType);
            currentBlock.pushInstruction(new loadInst(memberCounter,memberCounterPointer));
            Register isZero=new Register(currentScope.regCnt(),null,new IRBoolType());
            currentBlock.pushInstruction(new compareInst(compareInst.compareType.sge,memberCounter,new IntConstant(0),isZero));
            currentBlock.pushInstruction(new brInst(isZero,ArraySub,ArrayAfter));
            currentFunc.Blocks.add(currentBlock);
            //ArraySub
            currentBlock=new BasicBlock(ArraySub);
            memberCounter=new Register(currentScope.regCnt(),null,((IRPointerType)memberCounterPointer.type).baseType);
            currentBlock.pushInstruction(new loadInst(memberCounter,memberCounterPointer));
            Register subArrayHeader=new Register(currentScope.regCnt(),null,currentArrayHead.type);
            currentBlock.pushInstruction(new getElementInst(subArrayHeader,currentArrayHead,memberCounter));
            genArray(((IRPointerType)targetType).baseType,sizeExpr);
            currentBlock.pushInstruction(new storeInst(calBack,subArrayHeader));
            memberCounter=new Register(currentScope.regCnt(),null,((IRPointerType)memberCounterPointer.type).baseType);
            Register memberCounterSub=new Register(currentScope.regCnt(),null,((IRPointerType)memberCounterPointer.type).baseType);
            currentBlock.pushInstruction(new loadInst(memberCounter,memberCounterPointer));
            currentBlock.pushInstruction(new binaryInst(binaryInst.binaryType.sub,memberCounter,new IntConstant(1),memberCounterSub));
            currentBlock.pushInstruction(new storeInst(memberCounterSub,memberCounterPointer));
            currentBlock.pushInstruction(new jumpInst(ArrayCond));
            currentFunc.Blocks.add(currentBlock);
            //ArrayAfter
            currentBlock=new BasicBlock(ArrayAfter);
            calBack=currentArrayHead;
        }
    }

    @Override
    public void visit(programNode it){
        currentScope=new IRScopeGlobal(currentScope);

        ((IRScopeGlobal)currentScope).insertGlobalVar(module.globalVars);
        buildInitFunc();

        it.programBlockList.forEach(item->{
            if(item instanceof funcBlockNode || item instanceof classBlockNode)
            item.accept(this);
        });
    }

    @Override
    public void visit(funcBlockNode it){
        currentScope=new IRScopeFunc(currentScope);
        currentFunc=module.functions.get(it.funcName);
        for(int i=0;i<it.paras.size();i++){
            currentFunc.paras.add(new Register(currentScope.regCnt(),it.paras.get(i).VarName,trans.transType(it.paras.get(i).type)));
        }
        currentBlock=new BasicBlock(new Label(currentScope.regCnt()));
        currentFunc.buildInit((IRScopeFunc)currentScope,currentBlock);
        visit(it.funcStatementLists);
        if(currentBlock.canInsert())
            currentBlock.pushInstruction(currentFunc.jumpToRet());
        currentFunc.Blocks.add(currentBlock);
        currentBlock=currentFunc.genRetBlock(currentScope);
        currentFunc.Blocks.add(currentBlock);
        module.functions.put(it.funcName,currentFunc);
        currentBlock=null;
        currentFunc=null;
        currentScope=currentScope.parentsScope;
    }

    @Override
    public void visit(classBlockNode it){
        //todo
    }

    @Override
    public void visit(buildFuncBlockNode it){
        //todo
    }

    @Override
    public void visit(singleVarBlockNode it){
        if(it.expr==null)
            calBack=null;
        else
            it.expr.accept(this);
        IRBaseType irType=trans.transType(it.type);
        Register reg=new Register(currentScope.regCnt(),it.VarName,new IRPointerType(irType));
        currentScope.renameTable.put(it.VarName,reg);
        currentBlock.pushInstruction(new allocaInst(reg));
        if(calBack==null)
            currentBlock.pushInstruction(new storeInst(irType.defaultValue(),reg));
        else
            currentBlock.pushInstruction(new storeInst(calBack,reg));
    }

    @Override
    public void visit(varBlockNode it){
        it.varList.forEach(v->
                v.accept(this));
    }

    @Override
    public void visit(statementBlockNode it){
        currentScope=new IRScopeBase(currentScope);

        it.statementList.forEach(item-> {
            if(currentBlock.canInsert())
                item.accept(this);
        });

        currentScope.parentsScope.copyCnt(currentScope);
        currentScope=currentScope.parentsScope;
    }

    @Override
    public void visit(breakNode it){
        currentBlock.pushInstruction(new jumpInst(breakStack.peek()));
    }

    @Override
    public void visit(continueNode it){
        currentBlock.pushInstruction(new jumpInst(continueStack.peek()));
    }

    @Override
    public void visit(exprStatementNode it){
        it.expr.accept(this);
    }

    @Override
    public void visit(forNode it){
        currentScope=new IRScopeBase(currentScope);

        if(it.initExp!=null)
            it.initExp.accept(this);

        int forId= IRCounter.getLabelCnt();
        Label forCheckLabel=new Label("forCheck."+forId);
        Label forStepLabel=new Label("forStep."+forId);
        Label forRunLabel=new Label("forRun."+forId);
        Label forNextLabel=new Label("forNext."+forId);
        currentBlock.pushInstruction(new jumpInst(forCheckLabel));
        currentFunc.Blocks.add(currentBlock);

        currentBlock=new BasicBlock(forCheckLabel);
        if(it.finishExp!=null) {
            it.finishExp.accept(this);
            IROperand cond=calBack;
            currentBlock.pushInstruction(new brInst(cond,forRunLabel,forNextLabel));
        }else{
            currentBlock.pushInstruction(new jumpInst(forRunLabel));
        }
        currentFunc.Blocks.add(currentBlock);

        currentBlock=new BasicBlock(forRunLabel);
        continueStack.push(forStepLabel);
        breakStack.push(forNextLabel);
        if(it.runStatement!=null)
            it.runStatement.accept(this);
        continueStack.pop();
        breakStack.pop();
        if(currentBlock.canInsert())
            currentBlock.pushInstruction(new jumpInst(forStepLabel));
        currentFunc.Blocks.add(currentBlock);

        currentBlock=new BasicBlock(forStepLabel);
        if(it.stepExp!=null)
            it.stepExp.accept(this);
        currentBlock.pushInstruction(new jumpInst(forCheckLabel));
        currentFunc.Blocks.add(currentBlock);

        currentBlock=new BasicBlock(forNextLabel);

        currentScope.parentsScope.copyCnt(currentScope);
        currentScope=currentScope.parentsScope;
    }

    @Override
    public void visit(ifNode it){
        it.condition.accept(this);
        int ifId= IRCounter.getLabelCnt();
        Label trueLabel=new Label("ifTrueBlock."+ifId);
        Label finalLabel=new Label("ifNextBlock."+ifId);
        Label falseLabel=finalLabel;
        if(it.falseStatement!=null){
            falseLabel=new Label("ifFalseBlock."+ifId);
        }
        currentBlock.pushInstruction(new brInst(calBack,trueLabel,falseLabel));
        currentFunc.Blocks.add(currentBlock);

        //gen True Block
        currentBlock=new BasicBlock(trueLabel);
        currentScope=new IRScopeBase(currentScope);
        it.trueStatement.accept(this);
        currentScope.parentsScope.copyCnt(currentScope);
        currentScope=currentScope.parentsScope;
        if(currentBlock.canInsert())
            currentBlock.pushInstruction(new jumpInst(finalLabel));
        currentFunc.Blocks.add(currentBlock);

        //gen False Block
        if(it.falseStatement!=null){
            currentBlock=new BasicBlock(falseLabel);
            currentScope=new IRScopeBase(currentScope);
            it.falseStatement.accept(this);
            if(currentBlock.canInsert())
                currentBlock.pushInstruction(new jumpInst(finalLabel));
            currentFunc.Blocks.add(currentBlock);
            currentScope.parentsScope.copyCnt(currentScope);
            currentScope=currentScope.parentsScope;
        }

        //gen Next Block
        currentBlock=new BasicBlock(finalLabel);
    }

    @Override
    public void visit(retNode it){
        if(it.returnExp!=null){
            it.returnExp.accept(this);
            currentBlock.pushInstruction(new storeInst(calBack,currentFunc.retReg));
        }
        currentBlock.pushInstruction(currentFunc.jumpToRet());
    }

    @Override
    public void visit(whileNode it){
        currentScope=new IRScopeBase(currentScope);

        int whileId= IRCounter.getLabelCnt();
        Label whileCheckLabel=new Label("whileCheck."+whileId);
        Label whileRunLabel=new Label("whileRun."+whileId);
        Label whileNextLabel=new Label("whileNext."+whileId);
        currentBlock.pushInstruction(new jumpInst(whileCheckLabel));
        currentFunc.Blocks.add(currentBlock);

        currentBlock=new BasicBlock(whileCheckLabel);
        it.finishExp.accept(this);
        IROperand cond=calBack;
        currentBlock.pushInstruction(new brInst(cond,whileRunLabel,whileNextLabel));
        currentFunc.Blocks.add(currentBlock);

        currentBlock=new BasicBlock(whileRunLabel);
        continueStack.push(whileCheckLabel);
        breakStack.push(whileNextLabel);
        it.runStatement.accept(this);
        breakStack.pop();
        continueStack.pop();
        if(currentBlock.canInsert())
            currentBlock.pushInstruction(new jumpInst(whileCheckLabel));
        currentFunc.Blocks.add(currentBlock);

        currentBlock=new BasicBlock(whileNextLabel);

        currentScope.parentsScope.copyCnt(currentScope);
        currentScope=currentScope.parentsScope;
    }

    @Override
    public void visit(emptyStatementNode it){}

    @Override
    public void visit(binaryExprNode it){
        IRBaseType irType=trans.transType(it.type);
        IRBaseType calType=trans.transType(it.leftExp.type);
        IROperand left,right;
        it.leftExp.accept(this);
        left=calBack;
        it.rightExp.accept(this);
        right=calBack;
        Instruction inst;
        Register target=new Register(currentScope.regCnt(),null,irType);
        if(calType instanceof IRIntType){
            switch (it.op){
                case mul -> inst=new binaryInst(binaryInst.binaryType.mul,left,right,target);
                case div -> inst=new binaryInst(binaryInst.binaryType.sdiv,left,right,target);
                case mod -> inst=new binaryInst(binaryInst.binaryType.srem,left,right,target);
                case add -> inst=new binaryInst(binaryInst.binaryType.add,left,right,target);
                case sub -> inst=new binaryInst(binaryInst.binaryType.sub,left,right,target);
                case bitLeft -> inst=new binaryInst(binaryInst.binaryType.shl,left,right,target);
                case bitRight -> inst=new binaryInst(binaryInst.binaryType.ashr,left,right,target);
                case smallThan -> inst=new compareInst(compareInst.compareType.slt,left,right,target);
                case bigThan -> inst=new compareInst(compareInst.compareType.sgt,left,right,target);
                case smallEqual -> inst=new compareInst(compareInst.compareType.sle,left,right,target);
                case bigEqual -> inst=new compareInst(compareInst.compareType.sge,left,right,target);
                case isEqual -> inst=new compareInst(compareInst.compareType.eq,left,right,target);
                case isNotEqual -> inst=new compareInst(compareInst.compareType.ne,left,right,target);
                case bitAnd -> inst=new binaryInst(binaryInst.binaryType.and,left,right,target);
                case bitXor -> inst=new binaryInst(binaryInst.binaryType.xor,left,right,target);
                case bitOr -> inst=new binaryInst(binaryInst.binaryType.or,left,right,target);
                default -> throw new compilerError("forbidden binary for int",throwPos);
            }
        }else if(calType instanceof IRBoolType){
            switch (it.op){
                case isEqual -> inst=new compareInst(compareInst.compareType.eq,left,right,target);
                case isNotEqual -> inst=new compareInst(compareInst.compareType.ne,left,right,target);
                case bitAnd -> inst=new binaryInst(binaryInst.binaryType.and,left,right,target);
                case bitXor -> inst=new binaryInst(binaryInst.binaryType.xor,left,right,target);
                case bitOr -> inst=new binaryInst(binaryInst.binaryType.or,left,right,target);
                case logicAnd -> //todo short circuit
                        inst=new binaryInst(binaryInst.binaryType.and,left,right,target);
                case logicOr -> //todo short circuit
                        inst=new binaryInst(binaryInst.binaryType.or,left,right,target);
                default -> throw new compilerError("forbidden binary for bool",throwPos);
            }
        }else if(calType instanceof IRStringType){
            switch (it.op){
                case add -> {
                    Function func=new Function("_str_addstring",new IRStringType());
                    inst = new callInst(func,target,new ArrayList<>(Arrays.asList(left, right)));
                }
                case smallThan -> {
                    Function func=new Function("_str_lt",new IRBoolType());
                    inst = new callInst(func,target,new ArrayList<>(Arrays.asList(left, right)));
                }
                case bigThan -> {
                    Function func=new Function("_str_gt",new IRBoolType());
                    inst = new callInst(func,target,new ArrayList<>(Arrays.asList(left, right)));
                }
                case smallEqual -> {
                    Function func=new Function("_str_le",new IRBoolType());
                    inst = new callInst(func,target,new ArrayList<>(Arrays.asList(left, right)));
                }
                case bigEqual -> {
                    Function func=new Function("_str_ge",new IRBoolType());
                    inst = new callInst(func,target,new ArrayList<>(Arrays.asList(left, right)));
                }
                case isEqual -> {
                    Function func=new Function("_str_eq",new IRBoolType());
                    inst = new callInst(func,target,new ArrayList<>(Arrays.asList(left, right)));
                }
                case isNotEqual -> {
                    Function func=new Function("_str_ne",new IRBoolType());
                    inst = new callInst(func,target,new ArrayList<>(Arrays.asList(left, right)));
                }
                default -> throw new compilerError("forbidden binary for string",throwPos);
            }
        }else if(calType instanceof IRClassType){
            //todo
            throw new compilerError("binary Class todo",throwPos);
        }else{
            throw new compilerError("binary for forbidden type",throwPos);
        }
        calBack=target;
        currentBlock.pushInstruction(inst);
    }

    @Override
    public void visit(unaryExprNode it){
        Register source;
        IROperand val;
        boolean queryLeft=getLeftPointer;
        if(it.op== unaryExprNode.opType.selfAdd || it.op== unaryExprNode.opType.selfSub){
            getLeftPointer=true;
            it.calExp.accept(this);
            getLeftPointer=queryLeft;
            source=(Register) calBack;
            val=new Register(currentScope.regCnt(),null,trans.transType(it.type));
            currentBlock.pushInstruction(new loadInst((Register) val,source));
        }else{
            getLeftPointer=false;
            it.calExp.accept(this);
            getLeftPointer=queryLeft;
            source=null;
            val=calBack;
        }
        switch (it.op){
            case selfAdd -> {
                Register ans=new Register(currentScope.regCnt(),null,trans.transType(it.type));
                currentBlock.pushInstruction(new binaryInst(binaryInst.binaryType.add,val,new IntConstant(1),ans));
                currentBlock.pushInstruction(new storeInst(ans,source));
                if(getLeftPointer)
                    calBack=source;
                else
                    calBack=ans;
            }
            case selfSub -> {
                Register ans=new Register(currentScope.regCnt(),null,trans.transType(it.type));
                currentBlock.pushInstruction(new binaryInst(binaryInst.binaryType.sub,val,new IntConstant(1),ans));
                currentBlock.pushInstruction(new storeInst(ans,source));
                if(getLeftPointer)
                    calBack=source;
                else
                    calBack=ans;
            }
            case positive -> {
                if(getLeftPointer)
                    throw new compilerError("+ operation return no left value",throwPos);
                calBack=val;
            }
            case negative -> {
                if(getLeftPointer)
                    throw new compilerError("- operation return no left value",throwPos);

                Register ans=new Register(currentScope.regCnt(),null,trans.transType(it.type));
                currentBlock.pushInstruction(new binaryInst(binaryInst.binaryType.sub,new IntConstant(0),val,ans));
                calBack=ans;
            }
            case logicNot -> {
                if(getLeftPointer)
                    throw new compilerError("! operation return no left value",throwPos);

                Register ans=new Register(currentScope.regCnt(),null,trans.transType(it.type));
                currentBlock.pushInstruction(new binaryInst(binaryInst.binaryType.xor,new BoolConstant(true),val,ans));
                calBack=ans;
            }
            case bitNot -> {
                if(getLeftPointer)
                    throw new compilerError("~ operation return no left value",throwPos);

                Register ans=new Register(currentScope.regCnt(),null,trans.transType(it.type));
                currentBlock.pushInstruction(new binaryInst(binaryInst.binaryType.xor,new IntConstant(-1),val,ans));
                calBack=ans;
            }
        }
    }

    @Override
    public void visit(newArrayExprNode it){
        ArrayList<IROperand> sizeExpr=new ArrayList<>();
        it.ExprList.forEach(item-> {
            item.accept(this);
            sizeExpr.add(calBack);
        });
        genArray(trans.transType(it.arrayType),sizeExpr);
    }

    @Override
    public void visit(newInitObjectExprNode it){
        //todo
    }

    @Override
    public void visit(newObjectExprNode it){
        //todo
    }

    @Override
    public void visit(postfixExprNode it){
        boolean queryLeft=getLeftPointer;
        getLeftPointer=true;
        it.calExp.accept(this);
        getLeftPointer=queryLeft;
        Register source=(Register) calBack;
        calBack=new Register(currentScope.regCnt(),null,trans.transType(it.type));
        currentBlock.pushInstruction(new loadInst((Register) calBack,source));

        Register tmp=new Register(currentScope.regCnt(),null,trans.transType(it.type));
        switch (it.op){
            case selfAdd -> currentBlock.pushInstruction(new binaryInst(binaryInst.binaryType.add,calBack,new IntConstant(1),tmp));
            case selfSub -> currentBlock.pushInstruction(new binaryInst(binaryInst.binaryType.sub,calBack,new IntConstant(1),tmp));
        }
        currentBlock.pushInstruction(new storeInst(tmp,source));
    }

    @Override
    public void visit(funcCallExprNode it){
        Function toCall;
        Register retReg;
        ArrayList<IROperand> parasExp=new ArrayList<>();
        if(it.funcName instanceof funcNode){
            toCall=module.functions.get(((funcNode)it.funcName).funcName);
        }else if(it.funcName instanceof methodNode){
            ((methodNode) it.funcName).father.accept(this);

            if(calBack.type instanceof IRStringType){
                switch (((methodNode) it.funcName).methodName){
                    case "length" -> toCall=new Function("_str_length",new IRIntType());
                    case "substring" -> toCall=new Function("_str_substring",new IRStringType());
                    case "parseInt" -> toCall=new Function("_str_parseInt",new IRIntType());
                    case "ord" -> toCall=new Function("_str_ord",new IRIntType());
                    default -> throw new compilerError("string method not find",throwPos);
                }
                parasExp.add(calBack);
            }else if(calBack.type instanceof IRPointerType){
                //todo array type
                if(Objects.equals(((methodNode) it.funcName).methodName, "size")){
                    Register transHeader;
                    if((((IRPointerType)calBack.type).baseType instanceof IRIntType)){
                        transHeader=(Register) calBack;
                    }else{
                        transHeader=new Register(currentScope.regCnt(),null,new IRPointerType(new IRIntType()));
                        currentBlock.pushInstruction(new bitcastInst(calBack,transHeader));
                    }
                    Register lenHeader=new Register(currentScope.regCnt(),null,new IRPointerType(new IRIntType()));
                    currentBlock.pushInstruction(new getElementInst(lenHeader,transHeader,new IntConstant(-1)));
                    Register lenReg=new Register(currentScope.regCnt(),null,new IRIntType());
                    currentBlock.pushInstruction(new loadInst(lenReg,lenHeader));
                    calBack=lenReg;
                    return;
                }else{
                    throw new compilerError("array method name not find",throwPos);
                }
            }else{
                //todo class Type
                throw new compilerError("method todo",throwPos);
            }
        }else{
            throw new compilerError("cannot build ir for obj except funcNode and methodNode",throwPos);
        }

        for(var para:it.paras){
            para.accept(this);
            parasExp.add(calBack);
        }
        if(toCall.retType instanceof IRVoidType)retReg=null;
        else{
            retReg=new Register(currentScope.regCnt(),null,toCall.retType);
        }
        callInst inst=new callInst(toCall,retReg,parasExp);
        currentBlock.pushInstruction(inst);
        calBack=retReg;
    }

    @Override
    public void visit(assignExprNode it){
        Register left;
        IROperand right;
        boolean queryLeft=getLeftPointer;
        getLeftPointer=true;
        it.leftExpr.accept(this);
        getLeftPointer=queryLeft;
        left=(Register) calBack;
        it.rightExpr.accept(this);
        right=calBack;
        currentBlock.pushInstruction(new storeInst(right,left));
        calBack=left;
    }

    @Override
    public void visit(classMemberExprNode it){
        //todo care for left value access
    }

    @Override
    public void visit(arrayMemberExprNode it){
        //todo
        boolean tmp=getLeftPointer;
        getLeftPointer=true;
        it.arrayFather.accept(this);
        IROperand arrayFather=calBack;
        getLeftPointer=false;
        it.index.accept(this);
        getLeftPointer=tmp;

        IROperand index=calBack;
        Register head=new Register(currentScope.regCnt(),null,((IRPointerType)arrayFather.type).baseType);
        currentBlock.pushInstruction(new loadInst(head,(Register) arrayFather));
        Register valuePointer=new Register(currentScope.regCnt(),null,head.type);
        currentBlock.pushInstruction(new getElementInst(valuePointer,head,index));
        if(getLeftPointer){
            calBack=valuePointer;
        }else{
            calBack=new Register(currentScope.regCnt(),null,((IRPointerType)valuePointer.type).baseType);
            currentBlock.pushInstruction(new loadInst((Register) calBack,valuePointer));
        }
    }

    @Override
    public void visit(thisExprNode it){
        //todo
    }

    @Override
    public void visit(intConstNode it){
        calBack=new IntConstant(it.value);
    }

    @Override
    public void visit(boolConstNode it){
        calBack=new BoolConstant(it.value);
    }

    @Override
    public void visit(nullConstNode it){
        calBack=new NullptrConstant(new IRPointerType(trans.transType(it.type)));
    }

    @Override
    public void visit(stringConstNode it){
        if(module.stringConstTable.containsKey(it.value))
            calBack=module.stringConstTable.get(it.value);
        else{
            StringConstant sc=new StringConstant(IRCounter.getStringConstCnt(),it.value);
            module.stringConstTable.put(it.value,sc);
            calBack=sc;
        }
    }

    @Override
    public void visit(singleTypeNode it){}

    @Override
    public void visit(typeNode it){}

    @Override
    public void visit(varNode it){
        Register Addr=(Register) currentScope.queryRename(it.name);
        if(getLeftPointer){
            calBack=Addr;
        }else{
            calBack=new Register(currentScope.regCnt(),null,((IRPointerType)Addr.type).baseType);
            currentBlock.pushInstruction(new loadInst((Register) calBack,Addr));
        }
    }

    @Override
    public void visit(funcNode it){}

    @Override
    public void visit(methodNode it){}

    @Override
    public void visit(lambdaExprNode it){
        throw new compilerError("cannot deal with lambda!",it.pos);
    }

}
