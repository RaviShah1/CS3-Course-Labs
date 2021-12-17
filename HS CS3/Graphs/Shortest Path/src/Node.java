
public class Node implements Comparable<Node>
{
	int id;
	int x;
	int y;
	double dist;
	Node prev;
	
	public Node(int id, int x, int y)
	{
		this.id = id;
		this.x = x;
		this.y = y;
	}
	
	public double distTo(Node n2)
	{
		return Math.sqrt(Math.pow(x-n2.x, 2) + Math.pow(y-n2.y, 2));
	}
	
	@Override
	public int compareTo(Node n2)
	{
		return Double.compare(dist, n2.dist);
	}
	
	@Override
	public boolean equals(Object other)
	{
		Node n2 = (Node) other;
		return id == n2.id;
	}
	
	@Override
	public String toString()
	{
		return "" + id;
	}
}
