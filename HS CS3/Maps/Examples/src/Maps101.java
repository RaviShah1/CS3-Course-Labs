import java.util.*;

public class Maps101
{
	public static void main(String args[])
	{
		Map<Integer,  String> map1 = new TreeMap<Integer, String>();
		map1.put(1, "Zavier");
		map1.put(11, "Ty");
		map1.put(8, "Arjun");
		map1.put(3, "Ricky");
		map1.put(5, "Teja");
		map1.put(1, "Oscar");
		
		System.out.println(map1);
		
		System.out.println("\n");
		
		System.out.println("Element at 1: " + map1.get(1));
		System.out.println("Element at 1: " + map1.get(5));
		
		System.out.println("Element at 2: " + map1.get(2));
		// not inex out of bounds - returns null
		
		//.put returns element value that was at the key previously
		System.out.println("\n"+map1.put(2, "Ravi"));
		System.out.println(map1.put(3, "Oscar"));
		
		System.out.println(map1);
		
		System.out.println("\n*******************************************************************************************************************************************************************************************************************************************************************************************************************\n");

		Map<Integer,  String> map2 = new HashMap<Integer, String>();
		map2.put(1, "Zavier");
		map2.put(11, "Ty");
		map2.put(8, "Arjun");
		map2.put(3, "Ricky");
		map2.put(5, "Teja");
		map2.put(1, "Oscar");
		
		System.out.println(map2);
		
		System.out.println("\n");
		
		System.out.println("Element at 1: " + map2.get(1));
		System.out.println("Element at 1: " + map2.get(5));
		
		System.out.println("Element at 2: " + map2.get(2));
		// not inex out of bounds - returns null
		
		//.put returns element value that was at the key previously
		System.out.println("\n"+map2.put(2, "Ravi"));
		System.out.println(map2.put(3, "Oscar"));
		
		System.out.println(map2);
	}
}
