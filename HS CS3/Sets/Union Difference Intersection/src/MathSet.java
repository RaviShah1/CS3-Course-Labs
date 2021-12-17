//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Ravi Shah

import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import static java.lang.System.*;

public class MathSet
{
	private Set<Integer> one;
	private Set<Integer> two;

	/**
	 * Constructs a default object of the MathSet class (empty sets)
	 */
	public MathSet()
	{
		one = new TreeSet<Integer>();
		two = new TreeSet<Integer>();
	}

	/**
	 * Constructs an object of the MathSet class
	 * Fills sets one and two with input params
	 * @param is o string of words for set one
	 * @param is t string of words for set two
	 */
	public MathSet(String o, String t)
	{
		String[] oneWords = o.split(" ");
		String[] twoWords = t.split(" ");
		one = new TreeSet<Integer>();
		two = new TreeSet<Integer>();
		
		for(String word : oneWords)
			one.add(Integer.parseInt(word));
		for(String word : twoWords)
			two.add(Integer.parseInt(word));
	}

	/**
	 * Returns the union of set one and two
	 * @return union is a set that is the union of sets one and two
	 */
	public Set<Integer> union()
	{
		Set<Integer> union = new TreeSet<Integer>();
		union.addAll(one);
		union.addAll(two);
		return union;
	}

	/**
	 * Returns the intersection of set one and two
	 * @return intersection is a set that is the intersection of sets one and two
	 */
	public Set<Integer> intersection()
	{
		Set<Integer> intersection = new TreeSet<Integer>();
		intersection.addAll(one);
		intersection.retainAll(two);
		return intersection;
	}

	/**
	 * Returns the difference of sets one - two
	 * @return diff is a set that is the difference of sets one - two
	 */
	public Set<Integer> differenceAMinusB()
	{
		Set<Integer> diff = new TreeSet<Integer>();
		diff.addAll(one);
		diff.removeAll(two);
		return diff;
	}

	/**
	 * Returns the difference of sets two - one
	 * @return diff is a set that is the difference of sets two - one
	 */
	public Set<Integer> differenceBMinusA()
	{
		Set<Integer> diff = new TreeSet<Integer>();
		diff.addAll(two);
		diff.removeAll(one);
		return diff;
	}
	
	/**
	 * Returns the symmetric difference of sets one and two
	 * @return diff is a set that is the symmetric difference of sets one and two
	 */
	public Set<Integer> symmetricDifference()
	{		
		Set<Integer> diff = new TreeSet<Integer>();
		diff.addAll(differenceAMinusB());
		diff.addAll(differenceBMinusA());
		return diff;
	}	
	
	/**
	 * Returns a string representation of sets one and two
	 * @return a string representation of sets one and two
	 */
	public String toString()
	{
		return "Set one " + one + "\n" +	"Set two " + two +  "\n";
	}
}