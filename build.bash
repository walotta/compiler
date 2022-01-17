set ff=UNIX
set -e
mkdir runContain
cp bif/bif.s builtin.s
find ./src -name "*.java" -print0|xargs -0 javac -d runContain -cp ./lib/*.jar