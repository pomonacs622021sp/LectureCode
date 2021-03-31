package sorting;
import java.util.Arrays;
import java.util.Random;

public class BasicSorting {

	public static void insertionSort(int[] numbers) {
		for( int i = 1; i < numbers.length; i++ ) {
			int current = numbers[i];
			int j = i - 1;

			while( i > 0 && numbers[j] > current ) {

			}
		}
	}

	public static void insertionSort(Comparable[] a) {
		for( int i = 1; i < a.length; i++ ) {
			Comparable current = a[i];
			int j = i - 1;

			while( j > 0 && current.compareTo(a[j]) < 0 ) {
				a[j+1] = a[j];
				j--;
			}

			a[j] = current;
		}
	}

	public static void sort(Comparable[] a) {
		for( int i = 0; i < a.length; i++ ) {
			int smallestIndex = i;

			for( int j = i+1; j < a.length; j++ ) {
				if( a[j].compareTo(a[smallestIndex]) < 0 ) {
					smallestIndex = j;
				}
			}

			Comparable temp = a[i];
			a[i] = a[smallestIndex];
			a[smallestIndex] = temp;
		}
	}

	public static <E extends Comparable<E>> void sortBetter(E[] a) {
		for( int i = 0; i < a.length; i++ ) {
			int smallestIndex = i;

			for( int j = i+1; j < a.length; j++ ) {
				if( a[j].compareTo(a[smallestIndex]) < 0 ) {
					smallestIndex = j;
				}
			}

			E temp = a[i];
			a[i] = a[smallestIndex];
			a[smallestIndex] = temp;
		}
	}

	public static <E extends Comparable<E>> void selectionSort(E[] a) {
		for( int i = 0; i < a.length; i++ ) {
			int smallestIndex = i;

			for( int j = i+1; j < a.length; j++ ) {
				if( a[j].compareTo(a[smallestIndex]) < 0 ) {
					smallestIndex = j;
				}
			}

			E temp = a[i];
			a[i] = a[smallestIndex];
			a[smallestIndex] = temp;
		}
	}

	public static <E extends Comparable<E>> E[] mergeSort(E[] a) {
		if( a.length <= 1 ) {
			return a;
		} else {
			int mid = a.length/2;
			E[] left = Arrays.copyOfRange(a, 0, mid);
			E[] right = Arrays.copyOfRange(a, mid, a.length);
			E[] sortedLeft = mergeSort(left);
			E[] sortedRight = mergeSort(right);
			return merge(sortedLeft, sortedRight);
		}
	}

	public static <E extends Comparable<E>> E[] merge(E[] left, E[] right) {
		int size = left.length+right.length;
		E[] result = (E[])new Object[size];

		int lIndex = 0;
		int rIndex = 0;

		for( int i = 0; i < size; i++ ) {
			if( lIndex >= left.length ) { // done with left
				result[i] = right[rIndex];
				rIndex++;
			} else if( rIndex >= right.length ) { // done with right
				result[i] = left[lIndex];
				lIndex++;
			} else if( left[lIndex].compareTo(right[rIndex]) <= 0 ) {
				result[i] = left[lIndex];
				lIndex++;
			} else {
				result[i] = right[rIndex];
				rIndex++;
			}
		}

		return result;
	}

	public static <E extends Comparable<E>> void quicksort(E[] vals) {
		quicksortHelper(vals, 0, vals.length-1);
	}

	private static <E extends Comparable<E>> 
	void quicksortHelper(E[] vals, int start, int end){
		if( start < end ){
			int partition = partition(vals, start, end);
			quicksortHelper(vals, start, partition-1);
			quicksortHelper(vals, partition+1, end);
		}
	}

	public static <E extends Comparable<E>> int partition(E[] vals, int start, int end){
		int lessThanIndex = start-1;

		for( int i = start; i < end; i++ ){
			if( vals[i].compareTo(vals[end]) <= 0 ) {
				lessThanIndex++;
				swap(vals, lessThanIndex, i);
			}
		}

		swap(vals, lessThanIndex+1, end);
		return lessThanIndex+1;
	}

	private static <E extends Comparable<E>> void swap(E[] vals, int first, int second){
		E temp = vals[first];
		vals[first] = vals[second];
		vals[second] = temp;
	}

}
