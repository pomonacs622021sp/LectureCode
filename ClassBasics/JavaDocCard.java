/**
 * A class to represent a standard playing card.
 * 
 * @author Dr. Dave
 */
public class JavaDocCard {
	// constants for the number range
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 13;
	
	private int number;
	private String suit;
	
	/**
	 * Constructs a new playing card.  If the number and/or suit
	 * is not valid, defaults to 1 of hearts.
	 * 
	 * @param tempNumber the number of the card
	 * @param tempSuit the suit of the card
	 */
	public JavaDocCard(int tempNumber, String tempSuit){
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
	
	/**
	 * @return the suit of the card
	 */
	public String getSuit(){
		return suit;
	}
	
	/** 
	 * @return the number of the card
	 */
	public int getNumber(){
		return number;
	}
	
	/**
	 * Change the number of this card to 1.
	 */
	public void cheat(){
		number = 1; // ACE!
	}
	
	/**
	 * Two cards are equal if they have the same number and suit
	 * 
	 * @param other
	 * @return
	 */
	public boolean equals(JavaDocCard other){
		return number == other.getNumber() && suit.equals(other.getSuit());
		// could also write as:
		// number == other.number && suit.equals(other.suit);
	}
	
	public String toString(){
		return number + " of " + suit;
	}
	
	/**
	 * Checks if the number is a valid card number
	 * 
	 * @param number
	 * @return
	 */
	private boolean isValidNumber(int number){
		return number >= MIN_NUMBER && number <= MAX_NUMBER;
	}
	
	/**
	 * Checks if the suit is a valid suit
	 * 
	 * @param suit
	 * @return
	 */
	private boolean isValidSuit(String suit){
		return suit.equals("spades") ||
			   suit.equals("hearts") ||
			   suit.equals("clubs") ||
			   suit.equals("diamonds");
	}
	
	public static void main(String[] args) {
		JavaDocCard c = new JavaDocCard(10, "clubs");
		String s = "the card is " + c;
		System.out.println(s);
	}
}