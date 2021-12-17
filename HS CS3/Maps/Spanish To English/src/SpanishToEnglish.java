import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import static java.lang.System.*;


public class SpanishToEnglish
{
	private Map<String,String> pairs;

	/**
	 * Constructs an object of the spanish to english class
	 */
	public SpanishToEnglish()
	{
		pairs = new TreeMap<String, String>();
		

	}

	/**
	 * Adds an entry to the dictionary
	 * @param entry the Spanish English pair
	 */
	public void putEntry(String entry)
	{
		String[] list = entry.split(" ");
		pairs.put(list[0], list[1]);




	}

	/**
	 * Translates a sentence from Spanish to English
	 * @param sent is the Spanish sentence
	 * @return the English sentence
	 */
	public String translate(String sent)
	{
		Scanner chop = new Scanner(sent);
		String output ="";

		while(chop.hasNext())
		{
			output += pairs.get(chop.next()) + " ";
		}




		return output;
	}

	/**
	 * Gets a string representation of the dictionary
	 * @return a string representation of the map
	 */
	public String toString()
	{
		return pairs.toString().replaceAll("\\,","\n");
	}
}