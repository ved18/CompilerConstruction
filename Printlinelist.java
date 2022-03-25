public class Printlinelist implements Token {
    Printlist plist;

    public Printlinelist(Printlist plist) {
        this.plist = plist;
    }

    public Printlinelist() {
        this.plist = null;
    }

    public String toString(int t) {
        if (plist != null)
            return plist.toString(t) + " ";
        return " ";
    }
}
