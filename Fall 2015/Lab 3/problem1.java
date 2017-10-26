import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class problem1
{
	public static void main(String []args) throws FileNotFoundException
	{
		//Read file lab3.in
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
				SelectionSort(a);
				System.out.println();
			}
		}
		catch (FileNotFoundException exception) 
		{
			exception.printStackTrace();
			
		}
	
	}
	//SelectionSort method
	public static void SelectionSort(int A[]) {
		for(int i = 0 ; i < A.length ; i++)
		{
			int min = min(A,i,A.length);
			
			int temp = A[i];
			A[i] = A[min];
			A[min] = temp;
		}
		for(int i = 0 ; i < A.length ; i++)
		{
			System.out.print(A[i] + " ");
		}
	}
	//Calculating the minimum
	public static int min(int[]a , int start ,int end)
	{
		int min = a[start];
		int minindex = start;
		
		for(int i = start ; i < end ; i++)
		{
			if(a[i] < min)
			{
				min = a[i];
				minindex = i;
			}
		}
		return minindex;
	}
}