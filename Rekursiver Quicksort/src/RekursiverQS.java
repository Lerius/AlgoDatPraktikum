
public class RekursiverQS {
	public static void rekQS(int[] array, int arrayA, int arrayE)
	{
		int help = 0;
		int links = 0;
		int rechts = 0;
		if (arrayA < arrayE)
		{
			help = array[arrayE];
			links = arrayA;
			rechts = arrayE-1;
			while (true)
			{
				while (array[links] < help)
				{
					links = links + 1;	
				}
				while (array[rechts] > help)
				{
					rechts = rechts - 1;
				}
			if (links < rechts)
			{
				int helpvar = array[links];
				array[links] = array[rechts];
				array[rechts] = helpvar;
				links = links + 1;
				rechts = rechts - 1; 
			}
			else 
			{
				break;
			}
			}
			int helpvar = array[links];
			array[links] = array[arrayE];
			array[arrayE] = helpvar;
			
			rekQS(array, arrayA, links-1);
			rekQS(array, links+1, arrayE);
		}
		
	}

	public static void main(String[] args) {
		int array [] = new int [50];
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


		rekQS(array, 0, array.length-1);
		rekQS(random, 0, random.length-1);
		rekQS(worst, 0, worst.length-1);
		rekQS(best, 0, best.length-1);
		for( int k: array )
		{
			System.out.println(k+" \n");
		}

	}

}
