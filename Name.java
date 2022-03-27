class Name extends Token {
    String id;
    Expr expr;

    public Name(String id) {
        this.id = id;
        this.expr = null;
    }

    public Name(String id, Expr ex) {
        this.id = id;
        this.expr = ex;
    }

    public String toString() {
        return id + (expr != null ? "[" + expr.toString() + "]" : "");
    }

}