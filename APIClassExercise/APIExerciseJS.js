function chuckGenerate(){

fetch('https://api.chucknorris.io/jokes/random?exclude[explicit]')
.then(response =>response.json())
.then(result=>{
    let chuckList=document.getElementById("ChuckList");
   let joketest=result.value;
    var jokeElement = document.createElement("li");
   var JokeText = document.createTextNode((joketest));       
   jokeElement.appendChild(JokeText);                                
   chuckList.appendChild(jokeElement);
   var br = document.createElement("br");
   chuckList.appendChild(br);

    });
}