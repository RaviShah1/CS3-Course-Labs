//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.ArrayList;
import static java.lang.System.*;

public class UniquesDupes
{
	/**
	 * Reads in a list of words/letters and determine which values 
	 * are unique
	 * @param input is the list of words in string format
	 * @return uniques is the set of unique values
	 */
	public static Set<String> getUniques(String input)
	{
		String[]  words = input.split(" ");
		Set<String> uniques = new TreeSet<String>(Arrays.asList(words));
		return uniques;
	}

	/**
	 * Reads in a list of words/letters and determine which values 
	 * are duplicates
	 * @param input is the list of words in string format
	 * @return dupes is the set of duplicate values
	 */
	public static Set<String> getDupes(String input)
	{
		Set<String> check = new TreeSet<String>();
		Set<String> dupes = new TreeSet<String>();
		String[]  words = input.split(" ");
		for(String word : words)
			if(!(check.add(word)))
				dupes.add(word);
		
		return dupes;
	}
}