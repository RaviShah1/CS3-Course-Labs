import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MazeTester
{

	/**
	 * Tests stuff
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		//Square s = new Square(1,1,1);
		//System.out.println(s);

		Maze m = new Maze();
		m.loadMaze("maze-2");
		System.out.println(m);
		
		System.out.println(m.getNeighbors(m.getExit()));
		
		System.out.println();
		MyStack s = new MyStack();
		s.push(new Square(0,0,0));
		s.push(new Square(0,1,1));
		s.push(new Square(1,0,2));
		System.out.println(s);
		System.out.println(s.peek());
		System.out.println(s.size());
		s.pop();
		System.out.println(s.peek());
		s.pop();
		System.out.println(s.isEmpty());
		s.pop();
		System.out.println(s.isEmpty());
		s.push(new Square(0,0,0));
		s.push(new Square(0,1,1));
		s.push(new Square(1,0,2));
		s.clear();
		System.out.println(s);
	}

}
