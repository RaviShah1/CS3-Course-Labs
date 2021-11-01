import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.File;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //run methods in numerical order
public class WhitePagesTester {

	static PhoneBook book;
	static Set<String> uniqueNames;
	
	@BeforeClass
	public static void setUp() throws FileNotFoundException 
	{
		 book = new PhoneBook();
		 uniqueNames = new TreeSet<String>();
		 
		 Scanner file = new Scanner(new File("White Pages.txt")); // file
		// populate
		while(file.hasNextLine())
		{
			String[] line = file.nextLine().trim().split(",");
			book.put(new Person(line[0] + " " + line[1]), new PhoneNumber(line[2]));
			uniqueNames.add(line[0] + " " + line[1]);
		}
		
	}
	
	@Test
	public void test01_sizeTest1() 
	{
		assertTrue(book.size() == uniqueNames.size());
	}
	
	@Test
	public void test02_getTest1() 
	{
		assertEquals(book.get(new Person("Tiphanie Cossor")), (new PhoneNumber("776-938-4664")));
	}
	
	@Test
	public void test03_removeTest1() 
	{
		Person p = new Person("Ralph Kinder");
		PhoneNumber n = new PhoneNumber("910-455-3553");
		PhoneNumber rem = book.remove(p);
		PhoneNumber none = book.get(p);
		assertTrue(n.equals(rem) && none == null);
	}
	
	@Test
	public void test04_sizeTest2() 
	{
		//tests size after Ralph is gone 
		assertTrue(book.size() == uniqueNames.size()-1);
	}
	
	@Test
	public void test05_allMethodTest1() 
	{
		Person ravi = new Person("Ravi Shah");
		PhoneNumber num = new PhoneNumber("111-111-1111");
		book.put(ravi, num);
		
		PhoneNumber num2 = new PhoneNumber("469-992-9195");
		PhoneNumber wrongNum = book.put(ravi, num2);
		
		PhoneNumber rightNum = book.get(ravi);
		
		PhoneNumber rem = book.remove(ravi);
		PhoneNumber none = book.get(ravi);
		int size = book.size();
		
		assertTrue(wrongNum.equals(num) && rightNum.equals(num2) && rem.equals(num2) && none==null && size==uniqueNames.size()-1);
	}
	
	/*
	public static void main(String args[]) throws FileNotFoundException
	{
		PhoneBook b = new PhoneBook();
		 
		 Scanner file = new Scanner(new File("White Pages.txt")); // file
		// populate
		while(file.hasNextLine())
		{
			String[] line = file.nextLine().trim().split(",");
			b.put(new Person(line[0] + " " + line[1]), new PhoneNumber(line[2]));
		}
		
		System.out.println(b);
	}
	*/

}
