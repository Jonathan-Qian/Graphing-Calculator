package functions;

import math.FunctionBehaviour;
import math.FunctionProvider;

import java.util.HashMap;
import java.util.Map;

public class BasicFunctions implements FunctionProvider {
    @Override
    public Map<String, FunctionBehaviour> getFunctions() {
        Map<String, FunctionBehaviour> ops = new HashMap<>();

        ops.put("+", new FunctionBehaviour(0, 1, 1) {
            @Override
            public Double behaviour(double[] leftArguments, double[] rightArguments) {
                return leftArguments[0] + rightArguments[0];
            }
        });

        ops.put("-", new FunctionBehaviour(0, 1, 1) {
            @Override
            public Double behaviour(double[] leftArguments, double[] rightArguments) {
                return leftArguments[0] - rightArguments[0];
            }
        });

        ops.put("*", new FunctionBehaviour(1, 1, 1) {
            @Override
            public Double behaviour(double[] leftArguments, double[] rightArguments) {
                return leftArguments[0] * rightArguments[0];
            }
        });

        ops.put("/", new FunctionBehaviour(1, 1, 1) {
            @Override
            public Double behaviour(double[] leftArguments, double[] rightArguments) {
                return leftArguments[0] / rightArguments[0];
            }
        });

        ops.put("^", new FunctionBehaviour(2, 1, 1) {
            @Override
            public Double behaviour(double[] leftArguments, double[] rightArguments) {
                return Math.pow(leftArguments[0], rightArguments[0]);
            }
        });

        return ops;
    }
}
