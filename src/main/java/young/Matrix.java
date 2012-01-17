package young;

import java.util.Locale;

import com.google.common.base.Preconditions;

public class Matrix {

	private final int n;
	private final int m;

	private final int[][] contents;

	/**
	 * 
	 * 
	 * @param n
	 *            number of columns
	 * @param m
	 *            number of rows
	 */
	public Matrix(int n, int m) {
		Preconditions.checkArgument(n > 0, "n must be > 0");
		Preconditions.checkArgument(m > 0, "m must be > 0");
		
		this.n = n;
		this.m = m;

		contents = new int[m][];
		for (int i = 0; i < m; i++) {
			contents[i] = new int[n];
		}

	}

	public int get(int j, int i) {
		Preconditions.checkPositionIndex(j, n-1);
		Preconditions.checkPositionIndex(i, m-1);
		return contents[i][j];
	}

	public void set(int j, int i, int value) {
		Preconditions.checkPositionIndex(j, n-1);
		Preconditions.checkPositionIndex(i, m-1);
		contents[i][j] = value;
	}

	@Override
	public String toString() {
		PaddedDecimalFormat format = PaddedDecimalFormat.getNumberInstance(4,
				Locale.getDefault());

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				builder.append(format.format(get(j, i)));
				builder.append(", ");
			}
			builder.append('\n');
		}

		return builder.toString();
	}

	public int getM() {
		return m;
	}

	public int getN() {
		return n;
	}
}
