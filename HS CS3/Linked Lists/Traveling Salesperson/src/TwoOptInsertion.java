import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*************************************************************************
 *  This file utilizes a smallest insertion further optimized by
 *  the 2-opt algorithm
 *  
 *  Suprisingly, this algorithm does not work as well as my 
 *  imporveSmallest algorithm
 *  
 *  Score: 17144.8415
 *
 *************************************************************************/

public class TwoOptInsertion 
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
            //tour.add(p);
            /*
             * uncomment the 4 lines below to animate
             */
//            StdDraw.clear();
//            tour.draw();
//            StdDraw.show();
//            StdDraw.text(100, 0, "" + tour.distance());
//            StdDraw.pause(1);
        }
        //tour.improve();
        // draw to standard draw
        TwoOpt opt = new TwoOpt(tour);
        opt.optimize();
        tour = opt.toTour();
        
        tour.draw();
        
        StdDraw.show();
        
        // print tour to standard output
        System.out.printf("Tour distance =  %.4f\n", tour.distance());
        System.out.printf("Number of points = %d\n", tour.size());
        tour.show();
    }
}
