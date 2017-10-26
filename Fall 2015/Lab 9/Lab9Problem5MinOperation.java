import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Lab9Problem5MinOperation
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		File input=new File("p5.txt");

    	Scanner scan=new Scanner(input);
    	int testcases=scan.nextInt();
    	for(int test=0;test<testcases;test++)
    	{
    		int n=scan.nextInt();
    		System.out.println(getMinOperations(n));
    	}
    	scan.close();
	}
	public static int getMinOperations(int n) {
		    // Use this array to store the previous solved result.
		    int dp[] = new int[n + 1];
		    // base case, if it is 1, we do not need to do any processing
		    dp[1] = 0;

		    for (int i = 2; i <= n; i++) {
		        // for the time being, let's assume we are getting minimum number of step by subtracting 1
		        dp[i] = 1 + dp[i - 1];
		        // if number if divisible by 2 let's divide it and compare it with the number of steps 
		        // calculated in previous step, choose the minimum one
		        if (i % 2 == 0)
		            dp[i] = Math.min(dp[i], 1 + dp[i / 2]);
		        // if number if divisible by 3 let's divide it and compare it with the number of steps 
		        // calculated in previous step, choose the minimum one
		        if (i % 3 == 0)
		            dp[i] = Math.min(dp[i], 1 + dp[i / 3]);
		        // At this step we have stored the minimum step to reduce the i to 1. and we will continue till nth value
		    }
		       // Returning nth value of array, as value at each index is the minimum number of steps to reduce it to 1.
		    return dp[n];
		}
}

