import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Lab6Problem6Complete 
{

    public static void main(String args[]) throws FileNotFoundException
    {
 
		File input=new File("problem6.txt");

    	Scanner scan=new Scanner(input);
    	int N=scan.nextInt();
    	for(int i=0;i<N;i++)
    	{
    		int t=scan.nextInt();
    		int x=scan.nextInt();
    		Node3 n=new Node3(x,null,null);
    		for(int j=0;j<t-1;j++)
    			n.insert(n,scan.nextInt());
    		boolean compl=n.isComplete(n);
    		if(compl)
    		{
    			System.out.println("I am a complete tree!");
    		}
    		else
    		{
    			System.out.println("I am not a complete tree!");
    		}
    	}
    	scan.close();
    }
}
    

class Node3
{
	int value;
	Node3 left;
	Node3 right;
	public Node3(int v,Node3 l,Node3 r)
	{
		value=v;
		left=l;
		right=r;
	}
	public static void insert(Node3 n,int v)
	{
		if(v<n.value)
		{
			if(n.left!=null)
				insert(n.left,v);
			else
				n.left=new Node3(v,null,null);
		}
		if(v>n.value)
		{
			if(n.right!=null)
				insert(n.right,v);
			else
				n.right=new Node3(v,null,null);
		}
	}
	public static void preorder(Node3 n)
	{
		if(n!=null)
		{
			System.out.print(n.value + " ");
			preorder(n.left);
			preorder(n.right);
		}
	}

	public int count(Node3 n)
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
	public int depth(Node3 n)
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
	boolean isComplete(Node3 n){
		return (count(n)==(Math.pow(2, depth(n))-1));
	}	


}