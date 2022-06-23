#! /bin/bash
mkdir -p bin
find -name "*.java" > bin/sources.txt
javac -d bin @bin/sources.txt
java -classpath ./bin Main
