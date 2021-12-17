import java.util.NoSuchElementException;

public class SearchTree
{

	Node root;
	
	/**
	 * Constructs an object of the tree class
	 */
	public SearchTree(int val)
	{
		root = new Node(val);
	}
	
	/**
	 * Inserts an element into the tree
	 */
	public void add(int val) 
	{
		root = add(val, root);
	}
	
	private Node add(int val, Node r)
	{
		
//		if(val < r.val && r.left == null)
//			r.left = new Node(val);
//		else if(val < r.val)
//			add(val, r.left);
//		else if(val >= r.val && r.right == null)
//			r.right = new Node(val);
//		else if(val >= r.val)
//			add(val, r.right);
		
		if(r==null)
			r = new Node(val);
		else if(val<r.val)
			r.left = add(val, r.left);
		else
			r.right = add(val, r.right);
		return r; 
	}
	
	
	public void print()
	{
		print(root); // client method
		System.out.println();
	}
	
	private void print(Node r)
	{
		if(r != null)
		{
			print(r.left);
			System.out.print(r.val + " ");
			print(r.right);
		}
	}
	
	public boolean contains(int val)
	{
		return contains(root, val);
	}
	
//	private boolean contains(int val, Node r)
//	{	
//		if(r == null)
//			return false;
//		else if(val == r.val)
//			return true;
//		else
//			return contains(val, r.left) || contains(val, r.right);
//		
//	}
	
	private boolean contains(Node n, int v)
	{
		if(n==null)
			return false;
		else if(n.val == v)
			return true;
		else if(v<n.val)
			return contains(n.left, v);
		else 
			return contains(n.right, v);
		
	}
	
	public int getMin()
	{
		if(root == null)
			throw new NoSuchElementException();
		return getMin(root);
	}
	
	private int getMin(Node n)
	{
		if(n.left==null)
			return n.val;
		else
			return getMin(n.left);
		
	}
}
