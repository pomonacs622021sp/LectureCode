package interfaces;

/**
 * The {@code BasicArrayList} class represents a list that is indexable
 * and can dynamically grow.
 */
public class BasicArrayList<E> implements BasicList<E>{
	private static final int START_SIZE = 10;
	
	private E[] data; // underlying array of items
	private int size; // number of items in arraylist


	public BasicArrayList() {
		data = (E[]) new Object[START_SIZE];
		size = 0;
	}

	public BasicArrayList(int capacity) {
		data = (E[]) new Object[capacity];
		size = 0;
	}
	
	public E get(int index) {
		rangeCheck(index);
		return data[index];
	}

	public void set(int index, E item) {
		rangeCheck(index);
		data[index] = item;
	}
	
	private void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
		}
	}
	
	public void add(E item) {
		if (size == data.length){
			resize(2 * data.length);
		}
		data[size] = item;
		size++;
	}

	public int size() {
		return size;
	}	

	private void resize(int capacity) {
		E[] temp = (E[]) new Object[capacity];
		
		for (int i = 0; i < size; i++) {
			temp[i] = data[i];
		}

		data = temp;
	}

	public String toString() {
		String s = "ArrayList: [";
		
		for( int i = 0; i < size; i++ ) {
			s += data[i] + ", ";
		}
		
		return s.substring(0, s.length()-2) + "]";
	}
}
