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
	}),
	FACTORIAL("!", 3, new int[] {-1}, new OperatorBehaviour(1) {
		@Override
		public double behaviour(double[] operands) {
			int product = 1;

			for (int i = 2; i < operands[0]; i++) {
				product *= i;
			}

			return product;
		}
	});
	
	private final String SYMBOL;
	private final int PRIORITY;
	private final int[] RELATIVE_OPERAND_INDICES; // relative index of operand(s) (by Element object and not by character) from the operator itself (0 means itself)
	private final OperatorBehaviour OPERATION_BEHAVIOUR;
	
	private static final HashMap<String, Operator> OPERATOR_MAP = initOPERATOR_MAP();

	private Operator(String symbol, int priority, int[] relativeOperandIndices, OperatorBehaviour operationBehaviour) {
		this.SYMBOL = symbol;
		this.PRIORITY = priority;
		this.RELATIVE_OPERAND_INDICES = relativeOperandIndices;
		this.OPERATION_BEHAVIOUR = operationBehaviour;
	}

	private static HashMap<String, Operator> initOPERATOR_MAP() {
		Operator[] operators = Operator.values();
		HashMap<String, Operator> map = new HashMap<>();

		for (Operator o : operators) {
			map.put(o.SYMBOL, o);
		}

		return map;
	}

	public int getPRIORITY() {
		return PRIORITY;
	}

	public int[] getRELATIVE_OPERAND_INDICES() {
		return RELATIVE_OPERAND_INDICES;
	}

	public double operate(Element[] operands) {
		double[] simplifiedOperands = new double[operands.length];

		for (int i = 0; i < operands.length; i++) {
			simplifiedOperands[i] = operands[i].simplify();
		}

		return OPERATION_BEHAVIOUR.operate(simplifiedOperands);
	}

	public Operator getOperator(String symbol) {
		return OPERATOR_MAP.get(symbol);
	}

	public static boolean isOperator(String symbol) {
		return OPERATOR_MAP.get(symbol) != null;
	}
}