import java.util.*;

public class Iterators102
{

	public static void main(String[] args)
	{
		List<Integer> list1 = new ArrayList<Integer>();
		// ArrayList fill 10 integers [1..10]
		for(int i=0; i<10; i++)
		{
			list1.add((int)(Math.random()*10) + 1);
		}
		
		// you can use a basic for loop with iterators but its weird
		System.out.println("ArrayList: ");
		for(Iterator<Integer> i = list1.iterator(); i.hasNext(); /*this is empty*/)
		{
			System.out.print(i.next() + " ");
		}

		
	}

}
