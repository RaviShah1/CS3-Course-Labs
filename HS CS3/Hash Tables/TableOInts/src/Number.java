public class Number
{
	// the number
	private int theValue;
	
	/**
	 * Constructs an object of the NUmber class
	 * @param value is the number
	 */
	public Number(int value)
	{
		theValue = value;

	}	
	
	/**
	 * Gets the int value of the number
	 * @return the number as an int
	 */
	public int getValue()
	{
		return theValue;
	}
	
	/**
	 * Determines if two numbers are equal
	 * @param obj is the other number
	 * @return true if they have the same value, else false;
	 */
	public boolean equals(Object obj)
	{
		Number num2 = (Number) obj;
		return theValue == num2.theValue;
	} 
	
	/**
	 * Gets the hash code of the number
	 * @return the hash code of the number
	 */
	public int hashCode()
	{
		return theValue%10;
	}

	/**
	 * Gets a String representation of the number
	 * @return a String representation of the number
	 */
	public String toString()
	{
		return "" + theValue;
	}	
}
