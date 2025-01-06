public class SubExpression extends Element {
    private final Element[] operands;
    private final Operator operator;

    public SubExpression(Operator operator, Element[] operands) {
        super(Element.SUB_EXPRESSION);
        this.operator = operator;
        this.operands = operands;
    }

    @Override
    public double simplify() {
        return operator.operate(operands);
    }
}