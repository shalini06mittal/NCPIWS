package methodref;

import java.time.LocalDate;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

class Something {
	String startsWith(String s) {
		return String.valueOf(s.charAt(0));
	}
}

public class MethodRefDemo {

	public static void main(String[] args) {
		
		Supplier<Integer> supp = () -> 10;
		// Constructor
		String s1 = "Shalini";
		String s2 ="Mittal";
		Supplier<Person> persupp = ()-> new Person(s1,s2);
		Supplier<Person> persupp1= Person::new;
		
		System.out.println(persupp1.get());
		Function<String, Person> f1 = Person::new;
		System.out.println(f1.apply("Hey"));
		
		BiFunction<String, String, Person> bf1 = Person::new;
		System.out.println(bf1.apply("Hey","There"));
		
		// static method reference
		Supplier<LocalDate> date = LocalDate::now;
		System.out.println(date.get());
		
		//Consumer<Person> con = person -> Person.entered(person);
		Consumer<Person> con = Person::entered;
		con.accept(new Person("A","B"));
		
		// instance method with an object of a class
		Person p1 = new Person("a", "b");
		Person p22 = new Person("c", "d");
		p1.followed(p22);
		
//		Consumer<Person> f1 = p2 -> p22.followed(p2);
//		f1.accept(p22);
		System.out.println();
		Consumer<Person> f = p22::followed;
		f.accept(p1);
		
		// instance method with arbitrary object
//		Consumer<Person> cc = person -> person.exited();
		Consumer<Person> cc = Person::exited;
		
		cc.accept(new Person("Shalini"));
	}

}
