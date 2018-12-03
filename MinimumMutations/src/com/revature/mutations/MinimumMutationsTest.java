package com.revature.mutations;

import java.io.IOException;

public class MinimumMutationsTest {

	public static void main(String[] args) {
		
		MinimumMutations myMutationTrial = null;
		
		try {
			myMutationTrial = new MinimumMutations("src/gene-bank.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(myMutationTrial.tryMutate("AACCGGTT", "AAACGGTA"));

	}

}
