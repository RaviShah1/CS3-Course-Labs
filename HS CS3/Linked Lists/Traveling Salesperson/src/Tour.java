
public class Tour 
{
	Node head;
	Node tail;
	int size;
	
	public Tour()
	{
		head = null;
		tail = null;
		size = 0;
	}
	
	/** create a four-point tour, for debugging */
	public Tour(Point a, Point b, Point c, Point d)
	{
		insertNearest(a);
		insertNearest(b);
		insertNearest(c);
		insertNearest(d);
	}
	
	/** print tour (one point per line) to std output */
	public void show()
	{
		Node cur = head;
		
		while(cur.next!=null)
		{
			System.out.println(cur.p);
			cur= cur.next;
		}
	}
	
	/** draw the tour using StdDraw */
	public void draw()
	{
		Node cur = head;
		
		while(cur.next!=null)
		{
			cur.p.drawTo(cur.next.p);
			cur = cur.next;
		}
		cur.p.drawTo(head.p);
	}
	
	/** return number of nodes in the tour */
	public int size()
	{		
		return size;
	}
	
	/** return the total distance "traveled", from start to all nodes and back to start */
	public double distance()
	{
		double distance = 0.0;
		Node cur = head;
		
		while(cur.next!=null)
		{
			distance += (cur.p.distanceTo(cur.next.p));
			cur = cur.next;
		}
		
		return distance;
	}
	
	/** insert p using nearest neighbor heuristic */
    public void insertNearest(Point p) 
    {
    	if(head == null)
    	{
    		head = new Node(p);
    		tail = head;
    	}
    	
        int index = 0;
        int smallIdx = 0;
        double smallestDist = Double.MAX_VALUE;
        Node cur= head;
        
        // find index
        while(cur.next!=null)
        {
        	if(cur.p.distanceTo(p) < smallestDist)
        	{
        		smallestDist = cur.p.distanceTo(p);
        		smallIdx = index;
        	}
        	index++;
        	cur = cur.next;
        }
        
        // insert
        cur = head;
        for(int i=0; i<smallIdx; i++)
        {
        	cur = cur.next;
        }
        Node temp = cur.next;
		cur.next = new Node(p);
		if(smallIdx == size)
			tail = cur.next;
		cur.next.next = temp;
		size++;
    }

	/** insert p using smallest increase heuristic */
    public void insertSmallest(Point p) 
    {
    	if(head == null)
    	{
    		head = new Node(p);
    		tail = head;
    	}
    	
    	int index = 0; 
    	int smallIdx = 0;
    	double smallestDist = Double.MAX_VALUE;
    	Node cur = head;
    	
    	while(cur.next!=null)
    	{
    		double og = cur.p.distanceTo(cur.next.p);
    		double added = cur.p.distanceTo(p) + p.distanceTo(cur.next.p) - og;
    		
    		if(added < smallestDist)
    		{
    			smallestDist = added;
        		smallIdx = index;
    		}
    		index++;
        	cur = cur.next;
    	}
    	
    	// insert
        cur = head;
        for(int i=0; i<smallIdx; i++)
        {
        	cur = cur.next;
        }
        Node temp = cur.next;
		cur.next = new Node(p);
		if(smallIdx == size)
			tail = cur.next;
		cur.next.next = temp;
		size++;
    	
    }
    
    public void improveSmallest()
    {
    	for(int t=0; t<10; t++)
    	{
	    	Node cur = head;
	    	for(int i=0; i<size; i++)
	    	{
	    		try
	    		{
		    		Point temp = cur.next.p;
		    		cur.next = cur.next.next;
		    		size--;
		    		insertSmallest(temp);
		    		cur = cur.next;
	    		}
	    		catch(NullPointerException e)
	    		{
	    			
	    		}
	    	}
    	}
    }
    
    /**
	 * Appends a new value to the end of the list
	 * @param newVal the value to add
	 */
	public void add(Point newVal)
	{
		
		if(head == null)
		{
			head = new Node(newVal);
			tail = head;
			size++;
			return;
		}
		else
		{
			tail.next = new Node(newVal);
			tail = tail.next;
			size++;
		}
	}
	
	/**
	 * Gets a value at a given index
	 */
	public Point get(int idx)
	{
		Node cur = head;
		for(int i=0; i<idx; i++)
		{
			cur = cur.next;
		}
		return cur.p;
	}
    
    /**
	 * This class represents a node in the list
	 */
	private class Node
	{
		// the point in the node
		Point p;
		
		// the next node in the list 
		Node next;
		
		//creates the node and sets the value
		public Node(Point p) {this.p = p;}
		
		//returns the value in the node as a string
		@Override
		public String toString() {return "" + this.p;}
	}
}