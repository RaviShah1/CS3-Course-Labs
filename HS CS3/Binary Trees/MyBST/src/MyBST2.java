
public class MyBST2<T extends Comparable<T>> 
{
	// the root
		BSTNode root;
		
		/**
		 * Gets the size of the tree
		 * @return the size of the tree
		 */
		public int size()
		{
			return size(root);
		}
		
		/**
		 * Helper method that gets the size of the tree
		 * @param n is the current root
		 * @return the size of n subtree
		 */
		private int size(BSTNode n)
		{
			if(n==null)
				return 0;
			return 1 + size(n.left) + size(n.right);
		}
		
		/**
		 * Inserts a value into the tree
		 * @param val is the value to insert
		 */
		public void insert(T val)
		{
			root = insert(root, val);
		}
		
		/**
		 * Helper method that inserts a value into the tree
		 * @param n is the current node
		 * @param val is the value to insert
		 * @return a node being inserted
		 */
		private BSTNode insert(BSTNode n, T val)
		{
			if(n==null)
				n = new BSTNode(val);
			else if(val.compareTo(n.val)<0)
				n.left = insert(n.left, val);
			else
				n.right = insert(n.right, val);
			return n; 
		}
		
		/**
		 * Determines if the tree contains a value
		 * @param val is the value to search for
		 * @return true if the value is in the tree, else false
		 */
		public boolean contains(T val)
		{
			return contains(root, val);
		}
		
		/**
		 * Helper method that determines if a value is in the tree
		 * @param n the current node
		 * @param val the value to search for
		 * @return true if val is in the tree, else false
		 */
		private boolean contains(BSTNode n, T val)
		{
			if(n==null)
				return false;
			else if(val.compareTo(n.val)==0)
				return true;
			else if(val.compareTo(n.val)<0)
				return contains(n.left, val);
			else 
				return contains(n.right, val);
		}
		
		/**
		 * Gets the maximum value in the tree
		 * @return
		 */
		public T getMax()
		{
			return getMax(root);
		}
		
		/**
		 * Helper method that gets the maximum value within a tree or subtree
		 * @param n the tree of subtree
		 * @return the maximum value
		 */
		private T getMax(BSTNode n)
		{
			if(n.right==null)
				return n.val;
			return getMax(n.right);
		}
		
		/**
		 * Gets the minimum value in the tree
		 * @return
		 */
		public T getMin()
		{
			return getMin(root);
		}
		
		/**
		 * Helper method that gets the minimum value within a tree or subtree
		 * @param n the tree of subtree
		 * @return the minimum value
		 */
		public T getMin(BSTNode n)
		{
			if(n.left==null)
				return n.val;
			return getMin(n.left);
		}
		
		/**
		 * Deletes a node from the tree
		 * @param val is the value to delete
		 */
		public void delete(T val)
		{
			delete(root, val);
		}
		
		/**
		 * Helper method that deletes a value from the tree
		 * @param n is the current node
		 * @param val is the value to delete
		 * @return a node to replace
		 */
		private BSTNode delete(BSTNode n, T val)
		{
			//System.out.println(n);
			if(n == null)
				return null;
			else if(val.compareTo(n.val)<0)
				n.left = delete(n.left, val);
			else if(val.compareTo(n.val)>0)
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
					T key = getMin(n.right);
					n.val = key;
					n.right = delete(n.right, key);
				}
			}
			return n;
		}
		
		/**
		 * Prints the tree in order
		 */
		public void inOrder()
		{
			System.out.print("[");
			String str = inOrder(root);
			System.out.print(str.substring(0,str.length()-2));
			System.out.println("]");
		}
		
		/**
		 * Helper method that gets a string of the tree in order
		 * @param n is the current node
		 * @return a string containing the values in the tree in order
		 */
		public String inOrder(BSTNode n)
		{
			if(n != null)
			{
				return inOrder(n.left) + n.val + ", " +inOrder(n.right);
			}
			return "";
		}
		
		/**
		 * Prints the tree 
		 */
		public void print()
		{
			int h = height(root);
			print(root, 0, h);
		}
		
		/**
		 * Helper method that prints the tree
		 * @param n is the current node
		 * @param cur is the current level and space of the tree
		 * @param h is the height of the tree
		 */
		private void print(BSTNode n, int cur, int h)
		{
			if (n == null)
		        return;
			
			cur+=h;
			
			print(n.right, cur, h);
			
			//System.out.print("\n");
		    for (int i = h; i < cur; i++)
		        System.out.print(" ");
		    System.out.print(n.val + "\n");
		    
		    print(n.left, cur, h);
		}
		
		/**
		 * Helper method that gets the height of the tree
		 * @param n is the current node
		 * @return the height of the tree
		 */
		private int height(BSTNode n)
		{
			if(n==null)
				return 0;
			return Math.max(1+height(n.left), 1+height(n.right));	
		}
		
		/**
		 * Class that represents a node in the tree
		 *
		 */
		private class BSTNode
		{
			T val; // the value of the node
			BSTNode left, right; // the left and right branches of this node
			
			/**
			 * COnstructs a node object
			 * @param val is the value of the node
			 */
			public BSTNode(T val)
			{
				this.val = val;
				left = right = null;
			}
			
			/**
			 * Gets a string representation of the node
			 * @return a string representation of the node
			 */
			public String toString() { return "" + this.val; }
		}
}
