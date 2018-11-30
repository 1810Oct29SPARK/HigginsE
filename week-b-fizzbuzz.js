/*
    Basic FizzBuzz:
    Write a function which prints out the numbers 1-100, with the following substitutions:
    Each multiple of 3 replaced with 'fizz'
    Each multiple of 5 replaced with 'buzz'
    Each multiple of both 3 and 5 replaced with 'fizzbuzz'
*/
function fizzBuzz1(){
    for (let i = 1; i <= 100; i++) {
        
        if (i % 3 === 0 && i % 5 === 0) {
            console.log("fizzbuzz");
        }
        
        else if (i % 3 === 0) {
            console.log("fizz");
        }
        else if (i % 5 === 0){
            console.log("buzz");
        }

<<<<<<< HEAD
        else {
            console.log(i);
        }
    }
=======
    console.log('fizzbuzz1');

>>>>>>> a1e059113bf8cc7f622146397d6577f62db6df01
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
    if (m <= n){
        for (; m <= n; m++) {
            if (i % 3 === 0 && i % 5 === 0) {
                console.log("fizzbuzz");
            } 
            else if (m % 3 === 0) {
                console.log("fizz");
            }
            else if (m % 5 === 0){
                console.log("buzz");
            }
            else {
                console.log(m);
            }
        }
    }
    else {
        console.log("m is not less than n");
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


