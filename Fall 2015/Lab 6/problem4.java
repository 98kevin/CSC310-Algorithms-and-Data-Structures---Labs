import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Lab6Problem4Count 
{

    public static void main(String args[]) throws FileNotFoundException
    {
 
		File input=new File("problem4.txt");

    	Scanner scan=new Scanner(input);
    	int N=scan.nextInt();
    	for(int i=0;i<N;i++)
    	{
    		int t=scan.nextInt();
    		int x=scan.nextInt();
    		Node2 n=new Node2(x,null,null);
    		for(int j=0;j<t-1;j++)
    			n.insert(n,scan.nextInt());
    		System.out.println(n.count(n));
    	}
    	scan.close();
    }
    
    
}
class Node2
{
	int value;
	Node2 left;
	Node2 right;
	public Node2(int v,Node2 l,Node2 r)
	{
		value=v;
		left=l;
		right=r;
	}
	public static void insert(Node2 n,int v)
	{
		if(v<n.value)
		{
			if(n.left!=null)
				insert(n.left,v);
			else
				n.left=new Node2(v,null,null);
		}
		if(v>n.value)
		{
			if(n.right!=null)
				insert(n.right,v);
			else
				n.right=new Node2(v,null,null);
		}
	}
	public static void preorder(Node2 n)
	{
		if(n!=null)
		{
			System.out.print(n.value + " ");
			preorder(n.left);
			preorder(n.right);
		}
	}

	public int count(Node2 n)
	{
		if(n == null)
		{
			return 0;
		}
		else
		{
			return 1+count(n.left)+count(n.right) ;
		}
	}
}