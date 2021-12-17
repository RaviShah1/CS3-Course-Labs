public class FireCell
{
    public static final int DIRT = 0, GREEN = 1, BURNING = 2;
    private int status;

    /**
     * Constructs a fire cell object
     */
    public FireCell()
    {
        status = DIRT;
        if ( Math.random() <= 0.60 )
            status = GREEN;
    }

    /**
     * Gets the status of the cell
     * @return the status of the cell
     */
    public int getStatus()
    {
        return status;
    }

    /**
     * Sets the status if the cell
     * @param n is the new status
     */
    public void setStatus(int n)
    {
        status = n;
    }
}
