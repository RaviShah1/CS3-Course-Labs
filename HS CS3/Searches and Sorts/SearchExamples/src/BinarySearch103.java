import java.util.*;
import static java.lang.System.out;

public class BinarySearch103 
{
	public static void main(String args[])
	{
		int nums[] = {3,2,6,8,5,7};
		Arrays.sort(nums);
		int index = Arrays.binarySearch(nums, 4);
		
		if(index > -1)
			out.println("The item is at index: " + index);
		else
			out.println("The item is not in the array\nThe item should be places at " + Math.abs(index+1));
	}
	
}
