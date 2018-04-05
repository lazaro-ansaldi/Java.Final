<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Password</title>
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
			<form name="recoverPasswordForm"
				action="<c:url value="/AccountController/updateNewPassword/${usernameParam}" />"
				method="post" class="align-middle">
				<div>
					<h3>Change password</h3>
				</div>

				<div>
					<input type="password" id="currentPassword" class="form-control" name="currentPassword"> 
					<label for="currentPassword">Current password</label>
				</div>

				<div>
					<input type="password" id="newPassword" class="form-control" name="newPassword"> 
					<label for="newPassword">New password</label>
				</div>

				<div>
					<input type="password" id="confirmPassword" class="form-control"
						name="confirmPassword"> <label for="confirmPassword">Current
						password</label>
				</div>

				<div>
					<span class="error-message">${errorMessage}</span>
				</div>

				<div class="text-center">
					<button type="submit" class="btn btn-primary">Update password</button>
				</div>

				<!--Footer-->
				<div class="modal-footer">
					<div>
						<a href="<c:url value="/" />">Go Back</a>
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