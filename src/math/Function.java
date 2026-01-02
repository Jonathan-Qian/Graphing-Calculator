package math;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

public class Function {
    private static final HashMap<String, FunctionBehaviour> functionMap = new HashMap<>();

    private Function() {}

    static {
        ServiceLoader<FunctionProvider> loader = ServiceLoader.load(FunctionProvider.class);

        for (FunctionProvider provider : loader) {
            for (Map.Entry<String, FunctionBehaviour> entry : provider.getFunctions().entrySet()) {

                if (functionMap.containsKey(entry.getKey())) {
                    System.err.println("Duplicate function symbol: " + entry.getKey());
                }
                else {
                    functionMap.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public static FunctionBehaviour getFunctionBehaviour(String symbol) {
        return functionMap.get(symbol);
    }

    public static void addFunction(String symbol, FunctionBehaviour behaviour) {
        functionMap.put(symbol, behaviour);
    }
}
