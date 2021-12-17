import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * This class Represents a Maze
 * @author Ravi Shah
 *
 */
public class Maze
{
	
	private Square[][] maze;
	private Square[][] original;
	private Square start;
	private Square exit;
	private String file;
	
	/**
	 * Constructs a maze object
	 */
	public Maze()
	{
		
	}
	
	/**
	 * Loads a file and stores its maze in a maze variable
	 * @param filename is the name of the file
	 * @return true if the maze was successfully loaded else false
	 * @throws IOException
	 */
	public boolean loadMaze(String filename) throws IOException
	{
		try
		{
			Scanner file = new Scanner(new File(filename));
			int r = file.nextInt();
			int c = file.nextInt();
			maze = new Square[r][c];
			original = new Square[r][c];
			
			for(int i=0; i<r; i++)
			{
				for(int j=0; j<c; j++)
				{
					int type = file.nextInt();
					maze[i][j] = new Square(i, j, type);
					original[i][j] = new Square(i, j, type);
					
					if(type==2)
						start = maze[i][j];
					if(type==3)
						exit = maze[i][j];
				}	
			}
			
			return true;
		}	
		catch(Exception e)
		{
			System.out.println("File Not Found");
			return false;
		}
	}

	/**
	 * Gets a list of squares neighboring a given square
	 * @param s is the central square
	 * @return the list of squares around s
	 */
	public List<Square> getNeighbors(Square s)
	{
		List<Square> list = new ArrayList<Square>();
		if(inBounds(s.getRow()-1, s.getCol()))
			list.add(maze[s.getRow()-1][s.getCol()]);
		if(inBounds(s.getRow(), s.getCol()+1))
			list.add(maze[s.getRow()][s.getCol()+1]);
		if(inBounds(s.getRow()+1, s.getCol()))
			list.add(maze[s.getRow()+1][s.getCol()]);
		if(inBounds(s.getRow(), s.getCol()-1))
			list.add(maze[s.getRow()][s.getCol()-1]);
		return list;
	}
	
	/**
	 * Determines if a row, col pair is inside the maze
	 * @param r is the row to check
	 * @param c is the col to check
	 * @return true if it is in bounds, else false
	 */
	private boolean inBounds(int r, int c)
	{
		return (r>=0 && c>=0 && r<maze.length && c<maze[0].length);
	}
	
	/**
	 * Gets the start square
	 * @return teh start square
	 */
	public Square getStart()
	{
		return start;
	}
	
	/**
	 * Gets the exit  square
	 * @return the extio square
	 */
	public Square getExit()
	{
		return exit;
	}
	
	/**
	 * Resets the maze
	 */
	public void reset() 
	{
		//maze = original;
		for(int i=0; i<maze.length; i++)
		{
			for(int j=0; j<maze[i].length; j++)
				maze[i][j].reset();
		}
	}
	
	/**
	 * Creates and returns a string representation of the maze
	 * @return a string representation of the maze
	 */
	@Override
	public String toString()
	{
		String str = "";
		
		for(Square[] row : maze)
		{
			for(Square s : row)
			{
				str+=s+" ";
			}
			str+="\n";
		}
		
		return str;
	}
	
}
