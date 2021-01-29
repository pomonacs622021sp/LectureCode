
public class BetterCard {
	int number;
	String suit;

	BetterCard(int tempNumber, String tempSuit){
		if( isValidNumber(tempNumber) ) {
			number = tempNumber;
		} else {
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

	String getSuit(){
		return suit;
	}

	int getNumber(){
		return number;
	}

	void cheat(){
		number = 1; // ACE!
	}

	boolean isValidNumber(int num) {
		return num >= 1 && num <= 13;
	}

	boolean isValidSuit(String s){
		return s.equals("spades") ||
				s.equals("hearts") ||
				s.equals("clubs") ||
				s.equals("diamonds");
	}

	public static void main(String args[]){
		BetterCard card1 = new BetterCard(2, "clubs");		
		BetterCard card2 = new BetterCard(20, "bananas");

		System.out.println("Card1: " + card1.getNumber() + " of " + card1.getSuit());
		System.out.println("Card2: " + card2.getNumber() + " of " + card2.getSuit());

		card1.cheat();
		System.out.println("CHEATING!");

		System.out.println("Card1: " + card1.getNumber() + " of " + card1.getSuit());
		System.out.println("Card2: " + card2.getNumber() + " of " + card2.getSuit());
	}
}