import java.util.ArrayList;

/**
 * Queue implementation using ArrayLists
 * 
 * @author dave
 *
 * @param <E>
 */
public class ArrayListQueue<E> implements Queue<E>, Linear<E>{
	private ArrayList<E> list = new ArrayList<E>();

	public E dequeue(){
		return list.remove(0);
	}

	public boolean empty() {
		return list.size() == 0;
	}

	public void enqueue(E item) {
		list.add(item);
	}

	public E peek() {
		return list.get(0);
	}

	// ---------------- Just added for compatibility with Linear
	public void add(E item){
		enqueue(item);
	}

	public E remove() {
		return dequeue();
	}
}
