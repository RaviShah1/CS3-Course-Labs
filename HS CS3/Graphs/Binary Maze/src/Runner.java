import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner
{
	/**
	 * Runs the program
	 * @param scan is the canner with the data
	 */
	public static void run(Scanner scan)
	{
		int R = scan.nextInt();
		int C = scan.nextInt();
		Graph g = new Graph(R, C);
		
		scan.nextLine();
		for(int r=0; r<R; r++)
			g.insertRow(scan.nextLine(), r);
		
		System.out.println(g.BFS(scan.nextLine(), scan.nextLine()));
		//System.out.println(g);
	}
	
	/**
	 * Main method to run the program
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String args[]) throws FileNotFoundException
	{
		System.out.print("maze 1: ");
		run(new Scanner(new File("maze1.txt")));
		System.out.print("maze 2: ");
		run(new Scanner(new File("maze2.txt")));
		System.out.print("maze 3: ");
		run(new Scanner(new File("maze3.txt")));
	}
}
