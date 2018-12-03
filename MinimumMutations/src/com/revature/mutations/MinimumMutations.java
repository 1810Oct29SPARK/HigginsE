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
		
		// Read file
		FileReader fr = new FileReader(fileName);
		
		// Setup data container
		StringBuilder geneList = new StringBuilder();
		
		// Read data until reaching the end of file
		int data = fr.read();
		while (data != -1) {
			char newData = (char)data;
			geneList.append(newData);
			data = fr.read();
		}
		
		// Parse data and build gene bank
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
	
	// Try to mutate genes
	public int tryMutate(String start, String end) {

		// Convert to StringBuilders
		StringBuilder currentGene = new StringBuilder(start);
		StringBuilder targetGene = new StringBuilder(end);
		
		// Check initial equality
		if (isEqual(currentGene, targetGene)) {
			return 0;
		}
		
		// Check if the target is invalid to begin with
		if (!isInBank(targetGene)) {
			return -1;
		}
		
		// Count the number of mutations occurred
		int mutateCount = 0;
		
		// Old code with flaw
		while (!isEqual(currentGene, targetGene)) {
			// Try find any difference between the current gene and the target
			for (int i = 0; i <= currentGene.length(); ++i) {
				// When i reaches length, mutation fails
				if (i == currentGene.length()) {
					return -1;
				}
				// Found a difference
				// Try mutate by replacing the old gene character
				// with the target's character
				if (currentGene.charAt(i) != targetGene.charAt(i)) {
					// Store the old gene character
					char temp = currentGene.charAt(i);
					currentGene.setCharAt(i, targetGene.charAt(i));
					// Check if it is a valid mutation
					if (!isInBank(currentGene)) {
						// If not then swap back and try another
						currentGene.setCharAt(i, temp);
						continue;
					}
					else {
						// One mutation is possible
						// Try to mutate more
						++mutateCount;
						break;
					}
				}
			}
		}
		
		return mutateCount;
		
	}
	
	public StringBuilder mutateOne(StringBuilder currentGene, StringBuilder targetGene) {
		StringBuilder result = null;
		
		for (int i = 0; i <= currentGene.length(); ++i) {
			// When i reaches length, mutation fails
			if (i == currentGene.length()) {
				return null;
			}
			// Found a difference
			// Try mutate by replacing the old gene character
			// with the target's character
			if (currentGene.charAt(i) != targetGene.charAt(i)) {
				// Store the old gene character
				char temp = currentGene.charAt(i);
				currentGene.setCharAt(i, targetGene.charAt(i));
				// Check if it is a valid mutation
				if (!isInBank(currentGene)) {
					// If not then swap back and try another
					currentGene.setCharAt(i, temp);
					continue;
				}
				else {
					result = currentGene;
					break;
				}
			}
		}
		
		return result;
	}

}
