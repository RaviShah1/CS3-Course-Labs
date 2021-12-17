import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesterLinearP
{

	public static void main(String[] args) throws FileNotFoundException
	{
		//1
		Scanner file = new Scanner(new File("Large Data Set.txt"));
		List<Integer> ids = new ArrayList<Integer>();
		List<Employee> vals = new ArrayList<Employee>();
		
		while(file.hasNext())
		{
			String line[] = file.nextLine().split(" ");
			int key = Integer.parseInt(line[0]);
			Employee val = new Employee(line[1]);
			ids.add(key);
			vals.add(val);
		}
		
		file = new Scanner(new File("Successful Search Records.txt"));
		List<Integer> searchIds = new ArrayList<Integer>();
		List<Employee> searchNames = new ArrayList<Employee>();
		while(file.hasNext())
		{
			String line[] = file.nextLine().split(" ");
			int key = Integer.parseInt(line[0]);
			Employee val = new Employee(line[1]);
			searchIds.add(key);
			searchNames.add(val);
		}
		
		
		//2
		EmployeeDatabaseLinear[] dbs = {new EmployeeDatabaseLinear(.1), 
										new EmployeeDatabaseLinear(.5),
										new EmployeeDatabaseLinear(.99)};	

		long[] buildTimes = new long[3];
		long[] searchTimes = new long[3];
		for(int d=0; d<3; d++)
		{
			//3
			long buildTableTime; 
			long start = System.nanoTime();
			
			//4
			for(int i=0; i<ids.size(); i++)
			{
				dbs[d].put(ids.get(i), vals.get(i));
			}
			
			//5
			long end = System.nanoTime();
			buildTableTime = end - start;
			buildTimes[d] = buildTableTime;
			
			//6
			long successfulSearchTime;
			start = System.nanoTime();
			
			//7 
			for(int i=0; i<searchIds.size(); i++)
			{
				if(dbs[d].get(searchIds.get(i)) == null)
					System.out.println("ERROR");
			}
			
			// 8
			end = System.nanoTime();
			successfulSearchTime = end - start;
			searchTimes[d] = successfulSearchTime;
		}
		
		//9
		System.out.println("All times are in nanoseconds\n");
		System.out.println("Results of 0.1 Load Factor");
		System.out.println("==========================");
		System.out.println("Hash Function: key % table size");
		System.out.println("Records Added: 50000");
		System.out.println("Final Table Size: " + dbs[0].getTableSize());
		System.out.println("Average Insertion Time: " + buildTimes[0]/50000.0);
		System.out.println("Average Search Time: " + searchTimes[0]/1000.0);
		System.out.println("Average Probes per Search: " + dbs[0].probes / 1000.0);
		System.out.println();
		System.out.println();
		System.out.println("Results of 0.5 Load Factor");
		System.out.println("==========================");
		System.out.println("Hash Function: key % table size");
		System.out.println("Records Added: 50000");
		System.out.println("Final Table Size: " + dbs[1].getTableSize());
		System.out.println("Average Insertion Time: " + buildTimes[1]/50000.0);
		System.out.println("Average Search Time: " + searchTimes[1]/1000.0);
		System.out.println("Average Probes per Search: " + dbs[1].probes / 1000.0);
		System.out.println();
		System.out.println();
		System.out.println("Results of 0.99 Load Factor");
		System.out.println("==========================");
		System.out.println("Hash Function: key % table size");
		System.out.println("Records Added: 50000");
		System.out.println("Final Table Size: " + dbs[2].getTableSize());
		System.out.println("Average Insertion Time: " + buildTimes[2]/50000.0);
		System.out.println("Average Search Time: " + searchTimes[2]/1000.0);
		System.out.println("Average Probes per Search: " + dbs[2].probes / 1000.0);
		
	}

}
