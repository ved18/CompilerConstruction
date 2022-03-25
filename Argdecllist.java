public class Argdecllist implements Token {
    Argdecl adcl;
    Argdecllist als;

    public Argdecllist(Argdecl adcl, Argdecllist als) {
        this.adcl = adcl;
        this.als = als;
    }

    public Argdecllist(Argdecl adcl) {
        this.adcl = adcl;
        this.als = null;
    }

    public String toString(int t) {
        if (adcl != null && als != null)
            return adcl.toString(t) + " " + als.toString(t);
        else if (als == null)
            return adcl.toString(t) + " ";
        return " ";
    }
}
