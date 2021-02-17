
public class Pair<F, S> {
	private F first;
	private S second;

	public Pair(F first, S second){
		this.first = first;
		this.second = second;
	}

	public F getFirst(){
		return first;
	}

	public S getSecond(){
		return second;
	}
	
	public static void main(String[] args) {
		Pair<Integer, String> p = new Pair<Integer, String>(10, "banana");
		int num = p.getFirst();
		String s = p.getSecond();
		
		System.out.println(num);
		System.out.println(s);
	}
}
