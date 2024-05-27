package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class EmpNameComparator implements Comparator<Employee>{
	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o2.getName().compareTo(o1.getName());
	}
	
}


public class ListEmployee {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1, "Shalini", "Mumbai", 12131));
		employees.add(new Employee(3, "Mahesh", "Pune", 987876));
		employees.add(new Employee(2, "Prasad", "Delhi", 654657));
		employees.add(new Employee(5, "Akshay", "Chennai", 9890));
		employees.add(new Employee(4, "Riya", "Mumbai", 89797));
		
		
		for(Employee emp :employees)
			System.out.println(emp);
		
		//employees.forEach(emp-> System.out.println(emp));
		
		System.out.println();
		Collections.sort(employees);
		//employees.sort(null);
		for(Employee emp :employees)
			System.out.println(emp);
		
		System.out.println();
		
		Comparator<Employee> comparator = new EmpNameComparator();
		
		Collections.sort(employees, comparator);
		//employees.sort(null);
		for(Employee emp :employees)
			System.out.println(emp);
		
		// anonynous inner class
		
		// providing the implementationof the Comparator interface
//		comparator = new Comparator<Employee>(){
//			@Override
//			public int compare(Employee o1, Employee o2) {
//				// TODO Auto-generated method stub
//				return o1.getCity().compareTo(o2.getCity());
//			}
//		};

		System.out.println();
		
		Collections.sort(employees, new Comparator<Employee>(){
			@Override
			public int compare(Employee o1, Employee o2) {
				// TODO Auto-generated method stub
				return o1.getCity().compareTo(o2.getCity());
			}
		});
		//employees.sort(null);
		for(Employee emp :employees)
			System.out.println(emp);
	}

}
