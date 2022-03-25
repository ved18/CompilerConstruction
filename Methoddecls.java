public class Methoddecls implements Token {
    Methoddecl m;
    Methoddecls ms;

    public Methoddecls(Methoddecl m, Methoddecls ms) {
        this.m = m;
        this.ms = ms;
    }

    public Methoddecls(Methoddecl m) {
        this.m = m;
        this.ms = null;
    }

    public String toString(int t) {
        String result = "";
        if (ms != null)
            result = m.toString(t) + ms.toString(t) + "\n";
        else
            result = m.toString(t) + "\n";

        return result;
    }
}