package math;

import java.util.ArrayList;

// The main model
public class Calculator {
    private Formatter formatter;
    private ArrayList<Expression> expressions;

    public Calculator(ArrayList<Expression> expressions) {
        this.expressions = expressions;
        // placeholder
        expressions.add(new Expression(new Element[] {new Number(0.01)}, new Element[] {new Expression(new Element[] {Variable.getVariable('x')}, new Element[] {new Number(2)}, Function.getFunctionBehaviour("^"))}, Function.getFunctionBehaviour("*")));
    }
    public Calculator() {
        this(new ArrayList<>());
    }

    public ArrayList<Expression> getExpressions() {
        return expressions;
    }
}
