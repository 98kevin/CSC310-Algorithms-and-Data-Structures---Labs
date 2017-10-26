import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//2
public class problem7
{
	public static void main(String []args) throws FileNotFoundException
	{
		File input=new File("problem7.in");
		
		Scanner scan=new Scanner(input);
		int testcases=scan.nextInt();
		while(testcases>0)
		{
			int number=scan.nextInt();
			int[] arr=new int[number];
			for (int i=0;i<number;i++)
			{
				arr[i]=scan.nextInt();
			}
			lis(arr);
			testcases--;
		}
			
	}
	public static int recurlis( int arr[], int n, int max_ref)
	{
	    if(n == 1)
	        return 1;
	 
	    int res, max_ending_here = 1; // length of LIS ending with arr[n-1]
	 
	    for(int i = 1; i < n; i++)
	    {
	        res = recurlis(arr, i, max_ref);
	        if (arr[i-1] < arr[n-1] && res + 1 > max_ending_here)
	            max_ending_here = res + 1;
	    }
	 
	    if (max_ref < max_ending_here)
	       max_ref = max_ending_here;
	 
	    return max_ending_here;
	}
	 
	public static void lis(int arr[])
	{
	    int n=arr.length;
	    int max = 1;
	    max=recurlis( arr, n, max );
	    System.out.println(max);
	}
}