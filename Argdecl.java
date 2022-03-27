class Argdecl extends Token {
    String type;
    String id;
    boolean addSquare;

    public Argdecl(Type type, String id, boolean addSquare) {
        this.type = type.toString();
        this.id = id;
        this.addSquare = addSquare;
    }

    public String toString() {
        return type + " " + id + (addSquare ? "[]" : "");
    }
}