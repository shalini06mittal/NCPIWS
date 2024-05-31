package collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class GenericsDemo {

	public <T, R> R m2(T t){
		return null;	
	}
	public static <T> T f1(T x) {

		return x ;
	}
	// type erasure
	public static void m1(List<Number> list) {

		System.out.println("In m1");
		System.out.println(list);
		//list.add("hey");
		System.out.println(list);
	}
	static final Comparator<String> IGNORE_CASE_ORDER
	= new Comparator<String>() {
		public int compare(String s1, String s2) {
			return s1.compareTo(s2);
		}
	};
	public static void main(String[] args) {

		 SortedSet<String> s = new TreeSet<String>(IGNORE_CASE_ORDER);
	        for (String a : args) {
	            s.add(a);
	        }
	        System.out.println(s.size() + " distinct words: " + s);
		System.out.println(f1(10.5));
		System.out.println(f1(10));
		System.out.println(f1("askdahj"));

		List<Number> nos = new ArrayList<>(); //Arrays.asList(1,2,3,4,5,6);
		nos.add(1);
		nos.add(100);
		m1(nos);
		//		System.out.println();
		//		System.out.println(nos);
	}
}
class Account{}
class GC<T>{
	public void m1(T t) {

	}
	public <Z> void m2(Z u) {

	}
}
