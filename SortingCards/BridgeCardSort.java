import java.util.Comparator;

public class BridgeCardSort implements Comparator<SortableCard>{
	
	private static int promoteAce(int num) {
		return num == 1 ? num + 20 : num;
	}
	
	public int compare(SortableCard o1, SortableCard o2) {
		// suit first, spades, hearts, diamonds, clubs
		// note this is basically reverse alphabetical
		int suitCompare = o1.getSuit().compareTo(o2.getSuit());
		
		if( suitCompare == 0 ) {
			int num1 = promoteAce(o1.getNumber());
			int num2 = promoteAce(o2.getNumber());
			
			return -Integer.compare(num1, num2); // higher is better, so reverse
		} else {
			return -suitCompare; // reverse alphabetic.
		}
	}

}
