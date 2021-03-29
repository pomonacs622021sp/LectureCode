import java.util.ArrayList;
import java.util.Random;

public class CardDealer{
	private static final int CARDS_PER_SUIT = 13;  // the number of cards in the deck
	private static final String[] SUITS = {"clubs", "diamonds", "hearts", "spades"};
	
	private ArrayList<Card> cards = new ArrayList<Card>();  // all of the cards to be dealt
	private int position = 0;  // our current position in our stack of cards

	public CardDealer(int numDecks){
		// initialize the individual cards
		for( int i = 0; i < numDecks; i++ ){
			addDeckWithoutShuffle();
		}
		
		shuffle();
	}
	
	public Card next(){
		position++;
		return cards.get(position-1);
	}
		
	public boolean hasNext(){
		return position < cards.size();
	}
	
	public void shuffle(){
		Random rand = new Random();
		
		for( int i = 0; i < cards.size(); i++ ){
			int nextPosition = rand.nextInt(cards.size());
			
			// swap this card with the card at next position
			Card temp = cards.get(i);
			cards.set(i, cards.get(nextPosition));
			cards.set(nextPosition, temp);
		}
		
		// once they're shuffled, start at the beginning again
		position = 0;
	}
	
	public void addDeck() {
		addDeckWithoutShuffle();
		shuffle();
	}
	
	private void addDeckWithoutShuffle() {
		for( int suitIndex = 0; suitIndex < SUITS.length; suitIndex++ ){
			for( int numIndex = 1; numIndex <= CARDS_PER_SUIT; numIndex++ ){					
				cards.add(new Card(numIndex, SUITS[suitIndex]));
			}
		}
	}
	
	public static void printDeck(CardDealer dealer){
		int count = 0;
		
		while( dealer.hasNext() ){
			System.out.println(dealer.next());
			count++;
		}
		System.out.println("Printed out " + count + " cards");
	}
	
	public static void main(String[] args){
		CardDealer dealer = new CardDealer(1);
		printDeck(dealer);
		dealer.addDeck();
		printDeck(dealer);
	}
}
