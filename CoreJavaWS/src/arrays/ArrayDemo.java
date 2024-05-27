package arrays;

public class ArrayDemo {

	public static void main(String[] args) {
		int a[];
		a = new int[10];
		a[0] = 1;
		
		int b[] = {1,2,3,4,5};
		System.out.println(b);
		int x[] = b;
		
		char c[] = {'a','e','i','o','u'}; 
		System.out.println(c);
		
		
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
		
		// Print the average of each player
		for (int i = 0; i < scores.length; i++) {
			double sum = 0;
			for (int j = 0; j < scores[i].length; j++) {
				sum += scores[i][j];
			}
			double avg = sum/scores[i].length;
			System.out.println("Average for player "+(i+1)+" "+avg);
		}
	}

}
