import java.awt.Color;

/**
 * GemType enum definition
 * @author Ravi Shah
 *
 */
enum GemType {
    GREEN, BLUE, ORANGE; //define the different types of Gems, comma delimited
}

/**
 * Gem class definition
 * @author Ravi Shah
 *
 */
public class Gem 
{	
	private GemType type;
	private int points;
	
	/**
	 * Constructs a gem object with random values
	 */
	public Gem()
	{
		type = GemType.values()[(int) (Math.random()*3)];
		int[] possiblePoints = {0,5,10,15,20,25,30,35,40,45,50};
		points = possiblePoints[(int) (Math.random()*possiblePoints.length)];
	}
	
	/**
	 * Constructs a gem object with given values
	 * @param type is the type of the gem
	 * @param points is the points of the gem
	 */
	public Gem(GemType type, int points)
	{
		this.type = type; 
		this.points = points;
	}
	
	/**
	 * Gets a string representation of the gem
	 * @return a string representation of the gem
	 */
	public String toString()
	{
		return type + " " + points;
	}
	
	/**
	 * Gets the type of the gem
	 * @return the type of the gem
	 */
	public GemType getType()
	{
		return type;
	}
	
	/**
	 * Gets the number of points the gem is worth
	 * @return the gems points
	 */
	public int getPoints()
	{
		return points;
	}
	
	/**
	 * Draws the gem
	 * @param x is the x coordinate to draw the gem
	 * @param y is the y coordinate to draw the gem
	 */
	public void draw(double x, double y)
	{
		StdDraw.setPenColor(Color.WHITE);
		

		if(type == GemType.GREEN)
		{
			StdDraw.picture(x, y, "gem_green.png");
			StdDraw.text(x, y, ""+points);
		}
		else if(type == GemType.BLUE)
		{
			StdDraw.picture(x, y, "gem_blue.png");
			StdDraw.text(x, y, ""+points);
		}
		else
		{
			StdDraw.picture(x, y, "gem_orange.png");
			StdDraw.text(x, y, ""+points);
		}
	}
	
	/** Tester main method */
	public static void main(String [] args)
	{
		final int maxGems = 16;
		
		// Create a gem of each type
		Gem green  = new Gem(GemType.GREEN, 10);
		Gem blue   = new Gem(GemType.BLUE, 20);
		Gem orange = new Gem(GemType.ORANGE, 30);
		System.out.println(green  + ", " + green.getType()  + ", " + green.getPoints());		
		System.out.println(blue   + ", " + blue.getType()   + ", " + blue.getPoints());
		System.out.println(orange + ", " + orange.getType() + ", " + orange.getPoints());
		green.draw(0.3, 0.7);
		blue.draw(0.5, 0.7);
		orange.draw(0.7, 0.7);
		
		// A row of random gems
		for (int i = 0; i < maxGems; i++)
		{
			Gem g = new Gem();
			g.draw(1.0 / maxGems * (i + 0.5), 0.5);
		}
	}
}
