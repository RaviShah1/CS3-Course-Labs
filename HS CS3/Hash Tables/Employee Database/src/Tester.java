import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tester
{
	public static void main(String args[]) throws FileNotFoundException
	{
		System.out.println("Linear");
		System.out.println("====================================");
		EmployeeDatabaseLinear db = new EmployeeDatabaseLinear();
		db.put(15, new Employee("Clancy"));
		db.put(31, new Employee("Wei"));
		db.put(35, new Employee("Waliany"));
		db.put(39, new Employee("Hale"));
		
		System.out.println(db);
		
		System.out.println("Should be Wei: " + db.get(31));
		System.out.println("Should be null: " + db.get(20));
		
		
		System.out.println("\nQuadratic");
		System.out.println("====================================");
		EmployeeDatabaseQuadratic db2 = new EmployeeDatabaseQuadratic();
		db2.put(9, new Employee("Clancy"));
		db2.put(19, new Employee("Wei"));
		db2.put(29, new Employee("Waliany"));
		db2.put(39, new Employee("Hale"));
		
		System.out.println(db2);
		
		System.out.println("Should be Wei: " + db2.get(19));
		System.out.println("Should be null: " + db2.get(20));
		
		
	}
}
