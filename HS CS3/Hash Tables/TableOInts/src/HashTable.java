import java.util.LinkedList;
import java.util.Scanner;

public class HashTable
{
	// the table
	private LinkedList[] table;

	/**
	 * Constructs an object of the hash table class
	 */
	public HashTable( )
	{
		table = new LinkedList[10];
		for(int i=0; i<10; i++)
		{
			table[i] = new LinkedList();
		}
	}

	/**
	 * Adds a object to the hash table
	 * @param obj is the object to add
	 */
	public void add(Object obj)
	{
		//System.out.println("add");
		int i = obj.hashCode();

		//if(table[i]==null)
		//	table[i] = new LinkedList();
		if(!table[i].contains(obj))
		table[i].add(obj);

	}

	/**
	 * Gets a string representation of the object
	 * @return a string representation of the object
	 */
	public String toString()
	{
		String output="HASHTABLE\n";

		for(int i=0; i<table.length; i++)
		{
			String vals = table[i].toString();
			output += "bucket " + i + ": " + vals.substring(1, vals.length()-1) + "\n";
		}

		return output;
	}
}
