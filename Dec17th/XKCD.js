function random(){
    let result = Math.ceil(Math.random()*2085);
    return result;
}
function getComic(){
    const proxyurl = "https://cors-anywhere.herokuapp.com/";
    const endpointFirst = "http://xkcd.com/";
    const endpointLast = "/info.0.json";
    fetch(proxyurl+endpointFirst+random()+endpointLast, {method:"GET"})
    .then(function(response){return response.json()})
    .then(function(stuff){
        let title = document.getElementById('title');
        let comic = document.getElementById('comic');
        title.innerHTML = stuff.title;
        comic.setAttribute("src",stuff.img);
        comic.setAttribute("title",stuff.alt);
    })
    //extra stuff I could do,
    //I could have it so the page gets continually loaded with new comics until you press another button to get rid of them
    //I could style it more.
}