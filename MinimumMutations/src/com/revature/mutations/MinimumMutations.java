package com.revature.mutations;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MinimumMutations {
	
	private List<String> geneBank;
	
	// Default setup
	public MinimumMutations() {
		geneBank = new ArrayList<String>();
		geneBank.add("AACCGGTA");
		geneBank.add("AACCGCTA");
		geneBank.add("AAACGGTA");
		geneBank.add("GACCGGTT");
	}
	
	// Setup gene bank with file
	public MinimumMutations(String fileName) throws IOException {
		geneBank = new ArrayList<String>();
		
		FileReader fr = new FileReader(fileName);
		StringBuilder geneList = new StringBuilder();
		
		int data = fr.read();
		
		while (data != -1) {
			char newChar = (char)data;
			geneList.append(newChar);
			data = fr.read();
		}
		
		String newStr = new String(geneList);
		String[] strList = newStr.split(",");
		
		for (String s: strList) {
			geneBank.add(s);
		}
		
		fr.close();
	}
	
	// Check if a StringBuilder gene is in the gene bank
	public boolean isInBank(StringBuilder gene) {
		String testGene = new String(gene);
		for (int i = 0; i < geneBank.size(); ++i) {
			if (testGene.equals(geneBank.get(i))) {
				return true;
			}
		}
		return false;
	}
	
	// Compare two StringBuilders
	public boolean isEqual(StringBuilder str1, StringBuilder str2) {
		
		String strt1 = new String(str1);
		String strt2 = new String(str2);
		
		if (strt1.equals(strt2)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public int tryMutate(String start, String end) {

		StringBuilder currentGene = new StringBuilder(start);
		StringBuilder targetGene = new StringBuilder(end);
		
		if (isEqual(currentGene, targetGene)) {
			return 0;
		}
		
		if (!isInBank(targetGene)) {
			return -1;
		}
		
		boolean flag = true;
		int mutateCount = 0;
		
		while (!isEqual(currentGene, targetGene) && flag) {
			for (int i = 0; i <= currentGene.length(); ++i) {
				if (i == currentGene.length()) {
					flag = false;
					mutateCount = -1;
					break;
				}
				if (currentGene.charAt(i) != targetGene.charAt(i)) {
					// Try mutate
					char temp = currentGene.charAt(i);
					currentGene.setCharAt(i, targetGene.charAt(i));
					if (!isInBank(currentGene)) {
						currentGene.setCharAt(i, temp);
						continue;
					}
					else {
						++mutateCount;
						break;
					}
				}
			}
		}
		
		return mutateCount;
		
	}

}
