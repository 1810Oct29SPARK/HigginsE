/*window.onload = function() {
    let div1= document.getElementById("div1");
    let p1 = document.createElement("p");
    let node = document.createTextNode("this is new");
    p1.appendChild(node);
    div1.appendChild(p1);
    document.getElementById("diveWithText").addEventListener("mousemove", function(event){
         console.log(event.timeStamp)
         document.getElementById("mouseX").innerText = event.clientX;
         document.getElementById("mouseY").innerText = event.clientY;
     })
     $("input.cloudinary-fileupload[type=file]").cloudinary_fileupload();

}*/

function shiba() {
    let numDoge = document.getElementById("num").value;
    console.log(numDoge);
    const proxyurl = "https://cors-anywhere.herokuapp.com/";
    const url = "http://shibe.online/api/shibes?count="+numDoge+"&urls=true&httpsUrls=false"; // site that doesn’t send Access-Control-*
    fetch(proxyurl + url) // https://cors-anywhere.herokuapp.com/https://example.com
    .then(response => response.text())
    .then(contents => {
        console.log(contents);
        let dogePic = JSON.parse(contents);
        console.log(dogePic[1]);
        var data = {
            // "images": [{ //only does up to 5 images
            //   "bannerImg1": dogePic[0]
            // },
            // {"bannerImg1" : dogePic[1]
            // },
            // {"bannerImg1" : dogePic[2]
            // },
            // {"bannerImg1" : dogePic[3]
            // },
            // {"bannerImg1" : dogePic[4]
            // }]
            
            //want to get dynamic array for multiple pictures, not just 5.
            "images": [{
                "bannerImg1": dogePic[0]
            }]
            
          };
          for (i=0; i<dogePic.length; i++) {
              data.images.push({"bannerImg1":dogePic[i]})
          }
          console.log(data.images);
          data.images.forEach( function(obj) {
            var img = new Image();
            img.src = obj.bannerImg1;
            img.setAttribute("class", "banner-img");
            img.setAttribute("alt", "effy");
            document.getElementById("img-container").appendChild(img);
          });
    })
    .catch(() => console.log("Can’t access " + url + " response. Blocked by browser?"))

    /*
    let weatherApiUrl = 'https://api.openaq.org/v1/locations&coordinates=40.23,34.17';
    fetch(weatherApiUrl).then((response) => {return response.json();
    }).then((data) => {
        tampaWeather = data;
        console.log(data);
        console.log('the temperature is: '+tampaWeather.location+' degrees');
        //document.getElementById('tempInfo').innerHTML = 'The weather in Tampa, Florida is: '+tampaWeather.main.temp+' degrees Fahrenheit';
    });*/
}

let bearJSON = '{"bears":[{"id":4,"name":"Aretha","cave":{"id":56,"name":"Valhalla"}},' +
'{"id":7,"name":"Gandalf","cave":{"id":34,"name":"Isengard"}}]}';
let bearObj = JSON.parse(bearJSON);

function showBears() {
    var bearDiv = document.getElementById("div1");
    let bears = bearObj.bears;
    for (let i=0; i<bears.length; i++) {
        let b = bears[i];
        let newParagraph = document.createElement("p");
        newParagraph.innerText = "name: "+b.name+" cave: "+b.cave.name;
        bearDiv.appendChild(newParagraph);
        console.log(b);
    }
}