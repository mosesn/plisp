#!/bin/sh
if [ $# = 1 ]; then
  scala -classpath ./target/scala-2.9.2/classes/ -howtorun:script src/main/scala/Compiler.scala $1
else
  scala -classpath ./target/scala-2.9.2/classes/ -howtorun:script src/main/scala/Compiler.scala
fi
