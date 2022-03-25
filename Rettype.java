import javax.sound.sampled.AudioFileFormat.Type;

public class Rettype {
    Type tp;

    public Rettype(Type tp) {
        this.tp = tp;
    }

    public Rettype() {
        this.tp = null;
    }

    public String toString(int t) {
        if (tp == null)
            return "Void ";
        return tp.toString(t) + " ";
    }
}
