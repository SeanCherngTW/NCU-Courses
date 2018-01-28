# -----------------------------------------------------------------------------
# MiniLispCompiler.py
#
# A Mini LISP Compiler.
# -----------------------------------------------------------------------------

reserved = {
   'if' : 'IF',
   'then' : 'THEN',
   'else' : 'ELSE',
   'while' : 'WHILE',
   'define' : 'DEFINE',
   'fun' : 'FUN',
   'mod' : 'MODULE',
   'and' : 'AND',
   'or'	 : 'OR',
   'not' : 'NOT',
   'print-num' : 'PRINTNUM',
   'print-bool' : 'PRINTBOOL'
}


tokens = [
    'NAME','number','id','boolval',
    'PLUS','MINUS','MULTIPLY','DIVIDE','EQUAL','GREATER','SMALLER',
    'LPAREN','RPAREN','TRUE','FALSE'] + list(reserved.values())

# Tokens

t_PLUS    	= r'\+'
t_MINUS   	= r'-'
t_MULTIPLY	= r'\*'
t_DIVIDE  	= r'/'
t_EQUAL  	= r'='
t_GREATER 	= r'>'
t_SMALLER 	= r'<'
t_LPAREN  	= r'\('
t_RPAREN  	= r'\)'
t_NAME    	= r'[a-zA-Z_][a-zA-Z0-9_]*'
t_id        = r'[a-z]([a-z]|[0-9]|-)*'
t_TRUE		= r'\#t'
t_FALSE		= r'\#f'

def t_ID(t):
	r'[a-z]([a-z]|\d|-)*'
	t.type = reserved.get(t.value, 'id')
	return t

def t_number(t):
	r'\d+'
	t.value = int(t.value)
	return t

# Ignored characters
t_ignore = " \t"

def t_newline(t):
	r'\n+'
	t.lexer.lineno += t.value.count("\n")

def t_error(t):
	t.lexer.skip(1)

# Build the lexer
import ply.lex as lex
lex.lex()

# Precedence rules for the arithmetic operators
precedence = (
	('left','PLUS','MINUS'),
	('left','MULTIPLY','DIVIDE'))

# dictionary of names (for storing variables)
variableDict = {}

def p_program(p):
	'PROGRAM : STMT'
	p[0] = p[1]

def p_stmt(p):
	'''STMT : EXP
			| DEF-STMT
			| PRINT-NUM
			| PRINT-BOOL'''
	p[0] = p[1]

def p_print_num(p):
	'PRINT-NUM : LPAREN PRINTNUM EXP RPAREN'
	if(isinstance(p[3],int)):
		print(p[3])
		p[0] = p[3]
	elif(isinstance(p[3],str) and variableDict[p[3]]!=None):
		print(variableDict[p[3]])
		p[0] = variableDict[p[3]]

def p_print_bool(p):
	'PRINT-BOOL : LPAREN PRINTBOOL EXP RPAREN'
	if(p[3]):
		print('#t')
	else:
		print('#f')
	p[0] = p[3]

def p_num_op(p):
	'''NUM-OP : F-PLUS
			  | F-MINUS
			  | F-MULTIPLY
			  | F-DIVIDE
			  | F-MODULUS
			  | F-GREATER
			  | F-SMALLER
			  | F-EQUAL'''
	p[0] = p[1]

def p_plus(p):
	'F-PLUS : LPAREN PLUS EXP EXPS RPAREN'
	if(isinstance(p[4],list)):
		for num in p[4]:
			p[3] = p[3] + num
		p[0] = p[3]
	
	elif(isinstance(p[4],int)):
		p[0] = p[3] + p[4]

def p_minus(p):
	'F-MINUS : LPAREN MINUS EXP EXPS RPAREN'
	p[0] = p[3] - p[4]

def p_multipy(p):
	'F-MULTIPLY : LPAREN MULTIPLY EXP EXPS RPAREN'
	if(isinstance(p[4],list)):
		for num in p[4]:
			p[3] = p[3] * num
		p[0] = p[3]
	
	elif(isinstance(p[4],int)):
		p[0] = p[3] * p[4]

def p_divide(p):
	'F-DIVIDE : LPAREN DIVIDE EXP EXP RPAREN'
	p[0] = p[3] / p[4]

def p_modulus(p):
	'F-MODULUS : LPAREN MODULE EXP EXP RPAREN'
	p[0] = p[3] % p[4]

def p_greater(p):
	'F-GREATER : LPAREN GREATER EXP EXP RPAREN'
	if(p[3] > p[4]):
		p[0] = True
	else:
		p[0] = False

def p_smaller(p):
	'F-SMALLER : LPAREN SMALLER EXP EXPS RPAREN'
	if(p[3] < p[4]):
		p[0] = True
	else:
		p[0] = False

def p_equal(p):
	'F-EQUAL : LPAREN EQUAL EXP EXPS RPAREN'
	if(isinstance(p[4],list)):
		p[4].sort()
		if((p[3] == p[4][0]) and (p[3] == p[4][-1])):
			p[0] = True
		else:
			p[0] = False

	elif(isinstance,int):
		if(p[3] == p[4]):
			p[0] = True
		else:
			p[0] = False


def p_logical_op(p):
	'''LOGICAL-OP : AND-OP
				  | OR-OP
				  | NOT-OP'''
	p[0] = p[1]

def p_and_op(p):
	'AND-OP : LPAREN AND EXP EXPS RPAREN'
	if(isinstance(p[4],list)):
		p[4].sort()
		if(p[4][0] and p[4][-1] and p[3]):
			p[0] = True
		else:
			p[0] = False
	else:
		if(p[3] and p[4]):
			p[0] = True
		else:
			p[0] = False

def p_or_op(p):
	'OR-OP : LPAREN OR EXP EXPS RPAREN'
	if(isinstance(p[4],list)):
		p[4].sort()
		if(p[4][0] or p[4][-1] or p[3]):
			p[0] = True
		else:
			p[0] = False
	else:
		if(p[3] or p[4]):
			p[0] = True
		else:
			p[0] = False

def p_not_op(p):
	'NOT-OP : LPAREN NOT EXP RPAREN'
	if(not p[3]):
		p[0] = True
	else:
		p[0] = False

def p_def_stmt(p):
	'DEF-STMT : LPAREN DEFINE VARIABLE EXP RPAREN'
	variableDict[p[3]] = p[4]

def p_variable(p):
	'VARIABLE : id'
	p[0] = p[1]

def p_fun_exp(p):
	'FUN-EXP : LPAREN FUN_IDs FUN-BODY RPAREN'

def p_fun_ids(p):
	'FUN_IDs : LPAREN id RPAREN'
	p[0] = p[2]

def p_fun_body(p):
	'FUN-BODY : EXP'
	p[0] = p[1]

def p_fun_call(p):
	'''FUN-CALL : LPAREN FUN-EXP PARAM RPAREN
				| FUN-NAME PARAM RPAREN'''

def p_param(p):
	'PARAM : EXP'
	p[0] = p[1]

def p_last_exp(p):
	'LAST-EXP : EXP'
	p[0] = p[1]

def p_fun_name(p):
	'FUN-NAME : id'
	p[0] = p[1]

def p_if_exp(p):
	'IF-EXP : LPAREN IF TEST-EXP THEN-EXP ELSE-EXP RPAREN'
	if(p[3]):
		p[0] = p[4]
	else:
		p[0] = p[5]

def p_test_exp(p):
	'TEST-EXP : EXP'
	p[0] = p[1]

def p_then_exp(p):
	'THEN-EXP : EXP'
	p[0] = p[1]

def p_else_exp(p):
	'ELSE-EXP : EXP'
	p[0] = p[1]

def p_exps_1(p):
	'EXPS : EXPS EXP'
	if isinstance(p[1], list):
		p[0] = p[1]
		p[0].append(p[2])
	elif isinstance(p[1], int) or isinstance(p[1], bool):
		p[0] = []
		p[0].append(p[1])
		p[0].append(p[2])

def p_exps_2(p):
	'EXPS : EXP'
	p[0] = p[1]

def p_exp_true(p):
	'EXP : TRUE'
	p[0] = True

def p_exp_false(p):
	'EXP : FALSE'
	p[0] = False

def p_exp_variable(p):
	'EXP : VARIABLE'
	p[0] = variableDict[p[1]]

def p_exp(p):
	'''EXP : number
		   | NUM-OP
		   | LOGICAL-OP
		   | FUN-EXP
		   | FUN-CALL
		   | IF-EXP '''
	p[0] = p[1]

def p_error(p):
	print("syntax error")

import ply.yacc as yacc
yacc.yacc()

while True:
	try:
		s = raw_input()   # use input() on Python 3
	except EOFError:
		break
	yacc.parse(s)