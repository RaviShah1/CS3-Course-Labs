
public class HashCode
{

	public static void main(String[] args)
	{
		Character c  = 'a';
		System.out.println(c.hashCode());
		c  = '0';
		System.out.println(c.hashCode());
		c  = 'A';
		System.out.println(c.hashCode());
		
		System.out.println();
		
		Integer num = 45;
		System.out.println(num.hashCode());
		num = 101;
		System.out.println(num.hashCode());
		
		
		System.out.println();
		
		String s = "a";
		System.out.println(s.hashCode());
		s = "ab";
		System.out.println(s.hashCode());
		System.out.println(97*98/2);
	}

}