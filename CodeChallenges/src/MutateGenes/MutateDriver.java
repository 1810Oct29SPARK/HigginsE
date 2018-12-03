package MutateGenes;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class MutateDriver {

	public static void main(String[] args) throws IOException {
		String results = "";
		String start = "";
		String end = "";
		String preBank = "";
		int count = 0;
		String[] bankString = new String[3];
		List<String> startList = new ArrayList<String>();
		List<String> endList = new ArrayList<String>();
		List<String> bank = new ArrayList<String>();
		List<List> fullBank = new ArrayList<List>();

		String fileName = "C:/Users/jbj30/Documents/Revature/Workspace/Excercise/exercise-submissions/CodeChallenges/src/MutateGenes/InputText";

		String line = null;

		try {
			FileReader fileReader = new FileReader(fileName);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				// if the line contains "start", we will read the sequence and add it to our
				// startList
				if (line.contains("start")) {
					for (int i = 0; i < line.length(); ++i) {
						if (Character.isUpperCase(line.charAt(i))) {
							start += line.charAt(i);
						}
					}
					startList.add(start);
					start = "";
				}
				if (line.contains("end")) {
					// if the line contains "end", we will read the sequence and add it to our
					// endList
					for (int i = 0; i < line.length(); ++i) {
						if (Character.isUpperCase(line.charAt(i))) {
							end += line.charAt(i);
						}
					}
					endList.add(end);
					end = "";
				}
				if (line.contains("bank")) {
					// if the line contains "bank", we will split each sequence and create a list of
					// them, known as our bank.
					preBank = line.replaceAll("[\\[\\],:\"a-z]", "");
					preBank = preBank.substring(1);
					bankString = preBank.split(" ");
					for (int i = 0; i < bankString.length; ++i) {
						bank.add(bankString[i]);
					}
					fullBank.add(bank);
				}

			}
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}

		for (int i = 0; i < startList.size(); ++i) {
			if (startList.get(i) == endList.get(i)) {
				results = "0";
			} else if (!fullBank.get(i).contains(endList.get(i))) {
				results = "-1";
			} else {
				for (int x = 0; x < endList.get(i).length(); ++x) {
					if (endList.get(i).charAt(x) != startList.get(i).charAt(x)) {
						count++;
					}
				}
				results = String.valueOf(count);
				count = 0;
			}
			System.out.println(results);
			results = "";
		}
		System.out.println(startList);
		System.out.println(endList);
	}

}
