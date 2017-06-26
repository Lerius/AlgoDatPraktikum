import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class ProbQS {
	
	private static int counter = 0; //Vergleiche
	private static int call = 0; //Quicksort-Aufrufe
	
	public static void quicksort(int[] array, int start, int end) //Quicksort
	{
		int pivot, left, right;
		call++;
		if (start < end) 
		{
			exchange(array, getRandom(start, end), end); //Zufälliges Element des Arrays wird an letzte Stelle verschoben
			pivot = array[end]; //Pivotelement => letztes Arrayelement
			left = start; //linker Sortierrand
			right = end-1; //Rechter Sortierrand
			
			while(true) 
			{
				while (array[left] < pivot && left < end) 
				{
					left++;
					counter++;
				}
				while (array[right] > pivot && right > start) 
				{
					right--;
					counter++;
				}
				
				if(left < right) 
				{
					exchange(array, left, right);
					left++;
					right--;
				} else {
					break;
				}
			}
			
			exchange(array, left, end); //Austausch
			quicksort(array, start, left-1);
			quicksort(array, left+1, end);
		}
	}
	
	public static void exchange(int[] array, int i, int j) //Methode zum austauschen zweier Arrayfelder 
	{		
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static int getRandom(int i, int j) //Random-Feld aus Array deklarieren
	{
		return ThreadLocalRandom.current().nextInt(i, j);
	}
	
	public static void printArray(int[] array) 
	{
		System.out.println(Arrays.toString(array));
	}
	
	public static void main(String[] args) 
	{
		//Testdaten
		int array[] = new int[50];
		int worst[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int best[] = new int[] {1, 3, 2, 6, 5, 7, 4};
		int random[] = new int[1000];
		int oberGrenze = 50;
		int oberGrenze2 = 1000;

		for (int i = 0; i < array.length; i++) 
		{
			array[i] = (int) (Math.random() * oberGrenze);
		}
		
		for (int i = 0; i < random.length; i++) 
		{
			random[i] = (int) (Math.random() * oberGrenze2);
		}
		
		printArray(best);
		
		//quicksort(array, 0, array.length - 1);
		//quicksort(random, 0, random.length - 1);
		//quicksort(worst, 0, worst.length - 1);
		quicksort(best, 0, best.length - 1);
		
		printArray(best);
		
		System.out.println(counter);
		System.out.println(call);		
	}
}