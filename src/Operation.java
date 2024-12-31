public class Operation extends Element {
    // perhaps now use a similar general pattern to Variable now that not every Operation is unique anymore (since it does not hold operands)
    public Operation(char symbol) {
        super(Element.OPERATION);
    }

    //no need for operation class anymore. Subequations should now contain Element[] operands and a Operator. In summary, a subequation is not what an Operation use to be;
    // Delete this class
    @Override
    public double simplify() {
        //placeholder
        return 0;
    }
}
