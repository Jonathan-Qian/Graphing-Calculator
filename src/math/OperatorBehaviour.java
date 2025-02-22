package math;

public abstract class OperatorBehaviour {
    private final int numOperands;
    
    public OperatorBehaviour(int numOperands) {
        this.numOperands = numOperands;
    }
    
    public double operate(double[] operands) {
        if (isNumOperandsValid(operands)) {
            return behaviour(operands);
        }
        
        System.out.println("Invalid number of operands. Operation result defaulted to 0.");
        return 0;
    }
    
    public abstract double behaviour(double[] operands);
    
    private boolean isNumOperandsValid(double[] operands) {
        return numOperands == operands.length;
    }
}