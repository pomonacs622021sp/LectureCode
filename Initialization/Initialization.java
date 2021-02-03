
public class Initialization {
	private int x;
	private Card card;
	
	public int getX() {
		return x;
	}

	public Card getCard() {
		return card;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setCard(Card card) {
		this.card = card;
	}
	
	public static void test1() {
		Initialization init = new Initialization();
		init.setX(2);
		init.setCard(new Card(4, "hearts"));
		System.out.println(init.getX());
		System.out.println(init.getCard());
	}
	
	public static void test2() {
		Initialization init = new Initialization();
		System.out.println(init.getX());
		System.out.println(init.getCard());
	}
	
	public static void test3() {
		Initialization init = new Initialization();
		init.getCard().cheat();
	}
	
	public static void main(String[] args) {
		test3();
	}
}
