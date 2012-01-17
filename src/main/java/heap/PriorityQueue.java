package heap;

public interface PriorityQueue<E extends Comparable<E>> {

	public E getAndRemoveMin();

	public void add(E element);

}
