import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class SpanRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("spantoeng.dat"));
		SpanishToEnglish test = new SpanishToEnglish();
		int T = file.nextInt();
		file.nextLine();
		
		while(T-->0)
		{
			String line = file.nextLine();
			test.putEntry(line);
		}
		System.out.println(test);
		System.out.println();
		
		while(file.hasNext())
		{
			String line = file.nextLine();
			System.out.println(test.translate(line));
		}
	}
}