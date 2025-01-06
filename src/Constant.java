import java.util.HashMap;

public enum Constant {
    E("e", Math.E),
    PI("pi", Math.PI),
    TAU("tau", Math.TAU);

    private final String SYMBOL;
    private final double VALUE;

    private static final HashMap<String, Constant> CONSTANT_MAP = initCONSTANT_MAP();

    private Constant(String symbol, double value) {
        this.SYMBOL = symbol;
		this.VALUE = value;
	}

    private static HashMap<String, Constant> initCONSTANT_MAP() {
        Constant[] constants = Constant.values();
		HashMap<String, Constant> map = new HashMap<>();

		for (Constant c : constants) {
			map.put(c.SYMBOL, c);
		}

		return map;
    }

    public double getConstantValue(String symbol) {
        return CONSTANT_MAP.get(symbol).VALUE;
    }
}