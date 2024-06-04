package lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class TestStudent {

	public static void printSpecialization(List<Student> list, Predicate<Student> predicate) {
		for(Student student:list)
			if(predicate.test(student))
				System.out.println(student);
	}
	public static void main(String[] args) {
		
		List<Student> listofstudents  = new ArrayList<>();
		listofstudents.add(new Student(111,"John",81.0,"Mathematics"));
		listofstudents.add(new Student(222,"Harsha",79.5,"History"));
		listofstudents.add(new Student(333,"Ruth",87.2,"Computer"));
		listofstudents.add(new Student(444,"Aroma",63.2,"Mathematics"));
		listofstudents.add(new Student(555,"Zade",83.5,"Computer"));
		listofstudents.add(new Student(666,"Xing",58.5,"Geography"));
		listofstudents.add(new Student(777,"Richards",72.6,"Banking"));
		listofstudents.add(new Student(888,"Sunil",86.7,"History"));
		listofstudents.add(new Student(999,"Jordan",58.6,"Finance"));
		listofstudents.add(new Student(1010,"Chris",89.8,"Computer"));
		
		printSpecialization(listofstudents, student -> student.getSpecialization().equals("Mathematics"));
		

	}

}
