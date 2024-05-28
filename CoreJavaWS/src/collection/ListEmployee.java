package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class EmpNameComparator implements Comparator<Employee>{
	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		int c = o1.getCity().compareTo(o2.getCity());
		if(c==0)
			c = o1.getName().compareTo(o2.getName());
		return c;
	}
	
}

class GenericsType<T>{
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
	
}

public class ListEmployee {
	//Java Generic Method
		public static <T> boolean isEqual(GenericsType<T> g1, GenericsType<T> g2){
			return g1.getT().equals(g2.getT());
		}

	public static void main(String[] args) {
		
		GenericsType<String> g1 = new GenericsType<>();
		g1.setT("Pankaj");
		
		GenericsType<String> g2 = new GenericsType<>();
		g2.setT("Pankaj");
		
		boolean isEqual = ListEmployee.<String>isEqual(g1, g2);
		//above statement can be written simply as
		isEqual = isEqual(g1, g2);
		//This feature, known as type inference, allows you to invoke a generic method as an ordinary method, without specifying a type between angle brackets.
		//Compiler will infer the type that is needed
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1, "Shalini", "Mumbai", 12131));
		employees.add(new Employee(3, "Mahesh", "Pune", 987876));
		employees.add(new Employee(2, "Prasad", "Delhi", 654657));
		employees.add(new Employee(5, "Akshay", "Chennai", 9890));
		employees.add(new Employee(4, "Riya", "Mumbai", 89797));
		
		
//		for(Employee emp :employees)
//			System.out.println(emp);
		
		//employees.forEach(emp-> System.out.println(emp));
		
//		System.out.println();
//		Collections.sort(employees);
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

//		System.out.println();
//		
//		Collections.sort(employees, new Comparator<Employee>(){
//			@Override
//			public int compare(Employee o1, Employee o2) {
//				// TODO Auto-generated method stub
//				return o1.getCity().compareTo(o2.getCity());
//			}
//		});
//		//employees.sort(null);
//		for(Employee emp :employees)
//			System.out.println(emp);
	}

}
