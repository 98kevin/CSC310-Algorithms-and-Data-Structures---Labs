import java.io.*;
import java.util.*;

public class problem1
{
	
	public static void main(String[] args) throws FileNotFoundException
	{
		File f1 = new File("problem1.in");
		try
		{
			@SuppressWarnings("resource")
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
				quickSort(a,0,a.length-1);
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
	public static void quickSort(int A[], int start, int end) {
		if (start < end) {
			int pivot = partition(A, start, end);
			quickSort(A, start, pivot-1);
			quickSort(A, pivot+1, end);
		}
	}
	
	public static int partition(int A[], int start, int end) {
		int x = A[start];
		
		int i = start;
		
		for (int j = start+1; j <= end; j++)
			if (A[j] <= x) {
				i++;
				swap(A, i, j);
			}
		
		swap(A, start, i);
		
		return i;
	}

	public static void swap(int A[], int index1, int index2) {
		int temp = A[index1];
		A[index1] = A[index2];
		A[index2] = temp;
	}
	

	
}
