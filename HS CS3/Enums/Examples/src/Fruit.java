
public enum Fruit
{
	APPLE("Red"), BANANA("Yello"), GRAPE("Purple"), ORANGE;
	
	private String color;
	
	private Fruit()
	{
		System.out.println("Constructor Called For: " + this.toString());
	}
	
	private Fruit(String color)
	{
		this.color = color;
	}
	
	public String getFruitColor()
	{
		return color;
	}
}

