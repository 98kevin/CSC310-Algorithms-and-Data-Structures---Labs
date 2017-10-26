import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class problem4
{
	public static void main(String []args) throws FileNotFoundException
	{
		// Read file lab3.in
		File f1 = new File("lab3.in");
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
				CountingSort(a);
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
	
	//counting sort
	public static void CountingSort(int[]arr)
	{
		int N = arr.length;
		if (N == 0)
			return;
		//find max //
		int max = arr[0];
		for (int i = 1; i < N; i++)
		{
			if (arr[i] > max)
				max = arr[i];
		}
		int range = max+1;

		int[] count = new int[range];
		for (int i = 0; i < N; i++)
		{
			count[arr[i]]++;
		}


		int last=0;
		for(int i=0;i<range;i++)
		{
			if(count[i]!=0)
			{
				int repeats=count[i];
				for(int j=0;j<repeats;j++)
				{
					arr[last+j]=i;
				}
				last=last+repeats;
			}
		}

	}
}