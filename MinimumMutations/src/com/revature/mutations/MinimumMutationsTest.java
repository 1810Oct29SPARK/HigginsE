package com.revature.mutations;

import java.io.IOException;

public class MinimumMutationsTest {

	public static void main(String[] args) {
		
		MinimumMutations myMutationTrial = null;
		
		// Try to read a gene-bank file
		try {
			myMutationTrial = new MinimumMutations("src/gene-bank.txt");
			System.out.println("gene bank loaded");
		} catch (IOException e) {
			System.out.println("no bank found, initializing with default");
			myMutationTrial = new MinimumMutations();
		}
		
		// Sample mutation
		System.out.println("\n==========Test Mutations==========\n");
		System.out.println(myMutationTrial.tryMutate("AACCGGTT", "AAACGGTA"));
		// Another Successful mutation
		System.out.println(myMutationTrial.tryMutate("AACCGGTA", "AAACGATT"));
		// Another Successful mutation
		System.out.println(myMutationTrial.tryMutate("EGGGTTTT", "AAAAAAAA"));
		// Same gene
		System.out.println(myMutationTrial.tryMutate("AACCGGTA", "AACCGGTA"));
		// Unsuccessful mutation
		System.out.println(myMutationTrial.tryMutate("AACCGGTA", "ATACTGTA"));
		// Invalid Gene
		System.out.println(myMutationTrial.tryMutate("AACCGGTA", "AACCGGEA"));

	}

}
