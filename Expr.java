public class Expr implements Token {
    int typeNumber;
    String charStr, id;
    int intlit;
    float floatlit;
    Name name;
    boolean bool;
    Expr expr[];
    Binaryop binOp;
    String unaryOp;
    Type castType;
    Args args;

    public Expr(Name nm) { // PROD 1 - name
        name = nm;
        typeNumber = 3;
    }

    public Expr(String id, boolean isMethod) { // PROD 2 - func()
        this.id = id;
        typeNumber = 11;
    }

    public Expr(String id, Args args) { // PROD 3 - func(args)
        this.id = id;
        this.args = args;
        typeNumber = 10;
    }

    public Expr(int i) { // PROD 4 - intlit
        intlit = i;
        typeNumber = 1;
    }

    public Expr(String i, char isStr) { // PROD 5,6 - strlit
        charStr = i;
        typeNumber = isStr == 's' ? 0 : 12;
    }

    public Expr(float i) { // PROD 7 - floatlit
        floatlit = i;
        typeNumber = 2;
    }

    public Expr(boolean b) { // PROD 8,9 - booleans
        bool = b;
        typeNumber = 4;
    }

    public Expr(Expr e) { // PROD 10 - paren
        expr = new Expr[] { e };
        typeNumber = 5;
    }

    public Expr(Expr e, String op) { // PROD 11,12,13 - prefix expr
        unaryOp = op;
        expr = new Expr[] { e };
        typeNumber = 6;
    }

    public Expr(Type ct, Expr e) { // PROD 14 - cast
        castType = ct;
        expr = new Expr[] { e };
        typeNumber = 7;
    }

    public Expr(Expr e1, Binaryop bOp, Expr e2) { // PROD 15 - binop
        expr = new Expr[] { e1, e2 };
        binOp = bOp;
        typeNumber = 8;
    }

    public Expr(Expr e1, Expr e2, Expr e3) { // PROD 16 - ternary
        expr = new Expr[] { e1, e2, e3 };
        typeNumber = 9;
    }

    public String toString(int t) {
        return "\n Worked";
    }
}