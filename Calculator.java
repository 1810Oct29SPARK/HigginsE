public class Calculator {

	public static double add(double arg0, double arg1) {
		return arg0 + arg1;
	}

	public static double subtract(double arg0, double arg1) {
		return arg0 - arg1;
	}

	public static double multiply(double arg0, double arg1) {
		return arg0 * arg1;
	}

	public static double divide(double arg0, double arg1) {
		if (arg1 == 0){return Double.POSITIVE_INFINITY;}
		return arg0 / arg1;
	}
}
