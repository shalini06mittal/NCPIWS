package labs;

import java.util.Arrays;
import java.util.Scanner;

/**
take input amount of 5 invoices
add all the invoices whose value is greater than 1000 
and print the sum of these invoices 
ex: 120 1200 3000 400 5000 
1200+3000+5000 = 9200 

 * @author Shalini
 *
 */
class Brand{
	private int id;
	private String brandname;
	
	public Brand() {
		// TODO Auto-generated constructor stub
	}

	public Brand(int id, String brandname) {
		super();
		this.id = id;
		this.brandname = brandname;
	}
	
}
public class Invoice {

	public static void main(String[] args) {

        
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for(int count=1; count<=5;count++) {
			System.out.println("Enter amount for invoice "+count);
			System.out.println();
			int i1 = sc.nextInt();

		}
		sc.close();

	}

}
