import java.util.Stack;

public class Runner
{

	public static void main(String[] args)
	{
		int[] vals = {1,3,5,0,-1};
		Stack<Integer> s = makeStack(vals);
		System.out.print("(1, 3, 5, 0, -1)                  >>> ");
		System.out.println(StackProbs.doubleUp(s));
		
		int[] vals2 = {2, 9, -4, 3, -1, 0, -6};
		s = makeStack(vals2);
		System.out.print("(2, 9, -4, 3, -1, 0, -6)          >>> ");
		System.out.println(StackProbs.posAndNeg(s));
		
		int[] vals3 = {7, 23, -7, 0, 22, -8, 4, 5};
		s = makeStack(vals3);
		System.out.print("(7, 23, -7, 0, 22, -8, 4, 5), 3   >>> ");
		System.out.println(StackProbs.shiftByN(s, 3));
		
		System.out.print("(\"hello how are you\")             >>> ");
		System.out.println(StackProbs.reverseVowels("hello how are you"));
	}

	/** Adds all values of a list to a stack*/
	public static Stack<Integer> makeStack(int[] nums) 
	{
		Stack<Integer> stack = new Stack<>();
		for (int num : nums)
			stack.push(num);
		return stack;
	}
}
