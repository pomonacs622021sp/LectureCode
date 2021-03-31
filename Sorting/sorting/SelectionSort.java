package sorting;

public class SelectionSort {
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
}
