/**
 * This is to get the button to work
 * ...
 * If that is even possible
 * 
 * Turns out that the button DOES work!  The button was not the problem at all.
 * It's the redirect.
 */
let user = {}

//function EmployeeRedirect(){
//	window.location = "localhost:8080/ProjectOne/Employee.html";
//}



function employeeLogin(){
	fetch("localhost:8080/ProjectOne/login")
	.then((response) => {
		return response.json();
	})
	.then((data) => {
		console.log(data);
	})
}
