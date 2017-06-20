public class QS 
{
	static int [] quicksort(int a[])
	{
		int help[] = new int [a.length];
		help = a;
		int hilfe;
		int x;
		int l;
		int r;
		int i = 0;
		int j = a.length-1;
		if (a[i] < a[j])
		{
			x = a[a.length-1];
			l = i;
			r = j-1;
			while (i<j)
			{
				while (a[l] < x)
				{
					l = l+1;
				}
				while (a[r] > x)
				{
					r = r-1;
				}
				if (l < r)
				{
					
					hilfe = a[l];
					a[l]=a[r];
					a[r]=hilfe;
					l=l+1;
					r=r-1;
				}
			
				break;
			}
		}
		else 
			{
				l = i;
				hilfe = a[l];
				a[l]=a[j];
				a[j]=hilfe;
				a = quicksort(a);
			}
		
		int ha1[] = new int [l-1];
		for (int p = 0; p < ha1.length;p++)
		{
				ha1[p] = a[p];
		}
		int ha2[] = new int [(a.length)-l+1];
		for (int p = 0; p < ha2.length;p++)
		{
				ha2[p] = a[p];
		}
		
		System.arraycopy(ha1, 0, a, 0, ha1.length-1);
		System.arraycopy(ha2, 0, a, 0, ha2.length-1);
		a = quicksort(a);
		
		
		
			return a;
		}
		
	


	public static void main(String[] args) {
		
		int size = 10;
		int liste[] = new int [size];
		  for (int i = 0; i < liste.length; i++)
		  {
			  liste[i] = (int)(Math.random()*10);
		  }
		  quicksort(liste);
		  for (int i=0; i<liste.length; i++)
		  {
			  System.out.println(liste[i]);
		  }
		  

	}

	}

