<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alan Airlines</title>
<link rel="stylesheet" href="resources/css/normalize.css"/>
<link rel="stylesheet" href="resources/css/theme.css"/>
</head>
<body>

	<div class="container">
		<div class="title">Add a passenger</div>
		<form action="AddPassenger" method="post">

			<fieldset>
				<legend>Passenger details</legend>

				<div class="inputfield">
					<label for="first-name">First name:</label> 
					<input name="first-name" type="text"></input>
				</div>
				<div class="inputfield">
					<label for="last-name">Last name:</label> 
					<input name="last-name" type="text"></input>
				</div>
				<div class="inputfield">
					<label for="dob">Date of birth:</label> 
					<input name="dob" type="date"></input>
				</div>
				<div class="inputfield">
					<label for="gender" class="inputLabel">Gender:</label> 
					<select name="gender">
						<option value="Male">Male</option>
						<option value="Female">Female</option>
					</select>
				</div>
			</fieldset>

			<div class="inputField" id="submitField">
				<input id="submitBtn" type="submit" value="Add new passenger"></input>
			</div>
		</form>


	</div>
</body>
</html>