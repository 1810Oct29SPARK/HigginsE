package com.revature.mutations;

import java.io.IOException;

public class MinimumMutationsTest {

	public static void main(String[] args) {
		
		MinimumMutations myMutationTrial = null;
		
		try {
			myMutationTrial = new MinimumMutations("src/gene-bank.txt");
		} catch (IOException e) {
			System.out.println("no bank found, initializing with default");
			myMutationTrial = new MinimumMutations();
		}
		
		// Successful mutation
		System.out.println(myMutationTrial.tryMutate("AACCGGTA", "AAACGATT"));
		// Same gene
		System.out.println(myMutationTrial.tryMutate("AACCGGTA", "AACCGGTA"));
		// Unsuccessful mutation
		System.out.println(myMutationTrial.tryMutate("AACCGGTA", "ATACTGTA"));
		// Invalid Gene
		System.out.println(myMutationTrial.tryMutate("AACCGGTA", "AACCGGEA"));

	}

}
