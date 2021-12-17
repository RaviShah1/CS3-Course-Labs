import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * The Graph to perform the search
 * @author Ravi Shah
 *
 */
public class Graph
{
	int R; // the number of rows in the graph
	int C; // the number of columns in the graph
	Location[][] g; // the graph as a matrix
	
	/**
	 * Constructs the graph
	 * @param r is the number of rows
	 * @param c is teh number of columns
	 */
	public Graph(int r, int c)
	{
		R = r;
		C = c;
		g = new Location[r][c];
	}
	
	/**
	 * Adds a row to the graph
	 * @param row is the row
	 * @param r is the row index
	 */
	public void insertRow(String row, int r)
	{
		String vals[] = row.split(" ");
		for(int c=0; c<vals.length; c++)
			g[r][c] = new Location(r, c, Integer.parseInt(vals[c]));
	}
	
	/**
	 * Searches the graph for the shortest path between two nodes
	 * @param loc1 is the start node
	 * @param loc2 is the end node
	 * @return the shortest distance between the two nodes
	 */
	public int BFS(String loc1, String loc2)
	{
		Location start = g[Integer.parseInt(loc1.split(" ")[0])]
						  [Integer.parseInt(loc1.split(" ")[1])];
		Location end = g[Integer.parseInt(loc2.split(" ")[0])]
				  [Integer.parseInt(loc2.split(" ")[1])];
		
		
		return BFS(start, end, new LinkedList<Location>());
	}
	
	/**
	 * Helper method to search the graph for the shortest path 
	 * between two nodes
	 * @param start is the starting node
	 * @param end is the ending node
	 * @param q is the work list queue
	 * @return the shortest distance between the two nodes
	 */
	private int BFS(Location start, Location end, Queue<Location> q)
	{
		q.offer(start);
		
		while(!q.isEmpty())
		{
			Location cur = q.poll();
			
			cur.visited = true;
			
			if(cur.equals(end))
				return getLen(cur, start);
			
			List<Location> adj = getAdj(cur);
			for(Location n : adj)
			{
				if(!n.visited)
					n.prev = cur;
				if(n.val==1 && !n.visited)
					q.offer(n);
			}
			
		}
		
		return -1;
		
	}
	
	/**
	 * Gets all the nodes adjacent to a given node 
	 * @param loc is the center node
	 * @return the adjacent nodes
	 */
	private List<Location> getAdj(Location loc)
	{
		List<Location> adj = new ArrayList<Location>();
		if(loc.r-1 >= 0)
			adj.add(g[loc.r-1][loc.c]);
		if(loc.r+1 < R)
			adj.add(g[loc.r+1][loc.c]);
		if(loc.c-1 >= 0)
			adj.add(g[loc.r][loc.c-1]);
		if(loc.c+1 < C)
			adj.add(g[loc.r][loc.c+1]);
		return adj;
	}
	
	/**
	 * Gets the number of edges between two nodes
	 * @param loc is the current node
	 * @param start is the starting node
	 * @return the distance
	 */
	private int getLen(Location loc, Location start)
	{
		int count = 0;
		while(loc != start)
		{
			loc = loc.prev;
			count++;
		}
		return count;
	}
	
	/**
	 * Gets a string representation of the graph
	 * @return a string representation of the graph
	 */
	@Override
	public String toString()
	{
		String str = "";
		for(int r=0; r<R; r++)
		{
			for(int c=0; c<C; c++)
			{
				str+= g[r][c]+" ";
			}
			str+="\n";
		}
		return str;
	}
}
