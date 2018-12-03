package mutations;

import java.util.Scanner;

public class MinimumMutations extends Mutations{

	public static void main(String[] args) {
		String str1 = "";
		String str2 = "";
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a starting 8 character long gene string (only A, C, G, and T): ");
		str1 = scan.nextLine();
		System.out.println("Please enter a ending 8 character long gene string (only A, C, G, and T): ");
		str2 = scan.nextLine();
		System.out.println(numOfMutations(str1, str2));
	}
	
}
