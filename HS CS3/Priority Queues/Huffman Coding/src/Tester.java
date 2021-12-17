import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Class to test the Huffman Tree 
 * @author Ravi Shah
 *
 */
public class Tester
{
	public static void main(String[] args) throws FileNotFoundException
	{
		/*
		 * Tests the tree using a mini hand made input
		 */
		int[] count = new int[256];

		count[121]=2;
		count[99]=1;
		count[120]=1;
		count[97]=3;
		count[98]=3;
		HuffmanTree tree = new HuffmanTree(count);
		
		TreePrinter.printTree(tree.root);

		System.out.println(tree.map);
		
		tree.write("bla.txt");
		
		tree = new HuffmanTree("bla.txt");
		TreePrinter.printTree(tree.root);
	
		/*
		 * Test encoding and decoding files using the Huffman Compressor class
		 */
		
		long startTime = System.currentTimeMillis();
//		HuffmanCompressor.compress("happy hip hop.txt");	
		HuffmanCompressor.compress("short.txt");			
//		HuffmanCompressor.compress("Hamlet.txt");
//		HuffmanCompressor.compress("War and Peace.txt");	
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
		
		startTime = System.currentTimeMillis();
//		HuffmanCompressor.expand("happy hip hop.code", "happy hip hop.short");
		HuffmanCompressor.expand("short.code", "short.short");	
//		HuffmanCompressor.expand("Hamlet.code", "Hamlet.short");
//		HuffmanCompressor.expand("War and Peace.code", "War and Peace.short");
		endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
	}

}
