import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class problem7 
{
	public static void main(String[] args) throws FileNotFoundException {
		File input=new File("graph.in");

    	Scanner scan=new Scanner(input);
    	int N=scan.nextInt();
		for(int i=0; i<N; i++)
		{
			int node=scan.nextInt();
			int edge=scan.nextInt();
			int A[][]=new int[node][node];
			int degrees[]=new int[node];
			for(int j=0; j<edge; j++)
			{
    			int a=scan.nextInt();
    			int b=scan.nextInt();
    			A[a][b]=1;
    			A[b][a]=1;
    			degrees[a]++;
    			degrees[b]++;
			}
			boolean thing=check4cycle(A,degrees);
			if (thing) System.out.println("yes");
			else System.out.println("no");
		}
		

	}
	public static boolean check4cycle(int A[][], int [] degrees)
	{
		for(int u=0;u<A.length;u++)
		{
			for(int v=u+1;v<A.length;v++)
			{
				int common=0;
				for(int i=0;i<A.length;i++)
				{
					if(A[u][i]==1 && A[v][i]==1)
					{
						common++;
					}
					if(common==2)
						return true;
				}
				
			}
		}
		return false;
	}
}