
import java.util.ArrayList;  

public class MyHashTable<K, V> implements IMapGeneric<K, V>
{

	//LinkedListNode[] table;
	ArrayList<LinkedListNode> table;
	int size;
	int capacity;
	
	public MyHashTable()
	{
		//table = new LinkedListNode[200];
		table = new ArrayList<LinkedListNode>(200);
		for(int i=0; i<200; i++)
			table.add(null);
		size = 0;
		capacity = 200;
	}
	
	public MyHashTable(int capacity)
	{
		//table = new LinkedListNode[capacity];
		table = new ArrayList<LinkedListNode>(capacity);
		for(int i=0; i<capacity; i++)
			table.add(null);
		size = 0;
		this.capacity = capacity;
	}
	
	public int hashFunction(K key)
	{
		//return key.hashCode() % table.length;
		return key.hashCode() % capacity;
	}
	
	/**
	 * Add the key/value pair to the table
	 * @return the number previously associated with person, or null
	 */
	public V put(K key, V val)
	{
		int idx = hashFunction(key);
		if(table.get(idx) == null)
		{
			table.set(idx, new LinkedListNode(new Entry((K)key, (V)val)));
		}
		else
		{
			LinkedListNode cur = table.get(idx);
			LinkedListNode current = table.get(idx);
			do
			{
				current = cur;
				if(cur.val.key.equals(key))
				{
					V oldNum = cur.val.val;
					cur.val.val = (V)val;
					return oldNum;
				}
				cur = cur.next;
			}while(current.next != null);
			
			current.next = new LinkedListNode(new Entry((K)key, (V)val));
		}
		
		size++;
		return null;
	}
	
	/**
	 * perform a table lookup
	 * @param person
	 * @return phone number mapped to this person
	 */
	public V get(K key)
	{
		int idx = hashFunction(key);
		if(table.get(idx) == null)
		{
			return null;
		}
		
		LinkedListNode cur = table.get(idx);
		LinkedListNode current = table.get(idx);
		do
		{
			current = cur;
			if(cur.val.key.equals(key))
				return cur.val.val;
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
	public V remove(K key)
	{
		size--;
		int idx = hashFunction(key);
		
		if(table.get(idx).val.key.equals(key))
		{
			V oldNum = table.get(idx).val.val;
			table.set(idx, table.get(idx).next);
			return oldNum;
		}
		
		LinkedListNode cur = table.get(idx);
		
		while(cur.next!=null && !cur.next.val.key.equals(key))
		{
			cur = cur.next;
		}
		
		if(cur.next == null)
			return null;
		
		V oldNum = cur.next.val.val;
		cur.next = cur.next.next;
		
		return oldNum;
	}
	
	public String toString()
	{
		String str = "MAP:\n";
		for(int i=0; i<table.size(); i++)
		{
			str += i + ": ";
			if(table.get(i)==null)
				str += "none";
			else
			{
				//System.out.println(table[i].next.next.next);
				LinkedListNode cur = table.get(i);
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
		K key;
		V val;
		
		public Entry(K key, V val)
		{
			this.key = key;
			this.val = val;
		}
		
		public String toString()
		{
			return key + " :: " + val;
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