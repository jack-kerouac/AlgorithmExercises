package facebook2011.pegGame;


public class BoardProbabilities {

	private double[][] probability;

	public BoardProbabilities(int rows, int columns) {
		probability = new double[rows][columns];
	}

	public void addToProbability(BoardCoordinate coord, double p) {
		probability[coord.getRow()][coord.getColumn()] += p;
	}

	public double getPropability(BoardCoordinate coord) {
		return probability[coord.getRow()][coord.getColumn()];
	}

	public void printRow(int row) {
		String line = "";
		for (int c = 0; c < probability[0].length; c++) {
			line += probability[row][c] + " ";
		}
		System.out.println(line);
	}

	public void verifyRow(int row) {
		double total = 0.0;
		for (int c = 0; c < probability[0].length; c++)
			total += probability[row][c];
		if (total != 1.0)
			throw new RuntimeException("sum should be 1.0, but was " + total);
	}

}
