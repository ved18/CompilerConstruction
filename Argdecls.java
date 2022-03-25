public class Argdecls implements Token {
    Argdecllist als;

    public Argdecls(Argdecllist als) {
        this.als = als;
    }

    public String toString(int t) {
        if (als != null)
            return als.toString(t);
    }

}
