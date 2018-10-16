<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<link href="<c:url value="/resources/css/core.css" />" rel="stylesheet" type="text/css">

	<link href="<c:url value="/resources/bootstrap/css/bootstrap.css" />" rel="stylesheet" type="text/css">

	<link href="<c:url value="/resources/css/font-awesome.min.css" />" rel="stylesheet" type="text/css">

	<link href="<c:url value="/resources/css/drunken-parrot.css" />" rel="stylesheet" type="text/css">
	<link href="<c:url value="/resources/css/demo.css" />" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="form-center-container">
		<div class="form-center">
			<form name="loginForm" action="<c:url value="/login" />" method="post" class="form-center">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<div>
	            	<h3>Sign In</h3>
	            </div>	            
	                        <!--Body-->
	            <div>
	                <input type="text" id="email" class="form-control" name="username">
	                <label for="email">Your username</label>
	            </div>
	            
	            <div>
	                <input type="password" id="password" class="form-control" name="password">
	                <label for="pass">Your password</label>
	            </div>
	            
	            <div>
	            	<span class="error-message">${errorMessage}</span>
	            </div>                                 
	                                      
	            <div class="text-center">
	            	<button type="submit" class="btn btn-primary btn-kr">Login</button>
	            </div>
	            
	                            <!--Footer-->
	            <div class="modal-footer">
	            	<div>
	                    <p>Forgot <a href="<c:url value="/AccountController/forgotPassword" />">Password?</a></p>
	                </div>
	            </div>                                                                         
			</form> 
		</div>         
	</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/js/checkbox.js" />"></script>
	<script src="<c:url value="/resources/js/radio.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap-switch.js" />"></script>
	<script src="<c:url value="/resources/js/toolbar.js" />"></script>
	<script src="<c:url value="/resources/js/application.js" />"></script>
	
</body>

</html>
