import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Test {

	public static void main(String[] args) throws IOException {
		Random gen = new Random();
		File input, output;
		FileWriter fwinput, fwoutput;
		BufferedWriter bwinput, bwoutput;

		for(int i = 1; i <= 6; i++)
		{
			input = new File("sort"+i+".in");
			fwinput = new FileWriter(input);
			bwinput = new BufferedWriter(fwinput);
			
			output = new File("sort"+i+".out");
			fwoutput = new FileWriter(output);
			bwoutput = new BufferedWriter(fwoutput);
			
			bwinput.write("7");
			bwinput.newLine();
			
			for(int j = 0; j < 7; j++)
			{
				int[] a = new int[gen.nextInt(40)+5];
				System.out.println(a.length);
				bwinput.write(a.length+" ");
				for(int k = 0; k < a.length; k++)
				{
					a[k] = gen.nextInt(100) + 10;
					bwinput.write(a[k]+" ");
				}
				bwinput.newLine();
				Arrays.sort(a);
				for(int k = 0; k < a.length; k++)
				{
					bwoutput.write(a[k]+" ");
				}
				bwoutput.newLine();
				bwoutput.flush();
				bwinput.flush();
			}
		}
	}
}
