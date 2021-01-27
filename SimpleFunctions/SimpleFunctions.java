public class SimpleFunctions {
	// ---------------------------------------------
	// a few simple java functions to get us started	

	int add(int num1, int num2){
		return num1 + num2;
	}

	boolean firstAndLastSame(String s){
		// s.length() gives us the length, in characters, of the string s
		return s.charAt(0) == s.charAt(s.length() - 1);
	}
	
	// sum_up_to
	int sumUpTo(int num){
		int sum = 0;

		/* for loops consist of three parts:
		 * 1) a beginning statement that is only run once (initialization)
		 * 2) the condition or test to see if the loop should keep going (condition)
		 * 3) a statement that is run after each loop iteration (increment)
		 */
		for( int i = 1; i <= num; i++ ){
			sum += i;
		}

		return sum;
	}

	int sumUpToWhile(int num){
		int sum = 0;

		int i = 1;

		while( i <= num ){
			sum += i;
			i++;
		}

		return sum;
	}

	void printSum(int num){
		System.out.println("The sum from 1 to " + num + " is " + sumUpTo(num));
	}

	// ---------------------------------------------
	// a mystery :)
	int mystery(int num){
		int sum = 0;

		for( int i = 0; i < num; i = i+3){
			sum += i;
		}

		return sum;
	}

	int mystery2(int num){
		int sum = 0;

		for( int i = 0; i < num; i++){
			if( i % 3 == 0 ) {          // % is the modulo operator, aka remainder
				sum += i;
			}
		}

		return sum;
	}


	// ---------------------------------------------
	// a few more complicated functions
	boolean isPrime(int num){
		for( int i = 2; i < num; i++ ){	// could stop at sqrt to make it faster...
			if( num % i == 0 ){  		// % is the modulo operator, aka remainder
				return false;
			}
		}

		return true;
	}

	void printPrimes(int numToPrint){
		int count = 0;
		int current = 2;

		while( count < numToPrint ){
			if( isPrime(current) ){
				System.out.println(current);
				count++;
			}

			current++;
		}
	}

	public static void main(String[] args){
		SimpleFunctions sf = new SimpleFunctions();
		sf.printPrimes(10);
	}
}
