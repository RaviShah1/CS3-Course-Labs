import java.util.*;


public class Maps102
{

	public static void main(String[] args)
	{
		Map<Character, Integer> map = new TreeMap<Character, Integer>();
		
		String s = "hawk pride never dies";
		
		for(int i=0; i<s.length(); i++)
		{
			char c = s.charAt(i);
			if(map.containsKey(c))
				map.put(c, map.get(c)+1);
			else
				map.put(c, 1);
		}
		
		System.out.println(map);
		System.out.println(map.get('e'));

		
		System.out.println("\n*************************************************\n");
		
		map = new HashMap<Character, Integer>();
		
		for(char c : s.toCharArray())
		{
			if(map.get(c)==null)
				map.put(c, 0);
			map.put(c, map.get(c)+1);
		}
		
		System.out.println(map);
		System.out.println(map.get('e'));
	}

}
