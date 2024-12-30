import java.util.HashMap;

public enum Operator {
	ADD("+", new int[] {-1, 1}, new OperatorBehaviour(2) {
		@Override
		public double behaviour(double[] operands) {
			return operands[0] + operands[1];
		}
	}),
	SUBTRACT("-", new int[] {-1, 1}, new OperatorBehaviour(2) {
		@Override
		public double behaviour(double[] operands) {
			return operands[0] - operands[1];
		}
	}),
	MULTIPLY("*", new int[] {-1, 1}, new OperatorBehaviour(2) {
		@Override
		public double behaviour(double[] operands) {
			return operands[0] * operands[1];
		}
	}),
	DIVIDE("/", new int[] {-1, 1}, new OperatorBehaviour(2) {
		@Override
		public double behaviour(double[] operands) {
			return operands[0] / operands[1];
		}
	}),
	POWER("^", new int[] {-1, 1}, new OperatorBehaviour(2) {
		@Override
		public double behaviour(double[] operands) {
			return Math.pow(operands[0], operands[1]);
		}
	}),
	NTHROOT("nthroot", new int[] {1, 2}, new OperatorBehaviour(2) { // nthroot(100, (9+5/2*nthroot(100))) // nthroot(base = 1, exponent = 2)
		@Override
		public double behaviour(double[] operands) {
			return Math.pow(operands[0], 1/operands[1]);
		}
	}),
	ABSOLUTE("|", new int[] {1}, new OperatorBehaviour(1) {
		@Override
		public double behaviour(double[] operands) {
			return Math.abs(operands[0]);
		}
	}),
	SIN("sin", new int[] {1}, new OperatorBehaviour(1) {
		@Override
		public double behaviour(double[] operands) {
			return Math.sin(operands[0]);
		}
	}),
	COS("cos", new int[] {1}, new OperatorBehaviour(1) {
		@Override
		public double behaviour(double[] operands) {
			return Math.cos(operands[0]);
		}
	}),
	TAN("tan", new int[] {1}, new OperatorBehaviour(1) {
		@Override
		public double behaviour(double[] operands) {
			return Math.tan(operands[0]);
		}
	}),
	ARCSIN("arcsin", new int[] {1}, new OperatorBehaviour(1) {
		@Override
		public double behaviour(double[] operands) {
			return Math.asin(operands[0]);
		}
	}),
	ARCCOS("arccos", new int[] {1}, new OperatorBehaviour(1) {
		@Override
		public double behaviour(double[] operands) {
			return Math.acos(operands[0]);
		}
	}),
	ARCTAN("arctan", new int[] {1}, new OperatorBehaviour(1) {
		@Override
		public double behaviour(double[] operands) {
			return Math.atan(operands[0]);
		}
	}),
	LOG("log", new int[] {1, 2}, new OperatorBehaviour(2) { //log(value:1, base:2)
		@Override
		public double behaviour(double[] operands) {
			return Math.log(operands[0]) / Math.log(operands[1]);
		}
	}),
	LN("ln", new int[] {1},  new OperatorBehaviour(1) {
		@Override
		public double behaviour(double[] operands) {
			return Math.log(operands[0]);
		}
	});
	
	final OperatorBehaviour operationBehaviour;
	final String symbol;
	final int[] relativeOperandIndices; // relative index of operand(s) (by Element object and not by character) from the end of the symbol string (0 means the character at the end of symbol)
	
	private static final HashMap<String, Operator> operatorMap = initOperatorMap();

	private Operator(String symbol, int[] relativeOperandIndices, OperatorBehaviour operationBehaviour) {
		this.operationBehaviour = operationBehaviour;
		this.symbol = symbol;
		this.relativeOperandIndices = relativeOperandIndices;
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