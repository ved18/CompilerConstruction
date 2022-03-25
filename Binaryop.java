public class Binaryop implements Token {
    String op;

    public Binaryop(String op) {
        this.op = op;
    }

    public boolean isArithmetic() {
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/");
    }

    public boolean isRelational() {
        return op.equals("<") || op.equals("<=") || op.equals(">") || op.equals(">=") || op.equals("==")
                || op.equals("<>");
    }

    public boolean isLogical() {
        return op.equals("||") || op.equals("&&");
    }

    public String toString(int t) {
        return op;
    }
}