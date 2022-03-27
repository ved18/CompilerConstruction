public class Token {
    String addSpace(int spaces) {
        String tabs = "";
        for (int i = 0; i < spaces; i++)
            tabs += "\t";
        return tabs;
    }
}