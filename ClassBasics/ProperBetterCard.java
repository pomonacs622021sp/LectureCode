
public class ProperBetterCard {
	private int number;
	private String suit;

	public ProperBetterCard(int tempNumber, String tempSuit){
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

	private boolean isValidNumber(int num) {
		return num >= 1 && num <= 13;
	}

	private boolean isValidSuit(String s){
		return s.equals("spades") ||
				s.equals("hearts") ||
				s.equals("clubs") ||
				s.equals("diamonds");
	}

	public static void main(String args[]){
		ProperBetterCard card1 = new ProperBetterCard(2, "clubs");
		ProperBetterCard card2 = new ProperBetterCard(20, "bananas");
		ProperBetterCard card3 = card1;
		
		System.out.println(card1);
		System.out.println(card2);
		System.out.println(card3);

		
		System.out.println("Card1: " + card1.getNumber() + " of " + card1.getSuit());
		System.out.println("Card2: " + card2.getNumber() + " of " + card2.getSuit());

		card1.cheat();
		System.out.println("CHEATING!");

		System.out.println("Card1: " + card1.getNumber() + " of " + card1.getSuit());
		System.out.println("Card2: " + card2.getNumber() + " of " + card2.getSuit());

	}
}