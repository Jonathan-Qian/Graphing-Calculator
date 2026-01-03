package math;

// expressions are immutable
public class Expression extends Element {
    private final Element[] arguments;
    private final FunctionBehaviour function;

    public Expression(Element[] arguments, FunctionBehaviour function) {
        super(Element.EXPRESSION);
        this.arguments = arguments;
        this.function = function;
    }

    @Override
    public double simplify() {
        return function.apply(arguments);
    }
}