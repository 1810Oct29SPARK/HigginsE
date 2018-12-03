/*
    Basic FizzBuzz:
    Write a function which prints out the numbers 1-100, with the following substitutions:
    Each multiple of 3 replaced with 'fizz'
    Each multiple of 5 replaced with 'buzz'
    Each multiple of both 3 and 5 replaced with 'fizzbuzz'
*/
<<<<<<< HEAD
 function fizzBuzz1(){
    for(var i=1;i<101;i++){
		if(i%5 === 0 && i%3 === 0){
			('FizzBuzz');
		} else if(i%3 === 0){
			console.log('Fizz');
		} else if(i%5 === 0){
			console.log('Buzz');
		} else {
			console.log(i);
		}
	}
=======
function fizzBuzz1(){

    console.log('fizzbuzz1');

>>>>>>> d5ab77b06b4e69932adc1c120d6fe359f013e157
}

/*
    Variable-length FizzBuzz:
    Write a function which prints out the numbers m-n, with the following substitutions:
    Each multiple of 3 replaced with 'fizz'
    Each multiple of 5 replaced with 'buzz'
    Each multiple of both 3 and 5 replaced with 'fizzbuzz'
    Validation that m <= n is a plus. 
*/
function fizzBuzz2(m,n){
    let lowernumber=m;
    let highernumber=n;
    if (lowernumber>= highernumber){
        console.log("not valid");
    } else for( i=lowernumber; i<=highernumber; i++){
		if(i%5 == 0 && i%3 == 0){
			console.log('FizzBuzz');
		} else if(i%3 == 0){
			console.log('Fizz');
		} else if(i%5 == 0){
			console.log('Buzz');
		} else {
            console.log(i);
        }

    }
}


/*
    Variable-length, varying-fizz/buzz number FizzBuzz:
    Write a function which prints out the numbers m-n, with the following substitutions:
    Each multiple of fizzNum replaced with 'fizz'
    Each multiple of buzzNum replaced with 'buzz'
    Each multiple of both fizzNum and BuzzNum replaced with 'fizzbuzz'
    Validation that m <= n is a plus. 
*/
function fizzBuzz3(m,n,fizzNum,buzzNum){

}

/*
    Variable-length FizzBuzz with arrays:
    Write a function which prints out the numbers m-n with substitutions of: 
    each element of the numbers array replaced by the element at the same index of the terms array.
    e.g., to mimic the behavior of fizzBuzz1, you would call the function like so:
    fizzBuzz4(1,100,[3,5],['fizz','buzz'])
    Validation the m <= n is a plus. 
    The arrays may have any length, but validation that their length is the SAME is a plus. 
*/
function fizzBuzz4(m,n,numbers,terms){

}


