import java.util.Arrays;
import java.util.LinkedList;

public class HashTable102
{

	public static void main(String[] args)
	{
		LinkedList[] hash = new LinkedList[10];
		System.out.println(Arrays.toString(hash));

		for(int i=0; i<hash.length; i++)
		{
			hash[i] = new LinkedList();
		}
		System.out.println("\n");
		
		System.out.println(Arrays.toString(hash));

		System.out.println("\n");
		
		Character d = 'A';
		hash[d.hashCode()%10].add(d);
		
		d = 'A';
		hash[d.hashCode()%10].add(d);
		
		d = 'B';
		hash[d.hashCode()%10].add(d);
		
		Integer num = 45;
		hash[num.hashCode()%10].add(num);
		
		num = 113;
		hash[num.hashCode()%10].add(num);
		
		num = 263;
		hash[num.hashCode()%10].add(num);
		
		num = 783;
		hash[num.hashCode()%10].add(num);
		
		String s = "e";
		hash[num.hashCode()%10].add(num);
		
		int idx = 0;
		for(LinkedList list : hash)
			System.out.println(idx++ + " " + list.toString());
	}

}