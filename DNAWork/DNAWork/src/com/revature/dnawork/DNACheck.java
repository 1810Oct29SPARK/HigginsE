package com.revature.dnawork;

import java.util.HashSet;
import java.util.regex.Pattern;

public class DNACheck {
	public static String[] startEnd = {"AACCGGTT","AAACGGTA"};
	public static String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
	//what am I even trying to do anymore?
//	public static int otherCheck() {
//		int[] arr = new int[bank.length];
//		String start = startEnd[0];
//		String end = startEnd[1];
////		for (int a=0;a<8;a++) {
////			for (int b=0;b<bank.length;b++) {
////				int zero = 0;
////				if (start.charAt(a)!=bank[b].charAt(a)) {
////					zero++;
////				}
////				arr[b]=zero;
////			}
////		System.out.println(arr[0]);
////		System.out.println(arr[1]);
////		System.out.println(arr[2]);
////		}
//		int t=0;
//		String recombinant = start;
//		while (t!=0) {recombinant=end;
//		for (int b=0;b<bank.length;b++) {
//			int zero = 0;
//			for (int a=0;a<8;a++) {
//				if (recombinant.charAt(a)!=bank[b].charAt(a)) {
//					zero++;
//				}
//			}
//			arr[b]+=zero;
//			System.out.println(arr[b]);
//		}
//		int lowChange=476;
//		int index = 900;
//		for (int r=0;r<arr.length;r++) {
//			if (arr[r]<lowChange) {
//				lowChange=arr[r];
//				index=r;
//			}
//		}
//		t++;
//		System.out.println(lowChange);
//		System.out.println(recombinant);
//		}//while loop;
//		return 0;
//	}
	
	
	public static int checkSequence() {
		String start = startEnd[0];
		String end = startEnd[1];
		//I'm going to check if end exists in the bank
		//if it doesn't then I'll say you can't reach this through mutation
		int possible = 0;
		for (int pos=0;pos<bank.length;pos++) {
			if (end==bank[pos]) {
				possible+=1;
			}
		}
		//the strings have to both be 8 long
		if (start.length()!=8 || end.length()!=8) {
			possible=possible*0;
		}
		if (possible==0) {
			System.out.println("impossible");
		}
		else {
			System.out.println("possible");
		}
		//check that only ATCG are in there. I think you can also have U in dna
		//nah its only in rna you can have u
		for (int huh=0;huh<bank.length;huh++) {
			if (Pattern.matches("[^ATCG]",bank[huh]) || Pattern.matches("[^ATCG]",start) || Pattern.matches("[^ATCG]",end)) {
				System.out.println("Ah weird DNA");
			}
		}
		HashSet<Integer> indexes = new HashSet<Integer>();
		char[] recombinant = new char[8];
		int[] arr = new int[bank.length];
		//I'm creating a hashset that i can put indexes into if they do not match
		//a value in the bank
		//I need to build a holding place for the mutant strains
		for (int d=0;d<8;d++) {
			recombinant[d]=start.charAt(d);
		}
		//now the recombinant dna be changed easily from start
		
		
		
		for (int banco=0;banco<bank.length;banco++) {
			for (int dna=0;dna<8;dna++) {
//				if (start.charAt(dna)==end.charAt(dna)) {
//					recombinant[dna]=start.charAt(dna);
//					//this is redundant now
//				}
//				else {
					for (int n=0;n<8;n++) {
						if (recombinant[n]!=bank[banco].charAt(n)) {
							//System.out.println(banco);
							switch (recombinant[n]) {
							case 'T': recombinant[n]='A';
							case 'A': recombinant[n]='T';
							case 'C': recombinant[n]='G';
							case 'G': recombinant[n]='C';
							//this switch case doesn't work because you can replace C with A
							//Oh I shoulda caught that.
							//oh well. I'll work on it at home later.
							}
							if (recombinant[n]!=bank[banco].charAt(n)) {
								indexes.add(n);
								//System.out.println(indexes);
								//so now it only adds the indexes if after mutating
								//it is not present in the bank
								//so from the readout it shows that no index
								//is added from the string at bank[1]
							}
							else {
								arr[banco]++;
								if (banco==bank.length-1) {
									banco=0;
									break;
								}
							}
							break;
						}
					}
				}
			}
//		//}
//		System.out.println(arr[0]);
//		System.out.println(arr[1]);
//		System.out.println(arr[2]);
		System.out.println("Incomplete assignment, I'll be working on it at home.");
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(checkSequence());
//		otherCheck();
	}

}
/*
 * from start check against values in end, 
 * when descrepency found check if w/change 
 * the new sequence is in the bank.
 * if then continue
 * if not then mark index leave it as it was originally 
 * then go back to checink the rest of the values.
 * once done check those indexes that
 * got marked as negatives
 * 
 * 
 * */
