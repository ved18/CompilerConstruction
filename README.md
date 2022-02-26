Project part 1:

```
We have implemented a scanner that follows the rules for identifying tokens and gives output as a list of valid and invalid tokens.
```

Build and Run:

```
make
```

Build:

```
make all
```

Run:

```
make run
```

Clean Project

```
make clean
```

### Input file

```
lexTest.txt
```

### Once run the output can be found in lexTest-output.txt

# Grammar

```
Program → class id { Memberdecls }
Memberdecls → Fielddecls Methoddecls
Fielddecls → Fielddecl Fielddecls | λ
Methoddecls → Methoddecl Methoddecls | λ
Fielddecl → Optionalfinal Type id Optionalexpr ; | Type id [ intlit ] ;
Optionalfinal → final | λ
Optionalexpr → = Expr | λ
Methoddecl → Returntype id ( Argdecls ) { Fielddecls Stmts } Optionalsemi
Optionalsemi → ; | λ
Returntype → Type | void
Type → int | char | bool | float
Argdecls → ArgdeclList | λ
ArgdeclList → Argdecl , ArgdeclList | Argdecl
Argdecl → Type id | Type id [ ]
Stmts → Stmt Stmts | λ
Stmt → if ( Expr ) Stmt OptionalElse | while ( Expr ) Stmt | Name = Expr ;
| read ( Readlist ) ; | print ( Printlist ) ; | printline ( Printlinelist ) ;
| id ( ) ; | id ( Args ) ; | return ; | return Expr ; | Name ++ ; | Name -- ;
| { Fielddecls Stmts } Optionalsemi
OptionalElse → else Stmt | λ
Name → id | id [ Expr ]
Args → Expr , Args | Expr
Readlist → Name , Readlist | Name
Printlist → Expr , Printlist | Expr
Printlinelist → Printlist | λ
Expr → Name | id ( ) | id ( Args ) | intlit | charlit | strlit | floatlit | true | false
| ( Expr ) | ~ Expr | - Expr | + Expr | ( Type ) Expr | Expr Binaryop Expr | ( Expr ? Expr : Expr )
Binaryop → * | / | + | - | < | > | <= | >= | == | <> | || | &&
```
