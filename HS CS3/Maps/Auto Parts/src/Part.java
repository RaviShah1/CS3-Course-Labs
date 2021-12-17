
public class Part implements Comparable<Part>
{
	// details about the part
	private String make, mode, rest;
	private int year;

	/**
	 * Constructs an object of the parts class
	 * @param line is a string containing information about the part
	 */
	public Part(String line)
	{
		String[] list = line.split("\\d+");
		String[] nums = line.split("\\D+");
		rest = list[0].trim() + " " + nums[1].trim();
		make = list[1].trim().split(" ")[0];
		mode = list[1].trim().split(" ")[1];
		year = Integer.parseInt(nums[2]);


	}

	//have to have compareTo if implements Comparable
	/**
	 * Compares one object to another
	 * @return positive if the part is greater than other, zero if they are the same, and negative if it is less
	 */
	public int compareTo( Part rhs )
	{
		if(!make.equalsIgnoreCase(rhs.make))
			return make.compareTo(rhs.make);
		else if(!mode.equalsIgnoreCase(rhs.mode))
			return mode.compareTo(rhs.mode);	
		else if(!rest.equalsIgnoreCase(rhs.rest))
			return rest.compareTo(rhs.rest);
		else
			return ((Integer)year).compareTo((Integer)rhs.year);
	}

	/**
	 * Gets a string representation of the part
	 * @return a string representation of the part
	 */
	public String toString()
	{
		return make + " " + mode + " " + year + " " + rest;
	}
}