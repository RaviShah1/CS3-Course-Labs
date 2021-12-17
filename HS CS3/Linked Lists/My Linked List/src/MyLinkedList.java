/**
 * This is the class definition for a linked list
 * @author Ravi Shah
 *
 */
public class MyLinkedList
{
	/** Head node of the list*/
	ListNode head;
	
	/** Tail of the list*/
	ListNode tail;
	
	/** Size of the list*/
	private int size;
	
	/**
	 * Constructs a MyLinkedList object and sets the head to null
	 */
	public MyLinkedList()
	{
		head = null;
		tail = null;
		size=0;
	}
	
	/**
	 * Constructs a MyLinkedList object and sets the head node with a given value
	 * @param val is the value to set the head node
	 */
	public MyLinkedList(int val)
	{
		head = new ListNode(val);
		size=1;
		tail = head;
	}
	
	/**
	 * Determines if the list contains a given value
	 * @param target is what the methods searches for
	 * @return true if the list contains target, else false
	 */
	public boolean contains(int target)
	{
		if(head == null)
			return false;
		
		ListNode cur = head;
		while(cur != null)
		{
			if(cur.val == target)
				return true;
			cur = cur.next;
		}
		return false;
	}
	
	/**
	 * Gets the value at a given index in the list
	 * @param index is the index to get the value from
	 * @return the value at index in the list
	 */
	public int get(int index)
	{
		ListNode cur = head;
		for(int i=0; i<index; i++)
		{
			if(cur.next == null)
				throw new IndexOutOfBoundsException();
			cur = cur.next;
		}
		return cur.val;
	}
	
	/**I
	 * Gets the index of a value in the list
	 * @param target is what the method searches for
	 * @return the index that contains target, if target is not in the list it returns -1
	 */
	public int indexOf(int target)
	{
		if(head == null)
			return -1;
		
		int idx = 0;
		ListNode cur = head;
		while(cur != null)
		{
			if(cur.val == target)
				return idx;
			cur = cur.next;
			idx++;
		}
		return -1;
	}
	
	/**
	 * Sets a value at a given index with a new value
	 * @param newVal is the value to set
	 * @param index is the index to set that value at
	 */
	public void set(int newVal, int index)
	{
		if(index<0 || index>=size())
			throw new IndexOutOfBoundsException();
		
		ListNode cur = head;
		for(int i=0; i<index; i++)
			cur = cur.next;
		cur.val = newVal;
	}
	
	/**
	 * Gets the length of the list
	 * @return the length / size of the list
	 */
	public int size()
	{
		return size;
	}
	
	public int sizeRecursive(int c, ListNode cur)
	{
		if(cur!=null)
			c = sizeRecursive(c+1, cur.next);
		return c;
		
	}
	
	/**
	 * Determines if the list if empty
	 * @return true if the list is empty, else false
	 */
	public boolean isEmpty()
	{
		return head == null;
	}

	/**
	 * Removes a value from the list at a given index
	 * @param index the index of the list to remove
	 * @return the removed value
	 */
	public int remove(int index)
	{	
		if(index==0)
		{
			int rem = head.val;
			head = head.next;
			size--;
			return rem;
		}
		ListNode cur = head;
		for(int i=0; i<index-1; i++)
			cur = cur.next;
		int rem = cur.val;
		cur.next = cur.next.next;
		size--;
		return rem;
	}
	
	/**
	 * Appends a new value to the end of the list
	 * @param newVal the value to add
	 */
	public void add(int newVal)
	{
		
		if(head == null)
		{
			head = new ListNode(newVal);
			tail = head;
			size++;
			return;
		}
		else
		{
			tail.next = new ListNode(newVal);
			tail = tail.next;
			size++;
		}
	}
	
	/**
	 * Insets a value at a given index
	 * @param newVal the value to add
	 * @param index the index to insert it at
	 */
	public void add(int newVal, int index)
	{
		ListNode cur = head;
		for(int i=0; i<index-1; i++)
		{
			cur = cur.next;
		}
		ListNode temp  = cur.next;
		cur.next = new ListNode(newVal);
		cur.next.next = temp;
		
		if(index == size)
			tail = temp;
		
		size++;
	}
	
	/**
	 * Gets a string representation of the list
	 * @return a string representation of the list
	 */
	@Override
	public String toString()
	{
		String str = "[";
		if(size()==0)
			str +="]";
		else if(size()==1)
			str += head.val + "]";
		else 
		{
			ListNode cur = head;
			while(cur.next!=null)
			{
				str += cur.val+", ";
				cur = cur.next;
			}
			str+=cur.val+"]";
		}
		return str;
	}
	
	/**
	 * This class represents a node in the list
	 */
	private class ListNode
	{
		// the value in the node
		int val;
		
		// the next node in the list 
		ListNode next;
		
		//creates the node and sets the value
		public ListNode(int val) {this.val = val;}
		
		//returns the value in the node as a string
		@Override
		public String toString() {return "" + this.val;}
	}
}
