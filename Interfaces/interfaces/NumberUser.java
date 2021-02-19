package interfaces;

public class NumberUser {

	public static void useNumbers(SimpleInterface simple) {
		System.out.println(simple.returnNumber());
		simple.doSomethingFancy();
		System.out.println(simple.returnNumber());
	}
	
	public static void main(String[] args) {
		NegativeNumber n = new NegativeNumber();
		PositiveNumber p = new PositiveNumber();
		
		useNumbers(n);
		useNumbers(p);
	}
}
