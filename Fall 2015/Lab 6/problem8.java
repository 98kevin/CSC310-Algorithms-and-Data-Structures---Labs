import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Lab6Problem8LCS 
{
  	public static void main(String[] args) throws FileNotFoundException
	{
		File f1 = new File("problem8.txt");
		try
		{
			Scanner scan = new Scanner(f1);
			
			int testcases = scan.nextInt();
			for(int i = 0; i < testcases ; i++)
			{
				String a= scan.next();
				String b= scan.next();
				String common=lcsRec(a,b);
				System.out.println(common.length());
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
	}
  	
  	public static String lcsRec(String a, String b)
  	{
  		String longest="";
  		String shortest="";
  		if(a.length()>=b.length()) {longest=a; shortest=b;}
  		else {longest=b; shortest=a;}
  		
  	//	System.out.println("lon sho "+longest+" "+shortest);
  		for(int short_size=shortest.length();short_size>=1;short_size--)
  		{
  		//	System.out.println("shortsize "+short_size+" length "+shortest.length());
  			for(int start=0, end=short_size; start<=shortest.length()-short_size;start++, end++)
  			{
  				String maybe=shortest.substring(start,end);
  			//	System.out.println("maybe "+maybe);
  				if (longest.contains(maybe)) {return maybe;}

  			}
  		}
  		return "";
  	}
}