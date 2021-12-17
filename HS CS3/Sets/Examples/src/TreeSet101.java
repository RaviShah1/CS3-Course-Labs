import java.util.Set;
import java.util.TreeSet;

public class TreeSet101
{
	//

	public static void main(String[] args)
	{
		Set<Integer> nums = new TreeSet<Integer>();
		nums.add(3);
		nums.add(2);
		
		//adding elements
		System.out.println(nums.add(6));
		System.out.println("nums: " + nums);

		System.out.println(nums.add(6)); // duplicates will not be added
		System.out.println("nums: " + nums);
		
		System.out.println(nums.add(-4)); // natural ordering in maintained
		System.out.println("nums: " + nums);
		
		//removing elements
		System.out.println(nums.remove(2));
		System.out.println(nums.remove(5));
		System.out.println("nums: " + nums);
		
		System.out.println("======================================================================================================================================================================\n");
	
		Set<String> words = new TreeSet<String>();
		words.add("rock");
		words.add("paper");
		System.out.println(words.add("scissors"));
		System.out.println("words: " + words);
		System.out.println(words.add("rock"));
		System.out.println("words: " + words);
		System.out.println(words.add("lizzard"));
		System.out.println("words: " + words);
		
		//remove
		System.out.println(words.remove("scissors"));
		System.out.println(words.remove("spock"));
		System.out.println("words: " + words);
		
	}

}
