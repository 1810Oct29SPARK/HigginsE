<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home (JSP Version)</title>
</head>
<body>
	<h1>Imperial Martial Arts Home Page</h1>
	<form id="employee">
		<h3>Employee Login</h3>
		<fieldset action="Login" method="POST">
			<legend>username:</legend>
			<input required type="text" name="employeeUsername" />
		</fieldset>
		<fieldset action="Login" method="post">
			<legend>password:</legend>
			<input required type="password" name="employeePassword" />
		</fieldset>
		<br> <input type="submit" value="Log in">
	</form>
	<form id="manager">
		<h3>Manager Login</h3>
		<fieldset action="Login" method="POST">
			<legend>username:</legend>
			<input required name="managerUsername" />
		</fieldset>
		<fieldset action="Login" method="post">
			<legend>password:</legend>
			<input required type="password" name="managerPassword" />
		</fieldset>
		<br> <input type="submit" value="Log in">
	</form>
</body>
</html>