package math;

import java.util.ArrayList;

// The main model
public class Calculator {
    private Formatter formatter;
    private ArrayList<Expression> expressions;

    public Calculator(ArrayList<Expression> expressions) {
        this.expressions = expressions;
    }
    public Calculator() {
        this(new ArrayList<>());
    }

    public ArrayList<Expression> getExpressions() {
        return expressions;
    }
}
