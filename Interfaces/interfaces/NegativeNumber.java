package interfaces;

public class NegativeNumber implements SimpleInterface{
	private int x = -10;
	
	public int returnNumber() {
		return x;
	}

	public void doSomethingFancy() {
		x = x - 10;
	}
	
	public int magnitude() {
		return Math.abs(x);
	}
}
