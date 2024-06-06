package methodref;

public class Person {

	String firstName;
	String lastName;

	Person() {
		System.out.println("Person def");
	}

	Person(String firstName) {
		this.firstName = firstName;
		System.out.println("Person 1 param");
		
	}
	Person(String firstName, String lastName) {
		this.firstName = firstName;
		System.out.println("Person 2 param");
		this.lastName = lastName;
	}

	public static void entered( final Person person ) {
		System.out.println( "Entered " + person.toString() );
	}

	public void followed( final Person another ) {
		System.out.println(this.toString()+ " \nFollowing the\n " + another.toString() );
	}

	public void exited() {  
		System.out.println( "Exited " + this.toString() );
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return firstName+" : "+lastName;
	}
}
