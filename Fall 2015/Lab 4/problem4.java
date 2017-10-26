import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//2
public class problem4
{
	public static void main(String []args) throws FileNotFoundException
	{
		File input=new File("problem4.in");
		
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
	public static int recurlis( int arr[], int n, int rf)
	{
	    if(n == 1)
	        return 1;
	 
	    int res, me = 1; 
	 
	    for(int i = 1; i < n; i++)
	    {
	        res = recurlis(arr, i, rf);
	        if (arr[i-1] < arr[n-1] && res + 1 > me)
	            me = res + 1;
	    }
	 
	    if (rf < me)
	       rf = me;
	 
	    return me;
	}
	 
	public static void lis(int arr[])
	{
	    int n=arr.length;
	    int max = 1;
	    max=recurlis( arr, n, max );
	    System.out.println(max);
	}
}