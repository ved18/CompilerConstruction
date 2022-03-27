import java.util.ArrayList;

class Expr extends Token {
    int caseNo;
    String cString;
    int intlit;
    float floatlit;
    Name name;
    boolean bool;
    Expr expr[];
    BinaryOp binOp;
    String unaryOp;
    ArrayList<Expr> args;
    String id;
    String typeCast;

    public Expr(String i, char isString) {
        cString = i;
        caseNo = isString == 's' ? 0 : 12;
    }

    public Expr(int i) {
        intlit = i;
        caseNo = 1;
    }

    public Expr(String id, boolean isFunc) {
        this.id = id;
        caseNo = 2;
    }

    public Expr(Name n) {
        name = n;
        caseNo = 3;
    }

    public Expr(boolean b) {
        bool = b;
        caseNo = 4;
    }

    public Expr(Expr e) {
        expr = new Expr[] { e };
        caseNo = 5;
    }

    public Expr(Expr e, String op) {
        unaryOp = op;
        expr = new Expr[] { e };
        caseNo = 6;
    }

    public Expr(Type type, Expr e) {
        typeCast = type.toString();
        expr = new Expr[] { e };
        caseNo = 7;
    }

    public Expr(Expr e1, BinaryOp bOp, Expr e2) {
        expr = new Expr[] { e1, e2 };
        binOp = bOp;
        caseNo = 8;
    }

    public Expr(Expr e1, Expr e2, Expr e3) {
        expr = new Expr[] { e1, e2, e3 };
        caseNo = 9;
    }

    public Expr(String id, ArrayList<Expr> args) {
        this.id = id;
        this.args = args;
        caseNo = 10;
    }

    public Expr(float i) {
        floatlit = i;
        caseNo = 11;
    }

    public String toString() {

        if (caseNo == 0 || caseNo == 12)
            return cString;
        else if (caseNo == 1)
            return "" + intlit;
        else if (caseNo == 2)
            return id + "()";

        else if (caseNo == 3)
            return name.toString();
        else if (caseNo == 4)
            return bool ? "true" : "false";
        else if (caseNo == 5)
            return expr[0].toString();
        else if (caseNo == 6)
            return "(" + unaryOp + " " + expr[0].toString() + ")";
        else if (caseNo == 7)
            return "(" + typeCast + ")" + expr[0].toString();
        else if (caseNo == 8)
            return "(" + expr[0].toString() + " " + binOp.toString() + " " + expr[1].toString() + ")";
        else if (caseNo == 9)
            return "( " + expr[0].toString() + " ? " + expr[1].toString() + " : " + expr[2].toString() + " )";
        else if (caseNo == 10) {
            String ret = "";
            for (Expr e : args) {
                ret += e.toString() + ", ";
            }
            ret = ret.substring(0, ret.length() > 0 ? ret.length() - 2 : 0);
            return id + "(" + ret + ")";

        } else if (caseNo == 11)
            return "" + floatlit;
        else
            return "";
    }

}