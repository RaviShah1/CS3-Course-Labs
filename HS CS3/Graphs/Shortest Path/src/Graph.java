import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Graph
{
	//Map<Node, LinkedList<Node>> adj;
	Node[] nodes;
	LinkedList<Integer>[] adj;
	int V;
	
	public Graph(int v)
	{
		V = v;
		nodes = new Node[V];
		adj = new LinkedList[V];
	}
	
	public void addNode(Node n)
	{
		//adj.put(n, new LinkedList<Node>());
		nodes[n.id] = n;
		adj[n.id] = new LinkedList<Integer>();
	}
	
	public void addEdge(int id1, int id2)
	{
		adj[id1].add(id2);
		adj[id2].add(id1);
	}
	
	public void dijkstra(int start) 
	{
		int s = start;
		Queue<Node> q = new PriorityQueue<Node>();
		
		for(Node v : nodes)
		{
			v.dist = Integer.MAX_VALUE;
			v.prev = null;
			q.offer(v);
		}
		nodes[s].dist = 0;
		
		while(!q.isEmpty())
		{
			Node u = q.poll();
			for(Integer v : adj[u.id])
				relax(u, nodes[v]);
		}
	}
	
	private void relax(Node u, Node v)
	{
		if(u.dist + u.distTo(v) < v.dist)
		{
			v.dist = u.dist + u.distTo(v);
			v.prev = u;
		}
	}
	
	public void printPath(int start, int end)
	{
		Node next = nodes[end];
		Stack<Node> stack = new Stack<Node>();
		
		while(next.id != start)
		{
			stack.push(next);
			next = next.prev;
		}
		stack.push(next);
		
		System.out.print("Path: ");
		while(!stack.isEmpty())
		{
			if(stack.size()>1)
				System.out.print(stack.pop() + " -> ");
			else
				System.out.println(stack.pop());
		}
		System.out.println("Distance: " + nodes[end].dist);
	}
	
	@Override
	public String toString()
	{
		return Arrays.toString(adj);
	}
}
