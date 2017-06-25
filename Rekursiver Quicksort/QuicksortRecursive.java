import java.util.Arrays;

public class QuicksortRecursive {
	public static void quicksort(int[] data, int start, int end) {
		int pivot, left, right;
		
		if(start < end) {
			pivot = data[end];
			left = start;
			right = end-1;
			
			while(true) {
				while(data[left] < pivot && left < end) {
					left++;
				}
				while(data[right] > pivot && right > start) {
					right--;
				}
				
				if(left < right) {
					exchange(data, left, right);
					left++;
					right--;
				} else {
					break;
				}
			}					
			
			exchange(data, left, end);
			quicksort(data, start, left-1);
			quicksort(data, left+1, end);
		}
	}
	
	public static void exchange(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void printArray(int[] array) {
		System.out.println(Arrays.toString(array));
	}
	
	public static void main(String[] args) {
		int array [] = new int [50];
		int worst [] = new int [] {1,2,3,4,5,6,7,8,9,10};
		int best [] = new int [] {0, 4, 1, 3, 5, 6, 7, 2, 8};
		int random [] = new int [1000];
		int oberGrenze = 50; 
		int oberGrenze2 = 1000;

		for(int i = 0; i < array.length; i++) {
		     array[i] = (int)(Math.random()*oberGrenze);
		}
	    printArray(array);

		for(int i = 0; i < random.length; i++) {
		     random[i] = (int)(Math.random()*oberGrenze2); 
		}
		
		quicksort(array, 0, array.length-1);
		quicksort(best, 0, best.length-1);
		quicksort(random, 0, random.length-1);
		quicksort(worst, 0, worst.length-1);
		quicksort(best, 0, best.length-1);
		
		printArray(array);
	}
}
