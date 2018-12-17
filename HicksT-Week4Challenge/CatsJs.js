
let state = {
    facts: ''
};
const apiUrl = 'https://cors-anywhere.herokuapp.com/https://cat-fact.herokuapp.com/facts/random?animal=cat&amount=1';
let getFact = function() {
    let output = "";
    fetch(apiUrl, {method: "GET", headers:{"Accept":"application/json"}})
    .then((response) => {
        return response.json();
    })
    .then((data) => {
        console.log(data);
        state.facts = data.text;
        updateContent();
        for(i=0; i<state.length;i++){
            output = (state.facts);
        }
        document.getElementById("facts-button").innetHtml = output;
    })
   
}

let updateContent = function() {
    console.log(state);
    const factsElement = document.getElementById('facts-field');
    factsElement.innerText = state.facts;
}

document.getElementById('facts-button').addEventListener('click',getFact);
