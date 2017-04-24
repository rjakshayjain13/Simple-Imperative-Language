/*
 *  A grammar for 'Simple Imperative Language' (SIL) written in ANTLR v4.
 *  Version 2 modified on 4/23/2017 by Akshay Jain.
 */

grammar SIL;

// Starting point for parsing SIL file.		
program
	: (statement)+
	;

// Statements
statement
	: assignment
	| ifstatement
	| whilestatement
	| print
	;

// Assignment Statement
assignment
	: Variable '=' expr
	;

Variable
	: [a-zA-Z0-9]+
	;

// Expressions
expr
	: expr '+' subexpr
	| expr '-' subexpr
	| subexpr
	;

subexpr
	: subexpr '*' value
	| subexpr '/' value
	| value
	;

value
	: Variable
	| Number
	;

Number  : [0-9]+
	;

// If Statement (with optional else statement)
ifstatement
	: 'if' compexpr ':' (statement)+ ('else' (statement)+)? 'stop'
	;

compexpr
	: 'true'
	| 'false'
	| expr Cop expr
	;

// Comparison Operators
Cop
	: '=='
	| '>='
	| '<='
	| '>'
	| '<'
	| '~='
	;

// While Statement
whilestatement
	: 'while' compexpr ':' (statement)+ 'stop'
	;

// Print Statement
print
	: 'disp' expr
	;

// Whitespace
WS 	:  [ \t\r\n\u000C]+ -> skip
	;