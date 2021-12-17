import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class WordChain
{
	private String start;
	private String end;
	private Queue<Stack<String>> q;
	private Set<String> used;
	private static Set<String> dict;
	private Stack<String> path;
	
	/**
	 * Constructs and object of the WordChain class
	 * @param start is the start word
	 * @param end is the end word
	 * @throws IOException 
	 */
	public WordChain(String start, String end) throws IOException
	{
		setChain(start, end);
	}


	/**
	 * Sets the attributes of the WordChain
	 * @param start is the start word
	 * @param end is the end word
	 * @throws IOException
	 */
	public void setChain(String start, String end) throws IOException
	{
		this.start = start.toUpperCase();
		this.end = end.toUpperCase();
		
		q = new LinkedList<Stack<String>>();
		used = new HashSet<String>();
		used.add(start);
		
		if(dict==null)
			dict = ReadData.readDictionary();
		path = new Stack<String>();
	}
	
	/**
	 * Gets the start word
	 * @return the start word
	 */
	public String getStart() 
	{
		return start;
	}
	
	/**
	 * Gets the end word
	 * @return the end word
	 */
	public String getEnd()
	{
		return end;
	}
	
	/**
	 * Gets the used words
	 * @return the used words
	 */
	public Set<String> getUsed()
	{
		return used;
	}
		
	/**
	 * Sets up the queue
	 */
	public void setUpQueue()
	{
		for(int i=0; i<start.length(); i++)
		{
			for(char c='A'; c<='Z'; c++)
			{
				String newWord = start.substring(0,i) + c + start.substring(i+1);
				if(dict.contains(newWord) && !used.contains(newWord))
				{
					Stack<String> s = new Stack<>();
					s.push(start);
					s.push(newWord);
					q.offer(s);
					used.add(newWord);
					if(newWord.equals(end))
						path = s;
				}
			}
		}
	}
	
	/**
	 * Determines if there is a path
	 * @return true if there still may be a path, else false
	 */
	public boolean isPossible()
	{
		if(start.equals(end))
			return false;
		if(start.length()!=end.length())
			return false;
		return q.size()>0;
	}
	
	/**
	 * Finds the shortest path if there is one
	 */
	public void getPath()
	{
		while(isPossible() && path.size()==0)
		{
			Stack<String> cur = q.poll();
			String str = cur.peek();
			if(str.equals(end))
			{
				path = cur;
				break;
			}
			
			for(int i=0; i<str.length(); i++)
			{
				for(char c='A'; c<='Z'; c++)
				{
					String newWord = str.substring(0,i) + c + str.substring(i+1);
					if(dict.contains(newWord) && !used.contains(newWord))
					{
						Stack<String> newStack = (Stack<String>)cur.clone(); 
						newStack.push(newWord);
						q.offer(newStack);
						used.add(newWord);
					}
				}
			}
		}
	}
	
	/**
	 * Gets a String representation of the shortest path
	 * @return a String representation of the shortest path
	 */
	public String toString()
	{
		setUpQueue();
		getPath();
		//return q.toString();
		if(start.equals(end))
			return "Ladder Found >>> [" + start.toLowerCase() + "]";
		else if(!isPossible())
			return "No ladder between " + start.toLowerCase() + " and " + end.toLowerCase();
		
		for(int i=0; i<path.size(); i++)
			path.set(i, path.get(i).toLowerCase());
		return "Ladder Found >>> " + path.toString();
	}
	
	
	
	
	
	
}
