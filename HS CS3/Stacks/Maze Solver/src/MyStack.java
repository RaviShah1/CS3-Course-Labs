import java.util.EmptyStackException;
/**
 * This is the class definition for a stack
 * @author Ravi Shah
 *
 */
public class MyStack implements StackADT
{

	private Square[] stack;
	private int size;
	
	/**
	 * Constructs a MyStack object with no size
	 */
	public MyStack()
	{
		size = -1;
		stack = new Square[1];
	}
	
	/**
	 * Constructs a MyStack object with a starting size
	 * @param initCap is the starting size
	 */
	public MyStack(int initCap)
	{
		size = -1;
		stack = new Square[initCap];
	}
	
	/**
	 * Determines if the stack is empty
	 * @return true is the stack is empty, else false
	 */
	public boolean isEmpty()
	{
		if(size==-1)
			return true;
		return false;
	}
	
	/**
	 * Gets the top element in the stack
	 */
	public Square peek()  
	{
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		return stack[size];
	}
	
	/**
	 * Removes the top element in the stack
	 * @return the previous top element in the stack
	 */
	public Square pop()
	{
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		Square del = stack[size];
		size--;
		return del;
	}
	
	/**
	 * Adds a new element to the stack
	 * @param item is the element to add to the stack
	 */
	public void push(Square item)
	{
		if(size+1 >= stack.length)
			doubleCapacity();
		stack[++size] = item;
	}
	
	/**
	 * Doubles the size of the array backing the stack
	 */
	public void doubleCapacity()
	{
		Square[] newStack = new Square[stack.length*2];
		for(int i=0; i<stack.length; i++)
			newStack[i] = stack[i];
		stack = newStack;
	}

	/**
	 * Gets the size of the stack
	 * @return the size of the stack
	 */
	public int size()
	{
		return size+1;
	}

	/**
	 * Clears the stack
	 */
	public void clear()
	{
		size=-1;
		stack = new Square[1];
	}
	
	/**
	 * Returns a string representation of the stack
	 * @return a string representation of the stack
	 */
	@Override
	public String toString()
	{
		String str = "[";
		for(int i=0; i<size; i++)
			str += (stack[i]+", ");
		if(size!=-1)
			str+=stack[size];
		str+="]";
		str+="<----- TOP";
		return str;
	}


}
