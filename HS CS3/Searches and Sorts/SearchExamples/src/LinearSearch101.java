import java.util.Arrays;
import static java.lang.System.out;


public class LinearSearch101 
{

	public static void main(String[] args) 
	{
		//linear (sequential) search with primitives
		int nums[] = {3,1,4,1,5,9};
		int key = 4;
		boolean found = false;
		
		System.out.println("Elements Checked: ");
		for(int i=0; i<nums.length; i++)
		{
			out.print(nums[i] + " ");
			if(nums[i]==key) 
			{
				found = true;
				break;
			}
		}
		out.println("\n\n" + Arrays.toString(nums));
		if(found)
			out.println("The array contains " + key + "\n");
		else
			out.println("The array does not contain " + key + "\n");
	}

}
