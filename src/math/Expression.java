package math;

// expressions are immutable
public class Expression extends Element {
    private final Element[] leftArguments, rightArguments;
    private final FunctionBehaviour function;

    public Expression(Element[] leftArguments, Element[] rightArguments, FunctionBehaviour function) {
        super(Element.EXPRESSION);
        this.leftArguments = leftArguments;
        this.rightArguments = rightArguments;
        this.function = function;
    }

    @Override
    public double simplify() {
        return function.apply(leftArguments, rightArguments);
    }
}