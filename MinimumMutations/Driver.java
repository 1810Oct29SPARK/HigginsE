package com.revature.MinimumMutations;

import java.io.File;
import java.io.FileNotFoundException;

public class Driver {

	public static void main(String[] args) throws FileNotFoundException {
		MinimumMutations mutate = new MinimumMutations();
		//Hardcoded version
		String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
		System.out.println(mutate.checkMutations("AACCGGTT", "AAACGGTA", bank));
		
		/*Reading from a file using Scanner
		 * File must be in the following format
		 * AAAAAAAA
		 * GGGGGGGG
		 * GGGGGGGG AAAAAAAA CCCCCCCC etc. (must be divided by spaces)
		 */
		File file1 = new File("src\\Mutations.txt");
		mutate.readFromFile(file1);
		File file2 = new File("src\\Mutations2.txt");
		mutate.readFromFile(file2);
	}

}
