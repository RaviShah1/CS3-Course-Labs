
public class Tester
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		SearchTree tree = new SearchTree(5);
		tree.add(6);
		tree.add(9);
		tree.add(7);
		tree.add(4);
		tree.print();
		System.out.println(tree.getMin());
	}

}
