function createNode(element) {
    return document.createElement(element);
}

function append(parent, el) {
    return parent.appendChild(el);
}

window.onload = function() {
document.getElementById("button").addEventListener("click", function() {

    fetch("https://random.dog/woof.json")
        .then(function(response) {
            response.json().then(function(data) {
            //console.log(data)
            let html = "";
            let doggo = data.results;
            let results = document.getElementById("results")
            let img = createNode('div')
            let child = append(img, )
            html += 

            results.innerHTML = html;
        })
    })
})
}