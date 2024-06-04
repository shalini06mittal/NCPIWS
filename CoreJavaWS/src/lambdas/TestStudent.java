package lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;


interface Tester{
	public <T> boolean test(T t);
}
public class TestStudent {

	public static void printSpecialization(List<Student> list, Predicate<Student> predicate) {
		for(Student student:list)
			if(predicate.test(student))
				System.out.println(student);
	}
	
	public static void printDetails(List<Student> list, Consumer<Student> consumer) {
		for(Student student:list)
			consumer.accept(student);
	}
	public static List<String> getNames(List<Student> list, Function<Student, String> function) {
		List<String> names = new ArrayList<>();
		for(Student student:list)
		{
			String name = function.apply(student);
			names.add(name);
		}
		return names;
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
		
		//1. stream of data to process -> stream do not store data
		
//		Stream<Student>  stream = listofstudents.stream();
		
		// intermediate
//		Stream<Student>  filteredstream = stream.filter(
//				student -> {
//					System.out.println("in filter "+student.getName());
//					return student.getSpecialization().equals("Mathematics");
//					}
//			);
		//terminal
//		filteredstream.forEach(student -> 
//				System.out.println("for each "+student.getName()+" "+student.getPercentage()));
//		
//		listofstudents.stream()
//		.filter(student -> student.getSpecialization().equals(""))
//		.forEach(student -> 
//		System.out.println("for each "+student.getName()+" "+student.getPercentage()));
		//.forEach(System.out::println);
		
		
		// 1 . stream
		
		Stream<Student>  stream = listofstudents.stream();
		
		//2. get the student object with names in uppercase 
		Stream<Student> mapStudent = stream.map(student -> {
			student.setName(student.getName().toUpperCase());
			return student; 
		});
		//3. comsume
		mapStudent
		.filter(student -> student.getSpecialization().equals("Computer"))
		.forEach(student -> 
		System.out.println(student));
		
		
//		printSpecialization(listofstudents, student -> student.getSpecialization().equals("Mathematics"));
//		printDetails(listofstudents, student -> 
//						System.out.println(student.getName()+" "+student.getPercentage()));
//		getNames(listofstudents, student -> student.getName());
	}

}
