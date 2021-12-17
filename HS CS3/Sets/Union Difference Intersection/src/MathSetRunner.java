//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Ravi Shah

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class MathSetRunner
{
	/**
	 * runs the program
	 */
	public static void main(String args[]) throws IOException
	{
		
		Scanner file = new Scanner(new File("mathsetdata.dat"));
		while(file.hasNext())
		{
			String one = file.nextLine();
			String two = file.nextLine();
			MathSet test = new MathSet(one, two);
			System.out.println(test);
			System.out.println("union - " + test.union());
			System.out.println("intersection - " + test.intersection());
			System.out.println("difference A-B - " + test.differenceAMinusB());
			System.out.println("difference B-A - " + test.differenceBMinusA());
			System.out.println("Symmetric Difference - " + test.symmetricDifference());
			System.out.println("\n");
		}
	}
}
