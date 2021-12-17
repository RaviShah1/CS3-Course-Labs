import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*************************************************************************
 *  This file utilizes a smallest insertion further optimized by
 *  my custom improveSmallest method in the tour class
 *  Score: 16806.7863
 *
 *************************************************************************/

public class SmallestImproved 
{
	public static void main(String[] args) 
    {
    	Scanner in = null;
    	
    	try {
    		in = new Scanner(new File("tsp1000.txt")); //change to test other files
    	}
    	catch (IOException ex) {}
    	
        // get dimensions
        int w = in.nextInt();
        int h = in.nextInt();
        StdDraw.setCanvasSize(w, h);
        StdDraw.setXscale(0, w);
        StdDraw.setYscale(0, h);
        StdDraw.setPenColor(Color.BLUE);
        StdDraw.enableDoubleBuffering();
        // run smallest insertion heuristic
        Tour tour = new Tour();
        
        while (in.hasNextLine()) {
            double x = in.nextDouble();
            double y = in.nextDouble();
            Point p = new Point(x, y);
            tour.insertSmallest(p);


        }
        tour.improveSmallest();
        // draw to standard draw
        tour.draw();
        
        StdDraw.show();
        
        // print tour to standard output
        System.out.printf("Tour distance =  %.4f\n", tour.distance());
        System.out.printf("Number of points = %d\n", tour.size());
        tour.show();
    }
}
