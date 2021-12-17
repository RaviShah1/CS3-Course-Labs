import static java.lang.System.out;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class PartList
{
	// the map
	private TreeMap<Part, Integer> partsMap;

	/**
	 * Constructs an object of the PartList class
	 */
	public PartList()
	{
			partsMap = new TreeMap<Part, Integer>();
	}

	/**
	 * Constructs an object of the PartList class given a file
	 * @param fileName is the file with input data
	 */
	public PartList(String fileName)
	{
		this();
		try
		{
			//add code here to read from the file
			//and add Parts to the map
			Scanner file = new Scanner(new File(fileName));
			while(file.hasNextLine())
			{
				Part part = new Part(file.nextLine());
				if(!partsMap.containsKey(part))
					partsMap.put(part, 0);
				partsMap.put(part, partsMap.get(part)+1);
			}


		}
		catch( IOException e )  //Most specific exceptions must be listed 1st
		{
			out.println(e);
		}
		catch( RuntimeException e )
		{
			out.println(e);
		}
		catch( Exception e )
		{
			out.println(e);
		}
		finally
		{
			//no code needed here
		}
	}

	/**
	 * Gets a string representation of the list
	 * @return a string representation of the list
	 */
	public String toString()
	{
		String output="";
		for(Part k : partsMap.keySet())
		{
			output += k + " - " + partsMap.get(k) + "\n";
		}

		return output;
	}
}