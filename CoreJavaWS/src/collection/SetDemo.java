package collection;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		set.add(10);
		set.add(20);
		set.add(30);
		set.add(10);
		set.add(40);
		set.add(100);
		set.add(240);
		set.add(130);
		set.add(1780);
		set.add(43450);
		System.out.println(set.toString());
		
		for(Integer ob:set) {
			
		}
		Set<Integer> treeset = new TreeSet<>();
		treeset.add(10);
		treeset.add(20);
		treeset.add(30);
		treeset.add(10);
		treeset.add(40);
		treeset.add(100);
		treeset.add(240);
		treeset.add(130);
		treeset.add(1780);
		treeset.add(43450);
		System.out.println(treeset.toString());
		
		for(Integer ob:treeset) {
			System.out.println(ob);
		}
	}

}
