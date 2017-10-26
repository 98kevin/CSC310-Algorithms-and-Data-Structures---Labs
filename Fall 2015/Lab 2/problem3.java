import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class problem3 
{

	public static void main(String args[]) throws FileNotFoundException
	{
		File input=new File("problem3.in");

		Scanner scan=new Scanner(input);
		int N=scan.nextInt();
		for(int i=0;i<N;i++)
		{
			int t=scan.nextInt();
			int x=scan.nextInt();
			Node n=new Node(x,null,null);
			for(int j=0;j<t-1;j++)
				n.insert(n,scan.nextInt());
			n.preorder(n);
			System.out.println();
		}
	}


}
class Node
{
	int value;
	Node left;
	Node right;

	public Node(int v,Node l,Node r)
	{
		value=v;
		left=l;
		right=r;
	}
	public static void insert(Node n,int v)
	{
		if(v<n.value)
		{
			if(n.left!=null)
				insert(n.left,v);
			else
				n.left=new Node(v,null,null);
		}
		if(v>n.value)
		{
			if(n.right!=null)
				insert(n.right,v);
			else
				n.right=new Node(v,null,null);
		}
	}
	public static void preorder(Node n)
	{
		if(n!=null)
		{
			System.out.print(n.value + " ");
			preorder(n.left);
			preorder(n.right);
		}
	}
}