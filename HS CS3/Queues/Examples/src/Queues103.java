import java.util.LinkedList;
import java.util.Queue;

public class Queues103
{

	public static void main(String[] args)
	{
		Queue<String> names = new LinkedList<String>();
		names.offer("Vincent");
		names.offer("Syed");
		System.out.println(names.offer("Anthony"));
		System.out.println(names.offer("Emma"));
		System.out.println(names.offer("Ravi"));
				
		System.out.println("Numb"+ "er of elements: " + names.size());

		//poll ==== removes
		names.poll();

		//element() ==== peek()  but element will throw exception if the queue is empty
		System.out.println(names.element());
	}

}

