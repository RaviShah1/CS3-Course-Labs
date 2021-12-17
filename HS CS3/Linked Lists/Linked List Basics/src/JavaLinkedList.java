import java.util.LinkedList;
import static java.lang.System.*;

public class JavaLinkedList
{
	private LinkedList<Integer> list;

	/**
	 * Constructs a linked list object 
	 */
	public JavaLinkedList()
	{
		list = new LinkedList<Integer>();
	}

	/**
	 * Constructs a linked list object given input nums as an array
	 * @param nums is the array of values to put in the linked list
	 */
	/*
	public JavaLinkedList(int[] nums)
	{
		list = new LinkedList<Integer>();
		for(int num : nums)
		{
			list.add(num);
		}
	}
	*/

	/**
	 * Constructs a linked list object given input nums as an array
	 * @param nums is the array of values to put in the linked list
	 */
	public JavaLinkedList(int[] nums)
	{
		list = new LinkedList<Integer>();
		for(int num : nums)
		{
			list.add(num);
		}
	}

	/**
	 * Gets the sum
	 * @return the sum
	 */
	public double getSum(  )
	{
		int total = 0;
		for(int num : list)
			total+=num;
		return total;
	}

	/**
	 * Gets the average
	 * @return the average
	 */
	public double getAvg(  )
	{
		double sum = getSum();
		return sum/(list.size());
	}

	/**
	 * Gets the largest
	 * @return the largest
	 */
	public int getLargest()
	{
		int largest=Integer.MIN_VALUE;
		for(int num : list)
			if(num > largest)
				largest = num;
		return largest;
	}

	/**
	 * Gets the smallest
	 * @return the smallest
	 */
	public int getSmallest()
	{
		int smallest = Integer.MAX_VALUE;
		for(int num : list)
			if(num < smallest)
				smallest = num;
		return smallest;
	}

	/**
	 * Gets a string representation of the linked list and its information
	 * @return a string representation of the linked list and its information
	 */
	public String toString()
	{
		String output= "list: " + list.toString() + " \n";
		output += "SUM:: " + getSum() + "\n";
		output += "AVERAGE:: " + getAvg() + "\n";
		output += "SMALLEST:: " + getSmallest() + "\n";
		output += "LARGEST:: " + getLargest() + "\n";
		return output;
	}
}