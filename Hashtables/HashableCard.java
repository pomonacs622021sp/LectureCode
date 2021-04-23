import java.util.Objects;

public class HashableCard {
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 13;
	
	private int number;
	private String suit;
	
	public HashableCard(int tempNumber, String tempSuit){
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
	
	public boolean equals(Object other){
		if( other instanceof HashableCard ) {
			HashableCard otherCard = (HashableCard)other;
			
			return number == otherCard.number && suit.equals(otherCard.suit);
		} else {
			return false;
		}
		
		// could also write as:
		// number == other.getNumber() && suit.equals(other.getSuit());	
	}
	
	public int hashCode() {
		return Objects.hash(suit, number);
		/* another version
		 * return (suit + Integer.toString(number)).hashCode();
		 */
	}
}