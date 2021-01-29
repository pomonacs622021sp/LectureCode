
public class Card {
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 13;
	
	private int number;
	private String suit;
	
	public Card(int tempNumber, String tempSuit){
		MIN_NUMBER = 10;
		if( isValidNumber(tempNumber) ) {
			number = tempNumber;
		}else {
			System.out.println("Invalid card number: " + tempNumber);
			System.out.println("Defaulting to 1");
			number = 1;
		}

		if( isValidSuit(tempSuit) ) {
			suit = tempSuit;
		} else {
			System.out.println("Invalid suit: " + tempSuit);
			System.out.println("Defaulting to hearts");
			suit = "hearts";
		}		
	}
	
	public String getSuit(){
		return suit;
	}
	
	public int getNumber(){
		return number;
	}
	
	public void cheat(){
		number = 1; // ACE!
	}
		
	public boolean equals(Card other){
		return number == other.number && suit.equals(other.suit);
		// could also write as:
		// number == other.getNumber() && suit.equals(other.getSuit());	
	}
	
	public String toString(){
		return number + " of " + suit;
	}
	
	private boolean isValidNumber(int number){
		return number >= MIN_NUMBER && number <= MAX_NUMBER;
	}
	
	private boolean isValidSuit(String suit){
		return suit.equals("spades") ||
			   suit.equals("hearts") ||
			   suit.equals("clubs") ||
			   suit.equals("diamonds");
	}
	
	public static void main(String[] args) {
		Card c = new Card(10, "clubs");
		System.out.println(c);
		String s = "the card is " + c;
		System.out.println(s);
	}
}