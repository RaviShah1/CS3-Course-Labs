import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner
{
	/**
	 * runs the program
	 * @param scan is the scanner with data
	 */
	public static void run(Scanner scan)
	{
		int T = scan.nextInt();
		scan.nextLine();
		
		while(T-->0)
		{
			String[] vals = scan.nextLine().split(" ");
			int n = Integer.parseInt(vals[0]);
			int m = Integer.parseInt(vals[1]);
			int l = Integer.parseInt(vals[2]);
			
			//Graph g = new Graph();
			Graph g = new Graph(n);
			for(int i=0; i<m; i++)
				g.insert(scan.nextLine());
			
			int count = 0;
			for(int i=0; i<l; i++)
				count += g.DFS(scan.nextLine());
			System.out.println(count);
		}
	}
	
	/**
	 * Main method to run the program
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String args[]) throws FileNotFoundException
	{
		run(new Scanner(new File("play.dat")));
		run(new Scanner(new File("play2.dat")));
		
	}
}
