/*
    Basic FizzBuzz:
    Write a function which prints out the numbers 1-100, with the following substitutions:
    Each multiple of 3 replaced with 'fizz'
    Each multiple of 5 replaced with 'buzz'
    Each multiple of both 3 and 5 replaced with 'fizzbuzz'
*/
function fizzBuzz1(){
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

    console.log(count);
}
return num;
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
        /*  console.log(m);
    console.log(n); */
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
function fizzBuzz4(m,n,fizzNum,buzzNum){

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
function fizzBuzz3(m,n,numbers,terms){

}


