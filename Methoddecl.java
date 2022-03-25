public class Methoddecl implements Token {
    Rettype rtype;
    String id;
    Argdecls as;
    Fielddecls fs;
    Stmts sts;
    Boolean optionalSemi;

    public Methoddecl(Rettype rtype, String id, Argdecls as, Fielddecls fs, Stmts sts, Boolean optionalSemi) {
        this.rtype = rtype;
        this.as = as;
        this.fs = fs;
        this.sts = sts;
        this.optionalSemi = optionalSemi;
    }

    public String toString(int t) {
        if (optionalSemi && as != null)
            return rtype.toString(t) + " " + id + " " + as.toString(t) + " " + fs.toString(t) + " " + sts.toString()
                    + ";";
        else if (optionalSemi && as == null)
            return rtype.toString(t) + " " + id + " " + fs.toString(t) + " " + sts.toString() + ";";
        else if (!optionalSemi && as != null)
            return rtype.toString(t) + " " + id + " " + as.toString(t) + " " + fs.toString(t) + " " + sts.toString();
        return rtype.toString(t) + " " + id + " " + fs.toString(t) + " " + sts.toString();
    }
}
