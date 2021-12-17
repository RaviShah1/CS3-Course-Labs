import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class AcroRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("acro.dat"));
		int T = file.nextInt();
		file.nextLine();
		
		Acronyms test = new Acronyms();
		
		while(T-->0)
		{
			String line = file.nextLine();
			test.putEntry(line);
		}
		System.out.println(test + "\n");
		
		while(file.hasNextLine())
		{
			String sent = file.nextLine();
			System.out.println(test.convert(sent));
		}
	}
}