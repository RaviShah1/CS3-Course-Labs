import java.util.Stack;

public class PostFix
{
	private Stack<Double> stack;
	private String expression;

	/**
	 * Constructs an object of the PostFix class with default values
	 */
	public PostFix()
	{
		stack = new Stack<Double>();
		expression = "";
	}

	/**
	 * Constructs an object of the PostFix class with an expression
	 * @param exp is the expression to set
	 */
	public PostFix(String exp)
	{
		stack = new Stack<Double>();
		expression = exp;
	}

	/**
	 * Sets the expression
	 * @param exp is the expression to set
	 */
	public void setExpression(String exp)
	{
		stack = new Stack<Double>();
		expression = exp;
	}

	public double calc(double one, double two, char op)
	{
		if(op == '+')
			return one+two;
		else if(op == '–')
			return one-two;
		else if(op == '*')
			return one*two;
		else
			return one/two;
	}

	/**
	 * Solves the expression and prints the expression and output
	 */
	public void solve()
	{
		double res = 0.0;
		String[] vals = expression.split(" ");
		
		for(int i=0; i<vals.length; i++)
		{
			if(vals[i].charAt(0) == '+' || vals[i].charAt(0) == '–' || vals[i].charAt(0) == '*' || vals[i].charAt(0) == '/')
			{
				double two = stack.pop();
				double one = stack.pop();
				stack.push(calc(one, two, vals[i].charAt(0)));
			}
			else
				stack.push(Double.parseDouble(vals[i]));
		}
		
		System.out.println(toString() + " = " + stack.peek());
	}

	/**
	 * Returns a string representation of the expression in this postfix object
	 * @return expression is the expression of this object
	 */
	public String toString()
	{
		return expression;
	}
}