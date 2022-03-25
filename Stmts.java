public class Stmts implements Token {
    Stmt st;
    Stmts sts;

    public Stmts(Stmt st, Stmts sts) {
        this.st = st;
        this.sts = sts;
    }

    public String toString(int t) {
        if (sts != null)
            return st.toString(t) + " " + sts.toString(t);
        return st.toString(t);
    }
}
