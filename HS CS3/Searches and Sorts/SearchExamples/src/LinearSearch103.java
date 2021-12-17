import static java.lang.System.out;

import java.util.Arrays;

public class LinearSearch103
{
	public static void main(String args[])
	{
		//linear (sequential) search with primitives
		Comparable list[] = {"Vincent", "Ty", "Ravi", "Teja", "Rayyon", "Leia"};
		String key = "Teja";
		int loc = -1;
		
		System.out.println("Elements Checked: ");
		for(int i=0; i<list.length; i++)
		{
			out.print(list[i] + " ");
			if(list[i].compareTo(key) == 0) 
			{
				loc = i;
				break;
			}
		}
		out.println("\n\n" + Arrays.toString(list));
		if(loc>-1)
			out.println("The array contains " + key + " at index " + loc  + "\n");
		else
			out.println("The array does not contain " + key + "\n");		
	}
}
