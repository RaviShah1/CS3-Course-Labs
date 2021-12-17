import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

public class Sets101
{

	 // Set One = [3, 6, 5, 9]
	 // Set Two = [7, 9, 1, 6]
	public static void main(String[] args)
	{
		Set<Integer> set1 = new TreeSet<Integer>();
		Set<Integer> set2 = new TreeSet<Integer>();
		
		set1.add(3);
		set1.add(6);
		set1.add(5);
		set1.add(9);
		System.out.println("Set 1:" + set1);
		
		set2.add(7);
		set2.add(9);
		set2.add(1);
		set2.add(6);
		System.out.println("Set 2:" + set2);
		
		// Set Three = set1 U set2
		Set<Integer> set3 = new TreeSet<Integer>();
		set3.addAll(set1);
		set3.addAll(set2);
		System.out.println("Union: " + set3);
		
		set3.clear();
		
		//Set Three = set1 ∩ set2
		set3.addAll(set1);
		set3.retainAll(set2);
		System.out.println("Intersection: " + set3);
		
		set3.clear();
		
		//Set Three = set1 - set2
		set3.addAll(set1);
		set3.removeAll(set2);
		System.out.println("Difference: " + set3);
	}

}
