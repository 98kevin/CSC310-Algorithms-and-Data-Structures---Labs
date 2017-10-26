import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Lab9Problem4LCS
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		File input=new File("p4.txt");

    	Scanner scan=new Scanner(input);
    	int testcases=scan.nextInt();
    	for(int test=0;test<testcases;test++)
    	{
    		int i,j;
    		String X=scan.next();
    		String Y=scan.next();
    	    int n = X.length();
    	    int m = Y.length();
    	    int[][] C = new int[n+1][m+1];
    	    int[][] B = new int[n+1][m+1];

    	    /* C[i][0] = 0 for 0<=i<=n */
    	    for (i = 0; i <= n; i++) {
    	        C[i][0] = 0;
    	    }

    	    /* C[0][j] = 0 for  0<=j<=m */
    	    for (j = 0; j <= m; j++) {
    	        C[0][j] = 0;
    	    }
    	    
    	    /* dynamic programming */
    	    for (i = 1; i <= n; i++) {
    	        for (j = 1; j <= m; j++) {
    	            if (X.charAt(i-1) == Y.charAt(j-1)) {
    	                C[i][j]=C[i-1][j-1]+1;
    	                B[i][j]=1;  /* diagonal */
    	            }
    	            else if (C[i-1][j]>=C[i][j-1]) {
    	                C[i][j]=C[i-1][j];
    	                B[i][j] = 2;  /* down */
    	            }
    	            else {
    	                C[i][j]=C[i][j-1];     
    	                B[i][j]=3;   /* forword */
    	            }
    	        }
    	    }
    	    /* Backtracking */
    	    String lcs = new String();
    	    i=n;
    	    j=m;
    	    while (i!=0 && j!=0) {
    	        if (B[i][j] ==1) {   /* diagonal */
    	            lcs =X.charAt(i-1) + lcs;
    	            i = i - 1;
    	            j = j - 1;
    	        }
    	        if (B[i][j] == 2) {  /* up */
    	            i = i - 1;
    	        }
    	        if (B[i][j] == 3) {  /* backword */
    	            j = j - 1;
    	        }
    	    }
    	    
    	    /* print out the result */
 //   	    System.out.println("String X is " + X);
  //  	    System.out.println("String Y is " + Y);
    	    System.out.println("The length of LCS is " + C[n][m]);
 //   	    System.out.println("The LCS is " + lcs);
    	        		
    	}
    	scan.close();
	}
}