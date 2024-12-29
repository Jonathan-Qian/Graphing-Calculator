public class Number extends Element {
    private final double VALUE;

    public Number(double number) {
        super(Element.NUMBER);
        VALUE = number;
    }

    @Override
    public double simplify() {
        return VALUE;
    }
}
