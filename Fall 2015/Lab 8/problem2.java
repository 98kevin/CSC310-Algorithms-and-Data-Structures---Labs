import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class problem2 
{

    public static void main(String args[]) throws FileNotFoundException
    {
 
		File input=new File("graph.in");

    	Scanner scan=new Scanner(input);
    	int N=scan.nextInt();
    	for(int i=0;i<N;i++)
    	{
    		int v=scan.nextInt();
    		int e=scan.nextInt();
    		int A[][]=new int[v][v];
    		for(int j=0;j<e;j++)
    		{
    			int a=scan.nextInt();
    			int b=scan.nextInt();
    			A[a][b]=1;
    			A[b][a]=1;
    		}
    		int seen[]=new int[v];
    		//BFS(A,0,seen);
    		BFS(A,v-1,seen);
    		 

    	}
    	scan.close();
    }
    public static void BFS(int A[][],int x,int seen[])
    {
    	Queue<Integer> queue=new LinkedList<Integer>();
    	queue.offer(x);
    	seen[x]=1;
    	while(!queue.isEmpty())
    	{
    		int temp=queue.poll();
    		System.out.print(temp + " ");

    		for(int i=0;i<A.length;i++)
    		{
    			if(A[temp][i]==1 && seen[i]==0)
    			{
    				seen[i]=1;
    				queue.offer(i);
    			
    			}
    		}
    	}
/*    	for(int i=0;i<seen.length;i++)
    	{
    		if(seen[i]==0)
    			BFS(A,i,seen);
    	}
  */  	System.out.println();
    }
}