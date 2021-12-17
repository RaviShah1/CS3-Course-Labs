
public class Backtracking101
{

	public static void printBinary(int n)
	{
		if(n==0)
			System.out.println();
		else
			printBinaryHelper(n, "");
			
	}
	
	private static void printBinaryHelper(int n, String str)
	{
		if(str.length() == n)
			System.out.print(str + " ");
		else
		{
			printBinaryHelper(n, str+"0");
			printBinaryHelper(n, str+"1");
		}
	}
	
	public static void main(String args[])
	{
		printBinary(3);
	}
}
