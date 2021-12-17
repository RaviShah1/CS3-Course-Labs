import java.util.Queue;
import java.util.LinkedList;

public class EvensFirst
{
	private Queue<Integer> q;
	
	/**
	 * Constructs an object of the EvensFirst class
	 * @param nums is a string on numbers to organize
	 */
	EvensFirst(String nums)
	{
		q = new LinkedList<Integer>();
		setQueue(nums);
	}
	
	public void setQueue(String nums)
	{
		String[] vals = nums.split(", ");
		
		for(String s : vals)
			q.offer(Integer.parseInt(s));
	}
	
	/**
	 * Puts the evens first the the queue
	 */
	public void run()
	{	
		Queue<Integer> evens = new LinkedList<Integer>();
		Queue<Integer> odds = new LinkedList<Integer>();
		while(!q.isEmpty())
		{
			int val = q.poll();
			if(val%2==0)
				evens.offer(val);
			else
				odds.offer(val);
		}
		
		while(!evens.isEmpty())
			q.offer(evens.poll());
		while(!odds.isEmpty())
			q.offer(odds.poll());
	}
	
	/**
	 * Prints the queue
	 * @return the queue with the evens in front
	 */
	public String toString()
	{
		run();
		String str = "head(";
		Queue<Integer> temp = new LinkedList<Integer>();
		int val = 0;
		while(!q.isEmpty())
		{
			val = q.poll();
			if(q.size()>1)
				str += val + ", ";
			temp.offer(val);
			
		}
		str+=val;
		
		q = temp;
		str += ")tail";
		return str;
	}
}
