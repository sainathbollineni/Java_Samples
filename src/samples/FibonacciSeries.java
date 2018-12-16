package samples;

public class FibonacciSeries {
	static int n1 = 0, n2 = 1;
	static int n3;

	public static void main(String args[]) {
		System.out.print(n1 + " " + n2);
		fibonacciSeries(10);

		System.out.println();

		n1 = 0;
		n2 = 1;

		System.out.print(n1 + " " + n2);

		fibonacciSeriesRecursion(10 - 2);

	}

	public static void fibonacciSeries(int n) {

		for (int i = 2; i < n; i++) {
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
			System.out.print(" " + n3);
		}
	}

	public static void fibonacciSeriesRecursion(int n) {

		if (n > 0) {
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
			System.out.print(" " + n3);
			fibonacciSeriesRecursion(n - 1);
		}
	}
}