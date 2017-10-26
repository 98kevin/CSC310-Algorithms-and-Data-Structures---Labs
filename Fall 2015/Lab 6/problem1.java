import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Lab6Problem1Radix 
{
  	public static void main(String[] args) throws FileNotFoundException
	{
		File f1 = new File("problem1.txt");
		try
		{
			Scanner scan = new Scanner(f1);
			
			int testcases = scan.nextInt();
			for(int i = 0; i < testcases ; i++)
			{
				int test = scan.nextInt();
				int a[] = new int[test];
				
				for(int j = 0 ; j < test ; j++)
				{
					a[j] = scan.nextInt();
				}
				a=radixsort2(a);
				for(int j = 0 ; j < a.length ; j++)
				{
					System.out.print(a[j] + " ");
				}
				System.out.println();
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
	}
  	public static void Radixsort1( int[] a)
    {
        int i, m = a[0], exp = 1, n = a.length;
        int[] b = new int[10];
        for (i = 1; i < n; i++)
            if (a[i] > m)
                m = a[i];
        while (m / exp > 0)
        {
            int[] bucket = new int[10];
 
            for (i = 0; i < n; i++)
                bucket[(a[i] / exp) % 10]++;
            for (i = 1; i < 10; i++)
                bucket[i] += bucket[i - 1];
            for (i = n - 1; i >= 0; i--)
                b[--bucket[(a[i] / exp) % 10]] = a[i];
            for (i = 0; i < n; i++)
                a[i] = b[i];
            exp *= 10;        
        }
    } 
  	public static int[] radixsort2(int[] old) {
  	    for (int shift = Integer.SIZE - 1; shift > -1; shift--) {
  	        int[] tmp = new int[old.length];
  	        int j = 0;
  	        for (int i = 0; i < old.length; i++) {
  	            boolean move = old[i] << shift >= 0;
  	            if (shift == 0 ? !move : move) {
  	                tmp[j] = old[i];
  	                j++;
  	            } else {
  	                old[i - j] = old[i];
  	            }
  	        }
  	        for (int i = j; i < tmp.length; i++) {
  	            tmp[i] = old[i - j];
  	        }
  	        old = tmp;
  	    }
  	    return old;
  	}
}
