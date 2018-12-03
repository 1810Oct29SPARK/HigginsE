package mutations;

import java.util.ArrayList;
import java.util.List;

public class Mutations {

	public static int numOfMutations(String in1, String in2) {
		int counter = 0;
		List<String> bank = new ArrayList<String>();
		bank.add("AACCGGTA");
		bank.add("AACCGCTA");
		bank.add("AAACGCTA");

		String upStr1 = in1.toUpperCase();
		String upStr2 = in2.toUpperCase();
		String rep1 = upStr1.replaceAll("[^ACGT]", "");
		String rep2 = upStr2.replaceAll("[^ACGT]", "");

		for (int i = 0; i < bank.size(); i++) {
			int timesInBank = i+1;
			System.out.println("\ntimes in bank: " + timesInBank);
			System.out.println("what rep1 is: " + rep1);
			System.out.println("what rep2 is: " + rep2);
			if (rep1.equals(rep2)) {
				System.out.println(rep1.equals(rep2));
				System.out.println(rep1 + " and " + rep2 + " are the same");
				break;
			}
			else if (rep1.length() == 8 && rep2.length() == 8) {
				System.out.println("both are valid and equals length");
				System.out.println(rep1 + " and " + rep2 + " are not the same");
					int num = 0;
					for (int j = 0; j < 8; j++) {
						if (rep1.charAt(j) != bank.get(i).charAt(j)) {
							num++;
							counter++;
							System.out.println("counter is at: " + counter);
						}
						if (num > 1) {
							System.out.println("invalid, does not match bank");
							break;
						}
					}
					rep1 = bank.get(i);
					System.out.println("new word is: " + rep1);
			} else {
				System.out.println("Invalid characters or num of characters");
			}
		}
		return counter;
	}
}
