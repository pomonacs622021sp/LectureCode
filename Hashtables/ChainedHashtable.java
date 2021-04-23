import java.util.LinkedList;

public class ChainedHashtable<E> implements Set<E> {
	
	private LinkedList<E>[] table;
	
	private int count = 0;
	
	public ChainedHashtable(int size){
		table = (LinkedList<E>[])new LinkedList[size];
	}
	
	public boolean containsKey(E key){
		LinkedList<E> entry = table[h(key)];	
		return entry == null ? false : entry.contains(key);
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public void put(E key) {
		LinkedList<E> entry = table[h(key)];
		
		if( entry == null ){
			entry = new LinkedList<E>();
			table[h(key)] = entry;
		}
		
		entry.addFirst(key);
		count++;
	}

	public E remove(E key) {
		LinkedList<E> entry = table[h(key)];
		
		if( entry != null && entry.remove(key) ){
			return key;
		}else{
			return null;
		}
	}

	public int size() {
		return count;
	}
	
	private int h(E key){
		return key.hashCode() % table.length;
	}
}
