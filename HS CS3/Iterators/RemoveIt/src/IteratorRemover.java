/**
 * This program contains the IteratorReplacer class which controls all functionality for the remove it iterators lab
 * @author Ravi Shah
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;


public class IteratorRemover
{
	private ArrayList<String> list;
	private String toRemove;

	/**
	 * Constructs a Iterator Remover Object
	 * @param line is the line of words separated by a space delimiter
	 * @param rem is the word to remove from line
	 */
	public IteratorRemover(String line, String rem)
	{
		setTest(line, rem);
	}

	/**
	 * Sets the list of words and toRemove variables
	 * @param line is the line of words separated by a space delimiter
	 * @param rem is the word to remove from line
	 */
	public void setTest(String line, String rem)
	{
		list = new ArrayList<String>();
		String[] arrInput = line.split(" ");
		for(String s : arrInput)
			list.add(s);
		toRemove = rem;
	}
	
	/**
	 * Removes string toRemove from the list variable (using and iterator)
	 */
	public void remove()
	{
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next().equals(toRemove))
				iter.remove();
		}
	}

	/**
	 * Returns the list as a string
	 * @return list is the list as a String
	 */
	public String toString()
	{
		return list.toString();
	}
}