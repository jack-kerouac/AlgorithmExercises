package parallel_merge;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelMergeSort {

	long starttime;

	private ExecutorService service;
	private final int threads;

	public ParallelMergeSort(int threads) {
		this.threads = threads;
		service = Executors.newFixedThreadPool(threads);
	}

	public int[] mergeSort(int[] array) {
		starttime = System.currentTimeMillis();
		return mergeSort(array, 0, array.length, 0);
	}

	private int[] mergeSort(int[] array, int lower, int upper, int level) {
		if ((upper - lower) == 0)
			return new int[] {};
		if ((upper - lower) == 1)
			return new int[] { array[lower] };

		level++;

		// calc in parallel
		if (level == (Math.log(threads) / Math.log(2))) {
			Future<int[]> first = service.submit(new Merger(array, lower, lower
					+ (upper - lower) / 2, level));
			Future<int[]> second = service.submit(new Merger(array, lower
					+ (upper - lower) / 2, upper, level));

			try {
				int[] merged = merge(first.get(), second.get());
				return merged;
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			} catch (ExecutionException e) {
				throw new RuntimeException(e);
			}
		}
		// calc serially
		else {
			int[] first = mergeSort(array, lower, lower + (upper - lower) / 2,
					level);
			int[] second = mergeSort(array, lower + (upper - lower) / 2, upper,
					level);
			int[] merged = merge(first, second);
			return merged;
		}
	}

	class Merger implements Callable<int[]> {

		private int[] array;
		private int lower, upper;
		private final int level;

		public Merger(int[] array, int lower, int upper, int level) {
			super();
			this.array = array;
			this.lower = lower;
			this.upper = upper;
			this.level = level;
		}

		@Override
		public int[] call() throws Exception {
			long startTimeLocal;
			startTimeLocal = System.currentTimeMillis();
			System.out.println("Thread " + Thread.currentThread().getName()
					+ ": level: " + level + ", lower: " + lower + " upper: "
					+ upper + ", time: "
					+ (System.currentTimeMillis() - starttime));
			int[] ret = mergeSort(array, lower, upper, level);
			System.out.println("Thread " + Thread.currentThread().getName()
					+ ": finished after "
					+ (System.currentTimeMillis() - startTimeLocal) + " ms");

			return ret;
		}

	}

	private int[] merge(int[] first, int[] second) {
		int[] ret = new int[first.length + second.length];
		int i, j;
		for (i = 0, j = 0; i < first.length && j < second.length;) {
			if (first[i] <= second[j]) {
				ret[i + j] = first[i];
				i++;
			} else {
				ret[i + j] = second[j];
				j++;
			}
		}
		// merge all remaining of first
		if (i != first.length) {
			for (int k = i; k < first.length; k++) {
				ret[k + second.length] = first[k];
			}
			return ret;
		}

		// merge all remaining of second
		if (j != second.length) {
			for (int k = j; k < second.length; k++) {
				ret[k + first.length] = second[k];
			}
		}

		return ret;
	}

}
