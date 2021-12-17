/**
 * This program is the runner for the replace it iterators lab
 * @author Ravi Shah
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class IteratorReplacerRunner
{
	/**
	 * Runs the program
	 */
	public static void main ( String[] args )
	{
		IteratorReplacer test = new IteratorReplacer("1 2 3 1 2 4", "1", "5");
		test.replace();
		System.out.println(test);
		
		test.setEmAll("1 2 3 4 5 6 7 8 9 10 -1 -1 -1", "-1", "42");
		test.replace();
		System.out.println(test);
		
		test.setEmAll("3 1 4 1 5 9 33 72 -3 2 3 6", "3", "0");
		test.replace();
		System.out.println(test);
	}
}