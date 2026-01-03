package math;

public class Formatter {
    public static Formatter instance;

    private Formatter() {}

    public static Formatter getInstance() {
        if (instance == null)
            instance = new Formatter();

        return instance;
    }

    public String format(String s) {
        s = s.replaceAll("\\s+","");

        

        return s;
    }
}
