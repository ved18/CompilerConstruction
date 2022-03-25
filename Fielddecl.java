import javax.sound.sampled.AudioFileFormat.Type;

public class Fielddecl implements Token {
  boolean optFinal;
  Type tp;
  String id;
  Expr optionalex;
  int length;

  public Fielddecl(Type type, String id, Expr optionalex, boolean optFinal) {
    this.tp = type;
    this.id = id;
    this.optionalex = optionalex;
    this.optFinal = optFinal;
    this.length = 0;
  }

  public Fielddecl(Type type, String id, int len) {
    this.tp = type;
    this.id = id;
    this.length = len;
  }

  public String toString(int t) {
    String result = "";

    if (this.length == 0 && optFinal == true)
      result = "FINAL" + tp.toString(t) + " " + id + " " + optionalex.toString(t);
    else
      result = tp.toString(t) + " " + id + " " + optionalex.toString(t);

    return result;
  }
}