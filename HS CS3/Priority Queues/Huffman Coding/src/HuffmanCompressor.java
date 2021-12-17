import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HuffmanCompressor
{
	/**
	 * Compresses a given file using a Huffman Tree.
	 * It creates a .code file so the file can be decoded and a .short file which
	 * is the encoded file. 
	 * @param fileName is the name of the file to encode
	 * @throws FileNotFoundException
	 */
	public static void compress(String fileName) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File(fileName));
		
		int[] count = new int[256];
		while(file.hasNextLine())
		{
			String line = file.nextLine();
			for(int i=0; i<line.length(); i++)
			{
				count[line.charAt(i)]++;
			}
			if(file.hasNext())
				count[10]++;
		}
		HuffmanTree tree = new HuffmanTree(count);
		
		String prefix = fileName.substring(0, fileName.indexOf("."));
		tree.write(prefix+".code");
		tree.encode(new BitOutputStream(prefix+".short"), fileName);
	}
	
	/**
	 * Expands a given file using a HuffmanTree by decoding it.
	 * Creates a .new file containing the decoded data
	 * @param codeFile is the name of the .code file to recreate the tree
	 * @param fileName is the file name to write to (will create a .new file)
	 * @throws FileNotFoundException
	 */
	public static void expand(String codeFile, String fileName) throws FileNotFoundException
	{
		String prefix = fileName.substring(0, fileName.indexOf("."));
		HuffmanTree tree = new HuffmanTree(codeFile);
		tree.decode(new BitInputStream(prefix+".short"), prefix+".new");
	}
}
