import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner
{
	public static void run(Scanner scan)
	{
		int V = scan.nextInt();
		int E = scan.nextInt();
		Graph g = new Graph(V);
		
		
		for(int v=0; v<V; v++) 
		{
			g.addNode(new Node(scan.nextInt(), scan.nextInt(), scan.nextInt()));
		}
		
		for(int e=0; e<E; e++)
		{
			g.addEdge(scan.nextInt(), scan.nextInt());
		}
		
		int start = scan.nextInt();
		int end = scan.nextInt();
				
		g.dijkstra(start);
		
		g.printPath(start, end);
		
	}
	
	public static void main(String args[]) throws FileNotFoundException
	{
		System.out.println("Input 6: ");
		run(new Scanner(new File("input6.txt")));

	}
}
