import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Graph to find the trail
 * @author Ravi Shah
 *
 */
public class Graph
{
	// the map of primes
	Map<Integer, Number> primes;
	
	/**
	 * Constructs the graph
	 */
	public Graph()
	{
		resetGraph();
				
	}
	
	/**
	 * Resets the graph
	 */
	public void resetGraph()
	{
		primes = new HashMap<Integer, Number>();
		generatePrimes();
	}
	
	/**
	 * Generates the prime numbers
	 */
	private void generatePrimes()
	{
		for(int i=1001; i<=9999; i+=2)
		{
			if(isPrime(i))
				primes.put(i, new Number(i));
		}
	}
	
	/**
	 * Determines if a number is prime
	 * @param n is the number
	 * @return true if it is prime, else false
	 */
	private boolean isPrime(int n)
	{
		for(int i=2; i<=Math.sqrt(n); i++)
		{
			if(n%i==0)
				return false;
		}
		return true;
	}
	
	/**
	 * Gets the edges of a node
	 * @param num is the node
	 * @return the edges as a list
	 */
	public List<Number> getEdges(Number num)
	{
		int n = num.n;
		List<Number> vals = new ArrayList<Number>();
		for(int i=1; i<=1000; i*=10)
		{
			for(int j=0; j<=9; j++)
			{
				int gone = n/i % 10;
				int newNum = n-(i*gone) + i*j;
				//System.out.println(newNum);
				if(primes.containsKey(newNum) && !primes.get(newNum).visited)
				{
					//primes.get(newNum).prev = num;
					vals.add(primes.get(newNum));
				}
			}
			//System.out.println();
		}
		
		return vals;
	}
	
	/**
	 * Breath First Searches the graph to find a trail
	 * @param start is the starting number
	 * @param end is the ending number
	 * @return the length of the trail, or -1 if there is no trail
	 */
	public int BFS(int start, int end)
	{
		resetGraph();
		Number goal = new Number(end);
		Queue<Number> q = new LinkedList<Number>();
		q.offer(new Number(start));
		
		while(!q.isEmpty())
		{
			Number cur = q.poll();
			//cur.visited = true;
			
			if(cur.equals(goal))
				return getLen(cur, new Number(start));
			
			List<Number> adj = getEdges(cur);
			for(Number n : adj)
			{
				n.prev = cur;
				n.visited = true;
				q.offer(n);	
			}
		}
		
		return -1;
	}
	
	/**
	 * Gets the length of a trail
	 * @param cur is the current node
	 * @param start is the starting node
	 * @return the distance between the nodes
	 */
	private int getLen(Number cur, Number start)
	{
		int count = 0; 
		while(!cur.equals(start))
		{
			count++;
			//System.out.println(cur);
			cur = cur.prev;
		}
		return count;
	}

}
