import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import static java.lang.System.*;

public class Acronyms
{
	// the map
	private Map<String,String> acronymTable;

	/**
	 * Creates an object of the Acronyms class 
	 */
	public Acronyms()
	{
		acronymTable = new TreeMap<String, String>();
	}

	/**
	 * Puts an entry into the map
	 * @param entry is the entry
	 */
	public void putEntry(String entry)
	{
		String[] parts = entry.split(" - ");
		acronymTable.put(parts[0], parts[1]);
	}

	/**
	 * Converts a acronyms in a sentence to words 
	 * @param sent is the sentence
	 * @return the converted sentence
	 */
	public String convert(String sent)
	{
		Scanner chop = new Scanner(sent);
		String output ="";

		while(chop.hasNext())
		{
			String str = chop.next();
			if(str.indexOf('.')!=-1 && acronymTable.containsKey(str.substring(0, str.indexOf('.'))))
				str = acronymTable.get(str.substring(0, str.indexOf('.'))) + ".";
			else if(acronymTable.containsKey(str))
				str = acronymTable.get(str);
			output += str + " ";
		}

		return output;
	}

	/**
	 * Gets a string representation of the map
	 * @return a string representation of the map
	 */
	public String toString()
	{
		return acronymTable.toString().replaceAll("\\,","\n");
	}
}