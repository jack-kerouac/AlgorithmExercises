package young;

public class YoungTableau {

	private final Matrix matrix;

	private YoungTableau(int n, int m) {
		matrix = new Matrix(n, m);
	}

	interface AddToValue {
		int value();
	}

	/**
	 * Only works for n == m right now!
	 * 
	 * @param n
	 * @param m
	 * @param variance
	 * @return
	 */
	public static YoungTableau create(int n, int m, AddToValue adder) {
		YoungTableau tab = new YoungTableau(n, m);
		Matrix matrix = tab.matrix;

		// upper triangle
		for (int startRow = 0; startRow < m; startRow++) {
			for (int i = startRow; i >= 0; i--) {
				int j = startRow - i;
				if (j >= n)
					break;
				matrix.set(j, i, maxOfLeftAndTop(j, i, matrix) + adder.value());
			}
		}

		// lower triangle
		for (int startColumn = 1; startColumn < n; startColumn++) {
			for (int j = startColumn; j < n; j++) {
				int i = m - 1 - (j - startColumn);
				if(i < 0)
					break;
				matrix.set(j, i, maxOfLeftAndTop(j, i, matrix) + adder.value());
			}
		}

		return tab;
	}

	private static int maxOfLeftAndTop(int j, int i, Matrix matrix) {
		if (j == 0 && i == 0)
			return 0;

		if (j == 0)
			return matrix.get(0, i - 1);
		if (i == 0)
			return matrix.get(j - 1, 0);

		return Math.max(matrix.get(j - 1, i), matrix.get(j, i - 1));
	}

	@Override
	public String toString() {
		return matrix.toString();
	}

	public static void main(String[] args) {
		YoungTableau tab = YoungTableau.create(10, 10, new AddToValue() {
			@Override
			public int value() {
				return 1;
			}
		});
		System.out.println(tab);
		System.out.println("1: " + tab.containsValue(1));
		System.out.println("2: " + tab.containsValue(2));
		System.out.println("3: " + tab.containsValue(3));
		System.out.println("9: " + tab.containsValue(9));
		System.out.println("10: " + tab.containsValue(10));
	}

	public boolean containsValue(int value) {
		int m = matrix.getM();
		int n = matrix.getN();

		int i = m - 1;
		int j = 0;
		while (j < n && i >= 0) {
			int current = matrix.get(j, i);
			if (current == value)
				return true;
			else if (current < value) {
				j++;
			} else {
				i--;
			}
		}
		return false;
	}
}
