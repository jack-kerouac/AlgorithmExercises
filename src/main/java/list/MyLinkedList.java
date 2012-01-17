package list;

public class MyLinkedList {

	class Elem {
		Elem next;
		int i;
		public Elem(Elem next, int i) {
			this.next = next;
			this.i = i;
		}
	}
	
	private Elem head;
	
	public void reverse() {
		if(head == null)
			return;
		
		Elem prev = head;
		Elem next = head.next;
		
		while(next != null) {
			Elem newPrev = next;
			next = next.next;
			prev.next.next = prev;
			prev = newPrev;
		}
		head.next = null;
		head = prev;
	}
	
	@Override
	public String toString() {
		String ret = "";
		Elem next = head;
		while(next != null) {
			ret += next.i  + " ";
			next = next.next;
		}
		return ret;
	}
	
	
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		
		list.head = list.new Elem(null, 1);
		list.head = list.new Elem(list.head, 2);
		list.head = list.new Elem(list.head, 3);
		list.head = list.new Elem(list.head, 4);
		
		System.out.println(list);
		
		list.reverse();
		
		System.out.println(list);
	}
	
}
