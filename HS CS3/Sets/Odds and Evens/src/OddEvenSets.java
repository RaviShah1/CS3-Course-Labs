//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Ravi Shah

import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class OddEvenSets
{
	private Set<Integer> odds;
	private Set<Integer> evens;

	/**
	 * Constructs  default object of the OddEvenSets class (empty sets)
	 */
	public OddEvenSets()
	{
		odds = new TreeSet<Integer>();
		evens = new TreeSet<Integer>();
	}

	/**
	 * Constructs an object of the OddEvenSets class
	 * determines which numbers in a string are odd and which 
	 * ones are even.
	 * Stores even numbers in evens set
	 * Stores odd number in odds set
	 * @param line is a string containing the numbers separted by a space
	 */
	public OddEvenSets(String line)
	{
		String[] words = line.split(" ");
		odds = new TreeSet<Integer>();
		evens = new TreeSet<Integer>();
		
		for(String word : words)
		{
			int num = Integer.parseInt(word);
			if(num%2==0)
				evens.add(num);
			else
				odds.add(num);
		}
	}

	/**
	 * Returns the string representation of odds and evens
	 */
	public String toString()
	{
		return "ODDS : " + odds + "\nEVENS : " + evens + "\n\n";
	}
}