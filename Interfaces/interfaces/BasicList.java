package interfaces;

public interface BasicList<E> {
	public E get(int index);
	public void set(int index, E val);
	public void add(E val);
	public int size(); 
}
