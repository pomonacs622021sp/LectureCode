import java.util.LinkedList;

public class LinkedQueue<E> implements Queue<E>, Linear<E> {
	private LinkedList<E> list = new LinkedList<E>();

	public void enqueue(E item){
		list.addLast(item);
	}
	
	public E dequeue() {
		return list.removeFirst();
	}

	public E peek() {
		return list.getFirst();
	}
	
	public boolean empty() {
		return list.isEmpty();
	}
	
	// ---------------- Just added for compatibility with Linear
	public void add(E item) {
		enqueue(item);
	}

	public E remove(){
		return dequeue();
	}
}
