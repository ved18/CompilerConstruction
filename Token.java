public class Token {
    protected String getTabs(int num) {
        String tabs = "";
        for (int i = 0; i < num; i++)
            tabs += "\t";
        return tabs;
    }
}