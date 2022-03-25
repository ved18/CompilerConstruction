public class Args implements Token {
    Args args;
    Expr e;

    public Args(Expr e) {
        this.e = e;
        this.args = null;
    }

    public Args(Expr e, Args args) {
        this.args = args;
        this.e = e;
    }

    public String toString(int t) {
        if (this.args == null)
            return e.toString(t) + "\n";
        return e.toString() + " , " + args.toString(t) + " ";
    }
}
