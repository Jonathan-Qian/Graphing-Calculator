package math;

import java.util.ArrayList;

// The main model
public class Calculator {
    private Formatter formatter;
    private ArrayList<SubExpression> expressions;

    public Calculator(ArrayList<SubExpression> expressions) {
        this.expressions = expressions;
    }
    public Calculator() {
        this(new ArrayList<>());
    }

    public ArrayList<SubExpression> getExpressions() {
        return expressions;
    }
}
