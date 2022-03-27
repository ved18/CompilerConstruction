class Fielddecl extends Token {
  boolean isFinal;
  String type, id;
  int arrLength;
  Expr opex;
  int caseNo;

  public Fielddecl(Type type, String id, Expr opex, boolean isFinal) {
    this.type = type.toString();
    this.id = id;
    this.opex = opex;
    this.isFinal = isFinal;
    caseNo = 0;
  }

  public Fielddecl(Type type, String id, int len) {
    this.type = type.toString();
    this.id = id;
    this.arrLength = len;
    caseNo = 1;
  }

  public String toString(int t) {
    if (caseNo == 0)
      return addSpace(t) + (isFinal ? "final " : "") + type + " " + id
          + (opex != null ? " = " + opex.toString() : "") + ";";
    else if (caseNo == 1)
      return addSpace(t) + type + " " + id + "[" + arrLength + "]" + ";";
    else
      return "";
  }
}