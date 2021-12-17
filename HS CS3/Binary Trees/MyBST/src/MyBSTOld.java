
public class MyBST
{
	
	
	BSTNode root;
	
	public int size()
	{
		return size(root);
	}
	
	private int size(BSTNode n)
	{
		if(n==null)
			return 0;
		return 1 + size(n.left) + size(n.right);
	}
	
	public void insert(Integer val)
	{
		root = insert(root, val);
	}
	
	private BSTNode insert(BSTNode n, Integer val)
	{
		if(n==null)
			n = new BSTNode(val);
		else if(val<n.val)
			n.left = insert(n.left, val);
		else
			n.right = insert(n.right, val);
		return n; 
	}
	
	public boolean contains(Integer val)
	{
		return contains(root, val);
	}
	
	private boolean contains(BSTNode n, Integer val)
	{
		if(n==null)
			return false;
		else if(n.val == val)
			return true;
		else if(val<n.val)
			return contains(n.left, val);
		else 
			return contains(n.right, val);
	}
	
	public Integer getMax()
	{
		return getMax(root);
	}
	
	private Integer getMax(BSTNode n)
	{
		if(n.right==null)
			return n.val;
		return getMax(n.right);
	}
	
	public Integer getMin()
	{
		return getMin(root);
	}
	
	public Integer getMin(BSTNode n)
	{
		if(n.left==null)
			return n.val;
		return getMin(n.left);
	}
	
	public void delete(Integer val)
	{
		delete(root, val);
	}
	
	private BSTNode delete(BSTNode n, Integer val)
	{
		//System.out.println(n);
		if(n == null)
			return null;
		else if(val<n.val)
			n.left = delete(n.left, val);
		else if(val>n.val)
			n.right = delete(n.right, val);
		else
		{
			if(n.left==null && n.right==null)
				n = null;
			else if(n.right == null)
			{
				return n.left;
			}
			else if(n.left == null)
			{
				return n.right;
			}
			else
			{
				Integer key = getMin(n.right);
				n.val = key;
				n.right = delete(n.right, key);
			}
		}
		return n;
	}
	
	public void inOrder()
	{
		System.out.print("[");
		inOrder(root);
		System.out.print("]");
	}
	
	public void inOrder(BSTNode n)
	{
		if(n != null)
		{
			inOrder(n.left);
			System.out.print(n.val + " ");
			inOrder(n.right);
		}
	}
	
	public void print()
	{
		
	}
	
	private class BSTNode
	{
		Integer val;
		BSTNode left, right;
		
		public BSTNode(Integer val)
		{
			this.val = val;
			left = right = null;
		}
		
		public String toString() { return "" + this.val; }
	}
	
}
