/**
 * Simple version of the map interface
 * 
 * @author dkauchak
 * @date 3/29/2010
 */
public interface Set<E> {
	public void put(E key);
	public boolean containsKey(E key);
	public E remove(E key);
	public boolean isEmpty();
	public int size();
}
