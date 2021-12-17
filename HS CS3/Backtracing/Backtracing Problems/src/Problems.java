import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problems
{
	/**
	 * Prints all possible way to climb stairs of a given 
	 * number of steps
	 * @param steps is the number of steps
	 */
	public static void climbStairs(int steps)
	{
		if(steps==0)
			System.out.println();
		else
			climbHelper(steps, "", 0);
	}
	
	/**
	 * Helper method to print all possible way to climb stairs of a 
	 * given number of steps
	 * @param steps is the number of steps
	 * @param str is the path of steps
	 * @param sum is the number of steps climbed in the path
	 */
	private static void climbHelper(int steps, String str, int sum)
	{
		if(sum>steps)
			return;
		if(sum==steps)
			System.out.println(str.substring(0, str.length()-2));
		else
		{
			climbHelper(steps, str+"1, ", sum+1);
			climbHelper(steps, str+"2, ", sum+2);
		}
	}

	/**
	 * Finds all possible paths to travel from (0,0) to a location
	 * going North, East, or Northeast
	 * @param x is the x final destination
	 * @param y is the y final destination
	 */
	public static void campsite(int x, int y)
	{
		if(x==0 && y==0)
			System.out.println();
		else
		{
			campsiteHelper(x,y,0,0,"");
		}
	}
	
	/**
	 * Helper method to find all possible paths to travel from (0,0) 
	 * to a location going North, East, or Northeast
	 * @param x is the x final destination
	 * @param y is the y final destination
	 * @param curX is the current x value
	 * @param curY is the current y value
	 * @param path is the path to the camp site
	 */
	private static void campsiteHelper(int x, int y, int curX, int curY, String path)
	{
		if(curX>x || curY>y)
			return;
		if(curX==x && curY==y)
			System.out.println(path);
		else
		{
			campsiteHelper(x, y, curX+1, curY, path+"E ");
			campsiteHelper(x, y, curX, curY+1, path+"N ");
			campsiteHelper(x, y, curX+1, curY+1, path+"NE ");
		}
	}
	
	/**
	 * Gets the maximum sum that can be created using values 
	 * in an array
	 * @param list is the list of values
	 * @param limit is the limit the sum must be under
	 * @return the max sum
	 */
	public static int getMax(List<Integer> list, int limit)
	{
		if (list.size() == 0 || limit <= 0) 
			return 0;
		else 
		    return getMaxHelper(list, limit, 0);
	}

	/**
	 * Helper method to get the maximum sum that can be created
	 * using values in an array
	 * @param list is the list of values
	 * @param limit is the limit the sum must be under
	 * @param idx is the current index the mthod is working on
	 * @return the max sum
	 */
	private static int getMaxHelper(List<Integer> list, int limit, int idx)
	{
		if(idx==list.size())
			return 0;
			
		int path1 = getMaxHelper(list, limit-list.get(idx), idx+1) + list.get(idx);
		int path2 = getMaxHelper(list, limit, idx+1);
		    
		if(path1<=limit && path1>path2)
			return path1;
		        
		return path2;
	}

	/**
	 * Gets the number of ways change can make up a given total
	 * @param amount is the total the change should add up to
	 * @return the number of ways change can add to amount
	 */
	public static int makeChange(int amount)
	{
		if(amount<=0)
			return 0;
		else
		{
			int[] money = {0,0,0,0};
			return makeChangeHelper(amount, money, 0);
		}
	}
	
	/**
	 * Helper method to get the number of ways change can make up 
	 * a given total
	 * @param amount is the total the change should add up to
	 * @param money is an array of length four representing different types of change
	 * @param prev is the index of the previous type of change the method worked on
	 * @return the number of ways change can add to amount
	 */
	private static int makeChangeHelper(int amount, int[] money, int prev)
	{
		if(calculateChange(money)>amount)
			return 0;
		if(calculateChange(money)==amount)
		
			return 1;
		
		int count = 0;
		for(int i=3; i>=prev; i--)
		{
			money[i]++;
			count += makeChangeHelper(amount, money, i);
			money[i]--;
		}
		return count;
	}
	
	/**
	 * Prints a report of all the ways change can add to a given 
	 * total
	 * @param amount is the total the change should add up to
	 */
	public static void makeChangeCoinCount(int amount)
	{
		if(amount<=0)
			System.out.println();
		else
		{
			System.out.println(" P  N  D  Q");
			System.out.println("------------");
			int[] money = {0,0,0,0};
			coinCountHelper(amount, money, 0);
		}
	}
	
	/**
	 * Helper to print a report of all the ways change can add to a
	 * given total
	 * @param amount is the total the change should add up to
	 * @param money is an array of length four representing different types of change
	 * @param prev is the index of the previous type of change the method worked on
	 */
	private static void coinCountHelper(int amount, int[] money, int prev)
	{
		if(calculateChange(money)>amount)
			return;
		if(calculateChange(money)==amount)
		{
			System.out.println(Arrays.toString(money));
			return;
		}
		
		for(int i=3; i>=prev; i--)
		{
			money[i]++;
			coinCountHelper(amount, money, i);
			money[i]--;
		}
	}
	
	/**
	 * Helper method to calculate change given an array representing money of length four
	 * @param money is an array of length four representing different amounts of money
	 * @return the total amount of money the array is worth
	 */
	private static int calculateChange(int[] money)
	{
		return money[0]*1 + money[1]*5 + money[2]*10 + money[3]*25;
	}
	
	
	public static void main(String[] args)
	{
		System.out.println("Climb Stairs");
		climbStairs(4);
		
		System.out.println("\nCampsite");
		campsite(2, 1);
		
		System.out.println("\nGet Max");
		Integer[] arr = {30, 2, 8, 22, 22, 6, 4, 20};
		List<Integer> list = new ArrayList<Integer>();
		Collections.addAll(list, arr);
		System.out.println(getMax(list, 19));
		
		System.out.println("\nMake Change");
		System.out.println(makeChange(25));
		System.out.println(makeChange(100));
		
		System.out.println("\nCoin Count");
		makeChangeCoinCount(11);
	}

}
