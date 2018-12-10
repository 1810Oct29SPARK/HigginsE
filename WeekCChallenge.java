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
		
			Calculator Calc = new Calculator ();
		additionResult =	Calc.add(1,2);
		subtractionResult =	Calc.subtract(1,2);
		multiplicationResult =	Calc.multiply(1,2);
		divisionResult = Calc.divide(2,2);
			
			System.out.println(additionResult);
			System.out.println(subtractionResult);
			System.out.println(multiplicationResult);
			System.out.println(divisionResult);
			
	int [] arr = {2,6};
	String[] word = {"fizz","buzz"};
			fizzBuzz(2,6,arr,word);
	}

	public static void fizzBuzz(int m, int n, int[] numbers, String[] terms){
	int num=0;
    if (m>n){
       System.out.println("error you can have a length of larger to smaller silly button!");
    }
    if(numbers.length != terms.length)
    {
        System.out.println("error you need as many numbers as terms silly button!");
    } 
    for (int i = m; i<n+1; i++)
    {
        num=i;
        if (num%i!=0){
        System.out.println(i);
    }
	}
    for (int y=0; y<numbers.length; y++){
        if(num % numbers[y]==0 & num!=0){
            System.out.println(terms[y]);
        }
    }

}
}
	
