import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class problem5
{
	public static void main(String []args) throws FileNotFoundException
	{
		File input=new File("problem5.in");
		
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
			
			if (split53(arr) == true) {
				System.out.println("Yes");
			}
			else 
			{
				System.out.println("No");
			}
			testcases--;
		}
			
	}
	public static boolean split53(int[] nums) {
	    int start = 0, firstPart = 0, secondPart = 0;
	    if (split(start, nums, firstPart, secondPart)) {
	        return true;
	    }
	    return false;
	}

	public static boolean split(int start, int[] nums, int firstPart, int secondPart) {
	    if (start >= nums.length) {
	        return (firstPart == secondPart);
	    }
	    if ((start + 1) < nums.length
	            && (nums[start] % 3 != 0)
	            && (nums[start + 1] % 5 != 0)
	            && split(start + 2, nums, firstPart + nums[start], secondPart
	                    + nums[start + 1])) {
	        return true;
	    }
	    if ((start + 1) < nums.length
	            && (nums[start + 1] % 3 != 0)
	            && (nums[start] % 5 != 0)
	            && split(start + 2, nums, firstPart + nums[start + 1],
	                    secondPart + nums[start])) {
	        return true;
	    }
	    if ((nums[start] % 3 != 0)
	            && split(start + 1, nums, firstPart + nums[start], secondPart)) {
	        return true;
	    }
	    if ((nums[start] % 5 != 0)
	            && split(start + 1, nums, firstPart, secondPart + nums[start])) {
	        return true;
	    }
	    return false;
	}
}