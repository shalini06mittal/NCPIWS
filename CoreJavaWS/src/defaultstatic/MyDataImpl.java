package defaultstatic;

public class MyDataImpl implements MyData{
	@Override
	public void print(String str) {
		// TODO Auto-generated method stub
		MyData.super.print(str);
	}
	
	 boolean isNull(String str) {
		System.out.println("Class Null Check");
		return MyData.isNull(str);
				//str==null ? true : "".equals(str) ? true: false;
	}
	
	public static void main(String[] args) {
		MyData obj = new MyDataImpl();
		obj.print("abc");
//		obj.isNull("");
	}
	
}
