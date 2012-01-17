package numeric.goldbach.primecheck;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AtkinSievePrimeCheckTest {

	private AtkinSievePrimeCheck check = new AtkinSievePrimeCheck();

	@Before
	public void init() {
		check.init(20);
	}

	@Test
	public void testPrimes() {
		assertTrue(check.isPrime(2));
		assertTrue(check.isPrime(3));
		assertTrue(check.isPrime(5));
		assertTrue(check.isPrime(7));
		assertTrue(check.isPrime(11));
		assertTrue(check.isPrime(13));
		assertTrue(check.isPrime(17));
		assertTrue(check.isPrime(19));

		assertFalse(check.isPrime(0));
		assertFalse(check.isPrime(1));
		assertFalse(check.isPrime(4));
		assertFalse(check.isPrime(6));
		assertFalse(check.isPrime(8));
		assertFalse(check.isPrime(9));
		assertFalse(check.isPrime(10));
		assertFalse(check.isPrime(12));
		assertFalse(check.isPrime(14));
		assertFalse(check.isPrime(15));
		assertFalse(check.isPrime(16));
		assertFalse(check.isPrime(18));
		assertFalse(check.isPrime(20));
	}

}
