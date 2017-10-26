import java.io.File;
import java.util.Scanner;

public class Problem2 {

	static int heapSize = 0;

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("problem2.in"));
		int t = scan.nextInt();
		for (int i = 0; i < t; i++) {
			heapSize = 0;
			int n = scan.nextInt();
			int[] array = new int[n];

			for (int j = 0; j < n; j++) {
				add(array, scan.nextInt());
			}
			for (int value : array)
				System.out.print(value + " ");
			System.out.println();
		}
		scan.close();
	}

	public static void add(int[] array, int element) {
		array[heapSize] = element;
		heapSize++;
		heapify(array);
	}

	public static void heapify(int[] array) {
		int index = heapSize - 1;
		while (array[index] > array[parent(index)]) {
			int temp = array[index];
			array[index] = array[parent(index)];
			array[parent(index)] = temp;

			index = parent(index);
		}
	}

	public static int parent(int c) {
		return (c - 1) / 2;
	}
}
