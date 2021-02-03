import java.util.Random;

public class CardDealer{
	private static final int CARDS_PER_SUIT = 13;  // the number of cards in the deck
	private static final String[] SUITS = {"clubs", "diamonds", "hearts", "spades"};
	
	private Card[] cards;  // all of the cards to be dealt
	private int position = 0;  // our current position in our stack of cards

	public CardDealer(int numDecks){
		// calculate the number of cards
		int numCards = numDecks * CARDS_PER_SUIT * SUITS.length;
		cards = new Card[numCards];
		
		// initialize the individual cards
		int cardIndex = 0;
		
		for( int i = 0; i < numDecks; i++ ){
			for( int suitIndex = 0; suitIndex < SUITS.length; suitIndex++ ){
				for( int numIndex = 1; numIndex <= CARDS_PER_SUIT; numIndex++ ){
					cards[cardIndex] = new Card(numIndex, SUITS[suitIndex]);
					cardIndex++;
				}
			}
		}
		
		shuffle();
	}
	
	public Card next(){
		position++;
		return cards[position-1];
	}
		
	public boolean hasNext(){
		return position < cards.length;
	}
	
	public void shuffle(){
		Random rand = new Random();
		
		for( int i = 0; i < cards.length; i++ ){
			int randPosition = rand.nextInt(cards.length);
			
			// swap this card with the card at next position
			Card temp = cards[i];
			cards[i] = cards[randPosition];
			cards[randPosition] = temp;
		}
		
		// once they're shuffled, start at the beginning again
		position = 0;
	}
	
	public static void printDeck(){
		CardDealer dealer = new CardDealer(6);
		int count = 0;
		
		while( dealer.hasNext() ){
			System.out.println(dealer.next());
			count++;
		}
		System.out.println("Printed out " + count + " cards");
	}
	
	public static void main(String[] args){
		printDeck();
	}
}
