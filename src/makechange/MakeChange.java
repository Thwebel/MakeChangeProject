package makechange;

import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		double price = 0.0, paid = 0.0, owedBack = 0.0;

		int $twentyD = 0, $tenD = 0, $fiveD = 0, $oneD = 0, $quarter = 0, $dime = 0, $nickle = 0,
				$penny = 0;
		
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

		owedBack = paid - price;

		if (owedBack == 0) {
			System.out.println("Thanks for exact change!");
		}
		System.out.printf("I owe you: $%.2f\n", owedBack);
		owedBack *= 100;
		owedBack = (int)(owedBack);
		System.out.println(owedBack);
		if (owedBack > 2000) {
			$twentyD = (int) (owedBack / 2000);
			owedBack %= 2000;
		}
		if (owedBack >= 1000) {
			$tenD = (int) (owedBack / 1000);
			owedBack %= 1000;
		}
		if (owedBack >= 500) {
			$fiveD = (int) (owedBack / 500);
			owedBack %= 500;
		}
		if (owedBack >= 100) {
			$oneD = (int) (owedBack / 100);
			owedBack %= 100;
		}
		if (owedBack >= 25) {
			$quarter = (int) (owedBack / 25);
			owedBack %= 25;
		}
		if (owedBack >= 10) {
			$dime = (int) (owedBack / 10);
			owedBack %= 10;
		}
		if (owedBack >= 5) {
			$nickle = (int) (owedBack / 5);
			owedBack %= 5;
		}
		if (owedBack >= 1) {
 			$penny = (int) (owedBack / 1);
			owedBack %= 1;
		}
//		Easy Check of every vars at end:
		System.out.println("cost: " + price + ", paid: " + paid);
		System.out.println("20s: " + $twentyD + ", 10s: " + $tenD + ", 5s: " + $fiveD + ", 1s: " + $oneD
				+ ",\n quarters: " + $quarter + ", dimes: " + $dime + ", nickles: " + $nickle + ", penny: " + $penny);
		System.out.println(owedBack);
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
 * Amount: .67, Tendered: .50, Result: Error message Amount: .67, Tendered:
 * 1.00, Result: 1 quarter, 1 nickel, 3 pennies. Amount: .59, Tendered: 1.00,
 * Result: 1 quarter, 1 dime, 1 nickel, 1 penny. Amount: 3.96, Tendered: 20.00,
 * Result: 1 ten dollar bill, 1 five dollar bill, 1 one dollar bill, 4 pennies.
 * Amount: any amount less than 20.00, Tendered: anything greater than amount:
 * correct denominations for correct change.
 */
