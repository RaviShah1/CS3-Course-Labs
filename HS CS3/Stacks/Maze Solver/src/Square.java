/**
 * This is the class definition for a Square
 * @author Ravi Shah
 *
 */
public class Square
{
	//constants - types
	public static final int SPACE = 0;
	public static final int WALL = 1;
	public static final int START = 2;
	public static final int EXIT = 3;
	
	//constants - status
	public static final char WORKING = 'O';
	public static final char EXPLORED = '.';
	public static final char EXIT_PATH = 'X';
	public static final char UNKNOWN = '_';
	
	//instance vars / attributes
	private int row;
	private int col;
	private int type;
	private char status;
	private int begType;
	private char begStatus;
	
	/**
	 * Creates an object of the Square class
	 * @param row is the row the square is in
	 * @param col is the column the square is in
	 * @param type is the types of square this square is
	 */
	public Square(int row, int col, int type)
	{
		this.row = row;
		this.col = col;
		this.type = type;
		begType = type;
		begStatus = status;
	}
	
	/**
	 * Gets the row the square
	 * @return the row of the square
	 */
	public int getRow()
	{
		return row;
	}

	/**
	 * Sets the row of the square
	 * @param row is the new row for the square
	 */
	public void setRow(int row)
	{
		this.row = row;
	}

	/**
	 * Gets the column of the square
	 * @return the column of the square
	 */
	public int getCol()
	{
		return col;
	}

	/**
	 * Sets the column of the square
	 * @param col is the column to set the square
	 */
	public void setCol(int col)
	{
		this.col = col;
	}

	/**
	 * Gets the type of the square
	 * @return the type of the square
	 */
	public int getType()
	{
		return type;
	}

	/**
	 * Sets the type of the square
	 * @param type is the type to set the square
	 */
	public void setType(int type)
	{
		this.type = type;
	}

	/**
	 * Gets the status of the square
	 * @return the status of the square
	 */
	public char getStatus()
	{
		return status;
	}

	/**
	 * Sets the status of the Square
	 * @param status is the stauts to set the square
	 */
	public void setStatus(char status)
	{
		this.status = status;
	}
	
	/**
	 * Rests the square to its inital state
	 */
	public void reset()
	{
		type = begType;
		status = begStatus;
	}

	/**
	 * Determines if two Squares are equal
	 * @return true if the objects are equal, else false
	 */
	@Override
	public boolean equals(Object obj)
	{
		Square s2 = (Square)obj;
		return row==s2.row && col==s2.col;
	}

	/**
	 * Gets a string representation of the square
	 * @return str is a String representation of the square
	 */
	@Override 
	public String toString()
	{
		String str = "";
		if(type==START)
			str+="S";
		else if(type==EXIT)
			str+="E";
		else if(status==WORKING)
			str+=WORKING;
		else if(status==EXPLORED)
			str+=EXPLORED;
		else if(type==SPACE)
			str+="_";
		else if(type==WALL)
			str+="#";
		return str;
	}
}
