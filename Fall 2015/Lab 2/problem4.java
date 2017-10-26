import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class problem4 
{

    public static void main(String args[]) throws FileNotFoundException
    {
		File input=new File("problem4.in");

    	Scanner scan=new Scanner(input);
    	while(scan.hasNext())
    	{
    		String s=scan.next();
    		if (s.contains("-"))
    			break;
    		boolean bool=checkPalindrome(s);
    		if (bool)
    		{
    			System.out.println("Yes");
    		}
    		else
    		{
    			System.out.println("No");
    		}
    	}
    }
    
    public static boolean isPal(String s)
    {   
    	if(s.length() == 0 || s.length() == 1)
            return true; 
        if(s.charAt(0) == s.charAt(s.length()-1))
        	return isPal(s.substring(1, s.length()-1));
        return false;
        
    }
    private static boolean checkPalindrome(String word) {
    	  if(word.length() < 2) { return true;  }
    	  char first  = word.charAt(0);
    	  char last   = word.charAt(word.length()-1);
    	  if(  first != last  ) { return false; }
    	  else { return checkPalindrome(word.substring(1,word.length()-1)); }
    	}
}
