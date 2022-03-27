import java.util.ArrayList;

class Methoddecl extends Token {
    ArrayList<Argdecl> argdecls;
    ArrayList<Fielddecl> fielddecls;
    ArrayList<Stmt> stmts;
    String type, id;
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

    public String toString(int depth) {
        String args = "";
        for (Argdecl a : argdecls) {
            args += a.toString() + ", ";
        }
        args = args.substring(0, args.length() > 0 ? args.length() - 2 : 0);

        String result = getTabs(depth) + type + " " + id + "(" + args + ")" + " {\n";
        for (Fielddecl f : fielddecls) {
            result += f.toString(depth + 1) + "\n";
        }
        for (Stmt st : stmts) {
            result += st.toString(depth + 1) + "\n";
        }
        result += getTabs(depth) + "}" + (hasSemi ? ";" : "");
        return result;
    }
}