/**
 * Linked list of gems
 * @author Ravi Shah
 *
 */
public class GemList 
{
	private Node head; // head of the list
	private Node tail; // tail of the list
	private int size; // size of the list
	
	/**
	 * Constructs an empty linked list
	 */
	public GemList()
	{
		head = null;
		tail = null;
		size = 0;
	}
	
	/**
	 * Gets the size of the list
	 * @return the size of the list
	 */
	public int size() 
	{
		return size;
		
	}
	
	/**
	 * Draws the list
	 * @param y is the y coordinate to draw the list at
	 */
	public void draw(double y)
	{
		if(head==null)
			return;
		
		Node cur = head;
		int count=0;
		while(cur != null)
		{
			cur.gem.draw(GemGame.indexToX(count), y);
			count++;
			cur = cur.next;
		}
	}
	
	/**
	 * Gets a string representation of the list
	 * @return the string representation of the list
	 */
	public String toString()
	{
		if(head == null)
			return "<none>";
		
		String str = "";
		Node cur = head;
		while(cur.next!=null)
		{
			str += cur.gem.toString() + " -> ";
			cur = cur.next;
		}
		str += cur.gem.toString();
		return str;
	
	}
	
	/**
	 * Insets a gem into the list
	 * @param gem is the gem to insert
	 * @param index is the index to insert the gem at
	 */
	public void insertBefore(Gem gem, int index)
	{
		
		if(head == null)
		{
			head = new Node(gem);
			tail = head.next;
			size++;
			return;
		}
		
		
		if(index >= size)
		{
			if(tail == null)
			{
				tail = new Node(gem);
				head.next = tail;
				size++;
				return;
			}
			tail.next = new Node(gem);
			tail = tail.next;
			size++;
			return;
		}
		
		Node cur = head;
		for(int i=0; i<index-1; i++)
		{
			cur = cur.next;
		}
		Node temp = cur.next;
		cur.next = new Node(gem);
		cur.next.next = temp;
		size++;
		
	}
	
	/**
	 * Gets the total score of the list
	 * @return the score of the list
	 */
	public int score()
	{
		int score = 0;
		int subScore = 0;
		int mult = 0;
		GemType c = null;
		
		Node cur = head;
		while(cur!=null)
		{
			if(c==null)
			{
				mult++;
				c = cur.gem.getType();
				subScore += cur.gem.getPoints();
			}
			else if(cur.gem.getType() == c)
			{
				mult++;
				subScore += cur.gem.getPoints();
			}
			else
			{
				if(mult==0)
					mult=1;
				c = cur.gem.getType();
				score += (subScore*mult);
				subScore=cur.gem.getPoints();
				mult = 1;
			}
			cur = cur.next;
		}

		if(mult==0)
			mult=1;
		score += (subScore*mult);
		return score;
		
	}
	
	/**
	 * This class represents a node in the list
	 */
	private class Node
	{
		// the value in the node
		Gem gem;
		
		// the next node in the list 
		Node next;
		
		//creates the node and sets the value
		public Node(Gem gem) {this.gem = gem;}
		
		//returns the value in the node as a string
		@Override
		public String toString() {return "" + this.gem;}
	}
	/** Test method */
	public static void main(String [] args)
	{
		GemList list = new GemList();
		System.out.println(list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.9);		
		
		list.insertBefore(new Gem(GemType.BLUE, 10), 0);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.8);
		
		list.insertBefore(new Gem(GemType.BLUE, 20), 99);  //not a mistake, should still work
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.7);
		
		list.insertBefore(new Gem(GemType.ORANGE, 30), 1);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.6);
		
		list.insertBefore(new Gem(GemType.ORANGE, 10), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.5);
		
		list.insertBefore(new Gem(GemType.ORANGE, 50), 3);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.4);
		
		list.insertBefore(new Gem(GemType.GREEN, 50), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.3);		
	}	
}
