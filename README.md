# Simple Imperative Language

This repository contains an implementation of lexical analyzer, parser, intermediate code generator, and runtime environment (intermediate code executor) for SIL language (Simple Imperative Language).


1. The compiler and runtime environment are built on Windows OS.
2. The tools that we have used are ANTLR4.7, JDK 1.8.
3. Directions to install and run the language are as follows: 

      Unzip the folder and open cmd and go to the directory where compiler.jar and runtime.jar are present.
      Now, suppose you want to run a file SurfaceAreOfCuboid.sil which is inside codes folder.

      To compile .sil program, use the following command:

        java -jar Compiler.jar codes/SurfaceAreOfCuboid.sil

      To run .silc program, use the following command: 

        java -jar Runtime.jar codes/SurfaceAreOfCuboid.silc

4. Youtube link for the project demonstration is :  https://youtu.be/kMCGBe1TDeY
