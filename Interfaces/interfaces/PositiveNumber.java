package interfaces;

public class PositiveNumber implements SimpleInterface{
	private int x = 10;
	
	public int returnNumber() {
		return x;
	}

	public void doSomethingFancy() {
		x = x + 10;
	}
	
	public int doubleValue() {
		return 2*x;
	}
}
