package math;

public class Number extends Element {
    private final double value;

    public Number(double number) {
        super(Element.NUMBER);
        value = number;
    }

    @Override
    public double simplify() {
        return value;
    }
}
