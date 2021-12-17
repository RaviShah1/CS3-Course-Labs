import java.util.*;

public class Iterators101
{

	public static void main(String[] args)
	{
		List<Integer> list1 = new ArrayList<Integer>();
		List<Double> list2 = new LinkedList<Double>();
		Set<Integer> set1 = new HashSet<Integer>();
		Set<Double> set2 = new TreeSet<Double>();
		
		// ArrayList fill 10 integers [1..10]
		for(int i=0; i<10; i++)
		{
			list1.add((int)(Math.random()*10) + 1);
		}
		
		//linked list fill 10 doubles [0.0 .. .99]
		for(int i=0; i<10; i++)
		{
			list2.add((int)(Math.random()*100) / 100.00);
		}
		
		// HashSet fill 10 integers [2..12] (as long as no duplicates)
		for(int i=0; i<10; i++)
		{
			set1.add((int)(Math.random()*11) + 2);
		}
				
		// TreeSet fill 10 integers [1.0..1.99] (as long as no duplicates)
		for(int i=0; i<10; i++)
		{
			set2.add(((int)(Math.random()*100) / 100.00)+1);
		}
		
		Iterator<Integer> here1 = list1.iterator();
		Iterator<Double> here2 = list2.iterator();
		Iterator<Integer> here3 = set1.iterator();
		Iterator<Double> here4 = set2.iterator();
		
		System.out.println("ArrayList: ");
		while(here1.hasNext())
		{
			System.out.print(here1.next() + " ");
		}
		
		System.out.println("\n\nLinkedList: ");
		while(here2.hasNext())
		{
			System.out.print(here2.next() + " ");
		}
		
		System.out.println("\n\nHashSet: ");
		while(here3.hasNext())
		{
			System.out.print(here3.next() + " ");
		}
		
		System.out.println("\n\nTreeSet: ");
		while(here4.hasNext())
		{
			System.out.print(here4.next() + " ");
		}
		
		
	}

}
