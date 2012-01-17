package facebook2011.pegGame;

import static org.junit.Assert.*;

import org.junit.Test;

public class PegBoardTest {

	@Test
	public void test() {
		PegBoard board = new PegBoard(6, 5);
		board.setMissingPeg(1, 1);
		board.setMissingPeg(2, 1);
		board.setMissingPeg(3, 2);

		assertEquals(6, board.getRows());
		assertEquals(5, board.getColumns());
		assertTrue(board.hasMissingPeg(1, 1));
		assertTrue(board.hasMissingPeg(2, 1));
		assertTrue(board.hasMissingPeg(3, 2));

		board.print();
	}

}
