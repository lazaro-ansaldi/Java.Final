<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New User</title>
<link href="<c:url value="/resources/css/core.css" />" rel="stylesheet">
<!-- Loading Bootstrap -->
<link href="<c:url value="/resources/bootstrap/css/bootstrap.css" />"
	rel="stylesheet">
<!-- Loading Font Awesome Icons -->
<link href="<c:url value="/resources/css/font-awesome.min.css" />"
	rel="stylesheet">
<!-- Loading Drunken Parrot UI -->
<link href="<c:url value="/resources/css/drunken-parrot.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/demo.css" />" rel="stylesheet">
</head>
<body>


	<div class="form-center-container">
		<div class="form-center">
			<form name="createUserForm" action="<c:url value="/AccountController/addUser" />"
				method="post" class="align-middle">
				<div>
					<h3>Create new user</h3>
				</div>

				<div>
					<input type="text" id="username" class="form-control" name="username"> 
					<label for="username">Username</label>
				</div>
				
				<div>
					<input type="password" id="password" class="form-control" name="password"> 
					<label for="password">Password</label>
				</div>

				<div>
					<input type="text" id="name" class="form-control" name="name"> 
					<label for="name">First Name</label>
				</div>
				
				<div>
					<input type="text" id="lastName" class="form-control" name="lastName"> 
					<label for="lastName">Last Name</label>
				</div>
				
				<div>
					<input type="text" id="email" class="form-control" name="email"> 
					<label for="email">Mail</label>
				</div>
				
				<select id="userRole" name="userRole">
				  <option value="Administrator">Administrator</option>
				  <option value="User">User</option>
				</select>
				<label for="userRole">Role</label>

				<div>
					<span class="error-message">${errorMessage}</span>
				</div>

				<div class="text-center">
					<button type="submit" class="btn btn-primary">Create user</button>
				</div>

				<!--Footer-->
				<div class="modal-footer">
					<div>
						<a onclick="history.go(-1);">Go Back</a>
					</div>
				</div>
			</form>
		</div>
	</div>

	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script	src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/js/checkbox.js" />"></script>
	<script src="<c:url value="/resources/js/radio.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap-switch.js" />"></script>
	<script src="<c:url value="/resources/js/toolbar.js" />"></script>
	<script src="<c:url value="/resources/js/application.js" />"></script>

</body>
</html>