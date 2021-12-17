import java.util.List;
/**
 * This class is the solver for a maze
 * @author Ravi Shah
 *
 */
public abstract class MazeSolver
{
	private Maze maze;
	private boolean solved;
	
	/**
	 * Constructs an object of the MazeSolver class
	 * @param maze is the maze to solve
	 */
	public MazeSolver(Maze maze) 
	{
		this.maze = maze;
	}

	/**
	 * Makes the stack empty
	 */
	public abstract void makeEmpty();
	
	/**
	 * Determines if a stack is empty
	 * @return true if it is empty, else false
	 */
	public abstract boolean isEmpty();
	
	/**
	 * Adds a square to the stack
	 * @param s is the square to add
	 */
	public abstract void add(Square s);
	
	/**
	 * Gets the next square
	 * @return the next square in the stack
	 */
	public abstract Square next();
	
	/**
	 * Determines if the maze is solved
	 * @return
	 */
	public boolean isSolved()
	{
		return solved;
	}
	
	/**
	 * Makes the next step in solving the maze
	 */
	public void step()
	{
		if(!isEmpty())
		{
			Square s = next();
			s.setStatus(Square.WORKING);
			if(s.getType()==Square.EXIT)
				solved = true;
			
			List<Square> adj = maze.getNeighbors(s);
			//System.out.println(adj);
			for(Square n : adj)
			{
				if(n.getType()!=Square.WALL && n.getStatus()!=Square.EXPLORED)
					{ add(n); n.setStatus(Square.WORKING);}
			}
			
			s.setStatus(Square.EXPLORED);
			
		}
	}
	
	/**
	 * Gets the status of the maze
	 * @return whether or not the maze is and can be solved
	 */
	public String getPath()
	{
		if(solved)
			return "Solved!";
		else if(isEmpty())
			return "Cannot Be Solved";
		return "Maze Not Solved";
	}
	
	/**
	 * Solves the maze
	 */
	public void solve()
	{
		while(!isSolved())
		{
			step();
		}
	}
}
	
