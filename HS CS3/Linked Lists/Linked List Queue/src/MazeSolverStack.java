/**
 * This class is the solver for a maze using the stack data structure
 * @author Ravi Shah
 *
 */
public class MazeSolverStack extends MazeSolver
{

	private MyStack stack;
	
	public MazeSolverStack(Maze maze)
	{
		super(maze);
		stack = new MyStack();
		add(maze.getStart());
	}

	/**
	 * Makes the stack empty
	 */
	@Override
	public void makeEmpty()
	{
		stack.clear();
		
	}

	/**
	 * Determines if a stack is empty
	 * @return true if it is empty, else false
	 */
	@Override
	public boolean isEmpty()
	{
		return stack.isEmpty();
	}

	/**
	 * Adds a square to the stack
	 * @param s is the square to add
	 */
	@Override
	public void add(Square s)
	{
		stack.push(s);
	}

	/**
	 * Gets the next square
	 * @return the next square in the stack
	 */
	@Override
	public Square next()
	{
		return stack.pop();
	}

}
