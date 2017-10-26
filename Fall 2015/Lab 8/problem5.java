import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class problem5 
{

	public static void main(String args[]) throws FileNotFoundException
	{

		File input=new File("graph.in");

		Scanner scan=new Scanner(input);
		int N=scan.nextInt();
		for(int i=0;i<N;i++)
		{	int v=scan.nextInt();
		int e=scan.nextInt();
		int al[][]=new int[v][v];
		int deg[]=new int[v];
		for(int j=0; j<e; j++)
		{
			int a=scan.nextInt();
			int b=scan.nextInt();
			al[a][deg[a]++]=b;
			al[b][deg[b]++]=a;
		}
		if(!bipartite(al,deg)) System.out.println("bipartite");
		else System.out.println("not bipartite");
		}
	}
	public static boolean bipartite(int [][]neo, int deg[])
	{
		Queue <Integer> q = new LinkedList<Integer>();
		int[] color = new int[deg.length];
		int u, v;
		int [] bi = new int [deg.length];
		for(int i = 0; i< deg.length; i++)
		{
			if(color[i] == 0)
			{
				q.offer(i);
				color[i] = 1;
				bi[i] = 1;
				while(!q.isEmpty())
				{
					u = q.poll();
					color[u] =2;
					
					for(int j = 0; j < deg[u]; j++)
					{
						
						v = neo[u][j];
						
						if(color[v] == 0)
						{
							if(bi[u] == 1)
								bi[v] = 2;
							if(bi[u] == 2)
								bi[u] = 1;
							q.offer(v);
							color[v] = 1;
						}
						
						if(bi[v] == bi[u])
							return false;
					}
					
				}
				
			}
		}
		return true;
		
	}
}