import java.util.LinkedList;
import java.util.Queue;

public class Queues102
{

	public static void main(String[] args)
	{
		Queue<String> names = new LinkedList<String>();
		names.add("Vincent");
		names.add("Syed");
		System.out.println(names.add("Anthony"));
		System.out.println(names.add("Emma"));
		System.out.println(names.add("Ravi"));
				
		System.out.println("Numb"+ "er of elements: " + names.size());
		
		//cannot use basic for loop because there is no get method
		//System.out.println("Printing queue with loop");
		//for(int i = 0; i<names.size(); i++)
		//	System.out.println(i + ". " + (names).get(i));
		
		System.out.println();
		for(String name : names)
			System.out.println(name);
		System.out.println();
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//peek() will return the element at the front of the queue but does not remove it
		System.out.println("The element at the head of the queue (index 0) is " + names.peek());
		System.out.println();
		
		//isEmpty  returns true if there is nothing in the queue
		System.out.println("Dedqueuing until isEmpty==true");
		while(!names.isEmpty())
		{
			System.out.println("Removing " + names.remove() + " -- Empty Queue: " + names.isEmpty());
		}
		System.out.println(names);
		
		//peek() returns null if the queue is empty
		System.out.println("\nThe element at the front of the queue is:");
		System.out.println(names.peek());
		
		//remove() throws an exception if the queue is empty
		names.remove();
		
	}

}
