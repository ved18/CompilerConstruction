class Argdecl extends Token {
    String type, id;
    boolean isArray;

    public Argdecl(String type, String id, boolean isArray) {
        this.type = type;
        this.id = id;
        this.isArray = isArray;
    }

    public String toString(int t) {
        return type + " " + id + (isArray ? "[]" : "");
    }
}