/*
    Basic FizzBuzz:
    Write a function which prints out the numbers 1-100, with the following substitutions:
    Each multiple of 3 replaced with 'fizz'
    Each multiple of 5 replaced with 'buzz'
    Each multiple of both 3 and 5 replaced with 'fizzbuzz'
*/
function fizzBuzz1(){
    var num1;
    for (i=1; i<101; i++){
        num = i;
        if (num % 3 == 0 && num % 5 == 0 && num != 0){
            console.log(i + ' fizz buzz');
        } else if (num % 3 == 0 && num != 0){
            console.log(i + ' fizz');
        } else if (num % 5 == 0 && num != 0) {
            console.log(i + ' buzz');
        }
        else {
            console.log(i);
        }
    }
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

    var lowNum = m;
    var highNum = n;

    if (lowNum > highNum){
        console.log(" ERROR!: Numbers are not in proper order, Try Again!");
    } else { 

    for (i=lowNum; i<(highNum+ 1); i++){
        num = i;
        if (num % 3 == 0 && num % 5 == 0 && num != 0){
            console.log(i + ' fizz buzz');
        } else if (num % 3 == 0 && num != 0){
            console.log(i + ' fizz');
        } else if (num % 5 == 0 && num != 0) {
            console.log(i + ' buzz');
        }
        else {
            console.log(i);
        }
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
    var lowNum = m;
    var highNum = n;
    var fNum = fizzNum;
    var bNum = buzzNum;

    if (lowNum > highNum){
        console.log(" ERROR!: Numbers are not in proper order, Try Again!");
    } else {
    for (i=lowNum; i<(highNum+ 1); i++){
        num = i;
        if (num % fNum == 0 && num % bNum == 0 && num != 0){
            console.log(i + ' fizz buzz');
        } else if (num % fNum == 0 && num != 0){
            console.log(i + ' fizz');
        } else if (num % bNum == 0 && num != 0) {
            console.log(i + ' buzz');
        }
        else {
            console.log(i);
        }
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
    var lowNum = m;
    var highNum = n;
    
    var numArr = numbers;
    var termArr = terms;

    x = numArr.length;

    if (lowNum > highNum){
    
        console.log(" ERROR!: Numbers are not in proper order, Try Again!");
    
    }   else if (numArr.length != termArr.length){   
    
            console.log("Array Lengths are not the proper size! Try Again!");
    
    }   else {

            for (i=lowNum; i<(highNum + 1); i++){
                num = i;
                console.log(i); 
            
                for ( y = 0 ; y < (numArr.length +1) ; y ++){
                    
                    if (num % numArr[y] == 0 && num != 0){
                        console.log(termArr[y]);
                    }
                } 
                
            }
    
    }
  
}
 

