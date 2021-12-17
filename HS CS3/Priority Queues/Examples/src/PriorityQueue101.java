import java.util.*;

public class PriorityQueue101
{

	public static void main(String args[])
	{
		Queue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(2);
		pq.offer(3);
		pq.add(6);
		pq.offer(1);
		pq.add(8);
		pq.offer(4);
		pq.add(5);
		pq.offer(9);
		
		System.out.println("Head: " + pq.peek());
		System.out.println("Head: " + pq.element() + "\n");
		
		//not "PQ order"
		System.out.println(pq);
		
		for(int num : pq)
		{
			System.out.print(num + " ");
		}
		System.out.println();
		
		while(!pq.isEmpty())
		{
			System.out.println(pq.poll() + " ");
		}
		System.out.println();
	}
}
