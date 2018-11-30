public class WeekCChallenge extends Calculator{

	public static void main(String[] args){
		Calculator c = new Calculator();
		//With how I have it written I don't think I need to do this.
		//I changed plenty with how these were set up.
		//I even renamed the Calculator to Calculator1 because I had my own Calculator.
		
		//1. create a new instance of the Calculator class

		//2. call each of Calculator's instance methods: add, subtract, multiply, and divide
		// with arguments of your choice, assigning the result to the variables below
		
		double additionResult = add(1.09,2.13);
		double subtractionResult = subtract(5.98,3.42);
		double multiplicationResult = multiply(4.01,3.75);
		double divisionResult = divide(12.0,0);

		//3. print the value of each of these variables to the console with a descriptive message
		System.out.println("The result of your addition is "+additionResult);
		System.out.println("The result of your subtraction is "+subtractionResult);
		System.out.println("The result of your multiplication is "+multiplicationResult);
		System.out.println("The result of your division is "+divisionResult);

		//4. implement the static fizzBuzz method in this class and call it from the main method
		int[] nums1 = new int[]{2,3};
		String[] terms1 = new String[]{"zwei","drei"};
		int[] nums2 = new int[]{6,7};
		String[] terms2 = new String[]{"seis","siete"};
		
		fizzBuzz(0,12,nums1,terms1);
		fizzBuzz(40,50,nums2,terms2);
		fizzBuzz(9,9,nums1,terms2);
		fizzBuzz(33,13,nums1,terms1);
	}
	

	public static void fizzBuzz(int m, int n, int[] numbers, String[] terms){
		if (numbers.length!=terms.length){System.out.println("The terms and numbers must contain the same amount of values.");}
		if (m==n){
			System.out.println("These numbers are the same. What are you doing?");
		}
		if (m>n) {
			System.out.println("These are in the wrong order but I'll switch 'em for you.");
			for (int l = n;l<=m;l++){
				if (l%numbers[0]==0 && l%numbers[1]==0){
					System.out.println(terms[0]+terms[1]);
				}
				else if (l%numbers[0]==0){
					System.out.println(terms[0]);
				}
				else if (l%numbers[1]==0){
					System.out.println(terms[1]);
				}
				else {
					System.out.println(l);
				}
			}
		}
		if (m<n) {
			for (int b = m;b<=n;b++){
				if (b%numbers[0]==0 && b%numbers[1]==0){
					System.out.println(terms[0]+terms[1]);
				}
				else if (b%numbers[0]==0){
					System.out.println(terms[0]);
				}
				else if (b%numbers[1]==0){
					System.out.println(terms[1]);
				}
				else {
					System.out.println(b);
				}
			}
		}
	}
}
