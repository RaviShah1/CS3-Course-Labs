import java.util.*;
import static java.lang.System.*;

public class IntegerCalculator
{
	private int operand1;
	private int operand2;
	private int result;

	public IntegerCalculator()
	{
		mainMenu();
	}

	public void mainMenu()
	{
		int ans = 0;

		do
		{
			ans = getInfo();

			if(ans == 1)
               add();
			if(ans == 2)
               subtract();
			if(ans == 3)
               multiply();
			if(ans == 4)
			   divide();

			System.out.println();
		}
		while(ans != 5);
	}

	// Postcondition:Retrieves calculator input from the user.
	//   Asks the user to select from a menu which operation they wish
	//   to perform 1) add 2) subtract 3) multiply 4) divide.
	//   It then asks the user to enter in two operands. If either of
	//   the two operands are not valid integers it displays an error
	//   message and asks the user for the information again.
	//   The method returns an integer representing operation selected
	//   by the user
	public int getInfo()
	{
		out.println("1)Add 2)Subtract 3)Multiply 4)Divide 5)Quit\n");
		Scanner scan = new Scanner(in);
		int option = -1;
		try
		{
			option = scan.nextInt();
			out.println("Operator 1 -->");
			operand1 = scan.nextInt();
			out.println("Operator 2 -->");
			operand2 = scan.nextInt();
			return option;
		}
		catch(Exception e)
		{
			System.out.println("Not a valid number, try again");
			getInfo();
		}
		return option;
		
	}

	public void add()
	{
		result = operand1 + operand2;
		System.out.println(operand1 + " + " + operand2 + " = " + result);
	}

	public void subtract()
	{
		result = operand1 - operand2;
		System.out.println(operand1 + " - " + operand2 + " = " + result);
	}

	public void multiply()
	{
		result = operand1 * operand2;
		System.out.println(operand1 + " * " + operand2 + " = " + result);

	}

	// Precondition:  two valid operands
	// Postcondition: performs the division operation on the two
	//    operands and displays the results. If a division by zero
	//    error occurs it displays an error message and does not
	//    display any results.
	public void divide()
	{
		try
		{
			if(operand2 == 0)
				throw new ArithmeticException("Error: You cannot divide by zero!");
			result = operand1 / operand2;
		}
		catch(ArithmeticException e)
		{
			System.out.println(e.getMessage());
		}

	}

	public static void main(String[] args)
	{
		IntegerCalculator app = new IntegerCalculator();
	}
}