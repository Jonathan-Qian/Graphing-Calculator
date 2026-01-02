package math;

import java.util.HashMap;

// the difference between variables and numbers are that variables can only be created through a static method, ensuring that any variables with the same symbol refer to the same variable object
// this syncs the value of all occurrences of the same variable from the original string
// also, a variable's value is mutable unlike a number
public class Variable extends Element {

    private static final HashMap<Character, Variable> variableMap = new HashMap<>();
    private double value;

    private Variable(double n) {
        super(Element.VARIABLE);
        value = n;
    }
    private Variable() {
        this(0);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double n) {
        value = n;
    }

    @Override
    public double simplify() {
        return value;
    }

    public static Variable getVariable(char symbol) {
        if (!variableMap.containsKey(symbol)) {
            Variable var = new Variable();
            variableMap.put(symbol, var);
            return var;
        }

        return variableMap.get(symbol);
    }
}
