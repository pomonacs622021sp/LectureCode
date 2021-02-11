import java.util.ArrayList;
import java.util.Random;


public class AsymptoticsExamples {
	public static int sum(ArrayList<Integer> nums){
		int sum = 0;
		
		for( int i = 0; i < nums.size(); i++ ){
			sum += nums.get(i);
		}
		
		return sum;
	}
	
	public static int sumProduct(ArrayList<Integer> nums){
		int sum = 0;
		
		for( int i = 0; i < nums.size(); i++ ){
			for( int j = 0; j < nums.size(); j++ ){
				if( i != j ){
					sum += nums.get(i) * nums.get(j);
				}
			}
		}
		
		return sum;
	}
	
	public static int lastElement(ArrayList<Integer> nums){
		if( nums.size() == 0 ){
			return 0; // probably should do something better than this
		}else{
			return nums.get(nums.size()-1);
		}
	}
	
	public static int doubleSum(ArrayList<Integer> nums){
		int sum1 = sum(nums);
		int sum2 = sum(nums);
		
		return sum1 + sum2;
	}
	
	public static ArrayList<Integer> randomArray(int num){
		ArrayList<Integer> nums = new ArrayList<Integer>();
		Random rand = new Random();
		
		for( int i = 0; i < num; i++ ){
			nums.add(rand.nextInt(1000));
		}
		
		return nums;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> rand = randomArray(1000000);
		long start = System.currentTimeMillis();
		sum(rand);
		long end = System.currentTimeMillis();
		
		System.out.println((end-start)/1000.0);
	}
}
