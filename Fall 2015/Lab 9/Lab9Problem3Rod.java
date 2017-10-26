import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Lab9Problem3Rod//CPP
{

	public static void main(String[] args) throws FileNotFoundException 
	{
		File input=new File("p3.txt");

    	Scanner scan=new Scanner(input);
    	int testcases=scan.nextInt();
    	for(int i=0;i<testcases;i++)
    	{
    		int n=scan.nextInt();
    		int[] pricearray=new int[n];
    		int[] smthn=new int[n];
    		for(int j=0;j<n;j++)
    		{
    			pricearray[j]=scan.nextInt();
    			smthn[j]=-1;
    		}
    		System.out.println(cutRod2(pricearray,n));
    		int q=0;
    		System.out.println(cutrod_aux(pricearray, n-1, smthn,q));   
    		
    	}
    	scan.close();
	}

	public static int max(int a, int b) { return (a > b)? a : b;}
	public static int cutRod2(int price[], int n)
	{
	   int []val=new int[n+1];
	   val[0] = 0;
	   int i, j;
	   for (i = 1; i<=n; i++)
	   {
	       int max_val = Integer.MIN_VALUE;
	       for (j = 0; j < i; j++)
	         max_val = max(max_val, price[j] + val[i-j-1]);
	       val[i] = max_val;
	   }
	 
	   return val[n];
	}
	public static int cutrod_aux(int[] p, int n, int[] r, int q){

		 if (r[n]>=0){return r[n];}
		 if (n==0)   return q=0;
		 for(int i = 1; i <= n;i++){
		     q = max(q,p[i]+cutrod_aux(p,n-i,r,q));
		         }
		r[n]=q;
		return q;
		}

	/*
	
	private static int[] p = {0,1,5,8,9,10,17,17,20,24,30};
	private static int[] r = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};

	public static int cutrod_aux(int[] p, int n, int[] r){

	 if (r[n]>=0){return r[n];}
	 if (n==0)   return q=0;
	 for(int i = 1; i <= n;i++){
	     q = max(q,p[i]+cutrod_aux(p,n-i,r));
	         }
	r[n]=q;
	return q;
	}

	public static void main(String[] args) {

	   cutrod_aux(p, 10, r);   
	}*/
}