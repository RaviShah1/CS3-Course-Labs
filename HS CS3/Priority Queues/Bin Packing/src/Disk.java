import java.util.ArrayList;
import java.util.List;

public class Disk implements Comparable<Disk>
{
	private int id;
	private int remaining;
	public final int SPACE = 1000000;
	private List<Integer> files;
	
	/**
	 * Constructs an object of the Disk class
	 * @param id is the id of the disk
	 */
	public Disk(int id)
	{
		this.id = id;
		files = new ArrayList<Integer>();
		remaining = SPACE;
	}
	
	/**
	 * Adds a file to the disk
	 * @param file is the file
	 */
	public void add(int file)
	{
		files.add(file);
		remaining -= file;
	}
	
	/**
	 * Gets the disks id
	 * @return is id of the disk
	 */
	public int getId()
	{
		return id;
	}
	
	/**
	 * Gets the remaining amount of space on the disk
	 * @return the remaining space on the disk
	 */
	public int getRemaining()
	{
		return remaining;
	}
	
	/**
	 * Compares two disks
	 * @return 0 if the disks are equal, positive number if this disk is greater negative number if this disk is smaller
	 */
	public int compareTo(Disk other)
	{
		return -1 * Integer.compare(remaining, other.remaining);
	}
	
	/**
	 * Gets a string representation of the disk
	 * @return a string representation of the disk
	 */
	public String toString()
	{
		String str = files.toString();
		return str.substring(1, str.length()-1);
	}
}
