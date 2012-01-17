package numeric.collatzSequence;

public class CollatzSequenceCalculator {

	public static int calc(int step, long number) {
		if (number == 1)
			return step;
		else if (number % 2 == 0)
			return calc(step + 1, number / 2);
		else
			return calc(step + 1, 3 * number + 1);
	}

	public static void main(String[] args) {
		for(int i = 1; i < 1000; i++)
			System.out.println(i + ": " + calc(0, i));
	}

}
