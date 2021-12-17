import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Relatives
{
	//the map
	private Map<String,Set<String>> map;

	/**
	 * Constructs an object of the Relatives class
	 */
	public Relatives()
	{
		map = new TreeMap<String, Set<String>>();
	}

	/**
	 * adds a person to the map if they are not already in it
	 * sets the second person as a relative to the first person in the map
	 * @param line
	 */
	public void setPersonRelative(String line)
	{
		String[] personRelative = line.split(" ");

		String key = personRelative[0];
		String val = personRelative[1];
		
		if(!map.containsKey(key))
			map.put(key, new TreeSet<String>());
		map.get(key).add(val);
	}


	/**
	 * Gets a string that describes who a person is related to
	 * @param person is the person
	 * @return output is a string that describes who a person is related to
	 */
	public String getRelatives(String person)
	{
		String output = person + " is related to ";
		Set<String> names = map.get(person);
		Iterator<String> it = names.iterator();
		while(it.hasNext())
		{
			String name = it.next();
			output += name;
			if(it.hasNext())
				output += ", ";
		}
		return output;
	}

	/**
	 * Gets a string representation of the people and their relatives
	 * in the map by calling getRelatives
	 * @return a string representation of the people and their relatives from the map
	 */
	public String toString()
	{
		String output="";

		for(String s : map.keySet())
		{
			output += getRelatives(s);
			output+="\n";
		}

		return output;
	}
}