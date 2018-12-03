package com.revature.MinimumMutations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) throws FileNotFoundException {
		MinimumMutations mutate = new MinimumMutations();
		//Hardcoded version
		String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
		System.out.println(mutate.checkMutations("AACCGGTT", "AAACGGTA", bank));
		
		/*Reading a file using Scanner
		 * File must be in the following format
		 * AAAAAAAA
		 * GGGGGGGG
		 * GGGGGGGG AAAAAAAA CCCCCCCC
		 */
		Scanner scan = new Scanner(new File("src/Mutations.txt"));
		List<String> input =  new ArrayList<String>();
		while(scan.hasNextLine()) {
			input.add(scan.nextLine());
		}
		scan.close();
		String[] inputs = new String[3];
		for(int i = 0; i < input.size(); i++) {
			inputs[i] = input.get(i);
		}
		String start = inputs[0];
		String end = inputs[1];
		String[] geneBank = inputs[2].split(" ");
		System.out.println(mutate.checkMutations(start, end, geneBank));
	}

}
