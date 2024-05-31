package lambdas;

public class LambdasDemo {

	public static void main(String[] args) {
		if(true)
		
			System.out.println();
		
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

	}

}
