package facebook2011.pegGame;

import static org.junit.Assert.*;

import org.junit.Test;

import static facebook2011.pegGame.BoardCoordinate.bc;

public class BoardCoordinateTest {

	@Test
	public void test() {
		PegBoard board = new PegBoard(3, 3);

		assertTrue(bc(0, 0).isTopRow(board));
		assertTrue(bc(0, 1).isTopRow(board));
		assertTrue(bc(0, 2).isTopRow(board));

		assertEquals(bc(2, 0), bc(1, 1).leftBelow());
		assertEquals(bc(1, 1), bc(0, 1).leftBelow());
		assertEquals(bc(0, 0), bc(1, 1).leftAbove());
		assertEquals(bc(1, 1), bc(2, 1).leftAbove());

		assertEquals(bc(2, 1), bc(1, 1).rightBelow());
		assertEquals(bc(1, 3), bc(0, 2).rightBelow());
		assertEquals(bc(0, 1), bc(1, 1).rightAbove());
		assertEquals(bc(1, 3), bc(2, 2).rightAbove());
		assertEquals(bc(1, 1), bc(2, 0).rightAbove());

		assertTrue(bc(0, 0).isLeftBorder(board));
		assertTrue(bc(1, 0).isLeftBorder(board));
		assertTrue(bc(2, 0).isLeftBorder(board));

		assertTrue(bc(0, 1).isRightBorder(board));
		assertFalse(bc(1, 1).isRightBorder(board));
		assertTrue(bc(2, 1).isRightBorder(board));
	}
}
