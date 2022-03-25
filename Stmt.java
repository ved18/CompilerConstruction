public class Stmt implements Token {
  int typeNumber;
  boolean isLoop, hasSemi;
  Fielddecl fielddecl;
  Stmt stmts;
  Args args;
  Expr expr;
  Stmt stmt, ifend;
  Name name;
  String id;
  String unaryOp;
  Readlist rlist;
  Printlist plist;
  Printlinelist printlinelist;

  public Stmt(Expr e, Stmt st, Stmt ifend) {
    // PROD 1 - if
    this.expr = e;
    this.stmt = st;
    this.ifend = ifend;
    this.typeNumber = 0;
  }

  public Stmt(Expr e, Stmt st) {
    // PROD 2 - while
    this.expr = e;
    this.stmt = st;
    typeNumber = 1;
  }

  public Stmt(Name nm, Expr e) {
    // PROD 3 - assign
    this.name = nm;
    this.expr = e;
    typeNumber = 2;
  }

  public Stmt(String function, Readlist rlist) {
    // PROD 4
    this.id = function;
    this.rlist = rlist;
    typeNumber = 3;
  }

  public Stmt(String function, Printlist plist) {
    // PROD 5
    this.id = function;
    this.plist = plist;
    typeNumber = 4;
  }

  public Stmt(String function, Printlinelist printlinelist) {
    // PROD 6
    this.id = function;
    this.printlinelist = printlinelist;
    typeNumber = 5;
  }

  public Stmt(String id) {
    // PROD 7 - id()
    this.id = id;
    typeNumber = 6;
  }

  public Stmt(String id, Args arg) {
    // PROD 8 - id(args)
    this.id = id;
    this.args = arg;
    typeNumber = 7;
  }

  public Stmt() {
    // PROD 9
    typeNumber = 8;
  }

  public Stmt(Expr e) {
    // PROD 10 - return expr
    expr = e;
    typeNumber = 9;
  }

  public Stmt(Name n, String unary) {
    // PROD 10,11 - INC and DEC
    name = n;
    unaryOp = unary;
    typeNumber = 10;
  }

  public Stmt(Fielddecl f, Stmt sts, boolean semi) {
    // PROD 12 - block
    fielddecl = f;
    stmts = sts;
    hasSemi = semi;
    typeNumber = 11;
  }

  public String toString(int t) {
    return "\nStmt worked";
  }
}
