

public class Tester
{
	public static void main(String args[])
	{
		// testing basic classes
		Person p1 = new Person("John");
		Person p2 = new Person("John");
		System.out.println("Should be true: " + p1.equals(p2));
		PhoneNumber n1 = new PhoneNumber("123-456-789");
		PhoneNumber n2 = new PhoneNumber("123-456-789");
		System.out.println("Should be true: " + n1.equals(n2));
		System.out.println();
		
		// testing basic methods on John test case
		PhoneBook test = new PhoneBook(10);
		test.put(p1, n1);
		System.out.println("Should be 123-456-789: " + 
							test.put(p2, new PhoneNumber("987-654-321")));
		System.out.println("Should be 1: " + test.size());
		System.out.println("Should be 987-654-321: " + test.get(p1));
		
		// testing filling the map with several items
		test.put(new Person("Joe"), new PhoneNumber("214-214-214"));
		test.put(new Person("Sally"), new PhoneNumber("279-279-279"));
		test.put(new Person("Ravi"), new PhoneNumber("469-469-111"));
		test.put(new Person("Randy"), new PhoneNumber("232-232-2322"));
		test.put(new Person("Vincent"), new PhoneNumber("888-888-8888"));
		test.put(new Person("Stites"), new PhoneNumber("421-70"));
		test.put(new Person("Ravi"), new PhoneNumber("469-469-469")); // override
		test.put(new Person("Stites"), new PhoneNumber("420-69")); //override
		test.put(new Person("Sally"), new PhoneNumber("972-972-972")); // override
		System.out.println("Should be 420-69: " + test.get(new Person("Stites")));
		System.out.println("Should be 7: " + test.size());
		System.out.println("\n");
		System.out.println(test);
		
		// testing the delete
		System.out.println("Should be 232-232-2322: " + 
							test.remove(new Person("Randy"))); // solo
		System.out.println("Should be 469-469-469: " + 
							test.remove(new Person("Ravi"))); // middle
		test.remove(new Person("Stites")); //end
		test.remove(new Person("Sally")); // start
		System.out.println("Should be 3: " + test.size());
		
		System.out.println("\n" + test);
		
	}
}