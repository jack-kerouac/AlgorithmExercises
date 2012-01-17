package numeric.goldbach.primecheck;

import numeric.goldbach.PrimeCheck;

public class NaivePrimeCheck implements PrimeCheck {

	@Override
	public void init(long largestNumberToTest) {
		// nothing needs to be done
	}
	
	@Override
	public boolean isPrime(long number) {
		for (long test = 2; test < (long)Math.sqrt(number) + 1; test++)
			if (number % test == 0)
				return false;
		return true;
	}

}
