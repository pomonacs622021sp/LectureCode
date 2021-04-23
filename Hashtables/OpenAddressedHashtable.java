public abstract class OpenAddressedHashtable<E> implements Set<E> {
	protected E[] table;
	private int count = 0;
	
	public OpenAddressedHashtable(int size){
		table = (E[])new Object[size];
	}
	
	public boolean containsKey(E key){
		int i = 0;
		int next = probeSequence(key, i);
		
		while( i < table.length && 
			   table[next] != null &&
			   !table[next].equals(key)){
			i++;
			next = probeSequence(key, i);
		}
		
		// only 3 ways to exit the while loop
		// the two of which below mean we didn't find it
		return !(i == table.length || table[next] == null);
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public void put(E key) {
		int i = 0;
		int next = probeSequence(key, i);
		
		while( i < table.length &&
			   table[next] != null ){
			i++;
			next = probeSequence(key, i);
		}
		
		table[next] = key;
		count++;
	}

	public E remove(E key) {
		// for now, we'll leave this unimplemented		
		return null;
	}

	public int size() {
		return count;
	}
	
	abstract protected int probeSequence(E key, int probNum);
}