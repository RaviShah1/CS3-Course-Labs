public class FireModel
{
    public static int SIZE = 47;
    private FireCell[][] myGrid;
    private FireView myView;

    /**
     * Constructs an object of the Fire Model class
     * @param view is the visualizer for the model
     */
    public FireModel(FireView view)
    {
        myGrid = new FireCell[SIZE][SIZE];
        int setNum = 0;
        for (int r=0; r<SIZE; r++)
        {
            for (int c=0; c<SIZE; c++)
            {
                myGrid[r][c] = new FireCell();
            }
        }
        myView = view;
        myView.updateView(myGrid);
    }

    /**
     *	Burns the forest and determines if Onett is safe from the fire
     */
    public void solve()
    {
        for(int i=0; i<SIZE-1; i++)
        	if(myGrid[SIZE-1][i].getStatus()==1)
        		solveHelp(SIZE-1, i);
        
        
        boolean safe = true;
        for(int i=0; i<SIZE-1; i++)
        	if(myGrid[0][i].getStatus()==2)
        		safe = false;
        if(safe)
        	System.out.println("Onett is safe");
        else
        	System.out.println("Onett is in trouble");
        	
        	
        myView.updateView(myGrid);
    }

    /**
     * Helper method to burn the forest
     * @param r is the current row
     * @param c is the current column
     */
    private void solveHelp(int r, int c)
    {
    	if(myGrid[r][c].getStatus()==1)
    	{
    		myGrid[r][c].setStatus(2);
    		
    		if(r-1>=0)
    			solveHelp(r-1, c);
    		if(r+1<SIZE)
    			solveHelp(r+1, c);
    		if(c-1>=0)
    			solveHelp(r, c-1);
    		if(c+1<SIZE)
    			solveHelp(r, c+1);
    	}
    	return;
    }
    

}
