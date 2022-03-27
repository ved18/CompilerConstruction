class Program extends Token {
    String className;
    Memberdecls memberdecls;

    public Program(String id, Memberdecls m) {
        className = id;
        memberdecls = m;
    }

    public String toString(int t) {
        return "class " + className + " {\n" + memberdecls.toString(t + 1) + "}";
    }

}