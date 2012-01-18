package facebook2011.pegGame;

import static facebook2011.pegGame.BoardCoordinate.bc;

public class PegGame {

	public static class Result {
		private final boolean uniqueResult;
		private final int startSlot;
		private final double probability;

		public static Result undecided() {
			return new Result(false, -1, 0.0);
		}

		public static Result decided(int startSlot, double probability) {
			return new Result(true, startSlot, probability);
		}

		private Result(boolean uniqueResult, int startSlot, double probability) {
			super();
			this.uniqueResult = uniqueResult;
			this.startSlot = startSlot;
			this.probability = probability;
		}

		public boolean isUniqueResult() {
			return uniqueResult;
		}

		public int getStartSlot() {
			return startSlot;
		}

		public double getProbability() {
			return probability;
		}

		@Override
		public String toString() {
			if (uniqueResult)
				// TODO: round probability
				return startSlot + " " + probability;
			else
				return "XXX";
		}
	}

	public Result solve(PegBoard board, int targetSlot) {
		return Result.decided(-1, calcProbability(board.getTargetSlotCoordinate(targetSlot), board));
	}

	public double calcProbability(BoardCoordinate coord, PegBoard board) {
		System.out.println("---------");
		board.printWithBall(coord);
		if (coord.isTopRow(board)) {
			return 1.0;
		} else if (coord.isLeftBorder(board)) {
			return 0.5 * calcProbability(coord.rightAbove(), board);

		} else if (coord.isRightBorder(board)) {
			return 0.5 * calcProbability(coord.leftAbove(), board);

		} else {
			return 0.5 * calcProbability(coord.leftAbove(), board) + 0.5 * calcProbability(coord.rightAbove(), board);
		}
	}

	public BoardProbabilities solveDown(int startSlot, PegBoard board) {
		BoardProbabilities propabilities = new BoardProbabilities(board.getRows(), board.getColumns() - 1);
		calcProbabilityDown(bc(0, startSlot), 1.0, board, propabilities);
		return propabilities;
	}

	public void calcProbabilityDown(BoardCoordinate coord, double probability, PegBoard board,
			BoardProbabilities probabilities) {
//		System.out.println("---------");
//		board.printWithBall(coord);

		probabilities.addToProbability(coord, probability);

		if (coord.isBottomRow(board))
			return;

		if (!board.hasMissingPeg(coord.below())) {
			if (coord.isLeftBorder(board)) {
				calcProbabilityDown(coord.rightBelow(), 1.0 * probability, board, probabilities);

			} else if (coord.isRightBorder(board)) {
				calcProbabilityDown(coord.leftBelow(), 1.0 * probability, board, probabilities);

			} else {
				calcProbabilityDown(coord.leftBelow(), 0.5 * probability, board, probabilities);
				calcProbabilityDown(coord.rightBelow(), 0.5 * probability, board, probabilities);
			}
		} else {
			probabilities.addToProbability(coord.below(), probability);
			calcProbabilityDown(coord.below().below(), 1.0 * probability, board, probabilities);
		}
	}
	
	public void calcBestStartSlotFor(int targetSlot, PegBoard board) {
		int bestStartSlot = 0;
		double bestProbability = -1.0;
		for(int startSlot = 0; startSlot < board.getColumns() - 1; startSlot++) {
			BoardProbabilities probabilities = solveDown(startSlot, board);
			double probOfBallInTargetSlot = probabilities.getPropability(bc(board.getRows() - 1, targetSlot));
			if(probOfBallInTargetSlot == bestProbability) {
				// UNDECIDED
				bestStartSlot = -1;
			}
			if(probOfBallInTargetSlot > bestProbability) {
				bestProbability = probabilities.getPropability(bc(board.getRows() - 1, targetSlot));
				bestStartSlot = startSlot;
			}
		}
		
		if(bestStartSlot == -1)
			System.out.println("XXX");
		else
			System.out.println(bestStartSlot + " " + bestProbability);
	}
	

	public static void main(String[] args) {
		PegGame game = new PegGame();
		PegBoard board = new PegBoard(3, 4);
		board.setMissingPeg(1, 0);
		game.solveDown(0, board);
	}

}
