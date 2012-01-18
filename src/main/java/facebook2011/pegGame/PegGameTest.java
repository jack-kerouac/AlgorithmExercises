package facebook2011.pegGame;

import static org.junit.Assert.*;

import org.junit.Test;

import facebook2011.pegGame.PegGame.Result;
import static facebook2011.pegGame.BoardCoordinate.bc;

public class PegGameTest {

	PegGame game = new PegGame();

//	@Test
//	public void testSimple3x4() {
//		PegBoard board = new PegBoard(3, 4);
//		board.setMissingPeg(1, 0);
//		BoardProbabilities probabilities = game.solveDown(0, board);
//	}

	// FB: Big example
	@Test
	public void test5x5() {
		PegBoard board = new PegBoard(5, 5);
		board.setMissingPeg(1, 1);
		board.setMissingPeg(2, 1);
		board.setMissingPeg(3, 2);
		game.calcBestStartSlotFor(0, board);
	}

	// FB: Example 1
	@Test
	public void test5x4() {
		PegBoard board = new PegBoard(5, 4);
		board.setMissingPeg(2, 2);
		game.calcBestStartSlotFor(0, board);
	}

	// FB: Example 2
	@Test
	public void test3x4() {
		PegBoard board = new PegBoard(3, 4);
		board.setMissingPeg(1, 0);
		board.printWithBall(bc(2, 1));
		game.calcBestStartSlotFor(1, board);
	}

	// FB: Example 3
	@Test
	public void test3x3() {
		PegBoard board = new PegBoard(3, 3);
		board.setMissingPeg(1, 1);
		board.setMissingPeg(1, 0);
		game.calcBestStartSlotFor(1, board);
	}

	// FB: Example 4
	@Test
	public void test3x4_2() {
		PegBoard board = new PegBoard(3, 4);
		board.setMissingPeg(1, 0);
		board.setMissingPeg(1, 1);
		game.calcBestStartSlotFor(0, board);
	}

	// FB: Example 5
	@Test
	public void test3x4_3() {
		PegBoard board = new PegBoard(3, 4);
		board.setMissingPeg(1, 1);
		game.calcBestStartSlotFor(0, board);
	}

}
