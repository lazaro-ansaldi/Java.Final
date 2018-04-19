<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New User</title>
</head>
<body>
<jsp:include page="../controls/header.jsp" />

	<div class="form-center-container">
		<div class="form-center">
			<form name="createUserForm" action="<c:url value="/ManageUsersController/addUser" />"
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

</body>
</html>