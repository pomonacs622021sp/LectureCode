
public class BasicCard {
	int number;
	String suit;
	
	BasicCard(int tempNumber, String tempSuit){
		number = tempNumber;
		suit = tempSuit;
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
	
	public static void main(String args[]){
		BasicCard card1 = new BasicCard(10, "hearts");
		BasicCard card2 = new BasicCard(2, "clubs");
		
		BasicCard[] cards = new BasicCard[52];
		
		for(int i = 0; i < cards.length; i++ ) {
			cards[i] = new BasicCard(i+1, "hearts");
		}
		
		System.out.println(cards[3].getNumber());
		
		
		System.out.println("Card1: " + card1.getNumber() + " of " + card1.getSuit());
		System.out.println("Card2: " + card2.getNumber() + " of " + card2.getSuit());
		
		card1.cheat();
		System.out.println("CHEATING!");

		System.out.println("Card1: " + card1.getNumber() + " of " + card1.getSuit());
		System.out.println("Card2: " + card2.getNumber() + " of " + card2.getSuit());
	}
}