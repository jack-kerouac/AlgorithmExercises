package quicksort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QuickSorter {

	public List<Integer> quicksort(List<Integer> toSort) {
		if (toSort.size() <= 1)
			return toSort;

		int pivot = toSort.remove(0);

		List<Integer> smaller = new LinkedList<Integer>();
		List<Integer> larger = new LinkedList<Integer>();

		for (Integer elem : toSort) {
			if (elem < pivot)
				smaller.add(elem);
			else
				larger.add(elem);
		}

		smaller = quicksort(smaller);
		larger = quicksort(larger);

		List<Integer> result = new ArrayList<Integer>(toSort.size());
		result.addAll(smaller);
		result.add(pivot);
		result.addAll(larger);

		return result;
	}

	public static void main(String[] args) {
		System.out.println(new QuickSorter().quicksort(new ArrayList<Integer>(
				Arrays.asList(7, 3, 5, 1, 9, 8, 6, 4, 2))));
	}

}
