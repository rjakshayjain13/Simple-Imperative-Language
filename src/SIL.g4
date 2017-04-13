grammar SIL;
		
statement
	: assignment
	| ifstatement
	| whilestatement
	| print
	;

assignment
	: Variable '=' expr
	;

Variable
	: [a-zA-Z0-9]+
	;

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

ifstatement
	: 'if' compexpr ':' statement ('else' statement)? 'stop'
	;

compexpr
	: expr COP expr
	;

COP
	: '=='
	| '>='
	| '<='
	| '>'
	| '<'
	| '~='
	;

whilestatement
	: 'while' compexpr ':' statement 'stop'
	;

print
	: 'disp' expr
	;

WS 	:  [ \t\r\n\u000C]+ -> skip
	;