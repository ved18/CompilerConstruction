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

%{

/*
 * NOTE: the above name ExampleLexer, will have to be changed here if
 * you chose to rename the lexer object.
 */

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

slash	= \\
letter	= [A-Za-z]
digit	= [0-9]
id	= {letter}[{letter}{digit}]*

intlit	= {digit}+
floatlit = {intlit}\.{intlit}
char = [^\\\n\t\"\']|\\.
str = {char}*
charlit = \'{char}\'
strlit = \"{str}\"

inlinecomment	= {slash}{slash}.*\n
multi_comment = {slash}\*(\\[^\*]|[^\\])*\*{slash}
whitespace = [ \n\t\r]



%%
//Lex Rules

class					{return newSym(sym.CLASS, "class");}
else					{return newSym(sym.ELSE, "else");}
if						{return newSym(sym.IF, "if");}
while					{return newSym(sym.WHILE, "while");}
return 					{return newSym(sym.RETURN, "return");}
";"						{return newSym(sym.SEMI, ";");}
"="   					{return newSym(sym.ASSIGN, "=");}
","						{return newSym(sym.COMMA, ",");}
"("						{return newSym(sym.LEFTROUND, "(");}
")"						{return newSym(sym.RIGHTROUND, ")");}
"["						{return newSym(sym.LEFTSQR, "[");}
"]"						{return newSym(sym.RIGHTSQR, "]");}
"{"						{return newSym(sym.LEFTCBR, "{");}
"}"						{return newSym(sym.RIGHTCBR, "}");}
"~"						{return newSym(sym.NOT, "~");}
"?"						{return newSym(sym.QUESTION, "?");}
":"						{return newSym(sym.COLON, ":");}
"++"					{return newSym(sym.INC, "++");}
"--"					{return newSym(sym.DEC, "--");}
"*"						{return newSym(sym.MULTI, "*");}
"/"						{return newSym(sym.DIV, "/");}
"+"						{return newSym(sym.PLUS, "+");}
"-"						{return newSym(sym.MINUS, "-");}
"<"						{return newSym(sym.LT, "<");}
">"						{return newSym(sym.GT, ">");}
"=="					{return newSym(sym.EQUAL, "==");}
"<>"					{return newSym(sym.NOTEQUAL, "<>");}
"<="					{return newSym(sym.LTE, "<=");}
">="					{return newSym(sym.GTE, ">=");}
"||"					{return newSym(sym.OR, "||");}
"&&"					{return newSym(sym.AND, "&&");}
read					{return newSym(sym.READ, "read");}
print					{return newSym(sym.PRINT, "print");}
printline				{return newSym(sym.PRINTLN, "printline");}
void					{return newSym(sym.VOID, "void");}
int						{return newSym(sym.INT, "int");}
float					{return newSym(sym.FLOAT, "float");}
bool					{return newSym(sym.BOOL, "bool");}
char					{return newSym(sym.CHAR, "char");}
final					{return newSym(sym.FINAL, "final");}
true					{return newSym(sym.TRUE, "true");}
false					{return newSym(sym.FALSE, "false");}
{intlit}				{return newSym(sym.INTLIT, yytext());}
{floatlit}				{return newSym(sym.FLOATLIT, yytext());}
{charlit}				{return newSym(sym.CHARLIT, yytext());}
{strlit}				{return newSym(sym.STRLIT, yytext());}
{id}					{return newSym(sym.ID, yytext());}

{whitespace}			{/* whitespace */}
{inlinecomment}			{}
{multi_comment}         {}

. {System.out.println("Illegal character, " + yytext() + " line:" + yyline + " col:" + yychar);}
 