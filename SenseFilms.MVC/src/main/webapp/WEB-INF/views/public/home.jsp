<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/core.css" />" rel="stylesheet">
	<script src="<c:url value="/resources/bootstrap/css/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="card">
		<form name="loginForm" action="<c:url value="/AccountController/authenticate" />" method="post" class="align-middle">
  				 <!--Header-->
			<div>
            	<h3>Login:</h3>
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
            	<button type="submit">Login</button>
            </div>
            
                            <!--Footer-->
            <div class="modal-footer">
            	<div>
                    <p>Forgot <a href="<c:url value="/AccountController/forgotPassword" />">Password?</a></p>
                </div>
            </div>                                                                         
		</form>           
	</div>
</body>

</html>
