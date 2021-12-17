
public class Runner
{
	/**
	 * Runs the program
	 * @param args
	 */
	public static void main(String args[])
	{
		Graph g = new Graph();
		g.getEdges(new Number(1793));
		
		System.out.println("Input: 1033 8179\nOutput: " + g.BFS(1033,  8179));
		System.out.println(g.BFS(1373,  8017));
		System.out.println(g.BFS(1033,  1033));
	}
}
