import java_cup.runtime.*;


%%
/*-*
 * LEXICAL FUNCTIONS:
 */

%cup
%line
%column
%unicode
%class Lexer

/*
 * NOTE: the above name ExampleLexer, will have to be changed here if
 * you chose to rename the lexer object.
 */
 
%{

/**
 * Return a new Symbol with the given token id, and with the current line and
 * column numbers.
 */
Symbol newSym(int tokenId) {
    return new Symbol(tokenId, yyline, yycolumn);
}

/**
 * Return a new Symbol with the given token id, the current line and column
 * numbers, and the given token value.  The value is used for tokens such as
 * identifiers and numbers.
 */
Symbol newSym(int tokenId, Object value) {
    return new Symbol(tokenId, yyline, yycolumn, value);
}

%}


/*-*
 * PATTERN DEFINITIONS:
 */

tab     = \\t
newline = \\n
slash	= \\
letter	= [A-Za-z]
digit	= [0-9]
id	    = {letter}[{letter}{digit}]*

intlit	 = {digit}+
floatlit = {intlit}\.{intlit}
char     = [^\\\n\t\"\']|\\.
str      = {char}*
charlit  = \'{char}\'
strlit   = \"{str}\"

inlinecomment = {slash}{slash}.*\n
multi_comment = {slash}\*(\\[^\*]|[^\\])*\*{slash}
whitespace    = [ \n\t\r]

%%
/**
 * LEXICAL RULES:
 */
class					{return newSym(sym.CLASS, "class");}
{id}					{return newSym(sym.ID, yytext());}
";"						{return newSym(sym.SEMI, ";");}
void					{return newSym(sym.VOID, "void");}
int						{return newSym(sym.INT, "int");}
char					{return newSym(sym.CHAR, "char");}
bool					{return newSym(sym.BOOL, "bool");}
float					{return newSym(sym.FLOAT, "float");}
if						{return newSym(sym.IF, "if");}
while					{return newSym(sym.WHILE, "while");}
"="   				    {return newSym(sym.ASSIGN, "=");}
read					{return newSym(sym.READ, "read");}
print					{return newSym(sym.PRINT, "print");}
printline			    {return newSym(sym.PRINTLN, "printline");}
return 				    {return newSym(sym.RETURN, "return");}
"("						{return newSym(sym.LROUND, "(");}
")"						{return newSym(sym.RROUND, ")");}
"++"					{return newSym(sym.INC, "++");}
"--"					{return newSym(sym.DEC, "--");}
"{"						{return newSym(sym.LCURLY, "{");}
"}"						{return newSym(sym.RCURLY, "}");}
else					{return newSym(sym.ELSE, "else");}
"["						{return newSym(sym.LSQR, "[");}
"]"						{return newSym(sym.RSQR, "]");}
","						{return newSym(sym.COMMA, ",");}
{intlit}			    {return newSym(sym.INTLIT, yytext());}
{floatlit}		        {return newSym(sym.FLOATLIT, yytext());}
{charlit}			    {return newSym(sym.CHARLIT, yytext());}
{strlit}			    {return newSym(sym.STRLIT, yytext());}
true					{return newSym(sym.TRUE, "true");}
false					{return newSym(sym.FALSE, "false");}
"~"						{return newSym(sym.NOT, "~");}
"-"						{return newSym(sym.MINUS, "-");}
"+"						{return newSym(sym.PLUS, "+");}

//Binary Ops
"?"						{return newSym(sym.QUESTION, "?");}
":"						{return newSym(sym.COLON, ":");}
"*"						{return newSym(sym.MULTI, "*");}
"/"						{return newSym(sym.DIV, "/");}
"<"						{return newSym(sym.LT, "<");}
">"						{return newSym(sym.GT, ">");}
"=="					{return newSym(sym.EQ, "==");}
"<="					{return newSym(sym.LTE, "<=");}
">="					{return newSym(sym.GTE, ">=");}
"<>"					{return newSym(sym.NE, "<>");}
"||"					{return newSym(sym.OR, "||");}
"&&"					{return newSym(sym.AND, "&&");}

final				    {return newSym(sym.FINAL, "final");}

{whitespace}	        {/* whitespace */}
{inlinecomment}			{return newSym(sym.INLINECOMMMENT, "Inline comment");}
{multi_comment}         {return newSym(sym.MULTICOMMMENT, "Multiline comment ");}

. {System.out.println("Illegal character, " + yytext() + " line:" + yyline + " col:" + yychar);}