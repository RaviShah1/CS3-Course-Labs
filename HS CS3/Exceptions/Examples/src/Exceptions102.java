import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Exceptions102
{

	/*
	 * All exceptions ultimately derive from the Throwable class
	 * The immediate subclasses from throwable are Error and Exception
	 * Common Exceptions are IOExceptions and RunTimeExceptions
	 * IOExceptions are used for exceptions beyond your control. (e.g. the disk is full)
	 * RunTimeException indicate programmer error (e.g. you tried to write past the end of an array))
	 *
	 * IOExceptions are considered "checked exceptions"
	 * "Checked" refers to the fact that the compiler will check to ensure
	 * that the exceptions is caught. Checked exceptions that are not monitored by a 
	 * try catch block 
	 * you must mark you method to indicate that it throws this exception
	 */
	
	
	public static void main(String args[]) throws IOException
	{
		readFile2();
	}
	
	/*
	 * Any method that shares the stack with an IOException must indicate that it 
	 * throws this exception
	 */
	public static void readFile1() throws IOException
	{
		File file = new File("mystery.txt");
		Scanner scan = new Scanner(file);
	}
	
	public static void readFile2()
	{
		try
		{
			File file = new File("mystery.txt");
			Scanner scan = new Scanner(file);
		}
		catch(IOException e)
		{
			System.out.println("The file does not exist.");
		}
	}
}
