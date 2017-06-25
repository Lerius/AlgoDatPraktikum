
public class iterativQS {
	public static void ITQS (int[] array, int arrayA, int arrayE)
	{
		int pivot;
		int [] beg = new int[50];
		beg[0] = 0;
		int [] end = new int [50];
		end[0] = array.length;
		int links = 0;
		int rechts = 0;
		int i = 0;
		while (i>=0)
		{
			links= beg[i];
			rechts = end[i]-1;
			if (links<rechts)
			{
				pivot = array[links];
				if (i == array.length-1)
				{
					break;
				}
				while (links < rechts)
				{
					while (array[rechts] >= pivot && links < rechts)
					{
						rechts--;
						if (links < rechts)
						{
							array[links++] = array[rechts];
						}
					}

					while (array[links] <= pivot && links < rechts)
					{
						links++;
						if (links < rechts)
						{
							array[rechts--] = array[links];
				}
				
			}
				}
				array[links] = pivot; 
				beg[i+1] = links+1;
				end[i+1] = end[i];
			    end[i++] = links;
				}
			else
			{
				i--;
			}
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
		ITQS(array, 0, array.length-1);
		ITQS(random, 0, random.length-1);
		ITQS(worst, 0, worst.length-1);
		ITQS(best, 0, best.length-1);
		for( int k: array )
		{
			System.out.println(k+" \n");
		}
	}
	}