
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;

public class HashTableRunner
{
  public static void main ( String[] args )
  {
		try{
			//make a new table			
			HashTable table = new HashTable();
			
			//read from the file			
			Scanner file = new Scanner(new File("words.dat"));
			
			//load stuff into the table			
			int T = file.nextInt();
			file.nextLine();
			while(T-->0)
			{
				table.add(new Word(file.nextLine().trim()));
				
			}
			
			//print out the table
			System.out.println(table);
		}
		catch(Exception e)
		{
			System.out.println("Houston, we have a problem!");
		}
  }
}