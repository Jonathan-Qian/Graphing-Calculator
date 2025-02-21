package math;

import java.util.HashMap;

public class Variable extends Element {

    private static final HashMap<Character, Variable> VARIABLE_MAP = new HashMap<>();
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
        try {
            return VARIABLE_MAP.get(symbol);
        }
        catch (Exception e) {
            Variable var = new Variable();
            VARIABLE_MAP.put(symbol, var);
            return var;
        }
    }
}
