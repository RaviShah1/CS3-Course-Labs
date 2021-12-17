//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Ravi Shah

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class OddRunner
{
	/**
	 * Runs the program
	 */
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("oddeven.dat"));
		while(file.hasNext())
		{
			String line = file.nextLine();
			OddEvenSets test = new OddEvenSets(line);
			System.out.println(test);
		}
				
	}
}