package facebook2011.pegGame;

public class BoardCoordinate {

	private final int row;
	private final int column;

	public static BoardCoordinate bc(int row, int column) {
		return new BoardCoordinate(row, column);
	}

	public BoardCoordinate(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public BoardCoordinate leftBelow() {
		if (row % 2 == 0)
			return bc(row + 1, column);
		else
			return bc(row + 1, column - 1);
	}

	public BoardCoordinate rightBelow() {
		if (row % 2 == 0)
			return bc(row + 1, column + 1);
		else
			return bc(row + 1, column);
	}

	public BoardCoordinate leftAbove() {
		if (row % 2 == 0)
			return bc(row - 1, column);
		else
			return bc(row - 1, column - 1);
	}

	public BoardCoordinate rightAbove() {
		if (row % 2 == 0)
			return bc(row - 1, column + 1);
		else
			return bc(row - 1, column);
	}
	
	public BoardCoordinate below() {
		return bc(row + 1, column);
	}

	public boolean isTopRow(PegBoard board) {
		return row == 0;
	}

	public boolean isBottomRow(PegBoard board) {
		return row == board.getRows() - 1;
	}

	public boolean isLeftBorder(PegBoard board) {
		return column == 0;
	}

	public boolean isRightBorder(PegBoard board) {
		if (row % 2 == 0)
			return column == board.getColumns() - 2;
		else
			return column == board.getColumns() - 1;
	}

	@Override
	public String toString() {
		return "(" + row + "," + column + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardCoordinate other = (BoardCoordinate) obj;
		if (column != other.column)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

}
