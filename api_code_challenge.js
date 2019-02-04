let beerApiUrl = "https://api.openbrewerydb.org/breweries?by_name=cooper";
var output = "";

function getBreweries() {
    fetch (beerApiUrl, {method: "GET", headers: {"Accept":"application/json"}})
    .then((response) => {
        return response.json();
    })
    .then((brews) => {
        for (i = 0; i < brews.length; i++) {
            console.log (brews[i].name, brews[i].country, brews[i].state, brews[i].postal_code, brews[i].phone);
            let name = brews[i].name;
            let country = brews[i].country;
            let state = brews[i].state;
            let postal_code = brews[i].postal_code;
            let phone = brews[i].phone;
            output += `
                <div>
                    <p> 
                        Name: ${name} <br>
                        State: ${state} <br>
                        Postal Code ${postal_code} <br>
                        Country: ${country} <br>
                        Phone: ${phone} <br>
                    </p>        
                </div> 
            `;
            
            container.innerHTML = output;
        }
    });
};


