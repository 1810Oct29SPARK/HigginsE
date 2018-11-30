public class WeekCChallenge {

	public static void main(String[] args){
		
		//1. create a new instance of the Calculator class
<<<<<<< HEAD
		Calculator calcOne = new Calculator();

		//2. call each of Calculator's instance methods: add, subtract, multiply, and divide
		// with arguments of your choice, assigning the result to the variables below
		double additionResult;
		additionResult = calcOne.add(3, 5);
		System.out.println ("The sum of 3 and 5 is: " + additionResult);

		double subtractionResult;
		subtractionResult = calcOne.subract(8, 6);
		System.out.println ("8 minus 6 is: " + subtractionResult);

=======


		//2. call each of Calculator's instance methods: add, subtract, multiply, and divide
		// with arguments of your choice, assigning the result to the variables below
		
		double additionResult;
		double subtractionResult;
>>>>>>> a1e059113bf8cc7f622146397d6577f62db6df01
		double multiplicationResult;
		double divisionResult;

		//3. print the value of each of these variables to the console with a descriptive message
<<<<<<< HEAD
		System.out.println ("The sum of 3 and 5 is: " + additionResult);

		//4. implement the static fizzBuzz method in this class and call it from the main method
			//fizzBuzz(1, 100, [3,5], ["fizz", "buzz"]);
	}
}
	
 /*
	public static void fizzBuzz(int m, int n, int[] numbers, String[] terms){
		if (m > n | numbers.length > terms.length | terms.length > numbers.length) {
			System.out.println("Error!");
		}
		else {
			for (int i = m; i <= n; i++) {
				String termString = " ";
				for (int y = 0; y < numbers.length; y++)
					if (i % numbers[y] == 0) {
						termString += terms[y];
					}
				}
				if (termString != " ") {
					System.out.println(termString);
				}
				else {
					System.out.println(i);
				}
			}
		}
	}
	*/
=======
		

		//4. implement the static fizzBuzz method in this class and call it from the main method
	}
	

	public static void fizzBuzz(int m, int n, int[] numbers, String[] terms){

	}
}
>>>>>>> a1e059113bf8cc7f622146397d6577f62db6df01
