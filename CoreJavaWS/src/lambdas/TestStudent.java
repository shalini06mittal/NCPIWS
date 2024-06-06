package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
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
		System.out.println();
		//		for(Student s:listofstudents.stream().sorted(
		//				Comparator.comparing(Student::getSpecialization).thenComparing(Student::getName))
		//		.collect(Collectors.toList()))
		//			System.out.println(s.getSpecialization()+" "+s.getName());
		//Collectors.groupingBy(Student::getSpecialization, Collectors.counting()))
		//	);

		User user1 = new User(1, "Shalini", "Pune","Maharastra"); 
		User user2 = new User(2, "Siya", "Mumbai","Maharastra"); 
		User user3 = new User(3, "Asha", "Delhi","Delhi");
		User user4 = new User(4, "Akhil", "Pune","Maharastra"); 
		User user5 = new User(5, "Nikhil", "Mumbai","Maharastra");
		User user6 = new User(6, "Alok", "Bhopal","Madhya Pradesh");
		System.out.println();
		List<User> users= Arrays.asList(user1, user2, user3, user4, user5, user6);
		//	 	System.out.println(users.stream()
		//	 			.collect(Collectors.toMap(User::getState, Function.identity())));
		//	 	System.out.println();
		//	 	System.out.println(users.stream()
		//	 			.collect(Collectors.groupingBy(User::getState)));
		//	 	System.out.println();
		//	 	System.out.println(users.stream()
		//	 			.collect(Collectors.groupingBy(User::getState,
		//	 					Collectors.groupingBy(User::getCity))));
		//	 	
		//	 	List<User> sorteduserwithcity =users.stream()
		//	 			.sorted(Comparator.comparing(User::getCity))
		//	 			.collect(Collectors.toList()); 
		//	 	for(User user:sorteduserwithcity)
		//	 		System.out.println(user);
		//	 	;
		//	 	System.out.println();
		//	 	
		//	 	List<User> sorteduserwithcityandname =users.stream()
		//	 			.sorted(
		//	 					
		//	 					Comparator.comparing(User::getCity)
		//	 					.thenComparing(user -> user.getName()))
		//	 			.collect(Collectors.toList()); 
		//	 	for(User user:sorteduserwithcityandname)
		//	 		System.out.println(user);
		//	 	;


		//	 	System.out.println();
		//	 	Arrays.asList(1,2,3,4,5)
		//	 	.stream().flatMap(n->{
		//	 		
		//	 		return Arrays.asList(n-1,n,n+1).stream();
		//	 	})
		//	 	.forEach(System.out::println);


		String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"},{"x","a"}};

		// array to a stream
		Stream<String[]> stream1 = Arrays.stream(array);

		new IntFunction<String[]>() {

			@Override
			public String[] apply(int value) {
				// TODO Auto-generated method stub
				return null;
			}
		};

		
		String[] result = Stream.of(array)  // Stream<String[]>
		          .flatMap(data -> Stream.of(data))        // Stream<String>
		         // .toArray(String[]::new);    // [a, b, c, d, e, f]
		          .toArray(s-> {
		        	  System.out.println(s);
		        	  return new String[s];  
		          });
		  for (String s : result) 
		      System.out.println(s);

		  
		// x is a String[]
//		List<String[]> result = stream1
//				.filter(x -> {
//					for(String s : x){      // really?
//						System.out.println("filter "+s);
//						if(s.equals("a")){
//							return false;
//						}
//					}
//					return true;
//				}).collect(Collectors.toList());
//
//		// print array
//		result.forEach(x -> System.out.println(Arrays.toString(x)));

	}


}

class User { 
	private int userId; 
	private String name; 
	private String city;
	private String state;
	// getter, setter etc..
	public User(int userId, String name, String city,String state) {
		super();
		this.userId = userId;
		this.name = name;
		this.city = city;
		this.state = state;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", city=" + city + ", state=" + state + "]";
	}



}

