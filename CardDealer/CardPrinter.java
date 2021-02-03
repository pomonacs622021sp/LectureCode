import java.util.Scanner;

public class CardPrinter {

	private static void printSomeCards() {
		Scanner in = new Scanner(System.in);
		
		System.out.print("What is your name? ");
		String name = in.nextLine();
		
		System.out.print("How many cards do you want? ");
		int numCards = in.nextInt();
		
		System.out.println();
		System.out.println("Hi " + name);
		System.out.println("Here are your " + numCards + " cards!");
		
		CardDealer deck = new CardDealer((numCards / 52) + 1);
		
		for( int i = 0; i < numCards; i++ ) {
			System.out.println(deck.next());
		}
	}
	
	public static void main(String[] args) {
		printSomeCards();
	}
}
