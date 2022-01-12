import subprocess
import sys
import os
from irSplit import judger
from rich.progress import track
import filecmp

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

def compile():
    ret, val = subprocess.getstatusoutput('java -cp ./lib/antlr-4.9-complete.jar:./runContain Main -emit-llvm <src.mx')
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

def run():
    ret, val = subprocess.getstatusoutput('./src.run <src.in >src.out')
    return ret, val

def compile_std():
    ret, val = subprocess.getstatusoutput('clang src.c -o src.run')
    return ret, val

def run_std():
    ret, val = subprocess.getstatusoutput('./src.run <src.in >src.out')
    return ret, val

testcase=judger()
if len(sys.argv)==1:
    printRet(compile)
    printRet(link)
    printRet(run)
    os.system('cat src.out')
elif sys.argv[1]=='-reload':
    printRet(javac)
    printRet(compile)
    printRet(link)
    printRet(run)
    os.system('cat src.out')
elif sys.argv[1]=='-std':
    printRet(compile_std)
    printRet(run_std)
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
elif sys.argv[1]=='-llvm-test':
    print('now running llvm test')
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
        run()
        ret, val = subprocess.getstatusoutput('diff -w -B src.std src.out')
        if val!='':
            print(fail.format(testName))
            errorcase.append(testPath)
        else:
            print(success.format(testName))
    print("\033[36m{}\033[0m".format('pass: {}/{}'.format(len(testcase.judge_list)-len(errorcase),len(testcase.judge_list))))
    with open('errorcase.txt','w') as f:
        f.write("\n".join(errorcase))
        if len(errorcase)==0:
            f.write('all passed')
    os.system('code errorcase.txt')
else:
    success="\033[32m[Success] : in {} \033[0m"
    fail="\033[31m[Failed] : in {} \033[0m"
    for testId in range(len(testcase.judge_list)):
        testPath=testcase.judge_list[testId]
        testName=os.path.basename(testPath)
        if(testName==sys.argv[1]+'.mx'):
            input,std=testcase.getJudge(testPath)
            os.system('cp {} src.mx'.format(testPath))
            with open('src.in','w') as f:
                f.write(input)
            with open('src.std','w') as f:
                f.write(std)
            compile()
            link()
            printRet(run)
            ret, val = subprocess.getstatusoutput('diff -w -B src.std src.out')
            if val!='':
                print(fail.format(testName))
            else:
                print(success.format(testName))
        
