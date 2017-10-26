import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class problem3
{
	public static void main(String []args) throws FileNotFoundException
	{
		// Read file lab3.in
		File f1 = new File("lab3.in");
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
				BubbleSort(a);
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
	//bubble sort method
	public static void BubbleSort(int a[]) {
		boolean swapped=false;
		for(int i = 0 ; i < a.length ; i++)
		{
			for(int j = 0; j < a.length-1;j++)
			{
				if(a[j] > a[j+1])
				{
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					swapped=true;
				}
			}
			if (swapped==false)
			{
				return;
			}
		}
	}
}