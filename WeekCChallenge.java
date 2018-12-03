<<<<<<< HEAD
public class WeekCChallenge {

<<<<<<< HEAD
public static void main(String[] args){

//1. create a new instance of the Calculator class

Calculator operationObject = new Calculator();

//2. call each of Calculator's instance methods: add, subtract, multiply, and divide

// with arguments of your choice, assigning the result to the variables below

double additionResult=operationObject.add(9, 3);

double subtractionResult=operationObject.subtract(9, 3);

double multiplicationResult=operationObject.multiply(9, 3);

double divisionResult=operationObject.divide(9, 3);

//3. print the value of each of these variables to the console with a descriptive message

System.out.println("Addition Result:\t:"+additionResult);

System.out.println("SubStraction Result\t:"+subtractionResult);

System.out.println("Multiplication Result\t:"+multiplicationResult);

System.out.println("Division Result\t\t:"+divisionResult);



//4. implement the static fizzBuzz method in this class and call it from the main method
int m = 1; 
int n = 100; 
int [] numbers = {3,5};
String[] terms = {"Fizz", "Buzz"};
fizzBuzz(m,n,numbers,terms);
}

public static void fizzBuzz(int m, int n, int[] numbers, String[] terms){

if (m > n || numbers.length > terms.length || terms.length > numbers.length) {
	System.out.println ("Error!");
}

else { 
 // this goes through range
	for (int i = m; i <= n; i++) {
		String termString = " ";
	 // this goes through index of the first array
		for (int y = 0; y < numbers.length; y++) {
			if (i % numbers[y] == 0) {
				termString = termString + terms[y];
			}
		}
	 //    if this isn't empty print string
		if (termString != " ") {
			System.out.println(termString);
		}
		else {
			System.out.println(i);
		}

	}
}
}
}
=======
	public static void main(String[] args){
		
		//1. create a new instance of the Calculator class


		//2. call each of Calculator's instance methods: add, subtract, multiply, and divide
		// with arguments of your choice, assigning the result to the variables below
		
		double additionResult;
		double subtractionResult;
		double multiplicationResult;
		double divisionResult;

		//3. print the value of each of these variables to the console with a descriptive message
		

		//4. implement the static fizzBuzz method in this class and call it from the main method
	}
	

	public static void fizzBuzz(int m, int n, int[] numbers, String[] terms){

	}
}
>>>>>>> 4f29cf41df67670672b472b39d3e7a991ba347fd
=======
public class WeekCChallenge {

	public static void main(String[] args){
		
		//1. create a new instance of the Calculator class


		//2. call each of Calculator's instance methods: add, subtract, multiply, and divide
		// with arguments of your choice, assigning the result to the variables below
		
		double additionResult;
		double subtractionResult;
		double multiplicationResult;
		double divisionResult;

		//3. print the value of each of these variables to the console with a descriptive message
		

		//4. implement the static fizzBuzz method in this class and call it from the main method
	}
	

	public static void fizzBuzz(int m, int n, int[] numbers, String[] terms){

	}
}
>>>>>>> d5ab77b06b4e69932adc1c120d6fe359f013e157
