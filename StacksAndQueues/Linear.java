/**
 * Simple list interface to allow Stacks and Queues to be used interchangeably
 * 
 * @author dave
 *
 * @param <E>
 */
public interface Linear<E> {
	/**
	 * Add the item to the data structure
	 * 
	 * @param item Data item to add
	 */
	public void add(E item);
	
	/**
	 * Remove and return the next item in the data structure
	 * 
	 * @return the next item
	 */
	public E remove();
	
	/**
	 * Look at the next item, but don't modify the data structure
	 * 
	 * @return the next item
	 */
	public E peek();
	
	/**
	 * @return if the data structure has any remaining values or not
	 */
	public boolean empty();
}
