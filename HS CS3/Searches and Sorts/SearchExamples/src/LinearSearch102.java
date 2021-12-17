import static java.lang.System.out;

import java.util.Arrays;

public class LinearSearch102 
{
	public static void main(String args[])
	{
		//linear (sequential) search with primitives
		int nums[] = {3,1,4,1,5,9};
		int key = 4;
		int loc = -1;
		
		System.out.println("Elements Checked: ");
		for(int i=0; i<nums.length; i++)
		{
			out.print(nums[i] + " ");
			if(nums[i]==key) 
			{
				loc = i;
				break;
			}
		}
		out.println("\n\n" + Arrays.toString(nums));
		if(loc>-1)
			out.println("The array contains " + key + "at index " + loc  + "\n");
		else
			out.println("The array does not contain " + key + "\n");		
	}
}
