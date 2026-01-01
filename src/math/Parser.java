package math;

public class Parser {
    public static Parser instance;

    private Parser() {}

    public static Parser getInstance() {
        if (instance == null)
            instance = new Parser();

        return instance;
    }

    //public Expression parse(String s) {


        

    //}

    //format
    //split into elements
    //split into sub expressions by priority
}
