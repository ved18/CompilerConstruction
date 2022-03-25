public class Readlist implements Token {
    Name nm;
    Readlist rlist;

    public Readlist(Name nm, Readlist readlist) {
        this.nm = nm;
        this.rlist = readlist;
    }

    public Readlist(Name nm) {
        this.nm = nm;
        this.rlist = null;
    }

    public String toString(int t) {
        if (rlist == null)
            return nm.toString(t) + " ";
        return nm.toString(t) + " , " + rlist.toString(t) + " ";
    }
}
