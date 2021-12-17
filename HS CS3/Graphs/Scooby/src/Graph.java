import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * The Graph to perform the search
 * @author Ravi Shah
 *
 */
public class Graph
{
	// the adjacency map
	Map<Character, String> adj;
	
	/**
	 * Constructs a graph
	 */
	public Graph()
	{
		adj = new TreeMap<Character, String>();
	}
	
	/**
	 * Inserts two nodes into the graph with a bidirectional edge between them
	 * @param edge a string containing the two nodes
	 */
	public void insert(String edge)
	{
		char n1 = edge.charAt(0);
		char n2 = edge.charAt(1);
		if(!adj.containsKey(n1))
			adj.put(n1, "");
		if(!adj.containsKey(n2))
			adj.put(n2, "");
		adj.put(n1, adj.get(n1)+n2);
		adj.put(n2, adj.get(n2)+n1);
	}
	
	/**
	 * Searches the graph to determine if there is a path between 
	 * two nodes
	 * @param start is the starting node
	 * @param end is the ending node
	 * @return true if there is a path between them, else false
	 */
	public boolean DFS(char start, char end)
	{
		return DFS(start, end, new Stack<Character>(), "");
	}
	
	/**
	 * Helper method to search the graph to determine if there is 
	 * a path between two nodes 
	 * @param start is the starting node
	 * @param end is the ending node
	 * @param stack is the work list stack
	 * @param visited contains all visited nodes
	 * @return true if there is a path between them, else false
	 */
	private boolean DFS(char start, char end, Stack<Character> stack, String visited)
	{
		stack.push(start);
		while(!stack.isEmpty())
		{
			char cur = stack.pop();
			if(visited.indexOf(cur)!=-1)
				continue;
			if(!adj.containsKey(cur))
				continue;
			if(cur==end)
				return true;
			
			visited+=cur;
			
			for(int i=0; i<adj.get(cur).length(); i++)
				stack.push(adj.get(cur).charAt(i));
		}
		return false;
	}
}
