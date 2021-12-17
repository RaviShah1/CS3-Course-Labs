/**
 * This program is the runner for the remove it iterators lab
 * @author Ravi Shah
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class IteratorRemoverRunner
{
	/**
	 * runs the program
	 */
	public static void main ( String[] args )
	{
		IteratorRemover test = new IteratorRemover("a b c a b c", "a");
		test.remove();
		System.out.println(test);
		
		test.setTest("a b c d e f g h i j x x x x", "x");
		test.remove();
		System.out.println(test);
		
		test.setTest("1 2 3 4 5 6 a b c a b c", "b");
		test.remove();
		System.out.println(test);
	}
}