package sort;

/**
 * How to merge sort
 * 
 * 1. split the array into two
 * 2. split those half arrays in half
 * 3. repeat until either there are 3 elements in the split array, in which sorting is relatively straightfoward, or there are 2 elements
 * which, again, sorting is straightforward
 * 4. insert the two smaller arrays back into the larger array in sorted order
 * 4a. programmatically, if the current element of array 1 is less than the length of array 1 AND the current element of array 2 
 * is less than the length of array 2, then check whichever current element in both arrays is smaller, and insert that element into the larger array
 * 4b. if either the current element of array 1 is greater than the size of array 1 OR the current element of array 2 is greater than the size of array 2,
 * then ignore that array and fill the rest of the main array with the remainder of the non yet completely checked array
 * 5. repeat until back to normal using recursion 
 * 
 * **/

public class MergeSort {
	
	private MergeSort() {} //not used
	public static long start, total;
	
	public static long sort(int [] input){
		start = System.currentTimeMillis();
		int length = input.length, elem1 = 0, elem2 = 0;		
		if(length > 3) {
			int [] input1 = new int[length / 2];
			int [] input2 = new int[(length / 2) + (length % 2)];
			for(int i=0; i < input.length; i++){
				if(i < input1.length) input1[elem1++] = input[i];
				else input2[elem2++] = input[i];
			}
			sort(input1);
			sort(input2);
			
			elem1 = 0;
			elem2 = 0;
			for(int i=0; i < length; i++) {
				if( (elem1 < input1.length) && (elem2 < input2.length) ){
					input[i] = (input1[elem1] < input2[elem2]) ? input1[elem1++] : input2[elem2++];
				}
				
				else if( (elem1 < input1.length) && (elem2 >= input2.length) ) input[i] = input1[elem1++];
				
				else if( (elem1 >= input1.length) && (elem2 < input2.length) ) input[i] = input2[elem2++];
			}
				
		}
		else if(length == 3) {
			if(input[0] > input[1]) swap(input, 0, 1);
			if(input[0] > input[2]) swap(input, 0, 2);
			if(input[1] > input[2]) swap(input, 1, 2);
			
		}
		else if(length == 2) {
			if(input[0] > input[1]) swap(input, 0, 1);
		}
		return System.currentTimeMillis() - start;
	}
	
	public static void swap(int [] input, int leftElem, int rightElem){
		int temp = input[leftElem];
		input[leftElem] = input[rightElem];
		input[rightElem] = temp;
	}
	
	public static void main(String [] args) {
		int [] foo = {3, 1, 2, 99, 235,3463,346,346,3475,24,2,6,346,2,846,587};
		sort(foo);
		for(int i : foo) System.out.print(i +" ");
	}

}
