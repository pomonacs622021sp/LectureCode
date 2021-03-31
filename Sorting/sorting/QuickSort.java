package sorting;

public class QuickSort {
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
