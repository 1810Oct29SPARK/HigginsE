

 let openTrivia = {};

 //send a GET request to this endppint to get Tampa weather
 let weatherApiURL = 'https://opentdb.com/api.php?amount=5';

 function getTriviaQuestions() {
     fetch(triviaApiURL).then((response) => {return response.json();
    }).then((data) => {
        openTrivia = data;
        updateTrivia1();
        updateTrivia2();
        updateTrivia3();
        updateTrivia4();
        updateTrivia5();
    });
 }
    function updateTrivia1() {
        let newPara = document.createElement("p")
        newPara.innerText = category;
        newPara.innerText = type;
        newPara.innerText = difficulty;
        newCheckBox.innerText = incorrect_answers;
        newCheckBox.innerText = correct_answers;
        //add new p element as a child of weatherDiv
        document.getElementById("questionOne").appendChild(newPara);
        if incorrect_answers = true {
            alert("WRONG");
            else
            alert("CORRECT")
        }
}
function updateTrivia2() {
    let newPara = document.createElement("p")
    newPara.innerText = category;
    newPara.innerText = type;
    newPara.innerText = difficulty;
    newRadioButton.innerText = incorrect_answers;
    newRadioButton.innerText = correct_answers;
    //add new p element as a child of weatherDiv
    document.getElementById("questionOne").appendChild(newPara);
    if incorrect_answers = true {
        alert("WRONG");
        else
        alert("CORRECT")
    }
}
function updateTrivia3() {
    let newPara = document.createElement("p")
    newPara.innerText = category;
    newPara.innerText = type;
    newPara.innerText = difficulty;
    newRadioButton.innerText = incorrect_answers;
    newRadioButton.innerText = correct_answers;
    //add new p element as a child of weatherDiv
    document.getElementById("questionOne").appendChild(newPara);
    if incorrect_answers = true {
        alert("WRONG");
        else
        alert("CORRECT")
    }
}
function updateTrivia4() {
    let newPara = document.createElement("p")
    newPara.innerText = category;
    newPara.innerText = type;
    newPara.innerText = difficulty;
    newRadioButton.innerText = incorrect_answers;
    newRadioButton.innerText = correct_answers;
    //add new p element as a child of weatherDiv
    document.getElementById("questionOne").appendChild(newPara);
    if incorrect_answers = true {
        alert("WRONG");
        else
        alert("CORRECT")
    }
}
function updateTrivia5() {
    let newPara = document.createElement("p")
    newPara.innerText = category;
    newPara.innerText = type;
    newPara.innerText = difficulty;
    newRadioButton.innerText = incorrect_answers;
    newRadioButton.innerText = correct_answers;
    //add new p element as a child of weatherDiv
    document.getElementById("questionOne").appendChild(newPara);
    if incorrect_answers = true {
        alert("WRONG");
        else
        alert("CORRECT")
    }
}

window.onload=function(){
    getTriviaQuestions();


}

