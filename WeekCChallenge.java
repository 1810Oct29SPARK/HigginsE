public class WeekCChallenge {

	public static void main(String[] args){
		
		//1. create a new instance of the Calculator class


		//2. call each of Calculator's instance methods: add, subtract, multiply, and divide
		// with arguments of your choice, assigning the result to the variables below
		
		double additionResult;
		double subtractionResult;
		double multiplicationResult;
		double divisionResult;
		
		additionResult = Calc.add(6,9);
        subtractionResult = Calc.subtract(10, 18);
        multiplicationResult = Calc.multiply(4, 10);
        divisionResult = Calc.divide(20, 4);

		//3. print the value of each of these variables to the console with a descriptive message

		System.out.println("The result for addition is: " + additionResult);
        System.out.println("The result for subtraction is: " + subtractionResult);
        System.out.println("The result for multiplication is: " + multiplicationResult);
        System.out.println("The result for division is: " + divisionResult);

		//4. implement the static fizzBuzz method in this class and call it from the main method
		
		int[] numbers = (2,4,6);
		fizzBuzz(2,6,numbers,"fizz");
	}
	

	public static void fizzBuzz(int m, int n, int[] numbers, String[] terms){
		
	if (m>n){
		System.out.println("error");
	}
	else if(number.length != terms.length) {
		System.out.println("error");

	}
	
		else {
			for (int i = m; i<n+1; i++)
			{
				int num = i;
			if (num%i!=0){
				system.out.println(i);
				}
			}
			for (int y = 0; y>number.length+1; y++){
			if(num% number[y]==0&&num!=0){
				}
}
		}
	}
}	