import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class problem3 
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
			dfs(A,0,seen);


    	}
    	scan.close();
    }
    public static void dfs (int A[][], int n,int seen[])
    {
			Stack <Integer> stack=new Stack <Integer>(); 
			dfsloop(A,n,seen,stack);
    		for (int i1=0;i1<seen.length;i1++)
    		{
    			if (seen[i1]==0)
    				dfsloop(A,i1,seen,stack);
    		}
    		System.out.println();

    }
    public static void dfsloop (int A[][], int n,int seen[], Stack<Integer> stack)
    {
    		seen[n]=1;
    		stack.push(n);
    		while(!stack.isEmpty())
			{ 
				int temp=stack.pop();
				System.out.print(n+" ");
	    		for(int i=0;i<A.length;i++)
	    			if(A[temp][i]==1 && seen[i]==0)
	    			{
	    				dfsloop(A,i,seen,stack);
	    			}
	    	}

	}


}