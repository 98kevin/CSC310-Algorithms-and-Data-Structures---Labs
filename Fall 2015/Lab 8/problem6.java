import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class problem6 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("graph.in"));

		int T = scan.nextInt();

		for (int i = 0; i < T; i++) {

			int v = scan.nextInt();
			int e = scan.nextInt();
			int al[][] = new int[v][v];
			int d[] = new int[v];
			for (int j = 0; j < e; j++) {

				int x = scan.nextInt();
				int y = scan.nextInt();
				al[x][d[x]++] = y;
				al[y][d[y]++] = x;

			}
			if(isCycle(al, d))
				System.out.println("cycle");
			else System.out.println("no cycle ");
	
		}

	}
	public static boolean isCycle(int[][] al, int[] d) {
		Queue<Integer> q = new LinkedList<Integer>();

		int[] color = new int[d.length];

		for (int i = 0; i < al.length; i++) {

			if (color[i] == 0) {


				q.offer(i);
				color[i] = 1;

			}
			while (!q.isEmpty()) {
				int u = q.poll();
				color[u] = 2;
				for (int j = 0; j < d[u]; j++) {
					int v = al[u][j];
					if (color[v] == 1)
						return true;
					if (color[v] == 0) {
						q.offer(v);
						color[v] = 1;
					}
				}
			}
		}
		return false;
	}
}
