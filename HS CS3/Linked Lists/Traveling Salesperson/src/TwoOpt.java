import java.util.List;
import java.util.ArrayList;

/**
 * The class applys the 2 opt method to a tour
 * this does not use a linked list
 * @author Ravi Shah
 *
 * sources:
 * https://www.researchgate.net/figure/Pseudo-code-for-2-opt-algorithm_tbl1_268981882
 * https://github.com/jackspyder/2-opt
 */

public class TwoOpt
{
	Tour ll;
	List<Point> tour;
	
	/**
	 * Constructs a TwoOpt object
	 * @param t
	 */
	public TwoOpt(Tour t)
	{
		ll = t;
		tour = new ArrayList<Point>();
		int size = t.size();
		for(int i=0; i<size; i++)
			tour.add(ll.get(i));
	}
	
	/**
	 * Calculated distance of tour
	 * @param tour is the tour
	 * @return dist is the distance
	 */
	public int distance(List<Point> tour)
	{
		int dist = 0;
		for(int i=0; i<tour.size()-1; i++)
		{
			dist += (tour.get(i).distanceTo(tour.get(i+1)));
		}
		return dist;
	}
	
	/**
	 * Applys the optimization
	 */
	public void optimize()
	{
		int bestDist = distance(tour);
		int newDist;
		int swaps = 1;
		
		while(swaps>0)
		{
			swaps = 0;
			
			for(int i=1; i<tour.size()-2; i++)
			{
				for(int j=i+2; j<tour.size()-1; j++)
				{
					if(tour.get(i).distanceTo(tour.get(i-1)) + tour.get(j+1).distanceTo(tour.get(j)) >=
						tour.get(i).distanceTo(tour.get(j+1)) + tour.get(i-1).distanceTo(tour.get(j)))
					{
						List<Point> newTour = swap(i, j);
						newDist = distance(newTour);
						
						if(newDist < bestDist)
						{
							tour = newTour;
							bestDist = newDist;
							swaps++;
						}
					}
				}
			}
		}
	}
	
	/**
	 * Swaps two paths
	 * @param i is the fist index
	 * @param j is the second index
	 * @return newTour is a new tour with swapped paths
	 */
	public List<Point> swap(int i, int j)
	{
		List<Point> newTour = new ArrayList<Point>();
		
		for(int p=0; p<i; p++)
			newTour.add(tour.get(p));
		
		int dec = 0;
		for(int p=i; p<=j; p++)
		{
			newTour.add(tour.get(j-dec));
			dec++;
		}
		
		for(int p=j+1; p<tour.size(); p++)
			newTour.add(tour.get(p));
		
		return newTour;
	}
	
	/**
	 * Converts array list to a linked list tour
	 * @return
	 */
	public Tour toTour()
	{
		Tour t = new Tour();
		for(int i=0; i<tour.size(); i++)
			t.add(tour.get(i));
		return t;
	}
}
