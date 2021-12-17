
public class EmployeeDatabaseLinear
{
	// the table
	Entry[] table;
	double loadFactor;
	int size;
	int capacity;
	int probes;
	
	/**
	 * Constructs a default object of the database
	 */
	public EmployeeDatabaseLinear()
	{
		loadFactor = .75;
		size = 0;
		capacity = 7;
		probes = 0;
		table = new Entry[capacity];
	}
	
	/**
	 * Constructs a database given a load factor
	 * @param a is the load factor
	 */
	public EmployeeDatabaseLinear(double a)
	{
		loadFactor = a;
		size = 0;
		capacity = 7;
		probes = 0;
		table = new Entry[capacity];
	}
	
	/**
	 * Resizes the array by doubling its size
	 */
	public void rehash()
	{
		Entry[] temp = new Entry[capacity];
		for(int i=0; i<capacity; i++)
			temp[i] = table[i];
		
		capacity*=2;
		table = new Entry[capacity];
		size = 0;
		for(Entry e : temp)
			if(e != null)
				put(e.id, e.employee);
	}
	
	/**
	 * Gets the table size
	 * @return the table size
	 */
	public int getTableSize()
	{
		return table.length;
	}
	
	/**
	 * Calculates the hash code
	 * @param key is the input key
	 * @return the hash code
	 */
	public int hashCode(int key)
	{
		//return key%10;
		//return ((int)Math.pow(key, 2) % table.length);
		return key % table.length;
	}
	
	/**
	 * Puts a value into the table using linear probing
	 * @param key is the key to input
	 * @param value is the value to input
	 */
	public void put(int key, Employee value)
	{		
		if(size++ > loadFactor * capacity)
			rehash();
		
		int k = hashCode(key);
		
		for(int i=0; i<table.length; i++)
		{
			int h = (k + i) % table.length;
			if(table[h] == null)
			{
				table[h] = new Entry(key, value);
				return;
			}
		}
	}
	
	/**
	 * Gets a value from the table given a key
	 * @param key is the key
	 * @return is the value
	 */
	public Entry get(int key)
	{
		int k = hashCode(key);
		
		for(int i=0; i<table.length; i++)
		{
			int h = (k + i) % table.length;
			if(table[h] != null && table[h].id == key)
			{
				return table[h];
			}
			probes++;
		}
		
		return null;
	}
	
	/**
	 * Gets a string representation of the database
	 * @return a string representation of the database
	 */
	public String toString()
	{
		String output = "";
		//for(int i=0; i<1000; i++)
		for(int i=0; i<table.length; i++)
		{
			if(table[i] != null)
				output += i + ": "  + table[i].toString() + "\n";
		}
		return output;
	}
	
	/**
	 * This is the class for each entry into the database
	 */
	private class Entry
	{
		int id; // the id
		Employee employee; // the employee
		
		/**
		 * Constructs an Entry object
		 * @param i is the id/key
		 * @param emp is the eployee
		 */
		public Entry(int i, Employee emp)
		{
			id = i;
			employee = emp;
		}

		/**
		 * Gets a string representation of the entry
		 * @return Gets a string representation of the entry 
		 */
		public String toString()
		{
			return "ID: " + id + "\t Name: " + employee.getName();
 		}
	}
}
