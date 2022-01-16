import subprocess
import sys
import os
from irSplit import judger
from rich.progress import track
import time

def printRet(func):
    print("\033[36m{}\033[0m".format('call: {}'.format(func.__name__)))
    ret,val=func()
    if val!='':
        if ret==0:
            print("\033[37m{}\033[0m".format(val))
        else:
            print("\033[31m{}\033[0m".format('ret code: '+str(ret)))
            print("\033[37m{}\033[0m".format(val))
            quit()

def javac():
    ret, val = subprocess.getstatusoutput('find ./src -name "*.java" -print0|xargs -0 javac -d runContain -cp ./lib/*.jar')
    return ret, val

def llvm():
    ret, val = subprocess.getstatusoutput('java -cp ./lib/antlr-4.9-complete.jar:./runContain Main -emit-llvm -file <src.mx')
    return ret, val

def compile():
    ret, val = subprocess.getstatusoutput('java -cp ./lib/antlr-4.9-complete.jar:./runContain Main -file <src.mx')
    return ret, val

def Slink():
    ret, val = subprocess.getstatusoutput('llvm-link src.ll bif/bif.ll -S -o link.ll')
    return ret, val

def Srun():
    ret, val = subprocess.getstatusoutput('lli link.ll')
    return ret, val

def link():
    ret, val = subprocess.getstatusoutput('clang src.ll bif/bif.ll -o src.run')
    return ret, val

def runllvm(detail=True):
    os.system('rm src.out')
    os.system('touch src.out')
    try:
        task=subprocess.run('./src.run <src.in >src.out',shell=True,stdout=subprocess.PIPE,stderr=subprocess.PIPE,encoding="utf-8",timeout=5)
    except:
        return 62,'time out'
    if task.stderr!='' and detail:
        print(task.stderr,end='')
    return task.returncode, task.stdout

def run():
    os.system('rm src.out')
    os.system('touch src.out')
    ret, val = subprocess.getstatusoutput('ravel --input-file=src.in --output-file=src.out src.s bif/bif.s')
    val=val.split('\n')
    newVal=''
    for v in val:
        if('Ignoring directive:' not in v):
            newVal=newVal+v+'\n'
    return ret, newVal

def compile_std():
    # ret, val = subprocess.getstatusoutput('clang -emit-llvm -S src.cpp -o src.ll --target=riscv32')
    ret, val = subprocess.getstatusoutput('llc src.ll -o src.s -march=riscv32')
    return ret, val

def run_std():
    ret, val = subprocess.getstatusoutput('./src.run <src.in >src.out')
    return ret, val

def ravel():
    ret, val = subprocess.getstatusoutput('ravel --input-file=src.in --output-file=src.out src.s bif/bif.s')
    return ret, val

testcase=judger()
if len(sys.argv)==1:
    print(llvm)
    printRet(compile)
    printRet(link)
    printRet(run)
    os.system('cat src.out')
elif sys.argv[1]=='-reload':
    printRet(javac)
    printRet(llvm)
    printRet(compile)
    printRet(link)
    printRet(run)
    os.system('cat src.out')
elif sys.argv[1]=='-std':
    printRet(compile_std)
elif sys.argv[1]=='-S':
    printRet(javac)
    printRet(compile)
    printRet(Slink)
    printRet(Srun)
elif sys.argv[1]=='-h':
    print("compiler runner version 1.0")
    print(' no argv        to  compile mx, link and run by bitcode')
    print(" with '\033[36m{}\033[0m'      to  compile mx, link and run by ASCII".format('-S'))
    print(" with '\033[36m{}\033[0m' to  recompile your compiler".format('-reload'))
    print("                and compile mx, link and run by ASCII")
    print(" with '\033[36m{}\033[0m'    to  use clang to compile .c and run".format('-std'))
    print(" with '\033[36m{}\033[0m'      to  get some help".format('-h'))
    print(" with '\033[36m{}\033[0m'      to  see version info".format('-v'))
elif sys.argv[1]=='-v':
    print("compiler runner version 1.0")
    print("use \033[36m{}\033[0m to get some help".format('-h'))
    print("@Copyright by walotta")
elif sys.argv[1]=='-test':
    printRet(javac)
    success="\033[32m[Success] : in {} \033[0m"
    fail="\033[31m[Failed] : in {} \033[0m"
    errorcase=[]
    for testId in track(range(len(testcase.judge_list))):
        testPath=testcase.judge_list[testId]
        testName=os.path.basename(testPath)
        input,std=testcase.getJudge(testPath)
        os.system('cp {} src.mx'.format(testPath))
        with open('src.in','w') as f:
            f.write(input)
        with open('src.std','w') as f:
            f.write(std)
        compile()
        link()
        run(detail=False)
        ret, val = subprocess.getstatusoutput('diff -w -B src.std src.out')
        if val!='':
            errorcase.append(testPath)
            print(fail.format(testName),'{}/{}'.format(testId-len(errorcase)+1,testId+1))
        else:
            print(success.format(testName),'{}/{}'.format(testId-len(errorcase)+1,testId+1))
    print("\033[36m{}\033[0m".format('pass: {}/{}'.format(len(testcase.judge_list)-len(errorcase),len(testcase.judge_list))))
    with open('errorcase.txt','w') as f:
        f.write("\n".join(errorcase))
        if len(errorcase)==0:
            f.write('all passed')
    os.system('code errorcase.txt')
elif sys.argv[1]=='-ravel':
    printRet(ravel)
    os.system('cat src.out')
else:
    success="\033[32m[Success] : in {} \033[0m"
    fail="\033[31m[Failed] : in {} \033[0m"
    for testId in range(len(testcase.judge_list)):
        testPath=testcase.judge_list[testId]
        testName=os.path.basename(testPath)
        if(testName==sys.argv[1]+'.mx' or testName==sys.argv[1]+'.mt'):
            input,std=testcase.getJudge(testPath)
            os.system('cp {} src.mx'.format(testPath))
            with open('src.in','w') as f:
                f.write(input)
            with open('src.std','w') as f:
                f.write(std)
            compile()
            link()
            run()
            ret, val = subprocess.getstatusoutput('diff -w -B src.std src.out')
            if val!='':
                print(fail.format(testName))
            else:
                print(success.format(testName))
        
