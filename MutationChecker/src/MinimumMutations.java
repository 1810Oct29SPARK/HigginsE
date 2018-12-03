
public class MinimumMutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String start ="AACCGGTT";
		String end=   "$AACGGTA";
//		String end2="CCCCCCCC";
		String[] bank= {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
		
		MutationChecker myMutator = new MutationChecker();
		int muations =myMutator.mutationChecker(start, end, bank);
		System.out.println(muations);

	}

}
