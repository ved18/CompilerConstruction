import java.util.ArrayList;

class Memberdecls extends Token {
    ArrayList<Fielddecl> fielddecls;
    ArrayList<Methoddecl> methoddecls;

    public Memberdecls(ArrayList<Fielddecl> fs, ArrayList<Methoddecl> ms) {
        fielddecls = fs;
        methoddecls = ms;
    }

    public Memberdecls(Fielddecl f, Memberdecls memberdecls) {
        memberdecls.fielddecls.add(0, f);
        this.fielddecls = memberdecls.fielddecls;
        this.methoddecls = memberdecls.methoddecls;
    }

    public Memberdecls(ArrayList<Methoddecl> methoddecl) {
        fielddecls = new ArrayList<Fielddecl>();
        methoddecls = methoddecl;
    }

    public String toString(int t) {
        String result = "";
        for (Fielddecl f : fielddecls)
            result += f.toString(t) + "\n";
        for (Methoddecl m : methoddecls)
            result += m.toString(t) + "\n";
        return result;
    }
}