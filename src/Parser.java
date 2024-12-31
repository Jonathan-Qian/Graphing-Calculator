
public class Parser {
    public static Parser instance;

    private Parser() {

    }

    public static Parser getInstance() {
        if (instance == null)
            instance = new Parser();

        return instance;
    }

    public SubExpression parse(String s) {
        //placeholder
        return new SubExpression(Operator.ABSOLUTE, new Element[] {new Number(1)});
    }
}
