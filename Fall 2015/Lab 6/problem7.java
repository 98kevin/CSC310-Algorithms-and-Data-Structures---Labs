import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Lab6Problem7AVL 
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
    		Node4 n=new Node4(x,null,null);
    		for(int j=0;j<t-1;j++)
    			n.insert(n,scan.nextInt());
    		boolean compl=n.isAVL(n);
    		if(compl)
    		{
    			System.out.println("Is AVL");
    		}
    		else
    		{
    			System.out.println("Is not AVL");
    		}
    	}
    	scan.close();
    }
}
    

class Node4
{
	int value;
	Node4 left;
	Node4 right;
	public Node4(int v,Node4 l,Node4 r)
	{
		value=v;
		left=l;
		right=r;
	}
	public static void insert(Node4 n,int v)
	{
		if(v<n.value)
		{
			if(n.left!=null)
				insert(n.left,v);
			else
				n.left=new Node4(v,null,null);
		}
		if(v>n.value)
		{
			if(n.right!=null)
				insert(n.right,v);
			else
				n.right=new Node4(v,null,null);
		}
	}
	public static void preorder(Node4 n)
	{
		if(n!=null)
		{
			System.out.print(n.value + " ");
			preorder(n.left);
			preorder(n.right);
		}
	}

	public int depth(Node4 n)
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
	boolean isAVL(Node4 n)
	{
	   int lh;
	   int rh; 
	 
	   /* If tree is empty then return true */
	   if(n == null)
	    return true; 
	 
	   /* Get the height of left and right sub trees */
	   lh = depth(n.left);
	   rh = depth(n.right);
	 
	   if( Math.abs(lh-rh) <= 1 &&
	       isAVL(n.left) &&
	       isAVL(n.right))
	     return true;
	 
	   /* If we reach here then tree is not height-balanced */
	   return false;
	}
	 


}