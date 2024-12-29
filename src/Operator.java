public class Operator extends Element {
    private Element[] operands;

    public Operator(char symbol, Element[] operands) {
        super(Element.OPERATOR);
        this.operands = operands;
    }
    
    public double simplify() {
        //placeholder
        return 0;
    }
}
