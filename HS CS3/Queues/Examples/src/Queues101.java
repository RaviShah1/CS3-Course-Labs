import java.util.Queue;
import java.util.LinkedList;
public class Queues101
{

	public static void main(String[] args)
	{
		//Queue is an interface
		Queue<Integer> queue;
		
		//LinkedList implements the queue interface (A queue reference to a linked list)
		queue = new LinkedList<Integer>();
	
		//elements are added at the tail of the queue
		//to add an element is to enqueue it
		queue.add(42);
		queue.add(23);
		queue.add(90);
		queue.add(13);
		queue.add(21);
		System.out.println(queue);
		
		//removing elements - first in first out (FIFO) order
		//remove() returns the element that was removed
		//elements are remove from the head
		
		//head is index 0; tail the the last index
		System.out.println("Removing " + queue.remove());
		System.out.println(queue);
		//to remove an element is to "dequeue"
		//System.out.println("Removing" + queue.remove());
		queue.remove();
		queue.remove();
		System.out.println(queue);
		
		queue.add(1);
		
		System.out.println(queue);
	}
}
