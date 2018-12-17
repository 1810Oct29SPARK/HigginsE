let beerApiUrl = "https://api.openbrewerydb.org/breweries?by_name=cooper";
let container = document.getElementById("container");

function getBreweries() {
    fetch (beerApiUrl, {method: "GET", headers: {"Accept":"application/json"}})
    .then((response) => {
        return response.json();
    })
    .then((brews) => {
        for (i = 0; i < brews.length; i++) {
            console.log (brews[i].name, brews[i].country, brews[i].state, brews[i].postal_code, brews[i].phone);
            var newDiv = document.createElement("div"); 
            var brewName = document.createTextNode("Name: " + brews[i].name);
            var brewState = document.createTextNode("State: " + brews[i].state);
            var brewPost = document.createTextNode("Postal Code: " + brews[i].postal_code);
            var brewCountry = document.createTextNode("Country: " + brews[i].country);
            var brewPhone = document.createTextNode("Phone: " + brews[i].phone);
            newDiv.appendChild(brewName);
            newDiv.appendChild(brewState);
            newDiv.appendChild(brewPost);
            newDiv.appendChild(brewCountry);
            newDiv.appendChild(brewPhone);
            container.appendChild(newDiv);
        }
    });
};

 