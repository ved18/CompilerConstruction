import java.util.ArrayList;

class Methoddecl extends Token {
    ArrayList<Argdecl> argdecls;
    ArrayList<Stmt> stmts;
    String type, id;
    ArrayList<Fielddecl> fielddecls;
    boolean hasSemi;

    public Methoddecl(String type, String id, ArrayList<Argdecl> as, ArrayList<Fielddecl> fs, ArrayList<Stmt> sts,
            boolean semi) {
        this.type = type;
        this.id = id;
        argdecls = as;
        fielddecls = fs;
        stmts = sts;
        hasSemi = semi;
    }

    public String toString(int t) {
        String args = "";
        for (Argdecl a : argdecls) {
            args += a.toString() + ", ";
        }
        args = args.substring(0, args.length() > 0 ? args.length() - 2 : 0);

        String result = addSpace(t) + type + " " + id + "(" + args + ")" + " {\n";
        for (Fielddecl f : fielddecls) {
            result += f.toString(t + 1) + "\n";
        }
        for (Stmt st : stmts) {
            result += st.toString(t + 1) + "\n";
        }
        result += addSpace(t) + "}" + (hasSemi ? ";" : "");
        return result;
    }
}