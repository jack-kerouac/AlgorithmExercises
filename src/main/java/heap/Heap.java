package heap;

import java.util.ArrayList;
import java.util.List;

public class Heap<E extends Comparable<E>> implements PriorityQueue<E> {

	private final List<E> heap;

	public Heap() {
		heap = new ArrayList<E>();
	}

	@Override
	public void add(E element) {
		heap.add(element);

		bubbleUp(parent(lastPos()));
	}

	private void bubbleUp(int position) {
		int minPos = minOfTriangle(position);

		if (minPos != position)
			swap(position, minPos);

		if (position == 0) {
			return;
		} else {
			bubbleUp(parent(position));
		}
	}

	private int parent(int position) {
		return (position - 1) / 2;
	}

	private int leftChild(int position) {
		return position * 2 + 1;
	}

	private int rightChild(int position) {
		return position * 2 + 2;
	}

	private int lastPos() {
		return heap.size() - 1;
	}

	private int minOfTriangle(int parent) {
		E min = heap.get(parent);
		int minPos = parent;
		if (leftChild(parent) <= lastPos()
				&& heap.get(leftChild(parent)).compareTo(min) < 0) {
			min = heap.get(leftChild(parent));
			minPos = leftChild(parent);
		}
		if (rightChild(parent) <= lastPos()
				&& heap.get(rightChild(parent)).compareTo(min) < 0) {
			min = heap.get(rightChild(parent));
			minPos = rightChild(parent);
		}
		return minPos;
	}

	private void swap(int i, int j) {
		E tmp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, tmp);
	}

	@Override
	public E getAndRemoveMin() {
		E min = heap.get(0);

		// move last element up
		E newTop = heap.get(lastPos());
		heap.set(0, newTop);
		heap.remove(lastPos());

		if (!heap.isEmpty())
			bubbleDown(0);

		return min;
	}

	private void bubbleDown(int position) {
		int minPos = minOfTriangle(position);
		if (minPos != position) {
			swap(position, minPos);
			if (leftChild(position) == minPos && leftChild(position) <= lastPos())
				bubbleDown(leftChild(position));
			if (rightChild(position) == minPos && rightChild(position) <= lastPos())
				bubbleDown(rightChild(position));
		}
	}

	public static <E extends Comparable<E>> void heapSort(E[] toSort) {
		Heap<E> heap = new Heap<E>();
		for (int i = 0; i < toSort.length; i++) {
			heap.add(toSort[i]);
		}

		for (int i = 0; i < toSort.length; i++) {
			toSort[i] = heap.getAndRemoveMin();
		}
	}

}
