JAVA=java
JAVAC=javac
JFLEX=$(JAVA) -jar jflex-1.8.2/lib/jflex-full-1.8.2.jar
CUPJAR=./java-cup-11b.jar
CUP=$(JAVA) -jar $(CUPJAR)
CP=.:$(CUPJAR)

default: run

.SUFFIXES: $(SUFFIXES) .class .java

.java.class:
				$(JAVAC) -cp $(CP) $*.java

FILE=		Lexer.java      parser.java    sym.java \
				lexerTest.java \
				Argdecl.java Argdecllist.java Args.java \
				Binaryop.java Expr.java Fielddecl.java Fielddecls.java \
				Memberdecls.java Methoddecl.java Methoddecls.java Name.java \
				Printlinelist.java Printlist.java Program.java Readlist.java \
				Rettype.java Stmt.java Stmts.java Token.java

run: testParse.txt lexTest.txt

parserTests: build
	$(JAVA) -cp $(CP) ParserTest $$f >> parserTestOutputs.txt
	cat -n parserTestOutputs.txt

testParse.txt: all
		$(JAVA) -cp $(CP) Parsertest testParse.txt > testParse-output.txt
		cat -n testParse-output.txt

lexTest.txt: all
		$(JAVA) -cp $(CP) lexerTest lexTest.txt > lexTest-output.txt
		cat -n lexTest-output.txt

all: Lexer.java parser.java $(FILE:java=class)

dump: Lexer.java parserD.java $(FILE:java=class)

clean:
		rm -f *.class *~ *.bak Lexer.java parser.java sym.java

Lexer.java: grammar.jflex
		$(JFLEX) grammar.jflex

parser.java: tokens.cup
		$(CUP) -interface < tokens.cup

parserD.java: tokens.cup
		$(CUP) -interface -dump < tokens.cup
