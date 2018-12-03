package mutationsPackage;

public class MutationsMain {

	public static void main(String[] args) {
		 MutationMaker mutationTest=new MutationMaker("AACCGGTT","AAACGGTA",new String[] {"AACCGGTA", "AACCGCTA", "AAACGGTA"});
		 mutationTest.mutationCheck();
		 
	}

}
