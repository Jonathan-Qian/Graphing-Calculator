package math;

public abstract class FunctionBehaviour {
    private final int priority;
    private final int minNumArguments, maxNumArguments;

    // any combination of the following  is valid (any negative number means infinity):
    // at least n arguments (n+): minNumArguments = n, maxNumArguments = -1
    // at most n arguments (0 - n): minNumArguments = 0, maxNumArguments = n
    // exactly n arguments (n): minNumArguments = n, maxNumArguments = n
    // between n and k arguments (n - k): minNumArguments = n, maxNumArguments = k
    // any number of arguments (0+): minNumArguments = 0, maxNumArguments = -1
    // no arguments (0): minNumArguments = 0, maxNumArguments = 0
    // domain and range of the operator can be enforced within the implementation of behaviour()
    // ex. if (x > 5 && x < 6)...
    // negative numbers are allowed for priority
    public FunctionBehaviour(int priority, int minNumArguments, int maxNumArguments) {
        this.priority = priority;
        this.minNumArguments = minNumArguments;
        this.maxNumArguments = maxNumArguments;
    }
    public FunctionBehaviour(int priority, int numArguments) {
        this(priority, numArguments, numArguments);
    }

    public Double apply(Element[] arguments) {
        if (isNumArgumentsValid(arguments)) {
            return behaviour(simplifyAll(arguments));
        }
        
        System.out.println("Invalid number of arguments.");
        return null;
    }

    // returns null if arguments outside of domain or result outside of range
    public abstract Double behaviour(double[] arguments);

    public int getPriority() {
        return priority;
    }

    public int getMinNumArguments() {
        return minNumArguments;
    }

    public int getMaxNumArguments() {
        return maxNumArguments;
    }

    public boolean canHaveNoArguments() {
        return minNumArguments < 1;
    }

    private boolean isNumArgumentsValid(Element[] arguments) {
        if (arguments.length < minNumArguments) {
            return false;
        }

        return maxNumArguments < 0 || arguments.length <= maxNumArguments;
    }

    private static double[] simplifyAll(Element[] arguments) {
        double[] simplified = new double[arguments.length];

        for (int i = 0; i < simplified.length; i++) {
            simplified[i] = arguments[i].simplify();
        }

        return simplified;
    }
}