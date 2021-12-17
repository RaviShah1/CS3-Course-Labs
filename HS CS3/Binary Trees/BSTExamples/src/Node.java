
public class Node
{
	int val; // data
	Node left; // left child
	Node right; // right child
	
	public Node(int v)
	{
		this.val = v;
		left = null;
		right = null;
	}
	
	public Node(int v, Node l, Node r)
	{
		this.val = v;
		left = l;
		right = r;
	}
}
