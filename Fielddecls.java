public class Fielddecls implements Token {
    Fielddecl f;
    Fielddecls fs;

    public Fielddecls(Fielddecl f, Fielddecls fs) {
        this.f = f;
        this.fs = fs;
    }

    public Fielddecls(Fielddecl f) {
        this.f = f;
        this.fs = null;
    }

    public String toString(int t) {
        String result = "";
        if (fs != null)
            result = f.toString(t) + fs.toString(t) + "\n";
        else
            result = f.toString(t) + "\n";

        return result;
    }
}
