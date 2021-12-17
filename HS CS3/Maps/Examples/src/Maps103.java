import java.util.*;

public class Maps103
{

	public static void main(String[] args)
	{
		String s = "dog1cat2pig3dog1cat2pig7dog3dog6cat8dog4pig";
		
		Map<String, Integer> map = new TreeMap<String, Integer>();
		
		for(String item : s.split("\\d+"))
		{
			if(map.get(item)==null)
			{
				map.put(item, 1);
			}
			else
			{
				map.put(item, map.get(item)+1);
			}
		}
		
		//keySet
		for(String key : map.keySet())
		{
			System.out.print(key + "\t"); 
		}
		System.out.println();
		
		//values
		for(Integer i : map.values())
		{
			System.out.print(" " + i + "\t");
		}
		
		System.out.println("\n");
		
		Iterator<String> it = map.keySet().iterator();
		
		while(it.hasNext())
		{
			String key = it.next();
			System.out.println(key + " - " + map.get(key));
		}
		
	}

}
