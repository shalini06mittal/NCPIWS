package arrays;

public class ArrayDemo {

	public static void main(String[] args) {
		int a[];
		a = new int[10];
		a[0] = 1;
		
		int b[] = new int[10];
		
		char c[] = {'a','e','i','o','u'}; 
		
		/**
		 * st1[]
		 * st2[]
		 * st3[]
		 * 
		 * 
		 */
		
//		int scores[][] = new int[10][];// jagged array
//		System.out.println(scores.length);
//		scores[0] = new int[5];
//		System.out.println(scores[0].length);
//		int pop[][] = {
//				{},
//				{},
//				{}
//		};
		
		int scores[][] = {
				{11,2,31,4},
				{50,6,17,81},
				{190,100,11,123}
		};
		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < scores[i].length; j++) {
				System.out.print(scores[i][j]+" ");
			}
			System.out.println();
		}

	}

}
