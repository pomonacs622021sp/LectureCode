package interfaces;
import java.util.*;

/**
 * A few different static methods to find the index of a particular value in and
 * Integer ArrayList
 * 
 * @author dave
 * @date February 18, 2021
 */
public class SimpleSearch {		
	public static int integerSearch(BasicList<Integer> nums, int findMe){
		for( int i = 0; i < nums.size(); i++ ){
			if( nums.get(i) == findMe ){
				return i;
			}
		}

		return -1;
	}
	
	public static <E> int search(BasicArrayList<E> nums, E findMe){
		for( int i = 0; i < nums.size(); i++ ){
			if( nums.get(i).equals(findMe) ){
				return i;
			}
		}

		return -1;
	}
	
	public static void main(String[] args) {
		BasicArrayList<String> strings = new BasicArrayList<String>();
		
		strings.add("CS");
		strings.add("62");
		strings.add("is");
		strings.add("great!");
		
		System.out.println(search(strings, "great!"));
	}
}