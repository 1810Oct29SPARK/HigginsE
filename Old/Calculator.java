//scanners are a trick I learned over the weekend, they gather user input in the console.
import java.util.Scanner;

public class Calculator {
	
static int op = 0;

//The scanner is named natescan because I wanted to add my own personal touch, obviosuly.

static Scanner natescan = new Scanner(System.in);

static double arg0;

static double arg1;

static double additionResult;

static double subtractionResult;

static double multiplicationResult;

static double divisionResult;

public static void main(String [] args){
	
	do{
		System.out.println("Welcome to Nathan's cat powered calculator.  Please select 1 for Addition. 2 for Subtraction. 3 for multiplication. 4 for divsion.");
		
		op = natescan.nextInt();
		
	}while(op<1 && op<4);
	
	if(op == 1){
		
		//Kitten speak must be used here.  Don't ask questions :3
		
		System.out.println("Pwease input your first number");
		
		arg0 = natescan.nextInt();
		System.out.println("Ohh thank chu! pwease give us your second number.");
		
		arg1 = natescan.nextDouble();
		
		additionResult = arg0 + arg1;
		
		//Descriptive answer goes here!
		
		System.out.println("Teh nerdy math kittens are hard at work adding up your answer! OwO They fetched... "+additionResult);
		
	}
	if(op == 2){
		
		System.out.println("Pwease input your first number");
		
		arg0 = natescan.nextInt();
		
		System.out.println("Ohh thank chu! pwease give us your second number.");
		
		arg1 = natescan.nextDouble();
		
		subtractionResult = arg0 - arg1;
		
		System.out.println("The Java cats are furiously pawing around java beans to find you're answer... looks like it's "+subtractionResult);
	}
	if(op == 3){
		
		System.out.println("Pwease input your first number");
		
		arg0 = natescan.nextInt();
		
		System.out.println("Ohh thank chu! pwease give us your second number.");
		
		arg1 = natescan.nextDouble();
		
		multiplicationResult = arg0 * arg1;
		
		System.out.println("Uploading math to teh interwebz... The answer is: "+multiplicationResult);
	}
	if(op == 4){
		
		System.out.println("Pwease input your first number");
		
		arg0 = natescan.nextInt();
		
		System.out.println("Ohh thank chu! pwease give us your second number.");
		
		arg1 = natescan.nextDouble();
		
		divisionResult = arg0 / arg1;
		
		System.out.println("Nomming all your browser cookies... The result is: "+divisionResult);
	}
}
}