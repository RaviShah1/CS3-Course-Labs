import java.util.ArrayList;

public class LambdaTesting
{
	public static void main(String args[])
	{
		ArrayList<Integer> numbers = new ArrayList<Integer>();
	    numbers.add(5);
	    numbers.add(9);
	    numbers.add(8);
	    numbers.add(1);
	    numbers.forEach( (n) -> { System.out.println(n); } );
	    System.out.println();
	    
	    Expression add = (a,b) -> a+b;
	    System.out.println(add.run(2,3));
	}
	
	interface Expression
	{
		public abstract int run(int a, int b);
	}
}
