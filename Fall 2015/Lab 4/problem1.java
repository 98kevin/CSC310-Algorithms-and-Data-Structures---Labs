import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class problem1
{
	public static void main(String []args) throws FileNotFoundException
	{
		File input=new File("problem1.in");
		
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
			int target=scan.nextInt();
			boolean answer=groupSum(0, arr, target);
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
	public static boolean groupSum(int start, int[] nums, int target)
	{
	  if(target == 0)
	  	return true;
	  if(start == nums.length)
	  	return false;
	  if(groupSum(start + 1, nums, target - nums[start]))
	  	return true;
	  return groupSum(start + 1, nums, target);
	}
}