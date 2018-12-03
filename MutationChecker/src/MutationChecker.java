

public class MutationChecker {
	
	public int mutationChecker(String start, String end, String[] bank) {
// will count the differences in the gene strings
		int mutationCounter = 0;
//		checker to see if the end string is found in the bank 
		int checker = 0;
		boolean charbool = start.matches("^[ACGT]*$");
		boolean charboolletstry = start.matches("[ACGT]*");

		System.out.println(charbool+" first boolean");
		System.out.println(charboolletstry+" secound boolean");

		

//		if (start.matches("^[ACGT]*$")) {
//			System.out.println("error");
//		}
//		System.out.println(start.matches("^[ACGT]*$"));
		
		for (int i=0; i<bank.length;i++) {
			if (!(end==bank[i])) {
				checker++;
			}
		}
//		if the end genes are not found in the bank
		if (checker ==3) {
			mutationCounter =-1;
			return mutationCounter;
		}
		
		
		if (start.length()>8) {
			System.out.println("genes too long!");
		}
		if(end.length()>8) {
			System.out.println("genes too long!");
		}
		
		for (int i=0; i<start.length();i++) {
			if(!(start.charAt(i)==end.charAt(i))) {
				mutationCounter++;
			}
			
		}
		
//		System.out.println(checker);

		return mutationCounter;
	}

}
