//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import static java.lang.System.*;
import java.util.*;

public class DupRunner
{
	/**
	 * runs the program
	 */
	public static void main( String args[] )
	{
		String str = "a b c d e f g h a b c d e f g h i j k";
		System.out.println("Original List : " + str);
		System.out.println("Uniques : " + UniquesDupes.getUniques(str));
		System.out.println("Dupes : " + UniquesDupes.getDupes(str));
		System.out.println();
		
		str = "one two three one two three six seven one two";
		System.out.println("Original List : " + str);
		System.out.println("Uniques : " + UniquesDupes.getUniques(str));
		System.out.println("Dupes : " + UniquesDupes.getDupes(str));
		System.out.println();

		str = "1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 6";
		System.out.println("Original List : " + str);
		System.out.println("Uniques : " + UniquesDupes.getUniques(str));
		System.out.println("Dupes : " + UniquesDupes.getDupes(str));
	}
}