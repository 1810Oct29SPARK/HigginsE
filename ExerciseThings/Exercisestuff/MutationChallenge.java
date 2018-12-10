package Exercisestuff;

import java.util.Scanner;

public class MutationChallenge {
/*	MutationChallenge(){
		super();
	}
	
	MutationChallenge(Scanner scanThing){
		this.scanThing = scanThing;
	}*/
Scanner scanThing = new Scanner(System.in);
public int scanThing () {

System.out.println("Please enter the starting sequence");
String start = scanThing.nextLine(); //make a the first line entered the starting sequence

char tletter; // letter to hold the test for actg
int xa;
int xg;
int xc;
int xt;
for(int i=0; i<start.length();i++) {
	tletter= Character.toUpperCase(start.charAt(i)); //assign the value of the char at index i in the starting string
	xa=(Character.compare(tletter, 'A')); //equals 0 if both match
	xg=(Character.compare(tletter, 'G'));
	xc=(Character.compare(tletter, 'C'));
	xt=(Character.compare(tletter, 'T'));
	if ((xa&xg&xc&xt)!=0) {
		System.out.println("please input a sequence containing A,G,C,T");
		return 0;
		
	}
		
}

System.out.println("Please enter the ending sequence");
String end = scanThing.next();

for(int i=0; i<end.length();i++) {
	tletter=end.charAt(i); //assign the value of the char at index i in the starting string
	xa=(Character.compare(tletter, 'A')); //equals 0 if both match
	xg=(Character.compare(tletter, 'G'));
	xc=(Character.compare(tletter, 'C'));
	xt=(Character.compare(tletter, 'T'));
	if ((xa&xg&xc&xt)!=0) {
		System.out.println("please input a sequence containing A,G,C,T");
		return 0;
		
	}
}

if (start.length()!=8) {
	System.out.println("You must input exactly 8 characters for a sequence");
	return 0;
}

if (end.length()!=8) {
	System.out.println("You must input exactly 8 characters for a sequence");
}

String fillBank = new String();


String[] bank= new String[100];
bank[0]= start;
bank [1]= end;

String choice= new String();
int testint; //test int for use later
char sletter;
char eletter;
int mutCount=0;
if (start == end) {
	System.out.println("There are no differences in the two sequences");
	return 0;
}
for (int i = 0;i<bank.length;i++) {
	if (bank[2]==null) {
		
		fillBank = scanThing.nextLine();
		tletter= Character.toUpperCase(fillBank.charAt(i)); //assign the value of the char at index i in the starting string
		xa=(Character.compare(tletter, 'A')); //equals 0 if both match
		xg=(Character.compare(tletter, 'G'));
		xc=(Character.compare(tletter, 'C'));
		xt=(Character.compare(tletter, 'T'));
		if ((xa&xg&xc&xt)!=0) {
			System.out.println("please input a sequence containing A,G,C,T");
			return 0;
			
		}
		if (fillBank.length()!=8) {
			System.out.println("You must input exactly 8 characters for a sequence");
			return 0;
		}
		bank[i]= fillBank;
		System.out.println("Please enter Continue to Continue");
		choice = scanThing.nextLine();
		if (choice.compareTo("Continue")==0) {
			System.out.println("Continuing enter another sequence");
			
		}
		

		
		//bank[i]=start;
		//bank[i+1]=end;
	}

}

if (start.length()!=end.length()) {
	System.out.println("Gene pairs must be of the same length");
	return 0;
}

for(int i=0;i<start.length();i++)
	{
	sletter=start.charAt(i);
	eletter=start.charAt(i);
	testint=Character.compare(sletter, eletter);
	if (testint!=0)
	{
		mutCount+=1;
		System.out.println("The start letter: "+sletter +"the end letter"+eletter+ "are not matching so mutation count is"+ mutCount);
	}
	
	
}
System.out.println(bank[0]);
System.out.println(bank[1]);
return 0;

}
}