
public class Container<V> {
	private V value;
	
	public Container(V value){
		this.value = value;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	public static void main(String[] args) {
		Container<String> c1 = new Container<String>("banana");
		Container<Integer> c2 = new Container<Integer>(10);
		
		System.out.println(c1.getValue());
		System.out.println(c2.getValue());
		
		// c2.setValue("car"); // DOESN'T WORK!
	}
}