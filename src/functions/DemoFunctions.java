package functions;

import math.FunctionBehaviour;
import math.FunctionProvider;

import java.util.HashMap;
import java.util.Map;

public class DemoFunctions implements FunctionProvider {
    @Override
    public Map<String, FunctionBehaviour> getFunctions() {
        Map<String, FunctionBehaviour> funcs = new HashMap<>();

        funcs.put("demofunction1", new FunctionBehaviour(-1, 2, -1) {
            @Override
            public Double behaviour(double[] arguments) {
                return Math.random();
            }
        });

        funcs.put("demofunction2", new FunctionBehaviour(-1, 0, 10) {
            @Override
            public Double behaviour(double[] arguments) {
                return Math.random();
            }
        });

        funcs.put("demofunction3", new FunctionBehaviour(-1, 3) {
            @Override
            public Double behaviour(double[] arguments) {
                return Math.random();
            }
        });

        funcs.put("demofunction4", new FunctionBehaviour(-1, 1, 4) {
            @Override
            public Double behaviour(double[] arguments) {
                return Math.random();
            }
        });

        funcs.put("demofunction5", new FunctionBehaviour(-1, 0, -1) {
            @Override
            public Double behaviour(double[] arguments) {
                return Math.random();
            }
        });

        funcs.put("demofunction6", new FunctionBehaviour(-1, 0, 0) {
            @Override
            public Double behaviour(double[] arguments) {
                return Math.random();
            }
        });

        return funcs;
    }
}
