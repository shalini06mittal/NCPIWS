package lambdas;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;

public class FunctionDemo {

	public static void notifies(NotificationAlert na) {
		na.notifyMessage();
	}
	public static void m1(int no, Function<Integer, Integer> na) {
		System.out.println(na.apply(no));
	}
	public static void main(String[] args) {
		
//		notifies(new NotificationAlert() {
//			
//			@Override
//			public void notifyMessage() {
//				// TODO Auto-generated method stub
//				
//			}
//		});
//		notifies(()->System.out.println("hey!!"));
		
		m1(10, n->n*n);
		
		new BiFunction<Integer, Double, Boolean>() {

			@Override
			public Boolean apply(Integer t, Double u) {
				// TODO Auto-generated method stub
				return null;
			}

			
		};
	
		

	}

}
