import subprocess
import sys
import os

def printRet(func):
    def wrapper(*args, **kw):
        print("\033[36m{}\033[0m".format('call: {}'.format(func.__name__)))
        ret,val=func(*args, **kw)
        if val!='':
            if ret==0:
                print("\033[37m{}\033[0m".format(val))
            else:
                print("\033[31m{}\033[0m".format('ret code: '+str(ret)))
                print("\033[37m{}\033[0m".format(val))
        return ret
    return wrapper

@printRet
def javac():
    ret, val = subprocess.getstatusoutput('find ./src -name "*.java" -print0|xargs -0 javac -d runContain -cp ./lib/*.jar')
    return ret, val

@printRet
def compile():
    ret, val = subprocess.getstatusoutput('java -cp ./lib/antlr-4.9-complete.jar:./runContain Main -emit-llvm <src.mx')
    return ret, val

@printRet
def Slink():
    ret, val = subprocess.getstatusoutput('llvm-link src.ll bif/bif.ll -S -o link.ll')
    return ret, val

@printRet
def Srun():
    ret, val = subprocess.getstatusoutput('lli link.ll')
    return ret, val

@printRet
def link():
    ret, val = subprocess.getstatusoutput('clang src.ll bif/bif.ll -o src.run')
    return ret, val

@printRet
def run():
    ret, val = subprocess.getstatusoutput('./src.run <src.in >src.out')
    return ret, val

@printRet
def compile_std():
    ret, val = subprocess.getstatusoutput('clang src.c -o src.run')
    return ret, val

@printRet
def run_std():
    ret, val = subprocess.getstatusoutput('./src.run <src.in >src.out')
    return ret, val

if len(sys.argv)==1:
    ret=compile()
    if ret!=0:
        quit()
    ret=link()
    if ret!=0:
        quit()
    ret=run()
    if ret!=0:
        quit()
    os.system('cat src.out')
elif sys.argv[1]=='-reload':
    ret=javac()
    if ret!=0:
        quit()
    ret=compile()
    if ret!=0:
        quit()
    ret=link()
    if ret!=0:
        quit()
    ret=run()
    if ret!=0:
        quit()
    os.system('cat src.out')
elif sys.argv[1]=='-std':
    ret=compile_std()
    if ret!=0:
        quit()
    ret=run_std()
    if ret!=0:
        quit()
elif sys.argv[1]=='-S':
    ret=javac()
    if ret!=0:
        quit()
    ret=compile()
    if ret!=0:
        quit()
    ret=Slink()
    if ret!=0:
        quit()
    ret=Srun()
    if ret!=0:
        quit()
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
