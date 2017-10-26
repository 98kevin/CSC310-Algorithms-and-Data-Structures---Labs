import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class problem1 {

	public static void main(String args[]) throws FileNotFoundException {

		File input = new File("graph.in");

		Scanner scan = new Scanner(input);
		int N = scan.nextInt();
		for (int i = 0; i < N; i++) {
			int v = scan.nextInt();
			int e = scan.nextInt();
			int A[][] = new int[v][v];
			int degrees[] = new int[v];
			for (int j = 0; j < e; j++) {
				int a = scan.nextInt();
				int b = scan.nextInt();
				A[a][b] = 1;
				A[b][a] = 1;
				degrees[a]++;
				degrees[b]++;
			}
			int seen[] = new int[v];

			printdegrees(degrees);
		}
		scan.close();
	}

	public static void printdegrees(int[] degrees) {
		for (int i = 0; i < degrees.length; i++) {
			System.out.println(i + ": " + degrees[i]);
		}
	}
}