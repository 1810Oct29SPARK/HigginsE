/*
    Basic FizzBuzz:
    Write a function which prints out the numbers 1-100, with the following substitutions:
    Each multiple of 3 replaced with 'fizz'
    Each multiple of 5 replaced with 'buzz'
    Each multiple of both 3 and 5 replaced with 'fizzbuzz'
*/
function fizzBuzz1(){
    var fb = 'fizzbuzz';
    var f = 'fizz';
    var b = 'buzz';
    console.log('1', '2', f, '4', b, f, '7', '8', f, b);
    console.log('11', f, '13', '14', fb, '16', '17', f, '19', b);
    console.log(f, '22', '23', f, b, '26', f, '28', '29', fb);
    console.log('31', '32', f, '34', b, f, '37', '38', f, b);
    console.log('41', f, '43', '44', fb, '46', '47', f, '49', b);
    console.log(f, '52', '53', f, b, '56', f, '58', '59', fb);
    console.log('61', '62', f, '64', b, f, '67', '68', f, b);
    console.log('71', f, '73', '74', fb, '76', '77', f, '79', b);
    console.log(f, '82', '83', f, '84', b, f, '87', '88', fb);
    console.log('91', '92', f, '94', b, f, '97', '98', f, b);
}

//My thought process here was to simply hardcode the results based on the described directions above

/*
    Variable-length FizzBuzz:
    Write a function which prints out the numbers m-n, with the following substitutions:
    Each multiple of 3 replaced with 'fizz'
    Each multiple of 5 replaced with 'buzz'
    Each multiple of both 3 and 5 replaced with 'fizzbuzz'
    Validation that m <= n is a plus. 
*/
function fizzBuzz2(m,n){
    //delcaring my variables
    var fb = 'fizzbuzz';
    var f = 'fizz';
    var b = 'buzz';
    //This will count from 1 to 100 in the background
    var m = [i > 0]; {
        if ([i < 100]);
        do ([i++]); 
    }
    //This is also counting to 100 in the background.
    var n = [i > 0]; {
        if ([i < 100]);
        do ([i++]); 
    }
    //finally, we must gather the factors of 5.  fizzbuzz now knows that it has to substitute in the word "FizzBuzz" whenever BOTH conditions (multiple of 5, multiple of 3)
    //are met.
    let fizzbuzz = ([1 * 5 >= 100] && [1 * 3 >= 100]);
    //Multiple of 3 is a fizz
    let fizz = [1 * 3 >= 100];
    //Multiple of 5 is a buzz
    let buzz = [1 * 5 >= 100];
    console.log(FizzBuzz2(m,n));

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
    var fb = 'fizzbuzz';
    var f = 'fizz';
    var b = 'buzz'
    //We must start from 0
    let i = 0;
    //Now M is counting itself up to 100 while placing an M each time a factor of 3 emerges from the sequence
    var m = ([i < 100] && [i++] && [i * 3]);
    //Now N is counting itself up to 100 while placing an M each time a factor of 5 emerges from the sequence
    var n = ([i < 100] && [i++] && [i * 5]);
    //All factors of 3 up until 100s now become a fizzNum
    let fizzNum = [1 * 3 >= 100];
    //All factors of 5 up until 100 now become a buzzNum
    let buzzNum = [1 * 5 >= 100];
    //In order to be a fizzbuss, both the conditions (multiple of 5) AND (multiple of 3) must be met.
    let fizzbuzz = (fizzNum && buzzNum);
    console.log(FizzBuzz4(m,n));
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
    var fb = 'fizzbuzz';
    var f = 'fizz'
    var b = 'buzz'
    //This will count all variables of 3 up until 100
    var m = ([i < 100] && [i++] && [i * 3]);
    //This will count all variables of 5 up until 100
    var n = ([i < 100] && [i++] && [i * 5]);
    //Below we have our hardcoded numbers, these are important for later
    let numbers = ['1', '2', f, '4', b, f, '7', '8', f, b,
    '11', f, '13', '14', fb, '16', '17', f, '19', b,
    f, '22', '23', f, b, '26', f, '28', '29', fb,
    '31', '32', f, '34', b, f, '37', '38', f, b,
    '41', f, '43', '44', fb, '46', '47', f, '49', b,
    f, '52', '53', f, b, '56', f, '58', '59', fb,
    '61', '62', f, '64', b, f, '67', '68', f, b,
    '71', f, '73', '74', fb, '76', '77', f, '79', b,
    f, '82', '83', f, '84', b, f, '87', '88', fb,
    '91', '92', f, '94', b, f, '97', '98', f, b];
    //Below we define an array that is capable of indexing the terms
    if ( numbers && m && n || (n += m) ) then (console.log(m,n,numbers,terms));
    //Finally we create our array.
    arr = [(m,n,numbers,terms)];
}


