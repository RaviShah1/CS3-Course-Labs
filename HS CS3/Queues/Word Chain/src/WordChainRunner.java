import java.io.IOException;
import java.util.Set;

/**
 * This is the runner / tester class
 * @author Ravi Shah
 *
 */
public class WordChainRunner
{
	/**
	 * Runs the test cases from the input
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		long startTime = System.currentTimeMillis();
		for(WordChain chain : ReadData.readInput())
		{
			System.out.println(chain);
			//break;
		}
		long endTime = System.currentTimeMillis();
		System.out.println("\nTime Taken " + (endTime - startTime) + " milliseconds");
		//System.out.println(ReadData.readInput().get(2));
	}
}
