import static java.lang.System.*;

//Files needed
 	//Part.java
 	//PartList.java

/**
 * Tests the PartList class
 * @author Ravi Shah
 *
 */
public class PartRunner
{
	public static void main(String[] args)
	{
		PartList prog = new PartList("partinfo.dat");
		out.println(prog);
	}
}
