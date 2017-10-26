import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Lab9Problem3RodCpp
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		File input=new File("p3.txt");

    	Scanner scan=new Scanner(input);
    	int testcases=scan.nextInt();
    	for(int i=0;i<testcases;i++)
    	{
    		System.out.println(1);
    		int n=scan.nextInt();
    		int[] array=new int[n];
    		System.out.println(cutRod(array,8));
    		
    	}
    	scan.close();
	}
	//note: to find the solution for a certain length we pass the length+1 as a param...for example
	//solution of length 7 = cutRod(p,8);
	    public static int cutRod(int p[],int n)
	    {
	        int r[] = new int[n];
	        int s[] = new int [n];
	        int q;
    		System.out.println(2);
    		int count=3;
	        for(int i=0;i<n;i++)
	        {
	            q = Integer.MIN_VALUE;
	    		System.out.println(++count);

	            for(int j=0;j<=i;j++)
	                if(q < p[j] + r[i-j])
	                {
	                    q = p[j] + r[i-j];
	                    s[i] = j;
	                }
	            r[i] = q;
	        }
	        System.out.println("out");
	        //printSol(s, n-1);

	        return r[n-1];
	    }

	    public static void printSol(int s[],int n)
	    {
	        int m = n;

	        while(m > 0)
	        {
	            System.out.print(s[m]+" ");
	            m -= s[m];
	        }
	    }
	}