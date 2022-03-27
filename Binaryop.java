class BinaryOp extends Token {
    String operator;

    public BinaryOp(String operator) {
        this.operator = operator;
    }

    public String toString() {
        return operator;
    }
}