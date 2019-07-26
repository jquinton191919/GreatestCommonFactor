package sort;
/**
 * How to do Quick Sort:
 * 1. Pick the middle element of 2 values in the array (usually the first element and last element)
 * 2. Get the value at that middle element and set this as the pivot value
 * 3. Check each element ascending from the left to see if they are smaller than the pivot value. If not, pause
 * 4. Check each element descending from the right to see if they are larger than the pivot value. If not, pause
 * 5. swap the two stopped elements. Repeat step 3, 4, and 5 until the left element number is greater than or equal to the right element number
 * 6. Sort two smaller portions of the array: If the first element is still smaller than the element that was descending from the right, sort between these two; if the last
 * element is still larger than the element counter ascending from the left, sort between these two
 * */

public class QuickSort {
	
	private QuickSort() {}
	
	public static long sort(int [] input){
		long start = System.currentTimeMillis();
		sort(input, 0, input.length - 1);
		return System.currentTimeMillis() - start;
	}
	
	public static void sort(int [] input, int low, int high){
		if(low >= high);
		else{
			int middle = low + (high - low) / 2,
					fromLow = low,
					fromHigh = high,
					pivot = input[middle];
			while(fromLow <= fromHigh){
				while(input[fromLow] < pivot) fromLow++;
				while(input[fromHigh] > pivot) fromHigh--;
				if(fromLow <= fromHigh){
					int temp = input[fromLow];
					input[fromLow] = input[fromHigh];
					input[fromHigh] = temp;
					fromLow++;
					fromHigh--;
				}
			}
			
			if(low < fromHigh) sort(input, low, fromHigh);
			if(high > fromLow) sort(input, fromLow, high);
		}
	}
	
	public static void swap(int [] input, int low, int high){
		int temp = input[low];
		input[low] = input[high];
		input[high] = temp;
	}
	
	public static void main(String[] args) {
		//int [] foo = {6, 5, 3, 1, 8, 7, 2, 4};
		//int [] foo = {6, 5, 3, 1, 8, 7, 2, 4, 8, 16};
		int [] foo = {5, 2, 4, 3, 1};
		sort(foo);
		for(int i : foo) System.out.print(i + " ");

	}

}
