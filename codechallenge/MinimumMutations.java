package com.revature.codechallenge;
import java.util.Scanner;
public class MinimumMutations {
    
    public static void main(String[] args) {
        //setting the driver
        int ans = MinimumMutation();
        System.out.println(ans);
    }
    public static int MinimumMutation() {
        // scanner input, to assume the same number of characters for start and end of the gene bank
        Scanner scan = new Scanner(System.in);
        String start = "";
        System.out.print("Start: ");
        start = scan.nextLine();
        
        String end = "";
        System.out.print("End: ");
        end = scan.nextLine();
        
        //giving the gene bank
        String[] geneBank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        System.out.println("Bank: " + geneBank);
        
        // verifying the end is a proper gene in the gene bank, default is false
        boolean insideBank = false;
        
        // this loop checks if the the end is in the gene bank
        for (int i = 0; i < geneBank.length; i++) {
            if (geneBank[i].equals(end)) {
                //changes boolean to true
                insideBank = true;
            }
        }
        
        // went through gene bank, didn't find end gene in gene bank
        if (insideBank == false) {
            return -1;
            
            // did find end gene in gene bank, compares start and end using a counter
            // if it finds a difference in the gene banks, it adds it to counter
            
        } else {
            
        	//using a counter to keep up with mutation number
            int count = 0;
            for (int i = 0; i < start.length(); i++) {
                //comparing the chars at index, if they are not equal
                if (start.charAt(i) != end.charAt(i)) {
                    //then add to the counter
                    count++;
                }
            }
            return count;
        }
    }
}
