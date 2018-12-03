package com.revature.Week1CC;

import java.io.Serializable;
import java.util.Scanner;

public class MinimumMutations extends Driver implements Serializable, CharSequence {
	static Scanner scan = new Scanner(System.in);
	
	/*
	 * Minimum Mutations!

A gene string can be represented by an 8-character long string, with 
choices from "A", "C", "G", "T".

Suppose we need to investigate about a mutation (mutation from "start" 
to "end"), where ONE mutation is defined as ONE single character changed 
in the gene string.

For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.

Also, there is a given gene "bank", which records all the valid gene 
mutations. A gene must be in the bank to make it a valid gene string.

Now, given 3 things - start, end, bank, your task is to determine what 
is the minimum number of mutations needed to mutate from "start" to 
"end".
If there is no such a mutation, return -1.
If the start and end string are the same, return 0.

Example:

start: "AACCGGTT"
end:   "AAACGGTA"
bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]

return: 2

Note:
	Starting point is assumed to be valid, so it might not be 
included in the bank.
	If multiple mutations are needed, all mutations during in the 
sequence must be valid.

Organize your solution into a driver class (with a main method) and 
utility class containing the logical implementation.
Points will be docked for code that's too tightly coupled.
The starting and ending sequences and mutation bank may be (in 
descending order of points awarded) read from a file, input through the 
console, or hardcoded in the driver class. 


REFERENCE:

Reading/writing to/from files in Java, you will need to use a 
FileInputStream passed to an ObjectInputStream. 

Submit your solution in this folder on your branch as .java files (if 
you wrote your solution in Eclipse/STS, make sure no compiled .class 
files or project metadata make their way up to GitHub. 
	 */
	
	//I'm going to attempt this using a StringBuilder
	//String Builder objects are like String objects, except they can be modified
	
	//This is my word bank 
	
	
	//StringBuilder strBuilder0=new StringBuilder("AACCGGTA");
	//StringBuilder strBuilder1=new StringBuilder("AACCGCTA");
	//StringBuilder strBuilder2=new StringBuilder("AAACGGTA");
	
	//nevermind, ignore that, we're using scanners!
	
	//This is the set of characters we are going to compare
	
	String char1 = scan.next();
	String char2 = scan.next();
	String char3 = scan.next();
	String char4 = scan.next();
	String char5 = scan.next();
	String char6 = scan.next();
	String char7 = scan.next();
	String char8 = scan.next();
	
	
	//we need to concatenate the string and save it as StrChar
	
public String strChar = (char1 + char2 + char3 + char4 + char5 + char6 + char7 + char8); 
			
	// next  we need to have the user input the mutation string in which the original string is being compared to
	
	String mutatation1 = scan.next();
	String mutatation2 = scan.next();
	String mutatation3 = scan.next();
	String mutatation4 = scan.next();
	String mutatation5 = scan.next();
	String mutatation6 = scan.next();
	String mutatation7 = scan.next();
	String mutatation8 = scan.next();
	
public String mutationChar = (mutation1 + mutation2 + mutation3 + mutation4 + mutation5 + mutation6 + mutation 7 + mutation 8); 	
	
	/*
	 * Now, given 3 things - start, end, bank, your task is to determine what 
	 *is the minimum number of mutations needed to mutate from "start" to 
	 *"end".
	 */
	
	if /*the start and end string are the same, return 0.*/ String mutationChar == starChar {
		then return 0;
	} else {
		return -1
	}

	@Override
	public char charAt(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}  
	

}
