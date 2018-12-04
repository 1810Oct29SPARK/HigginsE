package CodeChallenge;

import java.util.Scanner;

public class MutationsDriver {

	public static void main(String[] args) {
		
		MinimumMutations newMinMut = new MinimumMutations();
		
		System.out.println("Enter a starting gene: ");
		Scanner reader = new Scanner (System.in);
		String start = reader.nextLine();
		
		System.out.println("Enter the ending gene: ");
		String end = reader.nextLine();
		
		System.out.println("Enter the number of valid genes in gene bank : ");
		int numGenes = Integer.parseInt(reader.nextLine());
		
		String[] bank = new String[numGenes];
		
		for (int i = 0; i < bank.length; i++) {
			System.out.println("Enter a gene: ");
			bank[i] = reader.nextLine();
		}

		reader.close();			
	} 

}



