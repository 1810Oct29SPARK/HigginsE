/*
    Basic FizzBuzz:
    Write a function which prints out the numbers 1-100, with the following substitutions:
    Each multiple of 3 replaced with 'fizz'
    Each multiple of 5 replaced with 'buzz'
    Each multiple of both 3 and 5 replaced with 'fizzbuzz'
*/
function fizzBuzz1(){
<<<<<<< HEAD
    for (let i=1;i<101;++i){
        if(i%3==0 && i%5==0){
            console.log("fizzbuzz");
        }
        else if(i%3==0){
            console.log("fizz");
        }
        else if(i%5==0){
            console.log("buzz");
        }
        else {
            console.log(i);
        }
    }
=======

    console.log('fizzbuzz1');

>>>>>>> 4f29cf41df67670672b472b39d3e7a991ba347fd
}
/*
    Variable-length FizzBuzz:
    Write a function which prints out the numbers m-n, with the following substitutions:
    Each multiple of 3 replaced with 'fizz'
    Each multiple of 5 replaced with 'buzz'
    Each multiple of both 3 and 5 replaced with 'fizzbuzz'
    Validation that m <= n is a plus. 
*/
function fizzBuzz2(x,y){
    // I'm getting infinite loops if m<=n.
    // I can't get the solution before time.
    // Haha you stupid computer.
    // It was I that was the fool.
    // I forgot you can't read = as a comparison.
    // if(i=0){code;} was forever looping my code.
    if (x==y){
        return "What are you doing? These are equal, punk.";
    }
    if (x>y){
        console.log("I'll switch 'em for ya.");
        kooks(y,x);
    }
    else{
        kooks(x,y);
    }
    function kooks(m,n){
        for(let i=m;i<=n;++i){
            if (i==0){
                console.log(0)
            }
            else if (i%3==0 && i%5==0){
                console.log("fizzbuzz");
            }
            else if(i%3==0){
                console.log("fizz");
            }
            else if(i%5==0){
                console.log("buzz");
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
<<<<<<< HEAD
function fizzBuzz3(x,y,fizzNum,buzzNum){
    if (x==y){
        return "What are you doing? These are equal, punk.";
    }
    if (x>y){
        console.log("I'll switch 'em for ya.");
        kooks(y,x,fizzNum,buzzNum);
    }
    else{
        kooks(x,y,fizzNum,buzzNum);
    }
    function kooks(m,n){
        for(let i=m;i<=n;++i){
            if(i%fizzNum==0 && i%buzzNum==0){
                console.log("fizzbuzz");
            }
            else if(i%fizzNum==0){
                console.log("fizz");
            }
            else if(i%buzzNum==0){
                console.log("buzz");
            }
            else {
                console.log(i);
            }
        }
    }
=======
function fizzBuzz3(m,n,fizzNum,buzzNum){

>>>>>>> 4f29cf41df67670672b472b39d3e7a991ba347fd
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
function fizzBuzz4(x,y,numbers,terms){
    if (x==y){
        return "What are you doing? These are equal, punk.";
    }
    if (x>y){
        console.log("I'll switch 'em for ya.");
        kooks(y,x,numbers,terms);
    }
    else{
        kooks(x,y,numbers,terms);
    }
    function kooks(m,n){
        for(let i=m;i<=n;++i){
            if(i%numbers[0]==0 && i%numbers[1]==0){
                console.log(terms[0]+terms[1]);
            }
            else if(i%numbers[0]==0){
                console.log(terms[0]);
            }
            else if(i%numbers[1]==0){
                console.log(terms[1]);;
            }
            else {
                console.log(i);
            }
        }
    }
=======
function fizzBuzz4(m,n,numbers,terms){

>>>>>>> 4f29cf41df67670672b472b39d3e7a991ba347fd
}






function fizzBuzz4(m,n,numbers,terms){
    var word;
    if(m<=n && numbers.length==terms.length){
        for(m;m<=n;m++){
            word="";
            for(k=0;k<numbers.length;k++){
                if(m%numbers[k]==0){
                    word+=terms[k];
                }
            }
            if(word==""){
                console.log(m);
            }
            else{
                console.log(word);
            }
        }
    }
    else {console.log("Punk");}
}