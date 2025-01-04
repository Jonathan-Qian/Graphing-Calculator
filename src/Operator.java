import java.util.HashMap;

public enum Operator {
	ADD("+", 0, new int[] {-1, 1}, new OperatorBehaviour(2) {
		@Override
		public double behaviour(double[] operands) {
			return operands[0] + operands[1];
		}
	}),
	SUBTRACT("-", 0, new int[] {-1, 1}, new OperatorBehaviour(2) {
		@Override
		public double behaviour(double[] operands) {
			return operands[0] - operands[1];
		}
	}),
	MULTIPLY("*", 1, new int[] {-1, 1}, new OperatorBehaviour(2) {
		@Override
		public double behaviour(double[] operands) {
			return operands[0] * operands[1];
		}
	}),
	DIVIDE("/", 1, new int[] {-1, 1}, new OperatorBehaviour(2) {
		@Override
		public double behaviour(double[] operands) {
			return operands[0] / operands[1];
		}
	}),
	POWER("^", 2, new int[] {-1, 1}, new OperatorBehaviour(2) {
		@Override
		public double behaviour(double[] operands) {
			return Math.pow(operands[0], operands[1]);
		}
	}),
	EXPONENTIAL("exp", 3, new int[] {1}, new OperatorBehaviour(1) {
		@Override
		public double behaviour(double[] operands) {
			return Math.exp(operands[0]);
		}
	}),
	SQRT("sqrt", 3, new int[] {1}, new OperatorBehaviour(1) {
		@Override
		public double behaviour(double[] operands) {
			return Math.sqrt(operands[0]);
		}
	}),
	NTHROOT("nthroot", 3, new int[] {1, 2}, new OperatorBehaviour(2) { // nthroot(100, (9+5/2*nthroot(100))) // nthroot(base = 1, exponent = 2)
		@Override
		public double behaviour(double[] operands) {
			return Math.pow(operands[0], 1/operands[1]);
		}
	}),
	ABSOLUTE("abs", 3, new int[] {1}, new OperatorBehaviour(1) { // formatter will allow users to use '|' notation
		@Override
		public double behaviour(double[] operands) {
			return Math.abs(operands[0]);
		}
	}),
	SINE("sin", 3, new int[] {1}, new OperatorBehaviour(1) {
		@Override
		public double behaviour(double[] operands) {
			return Math.sin(operands[0]);
		}
	}),
	COSINE("cos", 3, new int[] {1}, new OperatorBehaviour(1) {
		@Override
		public double behaviour(double[] operands) {
			return Math.cos(operands[0]);
		}
	}),
	TANGENT("tan", 3, new int[] {1}, new OperatorBehaviour(1) {
		@Override
		public double behaviour(double[] operands) {
			return Math.tan(operands[0]);
		}
	}),
	ARCSINE("arcsin", 3, new int[] {1}, new OperatorBehaviour(1) {
		@Override
		public double behaviour(double[] operands) {
			return Math.asin(operands[0]);
		}
	}),
	ARCCOSSINE("arccos", 3, new int[] {1}, new OperatorBehaviour(1) {
		@Override
		public double behaviour(double[] operands) {
			return Math.acos(operands[0]);
		}
	}),
	ARCTANGENT("arctan", 3, new int[] {1}, new OperatorBehaviour(1) {
		@Override
		public double behaviour(double[] operands) {
			return Math.atan(operands[0]);
		}
	}),
	SECANT("sec", 3, new int[] {1}, new OperatorBehaviour(1) {
		@Override
		public double behaviour(double[] operands) {
			return 1 / Math.sin(operands[0]);
		}
	}),
	COSECANT("csc", 3, new int[] {1}, new OperatorBehaviour(1) {
		@Override
		public double behaviour(double[] operands) {
			return 1 / Math.cos(operands[0]);
		}
	}),
	COTANGENT("cot", 3, new int[] {1}, new OperatorBehaviour(1) {
		@Override
		public double behaviour(double[] operands) {
			return 1 / Math.tan(operands[0]);
		}
	}),
	LOGARITHM("log", 3, new int[] {1, 2}, new OperatorBehaviour(2) { //log(value:1, base:2)
		@Override
		public double behaviour(double[] operands) {
			return Math.log(operands[0]) / Math.log(operands[1]);
		}
	}),
	NATURAL_LOGARITHM("ln", 3, new int[] {1},  new OperatorBehaviour(1) {
		@Override
		public double behaviour(double[] operands) {
			return Math.log(operands[0]);
		}
	});
	
	private final String symbol;
	private final int priority;
	private final int[] relativeOperandIndices; // relative index of operand(s) (by Element object and not by character) from the end of the symbol string (0 means the character at the end of symbol)
	private final OperatorBehaviour operationBehaviour;
	
	private static final HashMap<String, Operator> operatorMap = initOperatorMap();

	private Operator(String symbol, int priority, int[] relativeOperandIndices, OperatorBehaviour operationBehaviour) {
		this.symbol = symbol;
		this.priority = priority;
		this.relativeOperandIndices = relativeOperandIndices;
		this.operationBehaviour = operationBehaviour;
	}

	private static HashMap<String, Operator> initOperatorMap() {
		Operator[] operators = Operator.values();
		HashMap<String, Operator> map = new HashMap<>();

		for (Operator o : operators) {
			map.put(o.symbol, o);
		}

		return map;
	}

	public int getPriority() {
		return priority;
	}

	public int[] getRelativeOperandIndices() {
		return relativeOperandIndices;
	}

	public double operate(Element[] operands) {
		double[] simplifiedOperands = new double[operands.length];

		for (int i = 0; i < operands.length; i++) {
			simplifiedOperands[i] = operands[i].simplify();
		}

		return operationBehaviour.operate(simplifiedOperands);
	}

	public static boolean isOperator(String s) {
		return operatorMap.get(s) != null;
	}
}