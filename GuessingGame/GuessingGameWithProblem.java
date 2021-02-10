import java.util.Random;
import java.util.Scanner;


public class GuessingGameWithProblem {
	private int maxGuess;
	
	public GuessingGameWithProblem(int maxGuess){
		this.maxGuess = maxGuess;
	}
	
	public void playGame(){
		// pick a random number
		Random rand = new Random();
		int pick = rand.nextInt(maxGuess) + 1;
		
		int guess = -1;
		Scanner in = new Scanner(System.in);
		
		while( guess != pick ){
			System.out.print("Enter a guess: ");
			guess = in.nextInt();
			
			if( guess == pick ){
				System.out.println("Good job!");
			}else if( guess < pick ){
				System.out.println("too low");
			}else{
				System.out.println("too high");
			}
		}
	}
	
	public static void main(String[] args){
		GuessingGameWithProblem game = new GuessingGameWithProblem(20);
		game.playGame();
	}
}
 