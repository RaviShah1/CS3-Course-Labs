import static java.lang.System.out;

import java.util.Arrays;

public class BinarySearch101 
{
	public static void main(String args[])
	{
		int nums[] = {3,1,4,1,5,9};
		
		System.out.println("Unsorted: " + Arrays.toString(nums));
		Arrays.sort(nums);
		System.out.println("Sorted: " + Arrays.toString(nums));

		int key = 2;
		int loc = -1;
		int min = 0;
		int max = nums.length-1;
		
		out.println("\nElements Check");
		while(min<max)
		{
			int mean = (min+max)/2;
			out.println(nums[mean] + " ");
			
			if(nums[mean] == key)
			{
				loc = mean;
				break;
			}
			else
			{
				if(key < nums[mean])
					max = mean-1;
				else
					min = mean+1;
			}
		}
		
		out.println("\n\n" + Arrays.toString(nums));
		if(loc>-1)
			out.println("The array contains " + key + " at index " + loc  + "\n");
		else
			out.println("The array does not contain " + key + "\n");
	}
}
