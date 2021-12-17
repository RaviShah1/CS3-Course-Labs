import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GameTree
{
	/**
	 * This class represents a Node in the binary tree
	 */
	private class Node
	{
		String val;
		boolean isQuestion;
		Node left, right;
		
		public Node(String str, boolean question)
		{
			val = str;
			isQuestion = question;
			left = right = null;
		}
	}

	Node root; // the root of the tree
	Node current; // the node the computer is currently on
	int level; // the level of the tree current is on
	String fname; // the filename of the input
	
	/**
	 * Constructor needed to create the game.
	 *
	 * @param fileName this is the name of the file we need to import the game
	 *                 questions and answers from.
	 */
	public GameTree(String fileName)
	{
		fname = fileName;
		try
		{
			Scanner scan = new Scanner(new File(fileName));
			root = makeTree(scan, root);
		} catch (FileNotFoundException s)
		{
			System.out.println("File does Not Exist Please Try Again: ");
		}
		current = root;
	}

	/**
	 * Makes the tree recursively
	 * @param scan is the scanner
	 * @param cur is the current node the file is reading into
	 * @return the root of the tree
	 */
	private Node makeTree(Scanner scan, Node cur)
	{
		String str = scan.nextLine();
		str.trim();
		if(str.indexOf("?") != -1)
		{
			cur = new Node(str, true);
			cur.left = makeTree(scan, cur.left);
			cur.right = makeTree(scan, cur.right);
		}
		else
		{
			cur = new Node(str, false);
		}
		return cur;
	}
	/*
	 * Add a new question and answer to the currentNode. If the current node has the
	 * answer chicken, theGame.add("Does it swim?", "goose"); should change that
	 * node like this:
	 */
	// -----------Feathers?-----------------Feathers?------
	// -------------/----\------------------/-------\------
	// ------- chicken horse-----Does it swim?-----horse--
	// -----------------------------/------\---------------
	// --------------------------goose--chicken-----------
	/**
	 * @param newQ The question to add where the old answer was.
	 * @param newA The new Yes answer for the new question.
	 */
	public void add(String newQ, String newA)
	{
		Node temp = new Node(current.val, current.isQuestion);
		Node tempL = current.left;
		Node tempR = current.right;
		temp.left = tempL; temp.right= tempR;
		
		current.val = newQ;
		current.isQuestion = true;
		current.left = new Node(newA, false);
		current.right = temp;
	}


	/**
	 * True if getCurrent() returns an answer rather than a question.
	 *
	 * @return False if the current node is an internal node rather than an answer
	 *         at a leaf.
	 */
	public boolean foundAnswer()
	{
		return !current.isQuestion;
	}

	/**
	 * Return the data for the current node, which could be a question or an answer.
	 * Current will change based on the users progress through the game.
	 *
	 * @return The current question or answer.
	 */
	public String getCurrent()
	{
		return current.val; // replace
	}

	/**
	 * Ask the game to update the current node by going left for Choice.yes or right
	 * for Choice.no Example code: theGame.playerSelected(Choice.Yes);
	 *
	 * @param yesOrNo
	 */
	public void playerSelected(Choice yesOrNo)
	{
		if(yesOrNo == Choice.Yes)
			current = current.left;
		else
			current = current.right;
		level++;
	}

	/**
	 * Begin a game at the root of the tree. getCurrent should return the question
	 * at the root of this GameTree.
	 */
	public void reStart()
	{
		current = root;
		level = 0;
	}

	/**
	 * Gets a String representation of the tree
	 * @return a String representation of the tree
	 */
	@Override
	public String toString()
	{
		return getString(root, "", 0);
	}
	
	/**
	 * Gets the string representation of the tree recursively
	 * @param n is the node the method is currently on
	 * @param str is the string representation of the tree
	 * @param level is the level the method is currently on
	 * @return a string representation of the tree
	 */
	private String getString(Node n, String str, int level)
	{
		if(n!=null)
		{
			
			
			//str += n.val + "\n";
			str = getString(n.right, str, level+1);
			for(int i=0; i<level; i++)
				str += "- ";
			str += n.val + "\n";
			str = getString(n.left, str, level+1);
		}
		return str;
	}

	/**
	 * Overwrite the old file for this gameTree with the current state that may have
	 * new questions added since the game started.
	 *
	 */
	public void saveGame()
	{
		PrintWriter diskFile = null;
		try {
			diskFile = new PrintWriter(new File(fname));
			save(diskFile, root);
			diskFile.close();
			}
		catch (IOException io) {
			System.out.println("Could not create file: " + fname);
		}
		
	}
	
	/**
	 * Saves the tree given a disk fle recursively
	 * @param diskFile is the DiskFile object to put the tree into
	 * @param n is the node the method is currently working on
	 */
	private void save(PrintWriter diskFile, Node n)
	{
		if(n!=null)
		{
			diskFile.println(n.val);
			save(diskFile, n.left);
			save(diskFile, n.right);
		}
		
	}
}
