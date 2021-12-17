import static java.lang.System.out;

import java.util.Arrays;

public class BinarySearch102
{
	public static void main(String args[])
	{
		Comparable list[] = {"Vincent", "Ty", "Ravi", "Teja", "Rayyon", "Leia"};
		
		System.out.println("Unsorted: " + Arrays.toString(list));
		Arrays.sort(list);
		System.out.println("Sorted: " + Arrays.toString(list));

		String key = "Teja";
		int loc = -1;
		int min = 0;
		int max = list.length-1;
		
		out.println("\nElements Check");
		while(min<max)
		{
			int mean = (min+max)/2;
			out.println(list[mean] + " ");
			
			if(list[mean].compareTo(key) == 0)
			{
				loc = mean;
				break;
			}
			else
			{
				if(list[mean].compareTo(key) > 0)
					max = mean-1;
				else
					min = mean+1;
			}
		}
		
		out.println("\n\n" + Arrays.toString(list));
		if(loc>-1)
			out.println("The array contains " + key + " at index " + loc  + "\n");
		else
			out.println("The array does not contain " + key + "\n");
	}
}
