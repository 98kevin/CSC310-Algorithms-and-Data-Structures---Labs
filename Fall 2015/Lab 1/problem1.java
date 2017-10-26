import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



class node {
	public int data;
	public node left;
	public node right;
	public int height;
	public node(int data){
		this.data=data;
		right=null;
		left=null;
		height=1;
	}

}

  class tree {
	node root;
	
	public void inorder(node r){
		if(r!=null){
			inorder(r.left);
			System.out.println(r.data);
			inorder(r.right);
		}
	}
	
	public void insert(int key) {
		root=insert(root, key);
	}
	
	public void preOrder() {
		preOrder(root);
		System.out.println();
	}
	
	public void preOrder(node current) {
		if (current != null) {
			System.out.print(current.data + " ");
			preOrder(current.left);
			preOrder(current.right);
		}
	}
	
	private node insert(node current, int key) {
		if (current == null) {
			return new node(key);
		}
		
		if (key < current.data) {
			current.left = insert(current.left, key);
		} else {
			current.right = insert(current.right, key);
		}
		
		current.height = Math.max(height(current.left), height(current.right)) + 1;
		
		int balanceFactor = getBalanceFactor(current);
		
		if (balanceFactor > 1 && key < current.left.data) {
			return rightRotate(current);
		} else if (balanceFactor < -1 && key > current.right.data) {
			return leftRotate(current);
		} else if (balanceFactor > 1 && key > current.left.data) {
			current.left = leftRotate(current.left);
			return rightRotate(current);
		} else if (balanceFactor < -1 && key < current.right.data) {
			current.right = rightRotate(current.right);
			return leftRotate(current);
		}
		
		return current;
	}
	
	private int height(node node) {
		return node == null ? 0 : node.height;
	}
	
	private int getBalanceFactor(node node) {
		return node == null ? 0 : height(node.left) - height(node.right);
	}
	
	private node rightRotate(node node) {
		node n2=node.left;
		node.left=n2.right;
		n2.right=node;
		 
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		n2.height = Math.max(height(n2.left), height(n2.right)) + 1;
		return n2;
		/*node leftChild = node.left;
		node childRightSubtree = leftChild.right;
		
		leftChild.right = node;
		node.left = childRightSubtree;
		
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		leftChild.height = Math.max(height(leftChild.left), height(leftChild.right)) + 1;
		
		return leftChild;*/
	}
	
	private node leftRotate(node node) {
		node n2=node.right;
		node.right=n2.left;
		n2.left=node;
		 
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		n2.height = Math.max(height(n2.left), height(n2.right)) + 1;
		return n2;
		/*node rightChild = node.right;
		node childLeftSubtree = rightChild.left;
		
		rightChild.left = node;
		node.right = childLeftSubtree;
		
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		rightChild.height = Math.max(height(rightChild.left), height(rightChild.right)) + 1;
		
		return rightChild;*/
	}
}




public class problem1 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan=new Scanner(new File("lab1.in"));
		int n =scan.nextInt();
		for(int i=0;i<n;i++){
			tree TREE=new tree();

			int k=scan.nextInt();
			for(int j=0;j<k;j++){
				TREE.insert(scan.nextInt());
			}
			TREE.preOrder();
		}
		
	
	}
}

