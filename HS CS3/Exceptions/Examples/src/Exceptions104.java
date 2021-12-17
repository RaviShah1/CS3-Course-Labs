import static java.lang.System.*;
import java.util.*;

public class Exceptions104
{

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(in);
		out.print("Enter an integer: ");
		int num = scan.nextInt();
		int answer = 0;
		
		try
		{
			if(num==0)
				throw new Exception("Cannot Divide By 0");
			else
				answer=42/num;
			out.println(answer);
		}
		catch(NullPointerException e)
		{
			out.println(e + "\nNull Pointer Exception");
		}
		catch(ClassCastException e)
		{
			out.println(e + "\nClass Cast Exception");
		}
		catch(Exception e)
		{
			out.println(e + "\nGeneral Stupid Exception");
		}
		//code placed in the finally block is guaranteed to run whether of not an exception is caught
		finally
		{
			out.println("This always happens");
			scan.close();
		}
		
	}

}
