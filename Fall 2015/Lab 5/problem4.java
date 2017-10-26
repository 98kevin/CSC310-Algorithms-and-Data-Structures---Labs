import java.io.*;
import java.util.*;


public class problem4 
{
     static int[] A;
     static int n;

    
    public static void heapify(int []a){
        A=a; n=A.length-1;
        for(int i=n/2;i>=0;i--){
            insert(A,i);
        }
    }
    
    public static void insert(int[] A, int i){ 
        int left=2*i;
        int right=2*i+1;
        int l;
        if(left <= n && A[left] > A[i]){
            l=left;
        }
        else{
            l=i;
        }
        
        if(right <= n && A[right] > A[l]){
            l=right;
        }
        if(l!=i){
        	swap(i,l); insert(A, l);
        }
    }
    
	public static void swap(int i1, int i2) {
		int t = A[i1];
		A[i1] = A[i2];
		A[i2] = t;
	}
   
    
  	public static void main(String[] args) throws FileNotFoundException
	{
		File f1 = new File("problem4.in");
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(f1);
			int te = scan.nextInt();
			for(int i = 0; i < te ; i++)
			{
				int test = scan.nextInt();
				int a[] = new int[test];
				
				for(int j = 0 ; j < test ; j++)
				{
					a[j] = scan.nextInt();
				}
				heapify(a);
				for(int j = 0 ; j < a.length ; j++)
				{
					System.out.print(a[j] + " ");
				}
				System.out.println();
			}
	
	
		
	}
}