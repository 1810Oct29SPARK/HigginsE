/*
    Basic FizzBuzz:
    Write a function which prints out the numbers 1-100, with the following substitutions:
    Each multiple of 3 replaced with 'fizz'
    Each multiple of 5 replaced with 'buzz'
    Each multiple of both 3 and 5 replaced with 'fizzbuzz'
*/
function fizzBuzz1(){
<<<<<<< HEAD
let num = 0;
let statement3 = "Fizz";
let statement5 = "Buzz";
let statement3and5= "Fizzbuzz"
for (let count = 0; count<101;count++)
{
    num = count;
    
    if (num %3==0){
        console.log(statement3);
    }
    if (num %5 == 0)
    {
        console.log(statement5);
    }
    if (num %3 && num % 5 == 0)
    {
        console.log(statement3and5)
    }

<<<<<<< HEAD
    console.log(count);
}
return num;
=======
    console.log('fizzbuzz1');

>>>>>>> 6c2609875967f8f9304a6f639b97ef96633e48cf
=======

    console.log('fizzbuzz1');

>>>>>>> 5afb7e7aa9c65868fe2dba66069ddde6763e5070
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
<<<<<<< HEAD
let statement3 = "Fizz";
let statement5 = "Buzz";
let statement3and5= "Fizzbuzz"
for(let count = m; count<n; count++) {   
    
    if (count %3 == 0 && count % 5 == 0)
    {
        console.log(statement3and5);
    }

    if (count % 3 == 0 && count % 5 != 0)
    {
        console.log(statement3);
    }

    if (count % 5 == 0 && count % 3 != 0 )
    {
        console.log(statement5);
    }
   
   

    if (count % 3 != 0 && count % 5 != 0){
        console.log(count);
    }
}
}
=======

}

>>>>>>> 5afb7e7aa9c65868fe2dba66069ddde6763e5070
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
<<<<<<< HEAD
<<<<<<< HEAD
function fizzBuzz3(m,n,numbers,terms){
let statement3 = "Fizz";
let statement5 = "Buzz";
let statement3and5= "Fizzbuzz"
    numbers=[];
    terms=[];
    numbers.length=n;
    for (let count = 0; count < numbers.length; count++)
    {
        numbers[count]= count;
    }
    if (count % 3 == 0)
=======
function fizzBuzz4(m,n,numbers,terms){

>>>>>>> 6c2609875967f8f9304a6f639b97ef96633e48cf
=======
function fizzBuzz4(m,n,numbers,terms){

>>>>>>> 5afb7e7aa9c65868fe2dba66069ddde6763e5070
}


