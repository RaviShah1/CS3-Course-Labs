import java.util.*;

public class ListIterator102
{

	public static void main(String[] args)
	{
		// an easy way to transfer elements from string to array
		// .split() of the String class will use <space> as the delimiter to separate
		// elements
		// "," and "-" are other common delimiters
		String input = "15 25 23 18 21 16";
		List<Integer> list = convertToIntegerList(input);
		printForwardsThenBackwards(list);

	}

	public static void printForwardsThenBackwards(List<Integer> input)
	{
		//even stranger for loop
		//you don't need any of the 3 major parts of a for loop
		ListIterator<Integer> here = input.listIterator();
		
		for(;here.hasNext();)
		{
			System.out.print(here.next() + " ");
		}
		System.out.println();
		for(;here.hasPrevious();)
		{
			System.out.print(here.previous() + " ");
		}
		
	}
	
	public static List<Integer> convertToIntegerList(String input)
	{
		String[] stringArr = input.split(" ");
		List<Integer> numList = new ArrayList<Integer>();
		
		for(int i=0; i<stringArr.length; i++)
		{
			numList.add(Integer.parseInt(stringArr[i]));
		}
		
		return numList;
	}

}
