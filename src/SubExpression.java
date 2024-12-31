public class SubExpression extends Element {
    private Element[] operands;
    private Operator operator;

    public SubExpression(Operator operator, Element[] operands) {
        super(Element.SUB_EQUATION);
        this.operator = operator;
        this.operands = operands;
    }

    @Override
    public double simplify() {
        return 1.0;
    }

    //Do we need Element class and element type anymore now that subequation is no longer holding an element list?
}
