import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BoggleSolver
{
	Set<String> dict = new HashSet<String>();
	Iterable<String> allValid;
	Trie trie;
	
	// Initializes the data structure using the given array of strings as the dictionary.
	// (You can assume each word in the dictionary contains only the uppercase letters A - Z.)
	public BoggleSolver(String dictionaryName) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File(dictionaryName));
		
		while(file.hasNext())
			dict.add(file.nextLine().trim());
		
		trie = new Trie();
		for(String word : dict)
			trie.addWord(word);
	}
	
	
	// Returns the set of all valid words in the given Boggle board, as an Iterable object
	public Iterable<String> getAllValidWords(BoggleBoard board)
	{
		if(allValid != null)
			return allValid;
		
		HashSet<String> valid = new HashSet<String>();
		//boolean[][] check = new boolean[board.rows()][board.cols()];
		
		for(int r=0; r<board.rows(); r++)
		{
			for(int c=0; c<board.cols(); c++)
			{
				boolean[][] check = new boolean[board.rows()][board.cols()];
				//getWordHelper(board, r, c, valid, "", check);
				trieGetWord(board, r, c, valid, "", check, trie, trie.root);
			}
		}

		allValid = valid;
		return valid;
	}
	
	/**
	 * Helper method to get all the valid words in the board
	 * @param b is the board
	 * @param r is the current row
	 * @param c is the current column
	 * @param valid is a HashSet of all the words
	 * @param str is the current String
	 * @param check is an array to see if the square has already been visited
	 */
	private void getWordHelper(BoggleBoard b, int r, int c, HashSet<String> valid, String str, boolean[][] check)
	{		
		if(check[r][c])
			return;
		check[r][c] = true;
		
		str += b.getLetter(r, c);
		if(b.getLetter(r, c) == 'Q')
			str+="U";
		if(dict.contains(str) && str.length()>2)
			valid.add(str);
		
		if(inBounds(b, r+1, c-1))
			getWordHelper(b, r+1, c-1, valid, str, check);
		if(inBounds(b, r+1, c))
			getWordHelper(b, r+1, c, valid, str, check);
		if(inBounds(b, r+1, c+1) )
			getWordHelper(b, r+1, c+1, valid, str, check);
		
		if(inBounds(b, r, c-1))
			getWordHelper(b, r, c-1, valid, str, check);
		if(inBounds(b, r, c+1))
			getWordHelper(b, r, c+1, valid, str, check);
		
		if(inBounds(b, r-1, c-1))
			getWordHelper(b, r-1, c-1, valid, str, check);
		if(inBounds(b, r-1, c))
			getWordHelper(b, r-1, c, valid, str, check);
		if(inBounds(b, r-1, c+1))
			getWordHelper(b, r-1, c+1, valid, str, check);
		check[r][c] = false;
	}
	
	/**
	 * Helper method to get all the valid words in the board using a Trie
	 * @param b is the board
	 * @param r is the current row
	 * @param c is the current column
	 * @param valid is a HashSet of all the words 
	 * @param str is the current String
	 * @param check is an array to see if the square has already been visited
	 * @param trie is the trie
	 * @param cur is the current node in the trie
	 */
	private void trieGetWord(BoggleBoard b, int r, int c, HashSet<String> valid, String str, boolean[][] check, Trie trie, Node cur)
	{		
		if(check[r][c])
			return;
		check[r][c] = true;
		
		str += b.getLetter(r, c);
		if(b.getLetter(r, c) == 'Q')
			str+="U";
		
		cur = trie.getNext(cur, b.getLetter(r, c));

		if(cur==null)
		{
			check[r][c] = false;
			return;
		}
		
		if(cur.isWord && str.length()>2)
			valid.add(str);
		
		if(inBounds(b, r+1, c-1))
			trieGetWord(b, r+1, c-1, valid, str, check, trie, cur);
		if(inBounds(b, r+1, c))
			trieGetWord(b, r+1, c, valid, str, check, trie, cur);
		if(inBounds(b, r+1, c+1) )
			trieGetWord(b, r+1, c+1, valid, str, check, trie, cur);
		
		if(inBounds(b, r, c-1))
			trieGetWord(b, r, c-1, valid, str, check, trie, cur);
		if(inBounds(b, r, c+1))
			trieGetWord(b, r, c+1, valid, str, check, trie, cur);
		
		if(inBounds(b, r-1, c-1))
			trieGetWord(b, r-1, c-1, valid, str, check, trie, cur);
		if(inBounds(b, r-1, c))
			trieGetWord(b, r-1, c, valid, str, check, trie, cur);
		if(inBounds(b, r-1, c+1))
			trieGetWord(b, r-1, c+1, valid, str, check, trie, cur);
		check[r][c] = false;
	}
	
	/**
	 * Determines if a row, column coordinate is in bounds
	 * @param b is the board
	 * @param r is the row
	 * @param c is the column
	 * @return true if it is in bounds, else false
	 */
	private boolean inBounds(BoggleBoard b, int r, int c)
	{
		return r>=0 && c>=0 && r<b.rows() && c<b.cols();
	}

	// Returns the score of the given word if it is in the dictionary, zero otherwise.
	// (You can assume the word contains only the upper case letters A - Z.)
	public int scoreOf(String word)
	{
		int len = word.length();
		
		if(len<=2)
			return 0;
		else if(len==3 || len==4)
			return 1;
		else if(len==5)
			return 2;
		else if(len==6)
			return 3;
		else if(len==7)
			return 5;
		else
			return 11;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("WORKING");

		final String PATH   = "./data/";
		BoggleBoard  board  = new BoggleBoard(PATH + "board-q.txt");
		BoggleSolver solver = new BoggleSolver(PATH + "dictionary-algs4.txt");

		int totalPoints = 0;

		for (String s : solver.getAllValidWords(board)) {
			System.out.println(s + ", points = " + solver.scoreOf(s));
			totalPoints += solver.scoreOf(s);
		}

		System.out.println("Score = " + totalPoints); //should print 84

		//new BoggleGame(4, 4);
	}

}
