import java.util.*;
import static java.lang.System.out;

public class SelectionSort101 
{
	public static void main(String args[])
	{
		//selection sort with primitives
		
		int nums[] = new int[10];
				
		//fill arr w/ 10 rand ints [5, 20]
		for(int i=0; i<nums.length; i++)
		{
			nums[i] = (int)(Math.random()*16)+5;
		}
		
		out.println(Arrays.toString(nums));
		
		for(int i=0; i<nums.length-1; i++) // i is first idx of unsorted arr
		{
			//find index of smallest element
			int min = i;
			//check unsorted portion of array for smallest element
			for(int j=i+1; j<nums.length; j++)
			{
				if(nums[j] <= nums[min])
					min = j;
			}
			
			if(min != i)
				swap(nums, i, min);
		}
		
		out.println(Arrays.toString(nums));
	}
	
	private static void swap(int nums[], int p1, int p2)
	{
		int temp = nums[p1];
		nums[p1] = nums[p2];
		nums[p2] = temp;
	}
}
