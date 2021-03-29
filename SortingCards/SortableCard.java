import java.util.ArrayList;
import java.util.Collections;

public class SortableCard extends Card implements Comparable<SortableCard>{
	public SortableCard(int number, String suit) {
		super(number, suit);
	}

	public int compareTo(SortableCard o) {
		// sort based on suit first then number
		int comparison = suit.compareTo(o.suit);

		return comparison == 0 ? Integer.compare(number, o.number) : comparison;
	}

	public static void naturalSort() {
		ArrayList<SortableCard> cards = new ArrayList<SortableCard>();

		CardDealer dealer = new CardDealer(1);
		
		while( dealer.hasNext() ) {
			Card c = dealer.next();
			System.out.println(c);
			cards.add(new SortableCard(c.getNumber(), c.getSuit()));
		}
		
		System.out.println("Sorting by natural ordering!");
		Collections.sort(cards);
		
		for( SortableCard c: cards ) {
			System.out.println(c);
		}
	}
	
	public static void bridgeOrderingSort() {
		ArrayList<SortableCard> cards = new ArrayList<SortableCard>();

		CardDealer dealer = new CardDealer(1);
		
		while( dealer.hasNext() ) {
			Card c = dealer.next();
			System.out.println(c);
			cards.add(new SortableCard(c.getNumber(), c.getSuit()));
		}
		
		System.out.println("Sorting by bridge ordering!");
		Collections.sort(cards, new BridgeCardSort());
		
		for( SortableCard c: cards ) {
			System.out.println(c);
		}
	}

	public static void main(String[] args) {
		bridgeOrderingSort();
	}
}