/**
 * A Location (node) in the graph
 * @author Ravi Shah
 *
 */
public class Location
{
	int val; // the value
	int r; // the row
	int c; // the column
	boolean visited; // if it has been visited
	Location prev; // its previous node
	
	/**
	 * Constructs the node
	 * @param r is the row
	 * @param c is the column
	 * @param v is the value
	 */
	public Location(int r, int c, int v)
	{
		val = v;
		this.r = r;
		this.c = c;
		visited = false;
		prev = null;
	}
	
	/**
	 * Gets a string representation of the node
	 * @return a string representation of the node
	 */
	@Override 
	public String toString()
	{
		return ""+val;
	}
	
	/**
	 * Determines if two nodes are equal
	 * @return true if they are equal, else false
	 */
	@Override
	public boolean equals(Object other)
	{
		Location loc2 = (Location) other;
		return r==loc2.r && c==loc2.c;
	}
}
