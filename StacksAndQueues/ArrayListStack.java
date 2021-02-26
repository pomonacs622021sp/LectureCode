import java.util.ArrayList;

/**
 * A stack implemented using an ArrayList
 * 
 * @author dave
 *
 * @param <E>
 */
public class ArrayListStack<E> implements Stack<E>, Linear<E> {
	private ArrayList<E> list = new ArrayList<E>();

	public void push(E item) {
		list.add(item);		
	}

	public E pop() {
		return list.remove(list.size()-1);
	}

	public E peek() {
		return list.get(list.size()-1);
	}


	public boolean empty() {
		return list.size() == 0;
	}

	// ---------------- Just added for compatibility with Linear
	public void add(E item) {
		push(item);
	}

	public E remove() {
		return pop();
	}
}
