package com.revature.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Mutations {
	
	public static void main(String[] args) {
		//setting the driver
		int ans = minMutation();
		System.out.println(ans);

	}
	
	//things to consider for the future: dynamic bank, limit string input, fileIO
	

	public static int minMutation() throws FileNotFoundException {

		// scanner input, assuming the same number of characters for start and end
		Scanner scan = new Scanner(System.in);

		String str = "";
		System.out.print("start: ");
		str = scan.nextLine();

		String ed = "";
		System.out.print("end: ");
		ed = scan.nextLine();

		//giving the gene bank, i know i need to rework this better ):
		String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
		System.out.println("bank: " +bank);

		// verifying the end is a proper gene in the bank, default is false
		boolean inBank = false;

		// this loop checks if the the end is in the bank
		for (int i = 0; i < bank.length; i++) {
			if (bank[i].equals(ed)) {
				//changes boolean to true
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
			//using a counter to keep up with mutation number
			int count = 0;
			for (int i = 0; i < str.length(); i++) {
				//comparing the chars at indexs, if they are not equal
				if (str.charAt(i) != ed.charAt(i)) {
					//then add to the counter
					count++;
				}
			}
			return count;

		}
		
		//fileio practice
		  File textFile = new File("mutationstart.txt");
		  try (Scanner scanner = new Scanner(textFile)) {
		

	}

}
