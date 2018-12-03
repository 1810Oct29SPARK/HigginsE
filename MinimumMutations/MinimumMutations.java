package com.revature.MinimumMutations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinimumMutations {
	public MinimumMutations() {
		
	}
	/*Minimum Mutations!

	A gene string can be represented by an 8-character long string, with 
	choices from "A", "C", "G", "T".

	Suppose we need to investigate about a mutation (mutation from "start" 
	to "end"), where ONE mutation is defined as ONE single character changed 
	in the gene string.

	For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.

	Also, there is a given gene "bank", which records all the valid gene 
	mutations. A gene must be in the bank to make it a valid gene string.

	Now, given 3 things - start, end, bank, your task is to determine what 
	is the minimum number of mutations needed to mutate from "start" to 
	"end".
	If there is no such a mutation, return -1.
	If the start and end string are the same, return 0.

	Example:

	start: "AACCGGTT"
	end:   "AAACGGTA"
	bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]

	return: 2

	Note:
		Starting point is assumed to be valid, so it might not be 
	included in the bank.
		If multiple mutations are needed, all mutations during in the 
	sequence must be valid.

	Organize your solution into a driver class (with a main method) and 
	utility class containing the logical implementation.
	Points will be docked for code that's too tightly coupled.
	The starting and ending sequences and mutation bank may be (in 
	descending order of points awarded) read from a file, input through the 
	console, or hardcoded in the driver class. 


	REFERENCE:

	Reading/writing to/from files in Java, you will need to use a 
	FileInputStream passed to an ObjectInputStream. 

	Submit your solution in this folder on your branch as .java files (if 
	you wrote your solution in Eclipse/STS, make sure no compiled .class 
	files or project metadata make their way up to GitHub.*/
	
	public int checkMutations(String start, String end, String[] bank) {
		int count = 0;
		//if the start or end length is not 8, return -1
		if(start.length() != 8 || end.length() != 8) {
			return -1;
		}else if(start.equals(end)) { //if start gene = end gene at the start, return 0
			return 0;
		}else {
				//iterate through each string in the string array "bank"
				for(int k = 0; k < bank.length; k++) {
					//once the start string equals the end string, break out of the loop
					if(start.equals(end)) {
						break;
					}
					//ensure each bank string only contains AGTC
					bank[k] = bank[k].replaceAll("[^AGTC]", "");
					//if the length of that string after replacing character is not 8, break
					if(bank[k].length() != 8) {
						break;
					}
					int count2 = 0;
					int count3 = 0;
					//iterate through each character of the current bank string
					for(int l = 0; l < bank[k].length(); l++) {
						//if the char in bank is the same as the end, but not start, that means it needs to change and add 1 to count2
						if(bank[k].charAt(l) == end.charAt(l) && bank[k].charAt(l) != start.charAt(l)) {
							count2++;							
						}//if the banks char is the same as the start char, it doesn't need to change and add one to count3
						if(bank[k].charAt(l) == start.charAt(l)) {
							count3++;
						}
					}
					//to ensure only 1 char was changed between start and this bank entry
					if(count2 == 1 && count3 == 7) {
						start = bank[k];
						count++;
						k = -1;
					}
				}
		}
		//After the previous iteration, ensure that start now equals end, if not print out and error
		if(start.equals(end)) {
			return count;
		}else {
			System.out.println("end string was not found in the bank or invalid bank entry");
			return -1;
		}
	}
	
	public void readFromFile(File filename) throws FileNotFoundException {
		//create a new scanner that scans "filename"
		boolean checker = true;
		Scanner scan = new Scanner(filename);
		List<String> input =  new ArrayList<String>();
		//iterate through each line of filename and add it to the ArrayList of strings
		while(scan.hasNextLine()) {
			input.add(scan.nextLine());
		}
		scan.close();
		String start = input.get(0);
		String end = input.get(1);
		String[] geneBank = input.get(2).split(" ");
		for(int i = 0; i < geneBank.length; i++) {
			if(geneBank[i].length() != 8) {
				checker = false;
			}
		}
		if(checker) {
			System.out.println(checkMutations(start, end, geneBank));
		}else {
			System.out.println("One or more bank entries was invalid");
		}
	}
}
