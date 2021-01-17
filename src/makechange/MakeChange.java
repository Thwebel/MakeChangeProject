package makechange;

import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		double price = 0.0, paid = 0.0, owedBack = 0.0;

		int $twentyD = 0, $tenD = 0, $fiveD = 0, $oneD = 0, $quarter = 0, $dime = 0, $nickle = 0,
				$penny = 0, owedBackInt = 0;
		
		boolean hasPaid = false;

		while (!hasPaid) {
			System.out.print("What is the cost of your Item: ");
			price = kb.nextDouble();
			kb.nextLine();

			System.out.print("\nHow much money did you give?: ");
			paid = kb.nextDouble();
			kb.nextLine();
			hasPaid = checkPayment(paid, price);

		}

		owedBack = (paid - price) + 0.001;
		System.out.println(owedBack);

		if (owedBack == 0) {
			System.out.println("Thanks for exact change!");
		}
		System.out.printf("I owe you: $%.2f\n", owedBack);
		
		
		owedBack *= 100;
//		System.out.println(owedBack);
		owedBackInt = (int)(owedBack);
//		System.out.println(owedBackInt);
		
		if (owedBackInt > 2000) {
			$twentyD =  owedBackInt / 2000;
			owedBackInt %= 2000;
		}
		if (owedBackInt >= 1000) {
			$tenD = owedBackInt / 1000;
			owedBackInt %= 1000;
		}
		if (owedBackInt >= 500) {
			$fiveD = owedBackInt / 500;
			owedBackInt %= 500;
		}
		if (owedBackInt >= 100) {
			$oneD = owedBackInt / 100;
			owedBackInt %= 100;
		}
		if (owedBackInt >= 25) {
			$quarter = owedBackInt / 25;
			owedBackInt %= 25;
		}
		if (owedBackInt >= 10) {
			$dime = owedBackInt / 10;
			owedBackInt %= 10;
		}
		if (owedBackInt >= 5) {
			$nickle = owedBackInt / 5;
			owedBackInt %= 5;
		}
		if (owedBackInt >= 1) {
 			$penny = owedBackInt / 1;
			owedBackInt %= 1;
		}
//		Easy Check of every vars at end:
		System.out.println("cost: " + price + ", paid: " + paid);
		System.out.println("twenties: " + $twentyD + ", tens: " + $tenD + ", fives: " + $fiveD + ", ones: " + $oneD
				+ ",\nquarters: " + $quarter + ", dimes: " + $dime + ", nickles: " + $nickle + ", penny: " + $penny);
		System.out.println(owedBackInt);
		kb.close();
	}

	public static boolean checkPayment(double paid, double price) {
		boolean hasPaid = false;
		if (paid < price) {
			System.out.printf("Hey buster, what are you trying to pull here. The cost is $%.2f, you only gave me $%.2f.%nEnter everything again %n", price, paid);
			hasPaid = false;
		} else {
			hasPaid = true;
		}
		return hasPaid;

	}
}

/**
 * Amount: .67, Tendered: .50,
 * Result: Error message 
 * 
 * Amount: .67, Tendered: 1.00, 
 * Result: 1 quarter, 1 nickel, 3 pennies. 
 * 
 * Amount: .59, Tendered: 1.00,
 * Result: 1 quarter, 1 dime, 1 nickel, 1 penny. 
 * 
 * Amount: 3.96, Tendered: 20.00,
 * Result: 1 ten dollar bill, 1 five dollar bill, 1 one dollar bill, 4 pennies.
 * 
 * Amount: any amount less than 20.00, Tendered: anything greater than amount:
 * 
 * correct denominations for correct change.
 */


















