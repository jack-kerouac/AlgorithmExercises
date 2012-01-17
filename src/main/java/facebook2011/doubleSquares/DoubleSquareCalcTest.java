package facebook2011.doubleSquares;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

public class DoubleSquareCalcTest {

	@Test
	public void testNumberOfDoubleSquares() {
		DoubleSquareCalc c = new DoubleSquareCalc();
		c.init();

		assertEquals(1, c.numberOfDoubleSquares(5));
		assertEquals(1, c.numberOfDoubleSquares(10));
		assertEquals(2, c.numberOfDoubleSquares(25));
		assertEquals(0, c.numberOfDoubleSquares(3));
		assertEquals(1, c.numberOfDoubleSquares(0));
		assertEquals(1, c.numberOfDoubleSquares(1));

		assertEquals(2, c.numberOfDoubleSquares(2074));
		assertEquals(2, c.numberOfDoubleSquares(4097));
		assertEquals(1, c.numberOfDoubleSquares(512));
		assertEquals(1, c.numberOfDoubleSquares(105258141));
		assertEquals(0, c.numberOfDoubleSquares(1851932289));
		assertEquals(0, c.numberOfDoubleSquares(992636323));
		assertEquals(4, c.numberOfDoubleSquares(1416573205));
		assertEquals(12, c.numberOfDoubleSquares(1409933825));
	}

	@Test
	public void testNumberOfDoubleSquaresPerformance1() {
		DoubleSquareCalc c = new DoubleSquareCalc();
		c.init();

		for (int i = 0; i < 10; i++) {
			assertEquals(1, c.numberOfDoubleSquares(105258141));
		}
	}

	@Test
	public void testNumberOfDoubleSquaresPerformance2() {
		DoubleSquareCalc c = new DoubleSquareCalc();
		c.init();

		Random r = new Random();

		for (int i = 0; i < 1000; i++) {
			int n = r.nextInt(2147483647) + 1;
			System.out.println(i + ": for " + n + " I found " + c.numberOfDoubleSquares(n) + " solutions");
		}
	}
}
