/**
 * This program contains the IteratorReplacer class which controls all functionality for the replace it iterators lab
 * @author Ravi Shah
 */

import java.util.ArrayList;
import java.util.ListIterator;

public class IteratorReplacer
{
	private ArrayList<Integer> list;
	private int toRemove, replaceWith;

	/**
	 * Constructs a Iterator Remover Object
	 * @param line is the line of words separated by a space delimiter
	 * @param rem is the word to remove from line
	 * @param rep is the word to replace all occurrences of rem
	 */
	public IteratorReplacer(String line, String rem, String rep)
	{
		setEmAll(line, rem, rep);
	}

	/**
	 * Sets the list of words, toRemove, and replaceWith variables
	 * @param line is the line of words separated by a space delimiter
	 * @param rem is the word to remove from line
	 * @param rep is the word to replace all occurrences of rem
	 */
	public void setEmAll(String line, String rem, String rep)
	{
		list = new ArrayList<Integer>();
		String[] arrInput = line.split(" ");
		for(String s : arrInput)
			list.add(Integer.parseInt(s));
		toRemove = Integer.parseInt(rem);
		replaceWith = Integer.parseInt(rep);
	}

	/**
	 * Replaces all occurrences of toRemove with replaceWith in list 
	 */
	public void replace()
	{
		ListIterator iter = list.listIterator();
		while(iter.hasNext())
		{
			if(iter.next().equals(toRemove))
				iter.set(replaceWith);
		}
	}

	/**
	 * Returns the list as a string
	 * @return list is the list as a String
	 */
	public String toString()
	{
		return list.toString()+"\n\n";
	}
}