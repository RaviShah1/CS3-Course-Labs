import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class HistogramRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("histogram.dat"));
		Histogram test = new Histogram();
		
		while(file.hasNextLine())
		{
			test.setSentence(file.nextLine().trim());
			System.out.println(test);
		}
	}
}