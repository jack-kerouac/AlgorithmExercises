package numeric.goldbach.primecheck;

import java.util.BitSet;

import numeric.goldbach.PrimeCheck;

// TODO: conversion from int to long for indices?
public class EratosthenesSievePrimeCheck implements PrimeCheck {

	private BitSet noPrime;

	@Override
	public void init(long largestNumberToTest) {
		noPrime = new BitSet((int) largestNumberToTest + 1);

		noPrime.set(0);
		noPrime.set(1);

		for (long nextPrime = 2; nextPrime < largestNumberToTest + 1; nextPrime = noPrime
				.nextClearBit((int) nextPrime + 1)) {
			for (long j = (long)Math.pow(nextPrime, 2); j < largestNumberToTest + 1; j += nextPrime) {
				noPrime.set((int) j);
			}
		}
	}

	@Override
	public boolean isPrime(long number) {
		return !noPrime.get((int) number);
	}

}
