set ff=UNIX
set -e
find ./src -name "*.java" -print0|xargs -0 javac -d runContain -cp ./lib/*.jar --enable-preview