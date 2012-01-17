package parallel_merge;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class ParallelMergeSortTest {

	private ParallelMergeSort sorter;

	private int[] array;
	private int[] sorted;

	@Before
	public void setUp() throws Exception {
		sorter = new ParallelMergeSort(2);
		int size = 10000000;
		array = new int[size];

		// FILL ARRAY
		Random rand = new Random();
		for (int i = 0; i < size; i++) {
			array[i] = rand.nextInt();
		}

		// make copy
		sorted = Arrays.copyOf(array, array.length);
		Arrays.sort(sorted);
	}

	@Test
	public void testMergeSort() {
		array = sorter.mergeSort(array);

		org.junit.Assert.assertArrayEquals(sorted, array);
	}

}
