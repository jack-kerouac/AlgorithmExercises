package numeric.fib;

public class FibCalc {

	public static void main(String[] args) {
		FibCalc fc = new FibCalc();
		for (int i = 0; i < 10; i++)
			System.out.println(i + ": " + fc.fib(i));
	}

	public int fib(int number) {
		int[] fibs = new int[number + 1];
		if (number == 0)
			return 1;

		fibs[0] = 1;
		fibs[1] = 1;

		for (int i = 2; i <= number; i++) {
			fibs[i] = fibs[i - 2] + fibs[i - 1];
		}

		return fibs[number];
	}

}
