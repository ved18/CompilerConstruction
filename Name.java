public class Name implements Token {
    String id;
    Expr e;

    public Name(String id) {
        this.id = id;
        this.e = null;
    }

    public Name(String id, Expr e) {
        this.id = id;
        this.e = e;
    }

    public String toString(int t) {
        if (this.e == null)
            return id + "\n";
        return id + " [ " + e.toString(t) + " ]";
    }
}
