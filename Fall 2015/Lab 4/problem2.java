import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class problem2
{
	public static void main(String []args) throws FileNotFoundException
	{
		File input=new File("problem2.in");
		
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
			mergeSort(arr,0,arr.length-1);
			for (int i=0;i<arr.length;i++)
			{
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			testcases--;
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
	
}
