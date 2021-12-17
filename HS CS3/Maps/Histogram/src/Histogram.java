import java.util.Map;
import java.util.TreeMap;

public class Histogram
{
	// the map
	private Map<String,Integer> histogram;

	/**
	 * Constructs an object of the Histogram Class
	 */
	public Histogram()
	{
		setSentence("");
	}

	/**
	 * Constructs an object of the Histogram Class and sets the map with a sentence
	 * @param sent is the sentence
	 */
	public Histogram(String sent)
	{
		setSentence(sent);
	}
	
	/**
	 * Sets the map given a sentence
	 * @param str is the sentence
	 */
	public void setSentence(String str)
	{
		histogram = new TreeMap<String, Integer>();
		str = str.replaceAll(" ", "");
		for(int i=0; i<str.length(); i++)
		{
			String c = str.substring(i,i+1);
			if(histogram.containsKey(c))
				histogram.put(c, histogram.get(c)+1);
			else
				histogram.put(c, 1);
		}
	}

	/**
	 * Gets a string representation of the map
	 * @return a string representation of the map
	 */
	public String toString()
	{
		String output="char\t1---5----10\n";
		for(String s : histogram.keySet())
		{
			output += s + "\t";
			for(int i=0; i<histogram.get(s); i++)
				output += "*";
			output+="\n";
		}
		
		return output+"\n\n";
	}
}