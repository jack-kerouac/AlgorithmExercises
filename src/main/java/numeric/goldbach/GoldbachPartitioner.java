package numeric.goldbach;

import java.util.Collection;
import java.util.LinkedList;

import numeric.goldbach.primecheck.OptimizedEratosthenesSievePrimeCheck;

import com.google.common.base.Preconditions;

public class GoldbachPartitioner {

	public static Collection<GoldbachPartition> calculatePartitions(long number) {
		Preconditions.checkArgument(number % 2 == 0, "input must be an even number");

		Collection<GoldbachPartition> partitions = new LinkedList<GoldbachPartition>();

		if (isPrime(number - 2))
			partitions.add(new GoldbachPartition(2, number - 2));

		
		for (long l = 3; l <= number / 2; l += 2) {
			long l1 = l;
			long l2 = number - l;

			if (isPrime(l1) && isPrime(l2))
				partitions.add(new GoldbachPartition(l1, l2));
		}

		return partitions;
	}
	
	public static void init(long numberToPartition) {
		primeCheck.init(numberToPartition);
	}
	
	private static PrimeCheck primeCheck = new OptimizedEratosthenesSievePrimeCheck();

	private static boolean isPrime(long number) {
		return primeCheck.isPrime(number);
	}

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		long numberToPartition = Long.valueOf(args[0]);
		init(numberToPartition);
		long initOverTime = System.currentTimeMillis();
		System.out.println("init over: " + (initOverTime - startTime) + " ms");

		Collection<GoldbachPartition> calculatePartitions = calculatePartitions(numberToPartition);
		
		System.out.println("calc: " + (System.currentTimeMillis() - initOverTime) + " ms");
		
		System.out.println("number of partitions: " + calculatePartitions.size());
	}
}
