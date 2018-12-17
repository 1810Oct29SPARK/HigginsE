let getCountries = "http://api.geonames.org/postalCodeSearch?48095";
var arrestInfo = {};
function getAllCountries() {
    fetch(getCountries).then((response) => {return response.json();
    }).then((data) => {
        arrestInfo = data;
        console.log(arrestInfo);
    })
    var orderedl = document.createElement(ol);
    for(let i = 0; i < arrestInfo.length;i++){
        let list = document.createElement(li);
        list.innerHTML = arrestInfo[i];
        orderedl.appendChild(list);
    }
    document.body.appendChild(orderedl);
}

let weatherApiUrl = 'http://api.openweathermap.org/data/2.5/weather?q=Tampa,us&units=imperial&APPID=859d47520ac736ebe8bbce1fef74269c';
function listTampaWeather() {
    fetch(weatherApiUrl).then((response) => {return response.json();
    }).then((data) => {
        console.log(data);
        var unorderedList = document.createElement("ol");
        for (var key in data) {
            if (data.hasOwnProperty(key)) {
              var val = data[key];
                var listItem = document.createElement("li");
                listItem.innerHTML = val;
                unorderedList.appendChild(listItem);
              console.log(val);
            }
        document.body.appendChild(unorderedList);
    }
})
}

window.onload = listTampaWeather();