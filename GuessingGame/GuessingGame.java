import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class GuessingGame {
	private int maxGuess;
	
	public GuessingGame(int maxGuess){
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
			
			try{
				guess = in.nextInt();

				if( guess == pick ){
					System.out.println("Good job!");
				}else if( guess < pick ){
					System.out.println("too low");
				}else{
					System.out.println("too high");
				}
			}catch(InputMismatchException e){
				System.out.println("Guess must be a number!");
				System.out.println(e.getMessage());
				e.printStackTrace();
				// there's still some text in there that's a string, so read it and ignore it
				in.nextLine();
			}
		}
		
		in.close();
	}
	
	public static void main(String[] args){
		GuessingGame game = new GuessingGame(20);
		game.playGame();
		
		try {
			Scanner in = new Scanner(new File("somefile.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
