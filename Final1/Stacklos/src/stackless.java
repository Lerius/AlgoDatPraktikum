
public class stackless {
	
	private static int counter = 0;
	
	public static void stackl(int[] array, int elements)
	{
		int pivot = 0;
		int[] beg = new int [array.length];
		beg[0] = 0;
		int[] end = new int [array.length];
		end[0] = elements;
		int i = 0;
		int links = 0;
		int rechts = 0;
		int swap = 0;
		
		while (i>=0)
		{
			links = beg[i];
			rechts = end[i]-1;
			if(links < rechts)
			{
				pivot = array[links];
			
				while (links < rechts)
				{
					while (array[rechts] >= pivot && links < rechts)
					{
						rechts--;
					}
				
					if (links < rechts)
					{
						array[links++] = array [rechts];
					}
				
					while (array[links] <= pivot && links < rechts)
					{
						links++;
					}
				
					if (links < rechts)
					{
						array[rechts--] = array [links];
					}
				}
				
				array[links] = pivot;
				beg[i+1] = links+1;
				end[i+1] = end[i];
				end[i++] = links;
			
				if (end[i]-beg[i] > end[i-1]-beg[i-1])
				{
					swap = beg[i];
					beg[i] = beg[i-1];
					beg[i-1]=swap;
				swap = end[i];
				end[i] = end[i-1];
				end[i-1] = swap;
				}
			}
			else
			{
				i--;
			}
		}
	}

	public static void main(String[] args) {

		int array [] = new int [10];
		int worst [] = new int [] {1,2,3,4,5,6,7,8,9,10};
		int best [] = new int [] {4, 1, 3, 5, 6, 7, 2};
		int random [] = new int [1000];
		int oberGrenze = 50; 
		int oberGrenze2 = 1000;

		for(int i = 0; i < array.length; i++) {
		     array[i] = (int)(Math.random()*oberGrenze); 
		}
		for(int i = 0; i < random.length; i++) {
		     random[i] = (int)(Math.random()*oberGrenze2); 
		}


		stackl(array, array.length);
		//stackl(random, random.length);
		//stackl(worst, worst.length);
		//stackl(best, best.length);
		
		for( int k: array )
		{
			System.out.println(k);
		}

	}

}
