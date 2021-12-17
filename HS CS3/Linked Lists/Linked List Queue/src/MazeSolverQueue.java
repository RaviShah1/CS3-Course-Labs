/**
 * Solves the maze with a queue
 * @author Ravi Shah
 *
 */
public class MazeSolverQueue extends MazeSolver
{
	private MyQueue<Square> queue;
	
	public MazeSolverQueue(Maze maze)
	{
		super(maze);
		queue = new MyQueue<Square>();
		add(maze.getStart());
	}
	
	/**
	 * Makes the stack empty
	 */
	public void makeEmpty()
	{
		queue.clear();
		
	}

	/**
	 * Determines if a stack is empty
	 * @return true if it is empty, else false
	 */
	public boolean isEmpty()
	{
		return queue.isEmpty();
	}

	/**
	 * Adds a square to the stack
	 * @param s is the square to add
	 */
	public void add(Square s)
	{
		queue.offer(s);
	}

	/**
	 * Gets the next square
	 * @return the next square in the stack
	 */
	public Square next()
	{
		return queue.poll();
	}
}
