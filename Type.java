public class Type implements Token {
    Type tp;

    public Type(Type tp) {
        this.tp = tp;
    }

    public String toString(int t) {
        return tp + " ";
    }
}
