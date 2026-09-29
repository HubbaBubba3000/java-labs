#!/bin/sh

javac -d build $(find . -name "*.java")
# run main with args
java -cp build Main "$@"

#remove all .class files
# rm -f *.class
