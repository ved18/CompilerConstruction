public class Argdecl implements Token {
    Type tp;
    String id;
    Boolean isSqaure;

    public Argdecl(Type tp, String id, Boolean isSquare) {
        this.tp = tp;
        this.id = id;
        this.isSqaure = isSquare;
    }

    public String toString(int t) {
        if (isSqaure)
            return tp.toString(t) + " " + id + " [ ]";
        return tp.toString(t) + " " + id;
    }
}
