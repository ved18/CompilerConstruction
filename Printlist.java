public class Printlist implements Token {
    Expr e;
    Printlist plist;

    public Printlist(Expr e, Printlist plist) {
        this.e = e;
        this.plist = plist;
    }

    public Printlist(Expr e) {
        this.e = e;
        this.plist = null;
    }

    public String toString(int t) {
        if (plist == null)
            return e.toString(t) + " ";
        return e.toString(t) + " , " + plist.toString(t) + " ";
    }
}
