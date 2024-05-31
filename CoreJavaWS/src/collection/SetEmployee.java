package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class SetEmployee {
	
	public static void main(String[] args) {
		int n=1;
		for(;n>0;n++);
		System.out.println(n);
		/**
		 * Create a list of names
		 * Create a map with name from list as key and value the
		 * number of times name appears in list
		 * 
		 */
		Set<Employee> employees = new TreeSet<>();
		employees.add(new Employee(1, "Shalini", "Mumbai", 12131));
		employees.add(new Employee(3, "Mahesh", "Pune", 987876));
		employees.add(new Employee(2, "Prasad", "Delhi", 654657));
		employees.add(new Employee(5, "Akshay", "Chennai", 9890));
		employees.add(new Employee(4, "Riya", "Mumbai", 89797));
		for(Employee emp:employees)
			System.out.println(emp);
	
	}

}
