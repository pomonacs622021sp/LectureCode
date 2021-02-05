
public class B extends A{
	public B(int number, String text) {
		super(number, text); // call A's constructor
	}
	
	public void resetInt(){
		number = 0;
	}
	
	public String toString(){
		return "I'm a B";
	}
	
	public static void test(){
		B b = new B(10, "test");
		System.out.println(b.getNumber());
		b.resetInt();
		System.out.println(b.getNumber());
		
		A a = new A(10, "test");
		System.out.println(a.getNumber());
		// a.resetInt(); // Why doesn't this work?
	}
	
	public static void test2(){
		A a = new B(10, "test");  // why does this work?!?
		System.out.println(a.getText());
		// System.out.println(a.resetInt()); // Why doesn't this work?
	}
	
	public static void test3(){
		A a1 = new A(10, "test");
		B b1 = new B(1, "banana");
		A a2 = new B(1, "apple");
		
		System.out.println("A1: " + a1);
		System.out.println("B1: " + b1);
		System.out.println("A2: " + a2);
	}
	
	public static void main(String[] args){
		test3();
	}
}
