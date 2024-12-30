import java.util.HashMap;

public class Variable extends Element {

    private static HashMap<Character, Variable> variableMap;
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

    public static Variable getVariable(char c) {
        try {
            return variableMap.get(c);
        }
        catch (Exception e) {
            Variable var = new Variable();
            variableMap.put(c, var);
            return var;
        }
    }
}
