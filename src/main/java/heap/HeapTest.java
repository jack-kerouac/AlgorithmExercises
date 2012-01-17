package heap;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class HeapTest {

	private Heap<Integer> heap;

	@Before
	public void setUp() throws Exception {
		heap = new Heap<Integer>();
	}

	@Test
	public void testGetAndRemoveMin() {
		heap.add(3);
		heap.add(2);
		heap.add(4);
		heap.add(1);
		heap.add(0);
		heap.add(9);

		assertEquals(new Integer(0), heap.getAndRemoveMin());
		assertEquals(new Integer(1), heap.getAndRemoveMin());
		assertEquals(new Integer(2), heap.getAndRemoveMin());
		assertEquals(new Integer(3), heap.getAndRemoveMin());
	}

	@Test
	public void testSort() {
		Random rand = new Random();
		Integer[] array = new Integer[1000000];
		for(int i = 0; i < 1000000; i++) {
			array[i] = rand.nextInt() % 100000000;
		}
		
		Integer[] copy = Arrays.copyOf(array, array.length);
		
		Arrays.sort(copy);
		
		Heap.heapSort(array);
		
		assertArrayEquals(copy, array);
	}
	
}
