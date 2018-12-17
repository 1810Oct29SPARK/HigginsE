function createNode(element) {
    return document.createElement(element);
}

function append(parent, elemt) {
  return parent.appendChild(elemt);
}

const ul = document.getElementById('authors');
const url = 'https://randomuser.me/api/?results=15';

fetch(url)
.then((resp) => resp.json())
.then(function(data) {
  console.log(data);
  
  let authors = data.results;

  return authors.map(function(author) {
    let li = createNode('li'),
        img = createNode('img'),
        span = createNode('span');

    img.src = author.picture.medium;
    var myJSON = JSON.stringify(author.name.last, author.name.first);
    document.getElementById("span").innerHTML = (myJSON);

    append(li, img);
    append(li, span);
    append(ul, li);
  })

})
.catch(function(error) {
  console.log(error);
});   