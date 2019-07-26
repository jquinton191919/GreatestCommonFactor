package sort;
/*****
 * Heap Sort
 * 1. Heapify the array from the bottom to the very first element; but don't heapify the "last row", which is the second half
 * of the array (i.e., it's a binary tree)
 * 1a. Heapify means that since it's a binary tree, the "left" child is 2 * ElementNumber + 1, and 
 * the "right" child is 2 * ElementNumber + 2. Parents should always be a higher number than its two children
 * 1b. If a switch is made (so that the higher number is the parent) recursively heap on the child node that was switched
 *  
 * 2. Switch the first element and the last element. Reheap the array but leave out the recently switched last element, 
 * which increases by 1 on each iteration
 * 3. Stop the loop when the 0th and 1th element are the only ones that remain (e.g., loop while(i > 1))
 * 
 * *********/
public class HeapSort {
	
	private HeapSort() {}
	
	public static void main(String [] args) {
		int [] foo = {6, 5, 3, 1, 8, 7, 2, 4}; // heaped: 8 6 7 4 5 3 2 1 
		sort(foo);
		for(int i : foo) System.out.print(i + " ");
	}
	
	public static long sort(int [] input) {
		long start = System.currentTimeMillis();
		for(int i=input.length / 2; i >= 0; i--) {
			heapify(input, i, input.length);
		}
		flipHeap(input);
		return (System.currentTimeMillis() - start);
	}
	
	public static void heapify(int [] input, int start, int end) {
		int left = (2 * start + 1 >= input.length) ? -1 : 2 * start +1,
				right = 2 * start + 2 >= input.length ? -1: 2 * start + 2, 
				largest = -1;
		if( (left == -1) && (right == -1) ) {
			//oh
		}
		else if( (left >= end) || (right >= end) ){
			//no
		}
		
		else{
			if( (left != -1) && (right != -1) ){
				largest = input[left] > input[right] ? left : right;
			}
			
			else if( (left == -1) && (right != -1) ){
				largest = input[start] > input[right] ? start : right;
			}
			else if( (left != -1) && (right == -1) ){
				largest = input[start] > input[left] ? start : left;
			}
			
			largest = input[start] > input[largest] ? start : largest;
			
			if(largest == start);
			
			else {
				swap(input, start, largest);
				heapify(input, largest, end);
			}
		}
		
		
	}
	
	public static void flipHeap(int [] input){
		for(int i = input.length - 1; i > 1; i-- ){
			swap(input, i, 0);
			heapify(input, 0, i);
		}
			
	}
	
	public static void swap(int [] input, int leftElem, int rightElem){
		int temp = input[leftElem];
		input[leftElem] = input[rightElem];
		input[rightElem] = temp;
	}

}
