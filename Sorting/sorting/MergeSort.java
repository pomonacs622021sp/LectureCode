package sorting;

import java.util.Arrays;

public class MergeSort {
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

}
