import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortableCard extends Card implements Comparable<SortableCard>{
	public SortableCard(int number, String suit) {
		super(number, suit);
	}

	public int compareTo(SortableCard o) {
		// sort based on suit first then number
		int comparison = suit.compareTo(o.suit);

		return comparison == 0 ? Integer.compare(number, o.number) : comparison;
	}

	//-------------------------------------------------
	// Comparator using anonymous functions (lambda expressions)
	private static int promoteAce(int num) {
		return num == 1 ? num + 20 : num;
	}

	public static Comparator<SortableCard> byBridgeOrder() {
		return 
		(SortableCard o1, SortableCard o2) -> {
			int suitCompare = o1.suit.compareTo(o2.suit);

			if( suitCompare == 0 ) {
				int num1 = promoteAce(o1.number);
				int num2 = promoteAce(o2.number);

				return -Integer.compare(num1, num2); // higher is better, so reverse
			} else {
				return -suitCompare; // reverse alphabetic.
			}
		};
	}

	//-------------------------------------------------
	// Comparator using a static inner class
	public static Comparator<SortableCard> byBridgeOrder2() {
		return new BridgeComparator();
	}

	private static class BridgeComparator implements Comparator<SortableCard> {
		public int compare(SortableCard o1, SortableCard o2) {

			// suit first, spades, hearts, diamonds, clubs
			// note this is basically reverse alphabetical
			int suitCompare = o1.suit.compareTo(o2.suit);

			if( suitCompare == 0 ) {
				int num1 = promoteAce(o1.number);
				int num2 = promoteAce(o2.number);

				return -Integer.compare(num1, num2); // higher is better, so reverse
			} else {
				return -suitCompare; // reverse alphabetic.
			}

		}

	}
	
	//-------------------------------------------------
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
		Collections.sort(cards, SortableCard.byBridgeOrder());

		for( SortableCard c: cards ) {
			System.out.println(c);
		}
	}

	public static void main(String[] args) {
		SortableCard c1 = new SortableCard(2, "hearts");
		SortableCard c2 = new SortableCard(1, "spades");

		System.out.println(c1.compareTo(c2));

		BridgeCardSort s = new BridgeCardSort();

		System.out.println(s.compare(c1, c2));		
	}
}