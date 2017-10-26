import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class problem1 {
	
	public static void  factorial(int number ) {
		
if (number == 0) {
	System.out.println("0");
}
else if (number < 0) {
	
}
else {
	System.out.println(factorialWork(number));
}}

public static int factorialWork (int number ) {
	
	if (number == 1)
		return 1;
	
else {
	
	return (number * factorialWork(number -1));
}
		
	}

public static void main (String[] args) throws FileNotFoundException {
	
	Scanner scan = new Scanner (new File("problem1.in"));
	while (scan.hasNextInt()){
		
		int george = scan.nextInt();
		factorial(george);
	}
}
	
}