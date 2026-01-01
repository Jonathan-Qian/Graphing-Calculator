package math;

public abstract class FunctionBehaviour {
    final int priority;
    final int minNumArgumentsLeft, maxNumArgumentsLeft, minNumArgumentsRight, maxNumArgumentsRight;

    // any combination of the following for left and right is valid (any negative number means infinity):
    // at least n argument: minNumArguments = n, maxNumArguments = -1
    // at most n arguments: minNumArguments = 0, maxNumArguments = n
    // exactly n arguments: minNumArguments = n, maxNumArguments = n
    // between n and k arguments: minNumArguments = n, maxNumArguments = k
    // any number of arguments: minNumArguments = 0, maxNumArguments = -1
    // no arguments: minNumArguments = 0, maxNumArguments = 0
    // domain and range of the operator can be enforced within the implementation of behaviour()
    // ex. if (x > 5 && x < 6)...
    // negative numbers are allowed for priority
    public FunctionBehaviour(int priority, int minNumArgumentsLeft, int maxNumArgumentsLeft, int minNumArgumentsRight, int maxNumArgumentsRight) {
        this.priority = priority;
        this.minNumArgumentsLeft = minNumArgumentsLeft;
        this.maxNumArgumentsLeft = maxNumArgumentsLeft;
        this.minNumArgumentsRight = minNumArgumentsRight;
        this.maxNumArgumentsRight = maxNumArgumentsRight;
    }

    public Double apply(Element[] leftArguments, Element[] rightArguments) {
        if (isNumArgumentsValid(leftArguments, minNumArgumentsLeft, maxNumArgumentsLeft) && isNumArgumentsValid(rightArguments, minNumArgumentsRight, maxNumArgumentsRight)) {
            return behaviour(simplifyAll(leftArguments), simplifyAll(rightArguments));
        }
        
        System.out.println("Invalid number of arguments.");
        return null;
    }

    // returns null if arguments outside of domain or result outside of range
    public abstract Double behaviour(double[] leftArguments, double[] rightArguments);

    private static boolean isNumArgumentsValid(Element[] arguments, int min, int max) {
        if (arguments.length < min) {
            return false;
        }

        return max < 0 || arguments.length <= max;
    }

    private static double[] simplifyAll(Element[] arguments) {
        double[] simplified = new double[arguments.length];

        for (int i = 0; i < simplified.length; i++) {
            simplified[i] = arguments[i].simplify();
        }

        return simplified;
    }
}