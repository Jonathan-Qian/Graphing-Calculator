import java.util.ArrayList;

public class SubEquation extends Element {
    private ArrayList<Element> elements;

    public SubEquation(ArrayList<Element> elements) {
        super(Element.SUB_EQUATION);
        this.elements = elements;
    }

    @Override
    public double simplify() {
        return 1.0;
    }
}
