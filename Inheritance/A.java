
public class A {
	protected int number;
	private String text;
	
	public A(int number, String text){
		this.number = number;
		this.text = text;
	}
	
	public int getNumber(){
		return number;
	}
	
	public String getText(){
		return text;
	}

	public String toString(){
		return "I'm an A";
	}
}