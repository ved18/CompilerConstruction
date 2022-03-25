public class Program implements Token {
    String id;
    Memberdecls memberdecls;

    public Program(String id, Memberdecls m) {
        this.id = id;
        this.memberdecls = m;
        // table = new SymTable();
    }

    public String toString(int t) {
        return "class " + this.id + " {\n" + memberdecls.toString(t + 1) + "}";
    }
}
