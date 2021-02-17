import java.util.*;

/**
 * A few different static methods to find the index of a particular value in and
 * Integer ArrayList
 * 
 * @author dave
 * @date February 2, 2010
 */
public class BinarySearchExamples {	
	public static int search1(ArrayList<Integer> nums, int findMe){
		for( int i = 0; i < nums.size(); i++ ){
			if( nums.get(i) == findMe ){
				return i;
			}
		}

		return -1;
	}
	
	public static int search1a(ArrayList<Integer> nums, int findMe){
		int returnMe = -1;
		
		for( int i = 0; i < nums.size(); i++ ){
			if( nums.get(i) == findMe ){
				returnMe = i;
			}
		}

		return returnMe;
	}

	public static int search2(ArrayList<Integer> nums, int findMe){
		return search2Helper(nums, findMe, 0);
	}

	private static int search2Helper(ArrayList<Integer> nums, int findMe, int index){
		if( index >= nums.size() ){
			return -1;
		}else if( nums.get(index) == findMe ){
			return index;
		}else{
			return search2Helper(nums, findMe, index+1);
		}
	}
	
	public static int binarySearch(ArrayList<Integer> sorted, int findMe){ 
		int low = 0; 
		int high = sorted.size() - 1; 

		while( low <= high ){ 
			int middle = (int)Math.floor((high+low)/2); 
			int middleElement = sorted.get(middle);
			
			if( middleElement == findMe ){ 
				// we've found the element, so return it 
				return middle;	
			}else if( findMe < middleElement ){ 
				high = middle - 1; 
			}else{ 
				// findMe > middleElement 
				low = middle+1; 
			} 
		}
		
		return -1; 
	}

	public static int binarySearchRecursive(ArrayList<Integer> sorted, int findMe){ 
		return BinarySearchHelper(sorted, findMe, 0, sorted.size()-1); 
	} 
	
	private static int BinarySearchHelper(ArrayList<Integer> sorted, int findMe, 
			int low, int high){ 
		if( low > high ){ 
			return -1; 
		}else{ 
			// find the mid-point of the list 
			int middle = (int)Math.floor((high+low)/2); 
			int middleElement = sorted.get(middle);
			
			if( middleElement == findMe ){
				// we've found the element, so return the index 
				return middle; 
			}else if( findMe < middleElement ){ 
				return BinarySearchHelper(sorted, findMe, low, middle-1); 
			}else{ 
				// findMe > middleElement 
				return BinarySearchHelper(sorted, findMe, middle+1, high); 
			} 
		} 
	} 
}