import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class BoardChallenges
{

	/**
	 * Calculates the score a a board
	 * @param boardName is the file name of the board
	 * @param dictionaryName is the dictionary file name
	 * @return the score
	 * @throws FileNotFoundException
	 */
	public static int calculateBoardScore(String boardName, String dictionaryName) throws FileNotFoundException
	{		
		final String PATH   = "./data/";
		BoggleBoard  board  = new BoggleBoard(PATH + boardName);
		BoggleSolver solver = new BoggleSolver(PATH + dictionaryName);

		int count = 0;

		for (String s : solver.getAllValidWords(board)) 
			count += solver.scoreOf(s);

		return count;
	}
	
	/**
	 * Calculates the score a a board 
	 * @param board is the board
	 * @param dictionaryName is the dictionary file name
	 * @return the score
	 * @throws FileNotFoundException
	 */
	public static int calculateBoardScore(BoggleBoard board, String dictionaryName) throws FileNotFoundException
	{		
		final String PATH   = "./data/";
		//BoggleBoard  board  = new BoggleBoard(boardMat);
		BoggleSolver solver = new BoggleSolver(PATH + dictionaryName);

		int count = 0;

		for (String s : solver.getAllValidWords(board)) 
			count += solver.scoreOf(s);

		return count;
	}

	
	public static void main(String[] args) throws FileNotFoundException
	{
		//System.out.println(calculateBoardScore("board-q.txt", "dictionary-algs4.txt"));

		/*
		 * 100 x 100 speed and score test
		 */
		long startTime = System.currentTimeMillis();
		BoggleBoard b = new BoggleBoard(100, 100);
		System.out.println(calculateBoardScore(b, "dictionary-yawl.txt"));
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		
	}

}
