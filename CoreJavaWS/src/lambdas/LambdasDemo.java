package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LambdasDemo {
	
	public static void main(String[] args) {
		
		/**
		 * ()->{
		 * Processing
		 * 
		 * return <value>
		 * }
		 */
		NotificationAlert na = new NotificationAlert() {
			
			@Override
			public void notifyMessage() {
				System.out.println("Notify via whatsapp");
				
			}
		};
		na.notifyMessage();
		
		 na = ()->{
			System.out.println("Notifying via email");
			//return 10;
		};
		na.notifyMessage();
		
//		NotificationAlert1 na1 = (String message)-> {
//			System.out.println(message.toUpperCase());
//		};
		NotificationAlert1 na1 = (name,message)-> System.out.println(message.toUpperCase());
		na1.notifyMessage("a","Delivered");
		NotificationAlert2 na21 = msg -> msg.length()>0;
		
		NotificationAlert2 na2 = msg -> {
			return msg.length()>0;
		};
		
		boolean res = na2.notifyMessage("");
	}

}
