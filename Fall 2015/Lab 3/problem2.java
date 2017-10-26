import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class problem2 {
	public static void main(String[] args) throws FileNotFoundException {
		// Read file lab3.in
		File f1 = new File("lab3.in");
		try {
			Scanner scan = new Scanner(f1);

			int testcases = scan.nextInt();
			for (int i = 0; i < testcases; i++) {
				int test = scan.nextInt();
				int a[] = new int[test];

				for (int j = 0; j < test; j++) {
					a[j] = scan.nextInt();
				}
				InsertionSort(a);
				for (int j = 0; j < a.length; j++) {
					System.out.print(a[j] + " ");
				}
				System.out.println();

			}
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();

		}

	}

	// Insertion sort method
	public static void InsertionSort(int A[]) {
		int key = 0;

		for (int i = 1; i < A.length; i++) {
			key = A[i];

			int j = i;

			while (j > 0 && A[j - 1] > key) {
				A[j] = A[j - 1];
				j--;
			}

			A[j] = key;
		}
	}
}