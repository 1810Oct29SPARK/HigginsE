
let catFacts = {};
const url = 'https://cat-fact.herokuapp.com/facts'

function getCatFacts() {
    fetch(url, {
        //trying to get past Cross-Origin Request Blocked ):
        headers: {
          'Access-Control-Allow-Origin':'*'
        }
      })
        response.json().then((jsonResponse) => {
          console.log(jsonResponse)
        })
        response.json().then(i => i.forEach(i => console.log(i.text)))
      }

document.getElementById('catfact-button').addEventListener('click',getCatFacts);
