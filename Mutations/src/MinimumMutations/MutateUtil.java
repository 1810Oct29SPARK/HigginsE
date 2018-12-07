package MinimumMutations;

import java.util.ArrayList;

public class MutateUtil {

	public static int minimumMutations() {
		String start = "AACCGGTT";
		String end = "AAACGGTA";
		String[] bank = { "AACCGGTA", "AACCGCTA", "AAACGGTA" };
		int result = 0;
		ArrayList<String> helix = new ArrayList<>();
		ArrayList<String> check = new ArrayList<>();
		String[] genes = { "A", "G", "C", "T" };
		check.add(start);
		helix.add(start);
		for (String sequence : bank) {
			helix.add(sequence);
		}
		if (start.length() == end.length()) {
			result = 0;
		} 
		for (int i = 0; i < start.length(); i++) {
			for (String com : genes) {
				String change = start.substring(0, i) + com + start.substring(i + 1);

				if (helix.contains(change) && !check.contains(change)) {
					check.add(change);
					int count = result + 1;
					if (count > 0) {
						result = count;
					} else if (count == 0) {
						result = -1;
					}
				}
			}
		}
		System.out.println(result);
		return result;
	}
}