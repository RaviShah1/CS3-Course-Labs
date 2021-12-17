import java.util.Scanner;

public class Exceptions101
{
	 public static void main(String[] args)
	    {
	       Divide test = new Divide();
	       Scanner keyboard = new Scanner(System.in);
	       String ans;
	       
	       do
	       {
	          test.getNumbers();    // get two numbers
	          test.divide();        // calculate the quotient
	          test.printResults();  // print the results
	          
	          System.out.print("Continue[Y/N]?");
	          ans = keyboard.nextLine();
	          System.out.println();
	       } while(ans.equalsIgnoreCase("y"));
	    }
}


class Divide
{
    private int dividend;
    private int divisor;
    private int quotient;
    
    public void getNumbers()
    {
       Scanner keyboard = new Scanner(System.in);
       System.out.print("Enter the Dividend-->");
       dividend = keyboard.nextInt();
       System.out.print("Enter the Divisor-->");
       divisor = keyboard.nextInt();
       System.out.println();
    }
    
    public void divide()
    {
    	//default behavior for exception is to exits program and pop all exceptions from stack
        //quotient = dividend / divisor;

    	quotient = dividend / divisor;
    	
//    	try
//    	{
//    		quotient = dividend / divisor;
//    	}
//    	catch(ArithmeticException e) // a catch must go with a try
//    	{
//    		// to override default behavior, add output in catch block
//    		System.out.println("Cannot divide by 0"); 
//    	}
    	
    	// this code will throw an exception when dividing by 42
//    	if(divisor == 42)
//    	{
//    		throw new ArithmeticException();
//    	}
    	
//    	if(divisor == 42)
//        {
//        	throw new ArithmeticException("Tried to divide " + dividend + " by 42... you dork!");
//        }
    	
    	try
    	{
    		if(divisor == 42)
    			throw new ArithmeticException("Cannot Divide By 42");
    		quotient = dividend / divisor;
    	}
    	catch(ArithmeticException e)
    	{
    		System.out.println(e.getMessage());
    	}
    	
    	
    }
    
    public void printResults()
    {
       System.out.println(dividend + " / " + divisor + " = " +  quotient);
       System.out.println();
    }
}