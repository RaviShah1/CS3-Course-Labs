
public class MyQueue<T> implements QueueADT
{

	MyLinkedList<T> queue;
	
	public MyQueue()
	{
		queue = new MyLinkedList<T>();
	}
	
	public MyQueue(T val)
	{
		queue = new MyLinkedList<T>(val);
	}
	
	public MyQueue(T... vals)
	{
		queue = new MyLinkedList<T>(vals);
	}
	
	/**
     * Determine if the queue is empty
     * @return true if the size is 0, false otherwise
     */
	public boolean isEmpty()
	{
		return queue.isEmpty();
	}
	
	/**
     * Add an item to the queue
     * @param item the data item to add (of type T)
     */
	@SuppressWarnings("unchecked")
	public void offer(Object item)
	{
		queue.add((T)item);
	}
	
	/**
     * Remove the front item from the queue
     * @return the front item in the queue
     */
	public T poll()
	{
		return queue.remove(0);
	}
	
	/**
     * Find how many items are in the queue
     * @return the number of items in the queue
     */
	public int size()
	{
		return queue.size();
	}
	
	/**
     * Clear out the data structure
     */
	public void clear()
	{
		queue = new MyLinkedList<T>();
	}
	
	/**
     * Return the front item in the queue without removing it
     * @return the front item in the queue
     */
	public T peek()
	{
		return queue.get(0);
	}

}
