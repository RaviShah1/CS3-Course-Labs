import java.util.*;
import static java.lang.System.out;

public class InsertionSort102 
{
	public static void main(String args[])
	{
		Comparable nums[] = new Comparable[10];
		
		for(int i=0; i<nums.length; i++)
			nums[i] = (int)(Math.random()*19)+3;
		
		//[3,21]
		out.println(Arrays.toString(nums));
		
		for(int i=1; i<nums.length; i++)
		{
			Comparable temp = nums[i];
			int j=i;
			while(j>0 && (temp.compareTo(nums[j-1]) < 0))
			{
				nums[j] = nums[j-1];
				j--;
			}
			nums[j] = temp; //insert element in arr at index j
			
		}
		
		out.println(Arrays.toString(nums));
		
		
	}
	
	private static void swap(Comparable nums[], int p1, int p2)
	{
		Comparable temp = nums[p1];
		nums[p1] = nums[p2];
		nums[p2] = temp;
	}
}
