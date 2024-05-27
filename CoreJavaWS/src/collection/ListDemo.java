package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		List numbers = new ArrayList();
		numbers.add(10);
		numbers.add("hello");
		numbers.add('2');
		numbers.add(true);
		numbers.add(10);
		System.out.println(numbers);
		System.out.println(numbers.size());
		numbers.add(20);
		System.out.println(numbers.size());
		numbers.remove("hello");
		System.out.println(numbers.size());
		for(int i=0;i<numbers.size();i++)
		{
			System.out.println(numbers.get(i));
		}

		numbers.forEach(value -> {
			System.out.println(value);
		});
		
		for(Object ob : numbers)
			System.out.println(ob);
		
		Iterator it = numbers.iterator();
		while(it.hasNext())
			System.out.println(it.next());
		
		//Collections.sort(numbers);
		
		List<String> colors = new ArrayList<>();
		colors.add("red");
		for(String s: colors)
			System.out.println(s);
		
		
		Collections.sort(colors);
	}

}
