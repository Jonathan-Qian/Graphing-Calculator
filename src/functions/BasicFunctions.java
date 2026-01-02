package functions;

import math.FunctionBehaviour;
import math.FunctionProvider;

import java.util.HashMap;
import java.util.Map;

public class BasicFunctions implements FunctionProvider {
    @Override
    public Map<String, FunctionBehaviour> getFunctions() {
        Map<String, FunctionBehaviour> ops = new HashMap<>();

        ops.put("+", new FunctionBehaviour(0, 2) {
            @Override
            public Double behaviour(double[] arguments) {
                return arguments[0] + arguments[1];
            }
        });

        ops.put("-", new FunctionBehaviour(0, 2) {
            @Override
            public Double behaviour(double[] arguments) {
                return arguments[0] - arguments[1];
            }
        });

        ops.put("*", new FunctionBehaviour(1, 2) {
            @Override
            public Double behaviour(double[] arguments) {
                return arguments[0] * arguments[1];
            }
        });

        ops.put("/", new FunctionBehaviour(1, 2) {
            @Override
            public Double behaviour(double[] arguments) {
                return arguments[0] / arguments[1];
            }
        });

        ops.put("^", new FunctionBehaviour(2, 2) {
            @Override
            public Double behaviour(double[] arguments) {
                return Math.pow(arguments[0], arguments[1]);
            }
        });

        return ops;
    }
}
