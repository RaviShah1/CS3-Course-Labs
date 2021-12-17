import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * This file contains a class of methods used to read
 * in the data
 * @author Ravi Shah
 *
 */
public class ReadData
{
	/**
	 * Reads in the dictionary and stores it in a hash set
	 * @return the dictionary in a hash set
	 * @throws IOException
	 */
	public static Set<String> readDictionary() throws IOException
	{
		Set<String> dict = new HashSet<String>();
		Scanner file = new Scanner(new File("dictionary.txt"));
		while(file.hasNext())
			dict.add(file.nextLine());
		return dict;
	}
	
	/**
	 * Reads in the input file and stores the input in a list of word chain objects
	 * @return a list of WordChain objects containing the input
	 * @throws IOException
	 */
	public static List<WordChain> readInput() throws IOException
	{
		List<WordChain> list = new ArrayList<WordChain>();
		Scanner file = new Scanner(new File("input.txt"));
		Set<String> dict = readDictionary();
		while(file.hasNext())
		{
			String[] testCase = file.nextLine().split(" ");
			list.add(new WordChain(testCase[0], testCase[1]));
		}
		return list;
	}
}
