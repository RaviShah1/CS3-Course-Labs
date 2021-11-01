
public class PhoneBook implements IMap
{
	LinkedListNode[] table;
	int size;
	
	public PhoneBook()
	{
		table = new LinkedListNode[200];
		size = 0;
	}
	
	public PhoneBook(int capacity)
	{
		table = new LinkedListNode[capacity];
		size = 0;
	}
	
	public int hashFunction(Person key)
	{
		return key.hashCode() % table.length;
	}
	
	/**
	 * Add the key/value pair to the table
	 * @return the number previously associated with person, or null
	 */
	public PhoneNumber put(Person person, PhoneNumber phone)
	{
		int idx = hashFunction(person);
		if(table[idx] == null)
		{
			table[idx] = new LinkedListNode(new Entry(person, phone));
		}
		else
		{
			LinkedListNode cur = table[idx];
			LinkedListNode current = table[idx];
			do
			{
				current = cur;
				if(cur.val.person.equals(person))
				{
					PhoneNumber oldNum = cur.val.num;
					cur.val.num = phone;
					return oldNum;
				}
				cur = cur.next;
			}while(current.next != null);
			
			current.next = new LinkedListNode(new Entry(person, phone));
		}
		
		size++;
		return null;
	}
	
	/**
	 * perform a table lookup
	 * @param person
	 * @return phone number mapped to this person
	 */
	public PhoneNumber get(Person person)
	{
		int idx = hashFunction(person);
		if(table[idx] == null)
		{
			return null;
		}
		
		LinkedListNode cur = table[idx];
		LinkedListNode current = table[idx];
		do
		{
			current = cur;
			if(cur.val.person.equals(person))
				return cur.val.num;
			cur = cur.next;
		}while(current.next != null);
		
		return null;
	}
	
	/** return the current number of key/value pairs in the map */
	public int size()
	{
		return size;
	}
	
	/**
	 * Remove supplied key (person)
	 * @return value mapped to supplied person, or null
	 */
	public PhoneNumber remove(Person person)
	{
		size--;
		int idx = hashFunction(person);
		
		if(table[idx].val.person.equals(person))
		{
			PhoneNumber oldNum = table[idx].val.num;
			table[idx] = table[idx].next;
			return oldNum;
		}
		
		LinkedListNode cur = table[idx];
		
		while(cur.next!=null && !cur.next.val.person.equals(person))
		{
			cur = cur.next;
		}
		
		if(cur.next == null)
			return null;
		
		PhoneNumber oldNum = cur.next.val.num;
		cur.next = cur.next.next;
		
		return oldNum;
	}
	
	public String toString()
	{
		String str = "MAP:\n";
		for(int i=0; i<table.length; i++)
		{
			str += i + ": ";
			if(table[i]==null)
				str += "none";
			else
			{
				//System.out.println(table[i].next.next.next);
				LinkedListNode cur = table[i];
				while(cur!=null)
				{
					str += cur.toString() + " -> ";
					cur = cur.next;
				}
				str += "none";
			}
			str += "\n";
		}
		
		return str;
	}
	
	private class Entry
	{
		Person person;
		PhoneNumber num;
		
		public Entry(Person p, PhoneNumber n)
		{
			person  = p;
			num = n;
		}
		
		public String toString()
		{
			return person + " :: " + num;
		}
	}
	
	private class LinkedListNode
	{
		Entry val;
		LinkedListNode next;
		
		public LinkedListNode(Entry val)
		{
			this.val = val;
			next = null;
		}
		
		public String toString()
		{
			return val.toString();
		}
	}

}
