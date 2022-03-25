public class Memberdecls implements Token {
    Fielddecl fielddecl;
    Methoddecls methoddecls;

    public Memberdecls(Fielddecl f, Methoddecls mds) {
        this.fielddecl = f;
        this.methoddecls = mds;
    }

    public Memberdecls(Methoddecls ms) {
        this.fielddecl = null;
        this.methoddecls = ms;
    }

    public String toString(int t) {
        String result = "";
        if (fielddecl != null)
            result += fielddecl.toString(t) + "\n" + methoddecls.toString(t);
        else
            result = methoddecls.toString(t) + "\n";

        return result;
    }
}
