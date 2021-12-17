import java.util.*;
import static java.lang.System.out;

public class BubbleSort101 
{

	public static void main(String[] args)
	{
		int nums[] = new int[10];
		
		//fill arr w/ 10 random ints [2, 11]
		for(int i=0; i<nums.length; i++)
		{
			nums[i] = (int)(Math.random()*10)+2;
		}
		
		out.println(Arrays.toString(nums));

		int count = 0;
		do
		{
			count = 0;
			for(int i=0; i<nums.length-1; i++)
			{
				if(nums[i] > nums[i+1])
				{
					swap(nums, i, i+1);
					count++;
				}
			}
		}while(count>0);
		
		out.println(Arrays.toString(nums));
	}
	
	private static void swap(int nums[], int p1, int p2)
	{
		int temp = nums[p1];
		nums[p1] = nums[p2];
		nums[p2] = temp;
	}
	
}