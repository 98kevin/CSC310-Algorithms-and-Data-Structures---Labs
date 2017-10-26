import java.io.*;
import java.util.*;

public class problem3
{
	public static void main(String []args) throws FileNotFoundException
	{
		File input=new File("problem3.in");
		Scanner scan=new Scanner(input);
		int testcases=scan.nextInt();
		
		while(testcases>0)
		{
			int number=scan.nextInt();
			int arr[]=new int[number];
			for (int i=0; i<number;i++)
			{
				arr[i]=scan.nextInt();
			}
			boolean answer=split53(arr);
			if (answer)
			{
				System.out.println("Yes");
			}
			else
			{
				System.out.println("No");
			}

			testcases--;
		}
			
	}
	public static boolean split53(int[] n) {
	    int s = 0, f = 0, sP = 0;
	    if (split(s, n, f, sP)) {
	        return true;
	    }
	    return false;
	}

	public static boolean split(int s, int[] n, int f, int sP) {
	    if (s >= n.length) {
	        return (f == sP);
	    }
	    if ((s + 1) < n.length && (n[s] % 3 != 0) && (n[s + 1] % 5 != 0) && split(s + 2, n, f + n[s], sP + n[s + 1])) {
	        return true;
	    }
	    if ((s + 1) < n.length && (n[s + 1] % 3 != 0) && (n[s] % 5 != 0) && split(s + 2, n, f + n[s + 1],  sP + n[s])) {
	        return true;
	    }
	    if ((n[s] % 3 != 0) && split(s + 1, n, f + n[s], sP)) {
	        return true;
	    }
	    if ((n[s] % 5 != 0) && split(s + 1, n, f, sP + n[s])) {
	        return true;
	    }
	    return false;
	}
}