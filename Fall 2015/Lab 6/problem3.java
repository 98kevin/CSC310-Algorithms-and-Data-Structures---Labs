import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Lab6Problem3HeapSort 
{
    private static int[] A;
    private static int n;

    
    public static void heapify(int []A){
        n=A.length-1;
        for(int i=n/2;i>=0;i--){
            insert(A,i);
        }
    }
    
    public static void insert(int[] A, int i){ 
        int left=2*i;
        int right=2*i+1;
        int largest;
        if(left <= n && A[left] > A[i]){
            largest=left;
        }
        else{
            largest=i;
        }
        
        if(right <= n && A[right] > A[largest]){
            largest=right;
        }
        if(largest!=i){
            swap(i,largest);
            insert(A, largest);
        }
    }
    
	public static void swap(int index1, int index2) {
		int temp = A[index1];
		A[index1] = A[index2];
		A[index2] = temp;
	}
   
  
    public static void heapSort(int []a){
        A=a;
        heapify(A);
        
        for(int i=n;i>0;i--){
            swap(0, i);
            n=n-1;
            insert(A, 0);
        }
    }
    
  	public static void main(String[] args) throws FileNotFoundException
	{
		File f1 = new File("problem3.txt");
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
				heapSort(a);
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
}
