import java.util.ArrayList;

public class Parser {
    public static Parser instance;

    private Parser() {

    }

    public static Parser getInstance() {
        if (instance == null)
            instance = new Parser();

        return instance;
    }

    public static SubEquation parse(String s) {
        //placeholder
        return new SubEquation(new ArrayList<>());
    }
}
