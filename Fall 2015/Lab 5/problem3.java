import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class problem3
{
	
	public static void main(String[] args) throws FileNotFoundException
	{
		File f1 = new File("problem3.in");
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
				mergeSort(a,0,a.length-1);
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

	public static void mergeSort(int A[], int start, int end) {
		if (start < end) {
			int mid = (start + end)/2;
			mergeSort(A, start, mid);
			mergeSort(A, mid+1, end);
			merge(A, start, mid, mid+1, end);
		}
	}
	
	public static void merge(int A[], int s1, int e1, int s2, int e2) {
		int B[] = new int[e2 - s1 + 1];
		
		int i = s1, j = s2, k = 0;
		
		while (i <= e1 && j <= e2) {
			if(A[i] < A[j])
				B[k++] = A[i++];
			else
				B[k++] = A[j++];
		}
		
		while (i <= e1)
			B[k++] = A[i++];
		
		while (j <= e2)
			B[k++] = A[j++];
		
		k = 0;
		
		for (i = s1; i <= e2; i++)
			A[i] = B[k++];
	}
	

	public static void swap(int A[], int index1, int index2) {
		int temp = A[index1];
		A[index1] = A[index2];
		A[index2] = temp;
	}
}
