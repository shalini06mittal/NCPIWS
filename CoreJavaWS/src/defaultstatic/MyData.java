package defaultstatic;

public interface MyData {
	
	default void print(String str) {
		if(!isNull(str)) {
			System.out.println("My Data "+str);
		}
	}
	static boolean isNull(String str) {
		System.out.println("Interface Null Check");
		return str==null ? true : "".equals(str) ? true: false;
	}
}
