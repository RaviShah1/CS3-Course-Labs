
public class Enums102
{

	public static void main(String[] args)
	{

		Element arr[] = Element.values();
		for(Element e : arr)
		{
			//calling ordinal()
			System.out.println(e + " at index " + e.ordinal());
		}
		
		//calling valueOf
		//returns an object of element with given constant
		//second line causes illegal argument exception
		System.out.println(Element.valueOf("FIRE"));
		System.out.println(Element.valueOf("LOVE"));
	}

}
