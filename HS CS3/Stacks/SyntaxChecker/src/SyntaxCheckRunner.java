public class SyntaxCheckRunner
{
	public static void main ( String[] args )
	{
		SyntaxChecker test = new SyntaxChecker("(abc(*def)");
		System.out.println(test);
		
		test.setExpression("[{}]");
		System.out.println(test);
		
		test.setExpression("[");
		System.out.println(test);
		
		test.setExpression("[{<()>}]");
		System.out.println(test);
		
		test.setExpression("{<html[value=4]*(12)>{$x}}");
		System.out.println(test);
		
		test.setExpression("[one]<two>{three}(four)");
		System.out.println(test);
		
		test.setExpression("car(cdr(a)(b)))");
		System.out.println(test);
		
		test.setExpression("car(cdr(a)(b))");
		System.out.println(test);
	}
}