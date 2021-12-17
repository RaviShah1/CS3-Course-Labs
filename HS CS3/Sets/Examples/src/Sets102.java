import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Sets102
{

	public static void main(String[] args)
	{
		//Parsing words from a string to a set via an array and collection
		//.split()

		String[] words = "memes are dreams".split(" ");
	
		//.asList() acts as a bridge between array based and collection based APIs
		Set<String> set = new TreeSet<String>(Arrays.asList(words));
		List<String> list = new ArrayList<String>(Arrays.asList(words));
		System.out.println(set + "\n");

	}

}
