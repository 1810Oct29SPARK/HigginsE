public class WeekCChallenge {

	public static void main(String[] args){
		
		//1. create a new instance of the Calculator class

		Calculator myCalculator = new Calculator();




		//2. call each of Calculator's instance methods: add, subtract, multiply, and divide
		// with arguments of your choice, assigning the result to the variables below
		

		double additionResult = myCalculator.add(5.2, 5.2);
		double subtractionResult = myCalculator.subtract(5.2, 5.2);
		double multiplicationResult = myCalculator.multiply(5.2, 5.2);
		double divisionResult = myCalculator.divide(5.2, 5.2);

		//3. print the value of each of these variables to the console with a descriptive message
		
		System.out.println("The result of the addition operation was " + additionResult);
		System.out.println("The result of the subtraction operation was " + subtractionResult);
		System.out.println("The result of the multiplication operation was " + multiplicationResult);
		System.out.println("The result of the division operation was " + divisionResult);
		
		

		//4. implement the static fizzBuzz method in this class and call it from the main method
	}
	

/* Couldn't get this to compile.

	public static void fizzBuzz(int m, int n, int[] numbers, String[] terms){
		
		String output = new String();

		for(i = m; m < n; i++){
			for(int j = 0; j < numbers.length; j++){
				if(j % numbers[j] == 0){
					output += terms[j];
					System.out.println(output);
				} else {
					System.out.println(i);
				}
			}
		}
		

	}
*/

}
