package lambdas;
@FunctionalInterface
public interface NotificationAlert {
	public void notifyMessage();
	default int m1(int x) {
		return 0;
	}
}

