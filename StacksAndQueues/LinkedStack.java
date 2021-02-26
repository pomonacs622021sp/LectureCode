import java.util.LinkedList;

/**
 * A stack implemented using an ArrayList
 * 
 * @author dave
 *
 * @param <E>
 */
public class LinkedStack<E> implements Stack<E>, Linear<E> {
	private LinkedList<E> list = new LinkedList<E>();

	public void push(E item) {
		list.addFirst(item);
	}
	
	public E pop() {
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
		push(item);
	}

	public E remove() {
		return pop();
	}	
}