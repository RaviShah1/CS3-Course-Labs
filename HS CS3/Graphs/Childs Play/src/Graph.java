import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * The Graph to perform the search
 * @author Ravi Shah
 *
 */
public class Graph
{
	// the adj set
	List<LinkedList<Integer>> adj;
	
	/**
	 * Constructs the graph
	 */
	public Graph(int n)
	{
		adj = new ArrayList<LinkedList<Integer>>();
		for(int i=0; i<n; i++)
			adj.add(new LinkedList<Integer>());
	}
	
	/**
	 * Inserts two nodes into the graph with an edge between them
	 * @param edge is a string containing the two nodes
	 */
	public void insert(String edge)
	{
		String[] nodes = edge.split(" ");
		int n1 = Integer.parseInt(nodes[0]);
		int n2 = Integer.parseInt(nodes[1]);
		/*
		if(adj.get(n1)==null)
			adj.set(n1, new LinkedList<Integer>());
		if(adj.get(n2)==null)
			adj.set(n2, new LinkedList<Integer>()); */
		adj.get(n1-1).add(n2-1);
	}
	
	/**
	 * Searches the graph and count the number of fallen dominos 
	 * @param n the domino that gets knocked over
	 * @return the number of fallen dominos
	 */
	public int DFS(String n)
	{
		int num = Integer.parseInt(n);
		return DFS(num, new Stack<Integer>(), new HashSet<Integer>());
	}
	
	/**
	 * Helper method to search the graph and count the number of 
	 * fallen dominos 
	 * @param start is the staring node
	 * @param stack is the work list stack
	 * @param visited contains all the visited nodes
	 * @return the number of fallen dominos 
	 */
	private int DFS(int start, Stack<Integer> stack, Set<Integer> visited)
	{
		int count = 0;
		stack.push(start);
		while(!stack.isEmpty())
		{
			int cur = stack.pop()-1;
			count++;
			if(visited.contains(cur))
				continue;
			//if(!adj.containsKey(cur))
			//	continue;
			
			visited.add(cur);
			
			for(int i : adj.get(cur))
				stack.push(i);
		}
		return count;
	}
}
