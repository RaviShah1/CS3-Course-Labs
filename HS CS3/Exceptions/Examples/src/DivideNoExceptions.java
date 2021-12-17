import java.util.*;
// exception = way java virtual machine handles unexpected events
public class DivideNoExceptions
{
    public static void main(String[] args)
    {
       DivideTester test = new DivideTester();
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

class DivideTester
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
       quotient = dividend / divisor;   
    }
    
    public void printResults()
    {
       System.out.println(dividend + " / " + divisor + " = " +  quotient);
       System.out.println();
    }
}