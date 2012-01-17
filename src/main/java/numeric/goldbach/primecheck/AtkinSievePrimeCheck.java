package numeric.goldbach.primecheck;

import java.util.BitSet;

import numeric.goldbach.PrimeCheck;

// TODO: conversion from int to long for indices?
public class AtkinSievePrimeCheck implements PrimeCheck {

	private BitSet primes;

	@Override
	public void init(long largestNumberToTest) {
		primes = new BitSet((int) largestNumberToTest + 1);
		primes.set(2);
		primes.set(3);
		primes.set(5);

		BitSet sieve = new BitSet((int) largestNumberToTest + 1);

		for (int i = 0; i < largestNumberToTest + 1; i++) {
			if (i % 60 == 1 || i % 60 == 13 || i % 60 == 17 || i % 60 == 29 || i % 60 == 37 || i % 60 == 41
					|| i % 60 == 49 || i % 60 == 53) {
				if (numberOfSolutionsForEqu1(i) % 2 == 1)
					sieve.flip(i);
			} else if (i % 60 == 7 || i % 60 == 19 || i % 60 == 31 || i % 60 == 43) {
				if (numberOfSolutionsForEqu2(i) % 2 == 1)
					sieve.flip(i);
			} else if (i % 60 == 11 || i % 60 == 23 || i % 60 == 47 || i % 60 == 59) {
				if (numberOfSolutionsForEqu3(i) % 2 == 1)
					sieve.flip(i);
			}
		}

		for (int i = sieve.nextSetBit(0); i < largestNumberToTest + 1 && i != -1; i = sieve.nextSetBit(i + 1)) {
			primes.set(i);
			for (long j = (long)i * i; j < largestNumberToTest + 1; j += i * i)
				sieve.clear((int)j);
		}
	}

	private int numberOfSolutionsForEqu1(int result) {
		int solutions = 0;

		for (int x = 1; result - 4 * x * x >= 0; x++) {
			int d = result - 4 * x * x;

			double y = Math.sqrt(d);
			
			if (y == Math.round(y))
				solutions++;
		}

		return solutions;
	}

	private int numberOfSolutionsForEqu2(int result) {
		int solutions = 0;

		for (int x = 1; result - 3 * x * x >= 0; x++) {
			int d = result - 3 * x * x;

			double y = Math.sqrt(d);
			
			if (y == Math.round(y))
				solutions++;
		}

		return solutions;
	}

	private int numberOfSolutionsForEqu3(int result) {
		int solutions = 0;

		for (int x = 1;; x++) {
			int d = 3 * x * x - result;

			double y = Math.sqrt(d);
			
			if (x <= y)
				break;

			if (y == Math.round(y))
				solutions++;
		}

		return solutions;
	}

	@Override
	public boolean isPrime(long number) {
		return primes.get((int) number);
	}

}
