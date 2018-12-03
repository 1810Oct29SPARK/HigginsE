package com.revature.example;

import java.util.Scanner;

public class Mutations {
	
	public static void main(String[] args) {
		int ans = minMutation();
		System.out.println(ans);

	}

	public static int minMutation() {

		// scanner input, assuming the same number of characters for start and end
		// will give outofbounds if not
		Scanner scan = new Scanner(System.in);
		int input = 1;

		String str = "";
		System.out.print("start: ");
		str = scan.nextLine();

		String ed = "";
		System.out.print("end: ");
		ed = scan.nextLine();

		// setting a bank
		String[] bank = { "AACCGGTT", "AACCGGTA" };

		// verifying the end is a proper gene in the bank
		boolean inBank = false;

		// this loop checks if the the end is in the bank
		for (int i = 0; i < bank.length; i++) {
			if (bank[i].equals(ed)) {
				inBank = true;
			}
		}
		// went through bank, didn't find end in bank
		if (inBank == false) {
			return -1;

			// did find end in bank, compares start and end using a counter
			// character to character because of charAt
			// if it finds a difference, added to counter
		} else {
			int count = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) != ed.charAt(i)) {
					count++;
				}
			}
			return count;

		}

	}

}
