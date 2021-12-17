import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class WorstFitDecreasing
{
	/**
	 * Reads the data into a sorted list
	 * @param file is the file
	 * @return is the list
	 */
	public static List<Integer> readData(Scanner file)
	{
		List<Integer> values = new ArrayList<Integer>();
		while(file.hasNextInt())
			values.add(file.nextInt());
		Collections.sort(values, Collections.reverseOrder());
		return values;
	}
	
	/**
	 * Applies the heuristic
	 * @param pq is the priority queue
	 * @param fileName is the file name
	 * @throws FileNotFoundException
	 */
	public static void pack(Queue<Disk> pq, String fileName) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File(fileName));
		List<Integer> values = readData(file);
		
		int count = 0;
		for(int n : values)
		{			
			if(pq.isEmpty())
			{
				Disk d = new Disk(count++);
				d.add(n);
				pq.offer(d);
			}
			else if(pq.peek().getRemaining()-n <= 0)
			{
				Disk d = new Disk(count++);
				d.add(n);
				pq.offer(d);
			}
			else
			{
				Disk d = pq.poll();
				d.add(n);
				pq.offer(d);
			}
		}
	}
	
	/**
	 * Gets the total size (GB) used
	 * @param pq
	 * @return the size
	 */
	public static double getTotalSize(Queue<Disk> pq)
	{
		int total = 0;
		for(Disk d : pq)
			total += (d.SPACE - d.getRemaining());
		
		return total / 1000000.0;
	}
	
	/**
	 * Prints the output of the heuristic
	 * @param pq is the priority queue
	 */
	public static void output(Queue<Disk> pq)
	{
		System.out.println("Total Size = " + getTotalSize(pq) + " GB");
		System.out.println("Disks req'd = " + pq.size() + "\n");
		
		System.out.println("# Avail");
		while(!pq.isEmpty())
		{
			Disk d = pq.poll();
			System.out.printf("%d%7d: " + d.toString() + "%n", d.getId(), d.getRemaining());
		}
	}
	
	/**
	 * runs the program
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String args[]) throws FileNotFoundException
	{
		Queue<Disk> pq = new PriorityQueue<Disk>();
		String fileName = "input20.txt";
		pack(pq, fileName);
		
		output(pq);
			
	}
}
