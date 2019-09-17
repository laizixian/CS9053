#!/usr/bin/env bash

# TODO - ensure `target/classes` exists (creating it if it doesn't)
mkdir -p target/classes
# TODO - compile all the Java files within the project and output them into `target/classes`
javac -d target/classes src/main/java/edu/nyu/cs9053/homework2/model/*.java src/main/java/edu/nyu/cs9053/homework2/*.java
