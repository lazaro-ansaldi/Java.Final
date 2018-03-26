<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
	<script src="<c:url value="/resources/bootstrap/css/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="card" style="width: 28rem;">
		<form name="loginForm" action="login" method="post" class="align-middle">
  				 <!--Header-->
			<div class="form-header default-color">
            	<h3><i class="fa fa-lock"></i> Login:</h3>
            </div>
            
                        <!--Body-->
            <div class="md-form">
            	<i class="fa fa-envelope prefix grey-text"></i>
                <input type="text" id="defaultForm-email" class="form-control" name="username">
                <label for="defaultForm-email">Your username</label>
            </div>
            
            <div class="md-form">
            	<i class="fa fa-lock prefix grey-text"></i>
                <input type="password" id="defaultForm-pass" class="form-control" name="password">
                <label for="defaultForm-pass">Your password</label>
            </div>
            
            <div>
            	<span class="text-error">${errorMessage}</span>
            </div>                                 
                                      
            <div class="text-center">
            	<button type="submit" class="btn btn-default waves-effect waves-light">Login</button>
            </div>
            
                            <!--Footer-->
            <div class="modal-footer">
            	<div class="options">
                	<p class="pool-right">Not a member? <a href="#">Sign Up</a></p>
                    <p class="pool-right">Forgot <a href="#">Password?</a></p>
                </div>
            </div>                                                                         
		</form>           
	</div>
</body>

</html>
