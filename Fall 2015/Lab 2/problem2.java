import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class problem2 {
	
	public static int  fibonnaci(int n ) {
		
		if (n == 0) 
			return 0;
		else if (n == 1)
			return 1;
		else 
			return fibonnaci(n-1) + fibonnaci(n-2);
		
		
		
	}
	public static void main (String[] args) throws FileNotFoundException {
		int i = 0;

		Scanner scan = new Scanner (new File("problem2.in"));
		while (scan.hasNextInt()){
			
			
			if (i == 0 )
				
			{		
				int george = scan.nextInt();

				i++;

			}
			else {
			int george = scan.nextInt();
			
			System.out.println(fibonnaci(george+1));
			i++;
			}
		}
	}
	
}