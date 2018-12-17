/*window.onload = function() {
    let div1 = document.getElementById("div1");
    let p1 = document.createElement("p");
    let node = document.createTextNode("this is something");
    p1.appendChild(node);
    div1.appendChild(p1);
    document.getElementById("TextDiv").addEventListener("mousemove", function(event){
        console.log(event.timeStamp);
        document.getElementById("mouseX")
    })
}
*/

let dogJSON = "https://dog.ceo/api/breeds/image/random";
let dogObj = JSON.parse(dogJSON);

window.onload = function nextDog(){
    var dogDiv = document.getElementById("div1");
    let doggie = dogObj.doggie;

}