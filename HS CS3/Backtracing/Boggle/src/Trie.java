/**
 * Class Definition for a Node in a Trie
 * @author Ravi Shah
 *
 */
class Node
{
	char val; // letter
	boolean isWord; // if it is a word
	Node[] childern; // childern nodes
	
	/**
	 * Creates a Node object
	 */
	public Node()
	{
		val = '?';
		isWord = false;
		childern = new Node[26];
	}
	
	/**
	 * Creates a node object given a letter
	 * @param let is the letter
	 */
	public Node(char let)
	{
		val = let;
		isWord = false;
		childern = new Node[26];
	}
	
	/**
	 * Gets a string representation of the Node
	 * @return a string representation of the node
	 */
	public String toString()
	{
		return ""+val;
	}
}

/**
 * Class definition for a Trie
 * @author Ravi Shah
 *
 */
public class Trie
{
	Node root; // is the root of the Trie
	
	/**
	 * Constructs the Trie
	 */
	public Trie()
	{
		root = new Node();
	}
	
	/**
	 * Adds a word the Trie
	 * @param str is the word being inserting 
	 */
	public void addWord(String str)
	{
		str = str.replaceAll("QU", "Q");
		
		Node cur = root;
		for(char c : str.toCharArray())
		{
			int idx = (int)c - 65;
			if(cur.childern[idx]==null)
				cur.childern[idx] = new Node(c);
			cur = cur.childern[idx];
		}
		cur.isWord = true;
	}
	
	/** 
	 * Traverses to the next Node in the Trie given a letter
	 * @param n is the current node
	 * @param next is the next letter
	 * @return the next node
	 */
	public Node getNext(Node n, char next)
	{
		int idx = (int)next-65;
		return n.childern[idx];
	}
}
