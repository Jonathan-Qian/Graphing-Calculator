package math;

import java.util.HashMap;

public class Function {
    private static final HashMap<String, FunctionBehaviour> functionMap = new HashMap<>();

    private Function() {}

    public static FunctionBehaviour getFunctionBehaviour(String symbol) {
        return functionMap.get(symbol);
    }

    public static void addFunction(String symbol, FunctionBehaviour behaviour) {
        functionMap.put(symbol, behaviour);
    }
}
