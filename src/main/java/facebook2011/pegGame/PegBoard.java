package facebook2011.pegGame;

public class PegBoard {

	private boolean[][] missingPegs;

	public PegBoard(int rows, int columns) {
		missingPegs = new boolean[rows][columns];
	}

	public void setMissingPeg(int row, int column) {
		missingPegs[row][column] = true;
	}

	public boolean hasMissingPeg(BoardCoordinate coord) {
		return hasMissingPeg(coord.getRow(), coord.getColumn());
	}

	public boolean hasMissingPeg(int row, int column) {
		return missingPegs[row][column];
	}

	public void print() {
		for (int r = 0; r < getRows(); r++) {
			String line = "";
			if (r % 2 == 1)
				line += " ";
			for (int c = 0; c < getColumns() - (r % 2); c++) {
				if (!hasMissingPeg(r, c))
					line += "x";
				else
					line += ".";
				line += " ";
			}
			System.out.println(line.substring(0, line.length() - 1));
		}

	}

	public void printWithBall(BoardCoordinate ballCoord) {
		for (int r = 0; r < getRows(); r++) {
			String line = "";
			if (r % 2 == 1)
				line += " ";
			for (int c = 0; c < getColumns() - (r % 2); c++) {
				if (!hasMissingPeg(r, c))
					line += "x";
				else
					line += ".";

				if (r == ballCoord.getRow() && c == ballCoord.getColumn() - (r % 2))
					line += "o";
				else
					line += " ";
			}
			System.out.println(line.substring(0, line.length() - 1));
		}

	}

	public int getRows() {
		return missingPegs.length;
	}

	public int getColumns() {
		return missingPegs[0].length;
	}

	public BoardCoordinate getTargetSlotCoordinate(int targetSlot) {
		return new BoardCoordinate(getRows() - 1, targetSlot);
	}

}
