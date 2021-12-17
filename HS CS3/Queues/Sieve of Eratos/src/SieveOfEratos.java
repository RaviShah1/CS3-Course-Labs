import java.util.LinkedList;
import java.util.Queue;

public class SieveOfEratos
{

	/**
	 * Prints all prime values from 2 to a given number
	 * @param n is the number to go to
	 */
	public static void getVals(int n)
	{
		Queue<Integer> nums = new LinkedList<Integer>();
		for(int i=2; i<=n; i++)
		{
			nums.offer(i);
		}
		if(n<2)
			throw new IllegalArgumentException();
		
		Queue<Integer> primes = new LinkedList<Integer>();
		
		//primes.offer(nums.poll());
		while(!nums.isEmpty())
		{
			Queue<Integer> temp = new LinkedList<Integer>();
			int p = nums.poll();
			for(int e : nums)
				if(e%p!=0)
					temp.offer(e);
			nums = temp;
			primes.offer(p);
		}
		System.out.println(primes);
	}
}
