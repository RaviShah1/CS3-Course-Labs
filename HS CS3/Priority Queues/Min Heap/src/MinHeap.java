import java.util.Arrays;

public class MinHeap
{
	Integer[] heap; // the heap
	int size; // the size
	static final int DEFAULT_CAPACITY = 8; // the default capacity
	
	/**
	 * Constructs a min heap
	 */
	public MinHeap()
	{
		size = 0;
		heap = new Integer[DEFAULT_CAPACITY];
	}
	
	/**
	 * Constructs a min heap with starting values using the build heap method
	 * @param nums the starting numbers
	 */
	public MinHeap(Integer... nums)
	{
		size = 0;
		heap = new Integer[DEFAULT_CAPACITY];
		for(Integer i : nums)
		{
			if(++size >= heap.length)
				doubleCapacity();
			heap[size] = i;
		}
		buildHeap();
	}
	
	/**
	 * Builds a heap given starting values
	 * The starting values are in the heap instance variable are are unsorted
	 */
	private void buildHeap()
	{
		for(int i=size/2; i>=1; i--)
			shiftDown(i); // my shift down works exactly like heapify
	}
	
	/**
	 * Gets the heaps size
	 * @return the size of the heap
	 */
	public int getSize()
	{
		return size;
	}
	
	/**
	 * Determines if the heap is empty
	 * @return true if the heap is empty, else false
	 */
	public boolean isEmpty()
	{
		return size==0;
	}
	
	/**
	 * Gets the minimum value in the heap
	 * @return the minimum value in the heap
	 */
	public int peekMinimum()
	{
		return heap[1];
	}
	
	/**
	 * Gets the left index of a given parent index
	 * @param index is the parent index
	 * @return is the left index
	 */
	public int getLeftChildIndex(int index)
	{
		return 2*index;
	}
	
	/**
	 * Gets the right index given a parent index
	 * @param index is the parent index
	 * @return the right index
	 */
	public int getRightChildIndex(int index)
	{
		return 2*index + 1;
	}
	
	/**
	 * Gets the parent index given a child index
	 * @param index is the child index
	 * @return is the parent index
	 */
	public int getParentIndex(int index)
	{
		return (index) / 2;
	}
	
	/**
	 * Doubles the capacity of the array backing the heap
	 */
	private void doubleCapacity()
	{
		Integer[] temp = heap;
		heap = new Integer[temp.length*2];
		for(int i=0; i<temp.length; i++)
			heap[i] = temp[i];
	}
	
	/**
	 * Inserts a value into the heap
	 * @param value is the value to insert
	 */
	public void insert(int value)
	{	
		if(++size >= heap.length)
			doubleCapacity();
		
		heap[size] = value; 
		bubbleUp(size);
	}
	
	/**
	 * Bubbles a value at a given index up to a location where is is the minimum
	 * @param index is the index
	 */
	private void bubbleUp(int index)
	{
		int parent = getParentIndex(index);
		if(index == 1)
			return;

		if(heap[index]<heap[parent])
		{
			Integer temp = heap[index];
			heap[index] = heap[parent];
			heap[parent] = temp;
			bubbleUp(parent);
		}
	}
	
	/**
	 * Removes the smallest value in the heap
	 * @return the smallest value that got removed
	 */
	public int popMinimum()
	{
		Integer min = heap[1];
		
		heap[1] = heap[size];
		heap[size--] = null;
		shiftDown(1);
		
		return min;
	}
	
	/**
	 * Applies the heapify algorithm
	 * Shifts a value down to a location where it is the minimum value
	 * @param index is the index
	 */
	private void shiftDown(int index)
	{
		int small = index;
		int l = getLeftChildIndex(index);
		int r = getRightChildIndex(index);
		
		if(l<=size && heap[l].compareTo(heap[small]) < 0)
			small = l;
		if(r<=size && heap[r].compareTo(heap[small]) < 0)
			small = r;
		
		if(small != index)
		{
			Integer temp = heap[index];
			heap[index] = heap[small];
			heap[small] = temp;
			shiftDown(small);
		}
		
	}
	
	/**
	 * Gets a string representation of the heap
	 * @return a string representation of the heap
	 */
	 @Override 
	 public String toString() 
	 { 
	  String output = ""; 
	 
	  for (int i = 1; i <= getSize(); i++)  
	   output += heap[i] + ", "; 
	 
	  return output.substring(0, output.lastIndexOf(",")); //lazily truncate last comma 
	 } 
	 
	 /** method borrowed with minor modifications from the internet somewhere, for printing */ 
	 public void display() { 
	  int nBlanks = 32, itemsPerRow = 1, column = 0, j = 1; 
	  String dots = "..............................."; 
	  System.out.println(dots + dots);       
	  while (j <= this.getSize()) 
	  { 
	   if (column == 0)                  
	    for (int k = 0; k < nBlanks; k++) 
	     System.out.print(' '); 
	 
	   System.out.print((heap[j] == null)? "" : heap[j]); 
	    
	   if (++column == itemsPerRow) { 
	    nBlanks /= 2;                  
	    itemsPerRow *= 2;              
	    column = 0;                    
	    System.out.println();          
	   } 
	   else                              
	    for (int k = 0; k < nBlanks * 2 - 2; k++) 
	     System.out.print(' '); 
	    
	   j++; 
	  } 
	  System.out.println("\n" + dots + dots);  
	 }  
	 
	
	
}
