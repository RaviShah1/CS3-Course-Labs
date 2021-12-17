

public class Person
{
	private String name;
	
	public Person(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int hashCode()
	{
		int code = 0;
		for(int i=0; i<name.length(); i++)
			if(name.substring(i,i+1).matches("[^AEIOUaeiou]"))
				code += (int)name.charAt(i);
		return code;
	}
	
	public boolean equals(Object other)
	{
		Person p2 = (Person) other;
		return name.equals(p2.getName());
	}
	
	public String toString()
	{
		return name;
	}
}