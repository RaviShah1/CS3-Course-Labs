import java.util.Arrays;

public class HashTable101
{
	
	public static void main(String args[])
	{
		Object[] hashtable = new Object[10];
	
		Character c = '1';
		System.out.println("hashcode for 'c': " + c.hashCode());
		hashtable[c.hashCode()%10] = c;
		
		Character d = 'A';
		hashtable[d.hashCode()%10] = d;
		
		Integer num = 133;
		hashtable[num.hashCode()%10] = num;
		
		String s = "e";
		hashtable[s.hashCode()%10] = s;
		
		System.out.println(Arrays.toString(hashtable));
		
		
	}
}
