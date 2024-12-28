import java.util.ArrayList;

public class SubEquation extends Element {
    private ArrayList<Element> elements;

    public SubEquation(String s) {
        super(Element.SUB_EQUATION);
        elements = translate(s);
    }

    private ArrayList<Element> translate(String s) {
        return null;
    }

    @Override
    public double simplify() {
        return 1.0;
    }
}
