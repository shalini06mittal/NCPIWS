package lambdas;
@FunctionalInterface
public interface NotificationAlert {
	public void notifyMessage();
	default int m1(int x) {
		return 0;
	}
}

interface NotificationAlert1 {
	public void notifyMessage(String name, String message);
	
}
interface NotificationAlert2 {
	public boolean notifyMessage(String message);
	
}
