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
	SIN("sin", 3, new int[] {1}, new OperatorBehaviour(1) {
		@Override
		public double behaviour(double[] operands) {
			return Math.sin(operands[0]);
		}
	}),
	COS("cos", 3, new int[] {1}, new OperatorBehaviour(1) {
		@Override
		public double behaviour(double[] operands) {
			return Math.cos(operands[0]);
		}
	}),
	TAN("tan", 3, new int[] {1}, new OperatorBehaviour(1) {
		@Override
		public double behaviour(double[] operands) {
			return Math.tan(operands[0]);
		}
	}),
	ARCSIN("arcsin", 3, new int[] {1}, new OperatorBehaviour(1) {
		@Override
		public double behaviour(double[] operands) {
			return Math.asin(operands[0]);
		}
	}),
	ARCCOS("arccos", 3, new int[] {1}, new OperatorBehaviour(1) {
		@Override
		public double behaviour(double[] operands) {
			return Math.acos(operands[0]);
		}
	}),
	ARCTAN("arctan", 3, new int[] {1}, new OperatorBehaviour(1) {
		@Override
		public double behaviour(double[] operands) {
			return Math.atan(operands[0]);
		}
	}),
	LOG("log", 3, new int[] {1, 2}, new OperatorBehaviour(2) { //log(value:1, base:2)
		@Override
		public double behaviour(double[] operands) {
			return Math.log(operands[0]) / Math.log(operands[1]);
		}
	}),
	LN("ln", 3, new int[] {1},  new OperatorBehaviour(1) {
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
}