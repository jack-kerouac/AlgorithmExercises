package facebook2011.doubleSquares;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public final class DoubleSquareCalc {

	class Tester implements Callable<Integer> {

		private final int lower, upper;
		private final int number;

		public Tester(int lower, int upper, int number) {
			super();
			this.lower = lower;
			this.upper = upper;
			this.number = number;
		}

		@Override
		public Integer call() throws Exception {
			int solutions = 0;

			for (int x = lower; x < upper; x++) {
				int missing = number - sqr(x);
				if (isInt(Math.sqrt(missing)))
					solutions++;
			}
			return solutions;
		}

	}

	private ExecutorService service = Executors.newFixedThreadPool(2);

	private int[] squares;

	private final int sqr(final int n) {
		return squares[n];
	}

	public final void init() {
		squares = new int[(int) Math.sqrt(2147483647)];
		for (int i = 0; i < squares.length; i++)
			squares[i] = (int) Math.pow(i, 2);
	}

	private final boolean isInt(double d) {
		return Math.floor(d) == d;
	}

	// http://www.wolframalpha.com/input/?i=integer+solution+for+61+%3D+x^2+%2B+y^2%2C+x+%3E0%2C+y+%3E+0%2C+x+%3C%3D+y
	public final int numberOfDoubleSquares(int number) {
		int end = (int) Math.sqrt(number / 2) + 1;

		final int threads = 4;

		Future<Integer>[] futures = new Future[threads];
		for (int t = 0; t < threads; t++) {
			futures[t] = service.submit(new Tester((int) (t / (double) threads * end), (int) ((t + 1)
					/ (double) threads * end), number));
		}

		try {
			int solutions = 0;
			for(Future<Integer> f : futures) {
				solutions += f.get();
			}
			return solutions;
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} catch (ExecutionException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) throws IOException {
		long time = System.nanoTime();

		DoubleSquareCalc c = new DoubleSquareCalc();
		c.init();
		// System.out.println("init done after " + ((System.nanoTime() - time) /
		// 1000000) + " ms");

		File input = new File(args[0]);
		BufferedReader reader = new BufferedReader(new FileReader(input));

		String numberOfNumbers = reader.readLine();
		System.out.println("number of numbers: " + numberOfNumbers);

		for (String line = reader.readLine(); line != null; line = reader.readLine()) {
			System.out.println(c.numberOfDoubleSquares(Integer.valueOf(line)));
		}

		// System.out.println("done after " + ((System.nanoTime() - time) /
		// 1000000) + " ms");
	}
}