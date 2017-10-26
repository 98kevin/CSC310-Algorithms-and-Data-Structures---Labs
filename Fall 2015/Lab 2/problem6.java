import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class problem6 
{

    public static void main(String args[]) throws FileNotFoundException
    {
 
		File input=new File("problem6.in");

    	Scanner scan=new Scanner(input);
    	int N=scan.nextInt();
    	for(int i=0;i<N;i++)
    	{
    		int t=scan.nextInt();
    		int x=scan.nextInt();
    		Node1 n=new Node1(x,null,null);
    		for(int j=0;j<t-1;j++)
    			n.insert(n,scan.nextInt());
    		System.out.println(n.depth(n)-1);
    	}
    	scan.close();
    }
    
    
}
class Node1
{
	int value;
	Node1 left;
	Node1 right;
	public Node1(int v,Node1 l,Node1 r)
	{
		value=v;
		left=l;
		right=r;
	}
	public static void insert(Node1 n,int v)
	{
		if(v<n.value)
		{
			if(n.left!=null)
				insert(n.left,v);
			else
				n.left=new Node1(v,null,null);
		}
		if(v>n.value)
		{
			if(n.right!=null)
				insert(n.right,v);
			else
				n.right=new Node1(v,null,null);
		}
	}
	public static void preorder(Node1 n)
	{
		if(n!=null)
		{
			System.out.print(n.value + " ");
			preorder(n.left);
			preorder(n.right);
		}
	}

	public int depth(Node1 n)
	{
		if(n == null)
		{
			return 0;
		}
		else
		{
			return Math.max(depth(n.left),depth(n.right))+1 ;
		}
	}
}