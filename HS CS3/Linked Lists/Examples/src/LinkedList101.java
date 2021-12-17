
public class LinkedList101
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}

class Node<T>
{
	T head;
	Node next;
	public Node(T val)
	{
		this.head = val;
	}
	
	public void add(Node n)
	{
		this.next = n;
	}
}