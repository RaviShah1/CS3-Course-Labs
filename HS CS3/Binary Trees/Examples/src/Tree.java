
public class Tree
{

	Node root;
	
	/**
	 * Constructs an object of the tree class
	 */
	public Tree(int val)
	{
		root = new Node(val);
	}
	
	/**
	 * Inserts an element into the tree
	 */
	public void add(int val) 
	{
		add(val, root);
	}
	
	private void add(int val, Node r)
	{
		
		if(val < r.val && r.left == null)
			r.left = new Node(val);
		else if(val < r.val)
			add(val, r.left);
		else if(val >= r.val && r.right == null)
			r.right = new Node(val);
		else if(val >= r.val)
			add(val, r.right);
	}
	
	
	public void print()
	{
		print(root); // client method
		System.out.println();
	}
	
	private void print(Node r)
	{
		if(root != null)
		{
			print(root.left);
			System.out.print(root.val);
			print(root.right);
		}
	}
	
	public boolean contains(int val)
	{
		return contains(val, root);
	}
	
	private boolean contains(int val, Node r)
	{
		/*
		if(root!=null)
		{
			if(val == root.val)
				return true;
			if(root.left != null)
				contains(val, root.left);
			if(root.right != null)
				contains(val, root.right);
		}
		return false;
		*/
		
		if(r == null)
			return false;
		else if(val == r.val)
			return true;
		else
			return contains(val, r.left) || contains(val, r.right);
		
	}
	
}
