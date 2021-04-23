
public class LinearAddressedHashtable<E> extends OpenAddressedHashtable<E> {
	public LinearAddressedHashtable(int size){
		super(size);
	}
	
	protected int probeSequence(E key, int i){
		return (h(key) + i) % table.length;
	}
	
	// a simple hash function based on mod
	private int	h(E key){
		return key.hashCode() % table.length;
	}
}