
public class Eval {
	
	

	public static void f(String digits, long goal) {
		long somma = 0;
		for (int i = 1; i <= digits.length(); i++) {
			String currentSequence = digits.substring(0, i);
			iterate(somma, Long.parseLong(currentSequence), digits.substring(i), goal, currentSequence);
		}
	}
	
	private static void iterate(long somma, long prev, String digits, long goal, String operation) {
		if (digits.isEmpty()) {
			if (goalReached(somma, prev, goal)) {
				printResult(goal, operation);
			}
		} else {
			for (int i = 1; i <= digits.length(); i++) {
				long current = Long.parseLong(digits.substring(0, i));
				String remaining = digits.substring(i);
				iterate(somma + prev, current, remaining, goal, getSum(operation, current));
				iterate(somma, prev * current, remaining, goal, getMult(operation, current));
				iterate(somma, prev / current, remaining, goal, getDiv(operation, current));
				iterate(somma + prev, -current, remaining, goal, getSub(operation, current));
			}
		}
	}

	private static String getSub(String operation, long current) {
		return operation + " - " + current;
	}

	private static String getDiv(String operation, long current) {
		return operation + " / " + current;
	}

	private static String getMult(String operation, long current) {
		return operation + " * " + current;
	}

	private static String getSum(String operation, long current) {
		return operation + " + " + current;
	}

	private static void printResult(long goal, String expr) {
		System.out.println(expr + " = " + goal);
	}

	private static boolean goalReached(long somma, long prev, long target) {
		return somma + prev == target;
	}

	public static void main(String[] args) {
		Eval.f("314159265358", 27182);
	}
}
