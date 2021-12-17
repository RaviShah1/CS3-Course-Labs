import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Represents a node in the tree 
 */
class Node implements Comparable<Node>
{
	Node left; // the left node
	Node right; // the right node
	int count; // the number of times the letter(s) occur
	String val; //the letter(s)
	
	/**
	 * Constructs a Node object
	 */
	public Node()
	{
		count = 0;
		val = "";
		left = null;
		right = null;
	}
	
	/**
	 * Constructs a Node object with a given count and value
	 * @param c is the count
	 * @param v is the value
	 */
	public Node(int c, String v)
	{
		left = null;
		right = null;
		count = c;
		val = v;
	}
	
	/**
	 * Determines if the Node is a leaf
	 * @return true if the node is a leaf, else false
	 */
	public boolean isLeaf()
	{
		return left == null && right == null;
	}
	
	/**
	 * Gets a string representation of the node
	 * @return a string representation of the Node
	 */
	@Override
	public String toString()
	{
		String str = ""+count;
		if(val.length()==1)
			str+=val;
		return str;
	}

	/**
	 * Determines if the current Node has a greater, lesser or equal count to another node
	 * @return a negative if it is less, 0 if they are equal, positive if it is greater
	 */
	@Override
	public int compareTo(Node other)
	{
		return Integer.compare(count, other.count);
	}
}

/**
 * The class below is a Huffman Tree
 */
public class HuffmanTree
{
	Queue<Node> pq; // is the priority queue
	Node root; // is the root of the tree
	Map<Integer, String> map; // maps an ascii value to a binary code
	
	/**
	 * Constructs a Huffman Tree given an array with value counts for each letter
	 * @param count is an array with value counts for each letter
	 */
	public HuffmanTree(int[] count)
	{
		 pq = new PriorityQueue<Node>();
		 pq.offer(new Node(1, ""+(char)256));
		 for(int i=0; i<count.length; i++)
		 {
			 if(count[i]>0)
				pq.offer( new Node( count[i], ""+((char)i) ) );
		 }
		 root = buildTree();
		 
		 map = new HashMap<Integer, String>();
		 buildMap(root, "");
	}
	
	/**
	 * Constructs a Huffman Tree given a code file
	 * @param codeFile is the code file
	 * @throws FileNotFoundException
	 */
	public HuffmanTree(String codeFile) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File(codeFile));
		
		root = new Node();
		
		while(file.hasNextLine())
		{
			String val = ""+(char)(Integer.parseInt(file.nextLine()));
			String code = file.nextLine();
			Node cur = root;
			for(int i=0; i<code.length(); i++)
			{
				if(code.charAt(i)=='0')
				{
					if(i==code.length()-1)
						cur.left = new Node(0, val);
					else if(cur.left == null)
						cur.left = new Node();
					cur = cur.left;
				}
				if(code.charAt(i)=='1')
				{
					if(i==code.length()-1)
						cur.right = new Node(0, val);
					else if(cur.right == null)
						cur.right = new Node();
					cur = cur.right;
				}
			}
		}
		
		map = new HashMap<Integer, String>();
		buildMap(root, "");
	} 
	
	/**
	 * Builds the map that connects ascii values to their new binary code
	 * @param cur is the current node the algorithm is working on
	 * @param code is the binary code that is being created
	 */
	private void buildMap(Node cur, String code) 
	{
		if(cur==null)
			return;
		else if(cur.isLeaf())
		{
			map.put((int)cur.val.charAt(0), code);
			return;
		}
		else
		{
			buildMap(cur.left, code+"0");
			buildMap(cur.right, code+"1");
		}
	}
	
	/**
	 * Builds the tree using the priority queue
	 * @return the root of the tree
	 */
	private Node buildTree()
	{
		while(pq.size()>1)
		{
			Node p = new Node();
			p.left = pq.poll();
			p.right = pq.poll();
			p.val = p.left.val+p.right.val;
			p.count = p.right.count+p.left.count;
			pq.offer(p);
		}
		
		return pq.element();
	}
	
	/**
	 * Writes the tree into a .code file
	 * @param fileName is the file name tow write to
	 */
	public void write(String fileName)
	{
		PrintWriter diskFile = null;
		try {
			diskFile = new PrintWriter(new File(fileName));
			save(diskFile, root, "");
			diskFile.close();
		}
		catch (IOException io) {
			System.out.println("Could not create file: " + fileName);
		}
	}
	
	/**
	 * Helper method for write() to create the .code file
	 * @param disk is a PrintWriter object where to save the data
	 * @param cur is the current node the algorithm is working on
	 * @param code is the binary code for a given letter
	 */
	private void save(PrintWriter disk, Node cur, String code)
	{
		if(cur==null)
			return;
		else if(cur.isLeaf())
		{
			disk.println((int)cur.val.charAt(0));
			disk.println(code);
			return;
		}
		else
		{
			save(disk, cur.left, code+"0");
			save(disk, cur.right, code+"1");
		}
	}
	
	/**
	 * Encodes a given file using the tree (creates a .short file)
	 * @param out is the BitOutputStream to write to encoded values to
	 * @param inFile is the input file
	 * @throws FileNotFoundException
	 */
	public void encode(BitOutputStream out, String inFile) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File(inFile));
		String code = "";
		
		while(file.hasNextLine())
		{
			String word = file.nextLine();
			for(int i=0; i<word.length(); i++)
			{
				code = map.get((int)word.charAt(i));
				for(char c : code.toCharArray())
				{
					if(c=='0')
						out.writeBit(0); 
					else
						out.writeBit(1);
				}
				//out.writeBit(map.get((int)word.charAt(i))); 
			}
			if(file.hasNext())
			{
				code = map.get(10);
				for(char c : code.toCharArray())
				{
					if(c=='0')
						out.writeBit(0); 
					else
						out.writeBit(1);
				}
			}
		}
		//out.writeBit(map.get(256));
		code = map.get(256);
		for(char c : code.toCharArray())
		{
			if(c=='0')
				out.writeBit(0); 
			else
				out.writeBit(1);
		}
		out.close();
	}
	
	/**
	 * Decodes a given file using the tree (creates a .new file)
	 * @param in is the BitInputStream to read the data from
	 * @param outFile is the file to write the output to
	 * @throws FileNotFoundException
	 */
	public void decode(BitInputStream in, String outFile) throws FileNotFoundException
	{
		PrintWriter diskFile = new PrintWriter(new File(outFile));
		int num = -2;
		Node cur = root;
		
		while(num!=-1)
		{
			num = in.readBit();
			
			
			if(num==0)
				cur = cur.left;
			else
				cur = cur.right;
			
			if(cur.isLeaf())
			{
				char val = cur.val.charAt(0);
				if(val!=(char)256)
					diskFile.print(val);
				cur = root;
			}
				
		}
		
		diskFile.close();
	}

}
	





