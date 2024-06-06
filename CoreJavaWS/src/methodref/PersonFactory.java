package methodref;

@FunctionalInterface
//specify a person factory interface to be used for creating new persons:
interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
   
}