public class Operation extends Element {
    private Element[] operands;

    public Operation(char symbol, Element[] operands) {
        super(Element.OPERATION);
        this.operands = operands;
    }
    
    @Override
    public double simplify() {
        //placeholder
        return 0;
    }
}
