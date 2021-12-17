import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class RelativesRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("relatives.dat"));
		Relatives test = new Relatives();
		int T = file.nextInt();
		file.nextLine();
		
		while(T-->0)
		{
			String line = file.nextLine();
			test.setPersonRelative(line);
		}
		System.out.println(test);
	}
}