import java.util.Stack;

public class StackProbs
{
	/**
	 * Replaces every value in the supplied stack with two of the same value 
	 * @param nums is a stack of the input numbers
	 * @return stack with values in nums doubled
	 */
	public static Stack<Integer> doubleUp(Stack<Integer> nums)
	{
		Stack<Integer> stack = new Stack<Integer>();
		while(!nums.isEmpty())
		{
			int val = nums.pop();
			stack.push(val);
			stack.push(val);
		}
		
		Stack<Integer> stack2 = new Stack<Integer>();
		while(!stack.isEmpty())
		{
			int val = stack.pop();
			stack2.push(val);
		}
		
		return stack2;
	}
	
	/**
	 * Splits supplied stack, such that all the negative numbers will be at the bottom of the stack, 
	 * and all non-negative numbers will be at the top of the stack.
	 * @param nums is a stack of the input numbers
	 * @return stack with values in nums sorted by positive and negative
	 */
	public static Stack<Integer> posAndNeg(Stack<Integer>nums)
	{
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> neg = new Stack<Integer>();
		Stack<Integer> pos = new Stack<Integer>();

		while(!nums.isEmpty())
		{
			int val = nums.pop();
			if(val<0)
				neg.push(val);
			else
				pos.push(val);
		}
		
		while(!neg.isEmpty())
			stack.push(neg.pop());
		while(!pos.isEmpty())
			stack.push(pos.pop());
		
		return stack;
	}
	
	/**
	 * Shifts a stack some number of times
	 * @param nums is a stack of the input numbers
	 * @param n is the number times the stack should be shifted
	 * @return stack with values in nums shifted
	 */
	public static Stack<Integer> shiftByN(Stack<Integer> nums, int n)
	{
		Stack<Integer> vals = new Stack<Integer>();
		vals.addAll(nums);
		
		for(int i=0; i<n; i++)
		{
			Stack<Integer> shift = new Stack<Integer>();
			int last = 0;
			while(!vals.isEmpty())
			{
				shift.push(vals.pop());
			}
			last = shift.pop();
			
			while(!shift.isEmpty())
				vals.push(shift.pop());
			vals.push(last);
				
		}
		
		return vals;
	}
	
	/**
	 * Reverses the vowels in a string using a stack
	 * @param str is the input string
	 * @return the input string with the vowels reversed
	 */
	public static String reverseVowels(String str)
	{
		Stack<Character> vowels = new Stack<Character>();
		
		for(int i=0; i<str.length(); i++)
		{
			char let = str.charAt(i);
			if(let=='a' || let=='e' || let=='i' || let=='o' || let=='u' ||
			   let=='A' || let=='E' || let=='I' || let=='O' || let=='U')
				vowels.push(let);
		}
		
		String res = "";
		for(int i=0; i<str.length(); i++)
		{
			char let = str.charAt(i);
			if(let=='a' || let=='e' || let=='i' || let=='o' || let=='u' ||
			   let=='A' || let=='E' || let=='I' || let=='O' || let=='U')
				res+=(vowels.pop());
			else
				res+=let;
		}
		
		return res;
	}
}
