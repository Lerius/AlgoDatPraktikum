
public class probQS {
	public static void ProbQS(int[] array, int arrayA, int arrayE)
	{
		int pivot = 0;
		int links = 0;
		int rechts = 0;
		if (arrayA < arrayE)
		{
			int exchangehelp = (int)(Math.random()*arrayE+1);
			int exchange = array[arrayE];
			array[arrayE] = array[exchangehelp];
			array[exchangehelp] = exchange;
			pivot = array[arrayE];
			links = arrayA;
			rechts = arrayE-1;
			while (true)
				{
				while (array[links] < pivot)
				{
					links = links + 1;	
				}
				while (array[rechts] > pivot)
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
				break;			}
			}
			int helpvar = array[links];
			array[links] = array[arrayE];
			array[arrayE] = helpvar;
			
			ProbQS(array, arrayA, links-1);
			ProbQS(array, links+1, arrayE);
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
		ProbQS(array, 0, array.length-1);
		ProbQS(random, 0, random.length-1);
		ProbQS(worst, 0, worst.length-1);
		ProbQS(best, 0, best.length-1);
		for( int k: array )
		{
			System.out.println(k+" \n");
		}

	}

}