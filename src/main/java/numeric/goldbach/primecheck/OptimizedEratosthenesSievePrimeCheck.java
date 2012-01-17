package numeric.goldbach.primecheck;

import java.util.BitSet;

import numeric.goldbach.PrimeCheck;

// TODO: conversion from int to long for indices?
public class OptimizedEratosthenesSievePrimeCheck implements PrimeCheck {

	private BitSet noPrime;

	@Override
	public void init(long largestNumberToTest) {
		noPrime = new BitSet((int) (largestNumberToTest - 1) / 2);

		for (long nextPrime = 3; nextPrime < largestNumberToTest + 1; nextPrime = indexToNumber(noPrime
				.nextClearBit(numberToIndex(nextPrime + 1)))) {
			for (long j = (long) nextPrime * nextPrime; j < largestNumberToTest + 1; j += nextPrime * 2) {
				noPrime.set(numberToIndex(j));
			}
		}
	}

	private int numberToIndex(long number) {
		return (int) (number / 2 - 1);
	}

	private long indexToNumber(int index) {
		return index * 2 + 3;
	}

	@Override
	public boolean isPrime(long number) {

		return !noPrime.get(numberToIndex(number));
	}

}
