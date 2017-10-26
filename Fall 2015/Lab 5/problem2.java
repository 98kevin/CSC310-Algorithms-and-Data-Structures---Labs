import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class problem2
{
	
	public static void main(String[] args) throws FileNotFoundException
	{
		File f1 = new File("problem2.in");
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
				quickSort(a);
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
	public static void quickSort(int[] a) {
	    recQuickSort(a, 0, a.length - 1);
	  }

	  public static void recQuickSort(int[] a, int l, int r) {
	    int size = r - l + 1;
	    if (size <= 3)
	      bruteforceSort(a, l, r);
	    else {
	      double median = medianOf3(a, l, r);
	      int partition = partitionIt(a, l, r, median);
	      recQuickSort(a, l, partition - 1);
	      recQuickSort(a, partition + 1, r);
	    }
	  }

	  public static int medianOf3(int[] a, int l, int r) {
	    int c = (l + r) / 2;

	    if (a[l] > a[c])
	      swap(a, l, c);

	    if (a[l] > a[r])
	      swap(a, l, r);

	    if (a[c] > a[r])
	      swap(a, c, r);

	    swap(a, c, r - 1);
	    return a[r - 1];
	  }

	  public static void swap(int[] a, int dex1, int dex2) {
	    int temp = a[dex1]; a[dex1] = a[dex2];  a[dex2] = temp;
	  }

	  public static int partitionIt(int[] a, int l, int r, double p) {
	    int lPtr = l;
	    int rPtr = r - 1;

	    while (true) {
	      while (a[++lPtr] < p)
	        ;
	      while (a[--rPtr] > p)
	        ;
	      if (lPtr >= rPtr)
	        break;
	      else
	        swap(a, lPtr, rPtr);
	    }
	    swap(a, lPtr, r - 1);
	    return lPtr;
	  }

	  public static void bruteforceSort(int[] a, int l, int r) {
	    int size = r - l + 1;
	    if (size <= 1)
	      return;
	    if (size == 2) {
	      if (a[l] > a[r])
	        swap(a, l, r);
	      return;
	    } else {
	      if (a[l] > a[r - 1])
	        swap(a, l, r - 1);
	      if (a[l] > a[r])
	        swap(a, l, r);
	      if (a[r - 1] > a[r])
	        swap(a, r - 1, r);
	    }
	  }

	}