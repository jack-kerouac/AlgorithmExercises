package numeric.goldbach;

public interface PrimeCheck {

	public void init(long largestNumberToTest);
	
	public boolean isPrime(long number);
	
}
