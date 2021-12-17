
import java.util.Arrays;

public class Regex {
	public static void main(String[] args) {
		//Regex, also known as a Regular Expression, is a tool used to search and determine the properties of a string
		//Regex allows us to efficiently and concisely search for certain patterns or instances in a string
		//Saves time otherwise spent creating a "for loop" and the associated "if statements" needed to check for patterns in a string
		//Instead, regex condenses it down to one line of code
		
		//.matches()
		//true if satisfies the regex
		//Start with two pointers at the start of the string and regular expression
		//Move each pointer forward when that part of the string matches that part of the regex
		//A .matches() is true if the pointer successfully reached the end of both the string and the regex, false otherwise
		//Any method that works on regex operates under this same approach
		
		//\d is any digit 0-9
		String s = "0";
		//have to use two backslashes, but on written contests there will just be one
		System.out.println(s.matches("\\d"));
		//capitalize to seek anything BUT, so here would be anything but a digit
		System.out.println(s.matches("\\D"));

		
		//\w is any digit, letter, or underscore
		System.out.println();
		s = "A";
	
		System.out.println(s.matches("\\w"));

		s = "1";
		System.out.println(s.matches("\\w"));

		System.out.println(s.matches("\\W"));
		s = "-";
		//true because not a \\w character
		System.out.println(s.matches("\\W"));

		
		//\s checks for white space
		System.out.println();
		s = "a";
	
		System.out.println(s.matches("\\s"));
		System.out.println(s.matches("\\S"));

	
		System.out.println();
		s = " ";
	
		System.out.println(s.matches("\\s"));
		System.out.println(s.matches("\\S"));
	

		//. is any character but a new line
		System.out.println();
		s = "a5";
		System.out.println(s.matches(".."));
		s = "a5\n";
		System.out.println(s.matches("..."));
		s = "a5\t";
		System.out.println(s.matches("..."));
		
		
		//* is 0 or more, + is 1 or more, ? is 0 or 1 (non plural)
		System.out.println();
		s = "1515";
		System.out.println(s.matches("\\d*"));
		System.out.println(s.matches("\\d+"));
		System.out.println(s.matches("\\d?"));
		s = "1";
		System.out.println(s.matches("\\d?"));
		s = "";
		System.out.println(s.matches("\\d*"));
		System.out.println(s.matches("\\d+"));
		System.out.println();
		
		//[a1 - ] any value inside "-" uses any value between the ASCII values specified by the ends of the interval
		s = "1a";
		System.out.println(s.matches("[a1]+"));
		System.out.println(s.matches("[1-z]*"));
		System.out.println(s.matches("[1-Z]*"));
		System.out.println(s.matches("[1-Za]*"));
		//can put as many values inside as you wish, (even a repeat value)
		System.out.println(s.matches("[a1eiousca]*"));
		//regex can work with boolean logic too
		//summed up, this is "1 or a-z except for a and c zero or more times"
		System.out.println(s.matches("[1a-z&&[^ac]]*"));
		System.out.println();
		
		
		//{}, how many occurrences, {1} one time, {1,} 1 or more, {1,3} 1-3
		s = "sk;ldf";
		
		System.out.println(s.matches("[a-z]{6}"));
		System.out.println(s.matches("\\D{6}"));
		System.out.println(s.matches("\\D{3,}"));
		System.out.println(s.matches("\\D{1,5}"));
		System.out.println(s.matches("\\D{1,6}"));
		System.out.println();
		
		//Regex is also important when using String methods like .split() and .replaceAll()
		s = "The big dog is a hairy dog";
		System.out.println(s.replaceAll("dog", "cat"));
		System.out.println(s.replaceAll("\\w+", "cat"));
		System.out.println(s.replaceAll("\\w", "cat"));
		String[] arr = s.split("\\s");
		System.out.println(Arrays.toString(arr));
		arr = s.split("dog");
		System.out.println(Arrays.toString(arr));
		s = "469-123-4567";
		arr = s.split("-");
		System.out.println(Arrays.toString(arr));

		//Say, for instance, you wanted to replace all consonants in a string with a c and all vowels with a v.
		//Then, you wanted to split each word into an array. How would this be done with Regex?
		s = "The big dog is a hairy dog";
		//note why consonants were replaced before vowels
		s = s.replaceAll("[a-zA-Z&&[^aeiouAEIOU]]", "c");
		s = s.replaceAll("[aeiouAEIOU]", "v");
		arr = s.split("\\s");
		System.out.println(Arrays.toString(arr));
		System.out.println();
		
		//Regex tries its hardest to satisfy the pattern
		
		s = "12";
		System.out.println(s.matches("\\d+")); //the \\d+ accounts for both the 1 and the 2
		System.out.println(s.matches("\\d+\\d+")); 
		//in the second example, the first \\d+ could account for both the 1 and 2
		//but because the second \\d+ needs to be satisfied, it only accounts for the 1, allowing for the second \\d+ to account for the 2
	}
}
