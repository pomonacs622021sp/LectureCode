/**
 * Queue interface (FIFO)
 * 
 * @author dave
 *
 * @param <E>
 */
public interface Queue<E>{
	
	/**
	 * Add an item to the end of the queue
	 * 
	 * @param item data item to be added
	 */
	public void enqueue(E item);
	
	/**
	 * Remove and return the item at the front of the queue
	 * 
	 * @return the item at the front of the queue
	 */
	public E dequeue();
	
	/**
	 * Return the item at the front of the queue, but do not modify the queue
	 * 
	 * @return the item at the front of the queue
	 */
	public E peek();
	
	/**
	 * Checks whether or not the queue is empty
	 * 
	 * @return returns whether the queue is empty
	 */
	public boolean empty();
}
