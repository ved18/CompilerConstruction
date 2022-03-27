import java.util.ArrayList;

class Stmt extends Token {
  int caseNo;
  boolean loopPresent, isSemi;
  ArrayList<Expr> args;
  Expr expr;
  Stmt stmt, elsestmt;
  Name name;
  String id;
  String uOP;
  ArrayList<Fielddecl> fielddecls;
  ArrayList<Stmt> stmts;
  ArrayList functions;

  public Stmt(Expr e, Stmt st, Stmt elsest) {
    expr = e;
    stmt = st;
    elsestmt = elsest;
    caseNo = 0;
  }

  public Stmt(String id, ArrayList<Expr> ex, boolean func) {
    this.id = id;
    args = ex;
    caseNo = 1;
  }

  public Stmt(ArrayList<Fielddecl> fs, ArrayList<Stmt> sts, boolean semi) {
    fielddecls = fs;
    stmts = sts;
    isSemi = semi;
    caseNo = 2;
  }

  public Stmt(Expr e, Stmt st) {
    expr = e;
    stmt = st;
    caseNo = 3;
  }

  public Stmt(Name n, Expr e) {
    name = n;
    expr = e;
    caseNo = 4;
  }

  public Stmt(String name, ArrayList lst) {
    id = name;
    functions = lst;
    caseNo = (name == "read" ? 5 : (name == "print" ? 6 : 7));
  }

  public Stmt(Name n, String unary) {
    name = n;
    uOP = unary;
    caseNo = 8;
  }

  public Stmt(Expr e) {
    expr = e;
    caseNo = 9;
  }

  public Stmt(String id) {
    this.id = id;
    caseNo = 10;
  }

  public Stmt() {
    caseNo = 11;
  }

  public String toString(int t) {
    String list;
    if (caseNo == 0) {
      return addSpace(t) + "if (" + expr.toString() + ")\n"
          + (stmt.caseNo == 2 ? stmt.toString(t)
              : addSpace(t) + "{\n" + stmt.toString(t + 1) + "\n" + addSpace(t) + "}")
          +
          (elsestmt != null
              ? "\n" + addSpace(t) + "else\n"
                  + (elsestmt.caseNo == 2 ? elsestmt.toString(t)
                      : addSpace(t) + "{\n" + elsestmt.toString(t + 1) + "\n" + addSpace(t) + "}")
              : "");
    }
    if (caseNo == 1) {
      list = "";
      for (Expr e : args) {
        list += e.toString() + ", ";
      }
      list = list.substring(0, list.length() > 0 ? list.length() - 2 : 0);
      return addSpace(t) + id + "(" + list + ");";
    }
    if (caseNo == 2) {
      String result = "";
      for (Fielddecl f : fielddecls) {
        result += f.toString(t + 1) + "\n";
      }
      for (Stmt st : stmts) {
        result += st.toString(t + 1) + "\n";
      }
      return addSpace(t) + "{\n" + result + addSpace(t) + "}";
    }
    if (caseNo == 3) {
      return addSpace(t) +
          "while (" + expr.toString() + ")\n" + stmt.toString(stmt.caseNo == 2 ? t : t + 1) + "\n";
    }
    if (caseNo == 4) {
      return addSpace(t) +
          name.toString() + " = " + expr.toString() + ";";
    }
    if (caseNo == 5) {
      list = "";
      for (Name n : (ArrayList<Name>) functions) {
        list += n.toString() + ", ";
      }
      list = list.substring(0, list.length() > 0 ? list.length() - 2 : 0);
      return addSpace(t) + id + "(" + list + ");";
    }
    if (caseNo == 6) {
      list = "";
      for (Expr e : (ArrayList<Expr>) functions) {
        list += e.toString() + ", ";
      }
      list = list.substring(0, list.length() > 0 ? list.length() - 2 : 0);
      return addSpace(t) + id + "(" + list + ");";
    }
    if (caseNo == 7) {
      list = "";
      for (Expr e : (ArrayList<Expr>) functions) {
        list += e.toString() + ", ";
      }
      list = list.substring(0, list.length() > 0 ? list.length() - 2 : 0);
      return addSpace(t) + id + "(" + list + ");";
    }
    if (caseNo == 8) {
      return addSpace(t) + name.toString() + uOP + ";";
    }
    if (caseNo == 9) {
      return addSpace(t) + "return " + expr.toString() + ";";
    }
    if (caseNo == 10) {
      return addSpace(t) + id + "();";
    }
    if (caseNo == 11) {
      return addSpace(t) + "return;";
    } else
      return "";
  }
}