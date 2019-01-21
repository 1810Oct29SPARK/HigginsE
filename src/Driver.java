public class WeekCChallenge {
	public static void main(String[] args{
//1. create a new instance of the Calculator class
        Calculator calculate = new Calculator();
        //2. call each of Calculator's instance methods: add, subtract, multiply, and divide
        // with arguments of your choice, assigning the result to the variables below
        
        double additionResult;
        double subtractionResult;
        double multiplicationResult;
        double divisionResult;
        
        additionResult = calcuate.add(6,9);
        subtractionResult = calculate.subtract(10, 18);
        multiplicationResult = calculate.multiply(4, 10);
        divisionResult = calculate.divide(20, 4);
        //3. print the value of each of these variables to the console with a descriptive message
        System.out.println("The result for addition is: " + additionResult);
        System.out.println("The result for subtraction is: " + subtractionResult);
        System.out.println("The result for multiplication is: " + multiplicationResult);
        System.out.println("The result for division is: " + divisionResult);



	}
	
}
