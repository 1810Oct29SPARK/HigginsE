const api_endpoint = "https://picsum.photos/list";

const button_class = "col-3 btn btn-info btn-picsum";

const fetch_option = {
	method: "GET",
	headers: {Accept: "application/json"}
};

const shuffle = function(array) {
	for (let i = array.length - 1; i > 0; i--) {
		const j = Math.floor(Math.random() * (i + 1));
		[array[i], array[j]] = [array[j], array[i]];
	}
	return array;
}

const url_wrapper = function(width, height, id) {
	return "https://picsum.photos/" + width + "/" + height + "?image=" + id;
}

const show_iamge = function(container, width, height, id) {
	var image = document.createElement("IMG");
	image.setAttribute("src", url_wrapper(width, height, id));
	container.appendChild(image);
}

document.getElementById("magic-form").addEventListener("submit", function(e) {
	var chosen_number = parseInt(document.getElementById("number").value);
	var chosen_width = parseInt(document.getElementById("width").value);
	var chosen_height = parseInt(document.getElementById("height").value);
	var container = document.getElementById("pic-container");
	var show_container = document.getElementById("pic-show");
	while(container.firstChild) {
		container.removeChild(container.firstChild);
	}
	while(show_container.firstChild) {
		show_container.removeChild(show_container.firstChild);
	}
	e.preventDefault();
	fetch(api_endpoint, fetch_option)
	.then(function(response) {
		return response.json();
	})
	.then(function(data) {
		var random_data = shuffle(data);
		random_data = random_data.slice(0, chosen_number);
		for (i = 0; i < random_data.length; ++i) {
			image_data = random_data[i];
			var newBtn = document.createElement("BUTTON");
			var space = document.createElement("DIV");
			space.setAttribute("class", "col-1");
			newBtn.setAttribute("class", button_class);
			newBtn.setAttribute("data-id", image_data["id"]);
			newBtn.innerHTML = image_data["id"] + " author: " + image_data["author"];
			newBtn.addEventListener("click", function() {
				var id = this.getAttribute("data-id")
				show_iamge(show_container, chosen_width, chosen_height, id);
			})
			container.appendChild(newBtn);
			container.appendChild(space);
		}
	})
	.catch(function(error) {
		console.log(error);
	})
})