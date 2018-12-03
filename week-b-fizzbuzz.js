/*
    Basic FizzBuzz:
    Write a function which prints out the numbers 1-100, with the following substitutions:
    Each multiple of 3 replaced with 'fizz'
    Each multiple of 5 replaced with 'buzz'
    Each multiple of both 3 and 5 replaced with 'fizzbuzz'
*/
function fizzBuzz1(){
   console.log('fizzbuzz1');
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
    for (i = m; i <= n; i++) {
        if (i % 3 == 0 && i % 5 == 0) {
            console.log("fizzbuzz");
        } 
        else if (i % 3 == 0) {
            console.log("fizz");
        }
        else if (i % 5 == 0)
        console.log("buzz");
        else {
            console.log(i);
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

    for (i = m; i <= n; i++) {
        if (i % fizzNum == 0 && i % buzzNum == 0) {
            console.log("fizzbuzz");
        } 
        else if (i % fizzNum == 0) {
            console.log("fizz");
        }
        else if (i % buzzNum == 0)
        console.log("buzz");
        else {
            console.log(i);
        }
    }
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

    for (i = m; i <= n; i++) {
        if (i % numbers[0] == 0 && i % numbers[1] == 0) {
            console.log(terms[0]+terms[1]);
        } 
        else if (i % numbers[0] == 0) {
            console.log(terms[0]);
        }
        else if (i % numbers[1] == 0) {
            console.log(terms[1]);
        }
        
        else {
            console.log(i);
        }
    }
}


