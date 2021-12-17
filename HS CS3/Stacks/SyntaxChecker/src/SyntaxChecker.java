import java.util.Stack;

public class SyntaxChecker
{
	private String exp;
	private Stack<Character> symbols;

	/**
	 * Constructs a syntax checker object with default values
	 */
	public SyntaxChecker()
	{
		exp = "";
		symbols = new Stack<Character>();
	}

	/**
	 * Constructs a syntax checker object given an expression
	 * @param s is the expression
	 */
	public SyntaxChecker(String s)
	{
		exp = s;
		symbols = new Stack<Character>();
	}
	
	/**
	 * Sets the expression and resets the stack
	 * @param s is the expression
	 */
	public void setExpression(String s)
	{
		exp = s;
		symbols = new Stack<Character>();
	}

	/**
	 * 
	 * @param let is the close symbol
	 * @param comp is the open symbol
	 * @return true is the symbols are a pair, else false
	 */
	public static boolean match(char let, char comp)
	{
		if(comp=='(' && let==')')
			return true;
		if(comp=='[' && let==']')
			return true;
		if(comp=='{' && let=='}')
			return true;
		if(comp=='<' && let=='>')
			return true;
		return false;
	}
	
	/**
	 * Checks to see if an expression is balanced
	 * @return true if the expression is balanced, else false
	 */
	public boolean checkExpression()
	{	
		for(int i=0; i<exp.length(); i++)
		{
			char let = exp.charAt(i);
			if(let=='(' || let=='[' || let=='{' || let=='<')
				symbols.push(let);
			else if(let==')' || let==']' || let=='}' || let=='>')
			{
				if(!symbols.isEmpty())
				{
					char comp = symbols.pop();
					if(!match(let, comp))
						return false;
				}
				else
					return false;
			}
		}
		
		if(symbols.isEmpty())
			return true;
		return false;
	}

	/**
	 * Returns a string representation of the expression and whether is expression is balanced
	 * @return the expression and the words "is correct" if the expression is balanced else "is incorrect"
	 */
	@Override
	public String toString()
	{
		if(checkExpression())
			return exp + " is correct";
		return exp + " is incorrect";
	}
}