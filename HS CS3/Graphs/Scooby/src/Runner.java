import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner
{
	/**
	 * Runs the program
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner scan = new Scanner(new File("scooby.dat"));
		int T = scan.nextInt();
		scan.nextLine();
		
		while(T-->0)
		{
			Graph g = new Graph();
			String[] edges = scan.nextLine().split(" ");
			for(String e : edges)
				g.insert(e);

			String goal = scan.nextLine();
			char start = goal.charAt(0);
			char end = goal.charAt(1);
			if(g.DFS(start, end))
				System.out.println("yes");
			else
				System.out.println("no");
		}

	}

}
