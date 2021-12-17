/**
 * Represents a number and a node in the Graph
 * @author Ravi Shah
 *
 */
public class Number
{
	int n; // the number
	boolean visited; // whether it has been visited
	Number prev; // its previous node
	
	/**
	 * Constructs the Nubmber object
	 * @param n is the number/value  of the object
	 */
	public Number(int n)
	{
		this.n = n;
		visited = false;
		prev = null;
	}
	
	/**
	 * Determines if two Numbers are equal
	 * @return true if they are equal, else false
	 */
	@Override 
	public boolean equals(Object other)
	{
		Number num2 = (Number) other;
		return n == num2.n;
	}
	
	/**
	 * Gets a string representation of the Number
	 * @return a string representation of the Number
	 */
	@Override
	public String toString()
	{
		return ""+n;
	}
}
