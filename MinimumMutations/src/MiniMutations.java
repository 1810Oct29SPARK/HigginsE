import java.util.Scanner;

public class MiniMutations {
	
	public static int getNumOfMutations() {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a start gene: ");
		String startGene = sc.nextLine();
		System.out.println("Enter an end gene:");
		String endGene = sc.nextLine();
		System.out.println("Enter the number of valid genes:");
		int numOfGenes = Integer.parseInt(sc.nextLine());
		
		String[] geneBank = new String[numOfGenes];
		
		for (int i = 0; i < geneBank.length; i++) {
			System.out.println("Enter a gene for the gene bank:");
			geneBank[i] = sc.nextLine();
		}
		
		sc.close();
		
		if (startGene == endGene) {
			return 0;
		}
		
		int isMutation = -1;
		
		for (int j = 0; j < geneBank.length; j++) {
			if (geneBank[j] == endGene) {
				isMutation = 1;
				return isMutation;
			}
			if (geneBank[geneBank.length-1] != endGene) {
				return isMutation;
			}
		}
		
		int counter = 0;
		
		for (int k = 0; k < endGene.length(); k++) {
			char currentChar = startGene.charAt(k);
			if (currentChar != endGene.charAt(k)) {
				counter++;
			}
		}
		
		return counter;
	};
}

	
